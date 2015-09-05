package org.mo.content.core.resource.material;

import org.mo.cloud.logic.data.resource.material.FGcResMaterialBitmapInfo;
import org.mo.cloud.logic.data.resource.material.FGcResMaterialInfo;

import org.mo.cloud.logic.data.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.content.engine.core.material.FResMaterialConsole;
import org.mo.content.engine.core.material.IResMaterialConsole;
import org.mo.content.resource.texture.FResTextureBitmapPack;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.image.FImage;

//============================================================
// <T>内容材质控制台。</T>
//============================================================
public class FCntMaterialConsole
      extends FResMaterialConsole
      implements
         ICntMaterialConsole
{
   // 资源材质控制台
   @ALink
   protected IResMaterialConsole _materialConsole;

   //============================================================
   // <T>生成材质预览数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   public byte[] makePreview(ILogicContext logicContext,
                             String guid){
      // 查找材质信息
      FGcResMaterialInfo materialInfo = _materialConsole.getByGuid(logicContext, guid);
      long materialId = materialInfo.ouid();
      // 查找位图信息
      long bitmapId = 0;
      FGcResMaterialBitmapInfo materialDiffuseInfo = _materialBitmapConsole.findByMaterialCode(logicContext, materialId, "diffuse");
      if(materialDiffuseInfo != null){
         bitmapId = materialDiffuseInfo.bitmapId();
      }else{
         FLogicDataset<FGcResMaterialBitmapInfo> dataset = _materialBitmapConsole.fetchByMaterialId(logicContext, materialId);
         for(FGcResMaterialBitmapInfo materialBitmapInfo : dataset){
            bitmapId = materialBitmapInfo.bitmapId();
            break;
         }
      }
      // 获得位图数据
      byte[] data = null;
      if(bitmapId > 0){
         FGcResBitmapInfo bitmapInfo = _bitmapConsole.get(logicContext, bitmapId);
         data = _bitmapConsole.makePreviewData(logicContext, bitmapInfo.guid());
      }
      // 返回数据
      return data;
   }

   //============================================================
   // <T>生成材质预览数据。</T>
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
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.CacheMaterialPreview, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      byte[] data = makePreview(logicContext, guid);
      // 存储数据
      if(data != null){
         SGcStorage storage = new SGcStorage(EGcStorageCatalog.CacheMaterialPreview, guid);
         storage.setData(data);
         _storageConsole.store(storage);
      }
      // 返回数据
      return data;
   }

   //============================================================
   // <T>生成纹理位图。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public byte[] makeBitmap(ILogicContext logicContext,
                            String guid,
                            String code){
      // 检查代码
      if(RString.isEmpty(guid) || RString.isEmpty(code)){
         throw new FFatalError("Material parameter is invalid. (guid={1}, code={2})", guid, code);
      }
      // 查找纹理
      FGcResMaterialInfo materialInfo = findByGuid(logicContext, guid);
      if(materialInfo == null){
         throw new FFatalError("Material is not exists. (guid={1})", guid);
      }
      long materialId = materialInfo.ouid();
      //............................................................
      byte[] data = null;
      boolean compress = false;
      if(code.contains("-")){
         String[] items = RString.split(code, '-');
         int count = items.length;
         Object[] itemDatas = new Object[items.length];
         for(int n = 0; n < count; n++){
            String item = items[n];
            if(!RString.isEmpty(item)){
               FGcResMaterialBitmapInfo materialBitmapInfo = _materialBitmapConsole.findByMaterialCode(logicContext, materialId, item);
               if(materialBitmapInfo == null){
                  throw new FFatalError("Material bitmap is not exists. (code={1})", code);
               }
               FGcResBitmapInfo bitmapInfo = _bitmapConsole.get(logicContext, materialBitmapInfo.bitmapId());
               SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceBitmap, bitmapInfo.guid());
               itemDatas[n] = resource.data();
            }
         }
         try(FResTextureBitmapPack pack = new FResTextureBitmapPack()){
            if(count == 2){
               // Merge rgb + a
               pack.mergeRgba((byte[])itemDatas[0], (byte[])itemDatas[1]);
            }else if(count == 3){
               // Merge r + g + b
               pack.mergeRgba3((byte[])itemDatas[0], (byte[])itemDatas[1], (byte[])itemDatas[2]);
               compress = true;
            }else{
               throw new FFatalError("Unknown pack mode");
            }
            data = pack.toArray();
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }else{
         FGcResMaterialBitmapInfo materialBitmapInfo = _materialBitmapConsole.findByMaterialCode(logicContext, materialId, code);
         if(materialBitmapInfo == null){
            throw new FFatalError("Texture bitmap is not exists. (code={1})", code);
         }
         FGcResBitmapInfo bitmapInfo = _bitmapConsole.get(logicContext, materialBitmapInfo.bitmapId());
         SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceBitmap, bitmapInfo.guid());
         data = resource.data();
         if(bitmapInfo.formatCode().equals("jpg")){
            // 对大于128K的数据进行降低画质压缩处理
            if(data.length > 1024 * 128){
               compress = true;
            }
         }
      }
      //............................................................
      // 压缩纹理数据
      if(compress){
         // 计算压缩率
         int dataLength = data.length;
         float quality = 0.0f;
         if(dataLength > 1024 * 1024){
            quality = 0.6f;
         }else if(dataLength > 1024 * 512){
            quality = 0.7f;
         }else if(dataLength > 1024 * 256){
            quality = 0.8f;
         }else{
            quality = 0.9f;
         }
         // 压缩数据
         try(FImage image = new FImage(data)){
            data = image.toJpegBytes(quality);
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }
      return data;
   }

   //============================================================
   // <T>生成纹理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   @Override
   public byte[] makeBitmapData(ILogicContext logicContext,
                                String guid,
                                String code){
      String flag = guid + "|" + code;
      //............................................................
      // 查找数据
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.CacheResourceMaterialBitmapPack, flag);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      byte[] data = makeBitmap(logicContext, guid, code);
      // 存储数据
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.CacheResourceMaterialBitmapPack, flag, "bin");
      storage.setCode(flag);
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }

   //============================================================
   // <T>根据资源编号删除材质信息。</T>
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
      // 获得材质
      FGcResMaterialInfo materialInfo = findByResourceId(logicContext, resourceId);
      if(materialInfo == null){
         throw new FFatalError("Material is not exists. (resource_id={1})", resourceId);
      }
      // 检查用户
      if(materialInfo.userId() != userId){
         throw new FFatalError("Material user is not same. (model_user_id={1}, session_user_id={2})", materialInfo.userId(), userId);
      }
      // 删除关联资源对象
      doDelete(logicContext, materialInfo);
      return EResult.Success;
   }
}
