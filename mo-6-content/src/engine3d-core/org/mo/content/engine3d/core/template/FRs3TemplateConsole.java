package org.mo.content.engine3d.core.template;

import com.cyou.gccloud.data.data.FDataResource3dModelMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import com.cyou.gccloud.data.data.FDataResource3dTemplateLogic;
import com.cyou.gccloud.data.data.FDataResource3dTemplateUnit;
import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapUnit;
import com.cyou.gccloud.data.data.FDataResource3dTextureUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.lang.EResult;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.engine.core.bitmap.IResBitmapConsole;
import org.mo.content.engine3d.core.model.IRs3ModelConsole;
import org.mo.content.engine3d.core.model.IRs3ModelMeshConsole;
import org.mo.content.engine3d.core.texture.IRs3TextureBitmapConsole;
import org.mo.content.engine3d.core.texture.IRs3TextureConsole;
import org.mo.content.resource3d.common.FRs3Display;
import org.mo.content.resource3d.common.FRs3DisplayMaterial;
import org.mo.content.resource3d.common.FRs3Material;
import org.mo.content.resource3d.common.FRs3MaterialGroup;
import org.mo.content.resource3d.common.FRs3MaterialTexture;
import org.mo.content.resource3d.common.FRs3Theme;
import org.mo.content.resource3d.template.FRs3Template;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模板控制台。</T>
//============================================================
public class FRs3TemplateConsole
      extends FAbstractLogicUnitConsole<FDataResource3dTemplateLogic, FDataResource3dTemplateUnit>
      implements
         IRs3TemplateConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 位图控制台
   @ALink
   protected IResBitmapConsole _bitmapConsole;

   // 纹理控制台
   @ALink
   protected IRs3TextureConsole _textureConsole;

   // 纹理位图控制台
   @ALink
   protected IRs3TextureBitmapConsole _textureBitmapConsole;

   // 模型控制台
   @ALink
   protected IRs3ModelConsole _modelConsole;

   // 模型网格控制台
   @ALink
   protected IRs3ModelMeshConsole _modelMeshConsole;

   //============================================================
   // <T>构造资源模板控制台。</T>
   //============================================================
   public FRs3TemplateConsole(){
      super(FDataResource3dTemplateLogic.class, FDataResource3dTemplateUnit.class);
   }

   //============================================================
   // <T>查找资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   @Override
   public FRs3Template findTemplate(ILogicContext logicContext,
                                    String guid){
      FRs3Template template = null;
      // 查找数据
      FDataResource3dTemplateUnit templateUnit = findByGuid(logicContext, guid);
      if(templateUnit != null){
         // 读取配置
         FXmlDocument xdocument = new FXmlDocument();
         xdocument.loadString(templateUnit.content());
         // 读取内容
         template = new FRs3Template();
         template.loadConfig(xdocument.root());
      }
      return template;
   }

   //============================================================
   // <T>导入模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   @Override
   public EResult importTemplate(ILogicContext logicContext,
                                 String fileName){
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadFile(fileName);
      FXmlNode xconfig = xdocument.root();
      // 获得纹理名称
      FRs3Template template = new FRs3Template();
      template.importConfig(xconfig);
      // 新建模板
      FDataResource3dTemplateLogic templateLogic = logicContext.findLogic(FDataResource3dTemplateLogic.class);
      FDataResource3dTemplateUnit templateUnit = templateLogic.doPrepare();
      templateUnit.setCode(template.code());
      templateLogic.doInsert(templateUnit);
      template.setGuid(templateUnit.guid());
      // 修正材质数据
      for(FRs3Theme theme : template.themes()){
         for(FRs3Material material : theme.materials()){
            FRs3MaterialGroup templateMaterial = template.syncMaterial(material.code());
            material.setGroupGuid(templateMaterial.guid());
            for(FRs3MaterialTexture texture : material.textures()){
               // 设置纹理唯一编号
               String textureCode = texture.textureCode();
               FDataResource3dTextureUnit textureUnit = _textureConsole.findByCode(logicContext, textureCode);
               texture.setTextureGuid(textureUnit.guid());
               // 设置纹理唯一编号
               String bitmapCode = texture.bitmapCode();
               FDataResource3dTextureBitmapUnit textureBitmapUnit = _textureBitmapConsole.findByCode(logicContext, textureUnit.ouid(), bitmapCode);
               texture.setBitmapGuid(textureBitmapUnit.guid());
            }
         }
      }
      // 修正显示数据
      for(FRs3Display display : template.displays()){
         // 设置模型唯一编号
         String modelCode = display.modelCode();
         FDataResource3dModelUnit modelUnit = _modelConsole.findByCode(logicContext, modelCode);
         display.setModelGuid(modelUnit.guid());
         // 设置网格唯一编号
         String meshCode = display.meshCode();
         FDataResource3dModelMeshUnit meshUnit = _modelMeshConsole.findByCode(logicContext, modelUnit.ouid(), meshCode);
         display.setMeshGuid(meshUnit.guid());
         // 修正材质
         for(FRs3DisplayMaterial material : display.materials()){
            String groupCode = material.code();
            FRs3MaterialGroup templateMaterial = template.syncMaterial(groupCode);
            material.setGroupGuid(templateMaterial.guid());
         }
      }
      // 存储配置信息
      FXmlNode xoutput = new FXmlNode("Template");
      template.saveConfig(xoutput);
      templateUnit = templateLogic.find(templateUnit.ouid());
      templateUnit.setContent(xoutput.xml().toString());
      templateLogic.doUpdate(templateUnit);
      //System.out.println(xoutput.xml());
      // 修正材质数据
      return EResult.Success;
   }
}
