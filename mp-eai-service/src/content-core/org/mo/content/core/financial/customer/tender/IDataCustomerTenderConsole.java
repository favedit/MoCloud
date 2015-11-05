package org.mo.content.core.financial.customer.tender;

import com.cyou.gccloud.data.data.FDataFinancialCustomerTenderUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融理财师客户投资控制台接口。</T>
//============================================================
public interface IDataCustomerTenderConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialCustomerTenderUnit>
{
   // ============================================================
   // <T>获取指定日期的投资记录</T>
   //
   // @param logicContext 链接对象
   // @param date 日期
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataFinancialCustomerTenderUnit> fetchByDay(ILogicContext logicContext,
                                                              String date);

}
