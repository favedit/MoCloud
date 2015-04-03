package org.mo.content.geom.mesh;

//============================================================
// <T>集合体面。</T>
//============================================================
public class SGeomFace
{
   // 位置索引
   public int[] vertexIndexs;

   // 纹理索引
   public int[] coordIndexs;

   // 法线索引
   public int[] normalIndexs;

   // 副法线索引
   public int[] binormalIndexs;

   // 切线索引
   public int[] tangentIndexs;

   //============================================================
   // <T>设置数据。</T>
   //============================================================
   public void set(int[] indexs){
      int count = indexs.length;
      vertexIndexs = new int[count];
      for(int n = 0; n < count; n++){
         vertexIndexs[n] = indexs[n];
      }
   }
}
