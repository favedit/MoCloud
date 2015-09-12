package com.ahyc.eai.batch.statistics.financial.department;

import com.ahyc.eai.batch.common.FStatisticsPoolConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDepartmentUnit;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
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
   // @param id 编号
   //============================================================
   @Override
   public FStatisticsDepartmentInfo findInfo(FLogicContext logicContext,
                                             long id){
      // 检查参数
      if(id == 0){
         return null;
      }
      // 查询信息
      String code = Long.toString(id);
      FStatisticsDepartmentInfo info = _infos.find(code);
      if(info != null){
         return info;
      }
      info = new FStatisticsDepartmentInfo();
      _infos.set(code, info);
      // 生成信息
      ISqlConnection sourceConnection = logicContext.activeConnection("ezubao");
      long findId = id;
      while(findId > 0){
         // 查找数据
         FRow row = sourceConnection.find("select id,upid,dept_name,level from lzh_new_department where id=" + findId);
         if(row == null){
            break;
         }
         long departmentId = row.getLong("id");
         String departmentName = row.get("dept_name");
         int departmentLevel = row.getInt("level");
         // 生成层级
         SDepartmentInfo departmentInfo = new SDepartmentInfo();
         departmentInfo.id = departmentId;
         departmentInfo.label = departmentName;
         departmentInfo.level = departmentLevel;
         info.levels().push(departmentInfo);
         // 初次设置
         if(info.label() == null){
            info.setId(departmentId);
            info.setLabel(departmentName);
         }
         // 生成路径
         if(info.labels() == null){
            info.setIds("\\" + departmentId);
            info.setLabels("\\" + departmentName);
         }else{
            info.setIds(departmentId + "\\" + info.ids());
            info.setLabels(departmentName + "\\" + info.labels());
         }
         // 查找下一层
         int level = row.getInt("level");
         if(level == 1){
            break;
         }
         findId = row.getLong("upid");
      }
      return info;
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
      // 查找单元
      String code = Long.toString(linkId);
      FStatisticsFinancialDepartmentUnit unit = _pool.find(code);
      if(unit != null){
         return unit;
      }
      // 查找单元
      FStatisticsFinancialDepartmentLogic logic = logicContext.findLogic(FStatisticsFinancialDepartmentLogic.class);
      unit = logic.search("LINK_ID=" + linkId);
      if(unit != null){
         return unit;
      }
      //............................................................
      // 查询信息
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      FSql sql = _resource.findString(FSql.class, "sql.department");
      sql.bindLong("id", linkId);
      FRow row = connection.find(sql);
      if(row == null){
         throw new FFatalError("Department is not exists. (link_id={1})", linkId);
      }
      // 查找信息
      FStatisticsDepartmentInfo info = findInfo(logicContext, linkId);
      info.labels();
      // 新建单元
      unit = logic.doPrepare();
      unit.setLinkTopId(info.id());
      unit.setLinkParentId(row.getLong("upid"));
      unit.setLinkId(linkId);
      unit.setLinkIdPath(info.ids());
      unit.linkDate().parse(row.get("upd_time"));
      unit.setCode(row.get("code"));
      unit.setTopLabel(info.label());
      unit.setLabel(row.get("dept_name"));
      unit.setLabelPath(info.labels());
      logic.doInsert(unit);
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
