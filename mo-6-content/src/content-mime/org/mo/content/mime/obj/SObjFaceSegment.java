package org.mo.content.mime.obj;

import org.mo.com.lang.FString;

//============================================================
//<T>OBJ顶点信息。</T>
//============================================================
public class SObjFaceSegment
{
   public int vIdx;

   public int tcIdx;

   public int nIdx;

   //============================================================
   // <T>获得字符串信息。</T>
   //
   // @return 字符串SObjFaceSegment.java
   //============================================================
   @Override
   public String toString(){
      FString result = new FString();
      result.append("VIdx:", vIdx, ", ");
      result.append("TIdx:", tcIdx, ", ");
      result.append("NIdx:", nIdx);
      return result.toString();
   }
}
