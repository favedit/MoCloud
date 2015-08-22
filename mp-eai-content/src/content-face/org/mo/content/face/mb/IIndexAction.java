package org.mo.content.face.mb;

import org.mo.content.face.pc.FIndexPage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>动态页面接口。</P>
//
// @author maocy
// @version 150724
//============================================================
public interface IIndexAction
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
   // <T>登录逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   String login(IWebContext context,
                ILogicContext logicContext,
                @AContainer(name = "page", fill = true) FIndexPage page);

   //============================================================
   // <T>表格逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   String chart(IWebContext context,
                ILogicContext logicContext,
                @AContainer(name = "page", fill = true) FIndexPage page);

   //============================================================
   // <T>表格逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   String loginOut(IWebContext context,
                   ILogicContext logicContext,
                   @AContainer(name = "page", fill = true) FIndexPage page);
}
