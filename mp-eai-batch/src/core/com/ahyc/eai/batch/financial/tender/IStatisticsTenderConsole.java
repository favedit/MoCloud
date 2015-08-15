package com.ahyc.eai.batch.financial.tender;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderUnit;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>统计投标控制台接口。</T>
//============================================================
public interface IStatisticsTenderConsole
{
   //============================================================
   // <T>根据编号同步一个投标信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param id 编号
   //============================================================
   FStatisticsFinancialTenderUnit sync(FLogicContext logicContext,
                                       long id);

   //============================================================
   // <T>清空处理。</T>
   //============================================================
   void clear();
}
