package org.mo.content.face.pc;

import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>动态页面接口。</P>
//
// @author maocy
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
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "page") FIndexPage page);

   //============================================================
   // <T>主页面。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================

   String main(IWebContext context,
               IWebSession sessionContext,
               ILogicContext logicContext,
               @AContainer(name = "page", fill = true) FIndexPage page);

}
