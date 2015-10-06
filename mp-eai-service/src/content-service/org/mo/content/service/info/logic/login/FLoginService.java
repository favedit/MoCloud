package org.mo.content.service.info.logic.login;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.define.enums.core.EGcAuthorityResult;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.logic.login.ILoginConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>新闻服务。</T>
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

   //session会话控制台
   @ALink
   protected IWebSessionConsole _sessionConsole;

   //============================================================
   // <T>默认逻辑。</T>
   //
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
   //
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
      FXmlNode passportNode = inputNode.findNode("passport");
      FXmlNode passwordNode = inputNode.findNode("password");
      FXmlNode sessionId = output.config().createNode("sessionId");
      FXmlNode status_cd = output.config().createNode("status_cd");
      FXmlNode user_id = output.config().createNode("user_id");
      FXmlNode passportNodeOut = output.config().createNode("label");
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
      //      String cookie = context.parameter("saveCookie");
      _logger.debug(this, "login_user*****************", "username={1},password={2}", passport, password);
      FDataPersonUserUnit user = _loginConsole.login(context, passport, password, logicContext, sessionContext);
      _logger.debug(this, "login_*****************------>status_cd", "status_cd={1}", user.statusCd());
      //如果OA登录成功  oa那边接口返回的是0
      if(user.statusCd() == EGcAuthorityResult.OaSuccess){
         //如果登录成功,,返回一个sessionId
         sessionId.setText("er45hgjh768909jh546567pklh");
         status_cd.setText(user.statusCd());
         user_id.setText(user.guid());
         //         xruntime.set("gender_cd", "psn_user没有性别字段");
         passportNodeOut.setText(user.passport());
         // 会话管理
         //         FGcWebSession session = (FGcWebSession)sessionContext;
         //         session.setUserId(user.ouid());
         //         _sessionConsole.open(session);

         return EResult.Success;
      }else{
         status_cd.setText(user.statusCd());
         return EResult.Failure;
      }
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
      _logger.debug(this, "logout", "logout begin. ");
      // 获得参数
      FXmlNode inputNode = input.config();
      FXmlNode userNode = inputNode.findNode("SessionCode");
      String sessionCode = userNode.text();
      FXmlNode xruntime = output.config();
      FDataPersonUserUnit user = _loginConsole.logout(context, sessionCode, logicContext, sessionContext);
      //如果返回-1意味着根据guid没有找到用户
      if(user.statusCd() == -1){
         //         xruntime.set("status_cd", user.statusCd());
         xruntime.set("info", "没有找到对应的用户!");
         return EResult.Failure;
      }else{
         //         xruntime.set("status_cd", user.statusCd());
         return EResult.Success;
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
      FXmlNode xruntime = output.config();
      _logger.debug(this, "*****************feedback", "SysAppCode={1},Version={2},Content={3}", sysAppCode, version, content);
      return EResult.Success;
   }

}
