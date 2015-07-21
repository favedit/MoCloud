package org.mo.eai.country;

import org.mo.com.io.FLinesFile;
import org.mo.com.lang.RString;
import org.mo.eai.RResourceExportor;
import org.mo.eai.template.province.FProvinceResource;
import org.mo.eai.template.province.FProvinceTemplate;

public class RDataConvert
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String fileName = "D:/Microbject/MoScript/data/country/boundary.txt";
      FProvinceTemplate provinceTemplate = RResourceExportor.provinceTemplate();
      FLinesFile file = new FLinesFile(fileName);
      int count = file.count();
      int n = -1;
      FCountryData activeCountry = new FCountryData();
      FProvinceData activeProvince = null;
      FBoundaryData activeBoundary = null;
      while(++n < count){
         String line = RString.trim(file.line(n));
         if(RString.startsWith(line, "province:")){
            String name = line.substring(9).trim();
            FProvinceResource provinceResource = provinceTemplate.findByName(name);
            activeProvince = new FProvinceData();
            activeProvince.setCode(provinceResource.code());
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
      activeCountry.optimize(0.00001);
      activeCountry.serializeFile("D:/Microbject/MoScript/source/ars/eai/country.dat");
      System.out.println("Success");
   }
}
