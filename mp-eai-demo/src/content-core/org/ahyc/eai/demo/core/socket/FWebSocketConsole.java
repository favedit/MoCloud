package org.ahyc.eai.demo.core.socket;

import javax.websocket.Session;
import org.ahyc.eai.demo.face.FTestAction;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.RString;
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

   // 会话字典
   protected FDictionary<FWebSockets> _sessions = new FDictionary<FWebSockets>(FWebSockets.class);

   //============================================================
   // <T>打开会话。</T>
   //
   // @param session 会话
   //============================================================
   @Override
   public void open(String groupCode,
                    Session session){
      FWebSockets sockets = _sessions.find(groupCode);
      if(sockets == null){
         sockets = new FWebSockets();
         sockets.setGroupCode(groupCode);
         _sessions.set(groupCode, sockets);
      }
      sockets.open(session);
      _logger.debug(this, "open", "Open session. (group_code={1}, count={2}, id={3})", groupCode, sockets.count(), session.getId());
   }

   //============================================================
   // <T>获得会话集合。</T>
   //
   // @return 会话集合
   //============================================================
   @Override
   public FWebSockets findSockets(String groupCode){
      return _sessions.find(groupCode);
   }

   //============================================================
   // <T>查找会话。</T>
   //
   // @param code 代码
   // @return 会话
   //============================================================
   @Override
   public FWebSocket find(String groupCode,
                          String code){
      FWebSockets sockets = _sessions.find(groupCode);
      return sockets.findByCode(code);
   }

   @Override
   public void sendMessage(String groupName,
                           String message){
      if(!RString.isEmpty(message)){
         FWebSockets sockets = findSockets(groupName);
         if(sockets != null){
            sockets.sendMessage(message);
            _logger.debug(this, "sendMessage", "Send message. (group_name={1}, count={2}, message={3})", groupName, sockets.count(), message);
         }
      }
   }

   @Override
   public void sendMessage(String groupName,
                           byte[] data,
                           int offset,
                           int length){
      if(length > 0){
         FWebSockets sockets = findSockets(groupName);
         if(sockets != null){
            sockets.sendMessage(data, offset, length);
            _logger.debug(this, "sendMessage", "Send message. (group_name={1}, count={2}, data_length={3})", groupName, sockets.count(), length);
         }
      }
   }

   //============================================================
   // <T>关闭会话。</T>
   //
   // @param session 会话
   //============================================================
   @Override
   public void close(String groupCode,
                     Session session){
      FWebSockets sockets = _sessions.find(groupCode);
      if(sockets != null){
         sockets.close(session);
         _logger.debug(this, "close", "Close session. (group_code={1}, count={2}, id={3})", groupCode, sockets.count(), session.getId());
      }
   }
}
