package org.ahyc.eai.demo.core.input;

import org.ahyc.eai.demo.core.socket.FWebSocketSession;
import org.ahyc.eai.demo.core.socket.IWebSocketConsole;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;

//============================================================
// <T>输入控制台。</T>
//============================================================
public class FEaiInputConsole
      extends FConsole
      implements
         IEaiInputConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FEaiInputConsole.class);

   @ALink
   protected IWebSocketConsole _socketConsole;

   protected FInputConnection _connection;

   //protected Matrix3D _matrix;

   @Override
   public void input(){
   }

   public void sendMessage(String message){
      if(!RString.isEmpty(message)){
         FObjects<FWebSocketSession> sessions = _socketConsole.sessions();
         for(FWebSocketSession session : sessions){
            session.sendMessage(message);
         }
         _logger.debug(this, "sendMessage", "Send message. (count={1}, message={2})", sessions.count(), message);
      }
   }

   public void initialize(){
      System.out.println("Start");
      _connection = new FInputConnection();
      _connection.setPort(3333);
      _connection.registerListener(new FEaiInputListener(this));
      _connection.connect();
   }
}
