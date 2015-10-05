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
   private int _port = 3000;

   // 客户端
   protected TuioClient _client;

   //============================================================
   // <T>构造TUIO链接。</T>
   //============================================================
   public FTuioConnection(){
   }

   //============================================================
   // <T>获得端口。</T>
   //
   // @return 端口
   //============================================================
   public int port(){
      return _port;
   }

   //============================================================
   // <T>设置端口。</T>
   //
   // @param port 端口
   //============================================================
   public void setPort(int port){
      _port = port;
   }

   //============================================================
   // <T>链接服务器。</T>
   //============================================================
   public void connect(){
      _client = new TuioClient(_port);
      _client.addTuioListener(_listener);
      _client.connect();
   }

   FTuioListener _listener;

   //============================================================
   // <T>链接服务器。</T>
   //============================================================
   public void registerListener(FTuioListener listener){
      _listener = listener;
      //_client.addTuioListener(listener);
   }

   //============================================================
   // <T>断开服务器。</T>
   //============================================================
   public void disconnect(){
      _client.disconnect();
   }

}
