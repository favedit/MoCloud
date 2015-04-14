package org.mo.content.core.resource.texture;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapConsole;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容图片控制台。</T>
//============================================================
public class FC3dBitmapConsole
      extends FGcResBitmapConsole
      implements
         IC3dBitmapConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>构造内容图片控制台。</T>
   //============================================================
   public FC3dBitmapConsole(){
   }

   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param whereSql 搜索内容
   // @param orderSql 排序内容
   // @param pageSize 页面大小
   // @param page 页面编号
   // @return 处理结果
   //============================================================
   @Override
   public FLogicDataset<FLogicUnit> list(ILogicContext logicContext,
                                         String whereSql,
                                         String orderSql,
                                         int pageSize,
                                         int page){
      FLogicDataset<FGcResBitmapInfo> bitmaps = fetch(logicContext, whereSql, orderSql, pageSize, page);
      // 转换结果
      FLogicDataset<FLogicUnit> dataset = new FLogicDataset<FLogicUnit>(FLogicUnit.class);
      dataset.loadDataset(bitmaps);
      return dataset;
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
      //      // 查找图片单元
      //      FDataResourceBitmapLogic bitmapLogic = context.findLogic(FDataResourceBitmapLogic.class);
      //      FDataResourceBitmapUnit bitmapUnit = bitmapLogic.findByGuid(guid);
      //      if(bitmapUnit == null){
      //         throw new FFatalError("Bitmap is not exists. (guid={1})", guid);
      //      }
      //      // 查找位图单元
      //      String whereSql = FDataResourceBitmapImageLogic.BITMAP_ID + "=" + bitmapUnit.ouid();
      //      FDataResourceBitmapImageLogic imageLogic = context.findLogic(FDataResourceBitmapImageLogic.class);
      //      FDataResourceBitmapImageUnit imageUnit = imageLogic.search(whereSql);
      //      if(imageUnit == null){
      //         throw new FFatalError("Bitmap image is not exists. (guid={1})", guid);
      //      }
      //      // 获得数据
      //      SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, imageUnit.guid());
      //      byte[] imageData = resource.data();
      //      // 生成预览图
      //      byte[] data = null;
      //      synchronized(FC3dBitmapConsole.class){
      //         try(FImage image = new FImage(imageData)){
      //            image.resizeScale(200, 150, true);
      //            data = image.toBytes("jpeg");
      //         }catch(Exception e){
      //            throw new FFatalError(e);
      //         }
      //      }
      //      // 返回数据
      //      return data;
      return null;
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
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Cache3dBitmapPreview, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      byte[] data = makePreview(logicContext, guid);
      // 存储数据
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Cache3dBitmapPreview, guid, "bin");
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }
}
