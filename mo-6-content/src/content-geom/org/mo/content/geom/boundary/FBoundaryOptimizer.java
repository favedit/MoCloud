package org.mo.content.geom.boundary;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;

//============================================================
// <T>边界数据优化器。</T>
//============================================================
public class FBoundaryOptimizer
{
   private double _rate = 1.0;

   // 点集合
   protected FDictionary<SBoundaryPoint> _points = new FDictionary<SBoundaryPoint>(SBoundaryPoint.class);

   // 线段集合
   protected FDictionary<SBoundaryLine> _lines = new FDictionary<SBoundaryLine>(SBoundaryLine.class);

   // 边集合
   protected FObjects<FBoundaryBorder> _borders = new FObjects<FBoundaryBorder>(FBoundaryBorder.class);

   // 边界集合
   protected FObjects<FBoundary> _boundaries = new FObjects<FBoundary>(FBoundary.class);

   public FBoundaryOptimizer(){
   }

   public FBoundaryOptimizer(double rate){
      _rate = rate;
   }

   public double rate(){
      return _rate;
   }

   public void setRate(double rate){
      _rate = rate;
   }

   //============================================================
   // <T>根据点获得要给数据点。</T>
   //
   // @param value 点
   // @return 数据点
   //============================================================
   public SBoundaryPoint syncPoint(SDoublePoint3 value){
      String code = value.toString();
      SBoundaryPoint point = _points.find(code);
      if(point == null){
         point = new SBoundaryPoint(value);
         _points.set(code, point);
      }
      return point;
   }

   //============================================================
   // <T>根据点获得要给数据点。</T>
   //
   // @param value 点
   // @return 数据点
   //============================================================
   public SBoundaryLine syncLine(SBoundaryPoint point1,
                                 SBoundaryPoint point2){
      String code = point1.toString() + "|" + point2.toString();
      SBoundaryLine line = _lines.find(code);
      if(line == null){
         code = point2.toString() + "|" + point1.toString();
         line = _lines.find(code);
      }
      if(line == null){
         line = new SBoundaryLine(point1, point2);
         _lines.set(code, line);
      }
      return line;
   }

   //============================================================
   // <T>获得边界集合。</T>
   //
   // @return 边界集合
   //============================================================
   public FObjects<FBoundary> boundaries(){
      return _boundaries;
   }

   //============================================================
   // <T>增加一个边界。</T>
   //
   // @param boundary 边界
   //============================================================
   public void pushBoundary(FBoundary boundary){
      _boundaries.push(boundary);
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void calculate(){
      // 计算所有点在边界上的线段
      for(FBoundary boundary : _boundaries){
         FObjects<SBoundaryPoint> points = boundary.points();
         int count = points.count();
         for(int i = 0; i < count; i++){
            // 获得端点
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
            // 生成线段
            SBoundaryLine line = syncLine(point1, point2);
            point1.pushLine(line);
            point2.pushLine(line);
         }
      }
      // 计算点平均长度
      for(INamePair<SBoundaryPoint> pair : _points){
         pair.value().calculateLength();
      }
      // 分解边线
      for(FBoundary boundary : _boundaries){
         FBoundaryBorder border = null;
         FObjects<SBoundaryPoint> points = boundary.points();
         for(SBoundaryPoint point : points){
            if(point.lineCount() > 2){
               if(border != null){
                  border.pushPoint(point);
               }
               border = new FBoundaryBorder();
               border.pushPoint(point);
               boundary.pushBorder(border);
               _borders.push(border);
            }else{
               if(border == null){
                  border = new FBoundaryBorder();
                  boundary.pushBorder(border);
                  _borders.push(border);
               }
               border.pushPoint(point);
            }
         }
      }
      // 优化边线
      for(FBoundaryBorder border : _borders){
         border.optimize(_rate);
      }
      // 优化边界
      for(FBoundary boundary : _boundaries){
         boundary.optimize();
      }
   }
}
