package com.ahyc.eai.batch.statistics.financial.customer;

import com.ahyc.eai.batch.common.IStatisticsPoolConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerUnit;
import org.mo.com.lang.FDoubles;
import org.mo.com.lang.type.TDateTime;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融客户控制台接口。</T>
//============================================================
public interface IStatisticsCustomerConsole
      extends
         IStatisticsPoolConsole
{
   //============================================================
   // <T>查询指定时间的投资信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param date 时间
   // @return 投资
   //============================================================
   public double fetchInvestment(ILogicContext logicContext,
                                 TDateTime date);

   //============================================================
   // <T>以天为单位查询开始时间到结束时间的投资信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param beginDate 开始时间
   // @param endDate 结束时间
   // @return 投资信息
   //============================================================
   public FDoubles fetchDayInvestments(ILogicContext logicContext,
                                       TDateTime beginDate,
                                       TDateTime endDate);

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
