package com.ahyc.eai.batch.statistics.financial.customer;

import com.ahyc.eai.batch.common.FStatisticsPeriodCalculater;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerAmountLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerAmountUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerPhaseUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.type.TDateTime;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;

//============================================================
// <T>金融客户统计计算器。</T>
//============================================================
public class FStatisticsCustomerCalculater
      extends FStatisticsPeriodCalculater
{
   // 合计间隔(1小时)
   protected long _recordSpan = 1000 * 60 * 60 * 24;

   //============================================================
   // <T>构造金融客户统计计算器。</T>
   //============================================================
   public FStatisticsCustomerCalculater(){
      _processCode = "financial.customer";
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
      FStatisticsFinancialCustomerAmountLogic amountLogic = logicContext.findLogic(FStatisticsFinancialCustomerAmountLogic.class);
      FStatisticsFinancialCustomerPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialCustomerPhaseLogic.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch("CUSTOMER_ACTION_DATE > STR_TO_DATE('" + beginDate + "','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE <= STR_TO_DATE('" + endDate + "','%Y%m%d%H%i%s')",
            "CUSTOMER_ACTION_DATE");
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         long recordId = dynamicUnit.ouid();
         long customerId = dynamicUnit.customerId();
         String customerLabel = dynamicUnit.customerLabel();
         String customerCard = dynamicUnit.customerCard();
         String customerArea = dynamicUnit.customerArea();
         String customerBirth = dynamicUnit.customerBirth();
         int customerGender = dynamicUnit.customerGender();
         String customerPhone = dynamicUnit.customerPhone();
         int customerActionCd = dynamicUnit.customerActionCd();
         TDateTime customerActionDate = dynamicUnit.customerActionDate();
         double customerActionAmount = dynamicUnit.customerActionAmount();
         double customerActionInterest = dynamicUnit.customerActionInterest();
         long tenderId = dynamicUnit.tenderId();
         String tenderModel = dynamicUnit.tenderModel();
         long tenderPriorId = 0;
         String tenderPriorModel = null;
         // 统计合计信息
         FStatisticsFinancialCustomerAmountUnit amountUnit = amountLogic.search("CUSTOMER_ID=" + customerId);
         boolean amountExist = (amountUnit != null);
         if(!amountExist){
            amountUnit = amountLogic.doPrepare();
            amountUnit.setCustomerId(customerId);
            amountUnit.setCustomerLabel(customerLabel);
            amountUnit.setCustomerCard(customerCard);
            amountUnit.setCustomerArea(customerArea);
            amountUnit.setCustomerBirth(customerBirth);
            amountUnit.setCustomerGender(customerGender);
            amountUnit.setCustomerPhone(customerPhone);
            amountUnit.setTenderId(tenderId);
            amountUnit.setTenderModel(tenderModel);
         }else{
            tenderPriorId = amountUnit.tenderId();
            tenderPriorModel = amountUnit.tenderModel();
            amountUnit.setTenderId(tenderId);
            amountUnit.setTenderModel(tenderModel);
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
            interestTotal += customerActionInterest;
            amountUnit.setInterestTotal(interestTotal);
         }else{
            throw new FFatalError("Customer action invalid.");
         }
         amountUnit.setNetinvestmentTotal(investmentTotal - redemptionTotal);
         if(amountExist){
            amountLogic.doUpdate(amountUnit);
         }else{
            amountLogic.doInsert(amountUnit);
         }
         // 插入用户数据
         TDateTime spanDate = new TDateTime();
         spanDate.parse(customerActionDate.format("YYYYMMDD"), "YYYYMMDD");
         FStatisticsFinancialCustomerPhaseUnit phaseUnit = phaseLogic.search("CUSTOMER_ID=" + customerId + " AND RECORD_DATE=STR_TO_DATE('" + spanDate.format() + "','%Y%m%d%H%i%s')");
         boolean phaseExist = (phaseUnit != null);
         if(!phaseExist){
            phaseUnit = phaseLogic.doPrepare();
            phaseUnit.recordYear().parse(spanDate.format("YYYY0101000000"));
            phaseUnit.recordMonth().parse(spanDate.format("YYYYMM01000000"));
            phaseUnit.recordWeek().parse(spanDate.format("YYYYMMWK000000"));
            phaseUnit.recordDay().parse(spanDate.format("YYYYMMDD000000"));
            phaseUnit.recordHour().parse(spanDate.format("YYYYMMDDHH240000"));
            phaseUnit.recordDate().assign(spanDate);
            phaseUnit.setCustomerId(customerId);
            phaseUnit.setCustomerLabel(customerLabel);
            phaseUnit.setCustomerCard(customerCard);
            phaseUnit.setCustomerArea(customerArea);
            phaseUnit.setCustomerBirth(customerBirth);
            phaseUnit.setCustomerGender(customerGender);
            phaseUnit.setCustomerPhone(customerPhone);
         }
         phaseUnit.setLinkId(recordId);
         phaseUnit.linkDate().assign(dynamicUnit.updateDate());
         // 设置数据
         phaseUnit.customerActionDate().assign(dynamicUnit.customerActionDate());
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            phaseUnit.setInvestment(phaseUnit.investment() + customerActionAmount);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            phaseUnit.setRedemption(phaseUnit.redemption() + customerActionAmount);
            phaseUnit.setInterest(phaseUnit.interest() + customerActionInterest);
         }else{
            throw new FFatalError("Customer action invalid.");
         }
         phaseUnit.setInvestmentTotal(investmentTotal);
         phaseUnit.setRedemptionTotal(redemptionTotal);
         phaseUnit.setNetinvestment(phaseUnit.investment() - phaseUnit.redemption());
         phaseUnit.setNetinvestmentTotal(investmentTotal - redemptionTotal);
         phaseUnit.setInterestTotal(interestTotal);
         // 设置投标
         if(tenderId != tenderPriorId){
            phaseUnit.setTenderChanged(1);
         }
         if(!phaseExist){
            phaseUnit.setTenderPriorId(tenderPriorId);
            phaseUnit.setTenderPriorModel(tenderPriorModel);
         }
         phaseUnit.setTenderId(tenderId);
         phaseUnit.setTenderModel(tenderModel);
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
