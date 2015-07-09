package org.mo.eai.resource.country;

import org.poly2tri.geometry.polygon.PolygonPoint;

//============================================================
// <T>多边形点。</T>
//============================================================
public class FPolygonPoint
      extends PolygonPoint
{
   // 索引
   protected int _index;

   //============================================================
   // <T>多边形点。</T>
   //
   // @param index 索引
   // @param x 横坐标
   // @param y 横坐标
   //============================================================
   public FPolygonPoint(int index,
                        double x,
                        double y){
      super(x, y);
      _index = index;
   }

   //============================================================
   // <T>构造多边形点。</T>
   //
   // @param index 索引
   // @param x 横坐标
   // @param y 横坐标
   // @param z 横坐标
   //============================================================
   public FPolygonPoint(int index,
                        double x,
                        double y,
                        double z){
      super(x, y, z);
      _index = index;
   }

   //============================================================
   // <T>获得索引。</T>
   //============================================================
   public int index(){
      return _index;
   }
}
