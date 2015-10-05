package org.ahyc.eai.demo.core.earth;

import javax.websocket.Session;
import org.ahyc.eai.demo.face.FTestAction;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FObjects;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>网络端口控制台。</T>
//============================================================
public class FWebSocketConsole
      extends FConsole
      implements
         IWebSocketConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FTestAction.class);

   // 会话集合
   protected FObjects<FWebSocketSession> _sessions = new FObjects<FWebSocketSession>(FWebSocketSession.class);

   //============================================================
   // <T>查找会话。</T>
   //
   // @param code 代码
   // @return 会话
   //============================================================
   @Override
   public FWebSocketSession find(String code){
      for(FWebSocketSession webSocket : _sessions){
         if(code.equals(webSocket.code())){
            return webSocket;
         }
      }
      return null;
   }

   //============================================================
   // <T>获得会话列表。</T>
   //
   // @return 会话列表
   //============================================================
   @Override
   public FWebSocketSession[] fetch(){
      _logger.debug(this, "fetch", "Fetch sessions. (count={1})", _sessions.count());
      return _sessions.toObjects();
   }

   //============================================================
   // <T>打开会话。</T>
   //
   // @param session 会话
   //============================================================
   @Override
   public void open(Session session){
      String sessionId = session.getId();
      FWebSocketSession webSession = find(sessionId);
      if(webSession == null){
         webSession = new FWebSocketSession();
         _sessions.push(webSession);
      }
      webSession.setSession(session);
      _logger.debug(this, "open", "Open session. (id={1})", session.getId());
   }

   //============================================================
   // <T>关闭会话。</T>
   //
   // @param session 会话
   //============================================================
   @Override
   public void close(Session session){
      String sessionId = session.getId();
      FWebSocketSession webSession = find(sessionId);
      if(webSession != null){
         _sessions.remove(webSession);
      }
      _logger.debug(this, "close", "Close session. (id={1})", sessionId);
   }
}
