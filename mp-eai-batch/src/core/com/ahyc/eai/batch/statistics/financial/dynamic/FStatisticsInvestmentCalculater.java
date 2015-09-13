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
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerGender;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.data.ISqlDatasetReader;
import org.mo.com.lang.RString;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>统计投资计算器。</T>
//============================================================
public class FStatisticsInvestmentCalculater
      extends FStatisticsCalculater
{
   // 同步总数
   protected long _intervalCount = 10000;

   protected IStatisticsCustomerConsole _customerConsole;

   protected IStatisticsMarketerConsole _marketerConsole;

   protected IStatisticsDepartmentConsole _departmentConsole;

   //============================================================
   // <T>构造统计投资计算器。</T>
   //============================================================
   public FStatisticsInvestmentCalculater(){
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
      ISqlConnection sourceConnection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      IStatisticsTenderConsole tenderConsole = RAop.find(IStatisticsTenderConsole.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      String selectSql = RString.format("SELECT id,borrow_id,investor_uid,FROM_UNIXTIME(add_time, '%Y%m%d%H%i%s') as investor_date,investor_capital,DATE_FORMAT(`upd_time`,'%Y%m%d%H%i%s') update_date FROM lzh_borrow_investor WHERE id>{1} AND id<={2}",
            beginId, endId);
      try(ISqlDatasetReader reader = sourceConnection.fetchReader(selectSql)){
         for(FRow row : reader){
            long recordId = row.getLong("id");
            long borrowId = row.getLong("borrow_id");
            long customerId = row.getLong("investor_uid");
            // 查找理财师编号
            long recommentId = sourceConnection.executeLong("select recommend_id from lzh_members where id=" + customerId);
            // 查找理财师信息：理财师编号/部门编号
            long managerId = 0;
            long departmentId = 0;
            if(recommentId != 0){
               FRow managerInfo = sourceConnection.find("select uid,belong_dept from lzh_fmanager where uid=" + recommentId);
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
            // 获得投标信息
            long tenderId = 0;
            String tenderModel = null;
            FStatisticsFinancialTenderUnit tenderUnit = tenderConsole.sync(logicContext, borrowId);
            if(tenderUnit != null){
               tenderId = tenderUnit.ouid();
               tenderModel = tenderUnit.borrowModel();
            }
            //............................................................
            // 新建记录
            FStatisticsFinancialDynamicUnit dynamicUnit = dynamicLogic.doPrepare();
            dynamicUnit.setLinkId(recordId);
            dynamicUnit.linkDate().parse(row.get("update_date"));
            dynamicUnit.setLinkBorrowId(borrowId);
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
               // 检查用户信息，如果为空的话重新更新一次客户信息
               String customerLabel = customerInfo.label();
               if(RString.isEmpty(customerLabel)){
                  customerInfo = _customerConsole.updateByLinkId(logicContext, customerId);
               }
               // 设置用户信息
               dynamicUnit.setCustomerId(customerInfo.ouid());
               dynamicUnit.setCustomerLinkId(customerInfo.linkId());
               dynamicUnit.setCustomerLabel(customerInfo.label());
               dynamicUnit.setCustomerPhone(customerInfo.phone());
               dynamicUnit.setCustomerCard(customerInfo.card());
            }
            String customerCard = dynamicUnit.customerCard();
            if(!RString.isEmpty(customerCard)){
               dynamicUnit.setCustomerCard(customerCard);
               if(customerCard.length() == 18){
                  dynamicUnit.setCustomerArea(customerCard.substring(0, 6));
                  dynamicUnit.setCustomerBirth(customerCard.substring(6, 14));
                  int customerGender = customerCard.charAt(16) - '0';
                  dynamicUnit.setCustomerGender(customerGender);
                  if(customerGender % 2 == 0){
                     dynamicUnit.setCustomerGender(EGcFinancialCustomerGender.Female);
                  }else{
                     dynamicUnit.setCustomerGender(EGcFinancialCustomerGender.Male);
                  }
               }else if(customerCard.length() == 15){
                  dynamicUnit.setCustomerArea(customerCard.substring(0, 6));
                  dynamicUnit.setCustomerBirth("19" + customerCard.substring(6, 12));
                  int customerGender = customerCard.charAt(14) - '0';
                  dynamicUnit.setCustomerGender(customerGender);
                  if(customerGender % 2 == 0){
                     dynamicUnit.setCustomerGender(EGcFinancialCustomerGender.Female);
                  }else{
                     dynamicUnit.setCustomerGender(EGcFinancialCustomerGender.Male);
                  }
               }
            }
            dynamicUnit.setCustomerActionCd(EGcFinancialCustomerAction.Investment);
            dynamicUnit.customerActionDate().parse(row.get("investor_date"));
            dynamicUnit.setCustomerActionAmount(row.getDouble("investor_capital"));
            dynamicUnit.setTenderId(tenderId);
            dynamicUnit.setTenderLinkId(tenderId);
            dynamicUnit.setTenderModel(tenderModel);
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
      long sourceMaxId = sourceConnection.executeLong("SELECT MAX(id) FROM lzh_borrow_investor");
      long targetMaxId = targetConnection.executeLong("SELECT MAX(LINK_ID) FROM ST_FIN_DYNAMIC WHERE CUSTOMER_ACTION_CD=" + EGcFinancialCustomerAction.Investment);
      if(targetMaxId == 0){
         targetMaxId = sourceConnection.executeLong("SELECT MIN(id) FROM lzh_borrow_investor");
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
