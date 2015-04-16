package org.mo.content.engine3d.core.template;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.resource.model.FGcResModelInfo;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.template.FGcResTemplateConsole;
import org.mo.cloud.logic.resource.template.FGcResTemplateInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.engine3d.core.bitmap.IRs3BitmapConsole;
import org.mo.content.engine3d.core.material.IRs3MaterialConsole;
import org.mo.content.engine3d.core.model.IRs3ModelConsole;
import org.mo.content.engine3d.core.model.IRs3ModelMeshConsole;
import org.mo.content.resource3d.common.FRs3Display;
import org.mo.content.resource3d.common.FRs3Material;
import org.mo.content.resource3d.common.FRs3MaterialBitmap;
import org.mo.content.resource3d.common.FRs3Renderable;
import org.mo.content.resource3d.common.FRs3Shape;
import org.mo.content.resource3d.template.FRs3Template;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.mime.compress.ECompressMode;
import org.mo.mime.compress.FCompressStream;

//============================================================
// <T>资源模板控制台。</T>
//============================================================
public class FRs3TemplateConsole
      extends FGcResTemplateConsole
      implements
         IRs3TemplateConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FRs3TemplateConsole.class);

   // 位图控制台
   @ALink
   protected IRs3BitmapConsole _bitmapConsole;

   // 模型网格控制台
   @ALink
   protected IRs3MaterialConsole _materialConsole;

   // 资源模型控制台
   @ALink
   protected IRs3ModelConsole _modelConsole;

   // 资源模型网格控制台
   @ALink
   protected IRs3ModelMeshConsole _modelMeshConsole;

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

   //============================================================
   // <T>生成资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   @Override
   public FRs3Template makeTemplate(ILogicContext logicContext,
                                    String guid){
      // 查找数据单元
      FGcResTemplateInfo templateInfo = findByGuid(logicContext, guid);
      if(templateInfo == null){
         return null;
      }
      // 读取内容
      FRs3Template template = new FRs3Template();
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
   // @return 处理结果
   //============================================================
   @Override
   public byte[] makeTemplateData(ILogicContext logicContext,
                                  String guid){
      // 查找数据
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.CacheResourceTemplate, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      FRs3Template template = makeTemplate(logicContext, guid);
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
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.CacheResourceTemplate, guid);
      storage.setCode(template.code());
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
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
      // 获得配置
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadFile(fileName);
      FXmlNode xconfig = xdocument.root();
      // 获得纹理名称
      FRs3Template template = new FRs3Template();
      template.importConfig(xconfig);
      String templateCode = template.code();
      //............................................................
      // 删除旧数据
      FGcResTemplateInfo templateInfo = findByCode(logicContext, userId, templateCode);
      if(templateInfo != null){
         doDelete(logicContext, templateInfo);
      }
      //............................................................
      // 新建模板
      templateInfo = doPrepare(logicContext);
      templateInfo.setUserId(userId);
      templateInfo.setProjectId(session.projectId());
      templateInfo.setFullCode(template.fullCode());
      templateInfo.setCode(templateCode);
      templateInfo.setLabel(template.label());
      templateInfo.setKeywords(template.keywords());
      doInsert(logicContext, templateInfo);
      template.setGuid(templateInfo.guid());
      //............................................................
      // 修正材质数据
      if(template.hasMaterial()){
         for(FRs3Material material : template.materials()){
            if(material.hasBitmap()){
               for(FRs3MaterialBitmap materialBitmap : material.bitmaps()){
                  String fullCode = materialBitmap.fullCode();
                  FGcResBitmapInfo bitmapInfo = _bitmapConsole.findByUserFullCode(logicContext, userId, fullCode);
                  materialBitmap.setBitmapGuid(bitmapInfo.guid());
               }
            }
         }
      }
      //............................................................
      // 修正显示数据
      if(template.hasDisplay()){
         for(FRs3Display display : template.displays()){
            if(display.hasRenderable()){
               for(FRs3Renderable renderable : display.renderables()){
                  if(renderable instanceof FRs3Shape){
                     FRs3Shape shape = (FRs3Shape)renderable;
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
                     FRs3Material material = template.findMaterialByCode(materialCode);
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
