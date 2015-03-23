package org.mo.content.mime.phy;

import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;

//============================================================
// <T>PLY网格。</T>
//============================================================
public class FPlyMesh
      extends FObject
{
   // 顶点定义
   protected FObjects<SPlyProperty> _vertexProperties = new FObjects<SPlyProperty>(SPlyProperty.class);

   // 顶点集合
   protected FObjects<SPlyVertex> _vertexs = new FObjects<SPlyVertex>(SPlyVertex.class);

   // 面定义
   protected FObjects<SPlyProperty> _faceProperties = new FObjects<SPlyProperty>(SPlyProperty.class);

   // 面集合
   protected FObjects<SPlyFace> _faces = new FObjects<SPlyFace>(SPlyFace.class);

   //============================================================
   // <T>构造PLY网格。</T>
   //============================================================
   public FPlyMesh(){
   }

   //============================================================
   // <T>获得顶点定义。</T>
   //
   // @return 顶点定义
   //============================================================
   public FObjects<SPlyProperty> _vertexProperties(){
      return _vertexProperties;
   }

   //============================================================
   // <T>获得顶点集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SPlyVertex> vertexs(){
      return _vertexs;
   }

   //============================================================
   // <T>获得面集合。</T>
   //
   // @return 面集合
   //============================================================
   public FObjects<SPlyFace> faces(){
      return _faces;
   }
}
