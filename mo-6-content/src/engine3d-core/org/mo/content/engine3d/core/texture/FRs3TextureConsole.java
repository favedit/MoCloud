package org.mo.content.engine3d.core.texture;

import org.mo.com.console.FConsole;

//============================================================
// <T>资源纹理控制台。</T>
//============================================================
public class FRs3TextureConsole
      extends FConsole
      implements
         IRs3TextureConsole
{
   //   // 日志输出接口
   //   private static ILogger _logger = RLogger.find(FRs3TextureConsole.class);
   //
   //   // 存储控制台
   //   @ALink
   //   protected IGcStorageConsole _storageConsole;
   //
   //   // 纹理位图控制台
   //   @ALink
   //   protected IRs3TextureBitmapConsole _bitmapConsole;
   //
   //   //============================================================
   //   // <T>根据代码查找纹理单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 纹理单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dTextureUnit findByCode(ILogicContext logicContext,
   //                                                String code){
   //      String searchSql = FDataResource3dTextureLogic.CODE + "='" + code + "'";
   //      FDataResource3dTextureLogic textureLogic = logicContext.findLogic(FDataResource3dTextureLogic.class);
   //      FDataResource3dTextureUnit textureUnit = textureLogic.search(searchSql);
   //      return textureUnit;
   //   }
   //
   //   //============================================================
   //   // <T>生成纹理。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public FRs3Texture makeTexture(ILogicContext logicContext,
   //                                  String guid){
   //      // 查找纹理
   //      FDataResource3dTextureLogic textureLogic = logicContext.findLogic(FDataResource3dTextureLogic.class);
   //      FDataResource3dTextureUnit textureUnit = textureLogic.findByGuid(guid);
   //      if(textureUnit == null){
   //         throw new FFatalError("Texture is not exists.");
   //      }
   //      // 加载纹理信息
   //      FRs3Texture texture = new FRs3Texture();
   //      texture.loadUnit(textureUnit);
   //      // 查找纹理
   //      FDataResource3dTextureBitmapLogic textureBitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
   //      FLogicDataset<FDataResource3dTextureBitmapUnit> textureBitmapUnits = textureBitmapLogic.fetch(FDataResource3dTextureBitmapLogic.TEXTURE_ID + "=" + textureUnit.ouid());
   //      for(FDataResource3dTextureBitmapUnit textureBitmapUnit : textureBitmapUnits){
   //         FDataResourceBitmapUnit bitmapUnit = textureBitmapUnit.bitmap();
   //         // 查找图片
   //         FDataResourceBitmapImageLogic bitmapImageLogic = logicContext.findLogic(FDataResourceBitmapImageLogic.class);
   //         FLogicDataset<FDataResourceBitmapImageUnit> bitmapImageUnits = bitmapImageLogic.fetch(FDataResourceBitmapImageLogic.BITMAP_ID + "=" + bitmapUnit.ouid());
   //         if(bitmapImageUnits.count() != 1){
   //            throw new FFatalError("Bitmap image is too many. (count={1}).", bitmapImageUnits.count());
   //         }
   //         FDataResourceBitmapImageUnit bitmapImageUnit = bitmapImageUnits.first();
   //         // 查找图片数据
   //         SGcStorage imageResource = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, bitmapImageUnit.guid());
   //         if(imageResource == null){
   //            throw new FFatalError("Can't find bitmap image storage. (guid={1}).", bitmapImageUnit.guid());
   //         }
   //         // 存储到纹理
   //         FRs3TextureBitmap textureBitmap = new FRs3TextureBitmap();
   //         textureBitmap.loadUnit(textureBitmapUnit);
   //         textureBitmap.setData(imageResource.data());
   //         texture.bitmaps().push(textureBitmap);
   //      }
   //      // 数据打包处理
   //      texture.pack();
   //      // 返回纹理
   //      return texture;
   //   }
   //
   //   //============================================================
   //   // <T>生成纹理数据。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 数据
   //   //============================================================
   //   @Override
   //   public byte[] makeTextureData(ILogicContext logicContext,
   //                                 String guid){
   //      return makeTextureData(logicContext, guid, true);
   //   }
   //
   //   //============================================================
   //   // <T>生成纹理数据。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @param compress 是否压缩
   //   // @return 数据
   //   //============================================================
   //   @Override
   //   public byte[] makeTextureData(ILogicContext logicContext,
   //                                 String guid,
   //                                 boolean compress){
   //      String catalog = compress ? EGcStorageCatalog.Cache3dTextureCompress : EGcStorageCatalog.Cache3dTexture;
   //      //............................................................
   //      // 查找数据
   //      SGcStorage findStorage = _storageConsole.find(catalog, guid);
   //      if(findStorage != null){
   //         return findStorage.data();
   //      }
   //      //............................................................
   //      // 生成模型
   //      byte[] data = null;
   //      FRs3Texture texture = makeTexture(logicContext, guid);
   //      // 获得数据
   //      FByteStream stream = new FByteStream();
   //      texture.serialize(stream);
   //      if(compress){
   //         // 压缩数据
   //         try(FCompressStream file = new FCompressStream(stream.toArray())){
   //            data = file.toCompressArray(ECompressMode.Lzma);
   //         }
   //      }else{
   //         data = stream.toArray();
   //      }
   //      //............................................................
   //      // 存储数据
   //      SGcStorage storage = new SGcStorage(catalog, guid, EMime.Bin.type());
   //      storage.setCode(texture.code());
   //      storage.setData(data);
   //      _storageConsole.store(storage);
   //      // 返回数据
   //      return data;
   //   }
   //
   //   //============================================================
   //   // <T>生成纹理位图。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @param code 代码
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public byte[] makeBitmap(ILogicContext logicContext,
   //                            String guid,
   //                            String code){
   //      // 检查代码
   //      if(RString.isEmpty(guid) || RString.isEmpty(code)){
   //         throw new FFatalError("Texture parameter is invalid. (guid={1}, code={2})", guid, code);
   //      }
   //      // 查找纹理
   //      FDataResource3dTextureLogic textureLogic = logicContext.findLogic(FDataResource3dTextureLogic.class);
   //      FDataResource3dTextureUnit textureUnit = textureLogic.findByGuid(guid);
   //      if(textureUnit == null){
   //         throw new FFatalError("Texture is not exists. (guid={1})", guid);
   //      }
   //      //............................................................
   //      byte[] data = null;
   //      boolean compress = false;
   //      long textureId = textureUnit.ouid();
   //      if(code.contains("-")){
   //         String[] items = RString.split(code, '-');
   //         int count = items.length;
   //         Object[] itemDatas = new Object[items.length];
   //         for(int n = 0; n < count; n++){
   //            String item = items[n];
   //            if(!RString.isEmpty(item)){
   //               String whereSql = "(" + FDataResource3dTextureBitmapLogic.TEXTURE_ID + "=" + textureId + ") AND (" + FDataResource3dTextureBitmapLogic.CODE + "='" + item + "')";
   //               FDataResource3dTextureBitmapLogic textureBitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
   //               FDataResource3dTextureBitmapUnit textureBitmapUnit = textureBitmapLogic.search(whereSql);
   //               if(textureBitmapUnit == null){
   //                  throw new FFatalError("Texture bitmap is not exists. (code={1})", code);
   //               }
   //               FDataResourceBitmapImageUnit imageUnit = _bitmapConsole.findBitmapUnit(logicContext, textureBitmapUnit.bitmapId());
   //               SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, imageUnit.guid());
   //               itemDatas[n] = resource.data();
   //            }
   //         }
   //         try(FRs3TextureBitmapPack pack = new FRs3TextureBitmapPack()){
   //            if(count == 2){
   //               // Merge rgb + a
   //               pack.mergeRgba((byte[])itemDatas[0], (byte[])itemDatas[1]);
   //            }else if(count == 3){
   //               // Merge r + g + b
   //               pack.mergeRgba3((byte[])itemDatas[0], (byte[])itemDatas[1], (byte[])itemDatas[2]);
   //               compress = true;
   //            }else{
   //               throw new FFatalError("Unknown pack mode");
   //            }
   //            data = pack.toArray();
   //         }catch(Exception e){
   //            throw new FFatalError(e);
   //         }
   //      }else{
   //         String whereSql = "(" + FDataResource3dTextureBitmapLogic.TEXTURE_ID + "=" + textureId + ") AND (" + FDataResource3dTextureBitmapLogic.CODE + "='" + code + "')";
   //         FDataResource3dTextureBitmapLogic textureBitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
   //         FDataResource3dTextureBitmapUnit textureBitmapUnit = textureBitmapLogic.search(whereSql);
   //         if(textureBitmapUnit == null){
   //            throw new FFatalError("Texture bitmap is not exists. (code={1})", code);
   //         }
   //         FDataResourceBitmapImageUnit imageUnit = _bitmapConsole.findBitmapUnit(logicContext, textureBitmapUnit.bitmapId());
   //         SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, imageUnit.guid());
   //         data = resource.data();
   //         if(imageUnit.formatCode().equals("jpg")){
   //            // 对大于128K的数据进行降低画质压缩处理
   //            if(data.length > 1024 * 128){
   //               compress = true;
   //            }
   //         }
   //      }
   //      //............................................................
   //      // 压缩纹理数据
   //      if(compress){
   //         // 计算压缩率
   //         int dataLength = data.length;
   //         float quality = 0.0f;
   //         if(dataLength > 1024 * 1024){
   //            quality = 0.6f;
   //         }else if(dataLength > 1024 * 512){
   //            quality = 0.7f;
   //         }else if(dataLength > 1024 * 256){
   //            quality = 0.8f;
   //         }else{
   //            quality = 0.9f;
   //         }
   //         // 压缩数据
   //         try(FImage image = new FImage(data)){
   //            // 数据转换不支持多线程处理
   //            synchronized(this){
   //               data = image.toJpegBytes(quality);
   //            }
   //         }catch(Exception e){
   //            throw new FFatalError(e);
   //         }
   //      }
   //      return data;
   //   }
   //
   //   //============================================================
   //   // <T>生成纹理。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public byte[] makeBitmapData(ILogicContext logicContext,
   //                                String guid,
   //                                String code){
   //      String uniqueCode = guid + "|" + code;
   //      //............................................................
   //      // 查找数据
   //      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Cache3dTextureBitmap, uniqueCode);
   //      if(findStorage != null){
   //         return findStorage.data();
   //      }
   //      //............................................................
   //      // 生成模型
   //      byte[] data = makeBitmap(logicContext, guid, code);
   //      // 存储数据
   //      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Cache3dTextureBitmap, uniqueCode, "bin");
   //      storage.setCode(uniqueCode);
   //      storage.setData(data);
   //      _storageConsole.store(storage);
   //      // 返回数据
   //      return data;
   //   }
}
