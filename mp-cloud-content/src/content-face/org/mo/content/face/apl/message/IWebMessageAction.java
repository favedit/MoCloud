package org.mo.content.face.apl.message;

import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>出错消息的处理页面。</T>
//
// @version 150407
//============================================================
public interface IWebMessageAction
{
   //============================================================
   // <T>转向到提示信息处理页面。</T>
   //
   // @param context 环境
   // @param page 页面
   // @return 提示信息处理页面
   //============================================================
   String info(IWebContext context,
               @AContainer(name = "message") FWebMessagePage page);

   //============================================================
   // <T>转向到警告信息处理页面。</T>
   //
   // @param context 环境
   // @param page 页面
   // @return 警告信息处理页面
   //============================================================
   String warn(IWebContext context,
               @AContainer(name = "message") FWebMessagePage page);

   //============================================================
   // <T>转向到业务错误处理页面。</T>
   //
   // @param context 环境
   // @param page 页面
   // @return 业务错误处理页面
   //============================================================
   String error(IWebContext context,
                @AContainer(name = "message") FWebMessagePage page);

   //============================================================
   // <T>转向到系统错误处理页面。</T>
   //
   // @param context 环境
   // @param page 页面
   // @return 系统错误处理页面
   //============================================================
   String fatal(IWebContext context,
                @AContainer(name = "message") FWebMessagePage page);

   //============================================================
   // <T>转向到超时错误处理页面。</T>
   //
   // @param context 环境
   // @param page 页面
   // @return 超时错误处理页面
   //============================================================
   String timeout(IWebContext context,
                  @AContainer(name = "message") FWebMessagePage page);
}
