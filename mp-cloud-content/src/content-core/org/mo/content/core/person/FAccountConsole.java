package org.mo.content.core.person;

import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.cloud.logic.system.IGcSessionConsole;

import org.mo.cloud.logic.person.FGcUserConsole;
import org.mo.cloud.logic.person.FGcUserInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台。</T>
//============================================================
public class FAccountConsole
      extends FGcUserConsole
      implements
         IAccountConsole
{
   // 会话控制台
   @ALink
   protected IGcSessionConsole _sessionConsole;

   //============================================================
   // <T>注册用户处理。</T>
   //
   // @param context 逻辑环境
   // @param info 容器
   // @return 处理结果
   //============================================================
   @Override
   public EResult doRegister(ILogicContext context,
                             FGcUserInfo user){
      return doInsert(context, user);
   }

   //============================================================
   // <T>用户登录处理。</T>
   //
   // @param context 逻辑环境
   // @param passport 账号
   // @param password 密码
   // @return 用户信息
   //============================================================
   @Override
   public FGcUserInfo doLogin(ILogicContext context,
                              String passport,
                              String password){
      // 获得用户是否存在
      FGcUserInfo user = findByPassport(context, passport);
      if(user == null){
         throw new FFatalError("User is not exists.");
      }
      // 检查密码是否相等
      if(!password.equals(user.passport())){
         throw new FFatalError("User password is invalid.");
      }
      // 打开用户会话
      long userId = user.ouid();
      FGcSessionInfo session = _sessionConsole.open(context, userId, 0);
      user.setSessionGuid(session.guid());
      return user;
   }
}
