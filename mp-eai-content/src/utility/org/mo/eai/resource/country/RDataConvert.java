package org.mo.eai.resource.country;

import java.util.List;
import net.sf.json.JSONObject;
import org.mo.com.io.FStringFile;
import org.mo.eai.RResourceExportor;
import org.mo.eai.template.province.FProvinceResource;
import org.mo.eai.template.province.FProvinceTemplate;

public class RDataConvert
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void pushProvince(FCountryData countryData,
                                   JSONObject jsonProvince){
      FProvinceTemplate provinceTemplate = RResourceExportor.provinceTemplate();
      String label = (String)jsonProvince.get("n");
      String boundaryData = (String)jsonProvince.get("b");
      //String pointData = (String)jsonProvince.get("g");
      FProvinceResource provinceResource = provinceTemplate.findByLabel(label);
      FProvinceData provinceData = new FProvinceData();
      provinceData.setCode(provinceResource.code());
      provinceData.parse(boundaryData);
      provinceData.calculate();
      countryData.provinces().push(provinceData);
      FStringFile file = new FStringFile();
      file.append(boundaryData);
      file.saveFile("D:/Microbject/MoScript/data/country2/" + label + ".txt");
      System.out.println("Parse province: " + label);
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   @SuppressWarnings("unchecked")
   public static void main(String[] args) throws Exception{
      FCountryData countryData = new FCountryData();
      FStringFile file = new FStringFile("D:/Microbject/MoScript/data/citydata.json");
      JSONObject dataJson = JSONObject.fromObject(file.toString());
      // 增加地区 
      {
         List<JSONObject> jsonProvinces = (List<JSONObject>)dataJson.get("municipalities");
         for(JSONObject jsonProvince : jsonProvinces){
            pushProvince(countryData, jsonProvince);
         }
      }
      // 增加省份
      {
         List<JSONObject> jsonProvinces = (List<JSONObject>)dataJson.get("provinces");
         for(JSONObject jsonProvince : jsonProvinces){
            pushProvince(countryData, jsonProvince);
         }
      }
      // 增加其他 
      {
         List<JSONObject> jsonProvinces = (List<JSONObject>)dataJson.get("other");
         for(JSONObject jsonProvince : jsonProvinces){
            pushProvince(countryData, jsonProvince);
         }
      }
      //System.out.println(countryData.dump());
      countryData.serializeFile("D:/Microbject/MoScript/source/ars/eai/country.dat");
   }
}
