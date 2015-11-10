package com.ahyc.eai.service.cockpit.forecast;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>智慧柯南接口.</T>
//============================================================
public class FCockpitForecastServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitForecastServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitForecastServlet.class);

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitWarningServlet.class);

   //============================================================
   // <T>智慧柯南列表</T>
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
      //检查参数
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
      int count = 5;
      FByteStream stream = createStream(context);
      stream.writeInt32(count);
      stream.writeString("同一账号反复投资/赎回");
      stream.writeInt32(10);
      for(int i = 0; i < 10; i++){
         stream.writeDouble(Math.random());
      }
      stream.writeString("所有员工的月末投资");
      stream.writeInt32(10);
      for(int i = 0; i < 10; i++){
         stream.writeDouble(Math.random());
      }
      stream.writeString("每月固定时间内投资/赎回");
      stream.writeInt32(10);
      for(int i = 0; i < 10; i++){
         stream.writeDouble(Math.random());
      }
      stream.writeString("理财师投资业绩/绩效业绩");
      stream.writeInt32(10);
      for(int i = 0; i < 10; i++){
         stream.writeDouble(Math.random());
      }
      stream.writeString("分公司的人员流动性");
      stream.writeInt32(10);
      for(int i = 0; i < 10; i++){
         stream.writeDouble(Math.random());
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send data notice dynamic. (count={1}, data_length={2})", count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
