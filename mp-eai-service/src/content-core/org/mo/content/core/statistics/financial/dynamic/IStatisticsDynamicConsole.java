package org.mo.content.core.statistics.financial.dynamic;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>理财师客户业务动态控制台。</P>
//
//@author sunhr
//@version 151108
//============================================================
public interface IStatisticsDynamicConsole
      extends
         IAbstractLogicUnitConsole<FStatisticsFinancialDynamicUnit>
{
   //============================================================
   // <T>根据理财师编号获取客户金融业务动态数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @return 数据集合
   //============================================================
   FLogicDataset<FStatisticsFinancialDynamicUnit> fetchByMarketerId(ILogicContext logicContext,
                                                                    long marketerId);

}
