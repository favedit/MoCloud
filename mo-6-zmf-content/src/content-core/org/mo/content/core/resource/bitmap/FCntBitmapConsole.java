package org.mo.content.core.resource.bitmap;

import org.mo.cloud.core.storage.mongo.EGcStorageMongoCatalog;
import org.mo.cloud.core.storage.mongo.SGcMongoStorage;

import org.mo.cloud.logic.data.resource.bitmap.FGcResBitmapInfo;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.content.engine.core.bitmap.FResBitmapConsole;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.image.FImage;

//============================================================
// <T>资源位图控制台。</T>
//============================================================
public class FCntBitmapConsole
      extends FResBitmapConsole
      implements
         ICntBitmapConsole
{
   //============================================================
   // <T>构造资源位图控制台。</T>
   //============================================================
   public FCntBitmapConsole(){
   }

   //============================================================
   // <T>更新位图数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param bitmapInfo 位图信息
   // @param stream 数据流
   // @return 处理结果
   //============================================================
   @Override
   public EResult updateData(ILogicContext logicContext,
                             FGcResBitmapInfo bitmapInfo,
                             FByteStream stream){
      // 检查参数
      if(bitmapInfo == null){
         throw new FFatalError("Bitmap is not exists.");
      }
      if(stream == null){
         throw new FFatalError("Stream is not exists.");
      }
      //............................................................
      // 计算图片尺寸
      int sizeWidth = 0;
      int sizeHeight = 0;
      try(FImage image = new FImage()){
         image.loadData(stream.memory(), 0, stream.length());
         sizeWidth = image.width();
         sizeHeight = image.height();
      }catch(Exception e){
         throw new FFatalError("Calculate image size failure.");
      }
      // 存储信息
      bitmapInfo.setSizeWidth(sizeWidth);
      bitmapInfo.setSizeHeight(sizeHeight);
      doUpdate(logicContext, bitmapInfo);
      //............................................................
      // 存储数据
      String guid = bitmapInfo.guid();
      SGcMongoStorage storage = new SGcMongoStorage(EGcStorageMongoCatalog.ResourceBitmap, guid);
      storage.setData(stream.toArray());
      _storageConsole.store(storage);
      //............................................................
      // 删除缓冲数据
      _storageConsole.delete(EGcStorageMongoCatalog.CacheBitmapPreview, guid);
      return EResult.Success;
   }

   //============================================================
   // <T>根据资源编号删除模型信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param resourceId 资源编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDeleteByResourceId(ILogicContext logicContext,
                                       long userId,
                                       long resourceId){
      // 获得模型
      FGcResBitmapInfo bitmap = findByResourceId(logicContext, resourceId);
      if(bitmap == null){
         throw new FFatalError("Bitmap is not exists. (resource_id={1})", resourceId);
      }
      // 检查用户
      if(bitmap.userId() != userId){
         throw new FFatalError("Bitmap user is not same. (bitmap_user_id={1}, session_user_id={2})", bitmap.userId(), userId);
      }
      // 删除关联资源对象
      doDelete(logicContext, bitmap);
      return EResult.Success;
   }
}
