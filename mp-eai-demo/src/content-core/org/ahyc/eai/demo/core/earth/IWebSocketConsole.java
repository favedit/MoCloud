package org.ahyc.eai.demo.core.earth;

import javax.websocket.Session;

//============================================================
// <T>网络端口控制台接口。</T>
//============================================================
public interface IWebSocketConsole
{
   void open(Session session);

   FWebSocketSession find(String code);

   FWebSocketSession[] fetch();

   void close(Session session);
}
