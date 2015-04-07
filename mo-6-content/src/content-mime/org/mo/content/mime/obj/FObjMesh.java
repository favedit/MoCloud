package org.mo.content.mime.obj;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.geom.SFloatPoint2;
import org.mo.com.geom.SFloatVector3;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.content.geom.mesh.SGeomFace;

//============================================================
//<T>OBJ网格。</T>
//============================================================
public class FObjMesh
      extends FObject
{

   // 顶点集合
   protected FObjects<SDoublePoint3> _vertexs = new FObjects<SDoublePoint3>(SDoublePoint3.class);

   // 顶点纹理集合
   protected FObjects<SFloatPoint2> _textureCoords = new FObjects<SFloatPoint2>(SFloatPoint2.class);

   // 法线集合
   protected FObjects<SFloatVector3> _normals = new FObjects<SFloatVector3>(SFloatVector3.class);

   // 面集合
   protected FObjects<SGeomFace> _faces = new FObjects<SGeomFace>(SGeomFace.class);

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
   public FObjects<SDoublePoint3> vertexs(){
      return _vertexs;
   }

   //============================================================
   // <T>获得uv集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SFloatPoint2> textureCoords(){
      return _textureCoords;
   }

   //============================================================
   // <T>获得法线集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SFloatVector3> normals(){
      return _normals;
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
