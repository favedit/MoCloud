package com.ahyc.eai.batch.statistics.financial.marketer;

import com.ahyc.eai.batch.common.IStatisticsPoolConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerUnit;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>金融理财师控制台接口。</T>
//============================================================
public interface IStatisticsMarketerConsole
      extends
         IStatisticsPoolConsole
{
   //============================================================
   // <T>根据编号同步一个理财师信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   FStatisticsFinancialMarketerUnit syncByLinkId(FLogicContext logicContext,
                                                 long linkId);

   //============================================================
   // <T>更新理财师理财师部门关系。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   void updateDepartment(FLogicContext logicContext,
                         long linkId);
}
