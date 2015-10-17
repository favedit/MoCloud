package org.mo.content.face.manage.product.user.logger;

import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessUnit;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.user.logger.IAccessConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>人员账号逻辑。</T>
//============================================================
public class FAccessAction 
      implements 
         IAccessAction 
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FAccessAction.class);
   // 用户控制台
   @ALink
   protected IAccessConsole _accessConsole;

   @Override
   public String construct(IWebContext context, 
                           ILogicContext logicContext, 
                           FBasePage basePage) {
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/user/logger/AccessList";
   }

   // ============================================================
   // <T>查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String select(IWebContext context, 
                        ILogicContext logicContext, 
                        FAccessPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Select", "Select begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      if (null != context.parameter("page")) {
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      } else {
         page.setPageCurrent(0);
      }
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = _accessConsole.select(logicContext, page.pageCurrent() - 1, pageSize);
      basePage.setJson(unitlist.toJsonListString());
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitlist.count());
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>根据创建时间，操作信息查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String selectByDate(IWebContext context, 
                              ILogicContext logicContext, 
                              FAccessPage accessPage, 
                              FBasePage basePage) {
      _logger.debug(this, "selectByDate", "selectByDate begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      if (null != context.parameter("page")) {
         String num = context.parameter("page");
         accessPage.setPageCurrent(Integer.parseInt(num));
      } else {
         accessPage.setPageCurrent(0);
      }
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      String beginDateStr = context.parameter("beginDate");
      String endDateStr = context.parameter("endDate");
      String logicMessage = context.parameter("logicMessage");
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = _accessConsole.selectByDateandMessage(logicContext, beginDateStr, endDateStr, logicMessage, accessPage.pageCurrent() - 1, pageSize);
      basePage.setJson(unitlist.toJsonListString());
      _logger.debug(this, "selectByDate", "selectByDate finish. (unitListCount={1})", unitlist.count());
      return "/manage/common/ajax";
   }
}
