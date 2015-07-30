package org.mo.eai.country;

import java.util.ArrayList;
import java.util.List;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FInts;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.lang.generic.TDumpInfo;
import org.mo.content.geom.boundary.FBoundary;
import org.mo.content.geom.boundary.SBoundaryPoint;
import org.mo.eai.RResourceExportor;
import org.mo.eai.resource.country.FPolygonPoint;
import org.mo.eai.template.province.FProvinceResource;
import org.mo.eai.template.province.FProvinceTemplate;
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

   // 省份信息
   protected FProvinceData _province;

   // 边界信息
   protected FBoundary _boundary;

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
   // <T>获得省份数据。</T>
   //
   // @return 省份数据
   //============================================================
   public FProvinceData province(){
      return _province;
   }

   //============================================================
   // <T>设置省份数据。</T>
   //
   // @param province 省份数据
   //============================================================
   public void setProvince(FProvinceData province){
      _province = province;
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

   public FBoundary boundary(){
      return _boundary;
   }

   public void setBoundary(FBoundary boundary){
      _boundary = boundary;
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
   // <T>检查内容。</T>
   //============================================================
   public int calculatePointCount(SBoundaryPoint find){
      int count = 0;
      for(SBoundaryPoint point : _points){
         if(point.equals(find)){
            count++;
         }
      }
      return count;
   }

   //============================================================
   // <T>检查内容。</T>
   //============================================================
   public void check(){
      int count = _points.count();
      for(int n = 0; n < count; n++){
         SBoundaryPoint point = _points.get(n);
         int pointCount = calculatePointCount(point);
         if(pointCount > 1){
            if(n == 0){
               continue;
            }
            if(n == count - 1){
               continue;
            }
            throw new FFatalError("Data invalid.");
         }
      }
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void calculate(){
      // 填充数据
      List<PolygonPoint> polygonPoints = new ArrayList<PolygonPoint>();
      int count = _optimizePoints.count();
      for(int i = 0; i < count; i++){
         SBoundaryPoint point = _optimizePoints.get(i);
         PolygonPoint polygonPoint = new FPolygonPoint(i, point.x, point.y, point.z);
         polygonPoints.add(polygonPoint);
      }
      // 转换数据
      Polygon polygon = new Polygon(polygonPoints);
      try{
         Poly2Tri.triangulate(polygon);
      }catch(Exception error){
         valid = false;
         System.out.println(_province.code() + ": " + error.getMessage());
         throw new FFatalError("Point is invalid.");
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
   public void optimize(boolean optimized){
      if(optimized){
         _optimizePoints.clear();
         for(SBoundaryPoint point : _boundary.optimizePoints()){
            _optimizePoints.push(point);
         }
      }else{
         _optimizePoints.clear();
         for(SBoundaryPoint point : _points){
            _optimizePoints.push(point);
         }
      }
      calculate();
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
      for(SBoundaryPoint point : _optimizePoints){
         output.writeFloat((float)point.x);
         output.writeFloat((float)point.y);
      }
      // 输出顶点集合
      int indexCount = _indexes.length();
      output.writeInt32(indexCount);
      for(int i = 0; i < indexCount; i++){
         output.writeUint16(_indexes.get(i));
      }
      // 查找省份定义
      String provinceCode = _province.code();
      FProvinceTemplate provinceTemplate = RResourceExportor.provinceTemplate();
      FProvinceResource provinceResource = provinceTemplate.findByCode(provinceCode);
      System.out.println("Write boundary. (province=" + _province.code() + ":" + provinceResource.label() + ", point= " + RInteger.format(_points.count(), 4, ' ') + " -> " + RInteger.format(pointCount, 4, ' ') + ", index=" + indexCount + ")");
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
