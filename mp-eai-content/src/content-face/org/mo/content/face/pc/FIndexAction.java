package org.mo.content.face.pc;

import com.cyou.gccloud.data.data.FDataControlModuleUnit;
import com.cyou.gccloud.data.data.FDataControlRoleModuleUnit;
import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import com.cyou.gccloud.data.data.FDataPersonUserEntryUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.define.enums.core.EGcAuthorityAccess;
import com.cyou.gccloud.define.enums.core.EGcAuthorityResult;
import com.cyou.gccloud.define.enums.core.EGcPersonUserFrom;
import com.cyou.gccloud.define.enums.core.EGcPersonUserStatus;
import org.mo.com.lang.RString;
import org.mo.content.core.common.EChartPage;
import org.mo.content.core.manage.person.module.IModuleConsole;
import org.mo.content.core.manage.person.role.IRoleConsole;
import org.mo.content.core.manage.person.role.IRoleModuleConsole;
import org.mo.content.core.manage.person.user.IEntryConsole;
import org.mo.content.core.manage.person.user.IUserConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.data.person.user.FDataPersonAccessAuthority;
import org.mo.eai.logic.data.person.user.IDataPersonAccessAuthorityConsole;
import org.mo.eai.logic.logger.person.user.FLoggerPersonUserAccess;
import org.mo.eai.logic.logger.person.user.ILoggerPersonUserAccessConsole;
import org.mo.eai.logic.service.info.ILogicServiceInfoConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>首页。</P>
//
// @author maocy
// @version 150427
//============================================================
public class FIndexAction
      implements
         IIndexAction
{
   @ALink
   protected IDataPersonAccessAuthorityConsole _personAccessAuthorityConsole;

   @ALink
   protected ILoggerPersonUserAccessConsole _loggerPersonUserAccessConsole;

   @ALink
   protected ILogicServiceInfoConsole _loggerServiceInfoConsole;

   @ALink
   protected IUserConsole _userConsole;

   @ALink
   protected IRoleConsole _roleConsole;

   //模块控制台
   @ALink
   protected IModuleConsole _moduleConsole;

   //角色模块控制台
   @ALink
   protected IRoleModuleConsole _roleModuleConsole;

   @ALink
   protected IEntryConsole _entryConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FIndexPage page){
      // 清空参数
      page.setPassport(null);
      page.setPassword(null);
      page.setMessage(null);
      // 获得参数
      String hostAddress = context.head("x-real-ip");
      if(RString.isEmpty(hostAddress)){
         hostAddress = context.head("x-forwarded-for");
         if(RString.isEmpty(hostAddress)){
            hostAddress = context.remoteAddress();
         }
      }
      page.setHost(hostAddress);
      // 登录处理
      FDataPersonAccessAuthority authority = _personAccessAuthorityConsole.findByHostAddress(logicContext, hostAddress);
      if(authority != null){
         int accessCd = authority.accessCd();
         if(accessCd == EGcAuthorityAccess.Allow){
            // 增加日志
            FLoggerPersonUserAccess logger = _loggerPersonUserAccessConsole.doPrepare(logicContext);
            logger.setHostAddress(hostAddress);
            logger.setLogicMessage("主机地址为白名单。");
            _loggerPersonUserAccessConsole.doInsert(logicContext, logger);
            // 设置服务主机
            return "/pc/main";
         }
      }
      // 非法设置
      return "Login";
   }

   //============================================================
   // <T>登录逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String login(IWebContext context,
                       ILogicContext logicContext,
                       FIndexPage page){
      // 获得参数
      String passport = RString.trim(page.passport());
      String password = RString.trim(page.password());
      String hostAddress = context.head("x-real-ip");
      if(RString.isEmpty(hostAddress)){
         hostAddress = context.head("x-forwarded-for");
         if(RString.isEmpty(hostAddress)){
            hostAddress = context.remoteAddress();
         }
      }
      // 登录处理
      String message = null;
      String logggerMessage = null;
      int resultCd = _personAccessAuthorityConsole.doLogin(logicContext, hostAddress, passport, password);
      switch(resultCd){
         case EGcAuthorityResult.Success:
            passport = "host_" + passport;
            synchronizeData(logicContext, page, passport);
            logggerMessage = "登录成功。";
            break;
         case EGcAuthorityResult.PassportInvalid:
            logggerMessage = "账号不存在。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.PasswordInvalid:
            logggerMessage = "密码错误。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.DateInvalid:
            message = "时间已失效。";
            break;
         case EGcAuthorityResult.OaSuccess:
            passport = "oa_" + passport;
            synchronizeData(logicContext, page, passport);
            logggerMessage = "OA登录成功。";
            break;
         case EGcAuthorityResult.OaPasswordInvald:
            logggerMessage = "OA用户或密码错误。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.OaHostInvalid:
            logggerMessage = "OA主机非法。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.PassportIllegal:
            logggerMessage = "用户名非法特殊字符。";
            message = "用户名非法或含有特殊字符。";
            break;
         case EGcAuthorityResult.PasswordIllegal:
            logggerMessage = "密码非法特殊字符。";
            message = "密码非法或含有特殊字符。";
            break;
      }
      // 增加日志
      FLoggerPersonUserAccess logger = _loggerPersonUserAccessConsole.doPrepare(logicContext);
      logger.setHostAddress(hostAddress);
      logger.setLogicMessage(logggerMessage);
      logger.setPassport(RString.left(passport, 40));
      logger.setPassword(RString.left(password, 40));
      logger.setBrowserUri(context.requestUrl());
      logger.setPageInfo(context.parameters().dump());
      _loggerPersonUserAccessConsole.doInsert(logicContext, logger);
      // 画面跳转
      if((resultCd == EGcAuthorityResult.Success) || (resultCd == EGcAuthorityResult.OaSuccess)){
         page.setPassport(passport.substring(passport.indexOf("_") + 1, passport.length()));
         return "/pc/main";
      }else{
         page.setMessage(message);
         return "Login";
      }
   }

   //============================================================
   // <T>表格逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String chart(IWebContext context,
                       ILogicContext logicContext,
                       FIndexPage page){
      String code = context.parameter("code");
      page.setServiceLogic(_loggerServiceInfoConsole.serviceLogic());
      page.setSceneCode(code);
      return EChartPage.Scene;
   }

   @Override
   public String loginOut(IWebContext context,
                          ILogicContext logicContext,
                          FIndexPage page){
      return "Login";
   }

   //============================================================
   // <T>登录成功后，用户信息同步。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 账户
   //============================================================
   private void synchronizeData(ILogicContext logicContext,
                                FIndexPage page,
                                String passport){
      FDataPersonUserUnit user = _userConsole.findByPassport(logicContext, passport);
      if(user == null){
         //获取角色
         FDataControlRoleUnit role = _roleConsole.findByCode(logicContext, "eai.oa");
         if(role != null){
            //同步OA用户
            FDataPersonUserUnit unit = new FDataPersonUserUnit();
            unit.setPassport(passport);
            unit.setRoleId(role.ouid());
            unit.setOvld(true);
            _userConsole.doInsert(logicContext, unit);
            //同步用户状态
            FDataPersonUserEntryUnit entryUnit = new FDataPersonUserEntryUnit();
            entryUnit.setOvld(true);
            entryUnit.setUserId(unit.ouid());
            entryUnit.setStatusCd(EGcPersonUserStatus.Normal);
            entryUnit.setFromCd(EGcPersonUserFrom.EaiOa);
            _entryConsole.doInsert(logicContext, entryUnit);
            tackAuthority(logicContext, page, unit.ouid());
         }
      }else{
         tackAuthority(logicContext, page, user.roleId());
      }
   }

   //============================================================
   // <T>获取管理权限。</T>
   //
   // @param logicContext 环境
   // @param page 容器
   // @param roleid 角色编号
   //============================================================
   private void tackAuthority(ILogicContext logicContext,
                              FIndexPage page,
                              long roleid){
      StringBuffer menuStrings = new StringBuffer();
      long roleId = roleid;
      if(roleId != 0){
         FLogicDataset<FDataControlRoleModuleUnit> roelModuleInfoList = _roleModuleConsole.selectDataByRoleIdAndModuleId(logicContext, roleId, 0);
         for(FDataControlRoleModuleUnit role : roelModuleInfoList){
            FDataControlModuleUnit module = _moduleConsole.find(logicContext, role.moduleId());
            if(module != null){
               menuStrings.append(module.code()).append("|");
            }
         }
         page.setMenuString(menuStrings.deleteCharAt(menuStrings.length() - 1).toString());
      }else{
         page.setMenuString(null);
      }
   }

}
