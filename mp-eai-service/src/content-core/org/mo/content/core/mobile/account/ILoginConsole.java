package org.mo.content.core.mobile.account;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
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

   //============================================================
   // <T>请求OA登录接口</T>
   //
   // @param url 接口链接
   // @param passport 用户名
   // @param password 密码
   // @return 登录结果（0：验证成功，1：签名不通过，2：参数不完整，3：用户名或密码错误，98：IP不在白名单中，99：系统异常）
   //============================================================
   public String oaLogin(String passport,
                         String password);

   public FDataPersonUserUnit synchronizeData(ILogicContext logicContext,
                                              FDataPersonUserUnit backUser,
                                              int from,
                                              String changePass);

   public FDataPersonUserUnit logout(IWebContext context,
                                     String sessionId,
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

   public FDataPersonUserInfo getUserInfo(long user_id,
                                          ILogicContext logicContext);

   public FDataSystemApplicationUnit getApplicationUnitByGuid(ILogicContext logicContext,
                                                              String applicationGuid);
}
