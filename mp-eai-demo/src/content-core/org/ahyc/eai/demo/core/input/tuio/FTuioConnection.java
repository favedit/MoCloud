package org.ahyc.eai.demo.core.input.tuio;

import TUIO.TuioClient;
import org.mo.com.lang.FObject;

//============================================================
// <T>TUIO链接。</T>
//============================================================
public class FTuioConnection
      extends FObject
{
   // 端口
   protected int _port = 3000;

   // 客户端
   protected TuioClient _client;

   //============================================================
   // <T>构造TUIO链接。</T>
   //============================================================
   public FTuioConnection(){
   }

   //============================================================
   // <T>链接服务器。</T>
   //============================================================
   public void connect(){
      _client = new TuioClient(_port);
      _client.connect();
   }

   //============================================================
   // <T>链接服务器。</T>
   //============================================================
   public void registerListener(FTuioListener listener){
      _client.addTuioListener(listener);
   }

   //============================================================
   // <T>断开服务器。</T>
   //============================================================
   public void disconnect(){
      _client.disconnect();
   }
}
