package com.ahyc.eai.batch.statistics.financial.customer;

import com.ahyc.eai.batch.common.IStatisticsPoolConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerUnit;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>金融客户控制台接口。</T>
//============================================================
public interface IStatisticsCustomerConsole
      extends
         IStatisticsPoolConsole
{
   //============================================================
   // <T>根据编号同步一个客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   FStatisticsFinancialCustomerUnit syncByLinkId(FLogicContext logicContext,
                                                 long linkId);

   //============================================================
   // <T>根据编号更新一个客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   FStatisticsFinancialCustomerUnit updateByLinkId(FLogicContext logicContext,
                                                   long linkId);
}
