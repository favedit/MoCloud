package com.ahyc.eai.batch.calculate.financial.tender;

import com.cyou.gccloud.data.calculate.FCalculateFinancialProductPeriodLogic;
import com.cyou.gccloud.data.calculate.FCalculateFinancialProductPeriodUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderUnit;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

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

   // ============================================================
   // <T>批量插入字段值link_id,borrow_model</T>
   // @param logicContext 链接对象
   // @return void
   // ============================================================
   @Override
   public void insertBatchLinkIdandBorrowModel(ILogicContext logicContext){
      FStatisticsFinancialTenderLogic logic = logicContext.findLogic(FStatisticsFinancialTenderLogic.class);
      FLogicDataset<FStatisticsFinancialTenderUnit> list = logic.fetchAll();
      FCalculateFinancialProductPeriodUnit unit = this.doPrepare(logicContext);
      for(FStatisticsFinancialTenderUnit oldUnit : list){
         unit.setProductCode(RString.parse(oldUnit.linkId()));
         unit.setProductIssue(RInteger.parse(oldUnit.borrowModel()));
         this.doInsert(logicContext, unit);
      }
   }
}
