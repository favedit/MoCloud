package org.mo.content.face.manage.home;

import org.mo.content.face.base.FBasePage;
import org.mo.content.face.solution.person.FUserPage;
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

public interface IFrameAction
{
   //============================================================
   // <T>列出目录。</T>
   //
   // @param context 环境
   // @param userPage 容器
   // @return 处理结果
   //============================================================
   String construct(IWebContext context,
                    @AContainer(name = "userPage") FFramePage formPage,
                    @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>用户登陆</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   String loginUser(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "userPage") FFramePage formPage,
                    @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>用户注销</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   String loginOut(IWebContext context,
                   ILogicContext logicContext,
                   @AContainer(name = "userPage") FFramePage formPage,
                   @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>修改密码加载</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param basePage 页面
   // @return 要跳转页面
   // ============================================================
   String changePwdPrepare(IWebContext context,
                           ILogicContext logicContext,
                           @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>修改用户密码</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @return 要跳转页面
   // ============================================================
   String changePwd(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "userPage") FUserPage userPage,
                    @AContainer(name = "basePage") FBasePage basePage);
}
