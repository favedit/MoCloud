package org.mo.content.face.solution.share;

import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>共享空间逻辑接口。</T>
//
// @author maocy
// @version 150413
//============================================================
@AWebLogin
public interface ISpaceAction
{
   //============================================================
   // <T>空间信息页面处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param sessionInfo 会话信息
   // @param page 容器
   // @return 页面
   //============================================================
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    FGcSessionInfo sessionInfo,
                    @AContainer(name = "page") FSpacePage page);
}
