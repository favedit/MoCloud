package org.mo.content.face.system.design;

import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>用户空间逻辑接口。</T>
//
// @author maocy
// @version 150613
//============================================================
public interface ISpaceAction
{
   //============================================================
   // <T>用户信息页面处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param sessionInfo 会话信息
   // @param page 容器
   // @return 页面
   //============================================================
   @AWebLogin
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    FGcSessionInfo sessionInfo,
                    @AContainer(name = "page") FSpacePage page);

   //============================================================
   // <T>运行页面处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param sessionInfo 会话信息
   // @param page 容器
   // @return 页面
   //============================================================
   String run(IWebContext context,
              ILogicContext logicContext,
              @AContainer(name = "page") FSpacePage page);
}
