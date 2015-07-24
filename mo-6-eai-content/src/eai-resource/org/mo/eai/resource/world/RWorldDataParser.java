package org.mo.eai.resource.world;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mo.com.geom.SDoublePoint3;
import org.mo.com.io.FStringFile;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>世界数据。</T>
//============================================================
public class RWorldDataParser
{
   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public static void loadBountry(FBoundaryData boundary,
                                  JsonNode jsonBoundary){
      // 读取坐标集合
      for(JsonNode jsonPoint : jsonBoundary){
         double jsonX = jsonPoint.get(0).asDouble();
         double jsonY = jsonPoint.get(1).asDouble();
         boundary.parsePoint(new SDoublePoint3(jsonX, jsonY, 0));
      }
      // 计算索引
      boundary.calculate();
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public static void loadCountry(FCountryData country,
                                  JsonNode jsonObject){
      // 读取属性
      JsonNode jsonProperties = jsonObject.get("properties");
      String brkName = jsonProperties.get("BRK_NAME").asText();
      country.setCode(brkName);
      // 读取属性
      JsonNode jsonGeometry = jsonObject.get("geometry");
      String geometryType = jsonGeometry.get("type").asText();
      // 读取坐标集合
      JsonNode jsonCoordinates = jsonGeometry.get("coordinates");
      for(JsonNode jsonCoordinate : jsonCoordinates){
         if(geometryType.equals("Polygon")){
            FBoundaryData boundary = new FBoundaryData();
            boundary.setCountry(country);
            loadBountry(boundary, jsonCoordinate);
            country.pushBoundary(boundary);
         }else if(geometryType.equals("MultiPolygon")){
            for(JsonNode jsonBoundary : jsonCoordinate){
               FBoundaryData boundary = new FBoundaryData();
               boundary.setCountry(country);
               loadBountry(boundary, jsonBoundary);
               country.pushBoundary(boundary);
            }
         }else{
            throw new FFatalError("Invalid message");
         }
      }
      System.out.println(brkName + " - " + geometryType + " - [" + country.boundaryCount() + " - " + country.boundaryPointCount() + "]");
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public static void main(String[] args){
      // 读取文件
      String jsonFileName = "D:/Microbject/MoScript/source/test/google/world.json";
      FStringFile file = new FStringFile(jsonFileName);
      String jsonSource = file.toString();
      FWorldData world = new FWorldData();
      // 解析内容
      ObjectMapper mapper = new ObjectMapper();
      try{
         JsonNode jsonRoot = mapper.readTree(jsonSource);
         // 读取数据
         JsonNode jsonFeatures = jsonRoot.get("features");
         for(JsonNode jsonFeature : jsonFeatures){
            FCountryData country = new FCountryData();
            loadCountry(country, jsonFeature);
            world.pushCountry(country);
         }
      }catch(Exception e){
         e.printStackTrace();
      }
      // 优化数据
      world.optimize(0.01);
      // 存储文件
      world.serializeFile("D:/Microbject/MoScript/source/ars/eai/data/world.dat");
      System.out.println("Success");
   }
}
