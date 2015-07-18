package org.mo.content.geom.boundary;

import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;

public class FBoundary
{
   // 点集合
   protected FObjects<SBoundaryPoint> _points = new FObjects<SBoundaryPoint>(SBoundaryPoint.class);

   // 优化后集合
   protected FObjects<SBoundaryPoint> _optimizePoints = new FObjects<SBoundaryPoint>(SBoundaryPoint.class);

   // 边集合
   protected FObjects<FBoundaryBorder> _borders = new FObjects<FBoundaryBorder>(FBoundaryBorder.class);

   public FBoundary(){
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
   public FObjects<FBoundaryBorder> borders(){
      return _borders;
   }

   //============================================================
   // <T>增加一个顶点。</T>
   //
   // @param point 顶点
   //============================================================
   public void pushBorder(FBoundaryBorder border){
      _borders.push(border);
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void optimize(){
      FDictionary<SBoundaryPoint> points = new FDictionary<SBoundaryPoint>(SBoundaryPoint.class);
      for(FBoundaryBorder border : _borders){
         for(SBoundaryPoint point : border.optimizePoints()){
            String code = point.toString();
            if(!points.contains(code)){
               _optimizePoints.push(point);
               points.set(code, point);
            }
         }
      }
      System.out.println("Optimize boundary: " + _points.count() + " -> " + _optimizePoints.count());
   }
}
