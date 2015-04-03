package org.mo.content.geom.mesh;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.geom.SFloatPoint2;
import org.mo.com.geom.SFloatVector3;
import org.mo.com.lang.FInts;
import org.mo.com.lang.FObjects;
import org.mo.content.geom.common.SFloatColor4;

//============================================================
// <T>空间顶点。</T>
//============================================================
public class SGeomVertex
{
   // 计算标志
   public boolean calculate;

   // 调整编号
   public int adjuestId;

   // 坐标
   public SDoublePoint3 position;

   // 颜色
   public SFloatColor4 color;

   // 纹理坐标
   public SFloatPoint2 coord;

   // 法线
   public SFloatVector3 normal;

   // 副法线
   public SFloatVector3 binormal;

   // 切线
   public SFloatVector3 tangent;

   // 骨头索引
   public int[] boneIds;

   // 骨头权重
   public float[] weights;

   // 面编号集合
   public FInts faceIds;

   // 面集合
   public FObjects<SGeomFace> faces;

   //============================================================
   // <T>增加一个面索引。</T>
   //
   // @param faceId 面索引
   //============================================================
   public void pushFaceId(int faceId){
      if(faceIds == null){
         faceIds = new FInts();
      }
      faceIds.append(faceId);
   }

   //============================================================
   // <T>增加一个面。</T>
   //
   // @param face 面
   //============================================================
   public void pushFace(SGeomFace face){
      if(faces == null){
         faces = new FObjects<SGeomFace>(SGeomFace.class);
      }
      faces.append(faces);
   }
}
