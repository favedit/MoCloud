package org.mo.content.core.manage.role;

import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import java.util.Map;

//============================================================
// <T>控制角色表逻辑单元。</T>
//============================================================
public class FDataControlRoleInfo
      extends FDataControlRoleUnit
{
   // 存储角色名称。
   private String _roleModules;

   public String roleModules(){
      return _roleModules;
   }

   public void setRoleModules(String _roleModules){
      this._roleModules = _roleModules;
   }

   //============================================================
   // <T>保存对照表。</T>
   //
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("roleModules", _roleModules);
   }

}
