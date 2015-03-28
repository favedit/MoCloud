package org.mo.content.core.person;

import com.cyou.gccloud.logic.person.FGcUserInfo;
import com.cyou.gccloud.logic.person.IGcUserConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台接口。</T>
//============================================================
public interface IAccountConsole
      extends
         IGcUserConsole
{
   //============================================================
   // <T>用户注册处理。</T>
   //
   // @param context 逻辑环境
   // @param info 容器
   // @return 处理结果
   //============================================================
   EResult doRegister(ILogicContext context,
                      FGcUserInfo user);

   //============================================================
   // <T>用户登录处理。</T>
   //
   // @param context 逻辑环境
   // @param passport 账号
   // @param password 密码
   // @return 用户信息
   //============================================================
   FGcUserInfo doLogin(ILogicContext context,
                       String passport,
                       String password);
}
