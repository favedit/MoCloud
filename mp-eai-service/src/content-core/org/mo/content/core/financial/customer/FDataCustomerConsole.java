package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>客户投资控制台。</T>
//============================================================
public class FDataCustomerConsole
      extends FAbstractLogicUnitConsole<FDataFinancialCustomerLogic, FDataFinancialCustomerUnit>
      implements
         IDataCustomerConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FDataCustomerConsole.class);

   // 资源访问接口
   private static IResource _resource = RResource.find(FDataCustomerConsole.class);

   //============================================================
   // <T>构造控制台。</T>
   //============================================================
   public FDataCustomerConsole(){
      super(FDataFinancialCustomerLogic.class, FDataFinancialCustomerUnit.class);
   }

   // ============================================================
   // <T>获取理财师的客户</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 日期
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataCustomerInfo> fetchInvestmentByMarketerId(ILogicContext logicContext,
                                                                       long marketerId){
      if(marketerId == 0){
         throw new FFatalError("marketer id can not be empty!");
      }
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.DATA);
      FSql sql = _resource.findString(FSql.class, "sql.customre.tender.sum");
      sql.bindLong("marketer_id", 5);
      FLogicDataset<FDataCustomerInfo> customerTenderList = new FLogicDataset<>(FDataCustomerInfo.class);
      _logger.debug(this, "process", "Send statistics tender info. (sql={1}, )", sql.toString());
      FDataset dataset = connection.fetchDataset(sql);
      for(FRow row : dataset){
         FDataCustomerInfo info = new FDataCustomerInfo();
         info.setLabel(row.get("label"));
         info.setRate(row.getDouble("rate"));
         info.setInvestmentTotal(row.getDouble("investment_total"));
         customerTenderList.push(info);
      }
      return customerTenderList;
   }

}
