package org.ahyc.eai.demo.core.earth;

import javax.websocket.Session;

//============================================================
// <T>通讯会话控制台接口。</T>
//============================================================
public interface IWebSocketConsole
{
   void open(Session session);

   Session find(String code);

   Session[] fetch();

   void close(Session session);
}
