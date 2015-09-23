package com.ahyc.eai.batch.statistics.financial.dynamic;

import com.ahyc.eai.batch.common.FStatisticsCalculater;
import com.ahyc.eai.batch.statistics.financial.customer.IStatisticsCustomerConsole;
import com.ahyc.eai.batch.statistics.financial.department.IStatisticsDepartmentConsole;
import com.ahyc.eai.batch.statistics.financial.marketer.IStatisticsMarketerConsole;
import com.ahyc.eai.batch.statistics.financial.tender.IStatisticsTenderConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.data.ISqlDatasetReader;
import org.mo.com.lang.RString;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>统计赎回计算器。</T>
//============================================================
public class FStatisticsRedemptionCalculater
      extends FStatisticsCalculater
{
   // 同步总数
   protected long _intervalCount = 10000;

   protected IStatisticsCustomerConsole _customerConsole;

   protected IStatisticsMarketerConsole _marketerConsole;

   protected IStatisticsDepartmentConsole _departmentConsole;

   //============================================================
   // <T>构造统计赎回计算器。</T>
   //============================================================
   public FStatisticsRedemptionCalculater(){
      _customerConsole = RAop.find(IStatisticsCustomerConsole.class);
      _marketerConsole = RAop.find(IStatisticsMarketerConsole.class);
      _departmentConsole = RAop.find(IStatisticsDepartmentConsole.class);
   }

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   public void processPhase(FLogicContext logicContext,
                            long beginId,
                            long endId){
      // 代码修正
      ISqlConnection sourceConnection = logicContext.activeConnection("ezubao");
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      IStatisticsTenderConsole tenderConsole = RAop.find(IStatisticsTenderConsole.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      String selectSql = RString.format("SELECT id,invest_id,sell_uid,FROM_UNIXTIME(addtime, '%Y%m%d%H%i%s') as action_date,transfer_price,DATE_FORMAT(`upd_time`,'%Y%m%d%H%i%s') update_date FROM lzh_invest_detb WHERE id>{1} AND id<={2}", beginId, endId);
      try(ISqlDatasetReader reader = sourceConnection.fetchReader(selectSql)){
         for(FRow row : reader){
            long recordId = row.getLong("id");
            long customerId = row.getLong("sell_uid");
            double transferAmount = row.getDouble("transfer_price");
            // 查找理财师编号
            long recommentId = sourceConnection.executeLong("select recommend_id from lzh_members where id=" + customerId);
            // 查找理财师信息：理财师编号/部门编号
            long managerId = 0;
            long departmentId = 0;
            if(recommentId != 0){
               FRow managerInfo = sourceConnection.find("select uid,real_name,rank,belong_dept from lzh_fmanager where uid=" + recommentId);
               if(managerInfo != null){
                  managerId = managerInfo.getLong("uid");
                  departmentId = managerInfo.getLong("belong_dept");
               }
            }
            // 查找部门信息
            FStatisticsFinancialDepartmentUnit departmentInfo = null;
            if(departmentId > 0){
               departmentInfo = _departmentConsole.syncByLinkId(logicContext, departmentId);
            }
            // 查找理财师信息
            FStatisticsFinancialMarketerUnit marketerInfo = null;
            if(managerId > 0){
               marketerInfo = _marketerConsole.syncByLinkId(logicContext, managerId);
            }
            // 查找客户信息
            FStatisticsFinancialCustomerUnit customerInfo = null;
            if(customerId > 0){
               customerInfo = _customerConsole.syncByLinkId(logicContext, customerId);
            }
            //............................................................
            // 查找关联投资信息
            long investId = row.getLong("invest_id");
            FRow investorRow = sourceConnection.find("select borrow_id,investor_capital from lzh_borrow_investor where id=" + investId);
            long borrowId = investorRow.getLong("borrow_id");
            double investmentAmount = investorRow.getDouble("investor_capital");
            //............................................................
            // 获得投标信息
            long borrowRecordId = 0;
            String borrowModel = null;
            FStatisticsFinancialTenderUnit tenderUnit = tenderConsole.syncByLinkId(logicContext, borrowId);
            if(tenderUnit != null){
               borrowRecordId = tenderUnit.ouid();
               borrowModel = tenderUnit.borrowModel();
            }
            //............................................................
            // 查找公司信息
            FStatisticsFinancialDynamicUnit dynamicUnit = dynamicLogic.doPrepare();
            dynamicUnit.setLinkId(recordId);
            dynamicUnit.linkDate().parse(row.get("update_date"));
            if(departmentInfo != null){
               dynamicUnit.setDepartmentId(departmentInfo.ouid());
               dynamicUnit.setDepartmentLinkId(departmentInfo.linkId());
               dynamicUnit.setDepartmentLabel(departmentInfo.label());
               dynamicUnit.setDepartmentLabelPath(departmentInfo.labelPath());
            }
            if(marketerInfo != null){
               dynamicUnit.setMarketerId(marketerInfo.ouid());
               dynamicUnit.setMarketerLinkId(marketerInfo.linkId());
               dynamicUnit.setMarketerLabel(marketerInfo.label());
               dynamicUnit.setMarketerRankLabel(marketerInfo.rankLabel());
            }
            if(customerInfo != null){
               dynamicUnit.setCustomerId(customerInfo.ouid());
               dynamicUnit.setCustomerLinkId(customerInfo.linkId());
               dynamicUnit.setCustomerLabel(customerInfo.label());
               dynamicUnit.setCustomerPhone(customerInfo.phone());
               dynamicUnit.setCustomerCard(customerInfo.card());
            }
            dynamicUnit.setCustomerActionCd(EGcFinancialCustomerAction.Redemption);
            dynamicUnit.customerActionDate().parse(row.get("action_date"));
            dynamicUnit.setCustomerActionAmount(investmentAmount);
            dynamicUnit.setCustomerActionInterest(transferAmount - investmentAmount);
            dynamicUnit.setTenderId(borrowRecordId);
            dynamicUnit.setTenderLinkId(borrowRecordId);
            dynamicUnit.setTenderModel(borrowModel);
            dynamicLogic.doInsert(dynamicUnit);
            // 统计处理
            processOnce();
         }
      }
   }

   //============================================================
   // <T>逻辑处理。</T>
   //============================================================
   @Override
   public void processLogic(FLogicContext logicContext){
      ISqlConnection sourceConnection = logicContext.activeConnection("ezubao");
      ISqlConnection targetConnection = logicContext.activeConnection("statistics");
      // 获得最大编号
      long sourceMaxId = sourceConnection.executeLong("SELECT MAX(id) FROM lzh_invest_detb");
      long targetMaxId = targetConnection.executeLong("SELECT MAX(LINK_ID) FROM ST_FIN_DYNAMIC WHERE CUSTOMER_ACTION_CD=" + EGcFinancialCustomerAction.Redemption);
      if(targetMaxId == 0){
         targetMaxId = sourceConnection.executeLong("SELECT MIN(id) FROM lzh_invest_detb");
         if(targetMaxId > 0){
            targetMaxId--;
         }
      }
      // 每次同步数量
      long beginId = targetMaxId;
      long endId = targetMaxId + _intervalCount;
      if(endId > sourceMaxId){
         endId = sourceMaxId;
      }
      // 同步阶段内数据
      if(endId > beginId){
         processPhase(logicContext, beginId, endId);
      }
   }
}
