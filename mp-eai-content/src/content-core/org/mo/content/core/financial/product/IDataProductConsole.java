package org.mo.content.core.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialProductUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>产品信息接口。</T>
//============================================================
public interface IDataProductConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialProductUnit>
{
   //============================================================
   // <T>查询产品信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param FDataFinancialProductUnit 产品信息
   // @return 插入结果
   //============================================================
   FLogicDataset<FDataFinancialProductInfo> select(ILogicContext logicContext,
                                                   FDataFinancialProductUnit unit);
}
