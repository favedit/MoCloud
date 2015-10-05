package com.ahyc.eai.batch.statistics.financial.dynamic;

import com.ahyc.eai.batch.common.FStatisticsPeriodCalculater;
import com.ahyc.eai.batch.statistics.financial.customer.IStatisticsCustomerConsole;
import com.ahyc.eai.batch.statistics.financial.department.IStatisticsDepartmentConsole;
import com.ahyc.eai.batch.statistics.financial.marketer.IStatisticsMarketerConsole;
import com.ahyc.eai.batch.statistics.financial.member.IStatisticsMemberConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialAmountLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialAmountUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialPhaseUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;

//============================================================
// <T>金融动态统计计算器。</T>
//============================================================
public class FStatisticsDynamicCalculater
      extends FStatisticsPeriodCalculater
{
   // 合计间隔(1小时)
   protected long _recordSpan = 1000 * 60 * 10;

   // 成员控制台接口
   protected IStatisticsMemberConsole _memberConsole;

   // 客户控制台接口
   protected IStatisticsCustomerConsole _customerConsole;

   // 理财师控制台接口
   protected IStatisticsMarketerConsole _marketerConsole;

   // 部门控制台接口
   protected IStatisticsDepartmentConsole _departmentConsole;

   //============================================================
   // <T>构造金融动态统计计算器。</T>
   //============================================================
   public FStatisticsDynamicCalculater(){
      _processCode = "financial.dynamic";
      _periodField = "CUSTOMER_ACTION_DATE";
      _periodTable = "ST_FIN_DYNAMIC";
      _memberConsole = RAop.find(IStatisticsMemberConsole.class);
      _customerConsole = RAop.find(IStatisticsCustomerConsole.class);
      _marketerConsole = RAop.find(IStatisticsMarketerConsole.class);
      _departmentConsole = RAop.find(IStatisticsDepartmentConsole.class);
   }

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   @Override
   public void processPhase(FLogicContext logicContext,
                            String beginDate,
                            String endDate){
      // 代码修正
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      FStatisticsFinancialAmountLogic amountLogic = logicContext.findLogic(FStatisticsFinancialAmountLogic.class);
      FStatisticsFinancialMemberLogic memberLogic = logicContext.findLogic(FStatisticsFinancialMemberLogic.class);
      FStatisticsFinancialCustomerLogic customerLogic = logicContext.findLogic(FStatisticsFinancialCustomerLogic.class);
      FStatisticsFinancialMarketerLogic marketerLogic = logicContext.findLogic(FStatisticsFinancialMarketerLogic.class);
      FStatisticsFinancialDepartmentLogic departmentLogic = logicContext.findLogic(FStatisticsFinancialDepartmentLogic.class);
      FStatisticsFinancialPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialPhaseLogic.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      FSql dynamicSql = new FSql("CUSTOMER_ACTION_DATE > STR_TO_DATE({begin_date},'%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE <= STR_TO_DATE({end_date},'%Y%m%d%H%i%s')");
      dynamicSql.bindString("begin_date", beginDate);
      dynamicSql.bindString("end_date", endDate);
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch(dynamicSql, "CUSTOMER_ACTION_DATE");
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         long recordId = dynamicUnit.ouid();
         long departmentId = dynamicUnit.departmentLinkId();
         long marketerId = dynamicUnit.marketerLinkId();
         long customerId = dynamicUnit.customerLinkId();
         int customerActionCd = dynamicUnit.customerActionCd();
         TDateTime customerActionDate = dynamicUnit.customerActionDate();
         double customerActionAmount = dynamicUnit.customerActionAmount();
         double customerActionInterest = dynamicUnit.customerActionInterest();
         //............................................................
         // 统计成员信息
         if(customerId > 0){
            boolean changed = false;
            FStatisticsFinancialMemberUnit memberUnit = _memberConsole.syncByLinkId(logicContext, dynamicUnit.customerLinkId());
            // 设置投资时间
            if(memberUnit.investmentDate().isEmpty()){
               if(customerActionCd == EGcFinancialCustomerAction.Investment){
                  memberUnit.investmentDate().assign(customerActionDate);
                  changed = true;
               }
            }
            // 设置赎回时间
            if(memberUnit.redemptionDate().isEmpty()){
               if(customerActionCd == EGcFinancialCustomerAction.Redemption){
                  memberUnit.redemptionDate().assign(customerActionDate);
                  changed = true;
               }
            }
            if(changed){
               memberLogic.doUpdate(memberUnit);
            }
         }
         //............................................................
         // 统计客户信息
         boolean customerExist = false;
         if(customerId > 0){
            FStatisticsFinancialCustomerUnit customerUnit = _customerConsole.syncByLinkId(logicContext, dynamicUnit.customerLinkId());
            customerExist = customerUnit.linkCd() > 0;
            customerUnit.setLinkCd(1);
            customerUnit.linkDate().assign(customerActionDate);
            double customerInvestmentTotal = customerUnit.investmentTotal();
            double customerRedemptionTotal = customerUnit.redemptionTotal();
            double customerInterestTotal = customerUnit.interestTotal();
            if(customerActionCd == EGcFinancialCustomerAction.Investment){
               // 设置投资开始时间和结束时间
               if(customerUnit.investmentFirstDate().isEmpty()){
                  customerUnit.investmentFirstDate().assign(customerActionDate);
               }
               if(customerUnit.investmentLastDate().isEmpty()){
                  customerUnit.investmentLastDate().assign(customerActionDate);
               }else if(customerUnit.investmentLastDate().get() < customerActionDate.get()){
                  customerUnit.investmentLastDate().assign(customerActionDate);
               }
               customerUnit.setInvestmentNumber(customerUnit.investmentNumber() + 1);
               // 计算投资金额
               customerInvestmentTotal += customerActionAmount;
               customerUnit.setInvestmentTotal(customerInvestmentTotal);
            }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
               // 设置赎回开始时间和结束时间
               if(customerUnit.redemptionFirstDate().isEmpty()){
                  customerUnit.redemptionFirstDate().assign(customerActionDate);
               }
               if(customerUnit.redemptionLastDate().isEmpty()){
                  customerUnit.redemptionLastDate().assign(customerActionDate);
               }else if(customerUnit.redemptionLastDate().get() < customerActionDate.get()){
                  customerUnit.redemptionLastDate().assign(customerActionDate);
               }
               customerUnit.setRedemptionNumber(customerUnit.redemptionNumber() + 1);
               // 计算赎回金额
               customerRedemptionTotal += customerActionAmount;
               customerUnit.setRedemptionTotal(customerRedemptionTotal);
               customerInterestTotal += customerActionInterest;
               customerUnit.setInterestTotal(customerInterestTotal);
            }else{
               throw new FFatalError("Customer action invalid.");
            }
            customerUnit.setNetinvestmentTotal(customerInvestmentTotal - customerRedemptionTotal);
            customerLogic.doUpdate(customerUnit);
         }
         //............................................................
         // 统计理财师信息
         boolean marketerExist = false;
         if(marketerId > 0){
            FStatisticsFinancialMarketerUnit marketerUnit = _marketerConsole.syncByLinkId(logicContext, dynamicUnit.marketerLinkId());
            marketerExist = marketerUnit.linkCd() > 0;
            marketerUnit.setLinkCd(1);
            double marketerInvestmentTotal = marketerUnit.investmentTotal();
            double marketerRedemptionTotal = marketerUnit.redemptionTotal();
            double marketerInterestTotal = marketerUnit.interestTotal();
            if(customerActionCd == EGcFinancialCustomerAction.Investment){
               marketerInvestmentTotal += customerActionAmount;
               marketerUnit.setInvestmentTotal(marketerInvestmentTotal);
            }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
               marketerRedemptionTotal += customerActionAmount;
               marketerUnit.setRedemptionTotal(marketerRedemptionTotal);
               marketerInterestTotal += customerActionInterest;
               marketerUnit.setInterestTotal(marketerInterestTotal);
            }else{
               throw new FFatalError("Customer action invalid.");
            }
            marketerUnit.setNetinvestmentTotal(marketerInvestmentTotal - marketerRedemptionTotal);
            marketerLogic.doUpdate(marketerUnit);
         }
         //............................................................
         // 统计部门信息
         boolean departmentExist = false;
         if(departmentId > 0){
            FStatisticsFinancialDepartmentUnit departmentUnit = _departmentConsole.syncByLinkId(logicContext, dynamicUnit.departmentLinkId());
            departmentExist = departmentUnit.linkCd() > 0;
            departmentUnit.setLinkCd(1);
            departmentUnit.linkDate().assign(customerActionDate);
            double departmentInvestmentTotal = departmentUnit.investmentTotal();
            double departmentRedemptionTotal = departmentUnit.redemptionTotal();
            double departmentInterestTotal = departmentUnit.interestTotal();
            if(customerActionCd == EGcFinancialCustomerAction.Investment){
               departmentInvestmentTotal += customerActionAmount;
               departmentUnit.setInvestmentTotal(departmentInvestmentTotal);
            }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
               departmentRedemptionTotal += customerActionAmount;
               departmentUnit.setRedemptionTotal(departmentRedemptionTotal);
               departmentInterestTotal += customerActionInterest;
               departmentUnit.setInterestTotal(departmentInterestTotal);
            }else{
               throw new FFatalError("Customer action invalid.");
            }
            departmentUnit.setNetinvestmentTotal(departmentInvestmentTotal - departmentRedemptionTotal);
            departmentLogic.doUpdate(departmentUnit);
         }
         //............................................................
         // 统计合计信息
         FStatisticsFinancialAmountUnit amountUnit = amountLogic.search("OUID=1");
         boolean amountExist = (amountUnit != null);
         if(!amountExist){
            amountUnit = amountLogic.doPrepare();
         }
         // 计算资金信息
         double investmentTotal = amountUnit.investmentTotal();
         int investmentNumberTotal = amountUnit.investmentNumberTotal();
         double redemptionTotal = amountUnit.redemptionTotal();
         int redemptionNumberTotal = amountUnit.redemptionNumberTotal();
         double interestTotal = amountUnit.interestTotal();
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            investmentTotal += customerActionAmount;
            amountUnit.setInvestmentTotal(investmentTotal);
            investmentNumberTotal++;
            amountUnit.setInvestmentNumberTotal(investmentNumberTotal);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            redemptionTotal += customerActionAmount;
            amountUnit.setRedemptionTotal(redemptionTotal);
            redemptionNumberTotal++;
            amountUnit.setRedemptionNumberTotal(redemptionNumberTotal);
            interestTotal += customerActionInterest;
            amountUnit.setInterestTotal(interestTotal);
         }else{
            throw new FFatalError("Marketer action invalid.");
         }
         amountUnit.setNetinvestmentTotal(investmentTotal - redemptionTotal);
         // 计算客户信息
         int customerTotal = amountUnit.customerTotal();
         if((customerId > 0) && !customerExist){
            customerTotal++;
            amountUnit.setCustomerTotal(customerTotal);
         }
         // 计算客户信息
         int marketerTotal = amountUnit.marketerTotal();
         if((marketerId > 0) && !marketerExist){
            marketerTotal++;
            amountUnit.setMarketerTotal(marketerTotal);
         }
         // 计算客户信息
         int departmentTotal = amountUnit.departmentTotal();
         if((departmentId > 0) && !departmentExist){
            departmentTotal++;
            amountUnit.setDepartmentTotal(departmentTotal);
         }
         if(amountExist){
            amountLogic.doUpdate(amountUnit);
         }else{
            amountLogic.doInsert(amountUnit);
         }
         //............................................................
         // 插入用户数据
         TDateTime spanDate = new TDateTime(customerActionDate.get());
         spanDate.truncate(_recordSpan);
         FStatisticsFinancialPhaseUnit phaseUnit = phaseLogic.search("RECORD_DATE=STR_TO_DATE('" + spanDate.format() + "','%Y%m%d%H%i%s')");
         boolean phaseExist = (phaseUnit != null);
         if(!phaseExist){
            // 设置初步数据
            phaseUnit = phaseLogic.doPrepare();
            phaseUnit.recordYear().parse(spanDate.format("YYYY0101000000"));
            phaseUnit.recordMonth().parse(spanDate.format("YYYYMM01000000"));
            phaseUnit.recordWeek().parse(spanDate.format("YYYYMMWK000000"));
            phaseUnit.recordDay().parse(spanDate.format("YYYYMMDD000000"));
            phaseUnit.recordHour().parse(spanDate.format("YYYYMMDDHH240000"));
            phaseUnit.recordDate().assign(spanDate);
            // 获得用户注册数
            // int memberCount = calculateMemberCount(sourceConnection, beginDate, endDate);
            // phaseUnit.setMemberCount(memberCount);
            // 获得用户总数
            // int memberTotal = calculateMemberTotal(sourceConnection, beginDate, endDate);
            // phaseUnit.setMemberTotal(memberTotal);
         }
         phaseUnit.setLinkId(recordId);
         phaseUnit.linkDate().assign(dynamicUnit.updateDate());
         phaseUnit.actionDate().assign(dynamicUnit.customerActionDate());
         // 计算客户信息
         if(!customerExist){
            phaseUnit.setCustomerCount(phaseUnit.customerCount() + 1);
         }
         phaseUnit.setCustomerTotal(customerTotal);
         // 计算理财师信息
         if((marketerId > 0) && !marketerExist){
            phaseUnit.setMarketerCount(phaseUnit.marketerCount() + 1);
         }
         phaseUnit.setMarketerTotal(marketerTotal);
         // 计算部门信息
         if((departmentId > 0) && !departmentExist){
            phaseUnit.setDepartmentCount(phaseUnit.departmentCount() + 1);
         }
         phaseUnit.setDepartmentTotal(departmentTotal);
         // 计算资金信息
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            phaseUnit.setInvestment(phaseUnit.investment() + customerActionAmount);
            phaseUnit.setInvestmentNumber(phaseUnit.investmentNumber() + 1);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            phaseUnit.setRedemption(phaseUnit.redemption() + customerActionAmount);
            phaseUnit.setRedemptionNumber(phaseUnit.redemptionNumber() + 1);
         }else{
            throw new FFatalError("Marketer action invalid.");
         }
         phaseUnit.setInvestmentTotal(investmentTotal);
         phaseUnit.setInvestmentNumberTotal(investmentNumberTotal);
         phaseUnit.setRedemptionTotal(redemptionTotal);
         phaseUnit.setRedemptionNumberTotal(redemptionNumberTotal);
         phaseUnit.setNetinvestment(phaseUnit.investment() - phaseUnit.redemption());
         phaseUnit.setNetinvestmentTotal(investmentTotal - redemptionTotal);
         phaseUnit.setInterestTotal(interestTotal);
         // 更新数据
         if(phaseExist){
            phaseLogic.doUpdate(phaseUnit);
         }else{
            phaseLogic.doInsert(phaseUnit);
         }
         // 统计处理
         processOnce();
      }
   }
}
