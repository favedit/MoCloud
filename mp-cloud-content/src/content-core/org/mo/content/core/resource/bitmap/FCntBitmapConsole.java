package org.mo.content.core.resource.bitmap;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.content.engine.core.bitmap.FResBitmapConsole;
import org.mo.data.logic.ILogicContext;

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
      String guid = bitmapInfo.guid();
      //............................................................
      // 存储数据
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.ResourceBitmap, guid);
      storage.setData(stream.toArray());
      _storageConsole.store(storage);
      //............................................................
      // 删除缓冲数据
      _storageConsole.delete(EGcStorageCatalog.CacheBitmapPreview, guid);
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
