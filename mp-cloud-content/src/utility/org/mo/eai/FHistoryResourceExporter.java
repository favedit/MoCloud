package org.mo.eai;

import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataOutput;
import org.mo.eai.template.card.FCardTemplate;
import org.mo.eai.template.city.FCityTemplate;
import org.mo.eai.template.province.FProvinceTemplate;
import org.mo.eai.template.rate.FRateTemplate;

//============================================================
// <T>资源导出器。</T>
//============================================================
public class FHistoryResourceExporter
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
      FProvinceTemplate provinceTemplate = RResourceExportor.provinceTemplate();
      provinceTemplate.parser();
      provinceTemplate.serialize(output);
      // 输出城市信息集合
      FCityTemplate cityTemplate = RResourceExportor.cityTemplate();
      cityTemplate.serialize(output);
      // 输出卡片信息集合
      FCardTemplate cardTemplate = new FCardTemplate();
      cardTemplate.serialize(output);
      // 增加内容
      FByteFile investmentFile = new FByteFile();
      investmentFile.loadFile("D:/Microbject/MoScript/source/ars/eai/investment.dat");
      output.write(investmentFile.memory(), 0, investmentFile.length());
      investmentFile.close();
   }
}
