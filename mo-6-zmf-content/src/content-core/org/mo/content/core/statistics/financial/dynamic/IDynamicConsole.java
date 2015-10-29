package org.mo.content.core.statistics.financial.dynamic;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.lang.type.TDateTime;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>客户阶段统计结果控制台接口。</P>
//
//@author sunhr
//@version 150801
//============================================================
public interface IDynamicConsole
      extends
         IAbstractLogicUnitConsole<FStatisticsFinancialDynamicUnit>
{
   //============================================================
   // <T>获取客户阶段统计的结果。</T>
   //
   // @param logicContext 逻辑环境
   // @param baginDate 开始时间
   // @param endDate 结束时间
   //============================================================
   FLogicDataset<FStatisticsFinancialDynamicUnit> select(ILogicContext logicContext,
                                                         TDateTime beginDate,
                                                         TDateTime endDate);

}
