package org.mo.content.face.marketer.recommend;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>金融用户接口。</P>
//
// @author sunhr
// @version 150921
//============================================================
public interface IRecommendAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   String construct(IWebContext context,
                    IWebSession sessionContext,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage basePage,
                    @AContainer(name = "page") FRecommendPage page);

   //============================================================
   // <T>查询逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   String select(IWebContext context,
                 IWebSession sessionContext,
                 ILogicContext logicContext,
                 @AContainer(name = "basePage") FBasePage basePage,
                 @AContainer(name = "page", fill = true) FRecommendPage page);
}
