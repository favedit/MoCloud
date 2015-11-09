package org.mo.content.core.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialProductLogic;
import com.cyou.gccloud.data.data.FDataFinancialProductUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.content.core.common.EDatabaseConnection;
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
   private static ILogger   _logger   = RLogger.find(FDataProductConsole.class);
                                      
   // 资源访问接口
   private static IResource _resource = RResource.find(FDataProductConsole.class);
                                      
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
      //      FDataFinancialProductLogic logic = logicContext.findLogic(FDataFinancialProductLogic.class);
      //      FLogicDataset<FDataFinancialProductInfo> productInfoList = logic.fetchClass(FDataFinancialProductInfo.class, null);
      FLogicDataset<FDataFinancialProductInfo> productInfoList = new FLogicDataset<>(FDataFinancialProductInfo.class);
      FSql modelSql = _resource.findString(FSql.class, "sql.product.model");
      ISqlConnection connection = logicContext.activeConnection(EDatabaseConnection.Data);
      FDataset modelDataset = connection.fetchDataset(modelSql);
      FDataFinancialProductInfo info = new FDataFinancialProductInfo();
      for(FRow modelRow : modelDataset){
         info = new FDataFinancialProductInfo();
         info.setIconUrl(modelRow.get("icon_url"));
         info.setLabel(modelRow.get("label"));
         info.setNetInvestment_total(modelRow.getFloat("netinvestment_total"));
         info.setOuid(modelRow.getLong("ouid"));
         productInfoList.push(info);
      }
      _logger.debug(this, "product", "product select all", productInfoList.count());
      return productInfoList;
   }
   
}
