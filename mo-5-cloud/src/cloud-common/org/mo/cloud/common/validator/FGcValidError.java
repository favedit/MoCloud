package org.mo.cloud.common.validator;

import org.mo.com.lang.FValidError;

//============================================================
// <T>校验例外。</T>
//============================================================
public class FGcValidError
      extends FValidError
{
   // 序列化标识
   private final static long serialVersionUID = 1L;

   //============================================================
   // <T>构造校验例外。</T>
   //============================================================
   public FGcValidError(){
      _catch = false;
   }

   //============================================================
   // <T>构造校验例外。</T>
   //
   // @param message 消息
   //============================================================
   public FGcValidError(String message){
      super(message);
      _catch = false;
   }

   //============================================================
   // <T>构造校验例外。</T>
   //
   // @param message 消息
   // @param params 参数
   //============================================================
   public FGcValidError(String message,
                        Object... params){
      super(message, params);
      _catch = false;
   }
}
