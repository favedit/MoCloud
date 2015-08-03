package com.ahyc.eai.batch.financial.department;

import org.mo.com.collections.FRow;
import org.mo.com.console.FConsole;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FDictionary;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>部门信息控制台。</T>
//============================================================
public class FStatisticsDepartmentInfoConsole
      extends FConsole
      implements
         IStatisticsDepartmentInfoConsole
{
   // 部门信息字典
   protected FDictionary<FStatisticsDepartmentInfo> _departments = new FDictionary<FStatisticsDepartmentInfo>(FStatisticsDepartmentInfo.class);

   //============================================================
   // <T>查找部门信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param id 编号
   //============================================================
   @Override
   public FStatisticsDepartmentInfo find(FLogicContext logicContext,
                               long id){
      // 检查参数
      if(id == 0){
         return null;
      }
      // 查询信息
      String code = Long.toString(id);
      FStatisticsDepartmentInfo info = _departments.find(code);
      if(info != null){
         return info;
      }
      info = new FStatisticsDepartmentInfo();
      _departments.set(code, info);
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
   // <T>清空处理。</T>
   //============================================================
   @Override
   public void clear(){
      _departments.clear();
   }
}
