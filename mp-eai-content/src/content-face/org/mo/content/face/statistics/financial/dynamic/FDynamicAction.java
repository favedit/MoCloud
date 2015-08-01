package org.mo.content.face.statistics.financial.dynamic;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.statistics.financial.dynamic.IDynamicConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>动态统计。</P>
//
// @author sunhr
// @version 150801
//============================================================
public class FDynamicAction
      implements
         IDynamicAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FDynamicAction.class);

   //用户控制台
   @ALink
   protected IDynamicConsole _dynamicConsole;

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

   //============================================================
   // <T>动态统计获取</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FBasePage basePage){
      _logger.debug(this, "Select", "Select begin. (beginDate={1})", context.parameter("beginDate"));
      String beginDateStr = context.parameter("beginDate");
      TDateTime beginDate = new TDateTime();
      beginDate.parse(beginDateStr, "YYYY-MM-DD HH24:MI");
      String endDateStr = context.parameter("beginDate");
      TDateTime endDate = new TDateTime();
      endDate.parse(endDateStr, "YYYY-MM-DD HH24:MI");

      FLogicDataset<FStatisticsFinancialDynamicUnit> unitlist = _dynamicConsole.select(logicContext, beginDate, endDate);
      basePage.setJson(unitlist.toJsonListString());
      return "/manage/common/ajax";
   }

}
