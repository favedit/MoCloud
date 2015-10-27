package org.mo.content.face.pc.marketer.recommend;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.face.AWebAuthority;
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
   @AWebAuthority("eai.marketer.member.recommend")
   String construct(IWebContext context,
                    IWebSession sessionContext,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage basePage,
                    @AContainer(name = "page", fill = true) FRecommendPage page);

   //============================================================
   // <T>查询逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @AWebAuthority("eai.marketer.member.recommend")
   String select(IWebContext context,
                 IWebSession sessionContext,
                 ILogicContext logicContext,
                 @AContainer(name = "basePage") FBasePage basePage,
                 @AContainer(name = "page", fill = true) FRecommendPage page);

   //============================================================
   // <T>关注逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @AWebAuthority("eai.marketer.member.recommend")
   String follow(IWebContext context,
                 IWebSession sessionContext,
                 ILogicContext logicContext,
                 @AContainer(name = "basePage") FBasePage basePage,
                 @AContainer(name = "page", fill = true) FRecommendPage page);

   //============================================================
   // <T>获取成员信息。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @AWebAuthority("eai.marketer.member.recommend")
   String memberInfo(IWebContext context,
                     IWebSession sessionContext,
                     ILogicContext logicContext,
                     @AContainer(name = "basePage") FBasePage basePage,
                     @AContainer(name = "page", fill = true) FRecommendPage page);
}