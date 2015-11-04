package com.ahyc.eai.service.cockpit.truetimedata;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>实时数据处理。</T>
//============================================================
public class FCockpitTrueTimeDataServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitTrueTimeDataServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitTrueTimeDataServlet.class);

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitWarningServlet.class);

   //============================================================
   // <T>实时数据</T>
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
      _logger.debug(this, "fetch", "the method named fetch from FCockpitTrueTimeDataServlet is beginning... ");
      // 检查参数
      //      if(!checkParameters(context, request, response)){
      //         return EResult.Failure;
      //      }
      //      String warningGuid = context.parameter("guid");
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "fetch";
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      //      TDateTime currentDate = RDateTime.currentDateTime();
      // 设置输出流
      FByteStream stream = createStream(context);
      //      ISqlConnection connection = logicContext.activeConnection("statistics");
      //............................................................
      stream.writeString("investment_total");
      stream.writeString("520亿7979万2378元");
      stream.writeString("current_investment");
      stream.writeString("20亿7979万2378元");
      stream.writeString("employee_count");
      stream.writeInt32(92800);
      stream.writeString("marketer_count");
      stream.writeInt32(70000);
      stream.writeString("subsidiary_count");
      stream.writeInt32(45);
      stream.writeString("wealth_count");
      stream.writeInt32(250);
      stream.writeString("workplace_count");
      stream.writeInt32(485);
      stream.writeString("thing_count");
      stream.writeInt32(8);
      stream.writeString("unread_count");
      stream.writeInt32(5);
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics customer dynamic. (data_length={1})", dataLength);
      return sendStream(context, request, response, stream);
   }

   //============================================================
   // <T>根据guid获取阈值预警详情</T>
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult find(IWebContext context,
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response){
      _logger.debug(this, "fetch", "the method named find from FCockpitWarningServlet is beginning... ");
      // 检查参数
      //      if(!checkParameters(context, request, response)){
      //         return EResult.Failure;
      //      }
      //      String warningGuid = context.parameter("guid");
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "find";
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      //      TDateTime currentDate = RDateTime.currentDateTime();
      // 设置输出流
      FByteStream stream = createStream(context);
      //      ISqlConnection connection = logicContext.activeConnection("statistics");
      //............................................................
      stream.writeString("本条阈值预警详情....");
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics customer dynamic. (data_length={1})", dataLength);
      return sendStream(context, request, response, stream);
   }
}
