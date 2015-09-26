package com.ahyc.eai.batch.statistics.financial.tender;

import com.ahyc.eai.batch.common.FStatisticsPeriodCalculater;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderPhaseUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import org.mo.com.data.FSql;
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
   // 合计间隔(15分钟)
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
      FStatisticsFinancialTenderPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialTenderPhaseLogic.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      FSql whereSql = new FSql("TENDER_ID IS NOT NULL AND CUSTOMER_ACTION_DATE > STR_TO_DATE({begin_date},'%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE <= STR_TO_DATE({end_date},'%Y%m%d%H%i%s')");
      whereSql.bindString("begin_date", beginDate);
      whereSql.bindString("end_date", endDate);
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch(whereSql, "CUSTOMER_ACTION_DATE");
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
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
            customerUnit.setTenderLinkId(tenderUnit.linkId());
            customerUnit.setCustomerId(customerId);
            customerUnit.setCustomerLinkId(dynamicUnit.customerLinkId());
         }
         int customerInvestmentCount = customerUnit.investmentCount();
         double customerInvestmentTotal = customerUnit.investmentTotal();
         int customerRedemptionCount = customerUnit.redemptionCount();
         double customerRedemptionTotal = customerUnit.redemptionTotal();
         double customerInterestTotal = customerUnit.interestTotal();
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            customerInvestmentCount++;
            customerUnit.setInvestmentCount(customerInvestmentCount);
            customerInvestmentTotal += customerActionAmount;
            customerUnit.setInvestmentTotal(customerInvestmentTotal);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            customerRedemptionCount++;
            customerUnit.setRedemptionCount(customerRedemptionCount);
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
         // 更新投标信息
         int investmentUserCount = tenderUnit.investmentUserCount();
         int investmentCount = tenderUnit.investmentCount();
         double tenderInvestmentTotal = tenderUnit.investmentTotal();
         int redemptionUserCount = tenderUnit.redemptionUserCount();
         int redemptionCount = tenderUnit.redemptionCount();
         double tenderRedemptionTotal = tenderUnit.redemptionTotal();
         double tenderInterestTotal = tenderUnit.interestTotal();
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            // 设置时间
            if(tenderUnit.investmentBeginDate().isEmpty()){
               tenderUnit.investmentBeginDate().assign(customerActionDate);
            }
            tenderUnit.investmentEndDate().assign(customerActionDate);
            // 设置人数
            if(customerInvestmentCount == 1){
               investmentUserCount++;
               tenderUnit.setInvestmentUserCount(investmentUserCount);
            }
            // 设置金额
            investmentCount++;
            tenderUnit.setInvestmentCount(investmentCount);
            tenderInvestmentTotal += customerActionAmount;
            tenderUnit.setInvestmentTotal(tenderInvestmentTotal);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            // 设置时间
            if(tenderUnit.redemptionBeginDate().isEmpty()){
               tenderUnit.redemptionBeginDate().assign(customerActionDate);
            }
            tenderUnit.redemptionEndDate().assign(customerActionDate);
            // 设置人数
            if(customerRedemptionCount == 1){
               redemptionUserCount++;
               tenderUnit.setRedemptionUserCount(redemptionUserCount);
            }
            // 设置金额
            redemptionCount++;
            tenderUnit.setRedemptionCount(redemptionCount);
            tenderRedemptionTotal += customerActionAmount;
            tenderUnit.setRedemptionTotal(tenderRedemptionTotal);
            tenderInterestTotal += customerActionInterest;
            tenderUnit.setInterestTotal(tenderInterestTotal);
         }else{
            throw new FFatalError("Marketer action invalid.");
         }
         tenderUnit.setNetinvestmentTotal(tenderInvestmentTotal - tenderRedemptionTotal);
         tenderLogic.doUpdate(tenderUnit);
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
            phaseUnit.setTenderLinkId(tenderUnit.linkId());
            phaseUnit.setTenderLabel(tenderUnit.label());
            phaseUnit.setTenderModel(tenderUnit.borrowModel());
         }
         // 计算客户信息
         if(!customerExist){
            phaseUnit.setCustomerCount(phaseUnit.customerCount() + 1);
         }
         phaseUnit.setCustomerTotal(investmentUserCount);
         // 计算资金信息
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            if(customerInvestmentCount == 1){
               phaseUnit.setInvestmentUserCount(phaseUnit.investmentUserCount() + 1);
            }
            phaseUnit.setInvestmentCount(phaseUnit.investmentCount() + 1);
            phaseUnit.setInvestment(phaseUnit.investment() + customerActionAmount);
            phaseUnit.setInvestmentTotal(tenderInvestmentTotal);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            if(customerRedemptionCount == 1){
               phaseUnit.setRedemptionUserCount(phaseUnit.redemptionUserCount() + 1);
            }
            phaseUnit.setRedemptionCount(phaseUnit.redemptionCount() + 1);
            phaseUnit.setRedemption(phaseUnit.redemption() + customerActionAmount);
            phaseUnit.setRedemptionTotal(tenderRedemptionTotal);
            phaseUnit.setInterest(phaseUnit.interest() + customerActionInterest);
            phaseUnit.setInterestTotal(tenderInterestTotal);
         }else{
            throw new FFatalError("Tender action invalid.");
         }
         // 计算金额
         phaseUnit.setNetinvestment(phaseUnit.investment() - phaseUnit.redemption());
         phaseUnit.setNetinvestmentTotal(tenderInvestmentTotal - tenderRedemptionTotal);
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
