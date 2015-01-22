package com.cyou.gccloud.core.message;

import org.mo.com.message.IMessageContext;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>逻辑消息控制台。</T>
//============================================================
public class FGcMessageConsole
      implements
         IGcMessageConsole
{
   // 资源访问接口
   private static IResource _resource = RResource.find(FGcMessageConsole.class);

   //============================================================
   // <T>构造用户控制台。</T>
   //============================================================
   public FGcMessageConsole(){
   }

   //============================================================
   // <T>增加一个逻辑错误。</T>
   //
   // @param context 数据环境
   // @param code 代码
   // @param params 参数集合
   //============================================================
   @Override
   public void pushError(IMessageContext context,
                         String code,
                         Object... params){
      // 获得设置
      FXmlNode xconfig = _resource.findConfig(code);
      String text = xconfig.get("text");
      // 产生消息
      FGcErrorMessage message = new FGcErrorMessage(code, text);
      message.setParams(params);
      context.messages().push(message);
   }

   //============================================================
   // <T>产生逻辑错误。</T>
   //
   // @param context 数据环境
   // @param code 代码
   // @param params 参数集合
   //============================================================
   @Override
   public void throwError(IMessageContext context,
                          String code,
                          Object... params){
      // 获得设置
      FXmlNode xconfig = _resource.findConfig(code);
      String text = xconfig.get("text");
      // 产生消息
      FGcErrorMessage message = new FGcErrorMessage(code, text);
      message.setParams(params);
      context.messages().push(message);
      // 检查例外
      throw new FGcLogicError(message.toString());
   }
}
