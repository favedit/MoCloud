package org.mo.eai.resource.country;

import org.mo.com.io.RFile;
import org.mo.eai.RResourceExportor;
import org.mo.eai.template.province.FProvinceResource;
import org.mo.eai.template.province.FProvinceTemplate;

public class RDataConvert
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      FProvinceTemplate provinceTemplate = RResourceExportor.provinceTemplate();

      String filePath = "D:/Microbject/MoScript/data/country";
      FCountryData countryData = new FCountryData();
      for(String fileName : RFile.listFiles(filePath)){
         String code = fileName.substring(filePath.length() + 1, filePath.length() + 3);
         FProvinceResource province = provinceTemplate.findByCode(code);
         FProvinceData provinceData = new FProvinceData();
         provinceData.setName(province.name());
         provinceData.loadFile(fileName);
         countryData.provinces().push(provinceData);
         System.out.println("Parse province: " + fileName);
      }
      //System.out.println(countryData.dump());
      countryData.serializeFile("D:/Microbject/MoScript/source/ars/eai/country.dat");
   }
}
