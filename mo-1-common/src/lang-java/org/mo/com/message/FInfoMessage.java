package org.mo.com.message;

//============================================================
// <T>信息消息。</T>
//============================================================
public class FInfoMessage
      extends FAbstractMessage
{
   private static String NAME = "Info";

   //============================================================
   // <T>信息消息。</T>
   //============================================================
   public FInfoMessage(){
   }

   public FInfoMessage(String message){
      super(message);
   }

   public FInfoMessage(String message,
                       String... params){
      super(message, params);
   }

   @Override
   public String name(){
      return NAME;
   }
}
