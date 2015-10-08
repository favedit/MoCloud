package org.ahyc.eai.demo.service.touch;

import javax.websocket.EncodeException;
import javax.websocket.Encoder.Text;
import javax.websocket.EndpointConfig;

//============================================================
// <T>日志编码。</T>
//============================================================
public class FLoggerEncoder
      implements
         Text<FLoggerMessage>
{
   @Override
   public void init(EndpointConfig arg0){
   }

   @Override
   public String encode(FLoggerMessage message) throws EncodeException{
      if(message != null){
         return "{\"msginfo\":\"" + message.getMsginfo() + "\",\"onlinecount\":" + message.getOnlinecount() + "}";
      }
      return "{}";
   }

   @Override
   public void destroy(){
   }
}
