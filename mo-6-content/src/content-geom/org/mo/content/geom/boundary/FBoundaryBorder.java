package org.mo.content.geom.boundary;

import java.util.ArrayList;
import java.util.List;
import org.mo.com.geom.SDoubleOutline3;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.FString;

//============================================================
// <T>边界边线。</T>
//============================================================
public class FBoundaryBorder
{
   // 优化器
   protected FBoundaryOptimizer _optimizer;

   // 边界
   protected FBoundary _boundary;

   // 轮廓
   protected SDoubleOutline3 _outline = new SDoubleOutline3();

   // 点集合
   protected FObjects<SBoundaryPoint> _points = new FObjects<SBoundaryPoint>(SBoundaryPoint.class);

   // 优化后集合
   protected FObjects<SBoundaryPoint> _optimizePoints = new FObjects<SBoundaryPoint>(SBoundaryPoint.class);

   //============================================================
   // <T>构造边界边线。</T>
   //============================================================
   public FBoundaryBorder(){
      _outline.reset();
   }

   //============================================================
   // <T>获得优化器。</T>
   //
   // @return 优化器
   //============================================================
   public FBoundaryOptimizer optimizer(){
      return _optimizer;
   }

   //============================================================
   // <T>设置优化器。</T>
   //
   // @param optimizer 优化器
   //============================================================
   public void setOptimizer(FBoundaryOptimizer optimizer){
      _optimizer = optimizer;
   }

   //============================================================
   // <T>获得边界。</T>
   //
   // @return 边界
   //============================================================
   public FBoundary boundary(){
      return _boundary;
   }

   //============================================================
   // <T>设置边界。</T>
   //
   // @param boundary 边界
   //============================================================
   public void setBoundary(FBoundary boundary){
      _boundary = boundary;
   }

   //============================================================
   // <T>获得顶点轮廓。</T>
   //
   // @return 顶点轮廓
   //============================================================
   public SDoubleOutline3 outline(){
      return _outline;
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
   // <T>增加一个顶点。</T>
   //
   // @param point 顶点
   //============================================================
   public void pushPoint(SBoundaryPoint point){
      _outline.merge(point);
      _points.push(point);
   }

   //============================================================
   // <T>获得顶点集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SBoundaryPoint> optimizePoints(){
      return _optimizePoints;
   }

   //============================================================
   // <T>获得顶点集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public boolean equals(FBoundaryBorder border){
      FObjects<SBoundaryPoint> borderPoints = border.points();
      int count = borderPoints.count();
      if(_points.count() != count){
         return false;
      }
      boolean aorder = true;
      for(int n = 0; n < count; n++){
         if(!_points.get(n).equals(borderPoints.get(n))){
            aorder = false;
            break;
         }
      }
      boolean dorder = true;
      for(int n = 0; n < count; n++){
         if(!_points.get(n).equals(borderPoints.get(count - n - 1))){
            dorder = false;
            break;
         }
      }
      return aorder || dorder;
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void optimize(double rate){
      //      // 计算所有点关联线的平均长度
      //      SBoundaryPoint[] points = _points.toObjects();
      //      Arrays.sort(points, 0, points.length, new SBoundaryPointComparator());
      //      // 优化掉百分比点
      //      int count = points.length;
      //      if(count > 16){
      //         int start = (int)(count * rate);
      //         double length = points[start].length;
      //         for(int i = 0; i < count; i++){
      //            SBoundaryPoint point = _points.get(i);
      //            if((i == 0) || (i == count - 1)){
      //               _optimizePoints.push(point);
      //            }else if(point.length > length){
      //               _optimizePoints.push(point);
      //            }
      //         }
      //      }else{
      //         _optimizePoints.assign(_points);
      //      }
      //if(_points.count() > 16){
      // 获得所有边线
      FObjects<FBoundaryBorder> borders = new FObjects<FBoundaryBorder>(FBoundaryBorder.class);
      for(FBoundaryBorder border : _optimizer.borders()){
         if(_outline.testRectangle(border.outline())){
            if(!border.equals(this)){
               borders.push(border);
            }
         }
      }
      //      List<SBoundaryPoint> boundaryPoints = new ArrayList<SBoundaryPoint>();
      //      int boundaryCount = _boundary.borders().count();
      //      int index = _boundary.borders().indexOf(this);
      //      for(int n = index + 1; n < boundaryCount; n++){
      //         FBoundaryBorder border = _boundary.borders().get(n);
      //         for(SBoundaryPoint point : border.points()){
      //            if(!boundaryPoints.contains(point)){
      //               boundaryPoints.add(point);
      //            }
      //         }
      //      }
      //      for(int n = 0; n < index; n++){
      //         FBoundaryBorder border = _boundary.borders().get(n);
      //         for(SBoundaryPoint point : border.points()){
      //            if(!boundaryPoints.contains(point)){
      //               boundaryPoints.add(point);
      //            }
      //         }
      //      }
      List<SBoundaryPoint> pointsReduce = new ArrayList<SBoundaryPoint>();
      for(SBoundaryPoint point : _points){
         pointsReduce.add(point);
      }
      List<SBoundaryPoint> newPoints = FDouglasPeucker.DouglasPeuckerReduction(borders, pointsReduce, rate);
      for(SBoundaryPoint point : newPoints){
         _optimizePoints.push(point);
      }
      //      }else{
      //         _optimizePoints.assign(_points);
      //      }
      System.out.println("Optimize border: " + _points.count() + " -> " + _optimizePoints.count());
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      FString result = new FString();
      int count = _points.count();
      for(int n = 0; n < count; n++){
         if(n > 0){
            result.append(";");
         }
         SBoundaryPoint point = _points.get(n);
         result.append(point.toString());
      }
      return result.toString();
   }
}
