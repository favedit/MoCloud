package org.mo.eai.template.city;

import org.mo.com.io.FLinesFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RString;

public class FCityTemplate
{

   protected String _fileName = "D:/Microbject/MoScript/data/citys.csv";

   protected FObjects<FCityData> _citys = new FObjects<FCityData>(FCityData.class);

   public void parser(){
      FLinesFile file = new FLinesFile();
      file.loadFile(_fileName);
      int count = file.count();
      for(int n = 1; n < count; n++){
         String line = file.line(n);
         if(!RString.isEmpty(line)){
            String[] items = RString.split(line.trim(), ',', 5);
            FCityData city = new FCityData();
            city.setProvinceName(RString.trim(items[0]));
            city.setProvinceCode(RString.trim(items[1]));
            city.setName(RString.trim(items[2]));
            city.setCode(RString.trim(items[3]));
            String location = items[4];
            if(RString.startsWith(location, "\"") && RString.endsWith(location, "\"")){
               location = location.substring(1, location.length() - 1);
               String[] locations = RString.split(location, ',');
               if(locations.length != 2){
                  throw new FFatalError("Location is valid");
               }
               city.location().x = RDouble.parse(locations[0]);
               city.location().y = RDouble.parse(locations[1]);
               _citys.push(city);
            }
            System.out.println(items[0] + " - " + items[1] + " - " + items[2] + " - " + items[3] + " - " + items[4]);
         }
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeInt32(_citys.count());
      for(FCityData city : _citys){
         city.serialize(output);
      }
   }
}
