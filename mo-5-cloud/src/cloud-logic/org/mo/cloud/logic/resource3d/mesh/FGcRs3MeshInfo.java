package org.mo.cloud.logic.resource3d.mesh;

import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;

//============================================================
// <T>3D资源网格。</T>
//============================================================
public class FGcRs3MeshInfo
      extends FDataResource3dMeshUnit
{
   // 目录编号
   private long _catalogId;

   //============================================================
   // <T>获得目录编号。</T>
   //
   // @return 目录编号
   //============================================================
   public long catalogId(){
      return _catalogId;
   }

   //============================================================
   // <T>设置目录编号。</T>
   //
   // @param catalogId 目录编号
   //============================================================
   public void setCatalogId(long catalogId){
      _catalogId = catalogId;
   }
}
