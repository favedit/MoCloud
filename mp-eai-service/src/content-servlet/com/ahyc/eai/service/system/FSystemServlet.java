package com.ahyc.eai.service.system;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.content.core.system.ISystemInfoConsole;
import org.mo.core.aop.face.ALink;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<T>系统信息处理接口。</T>
//============================================================
public class FSystemServlet
      extends FAbstractStatisticsServlet
      implements
         ISystemServlet
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FSystemServlet.class);

   @ALink
   protected ISystemInfoConsole _infoConsole;

   //============================================================
   // <T>获得系统信息。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult info(IWebContext context,
                       IWebServletRequest request,
                       IWebServletResponse response){
      FByteStream stream = new FByteStream();
      int token = _infoConsole.token();
      stream.writeInt32(token);
      //_logger.debug(this, "process", "Send statistics marketer dynamic. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      //............................................................
      // 发送数据
      return sendStream(context, request, response, stream);
   }
}
