package org.mo.content.geom.boundary;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;

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

   //============================================================
   // <T>构造边界数据优化器。</T>
   //============================================================
   public FBoundaryOptimizer(){
   }

   //============================================================
   // <T>构造边界数据优化器。</T>
   //
   // @param rate 优化比率
   //============================================================
   public FBoundaryOptimizer(double rate){
      _rate = rate;
   }

   //============================================================
   // <T>获得优化比率。</T>
   //
   // @return 优化比率
   //============================================================
   public double rate(){
      return _rate;
   }

   //============================================================
   // <T>设置优化比率。</T>
   //
   // @param rate 优化比率
   //============================================================
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
   // <T>根据点获得要给数据线。</T>
   //
   // @param point1 点1
   // @param point2 点2
   // @return 数据线
   //============================================================
   public SBoundaryLine syncLine(SBoundaryPoint point1,
                                 SBoundaryPoint point2){
      String code = point1 + "|" + point2;
      SBoundaryLine line = _lines.find(code);
      if(line == null){
         code = point2 + "|" + point1;
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
      boundary.setOptimizer(this);
      _boundaries.push(boundary);
   }

   //============================================================
   // <T>获得边界边线集合。</T>
   //
   // @return 边线集合
   //============================================================
   public FObjects<FBoundaryBorder> borders(){
      return _borders;
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
            SBoundaryPoint point1 = points.get(i);
            SBoundaryPoint point2 = null;
            if(i == count - 1){
               point2 = points.get(0);
            }else{
               point2 = points.get(i + 1);
            }
            // 生成线段
            SBoundaryLine line = syncLine(point1, point2);
            point1.pushLine(line);
            point2.pushLine(line);
         }
      }
      // 计算点平均长度
      //      for(INamePair<SBoundaryPoint> pair : _points){
      //         pair.value().calculate();
      //      }
      // 分解边线
      for(FBoundary boundary : _boundaries){
         FBoundaryBorder border = null;
         FObjects<SBoundaryPoint> points = boundary.points();
         for(SBoundaryPoint point : points){
            int lineCount = point.lines.count();
            //boundary.optimizePoints().push(point);
            if(lineCount > 2){
               // 新起点
               if(border != null){
                  border.pushPoint(point);
               }
               border = new FBoundaryBorder();
               border.pushPoint(point);
               boundary.pushBorder(border);
               _borders.push(border);
            }else if(lineCount == 2){
               if(border == null){
                  border = new FBoundaryBorder();
                  boundary.pushBorder(border);
                  _borders.push(border);
               }
               //               if(border.points().count() > 64){
               //                  border = new FBoundaryBorder();
               //                  boundary.pushBorder(border);
               //                  _borders.push(border);
               //               }
               border.pushPoint(point);
            }else{
               throw new FFatalError("Invlaid point.");
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
