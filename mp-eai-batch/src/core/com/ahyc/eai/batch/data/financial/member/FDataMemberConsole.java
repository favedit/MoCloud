package com.ahyc.eai.batch.data.financial.member;

import com.cyou.gccloud.data.data.FDataFinancialMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融用户控制台。</T>
//============================================================
public class FDataMemberConsole
      extends FAbstractLogicUnitConsole<FDataFinancialMemberLogic, FDataFinancialMemberUnit>
      implements
         IDataMemberConsole
{

   //============================================================
   // <T>构造金融用户控制台。</T>
   //============================================================
   public FDataMemberConsole(){
      super(FDataFinancialMemberLogic.class, FDataFinancialMemberUnit.class);
   }

   // ============================================================
   // <T>根据Linkid获取对象</T>
   //
   // @param logicContext 链接对象
   // @param linkId 
   // @return 数据对象 
   // ============================================================
   @Override
   public FDataFinancialMemberUnit findByLinkId(ILogicContext logicContext,
                                                long linkId){
      // TODO Auto-generated method stub
      return null;
   }

}
