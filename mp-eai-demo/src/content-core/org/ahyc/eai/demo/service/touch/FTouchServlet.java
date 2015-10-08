package org.ahyc.eai.demo.service.touch;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.ahyc.eai.demo.core.socket.IWebSocketConsole;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;

//============================================================
// <T>触摸处理。</T>
//============================================================
@ServerEndpoint(value = "/touch", encoders = {FLoggerEncoder.class})
public class FTouchServlet
      extends FObject
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FTouchServlet.class);

   // 日志输出接口
   public static String GROUP_NAME = "touch";

   // 演示控制台
   protected IWebSocketConsole _console;

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
      }
      _console.open(GROUP_NAME, session);
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
