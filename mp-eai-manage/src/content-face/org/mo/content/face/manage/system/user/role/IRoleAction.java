package org.mo.content.face.manage.system.user.role;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>后台角色逻辑接口</P>
//
//@class IRoleAction
//@author Sunhr
//@Date 2014.14.08  
//@version 1.0.0
//============================================================

public interface IRoleAction
{

   // ============================================================
   // <T>默认跳转函数</T>
   //
   // @param context 上下文
   // @return 要跳转页面
   // ============================================================
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>数据查询</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param rolePage 页面
   // @return 要跳转页面
   // ============================================================
   String selectDataByPage(IWebContext context,
                           ILogicContext logicContext,
                           @AContainer(name = "rolePage") FRolePage rolePage,
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
   // <T>新增数据</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param rolePage 容器
   // @param basePage 容器
   // @return 要跳转页面
   // ============================================================
   String insert(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "rolePage") FRolePage rolePage,
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>加载修改数据页面</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @return 要跳转页面
   // ============================================================
   String updatePrepare(IWebContext context,
                        ILogicContext logicContext,
                        @AContainer(name = "rolePage") FRolePage rolePage,
                        @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>修改数据</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @return 要跳转页面
   // ============================================================
   String update(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "rolePage") FRolePage rolePage,
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>删除数据</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param rolePage 页面
   // @return 要跳转页面
   // ============================================================
   String delete(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>查询角色模块</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param rolePage 页面
   // @return 要跳转页面
   // ============================================================
   String selectRoleModule(IWebContext context,
                           ILogicContext logicContext,
                           @AContainer(name = "rolePage") FRolePage rolePage,
                           @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>查询所有角色</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param basePage ajax
   // @return 要跳转页面
   // ============================================================
   String selectAll(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage basePage);
}
