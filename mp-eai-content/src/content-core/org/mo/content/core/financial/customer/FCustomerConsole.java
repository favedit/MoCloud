package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>客户推荐控制台。</T>
//============================================================
public class FCustomerConsole
      extends FAbstractLogicUnitConsole<FDataFinancialCustomerLogic, FDataFinancialCustomerUnit>
      implements
         ICustomerConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FCustomerConsole(){
      super(FDataFinancialCustomerLogic.class, FDataFinancialCustomerUnit.class);
   }

}
