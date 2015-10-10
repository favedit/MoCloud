package org.mo.content.face.manage.system.user.module;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>后台模块逻辑接口</P>
//
//@class IModuleAction
//@author Sunhr
//@Date 2014.12.08  
//@version 1.0.0
//============================================================

public interface IModuleAction
{

   // ============================================================
   // <T>默认跳转函数</T>
   //
   // @param context 上下文
   // @return 要跳转页面
   // ============================================================
   String construct(IWebContext context,
                    @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>查询</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param modulePage 页面
   // @return 要跳转页面
   // ============================================================
   String selectDataByPage(IWebContext context,
                           ILogicContext logicContext,
                           @AContainer(name = "modulePage") FModulePage modulePage,
                           @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>查询全部</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param modulePage 页面
   // @return 要跳转页面
   // ============================================================
   String selectAll(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>加载新增页面</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param basePage 容器
   // @return 要跳转页面
   // ============================================================
   String insertPrepare(IWebContext context,
                        ILogicContext logicContext,
                        @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>新增</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param modulePage 容器
   // @param basePage 容器
   // @return 要跳转页面
   // ============================================================
   String insert(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "modulePage") FModulePage modulePage,
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>加载修改页面</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @return 要跳转页面
   // ============================================================
   String updatePrepare(IWebContext context,
                        ILogicContext logicContext,
                        @AContainer(name = "modulePage") FModulePage modulePage,
                        @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>修改信息</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @return 要跳转页面
   // ============================================================
   String update(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "modulePage") FModulePage modulePage,
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>删除</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   String delete(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "basePage") FBasePage basePage);

}
