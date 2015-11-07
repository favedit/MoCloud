package org.mo.content.core.financial.marketer.customer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerCustomerUnit;
import com.cyou.gccloud.define.enums.common.EGcActive;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.content.core.financial.customer.ICustomerConsole;
import org.mo.data.logic.FLogicDataset;
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
   static final int           _pageSize = 12;
                                        
   //客户信息控制台
   protected ICustomerConsole _customerConsole;
                              
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
      whereSql.append(" AND ");
      whereSql.append(FDataFinancialMarketerCustomerLogic.ACTIVE_CD, " = '{activeCd}'");
      whereSql.bind("activeCd", RString.parse(EGcActive.Active));
      FDataFinancialMarketerCustomerUnit unit = logic.search(whereSql);
      return unit;
   }
   //============================================================
   // <T>查询理财师下产品的客户</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 产品编号
   // @return 插入结果
   //============================================================
   
   @Override
   public FLogicDataset<FDataFinancialMarketerCustomerInfo> selectByMarkterId(ILogicContext logicContext,
                                                                              long marketerId){
      FDataFinancialMarketerCustomerLogic logic = logicContext.findLogic(FDataFinancialMarketerCustomerLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialMarketerCustomerLogic.MARKETER_ID, " = '{marketerId}'");
      whereSql.bind("marketerId", RString.parse(marketerId));
      FLogicDataset<FDataFinancialMarketerCustomerInfo> unitList = logic.fetchClass(FDataFinancialMarketerCustomerInfo.class, whereSql);
      return unitList;
   }
   
   // ============================================================
   // <T>获取已设置短信提醒的数据</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @param  customerId 客户编号
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialMarketerCustomerInfo> findBeenSets(ILogicContext logicContext,
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
      whereSql.append(" AND ");
      whereSql.append(FDataFinancialMarketerCustomerLogic.ACTIVE_CD, " = '{activeCd}'");
      whereSql.bind("activeCd", RString.parse(EGcActive.Active));
      FLogicDataset<FDataFinancialMarketerCustomerInfo> marketerCustomerList = logic.fetchClass(FDataFinancialMarketerCustomerInfo.class, whereSql);
      return marketerCustomerList;
   }
}
