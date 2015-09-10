package com.ahyc.eai.batch.financial.dynamic;

import com.ahyc.eai.batch.common.FStatisticsPeriodCalculater;
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
import com.cyou.gccloud.data.statistics.FStatisticsFinancialPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialPhaseUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.type.TDateTime;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>金融动态统计计算器。</T>
//============================================================
public class FStatisticsDynamicCalculater
      extends FStatisticsPeriodCalculater
{
   // 合计间隔(1小时)
   protected long _recordSpan = 1000 * 60 * 10;

   //============================================================
   // <T>构造金融动态统计计算器。</T>
   //============================================================
   public FStatisticsDynamicCalculater(){
      _processCode = "financial.dynamic";
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
      ISqlConnection sourceConnection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      // 代码修正
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      FStatisticsFinancialAmountLogic amountLogic = logicContext.findLogic(FStatisticsFinancialAmountLogic.class);
      FStatisticsFinancialCustomerLogic customerLogic = logicContext.findLogic(FStatisticsFinancialCustomerLogic.class);
      FStatisticsFinancialMarketerLogic marketerLogic = logicContext.findLogic(FStatisticsFinancialMarketerLogic.class);
      FStatisticsFinancialDepartmentLogic departmentLogic = logicContext.findLogic(FStatisticsFinancialDepartmentLogic.class);
      FStatisticsFinancialPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialPhaseLogic.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch("CUSTOMER_ACTION_DATE > STR_TO_DATE('" + beginDate + "','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE <= STR_TO_DATE('" + endDate + "','%Y%m%d%H%i%s')",
            "CUSTOMER_ACTION_DATE");
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         long recordId = dynamicUnit.ouid();
         long departmentId = dynamicUnit.departmentId();
         long marketerId = dynamicUnit.marketerId();
         long customerId = dynamicUnit.customerId();
         int customerActionCd = dynamicUnit.customerActionCd();
         TDateTime customerActionDate = dynamicUnit.customerActionDate();
         double customerActionAmount = dynamicUnit.customerActionAmount();
         double customerActionInterest = dynamicUnit.customerActionInterest();
         //............................................................
         // 统计客户信息
         FStatisticsFinancialCustomerUnit customerUnit = customerLogic.search("LINK_ID=" + customerId);
         boolean customerExist = (customerUnit != null);
         if(!customerExist){
            customerUnit = customerLogic.doPrepare();
            customerUnit.setLinkId(customerId);
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
         boolean marketerExist = false;
         if(marketerId > 0){
            FStatisticsFinancialMarketerUnit marketerUnit = marketerLogic.search("LINK_ID=" + marketerId);
            marketerExist = (marketerUnit != null);
            if(!marketerExist){
               marketerUnit = marketerLogic.doPrepare();
               marketerUnit.setLinkId(marketerId);
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
         }
         //............................................................
         // 统计部门信息
         boolean departmentExist = false;
         if(departmentId > 0){
            FStatisticsFinancialDepartmentUnit departmentUnit = departmentLogic.search("LINK_ID=" + departmentId);
            departmentExist = (departmentUnit != null);
            if(!departmentExist){
               departmentUnit = departmentLogic.doPrepare();
               departmentUnit.setLinkId(departmentId);
            }
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
            if(departmentExist){
               departmentLogic.doUpdate(departmentUnit);
            }else{
               departmentLogic.doInsert(departmentUnit);
            }
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
         int investmentUserTotal = amountUnit.investmentUserTotal();
         double redemptionTotal = amountUnit.redemptionTotal();
         int redemptionUserTotal = amountUnit.redemptionUserTotal();
         double interestTotal = amountUnit.interestTotal();
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            investmentTotal += customerActionAmount;
            amountUnit.setInvestmentTotal(investmentTotal);
            investmentUserTotal++;
            amountUnit.setInvestmentUserTotal(investmentUserTotal);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            redemptionTotal += customerActionAmount;
            amountUnit.setRedemptionTotal(redemptionTotal);
            redemptionUserTotal++;
            amountUnit.setRedemptionUserTotal(redemptionUserTotal);
            interestTotal += customerActionInterest;
            amountUnit.setInterestTotal(interestTotal);
         }else{
            throw new FFatalError("Marketer action invalid.");
         }
         amountUnit.setNetinvestmentTotal(investmentTotal - redemptionTotal);
         // 计算客户信息
         int customerTotal = amountUnit.customerTotal();
         if(!customerExist){
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
            FSql memberRegisterSql = new FSql("SELECT COUNT(*) FROM lzh_members WHERE ");
            memberRegisterSql.append(" reg_time > 0 AND ");
            memberRegisterSql.append("FROM_UNIXTIME(reg_time, '%Y%m%d%H%i%s') > STR_TO_DATE('" + beginDate + "','%Y%m%d%H%i%s')");
            memberRegisterSql.append(" AND ");
            memberRegisterSql.append("FROM_UNIXTIME(reg_time, '%Y%m%d%H%i%s') <= STR_TO_DATE('" + endDate + "','%Y%m%d%H%i%s')");
            int memberRegister = sourceConnection.executeInteger(memberRegisterSql);
            phaseUnit.setMemberRegister(memberRegister);
            // 获得用户总数
            FSql memberTotalSql = new FSql("SELECT COUNT(*) FROM lzh_members WHERE ");
            memberTotalSql.append(" reg_time > 0 AND ");
            memberTotalSql.append("FROM_UNIXTIME(reg_time, '%Y%m%d%H%i%s') <= STR_TO_DATE('" + endDate + "','%Y%m%d%H%i%s')");
            int memberTotal = sourceConnection.executeInteger(memberTotalSql);
            phaseUnit.setMemberTotal(memberTotal);
         }
         phaseUnit.setLinkId(recordId);
         phaseUnit.linkDate().assign(dynamicUnit.updateDate());
         phaseUnit.actionDate().assign(dynamicUnit.customerActionDate());
         // 计算资金信息
         if(customerActionCd == EGcFinancialCustomerAction.Investment){
            phaseUnit.setInvestment(phaseUnit.investment() + customerActionAmount);
         }else if(customerActionCd == EGcFinancialCustomerAction.Redemption){
            phaseUnit.setRedemption(phaseUnit.redemption() + customerActionAmount);
            phaseUnit.setInterest(phaseUnit.interest() + customerActionInterest);
         }else{
            throw new FFatalError("Marketer action invalid.");
         }
         phaseUnit.setInvestmentTotal(investmentTotal);
         phaseUnit.setInvestmentUserTotal(investmentUserTotal);
         phaseUnit.setRedemptionTotal(redemptionTotal);
         phaseUnit.setRedemptionUserTotal(redemptionUserTotal);
         phaseUnit.setNetinvestment(phaseUnit.investment() - phaseUnit.redemption());
         phaseUnit.setNetinvestmentTotal(investmentTotal - redemptionTotal);
         phaseUnit.setInterestTotal(interestTotal);
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
