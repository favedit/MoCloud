package org.mo.content.core.financial.member;

import com.cyou.gccloud.data.data.FDataFinancialMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>金融理财师控制台。</T>
//============================================================
public class FDataMemberConsole
      extends FAbstractLogicUnitConsole<FDataFinancialMemberLogic, FDataFinancialMemberUnit>
      implements
         IDataMemberConsole
{
   //============================================================
   // <T>构造控制台。</T>
   //============================================================
   public FDataMemberConsole(){
      super(FDataFinancialMemberLogic.class, FDataFinancialMemberUnit.class);
   }

}
