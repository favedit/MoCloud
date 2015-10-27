/*
 * @(#)IWebMessageAction.java
 *
 * Copyright 2008 microbject, All Rights Reserved.
 *
 */
package org.mo.content.face.apl.message;

import org.mo.com.message.FErrorMessage;
import org.mo.com.message.FFatalMessage;
import org.mo.com.message.FMessages;
import org.mo.com.message.IMessage;
import org.mo.com.message.RMessage;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.web.core.webform.IWebFormConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>出错消息的处理页面。</T>
//
// @version 150407
//============================================================
public class FWebMessageAction
      implements
         IWebMessageAction
{
   // 逻辑错误
   public static String PAGE_ERROR = "LogicError";

   // 逻辑例外
   public static String PAGE_FATAL = "LogicFatal";

   // 表单管理器
   @ALink
   protected IWebFormConsole _webformConsole;

   //============================================================
   // <T>转向到提示信息处理页面。</T>
   //
   // @param context 环境
   // @param page 页面
   // @return 提示信息处理页面
   //============================================================
   @Override
   public String info(IWebContext context,
                      FWebMessagePage page){
      FXmlNode xmessage = new FXmlNode("Info");
      FMessages messages = context.messages();
      for(IMessage item : messages){
         item.saveConfig(xmessage.createNode(RMessage.TagMessage));
      }
      page.setMessages(xmessage);
      context.messages().clear();
      return "Information";
   }

   //============================================================
   // <T>转向到警告信息处理页面。</T>
   //
   // @param context 环境
   // @param page 页面
   // @return 警告信息处理页面
   //============================================================
   @Override
   public String warn(IWebContext context,
                      FWebMessagePage page){
      FXmlNode xmessage = new FXmlNode("Warn");
      FMessages messages = context.messages();
      for(IMessage item : messages){
         item.saveConfig(xmessage.createNode(RMessage.TagMessage));
      }
      page.setMessages(xmessage);
      context.messages().clear();
      return "Warning";
   }

   //============================================================
   // <T>转向到业务错误处理页面。</T>
   //
   // @param context 环境
   // @param page 页面
   // @return 业务错误处理页面
   //============================================================
   @Override
   public String error(IWebContext context,
                       FWebMessagePage page){
      // 获得错误信息
      FErrorMessage errorMessage = context.messages().message(FErrorMessage.class);
      // 设置页面信息
      page.setType("E");
      page.setCode(errorMessage.code());
      page.setMessage(errorMessage.message());
      page.setDescription(errorMessage.description());
      // 清除消息信息
      context.messages().clear();
      // 显示页面
      return PAGE_ERROR;
   }

   //============================================================
   // <T>转向到系统错误处理页面。</T>
   //
   // @param context 环境
   // @param page 页面
   // @return 系统错误处理页面
   //============================================================
   @Override
   public String fatal(IWebContext context,
                       FWebMessagePage page){
      // 获得错误信息
      FFatalMessage fatalMessage = context.messages().message(FFatalMessage.class);
      // 设置页面信息
      page.setType("F");
      page.setCode(fatalMessage.code());
      page.setMessage(fatalMessage.message());
      page.setDescription(fatalMessage.description());
      // 清除消息信息
      context.messages().clear();
      // 显示页面
      return PAGE_FATAL;
   }

   //============================================================
   // <T>转向到超时错误处理页面。</T>
   //
   // @param context 环境
   // @param page 页面
   // @return 超时错误处理页面
   //============================================================
   @Override
   public String timeout(IWebContext context,
                         FWebMessagePage page){
      context.messages().clear();
      return "Timeout";
   }
}
