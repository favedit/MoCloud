package org.mo.content.mime.obj;

import org.mo.com.lang.FObjects;
import org.mo.com.lang.FString;

//============================================================
//<T>OBJ顶点信息。</T>
//============================================================
public class SObjFace
{

   protected FObjects<SObjFaceSegment> _segments = new FObjects<SObjFaceSegment>(SObjFaceSegment.class);

   //============================================================
   // <T>获得字符串信息。</T>
   //
   // @return 字符串SObjVertex.java
   //============================================================
   @Override
   public String toString(){
      FString result = new FString();
      result.append("ObjFace:");
      for(SObjFaceSegment segment : _segments){
         result.append("[ ");
         result.append(segment.toString());
         result.append(" ]");
      }
      return result.toString();
   }
}
