package org.mo.content.core.resource3d.resource;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容图片控制台。</T>
//============================================================
public class FC3dResourceConsole
      extends FGcResBitmapConsole
      implements
         IC3dResourceConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>构造内容图片控制台。</T>
   //============================================================
   public FC3dResourceConsole(){
   }

   //============================================================
   // <T>查找预览数据。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   @Override
   public byte[] findPreviewData(ILogicContext logicContext,
                                 String typeCd,
                                 String guid){
      String catalog = EGcStorageCatalog.ResourcePreview + "." + typeCd;
      SGcStorage findStorage = _storageConsole.find(catalog, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      return null;
   }

   //============================================================
   // <T>上传位图预览数据。</T>
   //
   // @param context 逻辑环境
   // @param typeCd 类型
   // @param guid 唯一编号
   // @param data 数据
   // @return 处理结果
   //============================================================
   @Override
   public EResult uploadPreviewData(ILogicContext context,
                                    String typeCd,
                                    String guid,
                                    byte[] data){
      // 修改预览图
      String catalog = EGcStorageCatalog.ResourcePreview + "." + typeCd;
      SGcStorage storage = new SGcStorage(catalog, guid, "jpg");
      storage.setData(data);
      _storageConsole.store(storage);
      return EResult.Success;
   }
}
