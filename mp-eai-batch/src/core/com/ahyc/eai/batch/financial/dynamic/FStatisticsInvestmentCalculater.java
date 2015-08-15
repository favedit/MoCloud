package com.ahyc.eai.batch.financial.dynamic;

import com.ahyc.eai.batch.common.EDataConnection;
import com.ahyc.eai.batch.common.FStatisticsCalculater;
import com.ahyc.eai.batch.financial.department.FStatisticsDepartmentInfo;
import com.ahyc.eai.batch.financial.department.IStatisticsDepartmentInfoConsole;
import com.ahyc.eai.batch.financial.tender.IStatisticsTenderConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerGender;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.data.ISqlDatasetReader;
import org.mo.com.lang.RString;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>统计计算器。</T>
//============================================================
public class FStatisticsInvestmentCalculater
      extends FStatisticsCalculater
{
   // 同步总数
   protected long _intervalCount = 10000;

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   public void processPhase(FLogicContext logicContext,
                            long beginId,
                            long endId){
      // 代码修正
      ISqlConnection sourceConnection = logicContext.activeConnection(EDataConnection.EZUBAO);
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      IStatisticsDepartmentInfoConsole departmentInfoConsole = RAop.find(IStatisticsDepartmentInfoConsole.class);
      IStatisticsTenderConsole tenderConsole = RAop.find(IStatisticsTenderConsole.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      String selectSql = RString.format("SELECT id,borrow_id,investor_uid,FROM_UNIXTIME(add_time, '%Y%m%d%H%i%s') as investor_date,investor_capital,DATE_FORMAT(`upd_time`,'%Y%m%d%H%i%s') update_date FROM lzh_borrow_investor WHERE id>{1} AND id<={2}",
            beginId, endId);
      try(ISqlDatasetReader reader = sourceConnection.fetchReader(selectSql)){
         for(FRow row : reader){
            long recordId = row.getLong("id");
            long borrowId = row.getLong("borrow_id");
            long investorUid = row.getLong("investor_uid");
            // 查找客户信息：名称/电话号码/身份证号
            FRow memberInfoRow = sourceConnection.find("SELECT real_name,cell_phone,idcard FROM lzh_member_info where uid=" + investorUid);
            // 查找理财师编号
            long recommentId = sourceConnection.executeLong("select recommend_id from lzh_members where id=" + investorUid);
            // 查找理财师信息：编号/真实名称/等级/部门编号
            long managerId = 0;
            long departmentId = 0;
            FRow managerInfo = null;
            if(recommentId != 0){
               managerInfo = sourceConnection.find("select uid,real_name,rank,belong_dept from lzh_fmanager where uid=" + recommentId);
               if(managerInfo != null){
                  managerId = managerInfo.getLong("uid");
                  departmentId = managerInfo.getLong("belong_dept");
               }
            }
            // 查找公司信息
            FStatisticsDepartmentInfo departmentInfo = departmentInfoConsole.find(logicContext, departmentId);
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
               dynamicUnit.setDepartmentId(departmentInfo.id());
               dynamicUnit.setDepartmentLabel(departmentInfo.label());
               dynamicUnit.setDepartmentIds(departmentInfo.ids());
               dynamicUnit.setDepartmentLabels(departmentInfo.labels());
            }
            if(managerInfo != null){
               dynamicUnit.setMarketerId(managerId);
               dynamicUnit.setMarketerLabel(managerInfo.get("real_name"));
               dynamicUnit.setMarketerRank(managerInfo.get("rank"));
            }
            dynamicUnit.setCustomerId(investorUid);
            dynamicUnit.setCustomerLabel(memberInfoRow.get("real_name"));
            String customerCard = memberInfoRow.get("idcard");
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
            dynamicUnit.setCustomerPhone(memberInfoRow.get("cell_phone"));
            dynamicUnit.setCustomerActionCd(EGcFinancialCustomerAction.Investment);
            dynamicUnit.customerActionDate().parse(row.get("investor_date"));
            dynamicUnit.setCustomerActionAmount(row.getDouble("investor_capital"));
            dynamicUnit.setTenderId(tenderId);
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
