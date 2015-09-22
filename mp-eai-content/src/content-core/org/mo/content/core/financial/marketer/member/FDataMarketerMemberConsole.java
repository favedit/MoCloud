package org.mo.content.core.financial.marketer.member;

import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>金融理财师成员控制台。</T>
//============================================================
public class FDataMarketerMemberConsole
      extends FAbstractLogicUnitConsole<FDataFinancialMarketerMemberLogic, FDataFinancialMarketerMemberUnit>
      implements
         IDataMarketerMemberConsole
{
   //============================================================
   // <T>构造控制台。</T>
   //============================================================
   public FDataMarketerMemberConsole(){
      super(FDataFinancialMarketerMemberLogic.class, FDataFinancialMarketerMemberUnit.class);
   }

}
