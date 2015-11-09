package org.mo.content.core.manage.product.organization.department.user;

import java.util.Map;

import com.cyou.gccloud.data.data.FDataOrganizationDepartmentUserUnit;

public class FDataUserInfo
      extends FDataOrganizationDepartmentUserUnit
{
   //雇佣状态
   private String _statusCdStr;
   //关联关系
   private String _relationCdStr;
   
   //部门
   private String _departmentName;
   
   //用户
   private String _userName;
   
   public String departmentName(){
      return _departmentName;
   }

   public void setDepartmentName(String _departmentName){
      this._departmentName = _departmentName;
   }
   public String _userName(){
      return _userName;
   }
   
   public void setUserName(String _userName){
      this._userName = _userName;
   }
   public String statusCdStr(){
      return _statusCdStr;
   }
   
   public void setStatusCdStr(String _statusCdStr){
      this._statusCdStr = _statusCdStr;
   }
   public String _relationCdStr(){
      return _relationCdStr;
   }
   
   public void setRelationCdStr(String _relationCdStr){
      this._relationCdStr = _relationCdStr;
   }

   // ============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   // ============================================================
   @Override
   public void saveMap(Map<String, String> map) {
      super.saveMap(map);
      map.put("statusCdStr", _statusCdStr);
      map.put("relationCdStr", _relationCdStr);
      map.put("departmentName", _departmentName);
      map.put("userName", _userName);
   }
}
