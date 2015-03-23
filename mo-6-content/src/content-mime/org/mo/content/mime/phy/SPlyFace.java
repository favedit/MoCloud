package org.mo.content.mime.phy;

import org.mo.com.lang.FString;

//============================================================
// <T>PLY面信息。</T>
//============================================================
public class SPlyFace
{
   // 数据
   public int[] data;

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
            int value = data[n];
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
