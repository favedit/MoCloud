package org.mo.content.face.solution;

import org.mo.cloud.logic.person.FGcUserInfo;
import org.mo.cloud.logic.person.IGcUserConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>用户空间逻辑接口。</T>
//
// @author maocy
// @version 150413
//============================================================
public class FUserAction
      implements
         IUserAction
{
   // 用户控制台接口
   @ALink
   protected IGcUserConsole _userConsole;

   //============================================================
   // <T>用户信息显示处理。</T>
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
                           FUserPage page){
      FGcUserInfo userInfo = _userConsole.find(logicContext, sessionInfo.userId());
      page.setUser(userInfo);
      return "User";
   }

   //============================================================
   // <T>用户信息更新处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param sessionInfo 会话信息
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String update(IWebContext context,
                        ILogicContext logicContext,
                        FGcSessionInfo sessionInfo,
                        FUserPage page){
      // 获得参数
      String label = context.parameter("label");
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      // 更新信息
      FGcUserInfo userInfo = _userConsole.find(logicContext, sessionInfo.userId());
      userInfo.setLabel(label);
      _userConsole.doUpdate(logicContext, userInfo);
      // 返回结果
      page.setUser(userInfo);
      return "UserSuccess";
   }
}
