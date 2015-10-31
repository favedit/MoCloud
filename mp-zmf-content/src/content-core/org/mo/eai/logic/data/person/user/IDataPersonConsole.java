package org.mo.eai.logic.data.person.user;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;

//============================================================
// <T>数据人员访问授权信息控制台接口。</T>
//============================================================
public interface IDataPersonConsole
      extends
         IAbstractLogicUnitConsole<FDataPersonAccessAuthority>
{

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
}
