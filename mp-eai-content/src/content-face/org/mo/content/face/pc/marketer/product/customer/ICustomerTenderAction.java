package org.mo.content.face.pc.marketer.product.customer;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>金融用户接口。</P>
//
// @author hyw
// @version 
//============================================================
public interface ICustomerTenderAction
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
                    @AContainer(name = "basePage") FBasePage basePage,
                    @AContainer(name = "page", fill = true) FCustomerTenderPage page);

   //============================================================
   // <T>获取理财师产品下的客户。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   //   @AWebAuthority("eai.marketer.product.customer")
   String select(IWebContext context,
                 IWebSession sessionContext,
                 ILogicContext logicContext,
                 @AContainer(name = "page", fill = true) FTenderPage page);

   //============================================================
   // <T>获取客户信息。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   //   @AWebAuthority("eai.marketer.product.customer")
   String customerInfo(IWebContext context,
                       IWebSession sessionContext,
                       ILogicContext logicContext,
                       @AContainer(name = "page", fill = true) FTenderPage page);

   //============================================================
   // <T>查询产品</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String selectProduct(IWebContext context,
                        IWebSession sessionContext,
                        ILogicContext logicContext,
                        @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>查询客户</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String selectByMarketerIdAndProductId(IWebContext context,
                                         IWebSession sessionContext,
                                         ILogicContext logicContext,
                                         @AContainer(name = "page") FTenderPage page,
                                         @AContainer(name = "basePage") FBasePage basePage);
}
