package org.ahyc.eai.demo.core.socket;

import javax.websocket.Session;
import org.mo.com.lang.FObjects;

//============================================================
// <T>网络端口控制台接口。</T>
//============================================================
public interface IWebSocketConsole
{
   void open(Session session);

   //============================================================
   // <T>获得会话集合。</T>
   //
   // @return 会话集合
   //============================================================
   FObjects<FWebSocketSession> sessions();

   FWebSocketSession find(String code);

   FWebSocketSession[] fetch();

   void close(Session session);
}
