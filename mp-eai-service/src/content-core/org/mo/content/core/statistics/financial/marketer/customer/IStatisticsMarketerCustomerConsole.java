package org.mo.content.core.statistics.financial.marketer.customer;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerCustomerUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>理财师客户投资控制台。</P>
//
//@author sunhr
//@version 151106
//============================================================
public interface IStatisticsMarketerCustomerConsole
      extends
         IAbstractLogicUnitConsole<FStatisticsFinancialMarketerCustomerUnit>
{
   //============================================================
   // <T>根据理财师编号获取理财师客户关系数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @return 数据集合
   //============================================================
   FLogicDataset<FStatisticsFinancialMarketerCustomerUnit> fetchByMarketerId(ILogicContext logicContext,
                                                                             long marketerId);

}
