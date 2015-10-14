package org.mo.content.service.mobile.account;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
import com.cyou.gccloud.define.enums.core.EGcAuthorityResult;
import java.util.UUID;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.mobile.account.FDataPersonUserInfo;
import org.mo.content.core.mobile.account.ILoginConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>登录服务。</T>
//============================================================
public class FLoginService
      extends FObject
      implements
         ILoginService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FLoginService.class);

   //登录逻辑控制台
   @ALink
   protected ILoginConsole _loginConsole;

   //GcSession会话控制台
   @ALink
   protected IGcSessionConsole _sessionConsole;

   //WebSession会话控制台
   @ALink
   protected IWebSessionConsole _webSessionConsole;

   //============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      _logger.debug(this, "process", "process begin. ");
      return EResult.Success;
   }

   //============================================================
   // @登录
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult login(IWebContext context,
                        IWebInput input,
                        IWebOutput output,
                        ILogicContext logicContext,
                        IWebSession sessionContext){
      _logger.debug(this, "login", "login begin. ");
      // 获得参数
      FXmlNode inputNode = input.config();
      FXmlNode inputApplicationNode = inputNode.findNode("appkey");
      String applicationStr = inputApplicationNode.text();
      FDataSystemApplicationUnit applicationUnit = _loginConsole.getApplicationUnitByGuid(logicContext, applicationStr);
      if(applicationUnit == null){
         output.config().createNode("error").setText("app_key is error!");
         return EResult.Failure;
      }
      FXmlNode passportNode = inputNode.findNode("passport");
      FXmlNode passwordNode = inputNode.findNode("password");
      String sessionStr = context.head("mo-session-id");
      clearSessionCode(sessionStr, sessionContext, logicContext);
      FXmlNode status_cd = output.config().createNode("status_cd");
      String passport = RString.trimRight(passportNode.text());
      String password = RString.trimRight(passwordNode.text());
      if(RString.isEmpty(passport) || passport.indexOf("'") > -1 || passport.indexOf("%") > -1 || passport.length() > 18 || passport.length() < 2){
         status_cd.setText(EGcAuthorityResult.PassportIllegal);
         return EResult.Failure;
      }
      if(RString.isEmpty(password) || password.indexOf("'") > -1 || password.indexOf("%") > -1 || password.indexOf(";") > -1 || password.length() > 32 || password.length() < 6){
         status_cd.setText(EGcAuthorityResult.PasswordIllegal);
         return EResult.Failure;
      }
      _logger.debug(this, "login_user*****************", "username={1},password={2}", passport, password);
      FDataPersonUserUnit user = _loginConsole.login(context, passport, password, logicContext, sessionContext);
      _logger.debug(this, "login_*****************------>status_cd", "status_cd={1}", user.statusCd());
      //如果OA登录成功  oa那边接口返回的是0
      if(sessionStr == null || "".equals(sessionStr)){
         sessionStr = UUID.randomUUID().toString().replaceAll("-", "");
      }
      if(user.statusCd() == EGcAuthorityResult.OaSuccess){
         FXmlNode sessionId = output.config().createNode("session_code");
         FXmlNode passportNodeOut = output.config().createNode("label");
         FXmlNode icon_url = output.config().createNode("user_icon");
         FXmlNode company = output.config().createNode("company");
         icon_url.setText("http://eai.ezubo.com:8080/mb/images/re.png");
         company.setText("智慧企业推进中心");
         //         last_sign_date.setText("20150910102023");
         status_cd.setText(user.statusCd());
         String userLabel = user.label();
         if(userLabel != null && (!"".equals(userLabel))){
            passportNodeOut.setText(userLabel);
         }else{
            passportNodeOut.setText("-1");

         }
         // 登录成功创建session
         FGcWebSession session = (FGcWebSession)sessionContext;
         session.setId(sessionStr);
         session.setUserId(user.ouid());
         session.setFromCode("mobile_" + applicationUnit.code());
         session.setApplicationId(applicationUnit.ouid());
         EResult sessionResult = _webSessionConsole.open(session);
         _logger.debug(this, "session_id*****************------>", "session_id={1},user_id={2},applicationUnit.ouid()={3}", session.id(), user.ouid(), applicationUnit.ouid());
         sessionId.setText(session.id());
         FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, "eai", "mobile_" + applicationUnit.code(), session.id());
         if(sessionInfo != null){
            FXmlNode modules = output.config().createNode("modules");
            String roleModules = sessionInfo.roleModules();
            if(roleModules != null && (!"".equals(roleModules))){
               modules.setText(roleModules);
            }else{
               modules.setText("-1");
            }
         }
         _logger.debug(this, "session_id*****************------>", "sessionResult={1}", sessionResult);

         //返回上一次的打卡时间和用户的个人信息
         FDataPersonUserInfo userInfo = _loginConsole.getUserInfo(user.ouid(), logicContext);
         if(userInfo != null){
            FXmlNode last_sign_date = output.config().createNode("last_sign_date");
            if(userInfo.last_sign_date() != null && (!"".equals(userInfo.last_sign_date()))){
               last_sign_date.setText(userInfo.last_sign_date());
            }else{
               last_sign_date.setText("-1");
            }
         }
         return EResult.Success;
      }else{
         status_cd.setText(user.statusCd());
         return EResult.Failure;
      }
   }

   //============================================================
   // @已经登录的用户自动登录
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult autoLogin(IWebContext context,
                            IWebInput input,
                            IWebOutput output,
                            ILogicContext logicContext,
                            IWebSession sessionContext){
      //      FXmlNode inputNode = input.config();
      String sessionCode = context.head("mo-session-id");
      if(sessionCode == null || "".equals(sessionCode)){
         FXmlNode status_cd = output.config().createNode("status_cd");
         status_cd.setText(EGcAuthorityResult.Unknown);
         return EResult.Failure;
      }
      //sessionCode不可以重复!!
      FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, sessionCode);
      //      FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(log`icContext, "eai", "mobile_android", sessionCode);
      _logger.debug(this, "autoLogin*****************mo_session_id---->", "mo_session_id={1}", sessionCode);
      if(sessionInfo == null){
         //session已经失效
         output.config().createNode("session_status").setText(0);
         return EResult.Success;
      }
      FXmlNode passportNodeOut = output.config().createNode("label");
      FXmlNode last_sign_date = output.config().createNode("last_sign_date");
      FXmlNode icon_url = output.config().createNode("user_icon");
      FXmlNode company = output.config().createNode("company");
      company.setText("智慧企业推进中心");
      //      last_sign_date.setText("20150910102023");
      //返回上一次的打卡时间和用户的个人信息
      FDataPersonUserInfo userInfo = _loginConsole.getUserInfo(sessionInfo.userId(), logicContext);
      String last_sign_date2 = userInfo.last_sign_date();
      if(last_sign_date2 != null && (!"".equals(last_sign_date2))){
         last_sign_date.setText(last_sign_date2);
      }else{
         last_sign_date.setText("-1");
      }
      FXmlNode modules = output.config().createNode("modules");
      if(sessionInfo != null){
         String roleModules = sessionInfo.roleModules();
         if(roleModules != null && (!"".equals(roleModules))){
            modules.setText(roleModules);
         }else{
            modules.setText("-1");
         }
      }
      icon_url.setText("http://eai.ezubo.com:8080/mb/images/re.png");
      String userLabel = sessionInfo.userLabel();
      if(userLabel != null && (!"".equals(userLabel))){
         passportNodeOut.setText(userLabel);
      }else{
         passportNodeOut.setText("-1");

      }
      return EResult.Success;
   }

   //============================================================
   // @用户注销
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult logout(IWebContext context,
                         IWebInput input,
                         IWebOutput output,
                         ILogicContext logicContext,
                         IWebSession sessionContext){
      // 获得参数
      String sessionCode = context.head("mo-session-id");
      if(sessionCode == null || "".equals(sessionCode)){
         FXmlNode status_cd = output.config().createNode("status_cd");
         status_cd.setText(EGcAuthorityResult.Unknown);
         return EResult.Failure;
      }
      FGcWebSession session = (FGcWebSession)sessionContext;
      session.setId(sessionCode);
      FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, sessionCode);
      //      FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, "eai", "mobile_android", sessionCode);
      //如果没找到,意味着已经注销
      if(sessionInfo == null){
         return EResult.Success;
      }
      session.loadInfo(sessionInfo);
      _logger.debug(this, "------------------------------------>logout", "sessionCode={1},session.recordId={2}", session.id(), session.recordId());
      _webSessionConsole.close(session);
      return EResult.Success;
   }

   //============================================================
   // @通过sessionCode清空session
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public void clearSessionCode(String sessionCode,
                                IWebSession sessionContext,
                                ILogicContext logicContext){
      // 获得参数
      FGcWebSession session = (FGcWebSession)sessionContext;
      session.setId(sessionCode);
      FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, sessionCode);
      if(sessionInfo != null){
         session.loadInfo(sessionInfo);
         _logger.debug(this, "------------------------------------>logout", "sessionCode={1},session.recordId={2}", session.id(), session.recordId());
         _webSessionConsole.close(session);
      }

   }

   //============================================================
   // @功能说明   根据用户guid查询用户信息
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        IWebInput input,
                        IWebOutput output,
                        ILogicContext logicContext,
                        IWebSession sessionContext){
      _logger.debug(this, "query", "query begin. ");
      // 获得参数
      FXmlNode inputNode = input.config();
      FXmlNode userNode = inputNode.findNode("sessionCode");
      String userGuid = userNode.text();
      FXmlNode xruntime = output.config().createNode("User");
      FDataPersonUserUnit user = _loginConsole.query(context, userGuid, logicContext, sessionContext);
      //如果返回-1意味着根据guid没有找到用户
      if(user.statusCd() == -1){
         xruntime.set("status_cd", user.statusCd());
         xruntime.set("info", "没有找到对应的用户!");
         return EResult.Failure;
      }else{
         //         xruntime.set("status_cd", user.statusCd());
         xruntime.set("user_id", user.guid());
         xruntime.set("passport", user.passport());
         xruntime.set("gender_cd", "have no gender!");
         return EResult.Success;
      }
   }

   //============================================================
   // @功能说明   根据用户guid更新用户信息
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult update(IWebContext context,
                         IWebInput input,
                         IWebOutput output,
                         ILogicContext logicContext,
                         IWebSession sessionContext){
      _logger.debug(this, "update", "update begin. ");
      // 获得参数
      FXmlNode inputNode = input.config();
      FXmlNode guidNode = inputNode.findNode("SessionCode");
      FXmlNode labelNode = inputNode.findNode("Label");
      String userGuid = guidNode.text();
      String userLabel = labelNode.text();
      FDataPersonUserUnit unit = new FDataPersonUserUnit();
      unit.setLabel(userLabel);
      unit.setGuid(userGuid);
      FXmlNode xruntime = output.config().createNode("User");
      FDataPersonUserUnit user = _loginConsole.update(context, unit, logicContext, sessionContext);
      //如果返回-1意味着根据guid没有找到用户
      if(user.statusCd() == -1){
         xruntime.set("status_cd", user.statusCd());
         xruntime.set("info", "没有找到对应的用户!");
         return EResult.Failure;
      }else{
         xruntime.set("user_id", user.guid());
         //         xruntime.set("gender_cd", "psn_user没有性别字段");
         xruntime.set("label", user.label());
         //         xruntime.set("status_cd", user.statusCd());
         return EResult.Success;
      }
   }

   //============================================================
   // @用户反馈
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult feedback(IWebContext context,
                           IWebInput input,
                           IWebOutput output,
                           ILogicContext logicContext,
                           IWebSession sessionContext){
      // 获得参数
      FXmlNode inputNode = input.config();
      FXmlNode sysAppCodeNode = inputNode.findNode("SysAppCode");
      FXmlNode versionNode = inputNode.findNode("Version");
      FXmlNode contentNode = inputNode.findNode("Content");
      String sysAppCode = sysAppCodeNode.text();
      String version = versionNode.text();
      String content = contentNode.text();
      _logger.debug(this, "*****************feedback", "SysAppCode={1},Version={2},Content={3}", sysAppCode, version, content);
      return EResult.Success;
   }

}
