package org.mo.eai;

import org.mo.com.io.FByteFile;
import org.mo.eai.template.city.FCityTemplate;
import org.mo.eai.template.province.FProvinceTemplate;
import org.mo.eai.template.rate.FRateTemplate;

public class RTemplateExport
{
   protected static FCityTemplate _cityTemplate;

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
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args){
      FByteFile file = new FByteFile();
      // 输出比率信息集合
      FRateTemplate rateTemplate = new FRateTemplate();
      rateTemplate.parser();
      rateTemplate.serialize(file);
      // 输出城市信息集合
      FProvinceTemplate provinceTemplate = new FProvinceTemplate();
      provinceTemplate.parser();
      provinceTemplate.serialize(file);
      // 输出城市信息集合
      FCityTemplate cityTemplate = cityTemplate();
      cityTemplate.serialize(file);
      // 增加内容
      FByteFile investmentFile = new FByteFile();
      investmentFile.loadFile("D:/Microbject/MoScript/source/ars/eai/investment.dat");
      file.append(investmentFile);
      // 存储文件
      file.saveToFile("D:/Microbject/MoScript/source/ars/eai/resource.dat");
   }
}
