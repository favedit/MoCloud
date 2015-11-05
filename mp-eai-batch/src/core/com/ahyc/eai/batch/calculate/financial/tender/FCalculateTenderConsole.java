package com.ahyc.eai.batch.calculate.financial.tender;

import com.cyou.gccloud.data.calculate.FCalculateFinancialProductPeriodLogic;
import com.cyou.gccloud.data.calculate.FCalculateFinancialProductPeriodUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderUnit;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
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
      //取出所有数据
      FLogicDataset<FStatisticsFinancialTenderUnit> list = logic.fetchAll();
      FCalculateFinancialProductPeriodUnit unit = this.doPrepare(logicContext);
      for(FStatisticsFinancialTenderUnit oldUnit : list){
         Long linkId = oldUnit.linkId();
         String borrowModel = oldUnit.borrowModel();
         String linkid = RString.parse(linkId);
         if(RString.isNotEmpty(linkid)||RString.isNotEmpty(borrowModel)){
            //判断不存在数据
            if(isNotExistByProductCodeandIssue(logicContext, linkid, borrowModel)){
               unit.setProductCode(linkid);
               unit.setProductIssue(RInteger.parse(borrowModel));
               //插入数据
               this.doInsert(logicContext, unit);
            }
         }
      }
   }
   // ============================================================
   // <T>根据条件判断是否存在重复数据</T>
   //
   // @param context 网络环境
   // @param productCode 产品名称
   // @param productIssue 期次编号
   // @return 页面
   // ============================================================
   public boolean isNotExistByProductCodeandIssue(ILogicContext logicContext,
                                                  String productCode,
                                                  String productIssue){
      FSql where = new FSql();
      if(!RString.isEmpty(productCode)){
         where.append(FCalculateFinancialProductPeriodLogic.PRODUCT_CODE + " = {productCode}");
         where.bind("productCode", productCode);
      }else{
         where.append(FCalculateFinancialProductPeriodLogic.PRODUCT_CODE + " is null ");
      }
      if(!RString.isEmpty(productIssue)){
         where.append(" and ");
         where.append(FCalculateFinancialProductPeriodLogic.PRODUCT_ISSUE + " = {productIssue}");
         where.bind("productIssue", productIssue);
      }else{
         where.append(" and ");
         where.append(FCalculateFinancialProductPeriodLogic.PRODUCT_ISSUE + " is null ");
      }
      FCalculateFinancialProductPeriodLogic logic = logicContext.findLogic(FCalculateFinancialProductPeriodLogic.class);
      FCalculateFinancialProductPeriodUnit unit = logic.search(where);
      return unit==null?true:false;
   }
}
