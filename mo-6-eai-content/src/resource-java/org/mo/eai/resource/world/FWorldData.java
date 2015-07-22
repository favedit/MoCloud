package org.mo.eai.resource.world;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.content.geom.boundary.FBoundary;
import org.mo.content.geom.boundary.FBoundaryOptimizer;

//============================================================
// <T>世界数据。</T>
//============================================================
public class FWorldData
{
   // 国家集合
   protected FObjects<FCountryData> _countrys = new FObjects<FCountryData>(FCountryData.class);

   //============================================================
   // <T>构造国家数据。</T>
   //============================================================
   public FWorldData(){
   }

   //============================================================
   // <T>获得国家集合。</T>
   //
   // @return 国家集合
   //============================================================
   public FObjects<FCountryData> countrys(){
      return _countrys;
   }

   //============================================================
   // <T>增加一个国家。</T>
   //
   // @param country 国家
   //============================================================
   public void pushCountry(FCountryData country){
      _countrys.push(country);
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void optimize(double rate){
      // 建立边界优化器
      FBoundaryOptimizer optimizer = new FBoundaryOptimizer(rate);
      for(FCountryData country : _countrys){
         for(FBoundaryData boundaryData : country.boundaries()){
            FBoundary boundary = new FBoundary();
            int pointCount = boundaryData.points().count();
            for(int n = 0; n < pointCount; n++){
               SDoublePoint3 value = boundaryData.points().get(n);
               if(n != pointCount - 1){
                  boundary.pushPoint(optimizer.syncPoint(value));
               }
            }
            optimizer.pushBoundary(boundary);
            boundaryData.setBoundary(boundary);
         }
      }
      // 优化处理
      optimizer.calculate();
      // 读取数据
      for(FCountryData country : _countrys){
         for(FBoundaryData boundaryData : country.boundaries()){
            boundaryData.optimize();
         }
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      int count = _countrys.count();
      output.writeInt32(count);
      for(FCountryData country : _countrys){
         country.serialize(output);
      }
   }

   //============================================================
   // <T>保存序列化数据到文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void serializeFile(String fileName){
      FByteFile file = new FByteFile();
      serialize(file);
      file.saveToFile(fileName);
   }
}
