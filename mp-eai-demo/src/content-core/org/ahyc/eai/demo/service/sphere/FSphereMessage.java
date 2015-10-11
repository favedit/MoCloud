package org.ahyc.eai.demo.service.sphere;

//============================================================
// <T>日志消息。</T>
//============================================================
public class FSphereMessage
{
   protected String msginfo;

   protected int onlinecount;

   public FSphereMessage(){
   }

   public FSphereMessage(String msginfo,
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
