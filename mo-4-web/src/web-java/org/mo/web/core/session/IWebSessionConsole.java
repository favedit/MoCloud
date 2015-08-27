package org.mo.web.core.session;

import org.mo.com.lang.EResult;
import org.mo.eng.session.ISessionConsole;

//============================================================
// <T>网络线程控制台接口。</T>
//============================================================
public interface IWebSessionConsole
      extends
         ISessionConsole
{
   //============================================================
   // <T>建立线程对象。</T>
   //
   // @param sessionId 线程标识
   // @return 线程对象
   //============================================================
   IWebSession build(String sessionId);

   //============================================================
   // <T>打开会话对象。</T>
   //
   // @param session 会话对象
   // @return 处理结果
   //============================================================
   EResult open(IWebSession session);

   //============================================================
   // <T>更新会话对象。</T>
   //
   // @param session 会话对象
   // @return 处理结果
   //============================================================
   EResult update(IWebSession session);

   //============================================================
   // <T>关闭会话对象。</T>
   //
   // @param session 会话对象
   // @return 处理结果
   //============================================================
   EResult close(IWebSession session);
}
