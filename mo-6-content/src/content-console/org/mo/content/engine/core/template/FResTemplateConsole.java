package org.mo.content.engine.core.template;

import org.mo.cloud.core.storage.mongo.EGcStorageMongoCatalog;
import org.mo.cloud.core.storage.mongo.SGcMongoStorage;

import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.resource.template.FGcResTemplateConsole;
import org.mo.cloud.logic.data.resource.template.FGcResTemplateInfo;
import org.mo.cloud.logic.data.resource.template.FGcResTemplateMaterialInfo;
import org.mo.cloud.logic.data.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.data.resource.model.FGcResModelInfo;
import org.mo.cloud.logic.data.resource.material.FGcResMaterialBitmapInfo;
import org.mo.cloud.logic.data.resource.material.FGcResMaterialInfo;
import org.mo.cloud.logic.data.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.data.resource.FGcResourceInfo;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.engine.core.bitmap.IResBitmapConsole;
import org.mo.content.engine.core.material.IResMaterialBitmapConsole;
import org.mo.content.engine.core.material.IResMaterialConsole;
import org.mo.content.engine.core.model.IResModelConsole;
import org.mo.content.engine.core.model.IResModelMeshConsole;
import org.mo.content.resource.common.FResDisplay;
import org.mo.content.resource.common.FResMaterial;
import org.mo.content.resource.common.FResMaterialBitmap;
import org.mo.content.resource.common.FResRenderable;
import org.mo.content.resource.common.FResShape;
import org.mo.content.resource.template.FResTemplate;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.mime.compress.ECompressMode;
import org.mo.mime.compress.FCompressStream;

//============================================================
// <T>资源模板控制台。</T>
//============================================================
public class FResTemplateConsole
      extends FGcResTemplateConsole
      implements
         IResTemplateConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FResTemplateConsole.class);

   // 位图控制台
   @ALink
   protected IResBitmapConsole _bitmapConsole;

   // 模型网格控制台
   @ALink
   protected IResMaterialConsole _materialConsole;

   // 资源材质位图控制台
   @ALink
   protected IResMaterialBitmapConsole _materialBitmapConsole;

   // 资源模型控制台
   @ALink
   protected IResModelConsole _modelConsole;

   // 资源模型网格控制台
   @ALink
   protected IResModelMeshConsole _modelMeshConsole;

   // 资源模型网格控制台
   @ALink
   protected IResTemplateMaterialConsole _templateMaterialConsole;

   //============================================================
   // <T>生成资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param templateInfo 模板信息
   // @return 资源模板
   //============================================================
   @Override
   public FResTemplate makeTemplate(ILogicContext logicContext,
                                    FGcResTemplateInfo templateInfo){
      // 读取内容
      FResTemplate template = new FResTemplate();
      template.loadUnit(templateInfo);
      //      //............................................................
      //      // 查找主题
      //      FDataResourceTemplateThemeLogic templateThemeLogic = logicContext.findLogic(FDataResourceTemplateThemeLogic.class);
      //      String themeSql = FDataResourceTemplateThemeLogic.TEMPLATE_ID + "=" + templateInfo.ouid();
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
      return template;
   }

   //============================================================
   // <T>生成资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 资源模板
   //============================================================
   @Override
   public FResTemplate makeTemplate(ILogicContext logicContext,
                                    String guid){
      // 查找数据单元
      FGcResTemplateInfo templateInfo = findByGuid(logicContext, guid);
      if(templateInfo == null){
         return null;
      }
      // 读取内容
      return makeTemplate(logicContext, templateInfo);
   }

   //============================================================
   // <T>生成资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   @Override
   public byte[] makeTemplateData(ILogicContext logicContext,
                                  String guid){
      // 查找数据
      SGcMongoStorage findStorage = _storageConsole.find(EGcStorageMongoCatalog.CacheResourceTemplate, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      FResTemplate template = makeTemplate(logicContext, guid);
      // 获得数据
      FByteStream stream = new FByteStream();
      template.serialize(stream);
      // 压缩数据
      byte[] data = null;
      try(FCompressStream file = new FCompressStream(stream.toArray())){
         data = file.toCompressArray(ECompressMode.Lzma);
      }
      //............................................................
      // 存储数据
      SGcMongoStorage storage = new SGcMongoStorage(EGcStorageMongoCatalog.CacheResourceTemplate, guid);
      storage.setCode(template.code());
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }

   //============================================================
   // <T>更新模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param template 模板
   // @return 模板信息
   //============================================================
   @Override
   public FGcResTemplateInfo updateResource(ILogicContext logicContext,
                                            FResTemplate template){
      // 检查参数
      String guid = template.guid();
      if(RString.isEmpty(guid)){
         throw new FFatalError("Template guid is null.");
      }
      // 查找数据
      FGcResTemplateInfo templateInfo = findByGuid(logicContext, guid);
      if(templateInfo == null){
         throw new FFatalError("Template is not exists. (guid={1}})", guid);
      }
      long resourceId = templateInfo.resourceId();
      //............................................................
      // 检查材质
      if(template.hasMaterial()){
         for(FResMaterial material : template.materials()){
            String materialGuid = material.guid();
            FResMaterial findMaterial = _materialConsole.makeMaterial(logicContext, materialGuid);
            if(findMaterial == null){
               throw new FFatalError("Material is not exists. (guid={1})", materialGuid);
            }
            material.bitmaps(true).assign(findMaterial.bitmaps(true));
         }
      }
      //............................................................
      // 创建场景
      template.saveUnit(templateInfo);
      // 更新数据
      doUpdate(logicContext, templateInfo);
      //............................................................
      // 废弃临时数据
      FGcResourceInfo resource = _dataResourceConsole.get(logicContext, resourceId);
      _storageConsole.delete(EGcStorageMongoCatalog.CacheResourceTemplate, resource.guid());
      _dataResourceConsole.doUpdate(logicContext, resource);
      // 返回网格单元
      return templateInfo;
   }

   //============================================================
   // <T>导入模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   @Override
   public EResult importResource(ILogicContext logicContext,
                                 FGcSessionInfo session,
                                 String fileName){
      _logger.debug(this, "importResource", "Import template resource. (file={1})", fileName);
      long userId = session.userId();
      long projectId = session.projectId();
      // 获得配置
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadFile(fileName);
      FXmlNode xconfig = xdocument.root();
      // 获得纹理名称
      FResTemplate template = new FResTemplate();
      template.importConfig(xconfig);
      String templateCode = template.code();
      //............................................................
      // 删除旧数据
      FGcResTemplateInfo templateInfo = findByUserCode(logicContext, userId, templateCode);
      if(templateInfo != null){
         doDelete(logicContext, templateInfo);
      }
      //............................................................
      // 新建模板
      templateInfo = doPrepare(logicContext);
      templateInfo.setUserId(userId);
      templateInfo.setProjectId(projectId);
      templateInfo.setFullCode(template.fullCode());
      templateInfo.setCode(templateCode);
      templateInfo.setLabel(template.label());
      templateInfo.setKeywords(template.keywords());
      doInsert(logicContext, templateInfo);
      template.setGuid(templateInfo.guid());
      //............................................................
      // 修正材质数据
      if(template.hasMaterial()){
         for(FResMaterial material : template.materials()){
            // 新建材质
            FGcResMaterialInfo materialInfo = _materialConsole.doPrepare(logicContext);
            materialInfo.setUserId(userId);
            materialInfo.setProjectId(projectId);
            _materialConsole.doInsert(logicContext, materialInfo);
            if(material.hasBitmap()){
               for(FResMaterialBitmap materialBitmap : material.bitmaps()){
                  String fullCode = materialBitmap.fullCode();
                  FGcResBitmapInfo bitmapInfo = _bitmapConsole.findByUserFullCode(logicContext, userId, fullCode);
                  materialBitmap.setBitmapGuid(bitmapInfo.guid());
                  // 新建材质位图
                  FGcResMaterialBitmapInfo materialBitmapInfo = _materialBitmapConsole.doPrepare(logicContext);
                  materialBitmapInfo.setUserId(userId);
                  materialBitmapInfo.setProjectId(projectId);
                  materialBitmapInfo.setMaterialId(materialInfo.ouid());
                  materialBitmapInfo.setBitmapId(bitmapInfo.ouid());
                  materialBitmap.saveUnit(materialBitmapInfo);
                  _materialBitmapConsole.doInsert(logicContext, materialBitmapInfo);
               }
            }
            material.setGuid(materialInfo.guid());
            material.saveUnit(materialInfo);
            _materialConsole.doUpdate(logicContext, materialInfo);
            // 新建材质关联
            FGcResTemplateMaterialInfo templateMaterialInfo = _templateMaterialConsole.doPrepare(logicContext);
            templateMaterialInfo.setUserId(userId);
            templateMaterialInfo.setProjectId(projectId);
            templateMaterialInfo.setTemplateId(templateInfo.ouid());
            templateMaterialInfo.setMaterialId(materialInfo.ouid());
            templateMaterialInfo.setCode(materialInfo.code());
            _templateMaterialConsole.doInsert(logicContext, templateMaterialInfo);
         }
      }
      //............................................................
      // 修正显示数据
      if(template.hasDisplay()){
         for(FResDisplay display : template.displays()){
            if(display.hasRenderable()){
               for(FResRenderable renderable : display.renderables()){
                  if(renderable instanceof FResShape){
                     FResShape shape = (FResShape)renderable;
                     // 查找模型
                     String modelCode = shape.modelCode();
                     FGcResModelInfo modelInfo = _modelConsole.findByUserCode(logicContext, userId, modelCode);
                     long modelId = modelInfo.ouid();
                     shape.setModelGuid(modelInfo.guid());
                     // 查找网格
                     String meshCode = shape.meshCode();
                     FGcResModelMeshInfo meshInfo = _modelMeshConsole.findByUserModelCode(logicContext, userId, modelId, meshCode);
                     shape.setCode(meshCode);
                     shape.setLabel(meshInfo.label());
                     shape.setMeshGuid(meshInfo.guid());
                     // 查找材质
                     String materialCode = shape.materialCode();
                     FResMaterial material = template.findMaterialByCode(materialCode);
                     shape.setMaterialGuid(material.guid());
                  }
               }
            }
         }
      }
      //............................................................
      // 存储配置信息
      templateInfo.setContent(template.toXml());
      doUpdate(logicContext, templateInfo);
      return EResult.Success;
   }
}
