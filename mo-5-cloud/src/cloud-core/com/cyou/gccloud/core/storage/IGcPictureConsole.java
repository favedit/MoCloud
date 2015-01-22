package com.cyou.gccloud.core.storage;

//============================================================
// <T>图片控制台。</T>
//============================================================
public interface IGcPictureConsole
{
   //============================================================
   // <T>建立图标。</T>
   //
   // @param typeName 类型名称
   // @param fileName 文件名称
   // @param storageImages 位图集合
   //============================================================
   void buildImages(String typeName,
                    String fileName,
                    SGcStorageImages storageImages);
}
