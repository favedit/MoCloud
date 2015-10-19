package org.mo.content.face.pc.marketer.customer;

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
public interface ICustomerAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param basePage 公共容器
   // @param page 页面容器
   //============================================================
   @AWebAuthority("eai.marketer.member.recommend")
   String construct(IWebContext context,
                    IWebSession sessionContext,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage basePage,
                    @AContainer(name = "page", fill = true) FCustomerPage page);

   //============================================================
   // <T>解除关系逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param basePage 公共容器
   // @param page 页面容器
   //============================================================
   @AWebAuthority("eai.marketer.member.recommend")
   String removeRelation(IWebContext context,
                         IWebSession sessionContext,
                         ILogicContext logicContext,
                         @AContainer(name = "basePage") FBasePage basePage,
                         @AContainer(name = "page", fill = true) FCustomerPage page);

}
