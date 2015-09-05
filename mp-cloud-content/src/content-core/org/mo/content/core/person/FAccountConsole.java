package org.mo.content.core.person;

import org.mo.cloud.logic.data.person.FGcUserConsole;
import org.mo.cloud.logic.data.person.FGcUserInfo;
import org.mo.cloud.logic.data.person.IGcUserConsole;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.encoding.RSha1;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
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

   // 用户控制台
   @ALink
   protected IGcUserConsole _userConsole;

   //============================================================
   // <T>注册用户处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param info 容器
   // @return 处理结果
   //============================================================
   @Override
   public EResult doRegister(ILogicContext logicContext,
                             FGcUserInfo user){
      // 检查参数
      String passport = user.passport();
      if(RString.isEmpty(passport)){
         throw new FFatalError("User passport is empty.");
      }
      String password = user.password();
      if(RString.isEmpty(password)){
         throw new FFatalError("User password is empty.");
      }
      String label = user.label();
      if(RString.isEmpty(label)){
         throw new FFatalError("User label is empty.");
      }
      // 检查用户存在性
      FGcUserInfo findUser = _userConsole.findByPassport(logicContext, passport);
      if(findUser != null){
         throw new FFatalError("User is already exists. (passport={1})", passport);
      }
      // 新建用户
      String encodePassword = RSha1.encode(user.password());
      FGcUserInfo insertUser = doPrepare(logicContext);
      insertUser.setPassport(passport);
      insertUser.setPassword(encodePassword);
      insertUser.setLabel(label);
      EResult resultCd = doInsert(logicContext, insertUser);
      return resultCd;
   }

   //============================================================
   // <T>用户登录处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 账号
   // @param password 密码
   // @param fromCd 来源方式
   // @return 用户信息
   //============================================================
   @Override
   public FGcUserInfo doLogin(ILogicContext logicContext,
                              String passport,
                              String password,
                              int fromCd){
      // 检查参数
      if(RString.isEmpty(passport)){
         throw new FFatalError("User passport is empty.");
      }
      if(RString.isEmpty(password)){
         throw new FFatalError("User password is empty.");
      }
      String encodePassword = RSha1.encode(password);
      // 获得用户是否存在
      FGcUserInfo user = findByPassport(logicContext, passport);
      if(user == null){
         throw new FFatalError("User is not exists.");
      }
      // 检查密码是否相等
      if(!encodePassword.equals(user.password())){
         throw new FFatalError("User password is invalid.");
      }
      // 打开用户会话
      //      long userId = user.ouid();
      //      FGcSessionInfo session = _sessionConsole.open(logicContext, userId, fromCd);
      //      user.setSessionGuid(session.guid());
      return user;
   }
}
