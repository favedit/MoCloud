package org.mo.cloud.core.message;

import org.mo.com.message.IMessageContext;

//============================================================
// <T>逻辑消息控制台接口。</T>
//============================================================
public interface IGcMessageConsole
{
   //============================================================
   // <T>增加一个逻辑错误。</T>
   //
   // @param context 数据环境
   // @param code 代码
   // @param params 参数集合
   //============================================================
   void pushError(IMessageContext context,
                  String code,
                  Object... params);

   //============================================================
   // <T>产生逻辑错误。</T>
   //
   // @param context 数据环境
   // @param code 代码
   // @param params 参数集合
   //============================================================
   void throwError(IMessageContext context,
                   String code,
                   Object... params);
}
