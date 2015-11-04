package com.ahyc.eai.batch.statistics.financial.department;

import com.ahyc.eai.batch.common.FStatisticsPeriodCalculater;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentAmountLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentAmountUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentMarketerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentMarketerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentPhaseUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.type.TDateTime;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;

//============================================================
// <T>金融部门统计计算器。</T>
//============================================================
public class FStatisticsDepartmentCalculater
      extends FStatisticsPeriodCalculater
{
   //============================================================
   // <T>构造金融部门统计计算器。</T>
   //============================================================
   public FStatisticsDepartmentCalculater(){
      _processCode = "financial.department";
      _periodField = "CUSTOMER_ACTION_DATE";
      _periodTable = "ST_FIN_DYNAMIC";
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
      FStatisticsFinancialDepartmentCustomerLogic customerLogic = logicContext.findLogic(FStatisticsFinancialDepartmentCustomerLogic.class);
      FStatisticsFinancialDepartmentMarketerLogic marketerLogic = logicContext.findLogic(FStatisticsFinancialDepartmentMarketerLogic.class);
      FStatisticsFinancialDepartmentAmountLogic amountLogic = logicContext.findLogic(FStatisticsFinancialDepartmentAmountLogic.class);
      FStatisticsFinancialDepartmentPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialDepartmentPhaseLogic.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch("DEPARTMENT_ID IS NOT NULL AND CUSTOMER_ACTION_DATE > STR_TO_DATE('" + beginDate + "','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE <= STR_TO_DATE('" + endDate
            + "','%Y%m%d%H%i%s')", "CUSTOMER_ACTION_DATE");
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         long recordId = dynamicUnit.ouid();
         long departmentId = dynamicUnit.departmentId();
         String departmentLabel = dynamicUnit.departmentLabel();
         long marketerId = dynamicUnit.marketerId();
         long customerId = dynamicUnit.customerId();
         int customerActionCd = dynamicUnit.customerActionCd();
         TDateTime customerActionDate = dynamicUnit.customerActionDate();
         double customerActionAmount = dynamicUnit.customerActionAmount();
         double customerActionInterest = dynamicUnit.customerActionInterest();
         //............................................................
         // 统计客户信息
         FStatisticsFinancialDepartmentCustomerUnit customerUnit = customerLogic.search("DEPARTMENT_ID=" + departmentId + " AND CUSTOMER_ID=" + customerId);
         boolean customerExist = (customerUnit != null);
         if(!customerExist){
            customerUnit = customerLogic.doPrepare();
            customerUnit.setDepartmentId(departmentId);
            customerUnit.setMarketerId(marketerId);
            customerUnit.setCustomerId(customerId);
         }
         customerUnit.linkDate().assign(customerActionDate);
         double customerInvestmentTotal = customerUnit.investmentTotal();
         double customerRedemptionTotal = customerUnit.redemptionTotal();
         double customerInterestTotal = customerUnit.interestTotal();
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            customerInvestmentTotal += customerActionAmount;
            customerUnit.setInvestmentTotal(customerInvestmentTotal);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            customerRedemptionTotal += customerActionAmount;
            customerUnit.setRedemptionTotal(customerRedemptionTotal);
            customerInterestTotal += customerActionInterest;
            customerUnit.setInterestTotal(customerInterestTotal);
         }else{
            throw new FFatalError("Customer action invalid.");
         }
         customerUnit.setNetinvestmentTotal(customerInvestmentTotal - customerRedemptionTotal);
         if(customerExist){
            customerLogic.doUpdate(customerUnit);
         }else{
            customerLogic.doInsert(customerUnit);
         }
         //............................................................
         // 统计理财师信息
         FStatisticsFinancialDepartmentMarketerUnit marketerUnit = marketerLogic.search("DEPARTMENT_ID=" + departmentId + " AND MARKETER_ID=" + marketerId);
         boolean marketerExist = (marketerUnit != null);
         if(!marketerExist){
            marketerUnit = marketerLogic.doPrepare();
            marketerUnit.setDepartmentId(departmentId);
            marketerUnit.setMarketerId(marketerId);
         }
         marketerUnit.linkDate().assign(customerActionDate);
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
         if(marketerExist){
            marketerLogic.doUpdate(marketerUnit);
         }else{
            marketerLogic.doInsert(marketerUnit);
         }
         //............................................................
         // 统计合计信息
         FStatisticsFinancialDepartmentAmountUnit amountUnit = amountLogic.search("DEPARTMENT_ID=" + departmentId);
         boolean amountExist = (amountUnit != null);
         if(!amountExist){
            amountUnit = amountLogic.doPrepare();
            amountUnit.setDepartmentId(departmentId);
            amountUnit.setDepartmentLabel(departmentLabel);
         }
         double investmentTotal = amountUnit.investmentTotal();
         double redemptionTotal = amountUnit.redemptionTotal();
         double interestTotal = amountUnit.interestTotal();
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            investmentTotal += customerActionAmount;
            amountUnit.setInvestmentTotal(investmentTotal);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            redemptionTotal += customerActionAmount;
            amountUnit.setRedemptionTotal(redemptionTotal);
            interestTotal += interestTotal;
            amountUnit.setInterestTotal(interestTotal);
         }else{
            throw new FFatalError("Customer action invalid.");
         }
         amountUnit.setNetinvestmentTotal(investmentTotal - redemptionTotal);
         // 计算理财师信息
         int marketerTotal = amountUnit.marketerTotal();
         if(!marketerExist){
            marketerTotal += 1;
            amountUnit.setMarketerTotal(marketerTotal);
         }
         // 计算客户信息
         int customerTotal = amountUnit.customerTotal();
         if(!customerExist){
            customerTotal += 1;
            amountUnit.setCustomerTotal(customerTotal);
         }
         if(amountExist){
            amountLogic.doUpdate(amountUnit);
         }else{
            amountLogic.doInsert(amountUnit);
         }
         //............................................................
         // 插入用户数据
         TDateTime spanDate = new TDateTime();
         spanDate.parse(customerActionDate.format("YYYYMMDDHH24"), "YYYYMMDDHH24");
         FStatisticsFinancialDepartmentPhaseUnit phaseUnit = phaseLogic.search("DEPARTMENT_ID=" + departmentId + " AND RECORD_DATE=STR_TO_DATE('" + spanDate.format() + "','%Y%m%d%H%i%s')");
         boolean phaseExist = (phaseUnit != null);
         if(!phaseExist){
            phaseUnit = phaseLogic.doPrepare();
            phaseUnit.recordYear().parse(spanDate.format("YYYY0101000000"));
            phaseUnit.recordMonth().parse(spanDate.format("YYYYMM01000000"));
            phaseUnit.recordWeek().parse(spanDate.format("YYYYMMWK000000"));
            phaseUnit.recordDay().parse(spanDate.format("YYYYMMDD000000"));
            phaseUnit.recordHour().parse(spanDate.format("YYYYMMDDHH240000"));
            phaseUnit.recordDate().assign(spanDate);
            // 设置部门信息
            phaseUnit.setDepartmentId(dynamicUnit.departmentId());
            phaseUnit.setDepartmentLinkId(dynamicUnit.departmentLinkId());
            phaseUnit.setDepartmentLabel(dynamicUnit.departmentLabel());
            phaseUnit.setDepartmentLevel1Id(dynamicUnit.departmentLevel1Id());
            phaseUnit.setDepartmentLevel1LinkId(dynamicUnit.departmentLevel1LinkId());
            phaseUnit.setDepartmentLevel1Label(dynamicUnit.departmentLevel1Label());
            phaseUnit.setDepartmentLevel2Id(dynamicUnit.departmentLevel2Id());
            phaseUnit.setDepartmentLevel2LinkId(dynamicUnit.departmentLevel2LinkId());
            phaseUnit.setDepartmentLevel2Label(dynamicUnit.departmentLevel2Label());
            phaseUnit.setDepartmentLevel3Id(dynamicUnit.departmentLevel3Id());
            phaseUnit.setDepartmentLevel3LinkId(dynamicUnit.departmentLevel3LinkId());
            phaseUnit.setDepartmentLevel3Label(dynamicUnit.departmentLevel3Label());
            phaseUnit.setDepartmentLevel4Id(dynamicUnit.departmentLevel4Id());
            phaseUnit.setDepartmentLevel4LinkId(dynamicUnit.departmentLevel4LinkId());
            phaseUnit.setDepartmentLevel4Label(dynamicUnit.departmentLevel4Label());
            phaseUnit.setDepartmentLevel5Id(dynamicUnit.departmentLevel5Id());
            phaseUnit.setDepartmentLevel5LinkId(dynamicUnit.departmentLevel5LinkId());
            phaseUnit.setDepartmentLevel5Label(dynamicUnit.departmentLevel5Label());
            phaseUnit.setDepartmentLevel6Id(dynamicUnit.departmentLevel6Id());
            phaseUnit.setDepartmentLevel6LinkId(dynamicUnit.departmentLevel6LinkId());
            phaseUnit.setDepartmentLevel6Label(dynamicUnit.departmentLevel6Label());
            phaseUnit.setDepartmentLevel7Id(dynamicUnit.departmentLevel7Id());
            phaseUnit.setDepartmentLevel7LinkId(dynamicUnit.departmentLevel7LinkId());
            phaseUnit.setDepartmentLevel7Label(dynamicUnit.departmentLevel7Label());
         }
         phaseUnit.setLinkId(recordId);
         phaseUnit.linkDate().assign(dynamicUnit.updateDate());
         // 计算资金信息
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            phaseUnit.setDepartmentInvestment(phaseUnit.departmentInvestment() + customerActionAmount);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            phaseUnit.setDepartmentRedemption(phaseUnit.departmentRedemption() + customerActionAmount);
            phaseUnit.setDepartmentInterest(phaseUnit.departmentInterest() + customerActionInterest);
         }else{
            throw new FFatalError("Department action invalid.");
         }
         phaseUnit.setDepartmentInvestmentTotal(investmentTotal);
         phaseUnit.setDepartmentRedemptionTotal(redemptionTotal);
         phaseUnit.setDepartmentNetinvestment(phaseUnit.departmentInvestment() - phaseUnit.departmentRedemption());
         phaseUnit.setDepartmentNetinvestmentTotal(investmentTotal - redemptionTotal);
         phaseUnit.setDepartmentInterestTotal(interestTotal);
         // 计算客户信息
         phaseUnit.customerActionDate().assign(dynamicUnit.customerActionDate());
         if(!customerExist){
            phaseUnit.setCustomerCount(phaseUnit.customerCount() + 1);
         }
         phaseUnit.setCustomerTotal(customerTotal);
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
