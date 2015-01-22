package org.mo.com.message;

import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;

//============================================================
// <T>消息环境。</T>
//============================================================
public class FMessageContext
      extends FObject
{
   // 消息集合
   protected FMessages _messages;

   //============================================================
   // <T>构造消息环境。</T>
   //============================================================
   public FMessageContext(){
   }

   //============================================================
   // <T>获得消息集合。</T>
   //
   // @return 消息集合
   //============================================================
   public FMessages messages(){
      return _messages;
   }

   //============================================================
   // <T>设置消息集合。</T>
   //
   // @param messages 消息集合
   //============================================================
   public void setMessages(FMessages messages){
      _messages = messages;
   }

   //============================================================
   // <T>校验空处理。</T>
   //============================================================
   public boolean validEmpty(String name,
                             String value){
      if(RString.isEmpty(value)){
         messages().push(new FErrorMessage(name + " is empty."));
         return false;
      }
      return true;
   }
}
