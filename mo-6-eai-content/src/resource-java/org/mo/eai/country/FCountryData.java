package org.mo.eai.country;

import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.generic.TDumpInfo;
import org.mo.content.geom.boundary.FBoundary;
import org.mo.content.geom.boundary.FBoundaryOptimizer;
import org.mo.content.geom.boundary.SBoundaryPoint;

//============================================================
// <T>国家数据。</T>
//============================================================
public class FCountryData
      extends FObject
{
   // 省份集合
   protected FObjects<FProvinceData> _provinces = new FObjects<FProvinceData>(FProvinceData.class);

   //============================================================
   // <T>构造国家数据。</T>
   //============================================================
   public FCountryData(){
   }

   //============================================================
   // <T>获得省份集合。</T>
   //
   // @return 省份集合
   //============================================================
   public FObjects<FProvinceData> provinces(){
      return _provinces;
   }

   //============================================================
   // <T>增加一个省份。</T>
   //
   // @param province 省份
   //============================================================
   public void pushBoundary(FProvinceData province){
      _provinces.push(province);
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void calculate(){
      for(FProvinceData province : _provinces){
         province.calculate();
      }
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void optimize(double rate){
      // 建立边界优化器
      int pointTotal = 0;
      FBoundaryOptimizer optimizer = new FBoundaryOptimizer(rate);
      for(FProvinceData province : _provinces){
         for(FBoundaryData boundaryData : province.boundaries()){
            boundaryData.check();
            FBoundary boundary = new FBoundary();
            int pointCount = boundaryData.points().count();
            for(int n = 0; n < pointCount; n++){
               SBoundaryPoint value = boundaryData.points().get(n);
               if(n != pointCount - 1){
                  boundary.pushPoint(optimizer.syncPoint(value));
                  pointTotal++;
               }
            }
            optimizer.pushBoundary(boundary);
            boundaryData.setBoundary(boundary);
         }
      }
      // 优化处理
      optimizer.calculate();
      // 读取数据
      int optimizeTotal = 0;
      for(FProvinceData province : _provinces){
         for(FBoundaryData boundaryData : province.boundaries()){
            boundaryData.optimize();
            optimizeTotal += boundaryData.optimizePoints().count();
         }
      }
      System.out.println("Optimize country: " + pointTotal + " -> " + optimizeTotal);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeString("china");
      output.writeString("中国");
      output.writeInt32(0);
      output.writeInt32(_provinces.count());
      for(FProvinceData province : _provinces){
         province.serialize(output);
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

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      for(FProvinceData province : _provinces){
         province.dump(info);
         info.appendLine();
      }
      return info;
   }
}
