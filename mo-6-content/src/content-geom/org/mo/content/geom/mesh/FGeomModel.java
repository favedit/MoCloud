package org.mo.content.geom.mesh;

import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;

//============================================================
// <T>空间模型。</T>
//============================================================
public class FGeomModel
      extends FObject
{
   // 网格集合
   protected FObjects<FGeomMesh> _meshs = new FObjects<FGeomMesh>(FGeomMesh.class);

   //============================================================
   // <T>构造空间模型。</T>
   //============================================================
   public FGeomModel(){
   }

   //============================================================
   // <T>获得网格集合。</T>
   //
   // @return 网格集合
   //============================================================
   public FObjects<FGeomMesh> meshs(){
      return _meshs;
   }
}
