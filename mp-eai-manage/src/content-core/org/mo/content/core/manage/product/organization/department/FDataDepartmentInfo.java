package org.mo.content.core.manage.product.organization.department;

import java.util.Map;

import com.cyou.gccloud.data.data.FDataOrganizationDepartmentUnit;

public class FDataDepartmentInfo
      extends 
         FDataOrganizationDepartmentUnit
{
   //是否有效
   private String _validCdStr;
   //父级标签
   private String _parentLable;

   public String validCdStr(){
      return _validCdStr;
   }

   public void setValidCdStr(String _validCdStr){
      this._validCdStr = _validCdStr;
   }
   public String parentLable(){
      return _validCdStr;
   }
   
   public void setParentLable(String _parentLable){
      this._parentLable = _parentLable;
   }

   // ============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   // ============================================================
   @Override
   public void saveMap(Map<String, String> map) {
      super.saveMap(map);
      map.put("validCdStr", _validCdStr);
      map.put("parentLable", _parentLable);
   }
}
