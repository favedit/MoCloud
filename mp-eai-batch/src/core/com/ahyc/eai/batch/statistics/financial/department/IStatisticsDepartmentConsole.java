package com.ahyc.eai.batch.statistics.financial.department;

import com.ahyc.eai.batch.common.IStatisticsPoolConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentUnit;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>部门信息控制台接口。</T>
//============================================================
public interface IStatisticsDepartmentConsole
      extends
         IStatisticsPoolConsole
{
   //============================================================
   // <T>根据编号同步一个部门信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   FStatisticsFinancialDepartmentUnit syncByLinkId(FLogicContext logicContext,
                                                   long linkId);
}
