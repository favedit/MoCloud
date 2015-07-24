package org.mo.eai.template.city;

import org.mo.com.io.FLinesFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.eai.RResourceConfiguration;

//============================================================
// <T>城市模板。</T>
//============================================================
public class FCityTemplate
{
   // 城市资源集合
   protected FDictionary<FCityResource> _citys = new FDictionary<FCityResource>(FCityResource.class);

   // 卡片资源
   //protected FDictionary<FCityResource> _cards = new FDictionary<FCityResource>(FCityResource.class);

   //============================================================
   // <T>获得城市集合。</T>
   //
   // @return 城市集合
   //============================================================
   public FDictionary<FCityResource> citys(){
      return _citys;
   }

   //============================================================
   // <T>获得城市集合。</T>
   //
   // @return 城市集合
   //============================================================
   public FCityResource findCity(String code){
      return _citys.find(code);
   }

   //============================================================
   // <T>获得城市集合。</T>
   //
   // @return 城市集合
   //============================================================
   //   public FDictionary<FCityResource> cards(){
   //      return _cards;
   //   }

   //============================================================
   // <T>解析处理。</T>
   //============================================================
   public void parser(){
      String fielName = RResourceConfiguration.HomeData + "/citys.csv";
      // 打开文件
      FLinesFile file = new FLinesFile();
      file.loadFile(fielName, "GB2312");
      // 读取所有行
      int count = file.count();
      for(int n = 1; n < count; n++){
         String line = file.line(n);
         if(!RString.isEmpty(line)){
            String[] items = RString.split(line.trim(), ',', 8);
            if(items.length != 8){
               throw new FFatalError("Line is invalid.");
            }
            boolean valid = RBoolean.parse(items[4]);
            if(!valid){
               continue;
            }
            FCityResource city = new FCityResource();
            city.setProvinceCode(RString.trim(items[0]));
            city.setProvinceLabel(RString.trim(items[1]));
            city.setCode(RString.trim(items[2]));
            city.setLabel(RString.trim(items[3]));
            city.setLevel(RInteger.parse(RString.trim(items[5])));
            city.setCardCode(RString.trim(items[6]));
            String location = items[7];
            if(RString.startsWith(location, "\"") && RString.endsWith(location, "\"")){
               location = location.substring(1, location.length() - 1);
               String[] locations = RString.split(location, ',');
               if(locations.length != 2){
                  throw new FFatalError("Location is valid.");
               }
               city.location().x = RDouble.parse(locations[0]);
               city.location().y = RDouble.parse(locations[1]);
               _citys.set(city.code(), city);
               //_cards.set(city.cardCode(), city);
            }else{
               throw new FFatalError("Line is invalid.");
            }
            //System.out.println(items[0] + " - " + items[1] + " - " + items[2] + " - " + items[3] + " - " + items[4] + " - " + items[5] + " - " + items[6]);
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
      for(INamePair<FCityResource> pair : _citys){
         pair.value().serialize(output);
      }
   }
}
