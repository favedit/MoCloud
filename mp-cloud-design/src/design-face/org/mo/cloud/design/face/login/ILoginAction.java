package org.mo.cloud.design.face.login;

import org.mo.cloud.design.face.base.FBasePage;
import org.mo.com.data.ASqlConnect;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

public interface ILoginAction
{
   // ============================================================
   // <T>用户登陆</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   String login(IWebContext context,
                @ASqlConnect(name = "GCDATA") ILogicContext logicContext,
                @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>用户注销</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   String loginOut(IWebContext context,
                   @ASqlConnect(name = "GCDATA") ILogicContext logicContext,
                   @AContainer(name = "basePage") FBasePage basePage);
}
