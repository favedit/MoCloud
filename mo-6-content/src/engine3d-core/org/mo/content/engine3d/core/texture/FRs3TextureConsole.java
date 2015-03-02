package org.mo.content.engine3d.core.texture;

import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapLogic;
import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapUnit;
import com.cyou.gccloud.data.data.FDataResource3dTextureLogic;
import com.cyou.gccloud.data.data.FDataResource3dTextureUnit;
import com.cyou.gccloud.data.data.FDataResourceBitmapImageLogic;
import com.cyou.gccloud.data.data.FDataResourceBitmapImageUnit;
import com.cyou.gccloud.data.data.FDataResourceBitmapLogic;
import com.cyou.gccloud.data.data.FDataResourceBitmapUnit;
import java.io.File;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.console.FConsole;
import org.mo.com.io.FByteFile;
import org.mo.com.io.FFileInfo;
import org.mo.com.io.FFileInfos;
import org.mo.com.io.RDirectory;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源纹理控制台。</T>
//============================================================
public class FRs3TextureConsole
      extends FConsole
      implements
         IRs3TextureConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>根据代码查找纹理单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 纹理单元
   //============================================================
   @Override
   public FDataResource3dTextureUnit findByCode(ILogicContext logicContext,
                                                String code){
      String searchSql = FDataResource3dTextureLogic.CODE + "='" + code + "'";
      FDataResource3dTextureLogic textureLogic = logicContext.findLogic(FDataResource3dTextureLogic.class);
      FDataResource3dTextureUnit textureUnit = textureLogic.search(searchSql);
      return textureUnit;
   }

   //============================================================
   // <T>导出数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   @Override
   public EResult exportData(ILogicContext logicContext,
                             String path){
      return EResult.Success;
   }

   //============================================================
   // <T>导入数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   @Override
   public EResult importData(ILogicContext logicContext,
                             String path){
      return EResult.Success;
   }

   //============================================================
   // <T>导入纹理。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   @Override
   public EResult importTexture(ILogicContext logicContext,
                                String path){
      path = RFile.format(path);
      // 获得文件列表
      FFileInfos fileInfos = RDirectory.listFiles(path);
      if(fileInfos.isEmpty()){
         return EResult.Failure;
      }
      // 获得纹理名称
      String[] items = RString.split(path, File.separatorChar);
      String textureCode = items[items.length - 1];
      // 新建纹理
      FDataResource3dTextureLogic textureLogic = logicContext.findLogic(FDataResource3dTextureLogic.class);
      FDataResource3dTextureUnit textureUnit = textureLogic.doPrepare();
      textureUnit.setCode(textureCode);
      textureLogic.doInsert(textureUnit);
      // 新建位图集合
      for(FFileInfo fileInfo : fileInfos){
         String fileCode = fileInfo.code();
         String fileExtension = fileInfo.extension();
         // 新建位图
         FDataResourceBitmapLogic bitmapLogic = logicContext.findLogic(FDataResourceBitmapLogic.class);
         FDataResourceBitmapUnit bitmapUnit = bitmapLogic.doPrepare();
         bitmapUnit.setFullCode(textureCode + "|" + fileCode);
         bitmapUnit.setCode(fileCode);
         bitmapLogic.doInsert(bitmapUnit);
         // 新建位图图片
         FDataResourceBitmapImageLogic imageLogic = logicContext.findLogic(FDataResourceBitmapImageLogic.class);
         FDataResourceBitmapImageUnit imageUnit = imageLogic.doPrepare();
         imageUnit.setBitmapId(bitmapUnit.ouid());
         imageUnit.setCode(fileCode);
         imageUnit.setFormatCode(fileExtension);
         imageLogic.doInsert(imageUnit);
         // 上传位图数据
         imageLogic.find(imageUnit, imageUnit.ouid());
         try(FByteFile file = new FByteFile(fileInfo.fileName())){
            SGcStorage resource = new SGcStorage(EGcStorageCatalog.ResourceBitmapImage, imageUnit.guid(), fileExtension);
            resource.setData(file.toArray());
            _storageConsole.store(resource);
         }
         // 新建纹理位图
         FDataResource3dTextureBitmapLogic textureBitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
         FDataResource3dTextureBitmapUnit textureBitmapUnit = textureBitmapLogic.doPrepare();
         textureBitmapUnit.setTextureId(textureUnit.ouid());
         textureBitmapUnit.setBitmapId(bitmapUnit.ouid());
         textureBitmapUnit.setCode(fileCode);
         textureBitmapLogic.doInsert(textureBitmapUnit);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>生成纹理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   @Override
   public FRs3Texture makeTexture(ILogicContext logicContext,
                                  String guid){
      // 查找纹理
      FDataResource3dTextureLogic textureLogic = logicContext.findLogic(FDataResource3dTextureLogic.class);
      FDataResource3dTextureUnit textureUnit = textureLogic.findByGuid(guid);
      if(textureUnit == null){
         throw new FFatalError("Texture is not exists.");
      }
      // 加载纹理信息
      FRs3Texture texture = new FRs3Texture();
      texture.loadUnit(textureUnit);
      // 查找纹理
      FDataResource3dTextureBitmapLogic textureBitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
      FLogicDataset<FDataResource3dTextureBitmapUnit> textureBitmapUnits = textureBitmapLogic.fetch(FDataResource3dTextureBitmapLogic.TEXTURE_ID + "=" + textureUnit.ouid());
      for(FDataResource3dTextureBitmapUnit textureBitmapUnit : textureBitmapUnits){
         FDataResourceBitmapUnit bitmapUnit = textureBitmapUnit.bitmap();
         // 查找图片
         FDataResourceBitmapImageLogic bitmapImageLogic = logicContext.findLogic(FDataResourceBitmapImageLogic.class);
         FLogicDataset<FDataResourceBitmapImageUnit> bitmapImageUnits = bitmapImageLogic.fetch(FDataResourceBitmapImageLogic.BITMAP_ID + "=" + bitmapUnit.ouid());
         if(bitmapImageUnits.count() != 1){
            throw new FFatalError("Bitmap image is too many. (count={1}).", bitmapImageUnits.count());
         }
         FDataResourceBitmapImageUnit bitmapImageUnit = bitmapImageUnits.first();
         // 查找图片数据
         SGcStorage imageResource = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, bitmapImageUnit.guid());
         if(imageResource == null){
            throw new FFatalError("Can't find bitmap image storage. (guid={1}).", bitmapImageUnit.guid());
         }
         // 存储到纹理
         FRs3TextureBitmap textureBitmap = new FRs3TextureBitmap();
         textureBitmap.loadUnit(textureBitmapUnit);
         textureBitmap.setData(imageResource.data());
         texture.bitmaps().push(textureBitmap);
      }
      // 数据打包处理
      texture.pack();
      // 返回纹理
      return texture;
   }
}
