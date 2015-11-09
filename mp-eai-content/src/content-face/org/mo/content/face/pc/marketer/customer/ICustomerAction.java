package org.mo.content.face.pc.marketer.customer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerCustomerUnit;
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
public interface ICustomerAction
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
                    @AContainer(name = "page", fill = true) FCustomerPage page);

   //============================================================
   // <T>短信提醒设置。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   //   @AWebAuthority("eai.marketer.member.recommend")
   String settingsSMS(IWebContext context,
                      IWebSession sessionContext,
                      ILogicContext logicContext,
                      @AContainer(name = "basePage") FBasePage basePage,
                      @AContainer(name = "page", fill = true) FCustomerPage page);

   //============================================================
   // <T>获取客户信息。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   //   @AWebAuthority("eai.marketer.member.recommend")
   String customerInfo(IWebContext context,
                       IWebSession sessionContext,
                       ILogicContext logicContext,
                       @AContainer(name = "page", fill = true) FCustomerPage page);

   //============================================================
   // <T>获取客户信息。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   //   @AWebAuthority("eai.marketer.member.recommend")
   String selectByCustomerId(IWebContext context,
                             IWebSession sessionContext,
                             ILogicContext logicContext,
                             @AContainer(name = "page", fill = true) FCustomerPage page);

   //============================================================
   // <T>修改短息提醒类型。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   //   @AWebAuthority("eai.marketer.member.recommend")
   String updataSms(IWebContext context,
                    IWebSession sessionContext,
                    ILogicContext logicContext,
                    @AContainer(name = "page", fill = true) FCustomerPage page);
                    
   //============================================================
   // <T>unit设置值。</T>
   // @param context 页面环境
   // @param logicContext 逻辑环境
   //============================================================
   //   @AWebAuthority("eai.marketer.member.recommend")
   void setMarketerAndCustomer(FDataFinancialMarketerCustomerUnit info,
                               IWebContext context,
                               ILogicContext logicContext,
                               long marketerId,
                               long customerId);
                               

   // ============================================================
   // <T>搜索客户。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   // ============================================================
   // @AWebAuthority("eai.marketer.member.recommend")
   String search(IWebContext context,
                 IWebSession sessionContext,
                 ILogicContext logicContext,
                 @AContainer(name = "basePage") FBasePage basePage,
                 @AContainer(name = "page", fill = true) FCustomerPage page);
}
