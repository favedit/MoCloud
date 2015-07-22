package org.mo.com.geom;

//============================================================
// <T>三维双浮点轮廓。</T>
//============================================================
public class SDoubleOutline3
{
   // 最小顶点
   public SDoublePoint3 min = new SDoublePoint3();

   // 最大顶点
   public SDoublePoint3 max = new SDoublePoint3();

   //============================================================
   // <T>构造三维双浮点轮廓。</T>
   //============================================================
   public SDoubleOutline3(){
   }

   //============================================================
   // <T>测试矩形是否相交。</T>
   //============================================================
   public boolean testRectangle(SDoubleOutline3 value){
      double left = min.x;
      double top = min.y;
      double width = max.x - min.x;
      double height = max.y - min.y;
      double valueLeft = value.min.x;
      double valueTop = value.min.y;
      double valueWidth = value.max.x - value.min.x;
      double valueHeight = value.max.y - value.min.y;
      return (left < valueLeft + valueWidth && left + width > valueLeft && top < valueTop + valueHeight && top + height > valueTop);
   }

   //============================================================
   // <T>重置处理。</T>
   //============================================================
   public void reset(){
      min.max();
      max.min();
   }

   //============================================================
   // <T>合并处理。</T>
   //============================================================
   public void merge(SDoublePoint3 point){
      min.min(point);
      max.max(point);
   }

   //============================================================
   // <T>获得内容字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return min + "-" + max;
   }
}
