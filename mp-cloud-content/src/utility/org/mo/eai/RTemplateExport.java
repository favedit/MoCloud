package org.mo.eai;

import org.mo.com.io.FByteFile;
import org.mo.eai.template.city.FCityTemplate;
import org.mo.eai.template.province.FProvinceTemplate;

public class RTemplateExport
{
   public static void main(String[] args){
      FByteFile file = new FByteFile();
      // 输出城市信息集合
      FProvinceTemplate provinceTemplate = new FProvinceTemplate();
      provinceTemplate.parser();
      provinceTemplate.serialize(file);
      // 输出城市信息集合
      FCityTemplate template = new FCityTemplate();
      template.parser();
      template.serialize(file);
      // 增加内容
      FByteFile investmentFile = new FByteFile();
      investmentFile.loadFile("D:/Microbject/MoScript/source/ars/eai/investment.dat");
      file.append(investmentFile);
      // 存储文件
      file.saveToFile("D:/Microbject/MoScript/source/ars/eai/resource.dat");
   }
}
