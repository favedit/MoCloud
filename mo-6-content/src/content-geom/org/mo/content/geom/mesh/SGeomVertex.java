package org.mo.content.geom.mesh;

import org.mo.content.geom.common.SDoublePoint3;
import org.mo.content.geom.common.SFloatColor4;

//============================================================
// <T>空间顶点。</T>
//============================================================
public class SGeomVertex
{
   // 调整编号
   public int adjuestId;

   // 坐标
   public SDoublePoint3 position;

   // 颜色
   public SFloatColor4 color;

   // 法线
   public SFloatColor4 normal;

   // 副法线
   public SFloatColor4 binormal;

   // 切线
   public SFloatColor4 tangent;

   // 骨头索引
   public int[] boneIds;

   // 骨头权重
   public float[] weights;
}
