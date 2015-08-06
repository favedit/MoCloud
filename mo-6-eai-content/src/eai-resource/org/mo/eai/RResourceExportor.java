package org.mo.eai;

import org.mo.eai.template.card.FCardTemplate;
import org.mo.eai.template.city.FCityTemplate;
import org.mo.eai.template.department.FDepartmentTemplate;
import org.mo.eai.template.province.FProvinceTemplate;

//============================================================
// <T>资源导出器。</T>
//============================================================
public class RResourceExportor
{
   // 省份模板
   protected static FProvinceTemplate _provinceTemplate;

   // 城市模板
   protected static FCityTemplate _cityTemplate;

   // 卡片模板
   protected static FCardTemplate _cardTemplate;

   // 部门模板
   protected static FDepartmentTemplate _departmentTemplate;

   //============================================================
   // <T>获得城市模板。</T>
   //
   // @return 城市模板
   //============================================================
   public static FProvinceTemplate provinceTemplate(){
      if(_provinceTemplate == null){
         _provinceTemplate = new FProvinceTemplate();
         _provinceTemplate.parser();
      }
      return _provinceTemplate;
   }

   //============================================================
   // <T>获得城市模板。</T>
   //
   // @return 城市模板
   //============================================================
   public static FCityTemplate cityTemplate(){
      if(_cityTemplate == null){
         _cityTemplate = new FCityTemplate();
         _cityTemplate.parser();
      }
      return _cityTemplate;
   }

   //============================================================
   // <T>获得卡片模板。</T>
   //
   // @return 卡片模板
   //============================================================
   public static FCardTemplate cardTemplate(){
      if(_cardTemplate == null){
         _cardTemplate = new FCardTemplate();
         _cardTemplate.parser();
      }
      return _cardTemplate;
   }

   //============================================================
   // <T>获得卡片模板。</T>
   //
   // @return 卡片模板
   //============================================================
   public static FDepartmentTemplate departmentTemplate(){
      if(_departmentTemplate == null){
         _departmentTemplate = new FDepartmentTemplate();
         _departmentTemplate.parser();
      }
      return _departmentTemplate;
   }
}
