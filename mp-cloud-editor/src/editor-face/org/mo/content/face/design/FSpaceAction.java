package org.mo.content.face.design;

import org.mo.cloud.core.web.FGcWebSession;
import org.mo.cloud.logic.person.FGcUserInfo;
import org.mo.cloud.logic.person.IGcUserConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<T>用户空间逻辑接口。</T>
//
//@author maocy
//@version 150413
//============================================================
public class FSpaceAction
      implements
         ISpaceAction
{
   // 用户控制台接口
   @ALink
   protected IGcUserConsole _userConsole;

   //============================================================
   // <T>用户信息页面处理。</T>
   //
   // @param context 网络环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           IWebSession sessionContext,
                           ILogicContext logicContext,
                           FSpacePage page){
      FGcWebSession session = (FGcWebSession)sessionContext;
      FGcUserInfo user = _userConsole.find(logicContext, session.userId());
      page.setUser(user);
      return "Space";
   }

   //============================================================
   // <T>运行页面处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String run(IWebContext context,
                     ILogicContext logicContext,
                     FSpacePage page){
      return "Run";
   }
}
