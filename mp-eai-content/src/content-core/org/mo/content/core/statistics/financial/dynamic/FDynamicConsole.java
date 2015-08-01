package org.mo.content.core.statistics.financial.dynamic;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>客户阶段统计结果控制台。</P>
//
//@author sunhr
//@version 150801
//============================================================
public class FDynamicConsole
      extends FAbstractLogicUnitConsole<FStatisticsFinancialDynamicLogic, FStatisticsFinancialDynamicUnit>
      implements
         IDynamicConsole
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FDynamicConsole.class);

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FDynamicConsole(){
      super(FStatisticsFinancialDynamicLogic.class, FStatisticsFinancialDynamicUnit.class);
   }

   //============================================================
   // <T>获取客户阶段统计的结果。</T>
   //
   // @param logicContext 逻辑环境
   // @param baginDate 开始时间
   // @param endDate 结束时间
   //============================================================
   @Override
   public FLogicDataset<FStatisticsFinancialDynamicUnit> select(ILogicContext logicContext,
                                                                TDateTime beginDate,
                                                                TDateTime endDate){
      if(beginDate.isEmpty() || endDate.isEmpty()){
         throw new FFatalError("beginDate and endDate can't be empty!");
      }
      StringBuffer where = new StringBuffer();
      if(!beginDate.isEmpty() && !endDate.isEmpty()){
         where.append(FStatisticsFinancialDynamicLogic.LINK_DATE).append(" >= ").append(beginDate);
         where.append(" AND ").append(FStatisticsFinancialDynamicLogic.RECORD_DATE).append(" <= ").append(endDate);
      }
      _logger.debug(this, "Select", "Select finish. (whereSql={1})", where.toString());
      FStatisticsFinancialDynamicLogic logic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      FLogicDataset<FStatisticsFinancialDynamicUnit> unitList = logic.fetch(where.toString());
      return unitList;
   }
}
