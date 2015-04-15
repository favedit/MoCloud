package org.mo.content.mime.stl;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.geom.SFloatVector3;
import org.mo.com.lang.FString;

public class SStlFace
{
   public SFloatVector3 normal;

   public SDoublePoint3[] vertexs = new SDoublePoint3[3];

   //============================================================
   // <T>获得字符串信息。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      FString result = new FString();
      result.append("normal:[ ");
      result.append(normal);
      result.append(" ], ");
      result.append("vertex[0]:[ ");
      result.append(vertexs[0]);
      result.append(" ], ");
      result.append("vertex[1]:[ ");
      result.append(vertexs[1]);
      result.append(" ], ");
      result.append("vertex[2]:[ ");
      result.append(vertexs[2]);
      result.append(" ]");
      return result.toString();
   }
}
