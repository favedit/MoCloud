package org.mo.content.face.system.design;

import org.mo.cloud.logic.data.person.FGcUserInfo;
import org.mo.cloud.logic.data.person.IGcUserConsole;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
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
   // @param logicContext 逻辑环境
   // @param sessionInfo 会话信息
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FGcSessionInfo sessionInfo,
                           FSpacePage page){
      FGcUserInfo user = _userConsole.find(logicContext, sessionInfo.userId());
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
