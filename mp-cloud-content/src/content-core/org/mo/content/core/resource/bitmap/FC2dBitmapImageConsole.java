package org.mo.content.core.resource.bitmap;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapImageConsole;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.image.FImage;

//============================================================
// <T>内容纹理控制台。</T>
//============================================================
public class FC2dBitmapImageConsole
      extends FGcResBitmapImageConsole
      implements
         IC2dBitmapImageConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>生成位图数据。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   @Override
   public byte[] makeViewData(ILogicContext logicContext,
                              String guid){
      // 获得数据
      SGcStorage storage = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, guid);
      return storage.data();
   }

   //============================================================
   // <T>生成位图数据。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   public byte[] makePreview(ILogicContext context,
                             String guid){
      // 获得数据
      SGcStorage storage = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, guid);
      byte[] imageData = storage.data();
      // 生成预览图
      byte[] data = null;
      synchronized(FImage.class){
         try(FImage image = new FImage(imageData)){
            image.resizeScale(200, 150, true);
            data = image.toBytes("jpg");
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }
      // 返回数据
      return data;
   }

   //============================================================
   // <T>生成位图数据。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   @Override
   public byte[] makePreviewData(ILogicContext logicContext,
                                 String guid){
      //............................................................
      // 查找数据
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Cache2dBitmapImagePreview, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      byte[] data = makePreview(logicContext, guid);
      // 存储数据
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Cache2dBitmapImagePreview, guid, "bin");
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }
}
