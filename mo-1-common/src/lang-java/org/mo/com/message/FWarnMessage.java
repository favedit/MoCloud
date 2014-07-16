package org.mo.com.message;

//============================================================
// <T>警告消息。</T>
//============================================================
public class FWarnMessage
      extends FAbstractMessage
{
   // 名称
   protected static String NAME = "Warn";

   //============================================================
   // <T>构造警告消息。</T>
   //============================================================
   public FWarnMessage(){
   }

   //============================================================
   // <T>构造警告消息。</T>
   //
   // @param message 消息
   //============================================================
   public FWarnMessage(String message){
      super(message);
   }

   //============================================================
   // <T>构造警告消息。</T>
   //
   // @param message 消息
   // @param params 参数集合
   //============================================================
   public FWarnMessage(String message,
                       String... params){
      super(message, params);
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   @Override
   public String name(){
      return NAME;
   }
}
