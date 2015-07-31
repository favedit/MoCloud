package org.mo.eai.logic.data.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityLogic;
import com.cyou.gccloud.define.enums.core.EGcAuthorityAccess;
import com.cyou.gccloud.define.enums.core.EGcAuthorityResult;
import com.cyou.gccloud.define.enums.core.EGcAuthorityType;
import com.ycjt.ead.ThreeDes;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>数据人员访问授权信息控制台。</T>
//============================================================
public class FDataPersonAccessAuthorityConsole
      extends FAbstractLogicUnitConsole<FDataPersonAccessAuthorityLogic, FDataPersonAccessAuthority>
      implements
         IDataPersonAccessAuthorityConsole
{
   private static ILogger _logger = RLogger.find(FDataPersonAccessAuthorityConsole.class);

   @AProperty
   protected boolean _oaLoginEnable;

   @AProperty
   protected String _oaLoginUrl;

   //============================================================
   // <T>构造数据人员访问授权信息控制台。</T>
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
      if(RString.isEmpty(hostAddress)){
         return null;
      }
      String whereSql = FDataPersonAccessAuthorityLogic.HOST_ADDRESS + "='" + RSql.formatValue(hostAddress) + "'";
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
      String whereSql = FDataPersonAccessAuthorityLogic.PASSPORT + "='" + RSql.formatValue(passport) + "'";
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
      //............................................................
      // 根据账号密码检查设置
      FDataPersonAccessAuthority passportAuthority = findByPassport(logicContext, passport);
      if(passportAuthority == null){
         if(_oaLoginEnable){
            // OA用户检测
            String oaLoginResult = ROALoginUnit.oaLogin(_oaLoginUrl, passport, password);
            _logger.debug(this, "doLogin", "OA login. (passport={1}, result={2})", passport, oaLoginResult);
            // 0:验证成功，1:签名不通过，3:用户名或密码错误，98:IP不在白名单中
            if(oaLoginResult.equals("0")){
               return EGcAuthorityResult.OaSuccess;
            }else if(oaLoginResult.equals("3")){
               return EGcAuthorityResult.OaPasswordInvald;
            }else if(oaLoginResult.equals("98")){
               return EGcAuthorityResult.OaHostInvalid;
            }
         }
         return EGcAuthorityResult.PassportInvalid;
      }
      // 检查密码
      if(!password.equals(passportAuthority.password())){
         return EGcAuthorityResult.PasswordInvalid;
      }
      // 检查权限
      if(passportAuthority.accessCd() != EGcAuthorityAccess.Allow){
         return EGcAuthorityResult.PasswordInvalid;
      }
      // 检查类型
      int typeCd = passportAuthority.typeCd();
      if(typeCd == EGcAuthorityType.Permanent){
         return EGcAuthorityResult.Success;
      }else if(typeCd == EGcAuthorityType.Temporary){
         long current = RDateTime.currentDateTime().get();
         long begin = passportAuthority.beginDate().get();
         long end = passportAuthority.endDate().get();
         _logger.debug(this, "doLogin", "Date span check. (current={1}, begin={2}, end={3})", current, begin, end);
         if((current >= begin) && (current < end)){
            return EGcAuthorityResult.Success;
         }else{
            return EGcAuthorityResult.DateInvalid;
         }
      }else{
         throw new FFatalError("Invalid type.");
      }
   }

   //============================================================
   // <T>根据OA账号信息登录。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 登录账号
   // @param password 登录密码
   // @return 登录结果
   //============================================================
   @Override
   public String oaLogin(ILogicContext logicContext,
                         String passport,
                         String password){
      String oaLoginResult = ROALoginUnit.oaLogin(_oaLoginUrl, passport, password);
      _logger.debug(this, "doLogin", "OA login. (passport={1}, result={2})", passport, oaLoginResult);
      return oaLoginResult;
   }
}
