package org.mo.cloud.logic.data.resource.template;

import com.cyou.gccloud.data.data.FDataResourceTemplateUnit;

//============================================================
// <T>资源模板。</T>
//============================================================
public class FGcResTemplateInfo
      extends FDataResourceTemplateUnit
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
