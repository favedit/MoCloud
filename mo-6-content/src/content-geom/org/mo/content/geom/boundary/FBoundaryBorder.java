package org.mo.content.geom.boundary;

import java.util.ArrayList;
import java.util.List;
import org.mo.com.lang.FObjects;

public class FBoundaryBorder
{
   // 点集合
   protected FObjects<SBoundaryPoint> _points = new FObjects<SBoundaryPoint>(SBoundaryPoint.class);

   // 优化后集合
   protected FObjects<SBoundaryPoint> _optimizePoints = new FObjects<SBoundaryPoint>(SBoundaryPoint.class);

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
      List<SBoundaryPoint> pointsReduce = new ArrayList<SBoundaryPoint>();
      for(SBoundaryPoint point : _points){
         pointsReduce.add(point);
      }
      List<SBoundaryPoint> newPoints = DouglasPeucker.DouglasPeuckerReduction(pointsReduce, rate);
      for(SBoundaryPoint point : newPoints){
         _optimizePoints.push(point);
      }
      System.out.println("Optimize " + pointsReduce.size() + " -> " + newPoints.size());
   }
}
