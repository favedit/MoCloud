package com.ahyc.eai.service.cockpit.achievement;

import com.ahyc.eai.core.financial.IFinancialConsole;
import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.core.common.EEaiDataConnection;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>驾驶舱业绩处理。</T>
//============================================================
public class FCockpitAchievementServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitAchievementServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitAchievementServlet.class);

   // 资源访问接口
   private static IResource _resource = RResource.find(FCockpitAchievementServlet.class);

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
   public EResult fetch(IWebContext context,
                        ILogicContext logicContext,
                        IWebServletRequest request,
                        IWebServletResponse response){
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      //............................................................
      // 获得当前时间
      TDateTime currentDate = RDateTime.currentDateTime();
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "dynamic|" + currentDate.format("YYYYMMDDHH24MI");
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.STATISTICS);
      // 输出当日合计数据
      FSql sql = _resource.findString(FSql.class, "sql.department");
      sql.bindString("month", currentDate.format("YYYYMM01"));
      FDataset dataset = connection.fetchDataset(sql);
      double investmentTotal = 0;
      double redemptionTotal = 0;
      FByteStream dataStream = createStream(context);
      int count = dataset.count();
      dataStream.writeInt32(count);
      for(FRow row : dataset){
         // 计算数据
         String label = row.get("label");
         double investmentAmount = row.getDouble("investment_amount");
         investmentTotal += investmentAmount;
         double redemptionAmount = row.getDouble("redemption_amount");
         redemptionTotal += redemptionAmount;
         double netinvestmentAmount = investmentAmount - redemptionAmount;
         redemptionTotal += redemptionAmount;
         int marketerCount = row.getInt("marketer_count");
         int marketerTotal = row.getInt("marketer_total");
         int customerCount = row.getInt("customer_count");
         int customerTotal = row.getInt("customer_total");
         // 输出数据
         dataStream.writeString(label);
         dataStream.writeDouble(RDouble.roundHalf(investmentAmount, 2));
         dataStream.writeDouble(RDouble.roundHalf(redemptionAmount, 2));
         dataStream.writeDouble(RDouble.roundHalf(netinvestmentAmount, 2));
         dataStream.writeUint32(marketerCount);
         dataStream.writeUint32(marketerTotal);
         dataStream.writeUint32(customerCount);
         dataStream.writeUint32(customerTotal);
      }
      // 写入数据
      stream.writeDouble(RDouble.roundHalf(investmentTotal, 2));
      stream.writeDouble(RDouble.roundHalf(redemptionTotal, 2));
      stream.writeDouble(RDouble.roundHalf(investmentTotal - redemptionTotal, 2));
      stream.write(dataStream.memory(), 0, dataStream.position());
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
