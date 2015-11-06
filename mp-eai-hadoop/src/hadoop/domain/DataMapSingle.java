package domain;

import java.util.Map;

public class DataMapSingle
{
   public static Map<String, String> dataMap;

   public Map<String, String> getDataMap(){
      return dataMap;
   }

   public void setDataMap(Map<String, String> dataMap){
      this.dataMap = dataMap;
   }

   private static DataMapSingle dataMapSingle = new DataMapSingle();

   public static DataMapSingle getDataMapSingle(){
      return dataMapSingle;
   }
}
