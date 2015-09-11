package com.ahyc.eai.batch.statistics.financial.tender;

import com.ahyc.eai.batch.common.FStatisticsPeriodCalculater;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderAmountLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderAmountUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderPhaseUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.type.TDateTime;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;

//============================================================
// <T>金融理财师统计计算器。</T>
//============================================================
public class FStatisticsTenderCalculater
      extends FStatisticsPeriodCalculater
{
   // 合计间隔(1小时)
   protected long _recordSpan = 1000 * 60 * 15;

   //============================================================
   // <T>构造金融理财师统计计算器。</T>
   //============================================================
   public FStatisticsTenderCalculater(){
      _processCode = "financial.tender";
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
      FStatisticsFinancialTenderLogic tenderLogic = logicContext.findLogic(FStatisticsFinancialTenderLogic.class);
      FStatisticsFinancialTenderCustomerLogic customerLogic = logicContext.findLogic(FStatisticsFinancialTenderCustomerLogic.class);
      FStatisticsFinancialTenderAmountLogic amountLogic = logicContext.findLogic(FStatisticsFinancialTenderAmountLogic.class);
      FStatisticsFinancialTenderPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialTenderPhaseLogic.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch("TENDER_ID IS NOT NULL AND CUSTOMER_ACTION_DATE > STR_TO_DATE('" + beginDate + "','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE <= STR_TO_DATE('" + endDate
            + "','%Y%m%d%H%i%s')", "CUSTOMER_ACTION_DATE");
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         long recordId = dynamicUnit.ouid();
         long customerId = dynamicUnit.customerId();
         int customerActionCd = dynamicUnit.customerActionCd();
         TDateTime customerActionDate = dynamicUnit.customerActionDate();
         double customerActionAmount = dynamicUnit.customerActionAmount();
         double customerActionInterest = dynamicUnit.customerActionInterest();
         // 查找竞标
         long tenderId = dynamicUnit.tenderId();
         FStatisticsFinancialTenderUnit tenderUnit = tenderLogic.find(tenderId);
         if(tenderUnit == null){
            continue;
         }
         //............................................................
         // 统计客户信息
         FStatisticsFinancialTenderCustomerUnit customerUnit = customerLogic.search("TENDER_ID=" + tenderId + " AND CUSTOMER_ID=" + customerId);
         boolean customerExist = (customerUnit != null);
         if(!customerExist){
            customerUnit = customerLogic.doPrepare();
            customerUnit.setTenderId(tenderId);
            customerUnit.setCustomerId(customerId);
         }
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
            throw new FFatalError("Marketer action invalid.");
         }
         customerUnit.setNetinvestmentTotal(customerInvestmentTotal - customerRedemptionTotal);
         if(customerExist){
            customerLogic.doUpdate(customerUnit);
         }else{
            customerLogic.doInsert(customerUnit);
         }
         //............................................................
         // 统计合计信息
         FStatisticsFinancialTenderAmountUnit amountUnit = amountLogic.search("TENDER_ID=" + tenderId);
         boolean amountExist = (amountUnit != null);
         if(!amountExist){
            amountUnit = amountLogic.doPrepare();
            amountUnit.setTenderId(tenderId);
            amountUnit.setTenderLabel(tenderUnit.label());
         }
         // 计算资金信息
         double tenderInvestmentTotal = amountUnit.investmentTotal();
         double tenderRedemptionTotal = amountUnit.redemptionTotal();
         double tenderInterestTotal = amountUnit.interestTotal();
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            tenderInvestmentTotal += customerActionAmount;
            amountUnit.setInvestmentTotal(tenderInvestmentTotal);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            tenderRedemptionTotal += customerActionAmount;
            amountUnit.setRedemptionTotal(tenderRedemptionTotal);
            tenderInterestTotal += customerActionInterest;
            amountUnit.setInterestTotal(tenderInterestTotal);
         }else{
            throw new FFatalError("Marketer action invalid.");
         }
         amountUnit.setNetinvestmentTotal(tenderInvestmentTotal - tenderRedemptionTotal);
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
         TDateTime spanDate = new TDateTime(customerActionDate.get());
         spanDate.truncate(_recordSpan);
         FStatisticsFinancialTenderPhaseUnit phaseUnit = phaseLogic.search("TENDER_ID=" + tenderId + " AND RECORD_DATE=STR_TO_DATE('" + spanDate.format() + "','%Y%m%d%H%i%s')");
         boolean phaseExist = (phaseUnit != null);
         if(!phaseExist){
            phaseUnit = phaseLogic.doPrepare();
            phaseUnit.recordYear().parse(spanDate.format("YYYY0101000000"));
            phaseUnit.recordMonth().parse(spanDate.format("YYYYMM01000000"));
            phaseUnit.recordWeek().parse(spanDate.format("YYYYMMWK000000"));
            phaseUnit.recordDay().parse(spanDate.format("YYYYMMDD000000"));
            phaseUnit.recordHour().parse(spanDate.format("YYYYMMDDHH240000"));
            phaseUnit.recordDate().assign(spanDate);
            phaseUnit.setTenderId(tenderUnit.ouid());
            phaseUnit.setTenderModel(tenderUnit.borrowModel());
            phaseUnit.setTenderLabel(tenderUnit.label());
         }
         phaseUnit.setLinkId(recordId);
         phaseUnit.linkDate().assign(dynamicUnit.updateDate());
         // 计算资金信息
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            phaseUnit.setInvestment(phaseUnit.investment() + customerActionAmount);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            phaseUnit.setRedemption(phaseUnit.redemption() + customerActionAmount);
            phaseUnit.setInterest(phaseUnit.interest() + customerActionInterest);
         }else{
            throw new FFatalError("Tender action invalid.");
         }
         phaseUnit.setInvestmentTotal(tenderInvestmentTotal);
         phaseUnit.setRedemptionTotal(tenderRedemptionTotal);
         phaseUnit.setNetinvestment(phaseUnit.investment() - phaseUnit.redemption());
         phaseUnit.setNetinvestmentTotal(tenderInvestmentTotal - tenderRedemptionTotal);
         phaseUnit.setInterestTotal(tenderInterestTotal);
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
