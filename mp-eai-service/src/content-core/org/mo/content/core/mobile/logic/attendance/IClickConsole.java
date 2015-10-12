package org.mo.content.core.mobile.logic.attendance;

import com.cyou.gccloud.data.data.FDataPersonUserSigningUnit;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<T>版本更新控制台接口。</T>
//============================================================
public interface IClickConsole
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
   public EResult click(IWebContext context,
                        ILogicContext logicContext,
                        IWebSession sessionContext,
                        FDataPersonUserSigningUnit unit);

}
