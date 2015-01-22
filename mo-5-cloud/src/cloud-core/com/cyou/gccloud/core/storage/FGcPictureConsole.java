package com.cyou.gccloud.core.storage;

import org.mo.com.console.FConsole;
import org.mo.com.io.RFile;
import org.mo.eng.image.FImage;

//============================================================
//<T>控制台。</T>
//============================================================
public class FGcPictureConsole
      extends FConsole
      implements
         IGcPictureConsole
{
   //============================================================
   // <T>建立图标。</T>
   //
   // @param typeName 类型名称
   // @param fileName 文件名称
   // @param storageImages 位图集合
   //============================================================
   @Override
   public void buildImages(String typeName,
                           String fileName,
                           SGcStorageImages storageImages){
      // 检查文件
      if(!RFile.exists(fileName)){
         return;
      }
      // 获得文件名称
      String filePath = RFile.extensionPath(fileName);
      if(storageImages != null){
         for(SGcStorageImage storageImage : storageImages){
            int width = storageImage.width();
            int height = storageImage.height();
            int round = storageImage.round();
            // 改变大小
            FImage image = new FImage(fileName);
            image.resizeScale(width, height, true);
            if(round > 0){
               image.round(round);
            }
            image.saveFile(filePath + "_" + width + "x" + height + "_" + round + ".png");
         }
      }
   }
}
