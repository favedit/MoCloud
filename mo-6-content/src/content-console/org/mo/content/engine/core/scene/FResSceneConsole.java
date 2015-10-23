package org.mo.content.engine.core.scene;

import org.mo.cloud.core.storage.mongo.EGcStorageMongoCatalog;
import org.mo.cloud.core.storage.mongo.SGcMongoStorage;

import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.resource.template.FGcResTemplateInfo;
import org.mo.cloud.logic.data.resource.template.FGcResTemplateMaterialInfo;
import org.mo.cloud.logic.data.resource.scene.FGcResSceneConsole;
import org.mo.cloud.logic.data.resource.scene.FGcResSceneInfo;
import org.mo.cloud.logic.data.resource.material.FGcResMaterialInfo;
import org.mo.cloud.logic.data.resource.FGcResourceInfo;
import java.io.File;
import org.mo.com.io.FByteStream;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.content.engine.core.material.IResMaterialConsole;
import org.mo.content.engine.core.template.IResTemplateConsole;
import org.mo.content.engine.core.template.IResTemplateMaterialConsole;
import org.mo.content.resource.common.FResDisplay;
import org.mo.content.resource.common.FResMaterial;
import org.mo.content.resource.scene.FResScene;
import org.mo.content.resource.scene.FResSceneDisplay;
import org.mo.content.resource.template.FResTemplate;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.mime.compress.ECompressMode;
import org.mo.mime.compress.FCompressStream;

//============================================================
// <T>资源场景控制台。</T>
//============================================================
public class FResSceneConsole
      extends FGcResSceneConsole
      implements
         IResSceneConsole
{
   // 材质模板控制台
   @ALink
   protected IResMaterialConsole _materialConsole;

   // 资源模板控制台
   @ALink
   protected IResTemplateConsole _templateConsole;

   // 资源模板材质控制台
   @ALink
   protected IResTemplateMaterialConsole _templateMaterialConsole;

   //============================================================
   // <T>生成场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param sceneLogic 场景信息
   // @return 场景
   //============================================================
   @Override
   public FResScene makeScene(ILogicContext logicContext,
                              FGcResSceneInfo sceneLogic){
      // 创建场景
      FResScene scene = new FResScene();
      scene.loadUnit(sceneLogic);
      return scene;
   }

   //============================================================
   // <T>生成场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编码
   // @return 场景
   //============================================================
   @Override
   public FResScene makeScene(ILogicContext logicContext,
                              String guid){
      // 检查参数
      if(RString.isEmpty(guid)){
         throw new FFatalError("Scene theme guid is null.");
      }
      // 查找信息
      FGcResSceneInfo sceneLogic = findByGuid(logicContext, guid);
      if(sceneLogic == null){
         throw new FFatalError("Scene theme is not exists. (guid={1})", guid);
      }
      return makeScene(logicContext, sceneLogic);
   }

   //============================================================
   // <T>生成场景主题。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编码
   // @return 场景主题
   //============================================================
   @Override
   public byte[] makeSceneData(ILogicContext logicContext,
                               String guid){
      // 查找数据
      SGcMongoStorage findStorage = _storageConsole.find(EGcStorageMongoCatalog.CacheResourceScene, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      FResScene scene = makeScene(logicContext, guid);
      // 获得数据
      FByteStream stream = new FByteStream();
      scene.serialize(stream);
      // 压缩数据
      byte[] data = null;
      try(FCompressStream file = new FCompressStream(stream.toArray())){
         data = file.toCompressArray(ECompressMode.Lzma);
      }
      //............................................................
      // 存储数据
      SGcMongoStorage storage = new SGcMongoStorage(EGcStorageMongoCatalog.CacheResourceScene, guid);
      storage.setCode(scene.code());
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }

   //============================================================
   // <T>更新场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param scene 场景
   // @return 场景信息
   //============================================================
   @Override
   public FGcResSceneInfo updateResource(ILogicContext logicContext,
                                         FResScene scene){
      // 检查参数
      String guid = scene.guid();
      if(RString.isEmpty(guid)){
         throw new FFatalError("Scene guid is null.");
      }
      // 查找数据
      FGcResSceneInfo sceneInfo = findByGuid(logicContext, guid);
      if(sceneInfo == null){
         throw new FFatalError("Scene is not exists. (guid={1}})", guid);
      }
      long resourceId = sceneInfo.resourceId();
      //............................................................
      // 矫正材质
      FObjects<FResDisplay> displays = scene.filterDisplays();
      for(FResDisplay display : displays){
         if(display instanceof FResSceneDisplay){
            FResSceneDisplay sceneDisplay = (FResSceneDisplay)display;
            // 查找模板
            String templateGuid = sceneDisplay.templateGuid();
            if(RString.isEmpty(templateGuid)){
               continue;
            }
            FResTemplate template = _templateConsole.makeTemplate(logicContext, templateGuid);
            if(template == null){
               throw new FFatalError("Template is not exists.");
            }
            // 检查材质
            if(template.hasMaterial()){
               FObjects<FResMaterial> materials = new FObjects<FResMaterial>(FResMaterial.class);
               for(FResMaterial material : template.materials()){
                  // 根据模板修正材质列表
                  String materialGuid = material.makeGuid();
                  FResMaterial displayMaterial = sceneDisplay.findMaterialByParentGuid(materialGuid);
                  if(displayMaterial == null){
                     displayMaterial = new FResMaterial();
                     displayMaterial.setParentGuid(materialGuid);
                     displayMaterial.assignInfo(material);
                     materials.push(displayMaterial);
                  }else{
                     materials.push(displayMaterial);
                  }
                  // 修正材质参数
                  if(RString.isEmpty(displayMaterial.code()) || RString.isEmpty(displayMaterial.label())){
                     FGcResMaterialInfo materialInfo = _materialConsole.findByGuid(logicContext, materialGuid);
                     if(RString.isEmpty(displayMaterial.code())){
                        displayMaterial.setCode(materialInfo.code());
                     }
                     if(RString.isEmpty(displayMaterial.label())){
                        displayMaterial.setLabel(materialInfo.label());
                     }
                  }
               }
               sceneDisplay.setMaterials(materials);
            }else{
               sceneDisplay.clearMaterials();
            }
         }
      }
      //............................................................
      // 更新数据
      scene.saveUnit(sceneInfo);
      doUpdate(logicContext, sceneInfo);
      //............................................................
      // 废弃临时数据
      FGcResourceInfo resource = _dataResourceConsole.get(logicContext, resourceId);
      _storageConsole.delete(EGcStorageMongoCatalog.CacheResourceScene, resource.guid());
      _dataResourceConsole.doUpdate(logicContext, resource);
      // 返回场景信息
      return sceneInfo;
   }

   //============================================================
   // <T>导入资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   @Override
   public EResult importResource(ILogicContext logicContext,
                                 FGcSessionInfo session,
                                 String filePath){
      // 获得名称
      long userId = session.userId();
      String code = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
      //............................................................
      // 获得首个配置文件
      String fileName = null;
      for(String findName : RFile.listFiles(filePath)){
         if(findName.endsWith(".ser")){
            fileName = findName;
            break;
         }
      }
      //............................................................
      // 加载模型资源
      FResScene scene = new FResScene();
      scene.loadFile(fileName);
      //............................................................
      // 关联显示集合
      FObjects<FResDisplay> displays = scene.filterDisplays();
      for(FResDisplay display : displays){
         if(display instanceof FResSceneDisplay){
            FResSceneDisplay sceneDisplay = (FResSceneDisplay)display;
            String displayCode = sceneDisplay.code();
            FGcResTemplateInfo templateInfo = _templateConsole.findByUserCode(logicContext, userId, displayCode);
            if(templateInfo == null){
               throw new FFatalError("Template info is not exists. (code={1})", displayCode);
            }
            long templateId = templateInfo.ouid();
            sceneDisplay.setTemplateGuid(templateInfo.guid());
            // 关联材质集合
            if(sceneDisplay.hasMaterial()){
               for(FResMaterial material : sceneDisplay.materials()){
                  String materialCode = material.code();
                  FGcResTemplateMaterialInfo templateMaterialInfo = _templateMaterialConsole.findByCode(logicContext, userId, templateId, materialCode);
                  if(templateMaterialInfo == null){
                     throw new FFatalError("Template material is not exists. (code={1})", materialCode);
                  }
                  String materialGuid = templateMaterialInfo.material().guid();
                  material.setParentGuid(materialGuid);
               }
            }
         }
      }
      //............................................................
      // 新建场景
      FGcResSceneInfo sceneInfo = null;
      FGcResSceneInfo findSceneInfo = findByUserCode(logicContext, userId, code);
      if(findSceneInfo == null){
         sceneInfo = doPrepare(logicContext);
      }else{
         sceneInfo = findSceneInfo;
      }
      sceneInfo.setUserId(userId);
      sceneInfo.setProjectId(session.projectId());
      sceneInfo.setFullCode(scene.fullCode());
      sceneInfo.setCode(code);
      sceneInfo.setLabel(scene.label());
      sceneInfo.setKeywords(scene.keywords());
      if(findSceneInfo == null){
         doInsert(logicContext, sceneInfo);
         scene.setGuid(sceneInfo.guid());
      }
      //............................................................
      // 新建场景主题
      scene.saveUnit(sceneInfo);
      // 设置信息
      doUpdate(logicContext, sceneInfo);
      return EResult.Success;
   }
}
