package org.mo.eai.country;

import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.generic.TDumpInfo;

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
   public void optimize(){
      // 建立顶点字典
      int pointTotal = 0;
      FDictionary<SBoundaryPoint> boundaryPoints = new FDictionary<SBoundaryPoint>(SBoundaryPoint.class);
      for(FProvinceData province : _provinces){
         for(FBoundaryData boundary : province.boundaries()){
            for(SBoundaryPoint point : boundary.points()){
               String code = point.toString();
               SBoundaryPoint find = boundaryPoints.find(code);
               if(find == null){
                  find = new SBoundaryPoint(point);
                  find.index = boundaryPoints.count();
                  boundaryPoints.set(code, find);
               }
               boundary.optimizePoints().push(find);
               pointTotal++;
            }
         }
      }
      System.out.println("Point total=" + pointTotal + " count=" + boundaryPoints.count());
      // 计算所有点在边界上的长度
      int lineTotal = 0;
      FDictionary<SBoundaryLine> boundaryLines = new FDictionary<SBoundaryLine>(SBoundaryLine.class);
      for(FProvinceData province : _provinces){
         for(FBoundaryData boundary : province.boundaries()){
            FObjects<SBoundaryPoint> points = boundary.optimizePoints();
            int count = points.count();
            for(int i = 0; i < count; i++){
               SBoundaryPoint point1 = null;
               SBoundaryPoint point2 = null;
               if(i != count - 1){
                  // 中间点
                  point1 = points.get(i);
                  point2 = points.get(i + 1);
               }else{
                  // 结尾点
                  point1 = points.get(i);
                  point2 = points.get(0);
               }
               lineTotal++;
               // 查找线段
               String code = point1.toString() + "|" + point2.toString();
               SBoundaryLine find = boundaryLines.find(code);
               if(find == null){
                  code = point2.toString() + "|" + point2.toString();
                  find = boundaryLines.find(code);
               }
               if(find == null){
                  find = new SBoundaryLine(point1, point2);
                  boundaryLines.set(code, find);
               }
               point1.pushLine(find);
               point2.pushLine(find);
            }
         }
      }
      System.out.println("Line total=" + lineTotal + " count=" + boundaryLines.count());
      // 计算所有点关联线的平均长度
      for(INamePair<SBoundaryPoint> pair : boundaryPoints){
         pair.value().calculateLength();
      }
      //SBoundaryPoint[] points = boundaryPoints.toObjects();
      //Arrays.sort(points, 0, points.length, new SBoundaryPointComparator());
      // 优化掉百分比点
      //int optimizeCount = (int)(points.length * 0.0);
      //for(int n = 0; n < optimizeCount; n++){
      //   points[n].valid = false;
      //}
      // 重新计算三角面
      for(FProvinceData province : _provinces){
         for(FBoundaryData boundary : province.boundaries()){
            boundary.optimize();
         }
      }
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
