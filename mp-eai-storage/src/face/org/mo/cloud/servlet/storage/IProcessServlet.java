package org.mo.cloud.servlet.storage;

import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理接口。</T>
//============================================================
public interface IProcessServlet
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public void upload(IWebContext context,
                      IWebServletRequest request,
                      IWebServletResponse response);

   //============================================================
   // <T>删除文件处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public void delete(IWebContext context,
                      IWebServletRequest request,
                      IWebServletResponse response);

   //============================================================
   // <T>删除目录处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public void drop(IWebContext context,
                    IWebServletRequest request,
                    IWebServletResponse response);
}
