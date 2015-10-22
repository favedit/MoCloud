package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>客户控制台接口。</T>
//============================================================
public interface ICustomerConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialCustomerUnit>
{
   // ============================================================
   // <T>获取理财师的客户</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataFinancialCustomerInfo> selectByMarketerId(ILogicContext logicContext,
                                                                long marketerId);

   // ============================================================
   // <T>获取总页数</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 理财师编号
   // @return 总页数
   // ============================================================
   int getPageCount(ILogicContext logicContext,
                    long marketerId);
}
