package org.mo.content.core.financial.marketer.customer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerCustomerUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>理财师客户控制台接口。</T>
//============================================================
public interface IDataMarketerCustomerConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialMarketerCustomerUnit>
{
   // ============================================================
   // <T>获取已设置短信提醒的数据</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @param  customerId 客户编号
   // @return 数据对象
   // ============================================================
   FDataFinancialMarketerCustomerUnit findBeenSet(ILogicContext logicContext,
                                                  long marketerId,
                                                  long customerId);
                                                  
   //============================================================
   // <T>查询理财师下产品的客户</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 产品编号
   // @return 插入结果
   //============================================================
   FLogicDataset<FDataFinancialMarketerCustomerInfo> selectByMarkterId(ILogicContext logicContext,
                                                                       long marketerId);
                                                                       
   // ============================================================
   // <T>获取已设置短信提醒的数据</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @param  customerId 客户编号
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataFinancialMarketerCustomerInfo> findBeenSets(ILogicContext logicContext,
                                                                  long marketerId,
                                                                  long customerId);
}
