package com.ahyc.eai.service.cockpit.trend;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.core.common.EEaiDataConnection;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>业绩趋势处理接口。</T>
//============================================================
public class FCockpitTrendServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitTrendServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitTrendServlet.class);

   // 资源访问接口
   private static IResource _resource = RResource.find(FCockpitTrendServlet.class);

   //============================================================
   // <T>业绩趋势列表</T>
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
      _logger.debug(this, "fetch", "the method named fetch from FCockpitTrendServlet is beginning... ");
      //       检查参数
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
      //............................................................
      TDateTime month2Date = new TDateTime(currentDate.format("YYYYMM01"), "YYYYMMDD");
      int month2Days = month2Date.monthDay();
      TDateTime month1Date = new TDateTime(month2Date);
      month1Date.addMonth(-1);
      int month1Days = month1Date.monthDay();
      // 查询数据
      FSql sql = _resource.findString(FSql.class, "sql.cockpit.trend");
      sql.bindDateTime("month1", month1Date, "YYYYMM01");
      sql.bindDateTime("month2", month2Date, "YYYYMM01");
      FDataset dataset = connection.fetchDataset(sql);
      // 生成字典
      FDictionary<FRow> rows = new FDictionary<FRow>(FRow.class);
      for(FRow row : dataset){
         String code = RDateTime.format(row.get("record_day"), "YYYYMMDD");
         rows.set(code, row);
      }
      // 输出数据
      TDateTime currentMonth1 = new TDateTime(month1Date);
      TDateTime currentMonth2 = new TDateTime(month2Date);
      int count = 31;
      stream.writeInt32(count);
      for(int n = 0; n < count; n++){
         // 写入上月数据
         String month1Code = currentMonth1.format("YYYYMMDD");
         stream.writeString(month1Code);
         FRow row1 = rows.find(month1Code);
         if((n < month1Days) && (row1 != null)){
            double investmentAmount = row1.getDouble("investment_amount");
            double redemptionAmount = row1.getDouble("redemption_amount");
            stream.writeDouble(investmentAmount);
            stream.writeDouble(redemptionAmount);
            stream.writeDouble(investmentAmount - redemptionAmount);
            currentMonth1.addDay(1);
         }else{
            stream.writeDouble(0);
            stream.writeDouble(0);
            stream.writeDouble(0);
         }
         // 写入当月数据
         String month2Code = currentMonth2.format("YYYYMMDD");
         stream.writeString(month2Code);
         FRow row2 = rows.find(month2Code);
         if((n < month2Days) && (row2 != null)){
            double investmentAmount = row2.getDouble("investment_amount");
            double redemptionAmount = row2.getDouble("redemption_amount");
            stream.writeDouble(investmentAmount);
            stream.writeDouble(redemptionAmount);
            stream.writeDouble(investmentAmount - redemptionAmount);
            currentMonth2.addDay(1);
         }else{
            stream.writeDouble(0);
            stream.writeDouble(0);
            stream.writeDouble(0);
         }
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics customer dynamic. (count={1}, data_length={2})", count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
