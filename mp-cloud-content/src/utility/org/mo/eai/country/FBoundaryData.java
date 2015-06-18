package org.mo.eai.country;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FInts;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.lang.generic.TDumpInfo;

//============================================================
// <T>边界数据。</T>
//============================================================
public class FBoundaryData
      extends FObject
{
   // 点集合
   protected FObjects<SDoublePoint3> _points = new FObjects<SDoublePoint3>(SDoublePoint3.class);

   // 索引集合
   protected FInts _indexes = new FInts();

   // 几何体顶点集合
   protected FObjects<SDoublePoint3> _geometryPoints = new FObjects<SDoublePoint3>(SDoublePoint3.class);

   // 几何体索引集合
   protected FInts _geometryIndexes = new FInts();

   //============================================================
   // <T>构造边界数据。</T>
   //============================================================
   public FBoundaryData(){
   }

   //============================================================
   // <T>获得顶点集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SDoublePoint3> points(){
      return _points;
   }

   //============================================================
   // <T>获得索引集合。</T>
   //
   // @return 索引集合
   //============================================================
   public FInts indexes(){
      return _indexes;
   }

   //============================================================
   // <T>解析顶点字符串。</T>
   //
   // @param source 字符串
   //============================================================
   public void parseVertexSource(String source){
      String[] pointValues = RString.split(source, ';');
      for(String pointValue : pointValues){
         SDoublePoint3 point = new SDoublePoint3();
         point.parse(pointValue);
         _points.push(point);
      }
   }

   //============================================================
   // <T>解析索引字符串。</T>
   //
   // @param source 字符串
   //============================================================
   public void parseIndexSource(String source){
      String[] indexValues = RString.split(source, ',');
      for(String indexValue : indexValues){
         _indexes.append(RInteger.parse(indexValue));
      }
   }

   //============================================================
   // <T>解析索引字符串。</T>
   //
   // @param source 字符串
   //============================================================
   public void makeGeometry(){
      // 生成上表面点集合
      //int pointCount = _points.count();
      for(SDoublePoint3 point : _points){
         _geometryPoints.push(new SDoublePoint3(point.x, point.y, 0));
      }
      //      // 生成下表面点集合
      //      for(SDoublePoint3 point : _points){
      //         _geometryPoints.push(new SDoublePoint3(point.x, point.y, 20));
      //      }
      // 生成上表面索引
      int count = _indexes.length();
      for(int n = 0; n < count; n++){
         _geometryIndexes.append(_indexes.get(n));
      }
      //      // 生成下表面索引
      //      for(int n = 0; n < count; n++){
      //         _geometryIndexes.append(pointCount + _indexes.get(n));
      //      }
      //      // 生成边缘索引
      //      for(int n = 0; n < pointCount; n++){
      //         if(n != count - 1){
      //            _geometryIndexes.append(n);
      //            _geometryIndexes.append(n + 1);
      //            _geometryIndexes.append(pointCount);
      //            _geometryIndexes.append(n + 1);
      //            _geometryIndexes.append(pointCount + 1);
      //            _geometryIndexes.append(pointCount);
      //         }else{
      //            _geometryIndexes.append(n);
      //            _geometryIndexes.append(n + 1);
      //            _geometryIndexes.append(0);
      //            _geometryIndexes.append(n + 1);
      //            _geometryIndexes.append(1);
      //            _geometryIndexes.append(0);
      //         }
      //      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeOld(IDataOutput output){
      // 输出顶点集合
      output.writeInt32(_points.count());
      for(SDoublePoint3 point : _points){
         point.serializeFloat3(output);
      }
      // 输出顶点集合
      int count = _indexes.length();
      output.writeInt32(count);
      for(int i = 0; i < count; i++){
         output.writeUint16(_indexes.get(i));
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      makeGeometry();
      // 输出顶点集合
      output.writeInt32(_geometryPoints.count());
      for(SDoublePoint3 point : _geometryPoints){
         point.serializeFloat3(output);
      }
      // 输出顶点集合
      int count = _geometryIndexes.length();
      output.writeInt32(count);
      for(int i = 0; i < count; i++){
         output.writeUint16(_geometryIndexes.get(i));
      }
   }

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      info.append("point_count=" + _points.count());
      info.append(", index_count=" + _indexes.length());
      return info;
   }
}
