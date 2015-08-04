package org.mo.content.face.manage.user;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.user.IUserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>登录逻辑实现类</P>
//
//@class FUserAction
//@author Sunhr
//@Date 2015.08.04  
//@version 1.0.0
//============================================================

public class FUserAction
      implements
         IUserAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FUserAction.class);

   //用户控制器
   @ALink
   protected IUserConsole _userConsole;

   //============================================================
   // <T>列出目录处理。</T>
   //
   // @param context 环境
   // @param page 容器
   // @return 处理结果
   //============================================================
   @Override
   public String construct(IWebContext context,
                           FUserPage userPage,
                           FBasePage basePage){
      System.out.println("-------------------------------------------------");
      _logger.debug(this, "construct", "construct begin.");
      return "/manage/manage/user/UserList";
   }

   // ============================================================
   // <T>用户登陆</T>
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FUserPage userPage,
                        FBasePage basePage){
      _logger.debug(this, "Select", "User Select. (passport={1},password={2})", context.parameter("passport"), context.parameter("password"));
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         userPage.setPageCurrent(Integer.parseInt(num));
      }else{
         userPage.setPageCurrent(0);
      }
      FLogicDataset<FDataPersonUserUnit> unit = _userConsole.selectDataByPageAndSomerow(logicContext, null, userPage.pageCurrent() - 1);
      basePage.setJson(unit.toJsonListString());
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>用户增加</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FUserPage formPage,
                        FBasePage basePage){
      // TODO Auto-generated method stub
      return null;
   }

   // ============================================================
   // <T>修改用户</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param basePage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String update(IWebContext context,
                        ILogicContext logicContext,
                        FBasePage basePage){
      // TODO Auto-generated method stub
      return null;
   }

}
