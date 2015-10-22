package org.mo.content.face.manage.product.business.salestools;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>销售工具信息接口。</P>
//@interface ISalestoolsAction
//@author Zhangxiaohui
//@Date 2015.10.10 
//@version 1.0.0
//============================================================
public interface ISalestoolsAction {

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
                 @AContainer(name = "page") FSalestoolsPage page, 
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String insertBefore(IWebContext context, 
                       ILogicContext logicContext, 
                       @AContainer(name = "page") FSalestoolsPage page, 
                       @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String insert(IWebContext context, 
                 ILogicContext logicContext, 
                 @AContainer(name = "page") FSalestoolsPage page, 
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>更新之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String updateBefore(IWebContext context, 
                       ILogicContext logicContext, 
                       @AContainer(name = "page") FSalestoolsPage page, 
                       @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>更新</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String update(IWebContext context, 
                 ILogicContext logicContext, 
                 @AContainer(name = "page") FSalestoolsPage page, 
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>删除之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   public String deleteBefore(IWebContext context, 
                              ILogicContext logicContext, 
                              @AContainer(name = "page") FSalestoolsPage page, 
                              @AContainer(name = "basePage") FBasePage basePage);
   
   // ============================================================
   // <T>删除</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String delete(IWebContext context, 
                 ILogicContext logicContext, 
                 @AContainer(name = "page") FSalestoolsPage page, 
                 @AContainer(name = "basePage") FBasePage basePage);
   
   // ============================================================
   // <T>根据状态，是否显示，标题查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String selectByData(IWebContext context, 
                       ILogicContext logicContext, 
                       @AContainer(name = "page") FSalestoolsPage page, 
                       @AContainer(name = "basePage") FBasePage basePage);
   
   // ============================================================
   // <T>查询内容</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String getDescription(IWebContext context, 
                         ILogicContext logicContext, 
                         @AContainer(name = "page") FSalestoolsPage page, 
                         @AContainer(name = "basePage") FBasePage basePage);
}