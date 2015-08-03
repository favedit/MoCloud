package com.ahyc.eai.batch.financial.marketer;

import com.ahyc.eai.batch.financial.FStatisticsCalculater;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerAmountLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerAmountUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerPhaseUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;

//============================================================
// <T>统计计算器。</T>
//============================================================
public class FStatisticsMarketerCalculater
      extends FStatisticsCalculater
{
   // 同步时间(1小时)
   protected long _intervalSpan = 1000 * 60 * 60;

   // 合计间隔(1小时)
   protected long _recordSpan = 1000 * 60 * 60;

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   public void processPhase(FLogicContext logicContext,
                            String beginDate,
                            String endDate){
      // 代码修正
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      FStatisticsFinancialMarketerCustomerLogic customerLogic = logicContext.findLogic(FStatisticsFinancialMarketerCustomerLogic.class);
      FStatisticsFinancialMarketerAmountLogic amountLogic = logicContext.findLogic(FStatisticsFinancialMarketerAmountLogic.class);
      FStatisticsFinancialMarketerPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialMarketerPhaseLogic.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch("MARKETER_ID IS NOT NULL AND CUSTOMER_ACTION_DATE > STR_TO_DATE('" + beginDate + "','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE <= STR_TO_DATE('" + endDate
            + "','%Y%m%d%H%i%s')", "CUSTOMER_ACTION_DATE");
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         long recordId = dynamicUnit.ouid();
         long marketerId = dynamicUnit.marketerId();
         String marketerLabel = dynamicUnit.marketerLabel();
         long customerId = dynamicUnit.customerId();
         int customerActionCd = dynamicUnit.customerActionCd();
         TDateTime customerActionDate = dynamicUnit.customerActionDate();
         double customerActionAmount = dynamicUnit.customerActionAmount();
         double customerActionInterest = dynamicUnit.customerActionInterest();
         //............................................................
         // 统计客户信息
         FStatisticsFinancialMarketerCustomerUnit customerUnit = customerLogic.search("MARKETER_ID=" + marketerId + " AND CUSTOMER_ID=" + customerId);
         boolean customerExist = (customerUnit != null);
         if(!customerExist){
            customerUnit = customerLogic.doPrepare();
            customerUnit.setMarketerId(marketerId);
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
         FStatisticsFinancialMarketerAmountUnit amountUnit = amountLogic.search("MARKETER_ID=" + marketerId);
         boolean amountExist = (amountUnit != null);
         if(!amountExist){
            amountUnit = amountLogic.doPrepare();
            amountUnit.setMarketerId(marketerId);
            amountUnit.setMarketerLabel(marketerLabel);
         }
         // 计算资金信息
         double marketerInvestmentTotal = amountUnit.investmentTotal();
         double marketerRedemptionTotal = amountUnit.redemptionTotal();
         double marketerInterestTotal = amountUnit.interestTotal();
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            marketerInvestmentTotal += customerActionAmount;
            amountUnit.setInvestmentTotal(marketerInvestmentTotal);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            marketerRedemptionTotal += customerActionAmount;
            amountUnit.setRedemptionTotal(marketerRedemptionTotal);
            marketerInterestTotal += customerActionInterest;
            amountUnit.setInterestTotal(marketerInterestTotal);
         }else{
            throw new FFatalError("Marketer action invalid.");
         }
         amountUnit.setNetinvestmentTotal(marketerInvestmentTotal - marketerRedemptionTotal);
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
         FStatisticsFinancialMarketerPhaseUnit phaseUnit = phaseLogic.search("MARKETER_ID=" + marketerId + " AND RECORD_DATE=STR_TO_DATE('" + spanDate.format() + "','%Y%m%d%H%i%s')");
         boolean phaseExist = (phaseUnit != null);
         if(!phaseExist){
            phaseUnit = phaseLogic.doPrepare();
            phaseUnit.recordYear().parse(spanDate.format("YYYY0101000000"));
            phaseUnit.recordMonth().parse(spanDate.format("YYYYMM01000000"));
            phaseUnit.recordWeek().parse(spanDate.format("YYYYMMWK000000"));
            phaseUnit.recordDay().parse(spanDate.format("YYYYMMDD000000"));
            phaseUnit.recordHour().parse(spanDate.format("YYYYMMDDHH240000"));
            phaseUnit.recordDate().assign(spanDate);
            phaseUnit.setDepartmentId(dynamicUnit.departmentId());
            phaseUnit.setDepartmentLabel(dynamicUnit.departmentLabel());
            phaseUnit.setMarketerId(marketerId);
            phaseUnit.setMarketerLabel(marketerLabel);
         }
         phaseUnit.setLinkId(recordId);
         phaseUnit.linkDate().assign(dynamicUnit.updateDate());
         // 计算资金信息
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            phaseUnit.setMarketerInvestment(phaseUnit.marketerInvestment() + customerActionAmount);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            phaseUnit.setMarketerRedemption(phaseUnit.marketerRedemption() + customerActionAmount);
            phaseUnit.setMarketerInterest(phaseUnit.marketerInterest() + customerActionInterest);
         }else{
            throw new FFatalError("Marketer action invalid.");
         }
         phaseUnit.setMarketerInvestmentTotal(marketerInvestmentTotal);
         phaseUnit.setMarketerRedemptionTotal(marketerRedemptionTotal);
         phaseUnit.setMarketerNetinvestment(phaseUnit.marketerInvestment() - phaseUnit.marketerRedemption());
         phaseUnit.setMarketerNetinvestmentTotal(marketerInvestmentTotal - marketerRedemptionTotal);
         phaseUnit.setMarketerInterestTotal(marketerInterestTotal);
         // 计算客户信息
         phaseUnit.customerActionDate().assign(dynamicUnit.customerActionDate());
         if(!customerExist){
            phaseUnit.setCustomerRegister(phaseUnit.customerRegister() + 1);
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

   //============================================================
   // <T>逻辑处理。</T>
   //============================================================
   @Override
   public void processLogic(FLogicContext logicContext){
      ISqlConnection connection = logicContext.activeConnection("statistics");
      // 获得最大编号
      String currentDate = connection.executeScalar("SELECT DATE_FORMAT(SYSDATE(),'%Y%m%d%H%i%s') AS `CURRENT_DATE` FROM DUAL");
      String sourceMaxDate = connection.executeScalar("SELECT DATE_FORMAT(MAX(CUSTOMER_ACTION_DATE),'%Y%m%d%H%i%s') AS `ACTION_DATE` FROM ST_FIN_DYNAMIC");
      String targetMaxDate = connection.executeScalar("SELECT DATE_FORMAT(MAX(CUSTOMER_ACTION_DATE),'%Y%m%d%H%i%s') AS `ACTION_DATE` FROM ST_FIN_MARKETER_PHASE");
      if(RString.isEmpty(targetMaxDate)){
         targetMaxDate = connection.executeScalar("SELECT DATE_FORMAT(MIN(CUSTOMER_ACTION_DATE),'%Y%m%d%H%i%s') AS ACTION_DATE FROM ST_FIN_DYNAMIC");
      }
      // 每次同步数量
      long currentTick = new TDateTime(currentDate).get();
      long sourceMaxTick = new TDateTime(sourceMaxDate).get();
      long targetMaxTick = new TDateTime(targetMaxDate).get();
      long beginTick = targetMaxTick;
      long endTick = targetMaxTick + _intervalSpan;
      if(endTick > sourceMaxTick){
         endTick = sourceMaxTick;
      }
      while(endTick < currentTick){
         String beginTime = new TDateTime(beginTick).format();
         String endTime = new TDateTime(endTick).format();
         int count = connection.executeInteger("SELECT COUNT(*) FROM ST_FIN_DYNAMIC WHERE MARKETER_ID IS NOT NULL AND CUSTOMER_ACTION_DATE > STR_TO_DATE('" + beginTime + "','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE <= STR_TO_DATE('" + endTime
               + "','%Y%m%d%H%i%s')");
         if(count > 0){
            break;
         }
         endTick += _intervalSpan;
      }
      // 同步阶段内数据
      if(endTick > beginTick){
         processPhase(logicContext, new TDateTime(beginTick).format(), new TDateTime(endTick).format());
      }
   }
}
