package org.mo.content.face.manage.product.examine.system;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>理财师信息接口。</P>
//@interface IMarketerAction
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public interface IVersionAction
{
   // ============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   // ============================================================
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage page);

   // ============================================================
   // <T>查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String select(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "page") FVersionPage page,
                 @AContainer(name = "basePage") FBasePage basePage);

   //   // ============================================================
   //   // <T>查询资讯内容</T>
   //   //
   //   // @param context 网络环境
   //   // @param logicContext 逻辑环境
   //   // @param page 容器
   //   // @return 页面
   //   // ============================================================
   //   String getDescription(IWebContext context, ILogicContext logicContext, @AContainer(name = "page") FVersionPage page, @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>更新资讯状态</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String checking(IWebContext context,
                   ILogicContext logicContext,
                   @AContainer(name = "page") FVersionPage page,
                   @AContainer(name = "basePage") FBasePage basePage);

}