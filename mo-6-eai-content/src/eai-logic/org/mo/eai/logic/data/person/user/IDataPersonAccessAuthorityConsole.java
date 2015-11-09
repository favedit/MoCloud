package org.mo.eai.logic.data.person.user;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>数据人员访问授权信息控制台接口。</T>
//============================================================
public interface IDataPersonAccessAuthorityConsole
      extends
         IAbstractLogicUnitConsole<FDataPersonAccessAuthority>
{
   //============================================================
   // <T>根据主机地址查找授权信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param hostAddress 网络地址
   // @return 授权信息
   //============================================================
   FDataPersonAccessAuthority findByHostAddress(ILogicContext logicContext,
                                                String hostAddress);

   //============================================================
   // <T>根据登录账号信息查找授权信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 登录账号
   // @return 授权信息
   //============================================================
   FDataPersonAccessAuthority findByPassport(ILogicContext logicContext,
                                             String passport);

   //============================================================
   // <T>根据登录账号信息登录。</T>
   //
   // @param logicContext 逻辑环境
   // @param hostAddress 主机地址
   // @param passport 登录账号
   // @param password 登录密码
   // @return 登录结果
   //============================================================
   int doLogin(ILogicContext logicContext,
               String passport,
               String password);

   //============================================================
   // <T>请求OA登录接口</T>
   //
   // @param url 接口链接
   // @param passport 用户名
   // @param password 密码
   // @return 登录结果（0：验证成功，1：签名不通过，2：参数不完整，3：用户名或密码错误，98：IP不在白名单中，99：系统异常）
   //============================================================
   String oaLogin(String passport,
                  String password);

   //============================================================
   // <T>请求本系统服务器登录</T>
   //
   // @param url 接口链接
   // @param passport 用户名
   // @param password 密码
   // @return 登录结果（0：验证成功，3：用户名或密码错误，99：系统异常）
   //============================================================
   boolean entryLogin(ILogicContext logicContext,
                      String passport,
                      String password);
}
