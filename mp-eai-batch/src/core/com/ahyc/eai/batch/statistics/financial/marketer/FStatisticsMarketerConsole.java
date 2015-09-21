package com.ahyc.eai.batch.statistics.financial.marketer;

import com.ahyc.eai.batch.common.FStatisticsPoolConsole;
import com.ahyc.eai.batch.statistics.financial.department.FStatisticsDepartmentInfo;
import com.ahyc.eai.batch.statistics.financial.department.IStatisticsDepartmentConsole;
import com.ahyc.eai.batch.statistics.financial.department.SDepartmentInfo;
import com.ahyc.eai.batch.statistics.financial.member.IStatisticsMemberConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>统计投标控制台。</T>
//============================================================
public class FStatisticsMarketerConsole
      extends FStatisticsPoolConsole<FStatisticsFinancialMarketerUnit>
      implements
         IStatisticsMarketerConsole
{
   // 资源访问接口
   private static IResource _resource = RResource.find(FStatisticsMarketerConsole.class);

   // 日志访问接口
   private static ILogger _logger = RLogger.find(FStatisticsMarketerConsole.class);

   // 成员控制台
   @ALink
   protected IStatisticsMemberConsole _memberConsole;

   // 部门控制台
   @ALink
   protected IStatisticsDepartmentConsole _departmentConsole;

   //============================================================
   // <T>构造金融用户控制台。</T>
   //============================================================
   public FStatisticsMarketerConsole(){
      super(FStatisticsFinancialMarketerUnit.class);
   }

   //============================================================
   // <T>根据编号同步一个理财师信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   @Override
   public FStatisticsFinancialMarketerUnit syncByLinkId(FLogicContext logicContext,
                                                        long linkId){
      // 检查参数
      if(linkId == 0){
         return null;
      }
      // 查找单元
      String code = Long.toString(linkId);
      FStatisticsFinancialMarketerUnit unit = _pool.find(code);
      if(unit != null){
         return unit;
      }
      // 查找单元
      FStatisticsFinancialMarketerLogic logic = logicContext.findLogic(FStatisticsFinancialMarketerLogic.class);
      unit = logic.search("LINK_ID=" + linkId);
      if(unit != null){
         return unit;
      }
      //............................................................
      // 查找成员
      FStatisticsFinancialMemberUnit memberUnit = _memberConsole.syncByLinkId(logicContext, linkId);
      if(memberUnit == null){
         throw new FFatalError("Marketer member is not exists. (link_id={1})", linkId);
      }
      //............................................................
      // 查询信息
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      FSql sql = _resource.findString(FSql.class, "sql.marketer");
      sql.bindLong("id", linkId);
      FRow row = connection.find(sql);
      if(row == null){
         throw new FFatalError("Marketer is not exists. (link_id={1})", linkId);
      }
      // 新建单元
      unit = logic.doPrepare();
      unit.setOuid(memberUnit.ouid());
      unit.setLinkId(linkId);
      unit.linkDate().parse(row.get("upd_time"));
      unit.setCode(row.get("code"));
      unit.setLabel(row.get("real_name"));
      unit.setRankLabel(row.get("rank"));
      unit.setPhone(memberUnit.phone());
      unit.setCard(memberUnit.card());
      unit.setStatusCd(row.getInt("status"));
      unit.enterDate().parse(row.get("add_date"));
      // 获得部门标签
      long departmentId = 0;
      long belongDepartmentId = row.getLong("belong_dept");
      unit.setDepartmentLinkId(belongDepartmentId);
      if(belongDepartmentId > 0){
         String belongDepartmentLabel = connection.executeScalar("SELECT dept_name FROM lzh_new_department WHERE id=" + belongDepartmentId);
         unit.setDepartmentLabel(belongDepartmentLabel);
      }
      // 设置部门级别
      FSql departmentSql = _resource.findString(FSql.class, "sql.marketer.department");
      departmentSql.bindLong("id", linkId);
      FRow departmentRow = connection.find(departmentSql);
      if(departmentRow != null){
         // 设置级别
         unit.setRankLabel(departmentRow.get("rank"));
         departmentId = departmentRow.getLong("dept_id");
         // 设置相关信息
         FStatisticsDepartmentInfo info = _departmentConsole.findInfo(logicContext, departmentId);
         if(info != null){
            for(SDepartmentInfo level : info.levels()){
               switch(level.level){
                  case 1:
                     unit.setDepartmentLevel1Id(level.id);
                     unit.setDepartmentLevel1Label(level.label);
                     break;
                  case 2:
                     unit.setDepartmentLevel2Id(level.id);
                     unit.setDepartmentLevel2Label(level.label);
                     break;
                  case 3:
                     unit.setDepartmentLevel3Id(level.id);
                     unit.setDepartmentLevel3Label(level.label);
                     break;
                  case 4:
                     unit.setDepartmentLevel4Id(level.id);
                     unit.setDepartmentLevel4Label(level.label);
                     break;
                  case 5:
                     unit.setDepartmentLevel5Id(level.id);
                     unit.setDepartmentLevel5Label(level.label);
                     break;
                  case 6:
                     unit.setDepartmentLevel6Id(level.id);
                     unit.setDepartmentLevel6Label(level.label);
                     break;
                  case 7:
                     unit.setDepartmentLevel7Id(level.id);
                     unit.setDepartmentLevel7Label(level.label);
                     break;
                  case 8:
                     unit.setDepartmentLevel8Id(level.id);
                     unit.setDepartmentLevel8Label(level.label);
                     break;
                  default:
                     _logger.warn(this, "updateDepartment", "Department level is not exists. (id={1}, level={2}, label={3})", level.id, level.level, level.label);
               }
            }
         }
      }
      // 设置入职时间
      FSql statusSql = _resource.findString(FSql.class, "sql.marketer.status");
      statusSql.bindLong("id", linkId);
      FRow statusRow = connection.find(statusSql);
      if(statusRow != null){
         unit.enterDate().parse(statusRow.get("add_date"));
      }
      // 新建记录
      logic.doInsert(unit);
      //............................................................
      // 更新用户信息
      if(memberUnit.marketerId() == 0){
         memberUnit.setMarketerId(unit.ouid());
         memberUnit.setDepartmentId(departmentId);
         FStatisticsFinancialMemberLogic memberLogic = logicContext.findLogic(FStatisticsFinancialMemberLogic.class);
         memberLogic.doUpdate(memberUnit);
      }
      return unit;
   }

   //============================================================
   // <T>更新部门。</T>
   //============================================================
   @Override
   public void updateDepartment(FLogicContext logicContext,
                                long linkId){
      FStatisticsFinancialMarketerUnit unit = syncByLinkId(logicContext, linkId);
      // 计算内容
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      FDataset dataset = connection.fetchDataset("SELECT dept_id,rank FROM lzh_fmanager_maping WHERE uid=" + linkId + " ORDER BY add_time DESC");
      if(dataset == null){
         return;
      }
      FRow row = dataset.first();
      long departmentId = row.getLong("dept_id");
      _departmentConsole.syncByLinkId(logicContext, departmentId);
      // 更新信息
      FStatisticsDepartmentInfo info = _departmentConsole.findInfo(logicContext, departmentId);
      if(info != null){
         for(SDepartmentInfo level : info.levels()){
            switch(level.level){
               case 1:
                  unit.setDepartmentLevel1Id(level.id);
                  unit.setDepartmentLevel1Label(level.label);
                  break;
               case 2:
                  unit.setDepartmentLevel2Id(level.id);
                  unit.setDepartmentLevel2Label(level.label);
                  break;
               case 3:
                  unit.setDepartmentLevel3Id(level.id);
                  unit.setDepartmentLevel3Label(level.label);
                  break;
               case 4:
                  unit.setDepartmentLevel4Id(level.id);
                  unit.setDepartmentLevel4Label(level.label);
                  break;
               case 5:
                  unit.setDepartmentLevel5Id(level.id);
                  unit.setDepartmentLevel5Label(level.label);
                  break;
               case 6:
                  unit.setDepartmentLevel6Id(level.id);
                  unit.setDepartmentLevel6Label(level.label);
                  break;
               case 7:
                  unit.setDepartmentLevel7Id(level.id);
                  unit.setDepartmentLevel7Label(level.label);
                  break;
               case 8:
                  unit.setDepartmentLevel8Id(level.id);
                  unit.setDepartmentLevel8Label(level.label);
                  break;
               default:
                  _logger.warn(this, "updateDepartment", "Department level is not exists. (id={1}, level={2}, label={3})", level.id, level.level, level.label);
            }
         }
      }
      // 设置内容
      unit.setRankLabel(row.get("rank"));
      // 更新数据
      FStatisticsFinancialMarketerLogic logic = logicContext.findLogic(FStatisticsFinancialMarketerLogic.class);
      logic.doUpdate(unit);
   }
}
