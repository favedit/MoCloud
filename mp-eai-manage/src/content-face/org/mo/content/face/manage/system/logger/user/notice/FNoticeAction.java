package org.mo.content.face.manage.system.logger.user.notice;

import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.system.logger.user.notice.FDataNoticeInfo;
import org.mo.content.core.manage.system.logger.user.notice.INoticeConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;


//============================================================
//<P>用户公告日志控制器</P>
//@class FNoticeloggerAction
//============================================================
public class FNoticeAction 
      implements 
         INoticeAction 
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FNoticeAction.class);
   // 用户控制台
   @ALink
   protected INoticeConsole _noticeLoggerConsole;

   @Override
   public String construct(IWebContext context, 
                           ILogicContext logicContext, 
                           FBasePage basePage) {
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/system/logger/user/notice/NoticeList";
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
                        FNoticePage page, 
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
      FLogicDataset<FDataNoticeInfo> unitlist = _noticeLoggerConsole.select(logicContext, page.pageCurrent() - 1, pageSize);
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
                              FNoticePage accessPage, 
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
      Integer activeCd = context.parameterAsInteger("activeCd");
      FLogicDataset<FDataNoticeInfo> unitlist = _noticeLoggerConsole.selectByDateandActiveCd(logicContext, beginDateStr, endDateStr, activeCd, accessPage.pageCurrent() - 1, pageSize);
      basePage.setJson(unitlist.toJsonListString());
      _logger.debug(this, "selectByDate", "selectByDate finish. (unitListCount={1})", unitlist.count());
      return "/manage/common/ajax";
   }
}
