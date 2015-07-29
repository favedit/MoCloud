package org.mo.develop.logger;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.mo.com.lang.FObject;

//============================================================
// <T>日志处理。</T>
//============================================================
@ServerEndpoint(value = "/logger", encoders = {FLoggerEncoder.class})
public class FLoggerServlet
      extends FObject
{
   //============================================================
   // <T>消息处理。</T>
   //
   // @param session 会话处理
   // @param message 消息内容
   //============================================================
   @OnMessage
   public void onMessage(Session session,
                         String message) throws Exception{
      System.out.println("> " + message);
      //Set<Session> sessions = session.getOpenSessions();
      //FLoggerMessage m = new FLoggerMessage(message, sessions.size());
      //for(Session s : sessions){
      //   if(s.isOpen()){
      //      s.getBasicRemote().sendObject(m);
      //   }
      //}
   }
}
