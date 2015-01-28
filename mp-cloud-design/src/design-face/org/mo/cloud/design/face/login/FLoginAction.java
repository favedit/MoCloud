package org.mo.cloud.design.face.login;

import org.mo.cloud.design.face.base.FBasePage;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

public class FLoginAction
      implements
         ILoginAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FLoginAction.class);

   // 用户控制台
   @ALink
   public IPersonConsole personConsole;

   // ============================================================
   // <T>用户登陆</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String login(IWebContext context,
                       ILogicContext logicContext,
                       FBasePage basePage){
      _logger.debug(this, "Login", "Login begin. (passport={1},password={2})", context.parameter("passport"), context.parameter("password"));
      //获取数据
      String passport = context.parameter("passport");
      String password = context.parameter("password");
      //处理逻辑，返回结果
      String result = personConsole.login(logicContext, basePage, passport, password);
      _logger.debug(this, "Login", "Login finish. (result={1})", result);
      basePage.ajax(result);
      return "#/design/manage/component/ajax";
   }

   // ============================================================
   // <T>用户注销</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String loginOut(IWebContext context,
                          ILogicContext logicContext,
                          FBasePage basePage){
      return null;
   }
}
