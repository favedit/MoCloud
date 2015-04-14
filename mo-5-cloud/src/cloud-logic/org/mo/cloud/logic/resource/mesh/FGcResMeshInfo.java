package org.mo.cloud.logic.resource.mesh;

import com.cyou.gccloud.data.data.FDataResourceModelMeshUnit;

//============================================================
// <T>3D资源网格。</T>
//============================================================
public class FGcResMeshInfo
      extends FDataResourceModelMeshUnit
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
