package org.mo.content.core.financial.customer.tender;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import com.cyou.gccloud.data.data.FDataFinancialCustomerTenderLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerTenderUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import com.cyou.gccloud.data.data.FDataFinancialTenderLogic;
import com.cyou.gccloud.define.enums.core.EGcPersonGender;
import java.util.Date;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.content.core.common.EDatabaseConnection;
import org.mo.content.core.financial.customer.FDataFinancialCustomerInfo;
import org.mo.content.core.financial.customer.ICustomerConsole;
import org.mo.content.core.financial.marketer.customer.IDataMarketerCustomerConsole;
import org.mo.content.core.financial.member.IDataMemberConsole;
import org.mo.content.core.financial.tender.FDataFinancialTenderInfo;
import org.mo.content.core.financial.tender.ITenderConsole;
import org.mo.content.core.product.common.ICityConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>投标控制台。</T>
//============================================================
public class FCustomerTenderConsole
      extends FAbstractLogicUnitConsole<FDataFinancialCustomerTenderLogic, FDataFinancialCustomerTenderUnit>
      implements
         ICustomerTenderConsole
{
   // 日志输出接口
   private static ILogger                 _logger   = RLogger.find(FCustomerTenderConsole.class);
                                                    
   // 每页条数
   public static final int                _pageSize = 7;
                                                    
   // 成员控制器
   @ALink
   protected IDataMemberConsole           _memberConsole;
                                          
   // 理财师成员控制器
   @ALink
   protected IDataMarketerCustomerConsole _marketerCustomerConsole;
                                          
   // 客户控制器
   @ALink
   protected ICustomerConsole             _customerConsole;
                                          
   // 客户控制器
   @ALink
   protected ITenderConsole               _tenderConsole;
                                          
   // 城市控制器
   @ALink
   protected ICityConsole                 _cityConsole;
                                          
   // 资源访问接口
   private static IResource               _resource = RResource.find(FCustomerTenderConsole.class);
                                                    
   // ============================================================
   // <T>投标控制台。</T>
   // ============================================================
   public FCustomerTenderConsole(){
      super(FDataFinancialCustomerTenderLogic.class, FDataFinancialCustomerTenderUnit.class);
   }
   
   // ============================================================
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @return 插入结果
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialTenderInfo> select(ILogicContext logicContext,
                                                         long marketerId,
                                                         long productId){
      if(marketerId == 0 || productId == 0){
         throw new FFatalError("marketerId or customerId is null");
      }
      FDataFinancialTenderLogic logic = logicContext.findLogic(FDataFinancialTenderLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialTenderLogic.PRODUCT_ID, " = '{productId}'");
      whereSql.bind("productId", RString.parse(productId));
      FLogicDataset<FDataFinancialTenderInfo> unitList = logic.fetchClass(FDataFinancialTenderInfo.class, whereSql);
      return unitList;
   }
   
   // ============================================================
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @param pageNum 页码
   // @return 插入结果
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialCustomerTenderInfo> selectByMarkterIdAndProductId(ILogicContext logicContext,
                                                                                        long marketerId,
                                                                                        long productId,
                                                                                        int pageNum){
      FLogicDataset<FDataFinancialCustomerInfo> customerList = _customerConsole.selectByMarketerId(logicContext, marketerId);
      FDataFinancialCustomerTenderLogic logic = logicContext.findLogic(FDataFinancialCustomerTenderLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialCustomerTenderLogic.CUSTOMER_ID, " = '{customerId}'");
      whereSql.bind("customerId", RString.parse(0));
      FLogicDataset<FDataFinancialCustomerTenderInfo> customerTenderList = logic.fetchClass(FDataFinancialCustomerTenderInfo.class, whereSql);
      FLogicDataset<FDataFinancialCustomerTenderInfo> customerTender = null;
      FDataFinancialMemberUnit member = null;
      FDataCommonCityUnit city = null;
      for(FDataFinancialCustomerInfo customer : customerList){
         FSql whereSql1 = new FSql();
         whereSql1.append(FDataFinancialCustomerTenderLogic.CUSTOMER_ID, " = '{customerId}'");
         whereSql1.bind("customerId", RString.parse(customer.ouid()));
         customerTender = logic.fetchClass(FDataFinancialCustomerTenderInfo.class, whereSql1);
         for(FDataFinancialCustomerTenderInfo info : customerTender){
            if(_tenderConsole.selectByTenderId(logicContext, info.tenderId()) == productId){
               member = _memberConsole.find(logicContext, info.customerId());
               if(null != member){
                  // 获取城市
                  city = _cityConsole.find(logicContext, member.cityId());
                  if(city != null){
                     info.setCityLabel(city.label());
                  }
                  info.setMemberLabel(member.label());
                  info.setMemberPhone(member.phone());
                  // 性别
                  info.setGenderLabel(EGcPersonGender.formatLabel(member.genderCd()));
                  info.setMemberLastLoginDate(member.lastLoginDate());
                  customerTenderList.pushUnique(info);
               }
            }
         }
      }
      _logger.debug(this, "tender", "tender select  '{customerId}'", customerTenderList.count());
      return customerTenderList.makePage(pageNum, _pageSize);
   }
   
   // ============================================================
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @param productId 产品编号
   // @return 插入结果
   // ============================================================
   @Override
   public int selectByMarkterIdAndProductId(ILogicContext logicContext,
                                            long marketerId,
                                            long productId){
      FSql modelSql = _resource.findString(FSql.class, "sql.customerTender.model.nopage");
      modelSql.bind("marketerId", RString.parse(marketerId));
      modelSql.bind("productId", RString.parse(productId));
      ISqlConnection connection = logicContext.activeConnection(EDatabaseConnection.Data);
      FDataset modelDataset = connection.fetchDataset(modelSql);
      _logger.debug(this, "count", "customerTender select  '{customerId}' '{productId}'", modelDataset.count());
      return modelDataset.count();
   }
   
   // ============================================================
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @param pageNum 页码
   // @return 插入结果
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialCustomerTenderInfo> selectByProductIdAndMarkterId(ILogicContext logicContext,
                                                                                        long marketerId,
                                                                                        long productId,
                                                                                        int pageNum){
                                                                                        
      FSql modelSql = _resource.findString(FSql.class, "sql.customerTender.model");
      modelSql.bind("marketerId", RString.parse(marketerId));
      modelSql.bind("productId", RString.parse(productId));
      ISqlConnection connection = logicContext.activeConnection(EDatabaseConnection.Data);
      FDataset modelDataset = connection.fetchDataset(modelSql);
      _logger.debug(this, "customerTender", "customerTender sql  ", modelDataset.count());
      FLogicDataset<FDataFinancialCustomerTenderInfo> customerTenderList = new FLogicDataset<>(FDataFinancialCustomerTenderInfo.class);
      FDataFinancialCustomerTenderInfo customerTender = null;
      FDataCommonCityUnit city = null;
      Date lastdate = null;
      Date investment_date = null;
      for(FRow modelRow : modelDataset){
         customerTender = new FDataFinancialCustomerTenderInfo();
         city = null;
         customerTender.setCustomerId(modelRow.getLong("customerid"));
         customerTender.setMemberLabel(modelRow.get("label"));
         customerTender.setGenderLabel(EGcPersonGender.formatLabel(modelRow.getInt("gender_cd")));
         customerTender.setMemberPhone(modelRow.get("phone"));
         customerTender.setInvestment(modelRow.getFloat("investment"));
         customerTender.setRedemption(modelRow.getFloat("redemption"));
         customerTender.setNetinvestment(modelRow.getFloat("netinvestment"));
         investment_date = modelRow.getDate("investment_date");
         if(null != investment_date){
            customerTender.setInvestmentDate(new TDateTime(investment_date));
         }
         lastdate = modelRow.getDate("lastdate");
         if(null != lastdate){
            customerTender.setMemberLastLoginDate(new TDateTime(lastdate));
         }
         // 获取城市
         city = _cityConsole.find(logicContext, modelRow.getInt("city_id"));
         if(city != null){
            customerTender.setCityLabel(city.label());
         }
         customerTenderList.push(customerTender);
      }
      return customerTenderList.makePage(pageNum, _pageSize);
   }
   
   // ============================================================
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @param productId 产品编号
   // @return 插入结果
   // ============================================================
   @Override
   public FDataset getTotal(ILogicContext logicContext,
                            long marketerId,
                            long productId){
      FSql modelSql = _resource.findString(FSql.class, "sql.customerTender.model.total");
      modelSql.bind("marketerId", RString.parse(marketerId));
      modelSql.bind("productId", RString.parse(productId));
      ISqlConnection connection = logicContext.activeConnection(EDatabaseConnection.Data);
      FDataset modelDataset = connection.fetchDataset(modelSql);
      _logger.debug(this, "sum", "total select  '{marketerId}' '{productId}'", modelDataset.count());
      return modelDataset;
   }
   
}
