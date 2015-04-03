package org.mo.content.mime.obj;

import org.mo.com.lang.FString;

//============================================================
//<T>OBJ顶点信息。</T>
//============================================================
public class SObjTextureCoordinate
{
   public float u;

   public float v;

   //============================================================
   // <T>获得字符串信息。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      FString result = new FString();
      result.append("u:", u, ", ");
      result.append("v:", v, ", ");
      return result.toString();
   }
}
