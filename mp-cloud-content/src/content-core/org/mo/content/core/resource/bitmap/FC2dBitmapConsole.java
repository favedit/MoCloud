package org.mo.content.core.resource.bitmap;

import com.cyou.gccloud.define.enums.core.EGcResource;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapConsole;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapImageInfo;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容图片控制台。</T>
//============================================================
public class FC2dBitmapConsole
      extends FGcResBitmapConsole
      implements
         IC2dBitmapConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 位图图像管理器
   @ALink
   protected IC2dBitmapImageConsole _bitmapImageConsole;

   //============================================================
   // <T>构造内容图片控制台。</T>
   //============================================================
   public FC2dBitmapConsole(){
   }

   //============================================================
   // <T>创建位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param bitmap 位图
   // @return 位图信息
   //============================================================
   @Override
   public FGcResBitmapInfo createBitmap(ILogicContext logicContext,
                                        FGcResBitmapInfo bitmap){
      // 创建资源对象
      FGcResourceInfo resource = _resourceConsole.doPrepare(logicContext);
      resource.setUserId(bitmap.userId());
      resource.setProjectId(bitmap.projectId());
      resource.setCatalogId(bitmap.catalogId());
      resource.setResourceCd(EGcResource.Bitmap);
      resource.setCode(bitmap.code());
      resource.setLabel(bitmap.label());
      _resourceConsole.doInsert(logicContext, resource);
      // 创建网格对象
      bitmap.setResourceId(resource.ouid());
      doInsert(logicContext, bitmap);
      return bitmap;
   }

   //============================================================
   // <T>导入位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @param stream 数据流
   // @return 处理结果
   //============================================================
   @Override
   public EResult importBitmap(ILogicContext logicContext,
                               String guid,
                               FByteStream stream){
      // 查找位图
      FGcResBitmapInfo bitmap = findByGuid(logicContext, guid);
      if(bitmap == null){
         throw new FFatalError("Bitmap is not exists.");
      }
      //............................................................
      // 新建图像
      FGcResBitmapImageInfo bitmapImage = _bitmapImageConsole.doPrepare(logicContext);
      bitmapImage.setBitmapId(bitmap.ouid());
      _bitmapImageConsole.doInsert(logicContext, bitmapImage);
      //............................................................
      // 存储数据
      String imageGuid = bitmapImage.guid();
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.ResourceBitmapImage, imageGuid, "jpg");
      storage.setData(stream.toArray());
      _storageConsole.store(storage);
      return EResult.Success;
   }
}
