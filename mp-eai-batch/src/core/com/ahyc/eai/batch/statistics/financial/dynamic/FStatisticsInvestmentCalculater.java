package com.ahyc.eai.batch.statistics.financial.dynamic;

import com.ahyc.eai.batch.common.FStatisticsCalculater;
import com.ahyc.eai.batch.statistics.financial.customer.IStatisticsCustomerConsole;
import com.ahyc.eai.batch.statistics.financial.department.IStatisticsDepartmentConsole;
import com.ahyc.eai.batch.statistics.financial.marketer.IStatisticsMarketerConsole;
import com.ahyc.eai.batch.statistics.financial.tender.IStatisticsTenderConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.data.ISqlDatasetReader;
import org.mo.com.lang.RString;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>统计投资计算器。</T>
//============================================================
public class FStatisticsInvestmentCalculater
      extends FStatisticsCalculater
{
   // 资源访问接口
   private static IResource _resource = RResource.find(FStatisticsInvestmentCalculater.class);

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
      FStatisticsFinancialCustomerLogic customerLogic = logicContext.findLogic(FStatisticsFinancialCustomerLogic.class);
      IStatisticsTenderConsole tenderConsole = RAop.find(IStatisticsTenderConsole.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      FSql selectSql = _resource.findString(FSql.class, "sql.select");
      selectSql.bindLong("begin_id", beginId);
      selectSql.bindLong("end_id", endId);
      try(ISqlDatasetReader reader = sourceConnection.fetchReader(selectSql)){
         for(FRow row : reader){
            long recordId = row.getLong("id");
            long borrowId = row.getLong("borrow_id");
            long customerId = row.getLong("investor_uid");
            double investment = row.getDouble("investor_capital");
            String actionDate = row.get("investor_date");
            // 查找理财师编号
            long recommentId = sourceConnection.executeLong("select recommend_id from lzh_members where id=" + customerId);
            // 查找理财师信息：理财师编号/部门编号
            long managerLinkId = 0;
            long departmentLinkId = 0;
            if(recommentId != 0){
               FRow managerInfo = sourceConnection.find("select uid from lzh_fmanager where uid=" + recommentId);
               if(managerInfo != null){
                  managerLinkId = managerInfo.getLong("uid");
                  if(managerLinkId != 0){
                     // 查找部门
                     FSql departmentSql = _resource.findString(FSql.class, "sql.marketer.department");
                     departmentSql.bindLong("id", managerLinkId);
                     FRow departmentRow = sourceConnection.find(departmentSql);
                     if(departmentRow != null){
                        departmentLinkId = departmentRow.getLong("dept_id");
                     }
                  }
               }
            }
            // 查找部门信息
            FStatisticsFinancialDepartmentUnit departmentInfo = null;
            if(departmentLinkId > 0){
               departmentInfo = _departmentConsole.syncByLinkId(logicContext, departmentLinkId);
            }
            // 查找理财师信息
            FStatisticsFinancialMarketerUnit marketerInfo = null;
            if(managerLinkId > 0){
               marketerInfo = _marketerConsole.syncByLinkId(logicContext, managerLinkId);
            }
            // 查找客户信息
            FStatisticsFinancialCustomerUnit customerInfo = null;
            if(customerId > 0){
               customerInfo = _customerConsole.syncByLinkId(logicContext, customerId);
            }
            //............................................................
            // 获得投标信息
            boolean tenderChanged = false;
            long tenderPriorId = 0;
            long tenderPriorLinkId = 0;
            String tenderPriorModel = null;
            long tenderId = 0;
            long tenderLinkId = 0;
            String tenderModel = null;
            FStatisticsFinancialTenderUnit tenderUnit = tenderConsole.syncByLinkId(logicContext, borrowId);
            if(tenderUnit != null){
               tenderId = tenderUnit.ouid();
               tenderLinkId = tenderUnit.linkId();
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
               dynamicUnit.setDepartmentLevel1Id(departmentInfo.level1Id());
               dynamicUnit.setDepartmentLevel1LinkId(departmentInfo.level1LinkId());
               dynamicUnit.setDepartmentLevel1Label(departmentInfo.level1Label());
               dynamicUnit.setDepartmentLevel2Id(departmentInfo.level2Id());
               dynamicUnit.setDepartmentLevel2LinkId(departmentInfo.level2LinkId());
               dynamicUnit.setDepartmentLevel2Label(departmentInfo.level2Label());
               dynamicUnit.setDepartmentLevel3Id(departmentInfo.level3Id());
               dynamicUnit.setDepartmentLevel3LinkId(departmentInfo.level3LinkId());
               dynamicUnit.setDepartmentLevel3Label(departmentInfo.level3Label());
               dynamicUnit.setDepartmentLevel4Id(departmentInfo.level4Id());
               dynamicUnit.setDepartmentLevel4LinkId(departmentInfo.level4LinkId());
               dynamicUnit.setDepartmentLevel4Label(departmentInfo.level4Label());
               dynamicUnit.setDepartmentLevel5Id(departmentInfo.level5Id());
               dynamicUnit.setDepartmentLevel5LinkId(departmentInfo.level5LinkId());
               dynamicUnit.setDepartmentLevel5Label(departmentInfo.level5Label());
               dynamicUnit.setDepartmentLevel6Id(departmentInfo.level6Id());
               dynamicUnit.setDepartmentLevel6LinkId(departmentInfo.level6LinkId());
               dynamicUnit.setDepartmentLevel6Label(departmentInfo.level6Label());
               dynamicUnit.setDepartmentLevel7Id(departmentInfo.level7Id());
               dynamicUnit.setDepartmentLevel7LinkId(departmentInfo.level7LinkId());
               dynamicUnit.setDepartmentLevel7Label(departmentInfo.level7Label());
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
               // 更新理财师信息
               if(departmentInfo != null){
                  customerInfo.setDepartmentId(departmentInfo.ouid());
                  customerInfo.setDepartmentLinkId(departmentInfo.linkId());
                  customerInfo.setDepartmentLabel(departmentInfo.label());
                  customerInfo.setDepartmentLevel1Id(departmentInfo.level1Id());
                  customerInfo.setDepartmentLevel1LinkId(departmentInfo.level1LinkId());
                  customerInfo.setDepartmentLevel1Label(departmentInfo.level1Label());
                  customerInfo.setDepartmentLevel2Id(departmentInfo.level2Id());
                  customerInfo.setDepartmentLevel2LinkId(departmentInfo.level2LinkId());
                  customerInfo.setDepartmentLevel2Label(departmentInfo.level2Label());
                  customerInfo.setDepartmentLevel3Id(departmentInfo.level3Id());
                  customerInfo.setDepartmentLevel3LinkId(departmentInfo.level3LinkId());
                  customerInfo.setDepartmentLevel3Label(departmentInfo.level3Label());
                  customerInfo.setDepartmentLevel4Id(departmentInfo.level4Id());
                  customerInfo.setDepartmentLevel4LinkId(departmentInfo.level4LinkId());
                  customerInfo.setDepartmentLevel4Label(departmentInfo.level4Label());
                  customerInfo.setDepartmentLevel5Id(departmentInfo.level5Id());
                  customerInfo.setDepartmentLevel5LinkId(departmentInfo.level5LinkId());
                  customerInfo.setDepartmentLevel5Label(departmentInfo.level5Label());
                  customerInfo.setDepartmentLevel6Id(departmentInfo.level6Id());
                  customerInfo.setDepartmentLevel6LinkId(departmentInfo.level6LinkId());
                  customerInfo.setDepartmentLevel6Label(departmentInfo.level6Label());
                  customerInfo.setDepartmentLevel7Id(departmentInfo.level7Id());
                  customerInfo.setDepartmentLevel7LinkId(departmentInfo.level7LinkId());
                  customerInfo.setDepartmentLevel7Label(departmentInfo.level7Label());
               }
               // 更新理财师信息
               if(marketerInfo != null){
                  customerInfo.setMarketerId(marketerInfo.ouid());
                  customerInfo.setMarketerLinkId(marketerInfo.linkId());
                  customerInfo.setMarketerLabel(marketerInfo.label());
               }
               // 更新产品信息
               long findTenderId = customerInfo.tenderId();
               if((findTenderId != 0) && (findTenderId == tenderId)){
                  tenderChanged = true;
                  tenderPriorId = customerInfo.tenderId();
                  tenderPriorLinkId = customerInfo.tenderLinkId();
                  tenderPriorModel = customerInfo.tenderModel();
               }
               customerInfo.setTenderId(tenderId);
               customerInfo.setTenderLinkId(tenderLinkId);
               customerInfo.setTenderModel(tenderModel);
               customerLogic.doUpdate(customerInfo);
               // 设置用户信息
               dynamicUnit.setCustomerId(customerInfo.ouid());
               dynamicUnit.setCustomerLinkId(customerInfo.linkId());
               dynamicUnit.setCustomerLabel(customerInfo.label());
               dynamicUnit.setCustomerPhone(customerInfo.phone());
               dynamicUnit.setCustomerCard(customerInfo.card());
               dynamicUnit.setCustomerArea(customerInfo.cardArea());
               dynamicUnit.setCustomerBirth(customerInfo.cardBirth());
               dynamicUnit.setCustomerGender(customerInfo.cardGender());
            }
            dynamicUnit.setCustomerActionCd(EGcFinancialCustomerAction.Investment);
            dynamicUnit.customerActionDate().parse(actionDate);
            dynamicUnit.setCustomerActionAmount(investment);
            // 设置投资内容
            dynamicUnit.setTenderChanged(tenderChanged);
            dynamicUnit.setTenderPriorId(tenderPriorId);
            dynamicUnit.setTenderPriorLinkId(tenderPriorLinkId);
            dynamicUnit.setTenderPriorModel(tenderPriorModel);
            dynamicUnit.setTenderId(tenderId);
            dynamicUnit.setTenderLinkId(tenderLinkId);
            dynamicUnit.setTenderModel(tenderModel);
            // 新建内容
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
