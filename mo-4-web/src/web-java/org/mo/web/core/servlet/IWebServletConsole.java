package org.mo.web.core.servlet;

import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>网络处理控制台接口。</T>
//============================================================
public interface IWebServletConsole
{
   //============================================================
   // <T>根据名称查找实例。</T>
   //
   // @param name 名称
   // @return 实例
   //============================================================
   Object findInstance(String name);

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param name 名称
   // @param context 环境
   // @param request 请求
   // @param response 应答
   // @return 处理结果
   //============================================================
   Object execute(String name,
                  IWebContext context,
                  IWebServletRequest request,
                  IWebServletResponse response);

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param uri 地址
   // @param context 环境
   // @param request 请求
   // @param response 应答
   // @return 处理结果
   //============================================================
   Object executeUri(String uri,
                     IWebContext context,
                     IWebServletRequest request,
                     IWebServletResponse response);
}
