package com.ahyc.eai.service.financial.customer;

import com.ahyc.eai.core.financial.FFinancialTenderModel;
import com.ahyc.eai.core.financial.IFinancialConsole;
import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialPhaseUnit;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理。</T>
//============================================================
public class FStatisticsCustomerServlet
      extends FAbstractStatisticsServlet
      implements
         IStatisticsCustomerServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsCustomerServlet.class);

   // 金融控制台
   @ALink
   protected IFinancialConsole _financialConsole;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult dynamic(IWebContext context,
                          ILogicContext logicContext,
                          IWebServletRequest request,
                          IWebServletResponse response){
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      // 检查参数
      String beginSource = context.parameter("begin");
      String endSource = context.parameter("end");
      if(RString.isEmpty(beginSource) || RString.isEmpty(endSource)){
         throw new FFatalError("Parameter is invalid.");
      }
      if((beginSource.length() != 14) || (endSource.length() != 14)){
         throw new FFatalError("Parameter length is invalid.");
      }
      // 限制查询范围最大10分钟
      TDateTime beginDate = new TDateTime(beginSource);
      TDateTime endDate = new TDateTime(endSource);
      long span = endDate.get() - beginDate.get();
      if((span < 0) && (span > 1000 * 600)){
         throw new FFatalError("Parameter span is invalid.");
      }
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "dynamic|" + beginSource + "-" + endSource;
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      TDateTime currentDate = RDateTime.currentDateTime();
      // 设置输出流
      FByteStream stream = createStream(context);
      ISqlConnection connection = logicContext.activeConnection("statistics");
      // 输出当日合计数据
      FSql statisticsSql = new FSql();
      statisticsSql.append("SELECT");
      statisticsSql.append(" SUM(INVESTMENT) INVESTMENT_COUNT");
      statisticsSql.append(",MAX(INVESTMENT_TOTAL) INVESTMENT_TOTAL");
      statisticsSql.append(",SUM(CUSTOMER_COUNT) CUSTOMER_COUNT");
      statisticsSql.append(",MAX(CUSTOMER_TOTAL) CUSTOMER_TOTAL");
      statisticsSql.append(" FROM ST_FIN_PHASE WHERE RECORD_DAY = STR_TO_DATE('" + endDate.format("YYYYMMDD") + "','%Y%m%d')");
      FRow statisticsRow = connection.find(statisticsSql);
      stream.writeDouble(statisticsRow.getDouble("investment_count"));
      stream.writeDouble(statisticsRow.getDouble("investment_total"));
      stream.writeInt32(statisticsRow.getInt("customer_count"));
      stream.writeInt32(statisticsRow.getInt("customer_total"));
      //............................................................
      // 输出排行数据
      FSql fetchSql = new FSql();
      fetchSql.append("SELECT * FROM (");
      fetchSql.append("SELECT CUSTOMER_ID,CUSTOMER_LABEL,CUSTOMER_CARD,CUSTOMER_PHONE");
      fetchSql.append(",SUM(INVESTMENT) INVESTMENT_TOTAL");
      fetchSql.append(" FROM ST_FIN_CUSTOMER_PHASE WHERE RECORD_DAY = STR_TO_DATE('" + endDate.format("YYYYMMDD") + "','%Y%m%d')");
      fetchSql.append("GROUP BY CUSTOMER_ID");
      fetchSql.append(") t ORDER BY INVESTMENT_TOTAL DESC LIMIT 3");
      FDataset rankDataset = connection.fetchDataset(fetchSql);
      int rankCount = rankDataset.count();
      stream.writeInt32(rankCount);
      for(FRow row : rankDataset){
         stream.writeString(RString.left(row.get("customer_label"), 1));
         stream.writeString(RString.left(row.get("customer_card"), 4));
         stream.writeString(RString.right(row.get("customer_phone"), 4));
         stream.writeDouble(row.getDouble("investment_total"));
      }
      //............................................................
      // 输出即时数据
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      String whereSql = "CUSTOMER_ACTION_CD=1 AND CUSTOMER_ACTION_DATE >= STR_TO_DATE('{1}','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE < STR_TO_DATE('{2}','%Y%m%d%H%i%s')";
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch(RString.format(whereSql, beginDate.format(), endDate.format()), "CUSTOMER_ACTION_DATE");
      int count = dynamicDataset.count();
      stream.writeInt32(count);
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         double investmentAmount = dynamicUnit.customerActionAmount();
         // 计算盈利
         String tenderModelLabel = null;
         double investmentGain = 0;
         FFinancialTenderModel tenderModel = _financialConsole.findTenderModel(dynamicUnit.tenderModel());
         if(tenderModel != null){
            tenderModelLabel = tenderModel.label();
            investmentGain = tenderModel.calculateGain(investmentAmount, currentDate);
         }
         // 输出内容
         stream.writeString(dynamicUnit.customerActionDate().format());
         stream.writeString(RString.left(dynamicUnit.customerLabel(), 1));
         stream.writeString(RString.left(dynamicUnit.customerCard(), 4));
         stream.writeString(RString.right(dynamicUnit.customerPhone(), 4));
         stream.writeString(tenderModelLabel);
         stream.writeDouble(investmentAmount);
         stream.writeDouble(investmentGain);
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics marketer dynamic. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }

   //============================================================
   // <T>上传处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult trend(IWebContext context,
                        ILogicContext logicContext,
                        IWebServletRequest request,
                        IWebServletResponse response){
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      // 检查参数
      String beginSource = context.parameter("begin");
      String endSource = context.parameter("end");
      if(RString.isEmpty(beginSource) || RString.isEmpty(endSource)){
         throw new FFatalError("Parameter is invalid.");
      }
      // 限制查询范围最大10分钟
      TDateTime beginDate = new TDateTime(beginSource);
      TDateTime endDate = new TDateTime(endSource);
      long dateSpan = endDate.get() - beginDate.get();
      if((dateSpan < 0) && (dateSpan > 1000 * 3600 * 24 * 7)){
         throw new FFatalError("Parameter span is invalid.");
      }
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "trend|" + beginSource + "-" + endSource;
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      // 输出总计数据
      FStatisticsFinancialPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialPhaseLogic.class);
      String phaseWhereSql = "RECORD_DATE > STR_TO_DATE('{1}','%Y%m%d%H%i%s') AND RECORD_DATE <= STR_TO_DATE('{2}','%Y%m%d%H%i%s')";
      FLogicDataset<FStatisticsFinancialPhaseUnit> phaseDataset = phaseLogic.fetch(RString.format(phaseWhereSql, beginDate.format(), endDate.format()), "RECORD_DATE ASC");
      // 计算阶段统计
      double investmentTotal = 0;
      int customerTotal = 0;
      for(FStatisticsFinancialPhaseUnit phaseUnit : phaseDataset){
         investmentTotal += phaseUnit.investment();
         customerTotal += phaseUnit.customerCount();
      }
      stream.writeDouble(investmentTotal);
      stream.writeUint32(customerTotal);
      // 输出数据集合
      int count = phaseDataset.count();
      stream.writeInt32(count);
      for(FStatisticsFinancialPhaseUnit phaseUnit : phaseDataset){
         stream.writeString(phaseUnit.recordDate().format());
         stream.writeDouble(phaseUnit.investment());
         stream.writeUint32(phaseUnit.customerCount());
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics marketer trend. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
