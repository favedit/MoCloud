package com.ahyc.eai.service.system;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import org.mo.cloud.logic.system.IGcSessionConsole;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<T>系统信息处理接口。</T>
//============================================================
public class FSystemServlet
      extends FAbstractStatisticsServlet
      implements
         ISystemServlet
{

   // 会话控制台
   @ALink
   protected IGcSessionConsole _sessionConsole;

   //============================================================
   // <T>获得系统信息。</T>
   //
   // @param context 环境
   // @param session 会话
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult info(IWebContext context,
                       IWebSession session,
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response){
      // 开启会话
      String sessionId = session.id();
      //_sessionConsole.open(logicContext, sessionId);
      //............................................................
      // 发送信息
      FByteStream stream = new FByteStream();
      // 写入会话
      stream.writeString(sessionId);
      // 写入时间
      String date = RDateTime.format();
      stream.writeString(date);
      // 写入令牌
      int token = _infoConsole.token();
      stream.writeInt32(token);
      //............................................................
      // 发送数据
      return sendStream(context, request, response, stream);
   }
}
