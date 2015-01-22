package org.mo.web.core.message;

import org.mo.com.lang.FValidError;

//============================================================
// <T>校验例外。</T>
//============================================================
public class FWebLogicError
      extends FValidError
{
   // 序列化标识
   private final static long serialVersionUID = 1L;

   //============================================================
   // <T>构造校验例外。</T>
   //============================================================
   public FWebLogicError(){
      _catch = false;
   }

   //============================================================
   // <T>构造校验例外。</T>
   //
   // @param message 消息
   //============================================================
   public FWebLogicError(String message){
      super(message);
      _catch = false;
   }

   //============================================================
   // <T>构造校验例外。</T>
   //
   // @param message 消息
   // @param params 参数
   //============================================================
   public FWebLogicError(String message,
                         Object... params){
      super(message, params);
      _catch = false;
   }
}
