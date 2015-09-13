package com.ahyc.eai.batch.statistics.financial.member;

import com.ahyc.eai.batch.common.IStatisticsPoolConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>金融用户控制台接口。</T>
//============================================================
public interface IStatisticsMemberConsole
      extends
         IStatisticsPoolConsole
{
   //============================================================
   // <T>根据编号同步一个用户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   FStatisticsFinancialMemberUnit syncByLinkId(FLogicContext logicContext,
                                               long linkId);
   
   //============================================================
   // <T>根据编号更新一个用户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   FStatisticsFinancialMemberUnit updateByLinkId(FLogicContext logicContext,
                                                 long linkId);
}
