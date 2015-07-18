package org.mo.content.geom.boundary;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.IComparable;

public class SBoundaryPoint
      extends SDoublePoint3
      implements
         IComparable<SBoundaryPoint>
{
   public boolean valid = true;

   public int index;

   public double length;

   public FObjects<SBoundaryLine> lines;

   //============================================================
   // <T>构造三维双浮点坐标。</T>
   //
   // @param value 内容
   //============================================================
   public SBoundaryPoint(){
   }

   //============================================================
   // <T>构造三维双浮点坐标。</T>
   //
   // @param value 内容
   //============================================================
   public SBoundaryPoint(SDoublePoint3 value){
      super(value);
   }

   //============================================================
   // <T>构造三维双浮点坐标。</T>
   //
   // @param value 内容
   //============================================================
   public SBoundaryPoint(double x,
                         double y){
      this.x = x;
      this.y = y;
   }

   //============================================================
   // <T>构造三维双浮点坐标。</T>
   //
   // @param x X坐标
   // @param y Y坐标
   // @param z Z坐标
   //============================================================
   public SBoundaryPoint(double x,
                         double y,
                         double z){
      super(x, y, z);
   }

   public int lineCount(){
      return (lines != null) ? lines.count() : 0;
   }

   public void pushLine(SBoundaryLine line){
      if(lines == null){
         lines = new FObjects<SBoundaryLine>(SBoundaryLine.class);
      }
      if(!lines.contains(line)){
         lines.push(line);
      }
   }

   public double calculateLength(){
      double total = 0;
      for(SBoundaryLine line : lines){
         total += line.length;
      }
      length = total / lines.count();
      return length;
   }

   @Override
   public int compare(SBoundaryPoint item,
                      Object... params){
      if(length > item.length){
         return 1;
      }else if(length < item.length){
         return -1;
      }else{
         return 0;
      }
   }

   @Override
   public boolean equals(Object value){
      return equals((SBoundaryPoint)value);
   }
}
