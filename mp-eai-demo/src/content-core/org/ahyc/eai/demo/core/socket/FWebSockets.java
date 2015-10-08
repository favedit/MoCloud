package org.ahyc.eai.demo.core.socket;

import javax.websocket.Session;
import org.mo.com.lang.FObjects;

//============================================================
// <T>网络端口会话。</T>
//============================================================
public class FWebSockets
      extends FObjects<FWebSocket>
{
   // 分组代码
   private String _groupCode;

   //============================================================
   // <T>构造网络端口会话。</T>
   //============================================================
   public FWebSockets(){
      super(FWebSocket.class);
   }

   //============================================================
   // <T>获得分组代码。</T>
   //
   // @return 分组代码
   //============================================================
   public String groupCode(){
      return _groupCode;
   }

   //============================================================
   // <T>设置分组代码。</T>
   //
   // @param groupCode 分组代码
   //============================================================
   public void setGroupCode(String groupCode){
      _groupCode = groupCode;
   }

   //============================================================
   // <T>打开会话。</T>
   //
   // @param session 会话
   //============================================================
   public void open(Session session){
      String sessionId = session.getId();
      FWebSocket socket = findByCode(sessionId);
      if(socket == null){
         socket = new FWebSocket();
         push(socket);
      }
      socket.setSession(session);
      //_logger.debug(this, "open", "Open session. (count={1}, id={2})", _sessions.count(), session.getId());
   }

   //============================================================
   // <T>查找会话。</T>
   //
   // @param code 代码
   // @return 会话
   //============================================================
   public FWebSocket findByCode(String code){
      if(_count > 0){
         for(int n = 0; n < _count; n++){
            FWebSocket socket = _items[n];
            if(code.equals(socket.code())){
               return socket;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>发送消息。</T>
   //
   // @param message 消息
   //============================================================
   public void sendMessage(String message){
      if(_count > 0){
         for(int n = 0; n < _count; n++){
            FWebSocket socket = _items[n];
            socket.sendMessage(message);
         }
      }
   }

   //============================================================
   // <T>发送消息。</T>
   //
   // @param message 消息
   //============================================================
   public void sendMessage(byte[] data,
                           int offset,
                           int length){
      if(_count > 0){
         for(int n = 0; n < _count; n++){
            FWebSocket socket = _items[n];
            socket.sendMessage(data, offset, length);
         }
      }
   }

   //============================================================
   // <T>关闭会话。</T>
   //
   // @param session 会话
   //============================================================
   public void close(Session session){
      String sessionId = session.getId();
      FWebSocket socket = findByCode(sessionId);
      if(socket != null){
         remove(socket);
      }
      //_logger.debug(this, "close", "Close session. (count={1}, id={2})", _sessions.count(), session.getId());
   }
}
