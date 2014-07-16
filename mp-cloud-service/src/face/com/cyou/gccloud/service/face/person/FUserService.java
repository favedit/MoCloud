package com.cyou.gccloud.service.face.person;

import com.cyou.gccloud.service.core.person.FUserInfo;
import com.cyou.gccloud.service.core.person.IUserConsole;
import com.cyou.gccloud.service.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.service.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.service.system.session.FSessionInfo;
import com.cyou.gccloud.service.system.session.ISessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.message.FErrorMessage;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>用户服务实现。</T>
//============================================================
public class FUserService
      extends FObject
      implements
         IUserService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FUserService.class);

   // 会话控制台
   @ALink
   protected ISessionConsole _sessionConsole;

   // 用户控制台
   @ALink
   protected IUserConsole _userConsole;

   //============================================================
   // <T>注册用户处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult register(IWebContext context,
                           ISqlContext sqlContext,
                           IWebInput input,
                           IWebOutput output){
      // 获得参数
      FXmlNode inputNode = input.config();
      String passport = inputNode.nodeText("Passport");
      String password = inputNode.nodeText("Password");
      String label = inputNode.nodeText("Label");
      String email = inputNode.nodeText("Email");
      // 设置数据
      FUserInfo info = new FUserInfo();
      info.setPassport(passport);
      info.setPassword(password);
      info.setLabel(label);
      info.setContactEmail(email);
      // 注册用户
      EResult resultCd = _userConsole.register(sqlContext, info);
      return resultCd;
   }

   //============================================================
   // <T>用户登录处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult login(IWebContext context,
                        ISqlContext sqlContext,
                        IWebInput input,
                        IWebOutput output){
      // 获得参数
      String passport = input.config().nodeText("Passport");
      String password = input.config().nodeText("Password");
      // 查找用户数据
      FDataPersonUserLogic userLogic = new FDataPersonUserLogic(sqlContext);
      FDataPersonUserUnit userUnit = userLogic.serach("PASSPORT='" + passport + "'");
      if(userUnit == null){
         context.messages().push(new FErrorMessage("Can't find user by passport. (passport={1})", passport));
         return EResult.Failure;
      }
      if(RString.isEmpty(password)){
         context.messages().push(new FErrorMessage("Password is empty. (passowrd={1})", password));
         return EResult.Failure;
      }
      String userPassword = userUnit.password();
      if(!password.equals(userPassword)){
         context.messages().push(new FErrorMessage("Password is not equals. (passowrd={1}, user_password={2})", password, userPassword));
         return EResult.Failure;
      }
      long userId = userUnit.ouid();
      String userLabel = userUnit.label();
      _logger.debug(this, "login", "User login. (user_id={1}, label={2})", userLabel);
      // 打开会话
      FSessionInfo sessionInfo = _sessionConsole.open(sqlContext, userId);
      String sessionCode = sessionInfo.code();
      // 设置输出
      FXmlNode sessionNode = output.config().createNode("Session");
      sessionNode.set("code", sessionCode);
      FXmlNode userNode = output.config().createNode("User");
      userNode.set("label", userLabel);
      return EResult.Success;
   }

   //============================================================
   // <T>用户查询处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        ISqlContext sqlContext,
                        IWebInput input,
                        IWebOutput output){
      // 获得参数
      FXmlNode inputNode = input.config();
      String passport = inputNode.nodeText("Passport");
      String password = inputNode.nodeText("Password");
      String label = inputNode.nodeText("Label");
      String email = inputNode.nodeText("Email");
      // 设置数据
      FDataPersonUserUnit userUnit = new FDataPersonUserUnit();
      userUnit.setPassport(passport);
      userUnit.setPassword(password);
      userUnit.setLabel(label);
      userUnit.setContactEmail(email);
      // 新建记录
      //FDataPersonUserLogic userLogic = new FDataPersonUserLogic(sqlContext);
      //userLogic.
      return EResult.Success;
   }

   //============================================================
   // <T>用户登出处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult logout(IWebContext context,
                         ISqlContext sqlContext,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }
}
