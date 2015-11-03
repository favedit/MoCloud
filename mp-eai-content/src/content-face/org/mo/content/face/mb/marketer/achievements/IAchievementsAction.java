package org.mo.content.face.mb.marketer.achievements;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>理财师业绩信息接口。</P>
//
// @author sunhr
// @version 151102
//============================================================
public interface IAchievementsAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   //   @AWebAuthority("eai.marketer.member.recommend")
   String construct(IWebContext context,
                    IWebSession sessionContext,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage", fill = true) FBasePage basePage,
                    @AContainer(name = "page", fill = true) FAchievementsPage page);

}
