package org.mo.eai.country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mo.com.geom.SDoublePoint3;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FInts;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.lang.generic.TDumpInfo;
import org.mo.eai.resource.country.FPolygonPoint;
import org.poly2tri.Poly2Tri;
import org.poly2tri.geometry.polygon.Polygon;
import org.poly2tri.geometry.polygon.PolygonPoint;
import org.poly2tri.triangulation.TriangulationPoint;
import org.poly2tri.triangulation.delaunay.DelaunayTriangle;

//============================================================
// <T>边界数据。</T>
//============================================================
public class FBoundaryData
      extends FObject
{
   public boolean valid = true;

   // 点集合
   protected FObjects<SBoundaryPoint> _points = new FObjects<SBoundaryPoint>(SBoundaryPoint.class);

   // 点集合
   protected FObjects<SBoundaryPoint> _optimizePoints = new FObjects<SBoundaryPoint>(SBoundaryPoint.class);

   // 索引集合
   protected FInts _indexes = new FInts();

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
   public FObjects<SBoundaryPoint> points(){
      return _points;
   }

   //============================================================
   // <T>获得优化顶点集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SBoundaryPoint> optimizePoints(){
      return _optimizePoints;
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
         SBoundaryPoint point = new SBoundaryPoint();
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
   // <T>计算数据。</T>
   //============================================================
   public void calculate(){
      // 填充数据
      List<PolygonPoint> polygonPoints = new ArrayList<PolygonPoint>();
      int count = _points.count();
      for(int n = 0; n < count - 1; n++){
         SDoublePoint3 point = _points.get(n);
         PolygonPoint polygonPoint = new FPolygonPoint(n, point.x, point.y, point.z);
         polygonPoints.add(polygonPoint);
      }
      Polygon polygon = new Polygon(polygonPoints);
      // 转换数据
      Poly2Tri.triangulate(polygon);
      // 获得索引
      _indexes.clear();
      for(DelaunayTriangle triangle : polygon.getTriangles()){
         TriangulationPoint[] points = triangle.points;
         _indexes.append(((FPolygonPoint)points[0]).index());
         _indexes.append(((FPolygonPoint)points[1]).index());
         _indexes.append(((FPolygonPoint)points[2]).index());
      }
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void calculate2(){
      // 填充数据
      List<PolygonPoint> polygonPoints = new ArrayList<PolygonPoint>();
      int count = _optimizePoints.count();
      for(int n = 0; n < count - 1; n++){
         SBoundaryPoint point = _optimizePoints.get(n);
         if(point.valid){
            PolygonPoint polygonPoint = new FPolygonPoint(n, point.x, point.y, point.z);
            polygonPoints.add(polygonPoint);
         }
      }
      if(polygonPoints.size() < 3){
         valid = false;
         return;
      }
      Polygon polygon = new Polygon(polygonPoints);
      // 转换数据
      try{
         Poly2Tri.triangulate(polygon);
      }catch(Exception e){
         valid = false;
         return;
      }
      // 获得索引
      _indexes.clear();
      for(DelaunayTriangle triangle : polygon.getTriangles()){
         TriangulationPoint[] points = triangle.points;
         _indexes.append(((FPolygonPoint)points[0]).index());
         _indexes.append(((FPolygonPoint)points[1]).index());
         _indexes.append(((FPolygonPoint)points[2]).index());
      }
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void optimize(){
      // 计算所有点关联线的平均长度
      SBoundaryPoint[] points = _optimizePoints.toObjects();
      Arrays.sort(points, 0, points.length, new SBoundaryPointComparator());
      // 优化掉百分比点
      float rate = 1;
      if(points.length > 1000){
         rate = 0.4f;
      }else if(points.length > 500){
         rate = 0.3f;
      }else if(points.length > 200){
         rate = 0.2f;
      }else if(points.length > 100){
         rate = 0.1f;
      }else{
         rate = 0.0f;
      }
      int optimizeCount = (int)(points.length * rate);
      for(int n = 0; n < optimizeCount; n++){
         points[n].valid = false;
      }
      calculate2();
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 输出顶点集合
      int pointCount = 0;
      for(SBoundaryPoint point : _optimizePoints){
         if(point.valid){
            pointCount++;
         }
      }
      output.writeInt32(pointCount);
      for(SBoundaryPoint point : _optimizePoints){
         if(point.valid){
            output.writeFloat((float)point.x);
            output.writeFloat((float)point.y);
         }
      }
      //      int pointCount = _points.count();
      //      output.writeInt32(pointCount);
      //      for(SDoublePoint3 point : _points){
      //         output.writeFloat((float)point.x);
      //         output.writeFloat((float)point.y);
      //      }
      // 输出顶点集合
      int count = _indexes.length();
      output.writeInt32(count);
      for(int i = 0; i < count; i++){
         output.writeUint16(_indexes.get(i));
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
