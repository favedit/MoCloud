package com.ahyc.eai.batch.financial.department;

import com.ahyc.eai.batch.financial.FStatisticsCalculater;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentAmountLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentAmountUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentPhaseUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
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
public class FStatisticsDepartmentCalculater
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
      FStatisticsFinancialDepartmentAmountLogic amountLogic = logicContext.findLogic(FStatisticsFinancialDepartmentAmountLogic.class);
      FStatisticsFinancialDepartmentPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialDepartmentPhaseLogic.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch("CUSTOMER_ACTION_DATE >= STR_TO_DATE('" + beginDate + "','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE < STR_TO_DATE('" + endDate + "','%Y%m%d%H%i%s')",
            "CUSTOMER_ACTION_DATE");
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         long recordId = dynamicUnit.ouid();
         long customerId = dynamicUnit.customerId();
         String customerLabel = dynamicUnit.customerLabel();
         int customerActionCd = dynamicUnit.customerActionCd();
         TDateTime customerActionDate = dynamicUnit.customerActionDate();
         double customerActionAmount = dynamicUnit.customerActionAmount();
         // 统计合计信息
         FStatisticsFinancialDepartmentAmountUnit amountUnit = amountLogic.search("CUSTOMER_ID=" + customerId);
         boolean amountExist = (amountUnit != null);
         if(!amountExist){
            amountUnit = amountLogic.doPrepare();
            amountUnit.setDepartmentId(customerId);
            amountUnit.setDepartmentLabel(customerLabel);
         }
         double investmentTotal = amountUnit.investmentTotal();
         double redemptionTotal = amountUnit.redemptionTotal();
         //double customerTotal = amountUnit.customerTotal();
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            investmentTotal += customerActionAmount;
            amountUnit.setInvestmentTotal(investmentTotal);
            //amountUnit.setCustomerTotal(customerTotal);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            redemptionTotal += customerActionAmount;
            amountUnit.setRedemptionTotal(redemptionTotal);
         }else{
            throw new FFatalError("Department action invalid.");
         }
         amountUnit.setNetinvestmentTotal(redemptionTotal - investmentTotal);
         if(amountExist){
            amountLogic.doUpdate(amountUnit);
         }else{
            amountLogic.doInsert(amountUnit);
         }
         // 插入用户数据
         customerActionDate.truncate(_recordSpan);
         FStatisticsFinancialDepartmentPhaseUnit phaseUnit = phaseLogic.search("CUSTOMER_ID=" + customerId + " AND RECORD_DATE=STR_TO_DATE('" + customerActionDate.format() + "','%Y%m%d%H%i%s')");
         boolean phaseExist = (phaseUnit != null);
         if(!phaseExist){
            phaseUnit = phaseLogic.doPrepare();
            phaseUnit.recordYear().parse(customerActionDate.format("YYYY0101000000"));
            phaseUnit.recordMonth().parse(customerActionDate.format("YYYYMM01000000"));
            phaseUnit.recordWeek().parse(customerActionDate.format("YYYYMMWK000000"));
            phaseUnit.recordDay().parse(customerActionDate.format("YYYYMMDD000000"));
            phaseUnit.recordHour().parse(customerActionDate.format("YYYYMMDDHH240000"));
            phaseUnit.recordDate().assign(customerActionDate);
            phaseUnit.setDepartmentId(dynamicUnit.departmentId());
            phaseUnit.setDepartmentLabel(dynamicUnit.departmentLabel());
            phaseUnit.setDepartmentId(customerId);
            phaseUnit.setDepartmentLabel(customerLabel);
         }
         phaseUnit.setLinkId(recordId);
         phaseUnit.linkDate().assign(dynamicUnit.updateDate());
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            phaseUnit.setDepartmentInvestment(phaseUnit.departmentInvestment() + customerActionAmount);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            phaseUnit.setDepartmentRedemption(phaseUnit.departmentRedemption() + customerActionAmount);
         }else{
            throw new FFatalError("Department action invalid.");
         }
         phaseUnit.setDepartmentInvestmentTotal(investmentTotal);
         phaseUnit.setDepartmentRedemptionTotal(redemptionTotal);
         phaseUnit.setDepartmentNetinvestment(phaseUnit.departmentInvestment() - phaseUnit.departmentRedemption());
         phaseUnit.setDepartmentNetinvestmentTotal(investmentTotal - redemptionTotal);
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
      String currentDate = connection.executeScalar("SELECT DATE_FORMAT(SYSDATE,'%Y%m%d%H%i%s') AS `CURRENT_DATE` FROM DUAL");
      String sourceMaxDate = connection.executeScalar("SELECT DATE_FORMAT(MAX(CUSTOMER_ACTION_DATE),'%Y%m%d%H%i%s') AS `ACTION_DATE` FROM ST_FIN_DYNAMIC");
      String targetMaxDate = connection.executeScalar("SELECT DATE_FORMAT(MAX(LINK_DATE),'%Y%m%d%H%i%s') AS `ACTION_DATE` FROM ST_FIN_CUSTOMER_PHASE");
      if(RString.isEmpty(targetMaxDate)){
         targetMaxDate = connection.executeScalar("SELECT DATE_FORMAT(MIN(CUSTOMER_ACTION_DATE),'%Y%m%d%H%i%s') AS ACTION_DATE FROM ST_FIN_DEPARTMENT_PHASE");
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
         int count = connection.executeInteger("SELECT COUNT(*) FROM ST_FIN_DYNAMIC WHERE CUSTOMER_ACTION_DATE >= STR_TO_DATE('" + beginTime + "','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE < STR_TO_DATE('" + endTime + "','%Y%m%d%H%i%s')");
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
