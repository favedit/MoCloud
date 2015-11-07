package org.mo.content.core.financial.tender;

import com.cyou.gccloud.data.data.FDataFinancialTenderLogic;
import com.cyou.gccloud.data.data.FDataFinancialTenderUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.financial.marketer.customer.IDataMarketerCustomerConsole;
import org.mo.content.core.financial.member.IDataMemberConsole;
import org.mo.content.core.product.common.ICityConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>投标控制台。</T>
//============================================================
public class FTenderConsole
      extends FAbstractLogicUnitConsole<FDataFinancialTenderLogic, FDataFinancialTenderUnit>
      implements
         ITenderConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FTenderConsole.class);

   // 每页条数
   public static final int _pageSize = 12;

   // 成员控制器
   @ALink
   protected IDataMemberConsole _memberConsole;

   // 成员控制器
   @ALink
   protected IDataMarketerCustomerConsole _marketerCustomerConsole;

   // 城市控制器
   @ALink
   protected ICityConsole _cityConsole;

   //============================================================
   // <T>投标控制台。</T>
   //============================================================
   public FTenderConsole(){
      super(FDataFinancialTenderLogic.class, FDataFinancialTenderUnit.class);
   }

   //============================================================
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @return 插入结果
   //============================================================
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

   //============================================================
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @param pageNum 页码
   // @return 插入结果
   //============================================================
   @Override
   public FLogicDataset<FDataFinancialTenderInfo> selectByMarkterIdAndProductId(ILogicContext logicContext,
                                                                                long marketerId,
                                                                                long productId,
                                                                                int pageNum){
      //      //MarketerCustomerLogic
      //      FDataFinancialMarketerCustomerLogic logic = logicContext.findLogic(FDataFinancialMarketerCustomerLogic.class);
      //      //TenderLogic
      //      FDataFinancialTenderLogic logic1 = logicContext.findLogic(FDataFinancialTenderLogic.class);
      //      FSql whereSql = new FSql();
      //      whereSql.append(FDataFinancialMarketerCustomerLogic.MARKETER_ID, " = '{marketerId}'");
      //      whereSql.bind("marketerId", RString.parse(marketerId));
      //      FLogicDataset<FDataFinancialMarketerCustomerInfo> unitList = logic.fetchClass(FDataFinancialMarketerCustomerInfo.class, whereSql);
      //      FSql whereSql2 = new FSql();
      //      whereSql2.append(FDataFinancialTenderLogic.CUSTOMER_ID, " = '{customerId}'");
      //      whereSql2.bind("customerId", RString.parse(0));
      //      FLogicDataset<FDataFinancialTenderInfo> tenderList = logic1.fetchClass(FDataFinancialTenderInfo.class, whereSql2);
      //      for(FDataFinancialMarketerCustomerInfo maketerCustomer : unitList){
      //         FSql whereSql1 = new FSql();
      //         whereSql1.append(FDataFinancialTenderLogic.CUSTOMER_ID, " = '{customerId}'");
      //         whereSql1.bind("customerId", RString.parse(maketerCustomer.customerId()));
      //         FLogicDataset<FDataFinancialTenderInfo> infoList = logic1.fetchClass(FDataFinancialTenderInfo.class, whereSql1);
      //         for(FDataFinancialTenderInfo info : infoList){
      //            if(info.productId() == productId){
      //               FDataFinancialMemberUnit member = _memberConsole.find(logicContext, info.customerId());
      //               if(null != member){
      //                  //获取城市
      //                  FDataCommonCityUnit city = _cityConsole.find(logicContext, member.cityId());
      //                  if(city != null){
      //                     info.setCityLabel(city.label());
      //                  }
      //                  info.setMemberLabel(member.label());
      //                  info.setMemberPhone(member.phone());
      //                  //性别
      //                  info.setGenderLabel(EGcPersonGender.formatLabel(member.genderCd()));
      //                  info.setMemberLastLoginDate(member.lastLoginDate());
      //                  tenderList.pushUnique(info);
      //               }
      //            }
      //         }
      //      }
      //      _logger.debug(this, "tender", "tender select  '{customerId}'", tenderList.count());
      //      return tenderList.makePage(pageNum, _pageSize);
      return null;
   }

   //============================================================
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @param productId 产品编号
   // @return 插入结果
   //============================================================
   @Override
   public int selectByMarkterIdAndProductId(ILogicContext logicContext,
                                            long marketerId,
                                            long productId){
      //      //MarketerCustomerLogic
      //
      //      FDataFinancialMarketerCustomerLogic logic = logicContext.findLogic(FDataFinancialMarketerCustomerLogic.class);
      //      FSql whereSql = new FSql();
      //      whereSql.append(FDataFinancialMarketerCustomerLogic.MARKETER_ID, " = '{marketerId}'");
      //      whereSql.bind("marketerId", RString.parse(marketerId));
      //      FLogicDataset<FDataFinancialMarketerCustomerInfo> unitList = logic.fetchClass(FDataFinancialMarketerCustomerInfo.class, whereSql);
      //      //TenderLogic
      //      FDataFinancialTenderLogic logic1 = logicContext.findLogic(FDataFinancialTenderLogic.class);
      //      FSql whereSql2 = new FSql();
      //      whereSql2.append(FDataFinancialTenderLogic.CUSTOMER_ID, " = '{customerId}'");
      //      whereSql2.bind("customerId", RString.parse(0));
      //      FLogicDataset<FDataFinancialTenderInfo> tenderList = logic1.fetchClass(FDataFinancialTenderInfo.class, whereSql2);
      //      for(FDataFinancialMarketerCustomerInfo maketerCustomer : unitList){
      //         FSql whereSql1 = new FSql();
      //         whereSql1.append(FDataFinancialTenderLogic.CUSTOMER_ID, " = '{customerId}'");
      //         whereSql1.bind("customerId", RString.parse(maketerCustomer.customerId()));
      //         FLogicDataset<FDataFinancialTenderInfo> infoList = logic1.fetchClass(FDataFinancialTenderInfo.class, whereSql1);
      //         for(FDataFinancialTenderInfo info : infoList){
      //            if(info.productId() == productId){
      //               FDataFinancialMemberUnit member = _memberConsole.find(logicContext, info.customerId());
      //               if(null != member){
      //                  tenderList.pushUnique(info);
      //               }
      //            }
      //         }
      //      }
      //      _logger.debug(this, "tender", "tender select count '{customerId}'", tenderList.count());
      //      return tenderList.count();
      return 0;
   }

   //============================================================
   // <T>查询产品编号</T>
   //
   // @param logicContext 逻辑环境
   // @param tenderId 
   // @return 插入结果
   //============================================================
   @Override
   public int selectByTenderId(ILogicContext logicContext,
                               long tenderId){
      FDataFinancialTenderLogic logic = logicContext.findLogic(FDataFinancialTenderLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialTenderLogic.OUID, " = '{tenderId}'");
      whereSql.bind("tenderId", RString.parse(tenderId));
      FDataFinancialTenderUnit tender = logic.search(whereSql);
      _logger.debug(this, "tender", "tender select productId '{customerId}'", tender.productId());
      return tender.productId();
   }

}
