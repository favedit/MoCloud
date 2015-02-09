package org.mo.content.engine3d.core.material;

import com.cyou.gccloud.data.data.FDataResource3dMaterialLogic;
import com.cyou.gccloud.data.data.FDataResource3dMaterialTextureLogic;
import com.cyou.gccloud.data.data.FDataResource3dMaterialTextureUnit;
import com.cyou.gccloud.data.data.FDataResource3dMaterialUnit;
import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapUnit;
import com.cyou.gccloud.data.data.FDataResource3dTextureUnit;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FFatalError;
import org.mo.content.engine3d.core.texture.IRs3TextureBitmapConsole;
import org.mo.content.engine3d.core.texture.IRs3TextureConsole;
import org.mo.content.resource3d.common.FRs3Material;
import org.mo.content.resource3d.common.FRs3MaterialTexture;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3MaterialConsole
      extends FConsole
      implements
         IRs3MaterialConsole
{
   // 纹理控制台
   @ALink
   protected IRs3TextureConsole _textureConsole;

   // 纹理位图控制台
   @ALink
   protected IRs3TextureBitmapConsole _textureBitmapConsole;

   //============================================================
   // <T>根据唯一编号查找材质。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   @Override
   public FRs3Material findMaterial(ILogicContext logicContext,
                                    String guid){
      // 查找数据单元
      FDataResource3dMaterialLogic materialLogic = logicContext.findLogic(FDataResource3dMaterialLogic.class);
      FDataResource3dMaterialUnit materialUnit = materialLogic.findByGuid(guid);
      // 创建材质
      FRs3Material material = new FRs3Material();
      material.loadUnit(materialUnit);
      return material;
   }

   //============================================================
   // <T>更新材质。</T>
   //
   // @param logicContext 逻辑环境
   // @param material 材质
   //============================================================
   @Override
   public void updateMaterial(ILogicContext logicContext,
                              FRs3Material material){
      long ouid = material.ouid();
      // 查找数据单元
      FDataResource3dMaterialLogic logic = logicContext.findLogic(FDataResource3dMaterialLogic.class);
      FDataResource3dMaterialUnit unit = logic.find(ouid);
      material.saveUnit(unit);
      logic.doUpdate(unit);
   }

   //============================================================
   // <T>新建一个材质。</T>
   //
   // @param logicContext 逻辑环境
   // @param material 材质
   // @return 材质单元
   //============================================================
   @Override
   public FDataResource3dMaterialUnit insertMaterial(ILogicContext logicContext,
                                                     long themeId,
                                                     long materialGroupId,
                                                     FRs3Material material){
      // 新建材质
      FDataResource3dMaterialLogic materialLogic = logicContext.findLogic(FDataResource3dMaterialLogic.class);
      FDataResource3dMaterialUnit materialUnit = materialLogic.doPrepare();
      materialUnit.setThemeId(themeId);
      materialUnit.setMaterialGroupId(materialGroupId);
      materialUnit.setFullCode(material.fullCode());
      materialUnit.setCode(material.code());
      materialUnit.setContent(material.toXml());
      materialLogic.doInsert(materialUnit);
      // 返回材质单元
      return materialLogic.find(materialUnit.ouid());
   }

   //============================================================
   // <T>新建一个材质纹理。</T>
   //
   // @param logicContext 逻辑环境
   // @param materialId 材质编号
   // @param materialTexture 材质纹理
   // @return 材质纹理单元
   //============================================================
   @Override
   public FDataResource3dMaterialTextureUnit insertMaterialTexture(ILogicContext logicContext,
                                                                   long materialId,
                                                                   FRs3MaterialTexture materialTexture){
      // 查找纹理单元
      String textureCode = materialTexture.textureCode();
      FDataResource3dTextureUnit textureUnit = _textureConsole.findByCode(logicContext, textureCode);
      if(textureUnit == null){
         throw new FFatalError("Texture is not exists. (code={1})", textureCode);
      }
      materialTexture.setTextureGuid(textureUnit.guid());
      // 查找纹理单元
      String bitmapCode = materialTexture.bitmapCode();
      FDataResource3dTextureBitmapUnit textureBitmapUnit = _textureBitmapConsole.findByCode(logicContext, textureUnit.ouid(), bitmapCode);
      materialTexture.setBitmapGuid(textureBitmapUnit.guid());
      // 新建材质纹理单元
      FDataResource3dMaterialTextureLogic materialTextureLogic = logicContext.findLogic(FDataResource3dMaterialTextureLogic.class);
      FDataResource3dMaterialTextureUnit materialTextureUnit = materialTextureLogic.doPrepare();
      materialTextureUnit.setMaterialId(materialId);
      materialTextureUnit.setFullCode(materialTexture.fullCode());
      materialTextureUnit.setCode(materialTexture.code());
      materialTextureUnit.setTextureId(textureUnit.ouid());
      materialTextureUnit.setTextureBitmapId(textureBitmapUnit.ouid());
      materialTextureLogic.doInsert(materialTextureUnit);
      // 返回材质纹理单元
      return materialTextureLogic.find(materialTextureUnit.ouid());
   }
}
