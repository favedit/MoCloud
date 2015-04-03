package org.mo.content.mime.obj;

import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;

//============================================================
//<T>OBJ网格。</T>
//============================================================
public class FObjMesh
      extends FObject
{

   // 顶点集合
   protected FObjects<SObjVertex> _vertexs = new FObjects<SObjVertex>(SObjVertex.class);

   // 法线集合
   protected FObjects<SObjNormal> _normals = new FObjects<SObjNormal>(SObjNormal.class);

   // 面集合
   protected FObjects<SObjFace> _faces = new FObjects<SObjFace>(SObjFace.class);

   //============================================================
   // <T>构造PLY网格。</T>
   //============================================================
   public FObjMesh(){
   }

   //============================================================
   // <T>获得顶点集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SObjVertex> vertexs(){
      return _vertexs;
   }

   //============================================================
   // <T>获得法线集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SObjNormal> normals(){
      return _normals;
   }

   //============================================================
   // <T>获得面集合。</T>
   //
   // @return 面集合
   //============================================================
   public FObjects<SObjFace> faces(){
      return _faces;
   }
}
