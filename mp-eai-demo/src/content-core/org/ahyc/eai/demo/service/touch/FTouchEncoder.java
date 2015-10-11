package org.ahyc.eai.demo.service.touch;

import javax.websocket.EncodeException;
import javax.websocket.Encoder.Text;
import javax.websocket.EndpointConfig;

//============================================================
// <T>日志编码。</T>
//============================================================
public class FTouchEncoder
      implements
         Text<FTouchMessage>
{
   @Override
   public void init(EndpointConfig arg0){
   }

   @Override
   public String encode(FTouchMessage message) throws EncodeException{
      if(message != null){
         return "{\"msginfo\":\"" + message.getMsginfo() + "\",\"onlinecount\":" + message.getOnlinecount() + "}";
      }
      return "{}";
   }

   @Override
   public void destroy(){
   }
}
