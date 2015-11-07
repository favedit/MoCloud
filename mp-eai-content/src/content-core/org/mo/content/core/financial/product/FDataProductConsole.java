package org.mo.content.core.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialProductLogic;
import com.cyou.gccloud.data.data.FDataFinancialProductUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>产品控制台。</T>
//============================================================
public class FDataProductConsole
      extends FAbstractLogicUnitConsole<FDataFinancialProductLogic, FDataFinancialProductUnit>
      implements
         IDataProductConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FDataProductConsole.class);

   //============================================================
   // <T>构造产品控制台。</T>
   //============================================================
   public FDataProductConsole(){
      super(FDataFinancialProductLogic.class, FDataFinancialProductUnit.class);
   }

   //============================================================
   // <T>查询产品信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param FDataFinancialProductInfo产品信息
   // @return 插入结果
   //============================================================
   @Override
   public FLogicDataset<FDataFinancialProductInfo> select(ILogicContext logicContext,
                                                          FDataFinancialProductUnit unit){
      FDataFinancialProductLogic logic = logicContext.findLogic(FDataFinancialProductLogic.class);
      FLogicDataset<FDataFinancialProductInfo> productInfoList = logic.fetchClass(FDataFinancialProductInfo.class, null);
      _logger.debug(this, "product", "product select all", productInfoList.count());
      return productInfoList;
   }

}
