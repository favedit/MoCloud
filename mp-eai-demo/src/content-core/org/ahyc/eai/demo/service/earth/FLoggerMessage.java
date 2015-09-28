package org.ahyc.eai.demo.service.earth;

//============================================================
// <T>日志消息。</T>
//============================================================
public class FLoggerMessage
{
   protected String msginfo;

   protected int onlinecount;

   public FLoggerMessage(){
   }

   public FLoggerMessage(String msginfo,
                         int onlinecount){
      super();
      this.msginfo = msginfo;
      this.onlinecount = onlinecount;
   }

   public String getMsginfo(){
      return msginfo;
   }

   public void setMsginfo(String msginfo){
      this.msginfo = msginfo;
   }

   public int getOnlinecount(){
      return onlinecount;
   }

   public void setOnlinecount(int onlinecount){
      this.onlinecount = onlinecount;
   }
}
