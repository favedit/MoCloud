package org.mo.content.core.financial.customer.tender;

import com.cyou.gccloud.data.data.FDataFinancialCustomerTenderLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerTenderUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>金融理财师客户投资控制台。</T>
//============================================================
public class FDataCustomerTenderConsole
      extends FAbstractLogicUnitConsole<FDataFinancialCustomerTenderLogic, FDataFinancialCustomerTenderUnit>
      implements
         IDataCustomerTenderConsole
{
   // 资源访问接口
   private static IResource _resource = RResource.find(FDataCustomerTenderConsole.class);

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

   // ============================================================
   // <T>获取指定客户的投资记录</T>
   //
   // @param logicContext 链接对象
   // @param date 日期
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataCustomerTenderInfo> fetchByCustomerId(ILogicContext logicContext,
                                                                   long customerId){
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.DATA);
      FSql sql = _resource.findString(FSql.class, "sql.customre.tender.sum");
      FLogicDataset<FDataCustomerTenderInfo> customerTenderList = new FLogicDataset<>(FDataCustomerTenderInfo.class);
      FDataset dataset = connection.fetchDataset(sql);
      for(FRow row : dataset){
         FDataCustomerTenderInfo info = new FDataCustomerTenderInfo();
         info.setCustomerId(row.getLong("customer_id"));
         info.setTenderId(row.getLong("tender_id"));
         info.setInvestmentTotal(row.getDouble("investment_total"));
         info.setRedemptionTotal(row.getDouble("redemption_total"));
         info.setNetinvestmentTotal(row.getDouble("netinvestment_total"));
         customerTenderList.push(info);
      }
      return null;
   }
}
