package org.mo.cloud.logic.resource.bitmap;

import com.cyou.gccloud.data.data.FDataResourceBitmapUnit;

//============================================================
// <T>资源位图信息。</T>
//============================================================
public class FGcResBitmapInfo
      extends FDataResourceBitmapUnit
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
