package org.mo.eai.logic.data.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityLogic;
import com.cyou.gccloud.define.enums.core.EGcAuthorityAccess;
import com.cyou.gccloud.define.enums.core.EGcAuthorityResult;
import com.cyou.gccloud.define.enums.core.EGcAuthorityType;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>用户授权信息控制台。</T>
//============================================================
public class FDataPersonAccessAuthorityConsole
      extends FAbstractLogicUnitConsole<FDataPersonAccessAuthorityLogic, FDataPersonAccessAuthority>
      implements
         IDataPersonAccessAuthorityConsole
{
   //============================================================
   // <T>构造资源位图信息控制台。</T>
   //============================================================
   public FDataPersonAccessAuthorityConsole(){
      super(FDataPersonAccessAuthorityLogic.class, FDataPersonAccessAuthority.class);
   }

   //============================================================
   // <T>根据主机地址查找授权信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param hostAddress 网络地址
   // @return 授权信息
   //============================================================
   @Override
   public FDataPersonAccessAuthority findByHostAddress(ILogicContext logicContext,
                                                       String hostAddress){
      String whereSql = FDataPersonAccessAuthorityLogic.HOST_ADDRESS + "=" + RSql.formatValue(hostAddress) + "'";
      FDataPersonAccessAuthority authority = search(logicContext, whereSql);
      return authority;
   }

   //============================================================
   // <T>根据登录账号信息查找授权信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 登录账号
   // @return 授权信息
   //============================================================
   @Override
   public FDataPersonAccessAuthority findByPassport(ILogicContext logicContext,
                                                    String passport){
      String whereSql = FDataPersonAccessAuthorityLogic.PASSPORT + "=" + RSql.formatValue(passport) + "'";
      FDataPersonAccessAuthority authority = search(logicContext, whereSql);
      return authority;
   }

   //============================================================
   // <T>根据登录账号信息登录。</T>
   //
   // @param logicContext 逻辑环境
   // @param hostAddress 主机地址
   // @param passport 登录账号
   // @param password 登录密码
   // @return 登录结果
   //============================================================
   @Override
   public int doLogin(ILogicContext logicContext,
                      String hostAddress,
                      String passport,
                      String password){
      // 根据主机地址检查设置
      FDataPersonAccessAuthority hostAuthority = findByHostAddress(logicContext, hostAddress);
      if(hostAuthority != null){
         int accessCd = hostAuthority.accessCd();
         if(accessCd == EGcAuthorityAccess.Allow){
            return EGcAuthorityResult.Success;
         }
      }
      // 根据账号密码检查设置
      FDataPersonAccessAuthority passportAuthority = findByPassport(logicContext, passport);
      if(passportAuthority == null){
         return EGcAuthorityResult.PassportInvalid;
      }
      // 检查密码
      if(!password.equals(passportAuthority.password())){
         return EGcAuthorityResult.PasswordInvalid;
      }
      // 检查类型
      int typeCd = passportAuthority.typeCd();
      if(typeCd == EGcAuthorityType.Permanent){
         return EGcAuthorityResult.Success;
      }else if(typeCd == EGcAuthorityType.Temporary){
         long current = RDateTime.currentDate().get();
         long begin = passportAuthority.beginDate().get();
         long end = passportAuthority.endDate().get();
         if((current >= begin) && (current < end)){
            return EGcAuthorityResult.Success;
         }else{
            return EGcAuthorityResult.DateInvalid;
         }
      }else{
         throw new FFatalError("Invalid type.");
      }
   }
}
