package com.ahyc.eai.service.cockpit.status;

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
// <T>仪表盘接口。</T>
//============================================================
public class FCockpitStatusServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitStatusServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitStatusServlet.class);

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitWarningServlet.class);

   //============================================================
   // <T>仪表盘数据获取</T>
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
      _logger.debug(this, "fetch", "the method named find from FCockpitWarningServlet is beginning... ");
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
      FByteStream dataStream = createStream(context);
      //      ISqlConnection connection = logicContext.activeConnection("statistics");
      //............................................................
      dataStream.writeString("50");//集团当月入职离职情况
      dataStream.writeString("60");//理财师人均业绩百分比
      dataStream.writeString("70");//集团收支状况百分比
      dataStream.writeString("80");//业绩完成度百分比
      //写入数据
      stream.write(dataStream.memory(), 0, dataStream.position());
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
