package org.mo.cloud.design.face.person;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.cloud.design.core.person.IPersonConsole;
import org.mo.cloud.design.face.base.FBasePage;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

public class FUserAction
      implements
         IUserAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FUserAction.class);

   // 用户控制台
   @ALink
   public IPersonConsole personConsole;

   //============================================================
   // <T>默认跳转。</T>
   //
   // @param context 环境
   // @param page 容器
   // @return 处理结果
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FBasePage basePage){
      _logger.debug(this, "construct", "construct begin.");
      return "#/manage/user/UserList";
   }

   // ============================================================
   // <T>用户查询</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String selectDataByPage(IWebContext context,
                                  ILogicContext logicContext,
                                  FUserPage userPage,
                                  FBasePage basePage){
      _logger.debug(this, "selectDataByPage", "selectDataByPage Begin.(pageNumber={1})", context.parameter("page"));
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         userPage.setPageCurrent(Integer.parseInt(num));
      }else{
         userPage.setPageCurrent(0);
      }
      FDataPersonUserUnit userUnit = new FDataPersonUserUnit();
      userUnit.setPassport(context.parameter("passport"));
      FLogicDataset<FDataPersonUserUnit> userUnitList = personConsole.selectDataByPageAndSomerow(logicContext, userUnit, userPage.pageCurrent() - 1);
      basePage.toJson(userUnitList.toJsonListString());
      _logger.debug(this, "selectDataByPage", "selectDataByPage finish.(userUnitList={1})", userUnitList.count());
      return "#/manage/component/ajax";
   }
}
