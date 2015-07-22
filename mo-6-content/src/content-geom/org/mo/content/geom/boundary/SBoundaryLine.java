package org.mo.content.geom.boundary;


public class SBoundaryLine
{
   public double length;

   public SBoundaryPoint begin;

   public SBoundaryPoint end;

   //============================================================
   // <T>构造三维双浮点坐标。</T>
   //
   // @param value 内容
   //============================================================
   public SBoundaryLine(){
   }

   //============================================================
   // <T>构造三维双浮点坐标。</T>
   //
   // @param value 内容
   //============================================================
   public SBoundaryLine(SBoundaryPoint value1,
                        SBoundaryPoint value2){
      length = value1.length(value2);
      begin = value1;
      end = value2;
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return begin + "|" + end;
   }
}
