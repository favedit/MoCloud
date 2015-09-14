package com.ahyc.eai.service.financial.marketer;

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
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理。</T>
//============================================================
public class FStatisticsMarketerServlet
      extends FAbstractStatisticsServlet
      implements
         IStatisticsMarketerServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsMarketerServlet.class);

   // 日志输出接口
   private static IResource _resource = RResource.find(FStatisticsMarketerServlet.class);

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
      // 设置输出流
      FByteStream stream = createStream(context);
      ISqlConnection connection = logicContext.activeConnection("statistics");
      // 输出当日合计数据
      FSql statisticsSql = _resource.findString(FSql.class, "sql.dynamic.sum");
      statisticsSql.bindDateTime("date", endDate, "YYYYMMDD");
      FRow statisticsRow = connection.find(statisticsSql);
      stream.writeDouble(statisticsRow.getDouble("investment_count"));
      stream.writeDouble(statisticsRow.getDouble("investment_total"));
      stream.writeInt32(statisticsRow.getInt("customer_count"));
      stream.writeInt32(statisticsRow.getInt("customer_total"));
      //............................................................
      // 输出日排行数据
      FSql rankDaySql = _resource.findString(FSql.class, "sql.dynamic.rank.day");
      rankDaySql.bindDateTime("date", endDate, "YYYYMMDD");
      FDataset rankDayDataset = connection.fetchDataset(rankDaySql);
      stream.writeInt32(rankDayDataset.count());
      for(FRow row : rankDayDataset){
         stream.writeString(row.get("department_label"));
         stream.writeString(row.get("marketer_label"));
         stream.writeDouble(row.getDouble("investment_total"));
         stream.writeInt32(row.getInt("customer_count"));
         stream.writeInt32(row.getInt("customer_total"));
      }
      //............................................................
      // 输出周排行数据
      FSql rankWeekSql = _resource.findString(FSql.class, "sql.dynamic.rank.week");
      rankWeekSql.bindDateTime("date", endDate, "YYYYMMWK");
      FDataset rankWeekDataset = connection.fetchDataset(rankWeekSql);
      stream.writeInt32(rankWeekDataset.count());
      for(FRow row : rankWeekDataset){
         stream.writeString(row.get("department_label"));
         stream.writeString(row.get("marketer_label"));
         stream.writeDouble(row.getDouble("investment_total"));
         stream.writeInt32(row.getInt("customer_count"));
         stream.writeInt32(row.getInt("customer_total"));
      }
      //............................................................
      // 输出月排行数据
      FSql rankMonthSql = _resource.findString(FSql.class, "sql.dynamic.rank.month");
      rankMonthSql.bindDateTime("date", endDate, "YYYYMM01");
      FDataset rankMonthDataset = connection.fetchDataset(rankMonthSql);
      stream.writeInt32(rankMonthDataset.count());
      for(FRow row : rankMonthDataset){
         stream.writeString(row.get("department_label"));
         stream.writeString(row.get("marketer_label"));
         stream.writeDouble(row.getDouble("investment_total"));
         stream.writeInt32(row.getInt("customer_count"));
         stream.writeInt32(row.getInt("customer_total"));
      }
      //............................................................
      // 输出即时数据
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      FSql whereSql = new FSql("CUSTOMER_ACTION_DATE >= STR_TO_DATE({begin_date},'%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE < STR_TO_DATE({end_date},'%Y%m%d%H%i%s')");
      whereSql.bindDateTime("begin_date", beginDate);
      whereSql.bindDateTime("end_date", endDate);
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch(whereSql, "CUSTOMER_ACTION_DATE");
      int count = dynamicDataset.count();
      stream.writeInt32(count);
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         stream.writeString(dynamicUnit.customerActionDate().format());
         stream.writeString(dynamicUnit.departmentLabel());
         stream.writeString(dynamicUnit.marketerLabel());
         stream.writeString(RString.left(dynamicUnit.customerLabel(), 1));
         stream.writeString(RString.left(dynamicUnit.customerCard(), 4));
         stream.writeString(RString.right(dynamicUnit.customerPhone(), 4));
         stream.writeUint8((byte)dynamicUnit.customerActionCd());
         stream.writeDouble(dynamicUnit.customerActionAmount());
         stream.writeDouble(dynamicUnit.customerActionInterest());
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send marketer marketer dynamic. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
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
      if((dateSpan < 0) || (dateSpan > 1000 * 3600 * 24 * 7)){
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
      FSql whereSql = new FSql("RECORD_DATE > STR_TO_DATE({begin_date},'%Y%m%d%H%i%s') AND RECORD_DATE <= STR_TO_DATE({end_date},'%Y%m%d%H%i%s')");
      whereSql.bindDateTime("begin_date", beginDate);
      whereSql.bindDateTime("end_date", endDate);
      FLogicDataset<FStatisticsFinancialPhaseUnit> phaseDataset = phaseLogic.fetch(whereSql, "RECORD_DATE ASC");
      // 计算阶段统计
      double investmentTotal = 0;
      for(FStatisticsFinancialPhaseUnit phaseUnit : phaseDataset){
         investmentTotal += phaseUnit.investment();
      }
      stream.writeDouble(investmentTotal);
      // 输出数据集合
      int count = phaseDataset.count();
      stream.writeInt32(count);
      for(FStatisticsFinancialPhaseUnit phaseUnit : phaseDataset){
         stream.writeString(phaseUnit.recordDate().format());
         stream.writeDouble(phaseUnit.investment());
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send marketer marketer trend. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
