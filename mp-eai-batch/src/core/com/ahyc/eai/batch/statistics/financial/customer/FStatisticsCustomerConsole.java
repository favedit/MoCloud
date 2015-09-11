package com.ahyc.eai.batch.statistics.financial.customer;

import com.ahyc.eai.batch.common.FStatisticsPoolConsole;
import com.ahyc.eai.batch.statistics.financial.member.IStatisticsMemberConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>统计投标控制台。</T>
//============================================================
public class FStatisticsCustomerConsole
      extends FStatisticsPoolConsole<FStatisticsFinancialCustomerUnit>
      implements
         IStatisticsCustomerConsole
{
   // 成员控制台
   @ALink
   protected IStatisticsMemberConsole _memberConsole;

   //============================================================
   // <T>构造金融用户控制台。</T>
   //============================================================
   public FStatisticsCustomerConsole(){
      super(FStatisticsFinancialCustomerUnit.class);
   }

   //============================================================
   // <T>根据编号同步一个理财师信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   @Override
   public FStatisticsFinancialCustomerUnit syncByLinkId(FLogicContext logicContext,
                                                        long linkId){
      // 检查参数
      if(linkId == 0){
         return null;
      }
      // 查找单元
      String code = Long.toString(linkId);
      FStatisticsFinancialCustomerUnit unit = _pool.find(code);
      if(unit != null){
         return unit;
      }
      // 查找单元
      FStatisticsFinancialCustomerLogic logic = logicContext.findLogic(FStatisticsFinancialCustomerLogic.class);
      unit = logic.search("LINK_ID=" + linkId);
      if(unit != null){
         return unit;
      }
      //............................................................
      // 查找成员
      FStatisticsFinancialMemberUnit memberUnit = _memberConsole.syncByLinkId(logicContext, linkId);
      if(memberUnit == null){
         return null;
      }
      //............................................................
      // 新建单元
      unit = logic.doPrepare();
      unit.setLinkId(linkId);
      unit.linkDate().assign(memberUnit.updateDate());
      unit.setLabel(memberUnit.label());
      unit.setPhone(memberUnit.phone());
      unit.setCard(memberUnit.card());
      logic.doInsert(unit);
      return unit;
   }
}
