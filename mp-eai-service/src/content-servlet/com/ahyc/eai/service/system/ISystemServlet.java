package com.ahyc.eai.service.system;

import org.mo.com.lang.EResult;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>系统信息处理接口。</T>
//============================================================
public interface ISystemServlet
{
   //============================================================
   // <T>获得系统信息。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   EResult info(IWebContext context,
                IWebServletRequest request,
                IWebServletResponse response);
}
