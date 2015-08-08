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
      // 设置输出流
      FByteStream stream = new FByteStream();
      ISqlConnection connection = logicContext.activeConnection("statistics");
      // 输出当日合计数据
      FSql statisticsSql = new FSql();
      statisticsSql.append("SELECT");
      statisticsSql.append(" SUM(INVESTMENT) INVESTMENT_COUNT");
      statisticsSql.append(",MAX(INVESTMENT_TOTAL) INVESTMENT_TOTAL");
      statisticsSql.append(",SUM(REDEMPTION) REDEMPTION_COUNT");
      statisticsSql.append(",MAX(REDEMPTION_TOTAL) REDEMPTION_TOTAL");
      statisticsSql.append(",SUM(NETINVESTMENT) NETINVESTMENT_COUNT");
      statisticsSql.append(",MAX(NETINVESTMENT_TOTAL) NETINVESTMENT_TOTAL");
      statisticsSql.append(",SUM(INTEREST) INTEREST_COUNT");
      statisticsSql.append(",MAX(INTEREST_TOTAL) INTEREST_TOTAL");
      statisticsSql.append(",SUM(PERFORMANCE) PERFORMANCE_COUNT");
      statisticsSql.append(",MAX(PERFORMANCE_TOTAL) PERFORMANCE_TOTAL");
      statisticsSql.append(",SUM(CUSTOMER_COUNT) CUSTOMER_COUNT");
      statisticsSql.append(",MAX(CUSTOMER_TOTAL) CUSTOMER_TOTAL");
      statisticsSql.append(" FROM ST_FIN_PHASE WHERE RECORD_DAY = STR_TO_DATE('" + endDate.format("YYYYMMDD") + "','%Y%m%d')");
      FRow statisticsRow = connection.find(statisticsSql);
      stream.writeDouble(statisticsRow.getDouble("investment_count"));
      stream.writeDouble(statisticsRow.getDouble("investment_total"));
      stream.writeDouble(statisticsRow.getDouble("redemption_count"));
      stream.writeDouble(statisticsRow.getDouble("redemption_total"));
      stream.writeDouble(statisticsRow.getDouble("netinvestment_count"));
      stream.writeDouble(statisticsRow.getDouble("netinvestment_total"));
      stream.writeDouble(statisticsRow.getDouble("interest_count"));
      stream.writeDouble(statisticsRow.getDouble("interest_total"));
      stream.writeDouble(statisticsRow.getDouble("performance_count"));
      stream.writeDouble(statisticsRow.getDouble("performance_total"));
      stream.writeInt32(statisticsRow.getInt("customer_count"));
      stream.writeInt32(statisticsRow.getInt("customer_total"));
      //............................................................
      // 输出排行数据
      FSql fetchSql = new FSql();
      fetchSql.append("SELECT * FROM (");
      fetchSql.append("SELECT DEPARTMENT_ID,DEPARTMENT_LABEL,MARKETER_ID,MARKETER_LABEL");
      fetchSql.append(",SUM(MARKETER_INVESTMENT) INVESTMENT_TOTAL");
      fetchSql.append(",SUM(MARKETER_REDEMPTION) REDEMPTION_TOTAL");
      fetchSql.append(",SUM(MARKETER_NETINVESTMENT) NETINVESTMENT_TOTAL");
      fetchSql.append(",SUM(MARKETER_INTEREST) INTEREST_TOTAL");
      fetchSql.append(",SUM(MARKETER_PERFORMANCE) PERFORMANCE_TOTAL");
      fetchSql.append(",SUM(CUSTOMER_REGISTER) CUSTOMER_REGISTER");
      fetchSql.append(",MAX(CUSTOMER_TOTAL) CUSTOMER_TOTAL");
      fetchSql.append(" FROM ST_FIN_MARKETER_PHASE WHERE RECORD_DAY = STR_TO_DATE('" + endDate.format("YYYYMMDD") + "','%Y%m%d')");
      fetchSql.append("GROUP BY MARKETER_ID");
      fetchSql.append(") t ORDER BY NETINVESTMENT_TOTAL DESC LIMIT 3");
      FDataset rankDataset = connection.fetchDataset(fetchSql);
      int rankCount = rankDataset.count();
      stream.writeInt32(rankCount);
      for(FRow row : rankDataset){
         stream.writeString(row.get("department_label"));
         stream.writeString(row.get("marketer_label"));
         stream.writeDouble(row.getDouble("investment_total"));
         stream.writeDouble(row.getDouble("redemption_total"));
         stream.writeDouble(row.getDouble("netinvestment_total"));
         stream.writeDouble(row.getDouble("interest_total"));
         stream.writeDouble(row.getDouble("performance_total"));
         stream.writeInt32(row.getInt("customer_register"));
         stream.writeInt32(row.getInt("customer_total"));
      }
      //............................................................
      // 输出即时数据
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      String whereSql = "CUSTOMER_ACTION_DATE >= STR_TO_DATE('{1}','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE < STR_TO_DATE('{2}','%Y%m%d%H%i%s')";
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch(RString.format(whereSql, beginDate.format(), endDate.format()), "CUSTOMER_ACTION_DATE");
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
      // 设置输出流
      FByteStream stream = new FByteStream();
      // 输出总计数据
      FStatisticsFinancialPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialPhaseLogic.class);
      String phaseWhereSql = "RECORD_DATE > STR_TO_DATE('{1}','%Y%m%d%H%i%s') AND RECORD_DATE <= STR_TO_DATE('{2}','%Y%m%d%H%i%s')";
      FLogicDataset<FStatisticsFinancialPhaseUnit> phaseDataset = phaseLogic.fetch(RString.format(phaseWhereSql, beginDate.format(), endDate.format()), "RECORD_DATE ASC");
      // 计算阶段统计
      double investmentTotal = 0;
      double redemptionTotal = 0;
      double netinvestmentTotal = 0;
      double interestTotal = 0;
      double performanceTotal = 0;
      for(FStatisticsFinancialPhaseUnit phaseUnit : phaseDataset){
         investmentTotal += phaseUnit.investment();
         redemptionTotal += phaseUnit.redemption();
         netinvestmentTotal += phaseUnit.netinvestment();
         interestTotal += phaseUnit.interest();
         performanceTotal += phaseUnit.performance();
      }
      stream.writeDouble(investmentTotal);
      stream.writeDouble(redemptionTotal);
      stream.writeDouble(netinvestmentTotal);
      stream.writeDouble(interestTotal);
      stream.writeDouble(performanceTotal);
      // 输出数据集合
      int count = phaseDataset.count();
      stream.writeInt32(count);
      for(FStatisticsFinancialPhaseUnit phaseUnit : phaseDataset){
         stream.writeString(phaseUnit.recordDate().format());
         stream.writeDouble(phaseUnit.investment());
         stream.writeDouble(phaseUnit.redemption());
         stream.writeDouble(phaseUnit.netinvestment());
         stream.writeDouble(phaseUnit.interest());
         stream.writeDouble(phaseUnit.performance());
      }
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics marketer trend. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      //............................................................
      // 发送数据
      return sendStream(context, request, response, stream);
   }
}
