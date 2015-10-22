package org.mo.content.core.financial.marketer.customer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerCustomerUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>理财师客户控制台。</T>
//============================================================
public class FDataMarketerCustomerConsole
      extends FAbstractLogicUnitConsole<FDataFinancialMarketerCustomerLogic, FDataFinancialMarketerCustomerUnit>
      implements
         IDataMarketerCustomerConsole
{
   // 每页条数
   static final int _pageSize = 12;

   //============================================================
   // <T>构造控制台。</T>
   //============================================================
   public FDataMarketerCustomerConsole(){
      super(FDataFinancialMarketerCustomerLogic.class, FDataFinancialMarketerCustomerUnit.class);
   }

   // ============================================================
   // <T>获取已设置短信提醒的数据</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @param  customerId 客户编号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialMarketerCustomerUnit findBeenSet(ILogicContext logicContext,
                                                         long marketerId,
                                                         long customerId){
      if(marketerId == 0 || customerId == 0){
         throw new FFatalError("findBeenSet,marketerId or customerId is null");
      }
      FDataFinancialMarketerCustomerLogic logic = logicContext.findLogic(FDataFinancialMarketerCustomerLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialMarketerCustomerLogic.MARKETER_ID, " = '{marketerId}'");
      whereSql.bind("marketerId", RString.parse(marketerId));
      whereSql.append(" AND ");
      whereSql.append(FDataFinancialMarketerCustomerLogic.CUSTOMER_ID, " = '{customerId}'");
      whereSql.bind("customerId", RString.parse(customerId));
      FDataFinancialMarketerCustomerUnit unit = logic.search(whereSql);
      return unit;
   }
}
