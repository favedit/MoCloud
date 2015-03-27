package org.mo.content.core.resource3d.texture;

import com.cyou.gccloud.data.data.FDataResourceBitmapImageLogic;
import com.cyou.gccloud.data.data.FDataResourceBitmapImageUnit;
import com.cyou.gccloud.data.data.FDataResourceBitmapLogic;
import com.cyou.gccloud.data.data.FDataResourceBitmapUnit;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.console.FConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.image.FImage;

//============================================================
// <T>内容图片控制台。</T>
//============================================================
public class FC3dBitmapConsole
      extends FConsole
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
   // @param context 逻辑环境
   // @param xoutput 输出内容
   // @param serach 搜索内容
   // @param pageSize 页面大小
   // @param page 页面编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult fetch(ILogicContext context,
                        FXmlNode xoutput,
                        String serach,
                        int pageSize,
                        int page){
      // 生成查询脚本
      String whereSql = null;
      if(!RString.isEmpty(serach)){
         whereSql = FDataResourceBitmapLogic.FULL_CODE + " LIKE '%" + serach + "%'";
      }
      // 查询数据
      FDataResourceBitmapLogic logic = context.findLogic(FDataResourceBitmapLogic.class);
      FLogicDataset<FDataResourceBitmapUnit> dataset = logic.fetch(whereSql, pageSize, page);
      xoutput.set("total", dataset.total());
      xoutput.set("count", dataset.count());
      xoutput.set("page_size", dataset.pageSize());
      xoutput.set("page_count", dataset.pageCount());
      xoutput.set("page", dataset.page());
      for(FDataResourceBitmapUnit unit : dataset){
         FXmlNode xitem = xoutput.createNode("Item");
         xitem.set("guid", unit.guid());
         xitem.set("type", "picture");
         xitem.set("code", unit.fullCode());
         xitem.set("label", unit.label());
      }
      return EResult.Success;
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
      synchronized(FC3dBitmapConsole.class){
         try(FImage image = new FImage(imageData)){
            image.resizeScale(200, 150, true);
            data = image.toBytes("jpeg");
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
   public byte[] makeData(ILogicContext logicContext,
                          String guid){
      //............................................................
      // 查找数据
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.ResourceCacheBitmap, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      byte[] data = makePreview(logicContext, guid);
      // 存储数据
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.ResourceCacheBitmap, guid, "bin");
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }
}
