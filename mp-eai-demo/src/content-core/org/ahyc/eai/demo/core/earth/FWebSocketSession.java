package org.ahyc.eai.demo.core.earth;

import javax.websocket.Session;
import org.ahyc.eai.demo.face.FTestAction;
import org.mo.com.lang.FDictionary;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

public class FWebSocketSession
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FTestAction.class);

   protected FDictionary<Session> _sessions = new FDictionary<Session>(Session.class);

   public void open(Session session){
      String sessionId = session.getId();
      _sessions.set(sessionId, session);
      _logger.debug(this, "open", "Open session. (id={1})", session.getId());
   }

   public Session find(String code){
      return _sessions.get(code, null);
   }

   public void close(Session session){
      String sessionId = session.getId();
      _sessions.remove(sessionId);
      _logger.debug(this, "close", "Close session. (id={1})", sessionId);
   }

   public Session[] fetch(){
      _logger.debug(this, "fetch", "Fetch sessions. (count={1})", _sessions.count());
      return _sessions.toObjects();
   }

}
