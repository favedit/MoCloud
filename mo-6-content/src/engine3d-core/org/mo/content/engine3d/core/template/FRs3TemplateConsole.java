package org.mo.content.engine3d.core.template;

import com.cyou.gccloud.data.data.FDataResource3dMaterialGroupUnit;
import com.cyou.gccloud.data.data.FDataResource3dMaterialLogic;
import com.cyou.gccloud.data.data.FDataResource3dMaterialTextureLogic;
import com.cyou.gccloud.data.data.FDataResource3dMaterialTextureUnit;
import com.cyou.gccloud.data.data.FDataResource3dMaterialUnit;
import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import com.cyou.gccloud.data.data.FDataResource3dTemplateLogic;
import com.cyou.gccloud.data.data.FDataResource3dTemplateMaterialGroupLogic;
import com.cyou.gccloud.data.data.FDataResource3dTemplateMaterialGroupUnit;
import com.cyou.gccloud.data.data.FDataResource3dTemplateThemeLogic;
import com.cyou.gccloud.data.data.FDataResource3dTemplateThemeUnit;
import com.cyou.gccloud.data.data.FDataResource3dTemplateUnit;
import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapUnit;
import com.cyou.gccloud.data.data.FDataResource3dThemeUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.engine.core.bitmap.IResBitmapConsole;
import org.mo.content.engine3d.core.material.IRs3MaterialConsole;
import org.mo.content.engine3d.core.material.IRs3MaterialGroupConsole;
import org.mo.content.engine3d.core.model.IRs3ModelConsole;
import org.mo.content.engine3d.core.model.IRs3ModelMeshConsole;
import org.mo.content.engine3d.core.texture.IRs3TextureBitmapConsole;
import org.mo.content.engine3d.core.texture.IRs3TextureConsole;
import org.mo.content.engine3d.core.theme.IRs3ThemeConsole;
import org.mo.content.resource3d.common.FRs3Display;
import org.mo.content.resource3d.common.FRs3DisplayMaterial;
import org.mo.content.resource3d.common.FRs3Material;
import org.mo.content.resource3d.common.FRs3MaterialGroup;
import org.mo.content.resource3d.common.FRs3MaterialTexture;
import org.mo.content.resource3d.common.FRs3Theme;
import org.mo.content.resource3d.template.FRs3Template;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
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

   // 材质组控制台
   @ALink
   protected IRs3MaterialGroupConsole _materialGroupConsole;

   // 模型控制台
   @ALink
   protected IRs3ModelConsole _modelConsole;

   // 模型网格控制台
   @ALink
   protected IRs3ModelMeshConsole _modelMeshConsole;

   // 模型网格控制台
   @ALink
   protected IRs3ThemeConsole _themeConsole;

   // 模型网格控制台
   @ALink
   protected IRs3MaterialConsole _materialConsole;

   //============================================================
   // <T>构造资源模板控制台。</T>
   //============================================================
   public FRs3TemplateConsole(){
      super(FDataResource3dTemplateLogic.class, FDataResource3dTemplateUnit.class);
   }

   //============================================================
   // <T>根据代码查找模板单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 模板单元
   //============================================================
   public FDataResource3dTemplateUnit findByCode(ILogicContext logicContext,
                                                 String code){
      String sql = FDataResource3dTemplateLogic.CODE + "='" + code + "'";
      FDataResource3dTemplateLogic templateLogic = logicContext.findLogic(FDataResource3dTemplateLogic.class);
      FDataResource3dTemplateUnit templateUnit = templateLogic.search(sql);
      return templateUnit;
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
                                    String guid,
                                    String code,
                                    String version){
      FRs3Template template = null;
      // 查找数据
      FDataResource3dTemplateUnit templateUnit = null;
      if(!RString.isEmpty(guid)){
         templateUnit = findByGuid(logicContext, guid);
      }else if(!RString.isEmpty(code)){
         templateUnit = findByCode(logicContext, code);
      }else{
         throw new FFatalError("Find template failure. (guid={1}, code={2}, version={3})", guid, code, version);
      }
      // 生成配置
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
   // <T>生成资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   @Override
   public FRs3Template makeTemplate(ILogicContext logicContext,
                                    String guid,
                                    String code){
      FRs3Template template = null;
      // 查找数据
      FDataResource3dTemplateUnit templateUnit = null;
      if(!RString.isEmpty(guid)){
         templateUnit = findByGuid(logicContext, guid);
      }else if(!RString.isEmpty(code)){
         templateUnit = findByCode(logicContext, code);
      }else{
         throw new FFatalError("Find template failure. (guid={1}, code={2})", guid, code);
      }
      // 未查到处理
      if(templateUnit == null){
         return null;
      }
      // 读取内容
      template = new FRs3Template();
      template.loadUnit(templateUnit);
      // 查找材质组
      FDataResource3dTemplateMaterialGroupLogic templateMaterialGroupLogic = logicContext.findLogic(FDataResource3dTemplateMaterialGroupLogic.class);
      String materialGroupSql = FDataResource3dTemplateMaterialGroupLogic.TEMPLATE_ID + "=" + templateUnit.ouid();
      FLogicDataset<FDataResource3dTemplateMaterialGroupUnit> groupDataset = templateMaterialGroupLogic.fetch(materialGroupSql);
      for(FDataResource3dTemplateMaterialGroupUnit unit : groupDataset){
         FDataResource3dMaterialGroupUnit materialGroup = unit.materialGroup();
         FRs3MaterialGroup group = new FRs3MaterialGroup();
         group.loadUnit(materialGroup);
         template.materialGroups().set(group.guid(), group);
      }
      // 查找主题
      FDataResource3dTemplateThemeLogic templateThemeLogic = logicContext.findLogic(FDataResource3dTemplateThemeLogic.class);
      String themeSql = FDataResource3dTemplateThemeLogic.TEMPLATE_ID + "=" + templateUnit.ouid();
      FLogicDataset<FDataResource3dTemplateThemeUnit> themeDataset = templateThemeLogic.fetch(themeSql);
      for(FDataResource3dTemplateThemeUnit unit : themeDataset){
         FDataResource3dThemeUnit themeUnit = unit.theme();
         FRs3Theme theme = new FRs3Theme();
         theme.loadUnit(themeUnit);
         template.themes().push(theme);
         // 查找材质
         FDataResource3dMaterialLogic materialLogic = logicContext.findLogic(FDataResource3dMaterialLogic.class);
         String materialSql = FDataResource3dMaterialLogic.THEME_ID + "=" + themeUnit.ouid();
         FLogicDataset<FDataResource3dMaterialUnit> materialDataset = materialLogic.fetch(materialSql);
         for(FDataResource3dMaterialUnit materialUnit : materialDataset){
            FDataResource3dMaterialGroupUnit materialGroup = materialUnit.materialGroup();
            FRs3Material material = new FRs3Material();
            material.loadUnit(materialUnit);
            material.setGroupGuid(materialGroup.guid());
            theme.materials().push(material);
            // 查找纹理
            FDataResource3dMaterialTextureLogic materialTextureLogic = logicContext.findLogic(FDataResource3dMaterialTextureLogic.class);
            String materialTextureSql = FDataResource3dMaterialTextureLogic.MATERIAL_ID + "=" + materialUnit.ouid();
            FLogicDataset<FDataResource3dMaterialTextureUnit> materialTextureDataset = materialTextureLogic.fetch(materialTextureSql);
            for(FDataResource3dMaterialTextureUnit materialTextureUnit : materialTextureDataset){
               FDataResource3dTextureBitmapUnit textureBitmapUnit = materialTextureUnit.textureBitmap();
               FRs3MaterialTexture materialTexture = new FRs3MaterialTexture();
               materialTexture.loadUnit(materialTextureUnit);
               materialTexture.setBitmapGuid(textureBitmapUnit.guid());
               material.textures().push(materialTexture);
            }
         }
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
      // 修正材质组
      for(FRs3MaterialGroup materialGroup : template.materialGroups().toObjects()){
         // 新建材质组
         FDataResource3dMaterialGroupUnit materialGroupUnit = _materialGroupConsole.insertMaterialGroup(logicContext, materialGroup);
         materialGroup.setOuid(materialGroupUnit.ouid());
         materialGroup.setGuid(materialGroupUnit.guid());
         // 关联模板和材质组
         FDataResource3dTemplateMaterialGroupLogic templateMaterialGroupLogic = logicContext.findLogic(FDataResource3dTemplateMaterialGroupLogic.class);
         FDataResource3dTemplateMaterialGroupUnit templateMaterialGroupUnit = templateMaterialGroupLogic.doPrepare();
         templateMaterialGroupUnit.setTemplateId(templateUnit.ouid());
         templateMaterialGroupUnit.setMaterialGroupId(materialGroupUnit.ouid());
         templateMaterialGroupLogic.doInsert(templateMaterialGroupUnit);
      }
      // 修正材质数据
      for(FRs3Theme theme : template.themes()){
         // 新建主题
         FDataResource3dThemeUnit themeUnit = _themeConsole.insert(logicContext, theme);
         theme.setGuid(themeUnit.guid());
         // 关联模板和主题
         FDataResource3dTemplateThemeLogic templateThemeLogic = logicContext.findLogic(FDataResource3dTemplateThemeLogic.class);
         FDataResource3dTemplateThemeUnit templateThemeUnit = templateThemeLogic.doPrepare();
         templateThemeUnit.setTemplateId(templateUnit.ouid());
         templateThemeUnit.setThemeId(themeUnit.ouid());
         templateThemeLogic.doInsert(templateThemeUnit);
         // 新建材质
         for(FRs3Material material : theme.materials()){
            FRs3MaterialGroup materialGroup = template.syncMaterialGroup(material.code());
            FDataResource3dMaterialUnit materialUnit = _materialConsole.insertMaterial(logicContext, themeUnit.ouid(), materialGroup.ouid(), material);
            for(FRs3MaterialTexture materialTexture : material.textures()){
               _materialConsole.insertMaterialTexture(logicContext, materialUnit.ouid(), materialTexture);
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
         FDataResource3dMeshUnit meshUnit = _modelMeshConsole.findMeshByCode(logicContext, modelUnit.ouid(), meshCode);
         display.setMeshGuid(meshUnit.guid());
         // 修正材质
         for(FRs3DisplayMaterial material : display.materials()){
            String groupCode = material.code();
            FRs3MaterialGroup templateMaterial = template.syncMaterialGroup(groupCode);
            material.setGroupGuid(templateMaterial.guid());
         }
      }
      // 存储配置信息
      templateUnit = templateLogic.find(templateUnit.ouid());
      templateUnit.setContent(template.toXml());
      templateLogic.doUpdate(templateUnit);
      //System.out.println(xoutput.xml());
      // 修正材质数据
      return EResult.Success;
   }
}
