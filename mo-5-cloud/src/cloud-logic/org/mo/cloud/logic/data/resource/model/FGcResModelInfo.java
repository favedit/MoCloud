package org.mo.cloud.logic.data.resource.model;

import com.cyou.gccloud.data.data.FDataResourceModelUnit;

//============================================================
// <T>资源位图信息。</T>
//============================================================
public class FGcResModelInfo
      extends FDataResourceModelUnit
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
