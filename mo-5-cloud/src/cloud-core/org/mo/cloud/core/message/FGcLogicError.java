package org.mo.cloud.core.message;

import org.mo.com.lang.FValidError;

//============================================================
// <T>校验例外。</T>
//============================================================
public class FGcLogicError
      extends FValidError
{
   // 序列化标识
   private final static long serialVersionUID = 1L;

   //============================================================
   // <T>构造校验例外。</T>
   //============================================================
   public FGcLogicError(){
      _catch = false;
   }

   //============================================================
   // <T>构造校验例外。</T>
   //
   // @param message 消息
   //============================================================
   public FGcLogicError(String message){
      super(message);
      _catch = false;
   }

   //============================================================
   // <T>构造校验例外。</T>
   //
   // @param message 消息
   // @param params 参数
   //============================================================
   public FGcLogicError(String message,
                        Object... params){
      super(message, params);
      _catch = false;
   }
}
