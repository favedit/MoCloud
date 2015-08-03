package org.mo.content.face.statistics.financial.customer;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerPhaseUnit;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.statistics.financial.customer.IPhaseConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>客户阶段统计。</P>
//
// @author sunhr
// @version 150801
//============================================================
public class FPhaseAction
      implements
         IPhaseAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FPhaseAction.class);

   //用户控制台
   @ALink
   protected IPhaseConsole _phaseConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FBasePage basePage){
      _logger.debug(this, "Construct", "Construct begin. (user={1})", basePage.user());
      return "/";
   }

   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FBasePage basePage){
      String beginDateStr = context.parameter("beginDate");
      TDateTime beginDate = new TDateTime();
      beginDate.parse(beginDateStr, "YYYY-MM-DD HH24:MI");

      String endDateStr = context.parameter("endDate");
      TDateTime endDate = new TDateTime();
      endDate.parse(endDateStr, "YYYY-MM-DD HH24:MI");

      FLogicDataset<FStatisticsFinancialCustomerPhaseUnit> unitlist = _phaseConsole.select(logicContext, beginDate, endDate);
      _logger.debug(this, "LoginUser", "LoginUser begin. (page={1})", context.parameter("page"));
      basePage.setJson(unitlist.toJsonListString());
      return "/manage/common/ajax";
   }

}
