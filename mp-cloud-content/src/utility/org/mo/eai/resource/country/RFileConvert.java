package org.mo.eai.resource.country;

import org.mo.com.io.FLinesFile;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;

public class RFileConvert
{
   public class SProvince
   {
      public String name;

      public String label;

      public String color;

      public SProvince(String name,
                       String label,
                       String color){
      }
   }

   static FObjects<SProvince> _provinces = new FObjects<SProvince>(SProvince.class);

   static{
      //      _provinces.push(new SProvince("guangxi", "广西", "C8C1E3"));
      //      _provinces.push(new SProvince("guangdong", "广东", "FBC5DC"));
      //      _provinces.push(new SProvince("hunan", "湖南", "DBEDC7"));
      //      _provinces.push(new SProvince("guizhou", "贵州", "E7CCAF"));
      //      _provinces.push(new SProvince("yunnan", "云南", "DBEDC7"));
      //
      //      _provinces.push(new SProvince("fujian", "福建", "FEFCBF"));
      //      _provinces.push(new SProvince("jiangxi", "江西", "E7CCAF"));
      //      _provinces.push(new SProvince("zhejiang", "浙江", "C8C1E3"));
      //      _provinces.push(new SProvince("anhui", "安徽", "FBC5DC"));
      //      _provinces.push(new SProvince("hubei", "湖北", "C8C1E3"));
      //
      //      _provinces.push(new SProvince("hebei", "河南", "DBECC8"));
      //      _provinces.push(new SProvince("jiangsu", "江苏", "DBECC8"));
      //      _provinces.push(new SProvince("sichuan", "四川", "FCFBBB"));
      //      _provinces.push(new SProvince("shandong", "山东", "FCFBBB"));
      //      _provinces.push(new SProvince("liaoning", "辽宁", "FCFBBB"));
      //
      //      _provinces.push(new SProvince("xinjiang", "新疆", "FCFBBB"));
      //      _provinces.push(new SProvince("xizang", "西藏", "E7CCAF"));
      //      _provinces.push(new SProvince("shaanxi", "陕西", "E7CCAF"));
      //      _provinces.push(new SProvince("hebei", "河北", "E7CCAF"));
      //      _provinces.push(new SProvince("helongjiang", "黑龙江", "E7CCAF"));
      //      _provinces.push(new SProvince("ningxia", "宁夏", "FBC5DC"));
      //
      //      _provinces.push(new SProvince("neimenggu", "内蒙古自治区", "DBEDC7"));
      //      _provinces.push(new SProvince("qinghai", "青海", "DBEDC7"));
      //      _provinces.push(new SProvince("gansu", "甘肃", "C8C1E3"));
      //      _provinces.push(new SProvince("shanxi", "山西", "FBC5DC"));
      //      _provinces.push(new SProvince("jiling", "吉林省", "C8C1E3"));
      //
      //      _provinces.push(new SProvince("beijing", "北京", "FBC5DC"));
      //      _provinces.push(new SProvince("tianjing", "天津", "C8C1E3"));
      //      _provinces.push(new SProvince("shanghai", "上海", "FCFBBB"));
      //      _provinces.push(new SProvince("chongqing", "重庆市", "FBC5DC"));
      //      _provinces.push(new SProvince("xianggang", "香港", "C8C1E3"));
      //      _provinces.push(new SProvince("hainan", "海南省", "FCFBBB"));
      //      _provinces.push(new SProvince("taiwan", "台湾", "DBECC8"));
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String fileName = "D:/Temp/china";
      FLinesFile file = new FLinesFile(fileName);
      int count = file.count();
      int n = -1;
      FCountryData activeCountry = new FCountryData();
      FProvinceData activeProvince = null;
      FBoundaryData activeBoundary = null;
      while(++n < count){
         String line = file.line(n);
         if(RString.startsWith(line, "province:")){
            activeProvince = new FProvinceData();
            activeProvince.setName(line.substring(9));
            activeCountry.pushBoundary(activeProvince);
         }
         if(RString.startsWith(line, "color:")){
            String color = line.substring(6);
            int colorValue = Integer.parseInt(color, 16);
            activeProvince.setColor(colorValue);
         }
         if(RString.startsWith(line, "boundary:")){
            activeBoundary = new FBoundaryData();
            activeProvince.pushBoundary(activeBoundary);
         }
         if(RString.startsWith(line, "vertex_source:")){
            String vertexSource = line.substring(14);
            activeBoundary.parseVertexSource(vertexSource);
         }
         if(RString.startsWith(line, "index_source:")){
            String idnexSource = line.substring(13);
            activeBoundary.parseIndexSource(idnexSource);
         }
      }
      System.out.println(activeCountry.dump());
      activeCountry.serializeFile("D:/Microbject/MoScript/source/ars/eai/country.dat");
   }
}
