package org.mo.content.core.manage.user;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import java.util.Map;
import org.mo.core.aop.face.ASourceMachine;

//============================================================
// <T>人员用户信息逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataPersonUserInfo
      extends FDataPersonUserUnit
{
   // 存储角色名称。
   private String _roleLabel;

   public String roleLabel(){
      return _roleLabel;
   }

   public void setRoleLabel(String _roleLabel){
      this._roleLabel = _roleLabel;
   }

   //============================================================
   // <T>保存对照表。</T>
   //
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("roleLabel", _roleLabel);

   }
}
