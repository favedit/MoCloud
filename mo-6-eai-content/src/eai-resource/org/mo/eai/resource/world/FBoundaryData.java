package org.mo.eai.resource.world;

import java.util.ArrayList;
import java.util.List;
import org.mo.com.geom.SDoublePoint3;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FInts;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.generic.TDumpInfo;
import org.mo.content.geom.boundary.FBoundary;
import org.mo.content.geom.boundary.SBoundaryPoint;
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
   private FCountryData _country;

   private FBoundary _boundary;

   // 点集合
   protected FObjects<SDoublePoint3> _points = new FObjects<SDoublePoint3>(SDoublePoint3.class);

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
   public FObjects<SDoublePoint3> points(){
      return _points;
   }

   public FCountryData country(){
      return _country;
   }

   public void setCountry(FCountryData country){
      _country = country;
   }

   public FBoundary boundary(){
      return _boundary;
   }

   public void setBoundary(FBoundary boundary){
      _boundary = boundary;
   }

   //============================================================
   // <T>增加一个坐标。</T>
   //
   // @param point 坐标
   //============================================================
   public void parsePoint(SDoublePoint3 point){
      _points.push(point);
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
      for(int n = 0; n < count; n++){
         SBoundaryPoint point = _optimizePoints.get(n);
         PolygonPoint polygonPoint = new FPolygonPoint(n, point.x, point.y, point.z);
         polygonPoints.add(polygonPoint);
      }
      Polygon polygon = new Polygon(polygonPoints);
      // 转换数据
      try{
         Poly2Tri.triangulate(polygon);
      }catch(Exception e){
         throw new FFatalError("Invalid point.");
         //System.out.println(_country.code() + ": " + e.getMessage());
         //valid = false;
         //return;
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
      for(SBoundaryPoint point : _boundary.optimizePoints()){
         _optimizePoints.push(point);
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
      int pointCount = _optimizePoints.count();
      output.writeInt32(pointCount);
      for(SDoublePoint3 point : _optimizePoints){
         output.writeFloat((float)point.x);
         output.writeFloat((float)point.y);
      }
      // 输出顶点集合
      int indexCount = _indexes.length();
      output.writeInt32(indexCount);
      for(int i = 0; i < indexCount; i++){
         output.writeUint16(_indexes.get(i));
      }
      System.out.println("Write boundary. (point= " + RInteger.format(_points.count(), 4, ' ') + " -> " + RInteger.format(pointCount, 4, ' ') + ", index=" + indexCount + ")");
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
