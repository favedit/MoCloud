package org.mo.content.geom.mesh;

import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;

//============================================================
// <T>空间网格。</T>
//============================================================
public class FGeomMesh
      extends FObject
{
   // 顶点集合
   protected FObjects<SGeomVertex> _vertexs = new FObjects<SGeomVertex>(SGeomVertex.class);

   // 面集合
   protected FObjects<SGeomFace> _faces = new FObjects<SGeomFace>(SGeomFace.class);

   //============================================================
   // <T>构造空间网格。</T>
   //============================================================
   public FGeomMesh(){
   }

   //============================================================
   // <T>获得顶点集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SGeomVertex> vertexs(){
      return _vertexs;
   }

   //============================================================
   // <T>获得面集合。</T>
   //
   // @return 面集合
   //============================================================
   public FObjects<SGeomFace> faces(){
      return _faces;
   }
}
