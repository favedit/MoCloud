package org.mo.content.core.resource.bitmap;

import com.cyou.gccloud.data.data.FDataResourceBitmapImageLogic;
import com.cyou.gccloud.data.data.FDataResourceBitmapImageUnit;
import com.cyou.gccloud.data.data.FDataResourceBitmapLogic;
import com.cyou.gccloud.data.data.FDataResourceBitmapUnit;
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
import org.mo.eng.image.FImage;

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
   // <T>生成位图数据。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   public byte[] makePreview(ILogicContext context,
                             String guid){
      // 查找图片单元
      FDataResourceBitmapLogic bitmapLogic = context.findLogic(FDataResourceBitmapLogic.class);
      FDataResourceBitmapUnit bitmapUnit = bitmapLogic.findByGuid(guid);
      if(bitmapUnit == null){
         throw new FFatalError("Bitmap is not exists. (guid={1})", guid);
      }
      // 查找位图单元
      String whereSql = FDataResourceBitmapImageLogic.BITMAP_ID + "=" + bitmapUnit.ouid();
      FDataResourceBitmapImageLogic imageLogic = context.findLogic(FDataResourceBitmapImageLogic.class);
      FDataResourceBitmapImageUnit imageUnit = imageLogic.search(whereSql);
      if(imageUnit == null){
         throw new FFatalError("Bitmap image is not exists. (guid={1})", guid);
      }
      // 获得数据
      SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, imageUnit.guid());
      byte[] imageData = resource.data();
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
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Cache2dBitmapPreview, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      byte[] data = makePreview(logicContext, guid);
      // 存储数据
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Cache2dBitmapPreview, guid, "bin");
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }

   //============================================================
   // <T>导入位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param bitmapImage 位图图片
   // @param stream 数据流
   // @return 处理结果
   //============================================================
   @Override
   public EResult importBitmap(ILogicContext logicContext,
                               FGcResBitmapImageInfo bitmapImage,
                               FByteStream stream){
      // 检查参数
      if(bitmapImage == null){
         throw new FFatalError("Bitmap is not exists.");
      }
      if(stream == null){
         throw new FFatalError("Stream is not exists.");
      }
      //............................................................
      // 存储数据
      String imageGuid = bitmapImage.guid();
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.ResourceBitmapImage, imageGuid, "jpg");
      storage.setData(stream.toArray());
      _storageConsole.store(storage);
      return EResult.Success;
   }
}
