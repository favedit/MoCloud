package org.mo.eai.country;

import org.mo.com.io.FLinesFile;
import org.mo.com.lang.RString;

public class RDataConvert
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String fileName = "D:/Microbject/MoScript/source/test/baidu/data.txt";
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
