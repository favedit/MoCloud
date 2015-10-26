package org.mo.cloud.servlet.picture;

import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>图片服务接口。</T>
//============================================================
public interface IPictureUrlServlet
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public void process(IWebContext context,
                       IWebServletRequest request,
                       IWebServletResponse response);
}
