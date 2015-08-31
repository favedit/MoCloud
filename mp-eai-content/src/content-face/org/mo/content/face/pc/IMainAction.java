package org.mo.content.face.pc;

import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.face.AWebAuthority;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>动态页面接口。</P>
//
// @author sunhr
// @version 150724
//============================================================
public interface IMainAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @AWebAuthority("eai.marketer.customer|eai.marketer.marketer|eai.department.marketer")
   String construct(IWebContext context,
                    IWebSession sessionContext,
                    ILogicContext logicContext,
                    @AContainer(name = "page") FMainPage page);

   //============================================================
   // <T>客户级。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @AWebAuthority("eai.marketer.customer")
   String customer(IWebContext context,
                   IWebSession sessionContext,
                   ILogicContext logicContext,
                   @AContainer(name = "page", fill = true) FMainPage page);

   //============================================================
   // <T>理财师级。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @AWebAuthority("eai.marketer.marketer")
   String marketer(IWebContext context,
                   IWebSession sessionContext,
                   ILogicContext logicContext,
                   @AContainer(name = "page", fill = true) FMainPage page);

   //============================================================
   // <T>公司级。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @AWebAuthority("eai.department.marketer")
   String department(IWebContext context,
                     IWebSession sessionContext,
                     ILogicContext logicContext,
                     @AContainer(name = "page", fill = true) FMainPage page);

}
