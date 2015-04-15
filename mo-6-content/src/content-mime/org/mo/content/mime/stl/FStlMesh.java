package org.mo.content.mime.stl;

import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;

public class FStlMesh
      extends FObject
{
   // 面集合
   protected FObjects<SStlFace> _faces = new FObjects<SStlFace>(SStlFace.class);

   //============================================================
   // <T>获得面集合。</T>
   //
   // @return 面集合
   //============================================================
   public FObjects<SStlFace> faces(){
      return _faces;
   }

}
