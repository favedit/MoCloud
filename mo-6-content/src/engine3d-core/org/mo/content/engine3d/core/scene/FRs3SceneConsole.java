package org.mo.content.engine3d.core.scene;

import com.cyou.gccloud.data.data.FDataResource3dMaterialGroupUnit;
import com.cyou.gccloud.data.data.FDataResource3dSceneLogic;
import com.cyou.gccloud.data.data.FDataResource3dSceneThemeLogic;
import com.cyou.gccloud.data.data.FDataResource3dSceneThemeUnit;
import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import com.cyou.gccloud.data.data.FDataResource3dTemplateUnit;
import java.io.File;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource3d.scene.FGcRs3SceneConsole;
import org.mo.com.io.FByteStream;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.net.EMime;
import org.mo.content.engine3d.core.template.IRs3TemplateConsole;
import org.mo.content.engine3d.core.texture.IRs3TextureConsole;
import org.mo.content.resource3d.common.FRs3Material;
import org.mo.content.resource3d.common.FRs3MaterialTexture;
import org.mo.content.resource3d.common.FRs3Theme;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.content.resource3d.scene.FRs3SceneDisplay;
import org.mo.content.resource3d.scene.FRs3SceneMaterial;
import org.mo.content.resource3d.template.FRs3Template;
import org.mo.content.resource3d.texture.FRs3Texture;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.mime.compress.ECompressMode;
import org.mo.mime.compress.FCompressStream;

//============================================================
// <T>资源场景控制台。</T>
//============================================================
public class FRs3SceneConsole
      extends FGcRs3SceneConsole
      implements
         IRs3SceneConsole
{
   // 资源纹理控制台
   @ALink
   protected IRs3TextureConsole _textureConsole;

   // 资源模板控制台
   @ALink
   protected IRs3TemplateConsole _templateConsole;

   //============================================================
   // <T>根据代码查找场景单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FDataResource3dSceneUnit findByCode(ILogicContext logicContext,
                                              String code){
      String searchSql = FDataResource3dSceneLogic.CODE + "='" + code + "'";
      FDataResource3dSceneLogic logic = logicContext.findLogic(FDataResource3dSceneLogic.class);
      FDataResource3dSceneUnit unit = logic.search(searchSql);
      return unit;
   }

   //============================================================
   // <T>查找场景单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 场景唯一编码
   // @param code 场景代码
   // @return 场景单元
   //============================================================
   @Override
   public FDataResource3dSceneUnit findSceneUnit(ILogicContext logicContext,
                                                 String guid,
                                                 String code){
      FDataResource3dSceneUnit unit = null;
      // 根据唯一编号查找
      if(!RString.isEmpty(guid)){
         FDataResource3dSceneLogic logic = logicContext.findLogic(FDataResource3dSceneLogic.class);
         unit = logic.findByGuid(guid);
      }
      // 根据唯一编号查找
      else if(!RString.isEmpty(code)){
         unit = findByCode(logicContext, code);
      }
      return unit;
   }

   //============================================================
   // <T>查找场景主题单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param sceneId 场景编码
   // @param themeCode 主题代码
   // @return 场景主题单元
   //============================================================
   @Override
   public FDataResource3dSceneThemeUnit findThemeUnit(ILogicContext logicContext,
                                                      long sceneId,
                                                      String themeCode){
      String sql = "(" + FDataResource3dSceneThemeLogic.SCENE_ID + "=" + sceneId + ") AND (" + FDataResource3dSceneThemeLogic.CODE + "='" + themeCode + "')";
      FDataResource3dSceneThemeLogic logic = logicContext.findLogic(FDataResource3dSceneThemeLogic.class);
      FDataResource3dSceneThemeUnit unit = logic.search(sql);
      return unit;
   }

   //============================================================
   // <T>生成场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param version 版本
   // @return 场景
   //============================================================
   @Override
   public FRs3Scene makeTheme(ILogicContext logicContext,
                              String guid){
      // 检查参数
      if(RString.isEmpty(guid)){
         throw new FFatalError("Scene theme guid is null.");
      }
      // 查找信息
      FDataResource3dSceneThemeLogic themeLogic = logicContext.findLogic(FDataResource3dSceneThemeLogic.class);
      FDataResource3dSceneThemeUnit themeUnit = themeLogic.findByGuid(guid);
      if(themeUnit == null){
         throw new FFatalError("Scene theme is not exists. (guid={1})", guid);
      }
      FDataResource3dSceneUnit sceneUnit = themeUnit.scene();
      if(sceneUnit == null){
         throw new FFatalError("Scene is not exists. (theme_guid={1})", guid);
      }
      // 创建场景
      FRs3Scene scene = new FRs3Scene();
      scene.loadSceneUnit(sceneUnit);
      scene.loadThemeUnit(themeUnit);
      // 生成纹理数据
      FDictionary<FRs3Texture> textures = scene.textures();
      FDictionary<FRs3Template> templates = scene.templates();
      FObjects<FRs3SceneDisplay> displays = scene.filterDisplays();
      for(FRs3SceneDisplay display : displays){
         String templateGuid = display.templateGuid();
         // 查找模板
         FRs3Template template = _templateConsole.makeTemplate(logicContext, templateGuid);
         templates.set(template.guid(), template);
         // 查找材质
         FRs3Theme theme = template.themes().first();
         for(FRs3SceneMaterial sceneMaterial : display.materials()){
            String materialGroupGuid = sceneMaterial.groupGuid();
            FRs3Material material = theme.findMaterialByGroupGuid(materialGroupGuid);
            // 查找纹理
            for(FRs3MaterialTexture materialTexture : material.textures()){
               String textureGuid = materialTexture.textureGuid();
               if(!textures.contains(textureGuid)){
                  byte[] data = _textureConsole.makeTextureData(logicContext, textureGuid, false);
                  FRs3Texture texture = new FRs3Texture();
                  texture.setData(data);
                  textures.set(textureGuid, texture);
               }
            }
         }
      }
      return scene;
   }

   //============================================================
   // <T>生成场景主题。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编码
   // @return 场景主题
   //============================================================
   @Override
   public byte[] makeThemeData(ILogicContext logicContext,
                               String guid){
      // 查找数据
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Cache3dSceneTheme, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      FRs3Scene scene = makeTheme(logicContext, guid);
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
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Cache3dSceneTheme, guid, EMime.Bin.type());
      storage.setCode(scene.code());
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }

   //============================================================
   // <T>导入场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param input 输入流
   // @return 处理结果
   //============================================================
   @Override
   public EResult importScene(ILogicContext logicContext,
                              String filePath){
      // 获得名称
      String code = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
      //............................................................
      // 新建场景
      FDataResource3dSceneLogic sceneLogic = logicContext.findLogic(FDataResource3dSceneLogic.class);
      FDataResource3dSceneUnit sceneUnit = sceneLogic.doPrepare();
      sceneUnit.setCode(code);
      sceneLogic.doInsert(sceneUnit);
      //............................................................
      // 获得所有文件
      for(String fileName : RFile.listFiles(filePath)){
         String themeCode = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
         if(!themeCode.endsWith(".ser")){
            continue;
         }
         themeCode = themeCode.substring(0, themeCode.length() - 4);
         //............................................................
         // 加载模型资源
         FRs3Scene scene = new FRs3Scene();
         scene.loadFile(fileName);
         //............................................................
         // 关联显示集合
         FObjects<FRs3SceneDisplay> displays = scene.filterDisplays();
         for(FRs3SceneDisplay display : displays){
            String displayCode = display.code();
            FDataResource3dTemplateUnit templateUnit = _templateConsole.findByCode(logicContext, displayCode);
            if(templateUnit == null){
               throw new FFatalError("Template unit is not exists. (code={1})", displayCode);
            }
            display.setTemplateGuid(templateUnit.guid());
            // 关联材质集合
            if(display.hasMaterial()){
               for(FRs3SceneMaterial material : display.materials()){
                  FDataResource3dMaterialGroupUnit materialGroupUnit = _templateConsole.findMaterialGroupByCode(logicContext, templateUnit.ouid(), material.code());
                  if(materialGroupUnit == null){
                     throw new FFatalError("Material group is not exists. (code={1})", material.code());
                  }
                  material.setGroupGuid(materialGroupUnit.guid());
               }
            }
         }
         //............................................................
         // 新建场景主题
         FDataResource3dSceneThemeLogic sceneThemeLogic = logicContext.findLogic(FDataResource3dSceneThemeLogic.class);
         FDataResource3dSceneThemeUnit sceneThemeUnit = sceneThemeLogic.doPrepare();
         sceneThemeUnit.setSceneId(sceneUnit.ouid());
         scene.setGuid(sceneThemeUnit.guid());
         scene.saveThemeUnit(sceneThemeUnit);
         sceneThemeUnit.setCode(themeCode);
         sceneThemeUnit.setFullCode(scene.code() + "|" + themeCode);
         sceneThemeLogic.doInsert(sceneThemeUnit);
         // 设置信息
         sceneUnit.setFullCode(scene.fullCode());
         sceneUnit.setLabel(scene.label());
         sceneUnit.setKeywords(scene.keywords());
      }
      sceneLogic.doUpdate(sceneUnit);
      return EResult.Success;
   }
}
