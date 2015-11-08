package org.mo.content.core.financial.marketer.customer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerCustomerUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.content.core.financial.member.IDataMemberConsole;
import org.mo.core.aop.face.ALink;

//============================================================
// <T>金融理财师客户控制台接口。</T>
//============================================================
public class FDataMarketerCustomerConsole
      extends FAbstractLogicUnitConsole<FDataFinancialMarketerCustomerLogic, FDataFinancialMarketerCustomerUnit>
      implements
         IDataMarketerCustomerConsole
{

   // 成员控制器
   @ALink
   protected IDataMemberConsole _memberConsole;

   //============================================================
   // <T>构造控制台。</T>
   //============================================================
   public FDataMarketerCustomerConsole(){
      super(FDataFinancialMarketerCustomerLogic.class, FDataFinancialMarketerCustomerUnit.class);
   }

}
