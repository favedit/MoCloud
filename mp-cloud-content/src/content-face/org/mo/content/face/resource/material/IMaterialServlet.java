package org.mo.content.face.resource.material;

import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>材质数据处理接口。</T>
//============================================================
public interface IMaterialServlet
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param request 页面请求
   // @param response 页面应答
   //============================================================
   public void process(IWebContext context,
                       ILogicContext logicContext,
                       FGcSessionInfo session,
                       IWebServletRequest request,
                       IWebServletResponse response);
}
