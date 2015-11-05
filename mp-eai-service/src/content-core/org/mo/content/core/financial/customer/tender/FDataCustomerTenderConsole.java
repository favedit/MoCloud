package org.mo.content.core.financial.customer.tender;

import com.cyou.gccloud.data.data.FDataFinancialCustomerTenderLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerTenderUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融理财师客户投资控制台。</T>
//============================================================
public class FDataCustomerTenderConsole
      extends FAbstractLogicUnitConsole<FDataFinancialCustomerTenderLogic, FDataFinancialCustomerTenderUnit>
      implements
         IDataCustomerTenderConsole
{
   //============================================================
   // <T>构造控制台。</T>
   //============================================================
   public FDataCustomerTenderConsole(){
      super(FDataFinancialCustomerTenderLogic.class, FDataFinancialCustomerTenderUnit.class);
   }

   // ============================================================
   // <T>获取指定日期的投资记录</T>
   //
   // @param logicContext 链接对象
   // @param date 日期
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialCustomerTenderUnit> fetchByDay(ILogicContext logicContext,
                                                                     String date){

      FSql whereSql = new FSql();
      whereSql.append("TO_DAYS(");
      whereSql.append(FDataFinancialCustomerTenderLogic.INVESTMENT_DATE);
      whereSql.append(") = TO_DAYS('{date}')");
      whereSql.bind("date", date);
      FLogicDataset<FDataFinancialCustomerTenderUnit> tenderList = fetch(logicContext, whereSql);
      if(tenderList.count() < 1){
         return null;
      }
      return tenderList;
   }
}
