package org.mo.content.face.resource.model;

import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理接口。</T>
//============================================================
public interface IModelServlet
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public void process(IWebContext context,
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response);

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话
   // @param request 请求
   // @param response 应答
   //============================================================
   @AWebLogin
   public void importData(IWebContext context,
                          ILogicContext logicContext,
                          FGcSessionInfo session,
                          IWebServletRequest request,
                          IWebServletResponse response);
}
