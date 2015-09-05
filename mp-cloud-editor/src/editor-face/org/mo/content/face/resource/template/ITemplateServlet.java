package org.mo.content.face.resource.template;

import org.mo.cloud.logic.data.system.FGcSessionInfo;

import org.mo.data.logic.ILogicContext;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理接口。</T>
//============================================================
public interface ITemplateServlet
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param request 页面请求
   // @param response 页面应答
   //============================================================
   public void process(IWebContext context,
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response);

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param request 页面请求
   // @param response 页面应答
   //============================================================
   @AWebLogin
   public void query(IWebContext context,
                     ILogicContext logicContext,
                     FGcSessionInfo session,
                     IWebServletRequest request,
                     IWebServletResponse response);
}
