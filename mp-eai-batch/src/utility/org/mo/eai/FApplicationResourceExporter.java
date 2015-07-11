package org.mo.eai;

import org.mo.com.io.IDataOutput;
import org.mo.eai.template.card.FCardTemplate;
import org.mo.eai.template.city.FCityTemplate;
import org.mo.eai.template.province.FProvinceTemplate;
import org.mo.eai.template.rate.FRateTemplate;

//============================================================
// <T>资源导出器。</T>
//============================================================
public class FApplicationResourceExporter
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
      FProvinceTemplate provinceTemplate = RBatchResourceExportor.provinceTemplate();
      provinceTemplate.parser();
      provinceTemplate.serialize(output);
      // 输出城市信息集合
      FCityTemplate cityTemplate = RBatchResourceExportor.cityTemplate();
      cityTemplate.serialize(output);
      // 输出卡片信息集合
      FCardTemplate cardTemplate = new FCardTemplate();
      cardTemplate.parser();
      cardTemplate.serialize(output);
   }
}
