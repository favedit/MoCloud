package org.mo.content.face.manage.user;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>登录逻辑实现类</P>
//
//@class FFormAction
//@author Sunhr
//@Date 2014.12.08  
//@version 1.0.0
//============================================================

public interface IUserAction
{
   //============================================================
   // <T>列出目录。</T>
   //
   // @param context 环境
   // @param userPage 容器
   // @return 处理结果
   //============================================================
   String construct(IWebContext context,
                    @AContainer(name = "userPage") FUserPage formPage,
                    @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>用户查询</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   String select(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "userPage") FUserPage formPage,
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>用户增加之前</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   String insertBefore(IWebContext context,
                       ILogicContext logicContext,
                       @AContainer(name = "userPage") FUserPage formPage,
                       @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>用户增加</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   String insert(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "userPage") FUserPage formPage,
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>修改用户之前</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param basePage 页面
   // @return 要跳转页面
   // ============================================================
   String updateBefore(IWebContext context,
                       ILogicContext logicContext,
                       @AContainer(name = "userPage") FUserPage formPage,
                       @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>修改用户</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param basePage 页面
   // @return 要跳转页面
   // ============================================================
   String update(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "userPage") FUserPage formPage,
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>删除用户</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param basePage 页面
   // @return 要跳转页面
   // ============================================================
   String del(IWebContext context,
              ILogicContext logicContext,
              @AContainer(name = "userPage") FUserPage formPage,
              @AContainer(name = "basePage") FBasePage basePage);

}
