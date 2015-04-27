package org.mo.content.engine.core.material;

import org.mo.cloud.logic.resource.material.FGcResMaterialConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FResMaterialConsole
      extends FGcResMaterialConsole
      implements
         IResMaterialConsole
{
   //   // 纹理控制台
   //   @ALink
   //   protected IRs3TextureConsole _textureConsole;
   //
   //   // 纹理位图控制台
   //   @ALink
   //   protected IRs3TextureBitmapConsole _textureBitmapConsole;
   //
   //   //============================================================
   //   // <T>根据唯一编号查找材质。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public FRs3Material findMaterial(ILogicContext logicContext,
   //                                    String guid){
   //      // 查找数据单元
   //      FDataResourceMaterialLogic materialLogic = logicContext.findLogic(FDataResourceMaterialLogic.class);
   //      FDataResource3dMaterialUnit materialUnit = materialLogic.findByGuid(guid);
   //      // 创建材质
   //      FRs3Material material = new FRs3Material();
   //      material.loadUnit(materialUnit);
   //      return material;
   //   }
   //
   //   //============================================================
   //   // <T>更新材质。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param material 材质
   //   //============================================================
   //   @Override
   //   public void updateMaterial(ILogicContext logicContext,
   //                              FRs3Material material){
   //      long ouid = material.ouid();
   //      // 查找数据单元
   //      FDataResourceMaterialLogic logic = logicContext.findLogic(FDataResourceMaterialLogic.class);
   //      FDataResource3dMaterialUnit unit = logic.find(ouid);
   //      material.saveUnit(unit);
   //      logic.doUpdate(unit);
   //   }
   //
   //   //============================================================
   //   // <T>新建一个材质。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param material 材质
   //   // @return 材质单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dMaterialUnit insertMaterial(ILogicContext logicContext,
   //                                                     long themeId,
   //                                                     long materialGroupId,
   //                                                     FRs3Material material){
   //      // 新建材质
   //      FDataResourceMaterialLogic materialLogic = logicContext.findLogic(FDataResourceMaterialLogic.class);
   //      FDataResource3dMaterialUnit materialUnit = materialLogic.doPrepare();
   //      materialUnit.setThemeId(themeId);
   //      materialUnit.setMaterialGroupId(materialGroupId);
   //      materialUnit.setCode(material.code());
   //      materialUnit.setFullCode(material.fullCode());
   //      materialUnit.setLabel(material.label());
   //      materialUnit.setKeywords(material.keywords());
   //      materialUnit.setContent(material.toXml());
   //      materialLogic.doInsert(materialUnit);
   //      // 返回材质单元
   //      return materialLogic.find(materialUnit.ouid());
   //   }
   //
   //   //============================================================
   //   // <T>新建一个材质纹理。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param materialId 材质编号
   //   // @param materialTexture 材质纹理
   //   // @return 材质纹理单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dMaterialTextureUnit insertMaterialTexture(ILogicContext logicContext,
   //                                                                   long materialId,
   //                                                                   FRs3MaterialTexture materialTexture){
   //      // 查找纹理单元
   //      String textureCode = materialTexture.textureCode();
   //      FDataResource3dTextureUnit textureUnit = _textureConsole.findByCode(logicContext, textureCode);
   //      if(textureUnit == null){
   //         throw new FFatalError("Texture is not exists. (code={1})", textureCode);
   //      }
   //      materialTexture.setTextureGuid(textureUnit.guid());
   //      // 查找纹理单元
   //      String bitmapCode = materialTexture.bitmapCode();
   //      FDataResource3dTextureBitmapUnit textureBitmapUnit = _textureBitmapConsole.findByCode(logicContext, textureUnit.ouid(), bitmapCode);
   //      if(textureBitmapUnit == null){
   //         throw new FFatalError("Texture bitmap is not exists. (texture={1}, bitmap={2})", textureUnit.code(), bitmapCode);
   //      }
   //      materialTexture.setBitmapGuid(textureBitmapUnit.guid());
   //      // 新建材质纹理单元
   //      FDataResource3dMaterialTextureLogic materialTextureLogic = logicContext.findLogic(FDataResource3dMaterialTextureLogic.class);
   //      FDataResource3dMaterialTextureUnit materialTextureUnit = materialTextureLogic.doPrepare();
   //      materialTextureUnit.setMaterialId(materialId);
   //      materialTextureUnit.setFullCode(materialTexture.fullCode());
   //      materialTextureUnit.setCode(materialTexture.code());
   //      materialTextureUnit.setTextureId(textureUnit.ouid());
   //      materialTextureUnit.setTextureBitmapId(textureBitmapUnit.ouid());
   //      materialTextureLogic.doInsert(materialTextureUnit);
   //      // 返回材质纹理单元
   //      return materialTextureLogic.find(materialTextureUnit.ouid());
   //   }

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
      //      path = RFile.format(path);
      //      //............................................................
      //      // 导入配置信息
      //      FRs3Texture texture = new FRs3Texture();
      //      String configFile = RFile.makeFilename(path, "config.xml");
      //      FXmlDocument xdocument = new FXmlDocument();
      //      xdocument.loadFile(configFile);
      //      texture.importConfig(xdocument.root());
      //      String textureCode = texture.code();
      //      String textureLabel = texture.label();
      //      String textureKeywords = texture.keywords();
      //      //............................................................
      //      // 新建纹理
      //      FDataResource3dTextureLogic textureLogic = logicContext.findLogic(FDataResource3dTextureLogic.class);
      //      FDataResource3dTextureUnit textureUnit = this.dop textureLogic.doPrepare();
      //      textureUnit.setCode(textureCode);
      //      textureUnit.setFullCode(texture.fullCode());
      //      textureUnit.setLabel(texture.label());
      //      textureUnit.setKeywords(textureKeywords);
      //      textureUnit.setContent(texture.toXml());
      //      textureLogic.doInsert(textureUnit);
      //      texture.setGuid(textureUnit.guid());
      //      //............................................................
      //      for(FRs3TextureBitmap bitmap : texture.bitmaps()){
      //         // 检查文件
      //         String bitmapCode = bitmap.code();
      //         int bitmapIndex = bitmap.index();
      //         String fileExtension = "jpg";
      //         String bitmapFile = RFile.makeFilename(path, bitmapCode + "." + fileExtension);
      //         if(!RFile.exists(bitmapFile)){
      //            throw new FFatalError("Bitmap file is not exists. (file_name={1})", bitmapFile);
      //         }
      //         FImage image = new FImage();
      //         image.loadFile(bitmapFile);
      //         // 新建位图
      //         FDataResourceBitmapLogic bitmapLogic = logicContext.findLogic(FDataResourceBitmapLogic.class);
      //         FDataResourceBitmapUnit bitmapUnit = bitmapLogic.doPrepare();
      //         bitmapUnit.setCode(bitmapCode);
      //         bitmapUnit.setFullCode(textureCode + "|" + bitmapCode);
      //         bitmapUnit.setLabel(textureLabel);
      //         bitmapUnit.setKeywords(textureKeywords);
      //         bitmapLogic.doInsert(bitmapUnit);
      //         // 新建位图图片
      //         FDataResourceBitmapImageLogic imageLogic = logicContext.findLogic(FDataResourceBitmapImageLogic.class);
      //         FDataResourceBitmapImageUnit imageUnit = imageLogic.doPrepare();
      //         imageUnit.setBitmapId(bitmapUnit.ouid());
      //         imageUnit.setCode(bitmapCode);
      //         imageUnit.setLabel(textureLabel);
      //         imageUnit.setKeywords(textureKeywords);
      //         imageUnit.setSizeWidth(image.width());
      //         imageUnit.setSizeHeight(image.height());
      //         imageUnit.setFormatCode(fileExtension);
      //         imageLogic.doInsert(imageUnit);
      //         // 上传位图数据
      //         try(FByteFile file = new FByteFile(bitmapFile)){
      //            SGcStorage resource = new SGcStorage(EGcStorageCatalog.ResourceBitmapImage, imageUnit.guid(), fileExtension);
      //            resource.setData(file.toArray());
      //            _storageConsole.store(resource);
      //         }
      //         // 新建纹理位图
      //         FDataResource3dTextureBitmapLogic textureBitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
      //         FDataResource3dTextureBitmapUnit textureBitmapUnit = textureBitmapLogic.doPrepare();
      //         textureBitmapUnit.setTextureId(textureUnit.ouid());
      //         textureBitmapUnit.setBitmapId(bitmapUnit.ouid());
      //         textureBitmapUnit.setCode(bitmapCode);
      //         textureBitmapUnit.setLabel(textureLabel);
      //         textureBitmapUnit.setKeywords(textureKeywords);
      //         textureBitmapUnit.setIndex(bitmapIndex);
      //         textureBitmapLogic.doInsert(textureBitmapUnit);
      //         bitmap.setGuid(textureBitmapUnit.guid());
      //         // 释放资源
      //         try{
      //            image.close();
      //         }catch(Exception e){
      //            throw new FFatalError(e);
      //         }
      //      }
      //      textureUnit.setContent(texture.toXml());
      //      textureLogic.doUpdate(textureUnit);
      //      _logger.debug(this, "importTexture", "Import texture success. (path={1})", path);
      return EResult.Success;
   }
}
