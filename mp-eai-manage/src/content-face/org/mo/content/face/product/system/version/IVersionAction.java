package org.mo.content.face.product.system.version;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>应用接口。</P>
//@interface IMarketerAction
//@author AnjoyTian
//@Date 2015.09.29 
//@version 1.0.0
//============================================================
public interface IVersionAction {
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage page);

   //============================================================
   // <T>查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String select(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "page") FVersionPage page,
                 @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String insertBefore(IWebContext context,
                       ILogicContext logicContext,
                       @AContainer(name = "page") FVersionPage page,
                       @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String insert(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "page") FVersionPage page,
                 @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>更新之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String updateBefore(IWebContext context,
                       ILogicContext logicContext,
                       @AContainer(name = "page") FVersionPage page,
                       @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>更新</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String update(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "page") FVersionPage page,
                 @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>删除</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String delete(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "page") FVersionPage page,
                 @AContainer(name = "basePage") FBasePage basePage);
}