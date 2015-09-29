package org.mo.content.core.logic.login;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<T>d登录控制台接口。</T>
//============================================================
public interface ILoginConsole
{
   //============================================================
   //
   // @param context 页面环境
   // @param passport 用户名
   // @param password 密码
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   public FDataPersonUserUnit login(IWebContext context,
                                    String passport,
                                    String password,
                                    ILogicContext logicContext,
                                    IWebSession sessionContext);

   public FDataPersonUserUnit synchronizeData(ILogicContext logicContext,
                                              FDataPersonUserUnit backUser,
                                              int from,
                                              String changePass);

   public FDataPersonUserUnit logout(IWebContext context,
                                     String passport,
                                     String password,
                                     ILogicContext logicContext,
                                     IWebSession sessionContext);

   public FDataPersonUserUnit query(IWebContext context,
                                    String userGuid,
                                    ILogicContext logicContext,
                                    IWebSession sessionContext);

   public FDataPersonUserUnit update(IWebContext context,
                                     FDataPersonUserUnit unit,
                                     ILogicContext logicContext,
                                     IWebSession sessionContext);
}
