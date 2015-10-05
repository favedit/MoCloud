package org.ahyc.eai.demo.service.earth;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.ahyc.eai.demo.core.earth.IWebSocketConsole;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;

//============================================================
// <T>日志处理。</T>
//============================================================
@ServerEndpoint(value = "/earth", encoders = {FLoggerEncoder.class})
public class FLoggerServlet
      extends FObject
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FLoggerServlet.class);

   // 演示控制台
   protected IWebSocketConsole _console;

   //============================================================
   // <T>消息处理。</T>
   //
   // @param session 会话处理
   // @param message 消息内容
   //============================================================
   @OnOpen
   public void onOpen(Session session){
      if(_console == null){
         _console = RAop.find(IWebSocketConsole.class);
      }
      _console.open(session);
   }

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

   //============================================================
   // <T>消息处理。</T>
   //
   // @param session 会话处理
   // @param message 消息内容
   //============================================================
   @OnClose
   public void onClose(Session session){
      _console.close(session);
   }

   //============================================================
   // <T>消息处理。</T>
   //
   // @param session 会话处理
   // @param message 消息内容
   //============================================================
   @OnError
   public void onError(Throwable throwable){
      _logger.error(this, "onError", throwable);
   }
}
