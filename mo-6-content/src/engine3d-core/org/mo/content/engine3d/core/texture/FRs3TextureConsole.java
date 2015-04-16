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
}
