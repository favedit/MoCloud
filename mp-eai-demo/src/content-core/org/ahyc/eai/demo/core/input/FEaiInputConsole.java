package org.ahyc.eai.demo.core.input;

import org.ahyc.eai.demo.core.socket.IWebSocketConsole;
import org.mo.com.console.FConsole;
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

   @Override
   public void input(){
   }

   public void sendMessage(String groupName,
                           String message){
      _socketConsole.sendMessage(groupName, message);
   }

   public void sendMessage(String groupName,
                           byte[] data,
                           int offset,
                           int length){
      _socketConsole.sendMessage(groupName, data, offset, length);
   }

   public void initialize(){
      _logger.info(this, "initialize", "Build input connection.");
      _connection = new FInputConnection();
      _connection.setPort(3333);
      _connection.registerListener(new FEaiInputListener(this));
      _connection.connect();
   }
}
