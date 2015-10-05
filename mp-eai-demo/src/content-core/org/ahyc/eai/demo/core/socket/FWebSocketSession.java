package org.ahyc.eai.demo.core.socket;

import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>网络端口会话。</T>
//============================================================
public class FWebSocketSession
      extends FObject
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FWebSocketSession.class);

   // 代码
   private String _code;

   // 会话
   private Session _session;

   //============================================================
   // <T>构造网络端口会话。</T>
   //============================================================
   public FWebSocketSession(){
   }

   //============================================================
   // <T>构造网络端口会话。</T>
   //
   // @param session 会话
   //============================================================
   public FWebSocketSession(Session session){
      setSession(session);
   }

   //============================================================
   // <T>获得会话。</T>
   //
   // @return 会话
   //============================================================
   public Session session(){
      return _session;
   }

   //============================================================
   // <T>设置会话。</T>
   //
   // @param session 会话
   //============================================================
   public void setSession(Session session){
      _session = session;
      _code = session.getId();
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>发送消息。</T>
   //
   // @param message 消息
   //============================================================
   public void sendMessage(String message){
      try{
         Async async = _session.getAsyncRemote();
         async.sendText(message);
         //         Basic basic = _session.getBasicRemote();
         //         basic.sendText(message);
      }catch(Exception exception){
         _logger.error(this, "sendMessage", exception);
      }
   }
}
