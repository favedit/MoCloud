package com.cyou.gccloud.core.storage;

import org.mo.com.lang.FObjects;
import org.mo.com.lang.FString;
import org.mo.com.lang.FStrings;
import org.mo.com.lang.RString;

//============================================================
// <T>存储图片集合。</T>
//============================================================
public class SGcStorageImages
      extends FObjects<SGcStorageImage>
{
   //============================================================
   // <T>构造存储图片集合。</T>
   //============================================================
   public SGcStorageImages(){
      super(SGcStorageImage.class);
   }

   //============================================================
   // <T>获得打包字符串。</T>
   //
   // @return 打包字符串
   //============================================================
   public SGcStorageImage search(int deviceCd,
                                 int qualityCd,
                                 int displayCd){
      //      for(int n = 0; n < _count; n++){
      //         SGcStorageImage image = _items[n];
      //         int imageDeviceCd = image.deviceCd();
      //         if((imageDeviceCd == deviceCd) || (imageDeviceCd == EGcStorageDevice.All)){
      //            int imageQualityCd = image.qualityCd();
      //            if((imageQualityCd == qualityCd) || (imageQualityCd == EGcStorageQuality.All)){
      //               int imageDisplayCd = image.displayCd();
      //               if((imageDisplayCd == displayCd) || (imageDisplayCd == EGcStorageDisplay.All)){
      //                  return image;
      //               }
      //            }
      //         }
      //      }
      return null;
   }

   //============================================================
   // <T>获得打包字符串。</T>
   //
   // @return 打包字符串
   //============================================================
   public String pack(){
      FStrings result = new FStrings();
      for(SGcStorageImage image : this){
         result.push(image.pack());
      }
      return result.pack();
   }

   //============================================================
   // <T>解析打包字符串。</T>
   //
   // @param pack 打包字符串
   //============================================================
   public void unpack(String pack){
      clear();
      if(!RString.isEmpty(pack)){
         FStrings items = new FStrings();
         items.unpack(pack);
         for(String item : items){
            SGcStorageImage image = new SGcStorageImage();
            image.unpack(item);
            push(image);
         }
      }
   }

   //============================================================
   // <T>获得运行信息。</T>
   //
   // @return 运行信息
   //============================================================
   @Override
   public String dump(){
      FString dump = new FString();
      dump.appendLine("Count:" + _count);
      for(int n = 0; n < _count; n++){
         SGcStorageImage image = _items[n];
         dump.appendLine(image.dump());
      }
      return dump.toString();
   }
}
