package org.mo.content.geom.boundary;

import org.mo.com.lang.FObjects;

//============================================================
// <T>边界。</T>
//============================================================
public class FBoundary
{
   // 优化器
   protected FBoundaryOptimizer _optimizer;

   // 点集合
   protected FObjects<SBoundaryPoint> _points = new FObjects<SBoundaryPoint>(SBoundaryPoint.class);

   // 优化后集合
   protected FObjects<SBoundaryPoint> _optimizePoints = new FObjects<SBoundaryPoint>(SBoundaryPoint.class);

   // 边集合
   protected FObjects<FBoundaryBorder> _borders = new FObjects<FBoundaryBorder>(FBoundaryBorder.class);

   //============================================================
   // <T>构造边界。</T>
   //============================================================
   public FBoundary(){
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
      //_points.push(point);
      if(!_points.contains(point)){
         _points.push(point);
      }
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
   public FObjects<FBoundaryBorder> borders(){
      return _borders;
   }

   //============================================================
   // <T>增加一个顶点。</T>
   //
   // @param point 顶点
   //============================================================
   public void pushBorder(FBoundaryBorder border){
      border.setOptimizer(_optimizer);
      border.setBoundary(this);
      _borders.push(border);
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void optimize(){
      int count = _borders.count();
      for(int n = 0; n < count; n++){
         FBoundaryBorder border = _borders.get(n);
         int pointCount = border.optimizePoints().count();
         for(int i = 0; i < pointCount; i++){
            SBoundaryPoint point = border.optimizePoints().get(i);
            if(n == 0){
               _optimizePoints.push(point);
            }else{
               if(i != 0){
                  _optimizePoints.push(point);
               }
            }
         }
      }
      System.out.println("Optimize boundary: " + _points.count() + " -> " + _optimizePoints.count());
   }
}
