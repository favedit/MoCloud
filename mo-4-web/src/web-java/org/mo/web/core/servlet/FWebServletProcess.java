package org.mo.web.core.servlet;

import org.mo.web.core.servlet.common.FAbstractWebServlet;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>页面处理类。</T>
//============================================================
public class FWebServletProcess
      extends FAbstractWebServlet
{
   // 序列化标志
   private static final long serialVersionUID = 1L;

   //============================================================
   // <T>网页请求逻辑对象执行开始。</T>
   //
   // @param name 名称
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void process(String name,
                       IWebContext context,
                       IWebServletRequest request,
                       IWebServletResponse response){
      _servletConsole.execute(name, context, request, response);
   }
}
