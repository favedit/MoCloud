package org.mo.content.engine3d.core.scene;

import java.io.File;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.scene.FGcResSceneConsole;
import org.mo.cloud.logic.resource.scene.FGcResSceneInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.io.FByteStream;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.data.logic.ILogicContext;
import org.mo.mime.compress.ECompressMode;
import org.mo.mime.compress.FCompressStream;

//============================================================
// <T>资源场景控制台。</T>
//============================================================
public class FRs3SceneConsole
      extends FGcResSceneConsole
      implements
         IRs3SceneConsole
{
   //   // 资源纹理控制台
   //   @ALink
   //   protected IRs3TextureConsole _textureConsole;
   //
   //   // 资源模板控制台
   //   @ALink
   //   protected IRs3TemplateConsole _templateConsole;
   //
   //   //============================================================
   //   // <T>根据代码查找场景单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public FDataResource3dSceneUnit findByCode(ILogicContext logicContext,
   //                                              String code){
   //      String searchSql = FDataResource3dSceneLogic.CODE + "='" + code + "'";
   //      FDataResource3dSceneLogic logic = logicContext.findLogic(FDataResource3dSceneLogic.class);
   //      FDataResource3dSceneUnit unit = logic.search(searchSql);
   //      return unit;
   //   }
   //
   //   //============================================================
   //   // <T>查找场景单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 场景唯一编码
   //   // @param code 场景代码
   //   // @return 场景单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dSceneUnit findSceneUnit(ILogicContext logicContext,
   //                                                 String guid,
   //                                                 String code){
   //      FDataResource3dSceneUnit unit = null;
   //      // 根据唯一编号查找
   //      if(!RString.isEmpty(guid)){
   //         FDataResource3dSceneLogic logic = logicContext.findLogic(FDataResource3dSceneLogic.class);
   //         unit = logic.findByGuid(guid);
   //      }
   //      // 根据唯一编号查找
   //      else if(!RString.isEmpty(code)){
   //         unit = findByCode(logicContext, code);
   //      }
   //      return unit;
   //   }
   //
   //   //============================================================
   //   // <T>查找场景主题单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param sceneId 场景编码
   //   // @param themeCode 主题代码
   //   // @return 场景主题单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dSceneThemeUnit findThemeUnit(ILogicContext logicContext,
   //                                                      long sceneId,
   //                                                      String themeCode){
   //      String sql = "(" + FDataResource3dSceneThemeLogic.SCENE_ID + "=" + sceneId + ") AND (" + FDataResource3dSceneThemeLogic.CODE + "='" + themeCode + "')";
   //      FDataResource3dSceneThemeLogic logic = logicContext.findLogic(FDataResource3dSceneThemeLogic.class);
   //      FDataResource3dSceneThemeUnit unit = logic.search(sql);
   //      return unit;
   //   }

   //============================================================
   // <T>生成场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param sceneLogic 场景信息
   // @return 场景
   //============================================================
   @Override
   public FRs3Scene makeScene(ILogicContext logicContext,
                              FGcResSceneInfo sceneLogic){
      // 创建场景
      FRs3Scene scene = new FRs3Scene();
      scene.loadUnit(sceneLogic);
      //      // 生成纹理数据
      //      FDictionary<FRs3Texture> textures = scene.textures();
      //      FDictionary<FRs3Template> templates = scene.templates();
      //      FObjects<FRs3SceneDisplay> displays = scene.filterDisplays();
      //      for(FRs3SceneDisplay display : displays){
      //         String templateGuid = display.templateGuid();
      //         // 查找模板
      //         FRs3Template template = _templateConsole.makeTemplate(logicContext, templateGuid);
      //         templates.set(template.guid(), template);
      //         // 查找材质
      //         FRs3Theme theme = template.themes().first();
      //         for(FRs3SceneMaterial sceneMaterial : display.materials()){
      //            String materialGroupGuid = sceneMaterial.groupGuid();
      //            FRs3Material material = theme.findMaterialByGroupGuid(materialGroupGuid);
      //            // 查找纹理
      //            for(FRs3MaterialTexture materialTexture : material.textures()){
      //               String textureGuid = materialTexture.textureGuid();
      //               if(!textures.contains(textureGuid)){
      //                  byte[] data = _textureConsole.makeTextureData(logicContext, textureGuid, false);
      //                  FRs3Texture texture = new FRs3Texture();
      //                  texture.setData(data);
      //                  textures.set(textureGuid, texture);
      //               }
      //            }
      //         }
      //      }
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
   public FRs3Scene makeScene(ILogicContext logicContext,
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
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.CacheResourceScene, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      FRs3Scene scene = makeScene(logicContext, guid);
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
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.CacheResourceScene, guid);
      storage.setCode(scene.code());
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
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
      String themeCode = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
      themeCode = themeCode.substring(0, themeCode.length() - 4);
      //............................................................
      // 加载模型资源
      FRs3Scene scene = new FRs3Scene();
      scene.loadFile(fileName);
      //............................................................
      // 新建场景
      FGcResSceneInfo sceneInfo = findByCode(logicContext, userId, code);
      if(sceneInfo == null){
         sceneInfo = doPrepare(logicContext);
         sceneInfo.setUserId(userId);
         sceneInfo.setProjectId(session.projectId());
         sceneInfo.setCode(code);
         doInsert(logicContext, sceneInfo);
      }
      //............................................................
      // 关联显示集合
      //      FObjects<FRs3SceneDisplay> displays = scene.filterDisplays();
      //      for(FRs3SceneDisplay display : displays){
      //         String displayCode = display.code();
      //         FDataResource3dTemplateUnit templateUnit = _templateConsole.findByCode(logicContext, displayCode);
      //         if(templateUnit == null){
      //            throw new FFatalError("Template unit is not exists. (code={1})", displayCode);
      //         }
      //         display.setTemplateGuid(templateUnit.guid());
      //         // 关联材质集合
      //         if(display.hasMaterial()){
      //            for(FRs3SceneMaterial material : display.materials()){
      //               FDataResource3dMaterialGroupUnit materialGroupUnit = _templateConsole.findMaterialGroupByCode(logicContext, templateUnit.ouid(), material.code());
      //               if(materialGroupUnit == null){
      //                  throw new FFatalError("Material group is not exists. (code={1})", material.code());
      //               }
      //               material.setGroupGuid(materialGroupUnit.guid());
      //            }
      //         }
      //      }
      //............................................................
      // 新建场景主题
      scene.setGuid(sceneInfo.guid());
      scene.saveUnit(sceneInfo);
      // 设置信息
      sceneInfo.setFullCode(scene.fullCode());
      sceneInfo.setLabel(scene.label());
      sceneInfo.setKeywords(scene.keywords());
      doUpdate(logicContext, sceneInfo);
      return EResult.Success;
   }
}
