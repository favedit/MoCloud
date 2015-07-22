package org.mo.content.geom.boundary;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.IComparable;

//============================================================
// <T>边界三维双浮点坐标。</T>
//============================================================
public class SBoundaryPoint
      extends SDoublePoint3
      implements
         IComparable<SBoundaryPoint>
{
   // 索引位置
   public int index;

   // 长度
   public double length;

   // 边线集合
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
      return lines.count();
   }

   public void pushLine(SBoundaryLine line){
      if(lines == null){
         lines = new FObjects<SBoundaryLine>(SBoundaryLine.class);
      }
      lines.pushUnique(line);
   }

   //============================================================
   // <T>计算当前点关联线的平均长度。</T>
   //============================================================
   public double calculate(){
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
