package org.mo.content.mime.phy;

import org.mo.com.lang.FString;

//============================================================
// <T>PLY顶点信息。</T>
//============================================================
public class SPlyVertex
{
   // 数据
   public float[] data;

   // 数据
   public float x;

   public float y;

   public float z;

   public int r;

   public int g;

   public int b;

   //============================================================
   // <T>获得字符串信息。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      FString result = new FString();
      if(data != null){
         result.append(data.length + " [ ");
         int count = data.length;
         for(int n = 0; n < count; n++){
            float value = data[n];
            if(n > 0){
               result.append(", ");
            }
            result.append(value);
         }
         result.append(" ]");
      }
      return result.toString();
   }
}
