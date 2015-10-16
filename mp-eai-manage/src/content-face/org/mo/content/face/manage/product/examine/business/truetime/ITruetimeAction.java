package org.mo.content.face.manage.product.examine.business.truetime;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>实时数据接口。</P>
//@interface ITruetimeAction
//============================================================
public interface ITruetimeAction {

   // ============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   // ============================================================
   String construct(IWebContext context, ILogicContext logicContext, @AContainer(name = "basePage") FBasePage page);

   // ============================================================
   // <T>查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String select(IWebContext context, ILogicContext logicContext, @AContainer(name = "page") FTruetimePage page, @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>查询内容</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String getDescription(IWebContext context, ILogicContext logicContext, @AContainer(name = "page") FTruetimePage page, @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>更新状态</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String checking(IWebContext context, ILogicContext logicContext, @AContainer(name = "page") FTruetimePage page, @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String insertBefore(IWebContext context, ILogicContext logicContext, @AContainer(name = "page") FTruetimePage Page, @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>增加</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String insert(IWebContext context, ILogicContext logicContext, @AContainer(name = "page") FTruetimePage Page, @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>更新之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String updateBefore(IWebContext context, ILogicContext logicContext, @AContainer(name = "page") FTruetimePage Page, @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>更新</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String update(IWebContext context, ILogicContext logicContext, @AContainer(name = "page") FTruetimePage Page, @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>删除</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String delete(IWebContext context, ILogicContext logicContext, @AContainer(name = "page") FTruetimePage Page, @AContainer(name = "basePage") FBasePage basePage);
}
