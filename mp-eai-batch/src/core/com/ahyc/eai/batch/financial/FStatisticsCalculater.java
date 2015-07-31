package com.ahyc.eai.batch.financial;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>统计计算器。</T>
//============================================================
public class FStatisticsCalculater
      extends FObject
{
   // 同步总数
   protected long _intervalCount = 100;

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   public void processInvestmentPhase(FLogicContext logicContext,
                                      long beginId,
                                      long endId){
      // 代码修正
      ISqlConnection sourceConnection = logicContext.activeConnection("ezubo");
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      String selectSql = RString.format("SELECT id,investor_uid,investor_capital,from_unixtime(add_time, '%Y%m%d%H%i%s') as add_time FROM lzh_borrow_investor WHERE (id>{1}) AND (id<{2})", beginId, endId);
      FDataset dataset = sourceConnection.fetchDataset(selectSql);
      for(FRow row : dataset){
         long recordId = row.getLong("id");
         long investorUid = row.getLong("investor_uid");
         // 查找客户信息：名称/电话号码/身份证号
         FRow memberInfoRow = sourceConnection.find("SELECT real_name,cell_phone,idcard FROM lzh_member_info where uid=" + investorUid);
         // 查找理财师编号
         long recommentId = sourceConnection.executeLong("select recommend_id from lzh_members where id=" + recordId);
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
         FRow departmentInfo = null;
         if(departmentId != 0){
            departmentInfo = sourceConnection.find("select dept_id,dept_name from lzh_new_department where dept_id=" + departmentId);
         }
         FStatisticsFinancialDynamicUnit dynamicUnit = dynamicLogic.doPrepare();
         dynamicUnit.setLinkId(recordId);
         if(departmentInfo != null){
            dynamicUnit.setCompanyId(departmentId);
            dynamicUnit.setCompanyLabel(departmentInfo.get("dept_name"));
         }
         if(managerInfo != null){
            dynamicUnit.setMarketerId(managerId);
            dynamicUnit.setMarketerLabel(managerInfo.get("real_name"));
         }
         dynamicUnit.setCustomerId(investorUid);
         dynamicUnit.setCustomerLabel(memberInfoRow.get("real_name"));
         dynamicUnit.setCustomerPhone(memberInfoRow.get("cell_phone"));
         dynamicUnit.setCustomerCard(memberInfoRow.get("idcard"));
         dynamicLogic.doInsert(dynamicUnit);
      }
   }

   //============================================================
   // <T>投资数据处理。</T>
   //============================================================
   public void processInvestment(FLogicContext logicContext){
      ISqlConnection sourceConnection = logicContext.activeConnection("ezubo");
      ISqlConnection targetConnection = logicContext.activeConnection("statistics");
      // 获得最大编号
      long sourceMaxId = sourceConnection.executeLong("SELECT MAX(id) FROM lzh_borrow_investor");
      long targetMaxId = targetConnection.executeLong("SELECT MAX(RECORD_ID) FROM ST_FIN_DYNAMIC");
      // 每次同步数量
      long beginId = targetMaxId;
      long endId = targetMaxId + _intervalCount;
      if(endId > sourceMaxId){
         endId = sourceMaxId;
      }
      // 同步阶段内数据
      if(endId > beginId){
         processInvestmentPhase(logicContext, beginId, endId);
      }
   }

   //============================================================
   // <T>逻辑处理。</T>
   //============================================================
   public void process(FLogicContext logicContext){
      processInvestment(logicContext);
   }
}
