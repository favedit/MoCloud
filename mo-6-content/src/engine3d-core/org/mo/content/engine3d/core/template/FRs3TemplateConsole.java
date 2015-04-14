package org.mo.content.engine3d.core.template;

import com.cyou.gccloud.data.data.FDataResourceTemplateLogic;
import com.cyou.gccloud.data.data.FDataResourceTemplateUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>资源模板控制台。</T>
//============================================================
public class FRs3TemplateConsole
      extends FAbstractLogicUnitConsole<FDataResourceTemplateLogic, FDataResourceTemplateUnit>
      implements
         IRs3TemplateConsole
{

   public FRs3TemplateConsole(Class<FDataResourceTemplateLogic> classLogic,
                              Class<FDataResourceTemplateUnit> classUnit){
      super(classLogic, classUnit);
      // TODO Auto-generated constructor stub
   }
   //   // 日志输出接口
   //   private static ILogger _logger = RLogger.find(FRs3TemplateConsole.class);
   //
   //   // 存储控制台
   //   @ALink
   //   protected IGcStorageConsole _storageConsole;
   //
   //   // 位图控制台
   //   @ALink
   //   protected IResBitmapConsole _bitmapConsole;
   //
   //   // 纹理控制台
   //   @ALink
   //   protected IRs3TextureConsole _textureConsole;
   //
   //   // 纹理位图控制台
   //   @ALink
   //   protected IRs3TextureBitmapConsole _textureBitmapConsole;
   //
   //   // 材质组控制台
   //   @ALink
   //   protected IRs3MaterialGroupConsole _materialGroupConsole;
   //
   //   // 模型控制台
   //   @ALink
   //   protected IRs3ModelConsole _modelConsole;
   //
   //   // 模型网格控制台
   //   @ALink
   //   protected IRs3ThemeConsole _themeConsole;
   //
   //   // 模型网格控制台
   //   @ALink
   //   protected IRs3MaterialConsole _materialConsole;
   //
   //   //============================================================
   //   // <T>构造资源模板控制台。</T>
   //   //============================================================
   //   public FRs3TemplateConsole(){
   //      super(FDataResourceTemplateLogic.class, FDataResourceTemplateUnit.class);
   //   }
   //
   //   //============================================================
   //   // <T>根据代码查找资源模板单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 资源模板单元
   //   //============================================================
   //   @Override
   //   public FDataResourceTemplateUnit findByCode(ILogicContext logicContext,
   //                                               String code){
   //      String sql = FDataResourceTemplateLogic.CODE + "='" + code + "'";
   //      FDataResourceTemplateLogic logic = logicContext.findLogic(FDataResourceTemplateLogic.class);
   //      FDataResourceTemplateUnit unit = logic.search(sql);
   //      return unit;
   //   }
   //
   //   //============================================================
   //   // <T>根据编号和代码查找材质组单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param templateId 模板编号
   //   // @param code 代码
   //   // @return 材质组单元
   //   //============================================================
   //   @Override
   //   public FDataResourceMaterialGroupUnit findMaterialGroupByCode(ILogicContext logicContext,
   //                                                                 long templateId,
   //                                                                 String code){
   //      String sql = FDataResourceTemplateMaterialGroupLogic.TEMPLATE_ID + "=" + templateId;
   //      FDataResourceTemplateMaterialGroupLogic logic = logicContext.findLogic(FDataResourceTemplateMaterialGroupLogic.class);
   //      FLogicDataset<FDataResourceTemplateMaterialGroupUnit> units = logic.fetch(sql);
   //      for(FDataResourceTemplateMaterialGroupUnit unit : units){
   //         FDataResourceMaterialGroupUnit materialGroupUnit = unit.materialGroup();
   //         if(materialGroupUnit.code().equals(code)){
   //            return materialGroupUnit;
   //         }
   //      }
   //      return null;
   //   }
   //
   //   //============================================================
   //   // <T>查找资源模板。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public FRs3Template findTemplate(ILogicContext logicContext,
   //                                    String guid,
   //                                    String code,
   //                                    String version){
   //      FRs3Template template = null;
   //      // 查找数据
   //      FDataResourceTemplateUnit templateUnit = null;
   //      if(!RString.isEmpty(guid)){
   //         templateUnit = findByGuid(logicContext, guid);
   //      }else if(!RString.isEmpty(code)){
   //         templateUnit = findByCode(logicContext, code);
   //      }else{
   //         throw new FFatalError("Find template failure. (guid={1}, code={2}, version={3})", guid, code, version);
   //      }
   //      // 生成配置
   //      if(templateUnit != null){
   //         // 读取配置
   //         FXmlDocument xdocument = new FXmlDocument();
   //         xdocument.loadString(templateUnit.content());
   //         // 读取内容
   //         template = new FRs3Template();
   //         template.loadConfig(xdocument.root());
   //      }
   //      return template;
   //   }
   //
   //   //============================================================
   //   // <T>生成资源模板。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public FRs3Template makeTemplate(ILogicContext logicContext,
   //                                    String guid){
   //      // 查找数据单元
   //      FDataResourceTemplateUnit templateUnit = findByGuid(logicContext, guid);
   //      if(templateUnit == null){
   //         return null;
   //      }
   //      // 读取内容
   //      FRs3Template template = new FRs3Template();
   //      template.loadUnit(templateUnit);
   //      //............................................................
   //      // 查找材质组
   //      FDataResourceTemplateMaterialGroupLogic templateMaterialGroupLogic = logicContext.findLogic(FDataResourceTemplateMaterialGroupLogic.class);
   //      String materialGroupSql = FDataResourceTemplateMaterialGroupLogic.TEMPLATE_ID + "=" + templateUnit.ouid();
   //      FLogicDataset<FDataResourceTemplateMaterialGroupUnit> groupDataset = templateMaterialGroupLogic.fetch(materialGroupSql);
   //      for(FDataResourceTemplateMaterialGroupUnit unit : groupDataset){
   //         FDataResourceMaterialGroupUnit materialGroup = unit.materialGroup();
   //         FRs3MaterialGroup group = new FRs3MaterialGroup();
   //         group.loadUnit(materialGroup);
   //         template.materialGroups().set(group.guid(), group);
   //      }
   //      //............................................................
   //      // 查找主题
   //      FDataResourceTemplateThemeLogic templateThemeLogic = logicContext.findLogic(FDataResourceTemplateThemeLogic.class);
   //      String themeSql = FDataResourceTemplateThemeLogic.TEMPLATE_ID + "=" + templateUnit.ouid();
   //      FLogicDataset<FDataResourceTemplateThemeUnit> themeDataset = templateThemeLogic.fetch(themeSql);
   //      for(FDataResourceTemplateThemeUnit unit : themeDataset){
   //         FDataResourceThemeUnit themeUnit = unit.theme();
   //         FRs3Theme theme = new FRs3Theme();
   //         theme.loadUnit(themeUnit);
   //         template.themes().push(theme);
   //         //............................................................
   //         // 查找材质
   //         FDataResourceMaterialLogic materialLogic = logicContext.findLogic(FDataResourceMaterialLogic.class);
   //         String materialSql = FDataResourceMaterialLogic.THEME_ID + "=" + themeUnit.ouid();
   //         FLogicDataset<FDataResourceMaterialUnit> materialDataset = materialLogic.fetch(materialSql);
   //         for(FDataResourceMaterialUnit materialUnit : materialDataset){
   //            FDataResourceMaterialGroupUnit materialGroup = materialUnit.materialGroup();
   //            FRs3Material material = new FRs3Material();
   //            material.loadUnit(materialUnit);
   //            material.setGroupGuid(materialGroup.guid());
   //            theme.materials().push(material);
   //            //............................................................
   //            // 查找纹理
   //            FDataResourceMaterialTextureLogic materialTextureLogic = logicContext.findLogic(FDataResourceMaterialTextureLogic.class);
   //            String materialTextureSql = FDataResourceMaterialTextureLogic.MATERIAL_ID + "=" + materialUnit.ouid();
   //            FLogicDataset<FDataResourceMaterialTextureUnit> materialTextureDataset = materialTextureLogic.fetch(materialTextureSql);
   //            for(FDataResourceMaterialTextureUnit materialTextureUnit : materialTextureDataset){
   //               FDataResourceTextureUnit textureUnit = materialTextureUnit.texture();
   //               FDataResourceTextureBitmapUnit textureBitmapUnit = materialTextureUnit.textureBitmap();
   //               FRs3MaterialTexture materialTexture = new FRs3MaterialTexture();
   //               materialTexture.loadUnit(materialTextureUnit);
   //               materialTexture.setTextureGuid(textureUnit.guid());
   //               materialTexture.setBitmapGuid(textureBitmapUnit.guid());
   //               material.textures().push(materialTexture);
   //            }
   //         }
   //      }
   //      return template;
   //   }
   //
   //   //============================================================
   //   // <T>生成资源模板。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public byte[] makeTemplateData(ILogicContext logicContext,
   //                                  String guid){
   //      // 查找数据
   //      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Cache3dTemplate, guid);
   //      if(findStorage != null){
   //         return findStorage.data();
   //      }
   //      //............................................................
   //      // 生成模型
   //      FRs3Template template = makeTemplate(logicContext, guid);
   //      // 获得数据
   //      FByteStream stream = new FByteStream();
   //      template.serialize(stream);
   //      // 压缩数据
   //      byte[] data = null;
   //      try(FCompressStream file = new FCompressStream(stream.toArray())){
   //         data = file.toCompressArray(ECompressMode.Lzma);
   //      }
   //      //............................................................
   //      // 存储数据
   //      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Cache3dTemplate, guid, EMime.Bin.type());
   //      storage.setCode(template.code());
   //      storage.setData(data);
   //      _storageConsole.store(storage);
   //      // 返回数据
   //      return data;
   //   }
   //
   //   //============================================================
   //   // <T>导入模板。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param fileName 文件名称
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public EResult importTemplate(ILogicContext logicContext,
   //                                 String fileName){
   //      // 获得配置
   //      _logger.debug(this, "importTemplate", "Import template. (file={1})", fileName);
   //      FXmlDocument xdocument = new FXmlDocument();
   //      xdocument.loadFile(fileName);
   //      FXmlNode xconfig = xdocument.root();
   //      // 获得纹理名称
   //      FRs3Template template = new FRs3Template();
   //      template.importConfig(xconfig);
   //      // 新建模板
   //      FDataResourceTemplateLogic templateLogic = logicContext.findLogic(FDataResourceTemplateLogic.class);
   //      FDataResourceTemplateUnit templateUnit = templateLogic.doPrepare();
   //      templateUnit.setCode(template.code());
   //      templateUnit.setFullCode(template.fullCode());
   //      templateUnit.setLabel(template.label());
   //      templateUnit.setKeywords(template.keywords());
   //      templateLogic.doInsert(templateUnit);
   //      template.setGuid(templateUnit.guid());
   //      // 修正材质组
   //      for(FRs3MaterialGroup materialGroup : template.materialGroups().toObjects()){
   //         // 新建材质组
   //         FDataResourceMaterialGroupUnit materialGroupUnit = _materialGroupConsole.insertMaterialGroup(logicContext, materialGroup);
   //         materialGroup.setOuid(materialGroupUnit.ouid());
   //         materialGroup.setGuid(materialGroupUnit.guid());
   //         // 关联模板和材质组
   //         FDataResourceTemplateMaterialGroupLogic templateMaterialGroupLogic = logicContext.findLogic(FDataResourceTemplateMaterialGroupLogic.class);
   //         FDataResourceTemplateMaterialGroupUnit templateMaterialGroupUnit = templateMaterialGroupLogic.doPrepare();
   //         templateMaterialGroupUnit.setTemplateId(templateUnit.ouid());
   //         templateMaterialGroupUnit.setMaterialGroupId(materialGroupUnit.ouid());
   //         templateMaterialGroupLogic.doInsert(templateMaterialGroupUnit);
   //      }
   //      // 修正材质数据
   //      for(FRs3Theme theme : template.themes()){
   //         // 新建主题
   //         FDataResourceThemeUnit themeUnit = _themeConsole.insert(logicContext, theme);
   //         theme.setGuid(themeUnit.guid());
   //         // 关联模板和主题
   //         FDataResourceTemplateThemeLogic templateThemeLogic = logicContext.findLogic(FDataResourceTemplateThemeLogic.class);
   //         FDataResourceTemplateThemeUnit templateThemeUnit = templateThemeLogic.doPrepare();
   //         templateThemeUnit.setTemplateId(templateUnit.ouid());
   //         templateThemeUnit.setThemeId(themeUnit.ouid());
   //         templateThemeLogic.doInsert(templateThemeUnit);
   //         // 新建材质
   //         for(FRs3Material material : theme.materials()){
   //            FRs3MaterialGroup materialGroup = template.syncMaterialGroup(material.code());
   //            material.setGroupGuid(materialGroup.guid());
   //            FDataResourceMaterialUnit materialUnit = _materialConsole.insertMaterial(logicContext, themeUnit.ouid(), materialGroup.ouid(), material);
   //            for(FRs3MaterialTexture materialTexture : material.textures()){
   //               _materialConsole.insertMaterialTexture(logicContext, materialUnit.ouid(), materialTexture);
   //            }
   //         }
   //      }
   //      // 修正显示数据
   //      for(FRs3Display display : template.displays()){
   //         // 设置模型唯一编号
   //         String modelCode = display.modelCode();
   //         FDataResourceModelUnit modelUnit = _modelConsole.findByCode(logicContext, modelCode);
   //         display.setModelGuid(modelUnit.guid());
   //         // 设置网格唯一编号
   //         String meshCode = display.meshCode();
   //         FDataResourceMeshUnit meshUnit = _modelConsole.findMeshByCode(logicContext, modelUnit.ouid(), meshCode);
   //         display.setMeshGuid(meshUnit.guid());
   //         // 修正材质
   //         for(FRs3DisplayMaterial material : display.materials()){
   //            String groupCode = material.code();
   //            FRs3MaterialGroup templateMaterial = template.syncMaterialGroup(groupCode);
   //            material.setGroupGuid(templateMaterial.guid());
   //         }
   //      }
   //      // 存储配置信息
   //      templateUnit = templateLogic.find(templateUnit.ouid());
   //      templateUnit.setContent(template.toXml());
   //      templateLogic.doUpdate(templateUnit);
   //      // 修正材质数据
   //      return EResult.Success;
   //   }
}
