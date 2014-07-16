package org.mo.web.protocol.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>会话内容变化监听类。</T>
// <P>会话内容变化时触发开始、结束事件</P>
//============================================================
public class FHttpSessionListener
      implements
         HttpSessionListener
{
   // 日志输出接口
   private ILogger _logger = RLogger.find(FHttpSessionListener.class);

   // 数量
   private static int _count = 0;

   //============================================================
   // <T>获得会话数量。</T>
   //
   // @return 会话数量
   //============================================================
   public static long sessionCount(){
      return _count;
   }

   //============================================================
   // <T>会话创建处理。</T>
   //
   // @param event 事件
   //============================================================
   @Override
   public void sessionCreated(HttpSessionEvent event){
      _count++;
      _logger.debug(this, "sessionCreated", "Session created({0}): {1}", _count, event.getSession().getId());
   }

   //============================================================
   // <T>会话销毁处理。</T>
   //
   // @param event 事件
   //============================================================
   @Override
   public void sessionDestroyed(HttpSessionEvent event){
      _count++;
      _logger.debug(this, "sessionDestroyed", "Session destroyed({0}): {1}", _count, event.getSession().getId());
   }
}
