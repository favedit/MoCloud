package org.mo.content.face.person;

import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>人员账号逻辑接口。</T>
//
// @author sunhr
// @version 150328
//============================================================
public interface IAccountAction
{
   //============================================================
   // <T>用户注册</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String register(IWebContext context,
                   ILogicContext logicContext,
                   @AContainer(name = "page") FAccountPage page);

   //============================================================
   // <T>用户登录</T>
   //
   // @param context 网络环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String login(IWebContext context,
                IWebSession sessionContext,
                ILogicContext logicContext,
                @AContainer(name = "page") FAccountPage page);
}
