package org.mo.cloud.logic.data.resource.bitmap;

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

   //============================================================
   // <T>测试尺寸是否有效。</T>
   //
   // @return 是否有效
   //============================================================
   public boolean testSizeValid(){
      if(_sizeWidth == 0){
         return false;
      }
      if(_sizeHeight == 0){
         return false;
      }
      return true;
   }

   //============================================================
   // <T>设置尺寸。</T>
   //
   // @param width 宽度
   // @param height 高度
   //============================================================
   public void setSize(int width,
                       int height){
      _sizeWidth = width;
      _sizeHeight = height;
   }
}
