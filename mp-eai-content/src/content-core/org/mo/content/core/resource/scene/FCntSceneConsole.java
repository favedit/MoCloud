package org.mo.content.core.resource.scene;

import org.mo.cloud.logic.data.resource.scene.FGcResSceneInfo;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.content.engine.core.scene.FResSceneConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容场景控制台。</T>
//============================================================
public class FCntSceneConsole
      extends FResSceneConsole
      implements
         ICntSceneConsole
{
   //============================================================
   // <T>构造场景控制台。</T>
   //============================================================
   public FCntSceneConsole(){
   }

   //============================================================
   // <T>根据资源编号删除场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param resourceId 资源编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDeleteByResourceId(ILogicContext logicContext,
                                       long userId,
                                       long resourceId){
      // 获得场景
      FGcResSceneInfo sceneInfo = findByResourceId(logicContext, resourceId);
      if(sceneInfo == null){
         throw new FFatalError("Scene is not exists. (resource_id={1})", resourceId);
      }
      // 检查用户
      if(sceneInfo.userId() != userId){
         throw new FFatalError("Scene user is not same. (model_user_id={1}, session_user_id={2})", sceneInfo.userId(), userId);
      }
      // 删除关联资源对象
      doDelete(logicContext, sceneInfo);
      return EResult.Success;
   }

   //   //============================================================
   //   // <T>根据代码查找模板单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 模板单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dSceneUnit findByCode(ILogicContext logicContext,
   //                                              String code){
   //      String sql = FDataResource3dSceneLogic.CODE + "='" + code + "'";
   //      FDataResource3dSceneLogic logic = logicContext.findLogic(FDataResource3dSceneLogic.class);
   //      FDataResource3dSceneUnit unit = logic.search(sql);
   //      return unit;
   //   }
   //
   //   //============================================================
   //   // <T>获取数据处理。</T>
   //   //
   //   // @param context 逻辑环境
   //   // @param xoutput 输出内容
   //   // @param serach 搜索内容
   //   // @param pageSize 页面大小
   //   // @param page 页面编号
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public EResult fetch(ILogicContext context,
   //                        FXmlNode xoutput,
   //                        String serach,
   //                        int pageSize,
   //                        int page){
   //      // 生成查询脚本
   //      String whereSql = null;
   //      if(!RString.isEmpty(serach)){
   //         whereSql = FDataResource3dSceneLogic.FULL_CODE + " LIKE '%" + serach + "%'";
   //      }
   //      // 查询数据
   //      FDataResource3dSceneLogic logic = context.findLogic(FDataResource3dSceneLogic.class);
   //      FLogicDataset<FDataResource3dSceneUnit> dataset = logic.fetch(whereSql, pageSize, page);
   //      xoutput.set("total", dataset.total());
   //      xoutput.set("count", dataset.count());
   //      xoutput.set("page_size", dataset.pageSize());
   //      xoutput.set("page_count", dataset.pageCount());
   //      xoutput.set("page", dataset.page());
   //      for(FDataResource3dSceneUnit unit : dataset){
   //         FXmlNode xitem = xoutput.createNode("Item");
   //         xitem.set("guid", unit.guid());
   //         xitem.set("type", "scene");
   //         xitem.set("code", unit.fullCode());
   //         xitem.set("label", unit.label());
   //      }
   //      return EResult.Success;
   //   }
   //
   //   //============================================================
   //   // <T>更新场景。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param scene 场景
   //   //============================================================
   //   @Override
   //   public EResult updateScene(ILogicContext logicContext,
   //                              FRs3Scene scene){
   //      // 检查参数
   //      String guid = scene.guid();
   //      if(RString.isEmpty(guid)){
   //         throw new FFatalError("Find scene guid is empty. (guid={1}})", guid);
   //      }
   //      // 查找数据
   //      FDataResource3dSceneThemeLogic themeLogic = logicContext.findLogic(FDataResource3dSceneThemeLogic.class);
   //      FDataResource3dSceneThemeUnit themeUnit = themeLogic.findByGuid(guid);
   //      if(themeUnit == null){
   //         throw new FFatalError("Find scene is not exists. (guid={1}})", guid);
   //      }
   //      // 创建场景
   //      scene.saveThemeUnit(themeUnit);
   //      // 修正数据
   //      FObjects<FRs3SceneDisplay> displays = scene.filterDisplays();
   //      for(FRs3SceneDisplay display : displays){
   //         String displayLabel = display.label();
   //         if(RString.isEmpty(displayLabel)){
   //            String templateGuid = display.templateGuid();
   //            FDataResource3dTemplateUnit templateUnit = _templateConsole.findByGuid(logicContext, templateGuid);
   //            display.setLabel(templateUnit.label());
   //         }
   //      }
   //      // 更新数据
   //      themeLogic.doUpdate(themeUnit);
   //      // 返回结果
   //      return EResult.Success;
   //   }
   //
   //   //============================================================
   //   // <T>更新场景。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param scene 场景
   //   //============================================================
   //   @Override
   //   public EResult updateSceneTheme(ILogicContext logicContext,
   //                                   FRs3Scene scene){
   //      // 检查参数
   //      String themeGuid = scene.themeGuid();
   //      if(RString.isEmpty(themeGuid)){
   //         throw new FFatalError("Scene theme guid is null.");
   //      }
   //      // 查找数据
   //      FDataResource3dSceneThemeLogic themeLogic = logicContext.findLogic(FDataResource3dSceneThemeLogic.class);
   //      FDataResource3dSceneThemeUnit themeUnit = themeLogic.findByGuid(themeGuid);
   //      if(themeUnit == null){
   //         throw new FFatalError("Scene theme is not exists. (guid={1}})", themeGuid);
   //      }
   //      // 创建场景
   //      scene.saveThemeUnit(themeUnit);
   //      // 修正数据
   //      FObjects<FRs3SceneDisplay> displays = scene.filterDisplays();
   //      for(FRs3SceneDisplay display : displays){
   //         String displayLabel = display.label();
   //         if(RString.isEmpty(displayLabel)){
   //            String templateGuid = display.templateGuid();
   //            FDataResource3dTemplateUnit templateUnit = _templateConsole.findByGuid(logicContext, templateGuid);
   //            display.setLabel(templateUnit.label());
   //         }
   //      }
   //      // 更新数据
   //      themeLogic.doUpdate(themeUnit);
   //      //............................................................
   //      // 废弃临时数据
   //      _storageConsole.delete(EGcStorageCatalog.Cache3dSceneTheme, themeGuid);
   //      // 返回结果
   //      return EResult.Success;
   //   }
}
