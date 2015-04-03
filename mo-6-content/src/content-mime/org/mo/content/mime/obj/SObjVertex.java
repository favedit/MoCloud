package org.mo.content.mime.obj;

import org.mo.com.lang.FString;

//============================================================
//<T>OBJ顶点信息。</T>
//============================================================
public class SObjVertex
{
   public float x;

   public float y;

   public float z;

   //============================================================
   // <T>获得字符串信息。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      FString result = new FString();
      result.append("x:", x, ", ");
      result.append("y:", y, ", ");
      result.append("z:", z);
      return result.toString();
   }
}
