package com.ahyc.eai.service.financial.achievement;

import com.ahyc.eai.core.financial.IFinancialConsole;
import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理。</T>
//============================================================
public class FStatisticsAchievementServlet
      extends FAbstractStatisticsServlet
      implements
         IStatisticsAchievementServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsAchievementServlet.class);

   // 资源访问接口
   private static IResource _resource = RResource.find(FStatisticsAchievementServlet.class);

   // 金融控制台
   @ALink
   protected IFinancialConsole _financialConsole;

   //============================================================
   // <T>获得统计动态数据。</T>
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
      if(!checkParameters(context, request, response)) {
         return EResult.Failure;
      }
      //............................................................
      // 获得当前时间
      TDateTime currentDate = RDateTime.currentDateTime();
      String dateString = currentDate.format("YYYYMMDDHH24MI00");
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "dynamic|" + dateString;
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null) {
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      ISqlConnection connection = logicContext.activeConnection("statistics");
      // 输出当日合计数据
      if(connection != null) {
         FSql sql = _resource.findString(FSql.class, "sql.achievement.day");
         sql.bindString("date", currentDate.format("YYYYMMDD"));
         FDataset dataset = connection.fetchDataset(sql);
         double investmentTotal = 0;
         double redemptionTotal = 0;
         int customerTotal = 0;
         FByteStream dataStream = createStream(context);
         int count = dataset.count();
         dataStream.writeInt32(count);
         for(FRow row : dataset){
            // 计算数据
            String recordDate = row.get("record_hour");
            double investmentAmount = row.getDouble("investment_amount");
            investmentTotal += investmentAmount;
            double redemptionAmount = row.getDouble("redemption_amount");
            redemptionTotal += redemptionAmount;
            double netinvestmentAmount = investmentAmount - redemptionAmount;
            int customerCount = row.getInt("customer_count");
            customerTotal += customerCount;
            // 输出数据
            dataStream.writeString(recordDate);
            dataStream.writeDouble(investmentAmount);
            dataStream.writeDouble(redemptionAmount);
            dataStream.writeDouble(netinvestmentAmount);
         }
         stream.writeDouble(investmentTotal);
         stream.writeDouble(redemptionTotal);
         stream.writeDouble(investmentTotal - redemptionTotal);
         stream.writeUint32(customerTotal);
         stream.writeUint32(customerTotal);
         stream.write(dataStream.memory(), 0, dataStream.position());
      }
      // 输出当月合计数据
      if(connection != null) {
         FSql sql = _resource.findString(FSql.class, "sql.achievement.month");
         sql.bindString("date", currentDate.format("YYYYMM01"));
         FDataset dataset = connection.fetchDataset(sql);
         double investmentTotal = 0;
         double redemptionTotal = 0;
         FByteStream dataStream = createStream(context);
         int count = dataset.count();
         dataStream.writeInt32(count);
         for(FRow row : dataset){
            String recordDate = row.get("record_day");
            // 计算数据
            double investmentAmount = row.getDouble("investment_amount");
            investmentTotal += investmentAmount;
            double redemptionAmount = row.getDouble("redemption_amount");
            redemptionTotal += redemptionAmount;
            double netinvestmentAmount = investmentAmount - redemptionAmount;
            // 输出数据
            dataStream.writeString(recordDate);
            dataStream.writeDouble(investmentAmount);
            dataStream.writeDouble(redemptionAmount);
            dataStream.writeDouble(netinvestmentAmount);
         }
         stream.writeDouble(investmentTotal);
         stream.writeDouble(redemptionTotal);
         stream.writeDouble(investmentTotal - redemptionTotal);
         stream.writeUint32(0);
         stream.writeUint32(0);
         stream.write(dataStream.memory(), 0, dataStream.position());
      }
      // 输出当年合计数据
      if(connection != null) {
         FSql sql = _resource.findString(FSql.class, "sql.achievement.year");
         sql.bindString("date", currentDate.format("YYYY0101"));
         FDataset dataset = connection.fetchDataset(sql);
         double investmentTotal = 0;
         double redemptionTotal = 0;
         FByteStream dataStream = createStream(context);
         int count = dataset.count();
         dataStream.writeInt32(count);
         for(FRow row : dataset){
            String recordDate = row.get("record_month");
            // 计算数据
            double investmentAmount = row.getDouble("investment_amount");
            investmentTotal += investmentAmount;
            double redemptionAmount = row.getDouble("redemption_amount");
            redemptionTotal += redemptionAmount;
            double netinvestmentAmount = investmentAmount - redemptionAmount;
            // 输出数据
            dataStream.writeString(recordDate);
            dataStream.writeDouble(investmentAmount);
            dataStream.writeDouble(redemptionAmount);
            dataStream.writeDouble(netinvestmentAmount);
         }
         stream.writeDouble(investmentTotal);
         stream.writeDouble(redemptionTotal);
         stream.writeDouble(investmentTotal - redemptionTotal);
         stream.writeUint32(0);
         stream.writeUint32(0);
         stream.write(dataStream.memory(), 0, dataStream.position());
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send dynamic. (date={1}, data_length={2})", currentDate.format(), dataLength);
      return sendStream(context, request, response, stream);
   }
}
