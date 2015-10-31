package org.mo.content.face.pc;

import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.data.person.user.IDataPersonConsole;
import org.mo.web.core.session.IWebSession;
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
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FIndexAction.class);

   @ALink
   private IDataPersonConsole _personConsole;

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
      System.out.println("--------------------------------");
      // 非法设置
      return "/ars/home/Login";
   }

   //============================================================
   // <T>登录逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String login(IWebContext context,
                       IWebSession sessionContext,
                       ILogicContext logicContext,
                       FIndexPage page){
      // 获得参数
      String passport = RString.trimRight(page.passport());
      String password = page.password();
      String message = null;
      boolean result = false;
      if(RString.isEmpty(passport) || passport.indexOf("'") > -1 || passport.indexOf("%") > -1 || passport.length() > 18){
         _logger.debug(this, "doLogin", "Login passport illegal. (passport={1})", passport);
         message = "用户名非法或含有特殊字符。";
      }
      if(RString.isEmpty(password) || password.indexOf("'") > -1 || password.indexOf("%") > -1 || password.indexOf(";") > -1 || passport.length() > 32){
         _logger.debug(this, "doLogin", "Login password illegal. (password={1})", password);
         message = "密码非法或含有特殊字符。";
      }
      _logger.debug(this, "Index", "Index login.(passport={1},password={2})", passport, password);
      // 0:验证成功，1:签名不通过，3:用户名或密码错误，98:IP不在白名单中
      String resultCd = _personConsole.oaLogin(passport, password);
      if(resultCd.equals("0")){
         result = true;
      }else if(resultCd.equals("1")){
         message = "用户名或密码错误。";
      }else if(resultCd.equals("3")){
         message = "用户名或密码错误。";
      }else if(resultCd.equals("98")){
         message = "用户名或密码错误。";
      }
      if(result){
         return "Main";
      }
      page.setMessage(message);
      // 画面跳转
      return "/ars/home/Login";
   }
}
