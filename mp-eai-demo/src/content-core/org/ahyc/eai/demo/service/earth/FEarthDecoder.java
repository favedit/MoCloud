package org.ahyc.eai.demo.service.earth;

import javax.websocket.EncodeException;
import javax.websocket.Encoder.Text;
import javax.websocket.EndpointConfig;

//============================================================
// <T>日志编码。</T>
//============================================================
public class FEarthDecoder
      implements
         Text<FEarthMessage>
{
   @Override
   public void init(EndpointConfig arg0){
   }

   @Override
   public String encode(FEarthMessage message) throws EncodeException{
      if(message != null){
         return "{\"msginfo\":\"" + message.getMsginfo() + "\",\"onlinecount\":" + message.getOnlinecount() + "}";
      }
      return "{}";
   }

   @Override
   public void destroy(){
   }
}
