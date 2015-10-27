package org.mo.eai.resource;

import org.mo.com.io.IDataOutput;
import org.mo.eai.FResourceExporter;
import org.mo.eai.resource.card.FEaiCardTemplate;
import org.mo.eai.resource.city.FEaiCityTemplate;
import org.mo.eai.resource.province.FEaiProvinceTemplate;
import org.mo.eai.template.department.FDepartmentTemplate;
import org.mo.eai.template.rate.FRateTemplate;

//============================================================
// <T>资源导出器。</T>
//============================================================
public class FEaiResourceExporter
      extends FResourceExporter
{
   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      // 输出比率信息集合
      FRateTemplate rateTemplate = new FRateTemplate();
      rateTemplate.parser();
      rateTemplate.serialize(output);
      // 输出城市信息集合
      FEaiProvinceTemplate provinceTemplate = REaiResourceExportor.provinceTemplate();
      provinceTemplate.parser();
      provinceTemplate.serialize(output);
      // 输出城市信息集合
      FEaiCityTemplate cityTemplate = REaiResourceExportor.cityTemplate();
      cityTemplate.serialize(output);
      // 输出卡片信息集合
      FEaiCardTemplate cardTemplate = new FEaiCardTemplate();
      cardTemplate.parser();
      cardTemplate.serialize(output);
      // 输出部门信息集合
      FDepartmentTemplate departmentTemplate = new FDepartmentTemplate();
      departmentTemplate.parser();
      departmentTemplate.serialize(output);
   }
}
