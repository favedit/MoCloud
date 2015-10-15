package com.ahyc.eai.batch.statistics.financial.customer;

import com.ahyc.eai.batch.common.FStatisticsPoolConsole;
import com.ahyc.eai.batch.statistics.financial.member.IStatisticsMemberConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FDoubles;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>统计投标控制台。</T>
//============================================================
public class FStatisticsCustomerConsole
      extends FStatisticsPoolConsole<FStatisticsFinancialCustomerUnit>
      implements
         IStatisticsCustomerConsole
{
   // 资源访问接口
   private final static IResource _resource = RResource.find(FStatisticsCustomerConsole.class);

   // 成员控制台
   @ALink
   protected IStatisticsMemberConsole _memberConsole;

   //============================================================
   // <T>构造金融用户控制台。</T>
   //============================================================
   public FStatisticsCustomerConsole(){
      super(FStatisticsFinancialCustomerUnit.class);
   }

   //============================================================
   // <T>查询指定时间的投资信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param date 时间
   // @return 投资
   //============================================================
   @Override
   public double fetchInvestment(ILogicContext logicContext,
                                 TDateTime date){
      FSql sql = _resource.findString(FSql.class, "sql.investment.total");
      sql.bindDateTime("date", date);
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.STATISTICS);
      double amount = connection.executeDouble(sql);
      return amount;
   }

   //============================================================
   // <T>以天为单位查询开始时间到结束时间的投资信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param beginDate 开始时间
   // @param endDate 结束时间
   // @return 投资信息
   //============================================================
   @Override
   public FDoubles fetchDayInvestments(ILogicContext logicContext,
                                       TDateTime beginDate,
                                       TDateTime endDate){
      // 查询内容
      FSql sql = _resource.findString(FSql.class, "sql.investment.day");
      sql.bindDateTime("begin_date", beginDate);
      sql.bindDateTime("end_date", endDate);
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.STATISTICS);
      FDataset dataset = connection.fetchDataset(sql);
      // 建立集合
      FDictionary<Double> data = new FDictionary<Double>(Double.class);
      for(FRow row : dataset){
         String date = row.get("date");
         double value = row.getDouble("amount");
         data.set(date, new Double(value));
      }
      // 建立输出
      FDoubles doubles = new FDoubles();
      TDateTime currentDate = new TDateTime(beginDate);
      while(true){
         String date = currentDate.format("YYYYMMDD");
         Double value = data.get(date);
         doubles.append(value.doubleValue());
         currentDate.addDay(1);
         if(currentDate.get() >= endDate.get()){
            break;
         }
      }
      return doubles;
   }

   //============================================================
   // <T>根据编号同步一个理财师信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   @Override
   public FStatisticsFinancialCustomerUnit syncByLinkId(FLogicContext logicContext,
                                                        long linkId){
      // 检查参数
      if(linkId == 0){
         return null;
      }
      // 查找单元
      String code = Long.toString(linkId);
      FStatisticsFinancialCustomerUnit unit = _pool.find(code);
      if(unit != null){
         return unit;
      }
      // 查找单元
      FStatisticsFinancialCustomerLogic logic = logicContext.findLogic(FStatisticsFinancialCustomerLogic.class);
      unit = logic.search("LINK_ID=" + linkId);
      if(unit != null){
         return unit;
      }
      //............................................................
      // 查找成员
      FStatisticsFinancialMemberUnit memberUnit = _memberConsole.syncByLinkId(logicContext, linkId);
      if(memberUnit == null){
         return null;
      }
      //............................................................
      // 新建单元
      unit = logic.doPrepare();
      unit.setOuid(memberUnit.ouid());
      unit.setLinkId(linkId);
      unit.linkDate().assign(memberUnit.updateDate());
      unit.setLabel(memberUnit.label());
      unit.setCard(memberUnit.card());
      unit.setCardArea(memberUnit.cardArea());
      unit.setCardBirth(memberUnit.cardBirth());
      unit.setCardGender(memberUnit.cardGender());
      unit.setPhone(memberUnit.phone());
      unit.registerDate().assign(memberUnit.registerDate());
      logic.doInsert(unit);
      //............................................................
      // 更新用户信息
      if(memberUnit.customerId() == 0){
         memberUnit.setCustomerId(unit.ouid());
         FStatisticsFinancialMemberLogic memberLogic = logicContext.findLogic(FStatisticsFinancialMemberLogic.class);
         memberLogic.doUpdate(memberUnit);
      }
      return unit;
   }

   //============================================================
   // <T>根据编号更新一个客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   @Override
   public FStatisticsFinancialCustomerUnit updateByLinkId(FLogicContext logicContext,
                                                          long linkId){
      // 更新成员信息
      FStatisticsFinancialMemberUnit memberUnit = _memberConsole.updateByLinkId(logicContext, linkId);
      if(memberUnit == null){
         return null;
      }
      //............................................................
      // 更新客户信息
      FStatisticsFinancialCustomerLogic logic = logicContext.findLogic(FStatisticsFinancialCustomerLogic.class);
      FStatisticsFinancialCustomerUnit unit = logic.search("LINK_ID=" + linkId);
      if(unit != null){
         unit.setLabel(memberUnit.label());
         unit.setCard(memberUnit.card());
         unit.setCardArea(memberUnit.cardArea());
         unit.setCardBirth(memberUnit.cardBirth());
         unit.setCardGender(memberUnit.cardGender());
         unit.setPhone(memberUnit.phone());
         logic.doUpdate(unit);
      }
      return unit;
   }
}
