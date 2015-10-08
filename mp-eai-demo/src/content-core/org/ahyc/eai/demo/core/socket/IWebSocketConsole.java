package org.ahyc.eai.demo.core.socket;

import javax.websocket.Session;

//============================================================
// <T>网络端口控制台接口。</T>
//============================================================
public interface IWebSocketConsole
{
   void open(String groupCode,
             Session session);

   FWebSockets findSockets(String groupCode);

   FWebSocket find(String groupCode,
                   String code);

   void sendMessage(String groupName,
                    String message);

   void sendMessage(String groupName,
                    byte[] data,
                    int offset,
                    int length);

   void close(String groupCode,
              Session session);

}
