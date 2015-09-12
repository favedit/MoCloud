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
   // <T>根据编号获得信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   // @return 数据信息
   //============================================================
   FStatisticsDepartmentInfo findInfo(FLogicContext logicContext,
                                      long id);

   //============================================================
   // <T>根据编号同步一个部门信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   // @return 数据单元
   //============================================================
   FStatisticsFinancialDepartmentUnit syncByLinkId(FLogicContext logicContext,
                                                   long linkId);
}
