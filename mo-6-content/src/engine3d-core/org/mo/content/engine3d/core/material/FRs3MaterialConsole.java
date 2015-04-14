package org.mo.content.engine3d.core.material;

import org.mo.com.console.FConsole;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3MaterialConsole
      extends FConsole
      implements
         IRs3MaterialConsole
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
}
