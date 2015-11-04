package com.ahyc.eai.batch.statistics.financial.department;

import com.ahyc.eai.batch.common.FStatisticsPoolConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentUnit;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>金融部门控制台。</T>
//============================================================
public class FStatisticsDepartmentConsole
      extends FStatisticsPoolConsole<FStatisticsFinancialDepartmentUnit>
      implements
         IStatisticsDepartmentConsole
{
   // 日志访问接口
   private static ILogger _logger = RLogger.find(FStatisticsDepartmentConsole.class);

   // 资源访问接口
   private static IResource _resource = RResource.find(FStatisticsDepartmentConsole.class);

   // 部门信息字典
   protected FDictionary<FStatisticsDepartmentInfo> _infos = new FDictionary<FStatisticsDepartmentInfo>(FStatisticsDepartmentInfo.class);

   //============================================================
   // <T>构造金融部门控制台。</T>
   //============================================================
   public FStatisticsDepartmentConsole(){
      super(FStatisticsFinancialDepartmentUnit.class);
   }

   //============================================================
   // <T>查找部门信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 编号
   //============================================================
   //@Override
   public FStatisticsDepartmentInfo findInfoByLinkId(FLogicContext logicContext,
                                                     long linkId){
      // 检查参数
      if(linkId == 0){
         return null;
      }
      // 查询信息
      String code = Long.toString(linkId);
      FStatisticsDepartmentInfo info = _infos.find(code);
      if(info != null){
         return info;
      }
      info = new FStatisticsDepartmentInfo();
      _infos.set(code, info);
      // 生成信息
      ISqlConnection sourceConnection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      long findId = linkId;
      while(findId > 0){
         // 查找数据
         FRow row = sourceConnection.find("select id,upid,dept_name,level from lzh_new_department where id=" + findId);
         if(row == null){
            break;
         }
         long departmentLinkId = row.getLong("id");
         String departmentName = row.get("dept_name");
         int departmentLevel = row.getInt("level");
         // 生成层级
         SDepartmentInfo departmentInfo = new SDepartmentInfo();
         departmentInfo.linkId = departmentLinkId;
         departmentInfo.label = departmentName;
         departmentInfo.level = departmentLevel;
         info.levels().push(departmentInfo);
         // 查找下一层
         int level = row.getInt("level");
         if(level == 1){
            break;
         }
         findId = row.getLong("upid");
      }
      info.levels().revert();
      return info;
   }

   //============================================================
   // <T>根据编号同步一个部门信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   public void doInsertUnit(FLogicContext logicContext,
                            long linkId){
      FStatisticsFinancialDepartmentLogic logic = logicContext.findLogic(FStatisticsFinancialDepartmentLogic.class);
      // 查询信息
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      FSql sql = _resource.findString(FSql.class, "sql.department");
      sql.bindLong("id", linkId);
      FRow row = connection.find(sql);
      if(row == null){
         throw new FFatalError("Department is not exists. (link_id={1})", linkId);
      }
      // 新建单元
      FStatisticsFinancialDepartmentUnit unit = logic.doPrepare();
      unit.setLinkParentId(row.getLong("upid"));
      unit.setLinkId(linkId);
      unit.linkDate().parse(row.get("upd_time"));
      unit.setCode(row.get("code"));
      unit.setLabel(row.get("dept_name"));
      unit.setLevel(row.getInt("level"));
      logic.doInsert(unit);
      // 查找父对象
      long parentLinkId = unit.linkParentId();
      if(parentLinkId != 0){
         FStatisticsFinancialDepartmentUnit parentUnit = logic.search(FStatisticsFinancialDepartmentLogic.LINK_ID + "=" + parentLinkId);
         if(parentUnit != null){
            unit.setParentId(parentUnit.ouid());
         }
      }
      // 设置层级信息
      FStatisticsDepartmentInfo info = findInfoByLinkId(logicContext, linkId);
      if(info != null){
         for(SDepartmentInfo level : info.levels()){
            FStatisticsFinancialDepartmentUnit findUnit = logic.search(FStatisticsFinancialDepartmentLogic.LINK_ID + "=" + level.linkId);
            if(findUnit == null){
               throw new FFatalError("Department link is not exsits. (link_id={1}, link_label={2}, level_link_id={3}, level_label={4})", unit.linkId(), unit.label(), level.linkId, level.label);
            }
            level.id = findUnit.ouid();
            switch(level.level){
               case 1:
                  unit.setLevel1Id(level.id);
                  unit.setLevel1LinkId(level.linkId);
                  unit.setLevel1Label(level.label);
                  break;
               case 2:
                  unit.setLevel2Id(level.id);
                  unit.setLevel2LinkId(level.linkId);
                  unit.setLevel2Label(level.label);
                  break;
               case 3:
                  unit.setLevel3Id(level.id);
                  unit.setLevel3LinkId(level.linkId);
                  unit.setLevel3Label(level.label);
                  break;
               case 4:
                  unit.setLevel4Id(level.id);
                  unit.setLevel4LinkId(level.linkId);
                  unit.setLevel4Label(level.label);
                  break;
               case 5:
                  unit.setLevel5Id(level.id);
                  unit.setLevel5LinkId(level.linkId);
                  unit.setLevel5Label(level.label);
                  break;
               case 6:
                  unit.setLevel6Id(level.id);
                  unit.setLevel6LinkId(level.linkId);
                  unit.setLevel6Label(level.label);
                  break;
               case 7:
                  unit.setLevel7Id(level.id);
                  unit.setLevel7LinkId(level.linkId);
                  unit.setLevel7Label(level.label);
                  break;
               default:
                  _logger.warn(this, "updateDepartment", "Department level is not exists. (id={1}, level={2}, label={3})", level.id, level.level, level.label);
            }
         }
      }
      logic.doUpdate(unit);
   }

   //============================================================
   // <T>根据编号同步一个部门信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   @Override
   public FStatisticsFinancialDepartmentUnit syncByLinkId(FLogicContext logicContext,
                                                          long linkId){
      // 检查参数
      if(linkId == 0){
         return null;
      }
      // 从缓冲查找单元
      String code = Long.toString(linkId);
      FStatisticsFinancialDepartmentUnit findUnit = _pool.find(code);
      if(findUnit != null){
         return findUnit;
      }
      // 重数据库查找单元
      FStatisticsFinancialDepartmentLogic logic = logicContext.findLogic(FStatisticsFinancialDepartmentLogic.class);
      findUnit = logic.search(FStatisticsFinancialDepartmentLogic.LINK_ID + "=" + linkId);
      if(findUnit != null){
         _pool.set(code, findUnit);
         return findUnit;
      }
      //............................................................
      // 新建所有层信息
      FStatisticsDepartmentInfo info = findInfoByLinkId(logicContext, linkId);
      if(info != null){
         for(SDepartmentInfo level : info.levels()){
            if(level.linkId != 0){
               FStatisticsFinancialDepartmentUnit unit = logic.search(FStatisticsFinancialDepartmentLogic.LINK_ID + "=" + level.linkId);
               if(unit == null){
                  doInsertUnit(logicContext, level.linkId);
               }
            }else{
               throw new FFatalError("Level link id is empty. (link_id={1})", level.linkId);
            }
         }
      }
      //............................................................
      // 重数据库查找单元
      FStatisticsFinancialDepartmentUnit unit = logic.search(FStatisticsFinancialDepartmentLogic.LINK_ID + "=" + linkId);
      _pool.set(code, unit);
      return unit;
   }

   //============================================================
   // <T>清空处理。</T>
   //============================================================
   @Override
   public void clear(){
      super.clear();
      _infos.clear();
   }
}
