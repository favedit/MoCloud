package org.mo.cloud.logic.data.resource.material;

import com.cyou.gccloud.data.data.FDataResourceMaterialUnit;

//============================================================
// <T>资源材质信息。</T>
//============================================================
public class FGcResMaterialInfo
      extends FDataResourceMaterialUnit
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
