package org.mo.content.core.logic.version;

import java.util.HashMap;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<T>版本更新控制台接口。</T>
//============================================================
public interface IVersionConsole
{
   //============================================================
   // @连接服务器获得新版本
   // @param context 页面环境
   // @param versionStr 版本号
   // @param applicationStr 应用程序id
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   public HashMap<String, Object> connect(IWebContext context,
                                          String versionStr,
                                          String applicationStr,
                                          ILogicContext logicContext,
                                          IWebSession sessionContext);

   //============================================================
   // @断开与服务器的连接
   // @param context 页面环境
   // @param sessionCode 会话码
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   public EResult disconnect(IWebContext context,
                             String sessionCode,
                             ILogicContext logicContext,
                             IWebSession sessionContext,
                             IWebSessionConsole _sessionConsole);
}
