package org.mo.eai.resource.country;

import org.poly2tri.geometry.polygon.PolygonPoint;

public class FPolygonPoint
      extends PolygonPoint
{
   protected int _index;

   public FPolygonPoint(int index,
                                double x,
                                double y){
      super(x, y);
      _index = index;
   }

   public FPolygonPoint(int index,
                                double x,
                                double y,
                                double z){
      super(x, y, z);
      _index = index;
   }

   public int index(){
      return _index;
   }
}
