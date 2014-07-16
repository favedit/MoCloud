package com.cyou.gccloud.service.face.person;

import com.cyou.gccloud.service.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.service.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.service.system.session.FSessionInfo;
import com.cyou.gccloud.service.system.session.ISessionConsole;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.message.FErrorMessage;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.core.service.EServiceResult;
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

   @ALink
   protected ISessionConsole _sessionConsole;

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
   public EServiceResult register(IWebContext context,
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
      FDataPersonUserLogic userLogic = new FDataPersonUserLogic(sqlContext);
      userLogic.doInsert(userUnit);
      return EServiceResult.Success;
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
   public EServiceResult login(IWebContext context,
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
         return EServiceResult.Failure;
      }
      if(RString.isEmpty(password)){
         context.messages().push(new FErrorMessage("Password is empty. (passowrd={1})", password));
         return EServiceResult.Failure;
      }
      String userPassword = userUnit.password();
      if(!password.equals(userPassword)){
         context.messages().push(new FErrorMessage("Password is not equals. (passowrd={1}, user_password={2})", password, userPassword));
         return EServiceResult.Failure;
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
      return EServiceResult.Success;
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
   public EServiceResult query(IWebContext context,
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
      FDataPersonUserLogic userLogic = new FDataPersonUserLogic(sqlContext);
      userLogic.doInsert(userUnit);
      return EServiceResult.Success;
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
   public EServiceResult logout(IWebContext context,
                                ISqlContext sqlContext,
                                IWebInput input,
                                IWebOutput output){
      return EServiceResult.Success;
   }
}
