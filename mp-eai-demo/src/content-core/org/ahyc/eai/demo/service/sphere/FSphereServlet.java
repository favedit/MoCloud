package org.ahyc.eai.demo.service.sphere;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.ahyc.eai.demo.core.input.IEaiInputConsole;
import org.ahyc.eai.demo.core.socket.IWebSocketConsole;
import org.ahyc.eai.demo.service.earth.FEarthServlet;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;

//============================================================
// <T>日志处理。</T>
//============================================================
@ServerEndpoint(value = "/sphere", encoders = {FLoggerEncoder.class})
public class FSphereServlet
      extends FObject
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FSphereServlet.class);

   // 日志输出接口
   private static String GROUP_NAME = "sphere";

   // 演示控制台
   protected IWebSocketConsole _console;

   // 演示控制台
   protected IEaiInputConsole _inputConsole;

   //============================================================
   // <T>消息处理。</T>
   //
   // @param session 会话处理
   // @param message 消息内容
   //============================================================
   @OnOpen
   public void onOpen(Session session,
                      EndpointConfig config){
      if(_console == null){
         _console = RAop.find(IWebSocketConsole.class);
         _inputConsole = RAop.find(IEaiInputConsole.class);
      }
      _console.open(GROUP_NAME, session);
   }

   //============================================================
   // <T>消息处理。</T>
   //
   // @param session 会话处理
   // @param message 消息内容
   //============================================================
   @OnMessage
   public void onMessage(String message,
                         Session session){
      _console.sendMessage(FEarthServlet.GROUP_NAME, message);
   }

   //============================================================
   // <T>消息处理。</T>
   //
   // @param session 会话处理
   // @param message 消息内容
   //============================================================
   @OnClose
   public void onClose(Session session,
                       CloseReason closeReason){
      _console.close(GROUP_NAME, session);
   }

   //============================================================
   // <T>消息处理。</T>
   //
   // @param session 会话处理
   // @param message 消息内容
   //============================================================
   @OnError
   public void onError(Session session,
                       Throwable throwable){
      _logger.error(this, "onError", throwable);
   }
}
