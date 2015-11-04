package com.ahyc.eai.batch.calculate.financial.tender;

import com.cyou.gccloud.data.calculate.FCalculateFinancialProductPeriodLogic;
import com.cyou.gccloud.data.calculate.FCalculateFinancialProductPeriodUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>产品期次控制台。</T>
//============================================================
public class FCalculateTenderConsole
      extends FAbstractLogicUnitConsole<FCalculateFinancialProductPeriodLogic, FCalculateFinancialProductPeriodUnit>
      implements
         ICalculateTenderConsole
{

   // ============================================================
   // <T>构造新闻控制台。</T>
   // ============================================================
   public FCalculateTenderConsole(){
      super(FCalculateFinancialProductPeriodLogic.class, FCalculateFinancialProductPeriodUnit.class);
   }

}
