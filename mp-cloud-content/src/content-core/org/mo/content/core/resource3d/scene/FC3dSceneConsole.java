package org.mo.content.core.resource3d.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneLogic;
import com.cyou.gccloud.data.data.FDataResource3dSceneThemeLogic;
import com.cyou.gccloud.data.data.FDataResource3dSceneThemeUnit;
import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import com.cyou.gccloud.data.data.FDataResource3dTemplateUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.content.engine3d.core.template.IRs3TemplateConsole;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.content.resource3d.scene.FRs3SceneDisplay;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>场景控制台。</T>
//============================================================
public class FC3dSceneConsole
      extends FAbstractLogicUnitConsole<FDataResource3dSceneLogic, FDataResource3dSceneUnit>
      implements
         IC3dSceneConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 模板控制台
   @ALink
   protected IRs3TemplateConsole _templateConsole;

   //============================================================
   // <T>构造场景控制台。</T>
   //============================================================
   public FC3dSceneConsole(){
      super(FDataResource3dSceneLogic.class, FDataResource3dSceneUnit.class);
   }

   //============================================================
   // <T>根据代码查找模板单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 模板单元
   //============================================================
   public FDataResource3dSceneUnit findByCode(ILogicContext logicContext,
                                              String code){
      String sql = FDataResource3dSceneLogic.CODE + "='" + code + "'";
      FDataResource3dSceneLogic logic = logicContext.findLogic(FDataResource3dSceneLogic.class);
      FDataResource3dSceneUnit unit = logic.search(sql);
      return unit;
   }

   //============================================================
   // <T>根据代码查找模板单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 模板单元
   //============================================================
   public FDataResource3dSceneThemeUnit findThemeByCode(ILogicContext logicContext,
                                                        long sceneId,
                                                        String code){
      String sql = "(" + FDataResource3dSceneThemeLogic.SCENE_ID + "=" + sceneId + ") AND (" + FDataResource3dSceneThemeLogic.CODE + "='" + code + "')";
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
   public FRs3Scene makeSceneTheme(ILogicContext logicContext,
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
      return scene;
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
   public FRs3Scene makeScene(ILogicContext logicContext,
                              String guid,
                              String code,
                              String themeCode){
      // 设置变量
      themeCode = RString.nvl(themeCode, "general");
      // 查找场景单元
      FDataResource3dSceneUnit sceneUnit = null;
      if(!RString.isEmpty(guid)){
         sceneUnit = findByGuid(logicContext, guid);
      }else if(!RString.isEmpty(code)){
         sceneUnit = findByCode(logicContext, code);
      }else{
         throw new FFatalError("Find scene failure. (guid={1}, code={2})", guid, code);
      }
      if(sceneUnit == null){
         throw new FFatalError("Scene is not exists. (guid={1}, code={2})", guid, code);
      }
      // 查找主题单元
      FDataResource3dSceneThemeUnit themeUnit = findThemeByCode(logicContext, sceneUnit.ouid(), themeCode);
      if(themeUnit == null){
         throw new FFatalError("Scene theme is not exists. (guid={1}, code={2}, theme={3})", guid, code, themeCode);
      }
      // 创建场景
      FRs3Scene scene = new FRs3Scene();
      scene.loadSceneUnit(sceneUnit);
      scene.loadThemeUnit(themeUnit);
      return scene;
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
   public byte[] makeSceneData(ILogicContext logicContext,
                               String guid,
                               String code,
                               String themeCode){
      // 查找唯一编号
      if(RString.isEmpty(guid)){
         FDataResource3dSceneUnit sceneUnit = findByCode(logicContext, code);
         if(sceneUnit == null){
            return null;
         }
         guid = sceneUnit.guid();
      }
      //............................................................
      // 查找数据
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Resource3dSceneTheme, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      FRs3Scene scene = makeScene(logicContext, guid, code, themeCode);
      // 获得数据
      FByteStream stream = new FByteStream();
      scene.serialize(stream);
      byte[] data = stream.toArray();
      // 存储数据
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Resource3dSceneTheme, guid, "bin");
      storage.setCode(scene.code());
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }

   //============================================================
   // <T>更新场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param scene 场景
   //============================================================
   @Override
   public EResult updateScene(ILogicContext logicContext,
                              FRs3Scene scene){
      // 检查参数
      String guid = scene.guid();
      if(RString.isEmpty(guid)){
         throw new FFatalError("Find scene guid is empty. (guid={1}})", guid);
      }
      // 查找数据
      FDataResource3dSceneThemeLogic themeLogic = logicContext.findLogic(FDataResource3dSceneThemeLogic.class);
      FDataResource3dSceneThemeUnit themeUnit = themeLogic.findByGuid(guid);
      if(themeUnit == null){
         throw new FFatalError("Find scene is not exists. (guid={1}})", guid);
      }
      // 创建场景
      scene.saveThemeUnit(themeUnit);
      // 修正数据
      FObjects<FRs3SceneDisplay> displays = scene.filterDisplays();
      for(FRs3SceneDisplay display : displays){
         String displayLabel = display.label();
         if(RString.isEmpty(displayLabel)){
            String templateGuid = display.templateGuid();
            FDataResource3dTemplateUnit templateUnit = _templateConsole.findByGuid(logicContext, templateGuid);
            display.setLabel(templateUnit.label());
         }
      }
      // 更新数据
      themeLogic.doUpdate(themeUnit);
      // 返回结果
      return EResult.Success;
   }

   //============================================================
   // <T>更新场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param scene 场景
   //============================================================
   @Override
   public EResult updateSceneTheme(ILogicContext logicContext,
                                   FRs3Scene scene){
      // 检查参数
      String themeGuid = scene.themeGuid();
      if(RString.isEmpty(themeGuid)){
         throw new FFatalError("Scene theme guid is null.");
      }
      // 查找数据
      FDataResource3dSceneThemeLogic themeLogic = logicContext.findLogic(FDataResource3dSceneThemeLogic.class);
      FDataResource3dSceneThemeUnit themeUnit = themeLogic.findByGuid(themeGuid);
      if(themeUnit == null){
         throw new FFatalError("Scene theme is not exists. (guid={1}})", themeGuid);
      }
      // 创建场景
      scene.saveThemeUnit(themeUnit);
      // 修正数据
      FObjects<FRs3SceneDisplay> displays = scene.filterDisplays();
      for(FRs3SceneDisplay display : displays){
         String displayLabel = display.label();
         if(RString.isEmpty(displayLabel)){
            String templateGuid = display.templateGuid();
            FDataResource3dTemplateUnit templateUnit = _templateConsole.findByGuid(logicContext, templateGuid);
            display.setLabel(templateUnit.label());
         }
      }
      // 更新数据
      themeLogic.doUpdate(themeUnit);
      // 返回结果
      return EResult.Success;
   }
}
