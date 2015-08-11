package org.mo.web.core.action.servlet;

import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>页面处理模块。</T>
//============================================================
public class FActionServlet
      extends FAbstractActionServlet
{
   // 序列化标志
   private static final long serialVersionUID = 1L;

   //============================================================
   // <T>网页逻辑处理。</T>
   //
   // @param context 页面环境
   //============================================================
   @Override
   public String process(IWebContext context){
      String redirect = null;
      String uri = context.requestUri();
      if(uri.endsWith(IActionConstant.WEB_ACTION)){
         redirect = _actionConsole.execute(context, uri);
      }
      return redirect;
   }
}
