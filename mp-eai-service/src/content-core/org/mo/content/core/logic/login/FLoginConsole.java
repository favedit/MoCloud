package org.mo.content.core.logic.login;

import com.cyou.gccloud.data.data.FDataPersonUserEntryLogic;
import com.cyou.gccloud.data.data.FDataPersonUserEntryUnit;
import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.define.enums.core.EGcAuthorityResult;
import com.cyou.gccloud.define.enums.core.EGcPersonUserFrom;
import org.mo.com.data.FSql;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.service.info.mobile.FMobileService;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.data.person.user.IDataPersonAccessAuthorityConsole;
import org.mo.eai.logic.logger.person.user.FLoggerPersonUserAccess;
import org.mo.eai.logic.logger.person.user.ILoggerPersonUserAccessConsole;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>登录控制台。</T>
//============================================================
public class FLoginConsole
      extends FObject
      implements
         ILoginConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMobileService.class);

   //用户添加日志控制台
   @ALink
   protected ILoggerPersonUserAccessConsole _loggerPersonUserAccessConsole;

   //用户访问控制台
   @ALink
   IDataPersonAccessAuthorityConsole _dataPersonAccessAuthorityConsole;

   //============================================================
   // <T>构造资源</T>
   //============================================================
   public FLoginConsole(){

   }

   //============================================================
   //
   // @param context 页面环境
   // @param passport 用户名
   // @param password 密码
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public FDataPersonUserUnit login(IWebContext context,
                                    String passport,
                                    String password,
                                    ILogicContext logicContext,
                                    IWebSession sessionContext){
      int statusCd = _dataPersonAccessAuthorityConsole.doLogin(logicContext, passport, password);

      // 登录处理
      String message = null;
      String logggerMessage = null;
      String changePass = null;
      int from = 0;
      switch(statusCd){
         case EGcAuthorityResult.Success:
            changePass = "white-user:" + passport;
            from = EGcPersonUserFrom.EaiHost;
            logggerMessage = "mobile:登录成功。";
            break;
         case EGcAuthorityResult.PassportInvalid:
            logggerMessage = "mobile:账号不存在。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.PasswordInvalid:
            logggerMessage = "mobile:密码错误。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.DateInvalid:
            message = "时间已失效。";
            break;
         case EGcAuthorityResult.OaSuccess:
            changePass = "oa:" + passport;
            from = EGcPersonUserFrom.EaiOa;
            logggerMessage = "mobile:OA登录成功。";
            break;
         case EGcAuthorityResult.OaPasswordInvald:
            logggerMessage = "mobile:OA用户或密码错误。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.OaHostInvalid:
            logggerMessage = "mobile:OA主机非法。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.PassportIllegal:
            logggerMessage = "mobile:用户名非法特殊字符。";
            message = "用户名非法或含有特殊字符。";
            break;
         case EGcAuthorityResult.PasswordIllegal:
            logggerMessage = "mobile:密码非法特殊字符。";
            message = "密码非法或含有特殊字符。";
            break;
         case EGcAuthorityResult.PasswordLengthFail:
            logggerMessage = "mobile:密码长度小于6位。";
            message = "密码长度小于6位。";
            break;
      }
      _logger.info(this, "login", "User login. (passport={1}, message={1})", passport, logggerMessage);
      //如果登录成功,同步数据
      FDataPersonUserUnit backUser = null;
      if((statusCd == EGcAuthorityResult.Success) || (statusCd == EGcAuthorityResult.OaSuccess)){
         backUser = synchronizeData(logicContext, new FDataPersonUserUnit(), from, changePass);
      }
      // 增加日志
      FLoggerPersonUserAccess logger = _loggerPersonUserAccessConsole.doPrepare(logicContext);
      logger.setUserId(1);
      logger.setLogicMessage(logggerMessage);
      logger.setPassport(RString.left(passport, 40));
      logger.setPassword(RString.left(password, 40));
      logger.setBrowserUri(context.requestUrl());
      logger.setPageInfo(context.parameters().dump());
      _loggerPersonUserAccessConsole.doInsert(logicContext, logger);
      // 会话管理
      //      FGcWebSession session = (FGcWebSession)sessionContext;
      if(backUser == null){
         backUser = new FDataPersonUserUnit();
         backUser.setStatusCd(statusCd);
      }
      return backUser;
   }

   //============================================================
   //
   // @param logicContext 逻辑上下文
   // @param backUser oa接口返回的用户
   // @param from 是通过什么身份登录的系统
   // @param changePass  以何种身份登录的用户名
   //============================================================
   @Override
   public FDataPersonUserUnit synchronizeData(ILogicContext logicContext,
                                              FDataPersonUserUnit backUser,
                                              int from,
                                              String changePass){
      //创建一个零时用户
      FDataPersonUserUnit tempUserUnit = new FDataPersonUserUnit();
      tempUserUnit.setStatusCd(backUser.statusCd());
      tempUserUnit.setPassport(changePass);
      tempUserUnit.setPassword(backUser.password());
      tempUserUnit.setGuid("A860A0BCF8CD42EBBF696A86E749295D");
      //      userUnit.setLabel(value);
      FDataPersonUserLogic userLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      FDataPersonUserUnit findUserByGuid = userLogic.findByGuid(tempUserUnit.guid());

      FDataPersonUserEntryLogic userEntryLogic = logicContext.findLogic(FDataPersonUserEntryLogic.class);

      if(findUserByGuid == null){
         userLogic.doInsert(tempUserUnit);
         //同步用户状态
         FDataPersonUserEntryUnit userEntryUnit = new FDataPersonUserEntryUnit();
         userEntryUnit.setOvld(true);
         userEntryUnit.setUserId(tempUserUnit.ouid());
         userEntryUnit.setStatusCd(tempUserUnit.statusCd());
         userEntryUnit.setFromCd(from);
         userEntryLogic.doInsert(userEntryUnit);
      }else{
         userLogic.doUpdate(findUserByGuid);
         //同步更新用户状态
         FSql whereSql = new FSql();
         whereSql.append(FDataPersonUserEntryLogic.USER_ID);
         whereSql.append("=");
         whereSql.append(findUserByGuid.ouid());
         FLogicDataset<FDataPersonUserEntryUnit> updateUserEntryUnits = userEntryLogic.fetch(whereSql);
         if(updateUserEntryUnits != null && updateUserEntryUnits.count() > 0){
            FDataPersonUserEntryUnit first = updateUserEntryUnits.first();
            first.setOvld(false);
            first.setUserId(findUserByGuid.ouid());
            first.setStatusCd(tempUserUnit.statusCd());
            first.setFromCd(from);
            userEntryLogic.doUpdate(first);
         }
      }
      return tempUserUnit;
   }

   //============================================================
   //注销
   // @param context 页面环境
   // @param passport 用户名
   // @param password 密码
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public FDataPersonUserUnit logout(IWebContext context,
                                     String passport,
                                     String password,
                                     ILogicContext logicContext,
                                     IWebSession sessionContext){
      return null;
   }

   //============================================================
   //根据guid查询用户
   // @param context 页面环境
   // @param passport 用户名
   // @param password 密码
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public FDataPersonUserUnit query(IWebContext context,
                                    String userGuid,
                                    ILogicContext logicContext,
                                    IWebSession sessionContext){
      FDataPersonUserLogic userLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      FDataPersonUserUnit findUserByGuid = userLogic.findByGuid(userGuid);
      if(findUserByGuid == null){
         findUserByGuid = new FDataPersonUserUnit();
         findUserByGuid.setStatusCd(-1);
         return findUserByGuid;
      }else{
         return findUserByGuid;
      }
   }

   //============================================================
   // 更新用户
   // @param context 页面环境
   // @param passport 用户名
   // @param password 密码
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public FDataPersonUserUnit update(IWebContext context,
                                     FDataPersonUserUnit unit,
                                     ILogicContext logicContext,
                                     IWebSession sessionContext){
      FDataPersonUserLogic userLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      FDataPersonUserUnit findUserByGuid = userLogic.findByGuid(unit.guid());
      if(findUserByGuid == null){
         findUserByGuid = new FDataPersonUserUnit();
         findUserByGuid.setStatusCd(-1);
         return findUserByGuid;
      }else{
         //先查找出来再更新标签
         findUserByGuid.setLabel(unit.label());
         userLogic.doUpdate(findUserByGuid);
         return findUserByGuid;
      }
   }
}
