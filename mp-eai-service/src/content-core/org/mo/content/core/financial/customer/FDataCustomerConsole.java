package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.content.core.financial.member.IDataMemberConsole;
import org.mo.core.aop.face.ALink;
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

   // 成员控制器
   @ALink
   protected IDataMemberConsole _memberConsole;

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
   public FLogicDataset<FDataCustomerProductInfo> fetchProductInvestmentByMarketerId(ILogicContext logicContext,
                                                                                     long marketerId){
      if(marketerId == 0){
         throw new FFatalError("marketer id can not be empty!");
      }
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.DATA);
      FSql sql = _resource.findString(FSql.class, "sql.customer.product.sum");
      sql.bindLong("marketer_id", marketerId);
      FLogicDataset<FDataCustomerProductInfo> customerTenderList = new FLogicDataset<>(FDataCustomerProductInfo.class);
      _logger.debug(this, "FetchProductInvestmentByMarketerId", "FetchProductInvestmentByMarketerId create customer product sum sql finish. (sql={1}, )", sql.toString());
      FDataset dataset = connection.fetchDataset(sql);
      for(FRow row : dataset){
         FDataCustomerProductInfo info = new FDataCustomerProductInfo();
         info.setLabel(row.get("label"));
         info.setRate(row.getDouble("rate"));
         info.setInvestmentTotal(row.getDouble("investment_total"));
         customerTenderList.push(info);
      }
      return customerTenderList;
   }

   // ============================================================
   // <T>获取理财师的客户</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 日期
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataCustomerInfo> fetchByMarketerId(ILogicContext logicContext,
                                                             long marketerId,
                                                             int pageNumber,
                                                             int pageSize){
      if(marketerId == 0){
         throw new FFatalError("marketer id can not be empty");
      }
      if(pageNumber <= 0){
         pageNumber = 1;
      }
      FDataFinancialCustomerLogic logic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialCustomerLogic.MARKETER_ID, " = ");
      whereSql.append(marketerId);
      FLogicDataset<FDataCustomerInfo> customerList = logic.fetchClass(FDataCustomerInfo.class, whereSql);
      for(FDataCustomerInfo info : customerList){
         FDataFinancialMemberUnit member = _memberConsole.find(logicContext, info.ouid());
         if(member != null){
            info.setIconUrl(member.iconUrl());
            info.setLabel(member.label());
            info.setLastLoginDate(member.lastLoginDate());
         }
      }
      return customerList;
   }

   // ============================================================
   // <T>获取理财师的指定名称客户</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 理财师编号
   // @param label 客户名称
   // @param pageNumber 当前面
   // @param PageSize 总页数
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataCustomerInfo> fetchByMarketerId(ILogicContext logicContext,
                                                             long marketerId,
                                                             String label,
                                                             int pageNumber,
                                                             int pageSize){
      if(marketerId == 0){
         throw new FFatalError("marketer id can not be empty");
      }
      if(pageNumber <= 0){
         pageNumber = 1;
      }
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.DATA);
      FSql sql = _resource.findString(FSql.class, "sql.customer.label");
      sql.bindLong("marketer_id", marketerId);
      sql.bindString("label", label);
      FLogicDataset<FDataCustomerInfo> customerList = new FLogicDataset<>(FDataCustomerInfo.class);
      _logger.debug(this, "FetchByMarketerId", "FetchByMarketerId create customer sql.customer.label sql finish. (sql={1}, )", sql.toString());
      FDataset dataset = connection.fetchDataset(sql);
      for(FRow row : dataset){
         FDataCustomerInfo info = new FDataCustomerInfo();
         info.setIconUrl(row.get("icon_url"));
         info.setLabel(row.get("label"));
         info.setInvestmentTotal(row.getDouble("investment_total"));
         info.setRedemptionTotal(row.getDouble("redemption_total"));
         info.setNetinvestment(row.getDouble("netinvestment"));
         info.setLastLoginDate(RDateTime.parseDateTime(row.get("last_login_date")));
         info.setInvestmentTotal(row.getDouble("investment_total"));
         customerList.push(info);
      }
      return customerList;
   }
}
