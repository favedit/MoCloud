package org.mo.content.service.resource.scene;

import org.mo.cloud.logic.data.system.FGcSessionInfo;

import org.mo.cloud.logic.data.solution.FGcProjectInfo;
import org.mo.cloud.logic.data.resource.template.FGcResTemplateInfo;
import org.mo.cloud.logic.data.resource.scene.FGcResSceneInfo;
import com.cyou.gccloud.data.data.FDataResourceSceneLogic;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource.scene.ICntSceneConsole;
import org.mo.content.core.resource.template.ICntTemplateConsole;
import org.mo.content.core.solution.project.ICntProjectConsole;
import org.mo.content.resource.common.FResComponent;
import org.mo.content.resource.common.FResDisplay;
import org.mo.content.resource.common.FResDisplayContainer;
import org.mo.content.resource.common.FResDisplayLayer;
import org.mo.content.resource.common.FResMovie;
import org.mo.content.resource.common.FResObject;
import org.mo.content.resource.common.FResSprite;
import org.mo.content.resource.scene.FResScene;
import org.mo.content.resource.scene.FResSceneDisplay;
import org.mo.content.resource.scene.FResSceneLayer;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D场景服务。</T>
//============================================================
public class FSceneService
      extends FObject
      implements
         ISceneService
{
   // 模板控制台接口
   @ALink
   protected ICntTemplateConsole _templateConsole;

   // 场景控制台接口
   @ALink
   protected ICntSceneConsole _sceneConsole;

   // 项目控制台接口
   @ALink
   protected ICntProjectConsole _projectConsole;

   //============================================================
   // <T>构造资源3D场景服务。</T>
   //============================================================
   public FSceneService(){
   }

   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult list(IWebContext context,
                       ILogicContext logicContext,
                       FGcSessionInfo session,
                       IWebInput input,
                       IWebOutput output){
      // 检查参数
      String projectGuid = context.parameter("project_guid");
      if(RString.isEmpty(projectGuid)){
         throw new FFatalError("Project guid is empty.");
      }
      long userId = session.userId();
      //............................................................
      // 获得项目
      FGcProjectInfo project = _projectConsole.getByGuid(logicContext, projectGuid);
      long projectId = project.ouid();
      //............................................................
      // 生成查询脚本
      String whereSql = "(" + FDataResourceSceneLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResourceSceneLogic.PROJECT_ID + "=" + projectId + ")";
      String orderBy = FDataResourceSceneLogic.CODE + " ASC";
      // 查询数据
      FLogicDataset<FGcResSceneInfo> dataset = _sceneConsole.fetch(logicContext, whereSql, orderBy);
      // 设置输出节点
      FXmlNode xoutput = output.config().createNode("SceneCollection");
      for(FGcResSceneInfo scene : dataset){
         FXmlNode xscene = xoutput.createNode("Scene");
         xscene.set("guid", scene.guid());
         xscene.set("code", scene.code());
         xscene.set("label", scene.label());
         xscene.set("update_date", scene.updateDate());
      }
      return EResult.Success;
   }

   //============================================================
   // <T>查询数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        ILogicContext logicContext,
                        FGcSessionInfo session,
                        IWebInput input,
                        IWebOutput output){
      //      String guid = context.parameter("guid");
      //      String code = context.parameter("code");
      //      String themeCode = context.parameter("theme");
      //      //............................................................
      //      // 查找场景
      //      FDataResourceSceneUnit sceneUnit = _sceneConsole.findSceneUnit(logicContext, guid, code);
      //      if(sceneUnit != null){
      //         // 查找主题
      //         FDataResourceSceneThemeUnit themeUnit = _sceneConsole.findThemeUnit(logicContext, sceneUnit.ouid(), themeCode);
      //         if(themeUnit != null){
      //            // 生成数据
      //            FRs3Scene scene = _sceneConsole.makeTheme(logicContext, themeUnit.guid());
      //            if(scene != null){
      //               FXmlNode xconfig = output.config().createNode("Scene");
      //               scene.saveConfig(xconfig);
      //            }
      //         }
      //      }
      return EResult.Success;
   }

   //============================================================
   // <T>创建数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult create(IWebContext context,
                         ILogicContext logicContext,
                         FGcSessionInfo session,
                         IWebInput input,
                         IWebOutput output){
      // 获得参数
      FXmlNode xscene = input.config().findNode("Scene");
      if(xscene == null){
         throw new FFatalError("Scene config is not exists.");
      }
      String projectGuid = xscene.get("project_guid", null);
      //if(RString.isEmpty(projectGuid)){
      //throw new FFatalError("Project guid is empty.");
      //}
      String code = xscene.get("code", null);
      if(RString.isEmpty(code)){
         throw new FFatalError("Code is empty.");
      }
      String label = xscene.get("label", null);
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      // 查找项目
      long projectId = 0;
      if(!RString.isEmpty(projectGuid)){
         FGcProjectInfo findProject = _projectConsole.findByGuid(logicContext, projectGuid);
         if(findProject == null){
            throw new FFatalError("Project is not exists. (guid={1})", projectGuid);
         }
         projectId = findProject.ouid();
      }
      // 查找场景
      long userId = session.userId();
      FGcResSceneInfo findSceneInfo = _sceneConsole.findByUserCode(logicContext, userId, projectId, code);
      if(findSceneInfo != null){
         throw new FFatalError("Scene code is duplicate. (user_id={1}, project_id={2}, code={3})", userId, projectId, code);
      }
      // 新建场景
      FResScene scene = new FResScene();
      scene.setCode(code);
      scene.setLabel(label);
      // 新建处理
      FGcResSceneInfo sceneInfo = _sceneConsole.doPrepare(logicContext);
      sceneInfo.setUserId(session.userId());
      sceneInfo.setProjectId(projectId);
      scene.saveUnit(sceneInfo);
      _sceneConsole.doInsert(logicContext, sceneInfo);
      return EResult.Success;
   }

   //============================================================
   // <T>创建相机处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult createCamera(IWebContext context,
                               ILogicContext logicContext,
                               FGcSessionInfo session,
                               IWebInput input,
                               IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>创建显示层处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult createLayer(IWebContext context,
                              ILogicContext logicContext,
                              FGcSessionInfo session,
                              IWebInput input,
                              IWebOutput output){
      long userId = session.userId();
      // 获得参数
      FXmlNode xlayer = input.config().findNode("Layer");
      if(xlayer == null){
         throw new FFatalError("Layer is empty.");
      }
      String spaceGuid = xlayer.get("space_guid", null);
      if(RString.isEmpty(spaceGuid)){
         throw new FFatalError("Space guid is empty.");
      }
      String code = xlayer.get("code", null);
      if(RString.isEmpty(code)){
         throw new FFatalError("Code is empty.");
      }
      String label = xlayer.get("label", null);
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      //............................................................
      // 查找项目
      FGcResSceneInfo sceneInfo = _sceneConsole.findByGuid(logicContext, spaceGuid);
      if(sceneInfo == null){
         throw new FFatalError("Scene is not exists. (guid={1})", sceneInfo);
      }
      // 检查用户有效
      if(sceneInfo.userId() != userId){
         throw new FFatalError("Scene user is invalid. (scene_user_id={1}, session_user_id={2})", sceneInfo.userId(), userId);
      }
      FResScene scene = _sceneConsole.makeScene(logicContext, sceneInfo);
      // 创建显示层
      FResSceneLayer layer = new FResSceneLayer();
      layer.setCode(code);
      layer.setLabel(label);
      scene.pushLayer(layer);
      //............................................................
      // 更新处理
      _sceneConsole.updateResource(logicContext, scene);
      return EResult.Success;
   }

   //============================================================
   // <T>创建精灵处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult createSprite(IWebContext context,
                               ILogicContext logicContext,
                               FGcSessionInfo session,
                               IWebInput input,
                               IWebOutput output){
      long userId = session.userId();
      // 获得参数
      FXmlNode xsprite = input.config().findNode("Sprite");
      if(xsprite == null){
         throw new FFatalError("Sprite is empty.");
      }
      String spaceGuid = xsprite.get("space_guid", null);
      if(RString.isEmpty(spaceGuid)){
         throw new FFatalError("Space guid is empty.");
      }
      String layerGuid = xsprite.get("layer_guid", null);
      if(RString.isEmpty(layerGuid)){
         throw new FFatalError("Layer guid is empty.");
      }
      String displayGuid = xsprite.get("display_guid", null);
      String code = xsprite.get("code", null);
      String label = xsprite.get("label", null);
      String templateGuid = xsprite.get("template_guid", null);
      String templateCode = xsprite.get("template_code", null);
      if(RString.isEmpty(templateGuid) && RString.isEmpty(templateCode)){
         throw new FFatalError("Template guid and code is empty.");
      }
      //............................................................
      // 查找项目
      FGcResSceneInfo sceneInfo = _sceneConsole.findByGuid(logicContext, spaceGuid);
      if(sceneInfo == null){
         throw new FFatalError("Scene is not exists. (guid={1})", sceneInfo);
      }
      FResScene scene = _sceneConsole.makeScene(logicContext, sceneInfo);
      // 查找模板
      FGcResTemplateInfo templateInfo = null;
      if(!RString.isEmpty(templateGuid)){
         templateInfo = _templateConsole.findByGuid(logicContext, templateGuid);
      }else{
         templateInfo = _templateConsole.findByUserCode(logicContext, userId, templateCode);
      }
      if(templateInfo == null){
         throw new FFatalError("Template is not exists. (code={1})", templateCode);
      }
      if(RString.isEmpty(code)){
         code = templateInfo.code();
      }
      if(RString.isEmpty(label)){
         label = templateInfo.label();
      }
      // 创建显示对象
      FResSceneDisplay sprite = new FResSceneDisplay();
      sprite.setCode(code);
      sprite.setLabel(label);
      sprite.setTemplateGuid(templateInfo.guid());
      // 增加显示对象
      FResDisplayLayer layer = scene.findLayerByGuid(layerGuid);
      if(RString.isEmpty(displayGuid)){
         layer.pushDisplay(sprite);
      }else{
         FResDisplay display = layer.searchDisplayByGuid(displayGuid);
         if(display instanceof FResSprite){
            ((FResSprite)display).pushDisplay(sprite);
         }
      }
      //............................................................
      // 更新处理
      _sceneConsole.updateResource(logicContext, scene);
      return EResult.Success;
   }

   //============================================================
   // <T>创建动画处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult createMovie(IWebContext context,
                              ILogicContext logicContext,
                              FGcSessionInfo session,
                              IWebInput input,
                              IWebOutput output){
      // 获得参数
      FXmlNode xsprite = input.config().findNode("Movie");
      if(xsprite == null){
         throw new FFatalError("Sprite is empty.");
      }
      String spaceGuid = xsprite.get("space_guid", null);
      if(RString.isEmpty(spaceGuid)){
         throw new FFatalError("Space guid is empty.");
      }
      String layerGuid = xsprite.get("layer_guid", null);
      if(RString.isEmpty(layerGuid)){
         throw new FFatalError("Layer guid is empty.");
      }
      String displayGuid = xsprite.get("display_guid", null);
      String code = xsprite.get("code", null);
      String label = xsprite.get("label", null);
      String interval = xsprite.get("interval", null);
      String rotation = xsprite.get("rotation", null);
      if(RString.isEmpty(interval) || RString.isEmpty(rotation)){
         throw new FFatalError("Interval or rotation is empty.");
      }
      //............................................................
      // 查找项目
      FGcResSceneInfo sceneInfo = _sceneConsole.findByGuid(logicContext, spaceGuid);
      if(sceneInfo == null){
         throw new FFatalError("Scene is not exists. (guid={1})", sceneInfo);
      }
      FResScene scene = _sceneConsole.makeScene(logicContext, sceneInfo);
      FResDisplayLayer layer = scene.findLayerByGuid(layerGuid);
      FResDisplay display = layer.searchDisplayByGuid(displayGuid);
      if(display == null){
         throw new FFatalError("Display is not exists.");
      }
      FResSceneDisplay sprite = (FResSceneDisplay)display;
      // 创建动画对象
      FResMovie movie = new FResMovie();
      movie.setCode(code);
      movie.setLabel(label);
      movie.setInterval(RInteger.parse(interval));
      movie.rotation().parse(rotation);
      sprite.pushMovie(movie);
      //............................................................
      // 更新处理
      _sceneConsole.updateResource(logicContext, scene);
      return EResult.Success;
   }

   //============================================================
   // <T>复制场景节点处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult copyNode(IWebContext context,
                           ILogicContext logicContext,
                           FGcSessionInfo session,
                           IWebInput input,
                           IWebOutput output){
      // 获得参数
      String spaceGuid = context.parameter("space_guid");
      if(RString.isEmpty(spaceGuid)){
         throw new FFatalError("Space guid is empty.");
      }
      String nodeGuid = context.parameter("node_guid");
      if(RString.isEmpty(nodeGuid)){
         throw new FFatalError("Node guid is empty.");
      }
      //............................................................
      // 查找项目
      FGcResSceneInfo sceneInfo = _sceneConsole.findByGuid(logicContext, spaceGuid);
      if(sceneInfo == null){
         throw new FFatalError("Scene is not exists. (guid={1})", spaceGuid);
      }
      FResScene scene = _sceneConsole.makeScene(logicContext, sceneInfo);
      // 查找模板
      FResObject findObject = scene.searchByGuid(nodeGuid);
      if(findObject == null){
         throw new FFatalError("Node guid is not found. (code={1})", nodeGuid);
      }
      if(findObject instanceof FResSceneDisplay){
         FResSceneDisplay display = (FResSceneDisplay)findObject;
         FResComponent parent = display.parent();
         if(parent instanceof FResDisplayContainer){
            FResDisplayContainer container = (FResDisplayContainer)parent;
            int index = container.displays().indexOf(display);
            FResSceneDisplay createDisplay = new FResSceneDisplay();
            createDisplay.assignInfo(display);
            container.displays().insert(createDisplay, index + 1);
         }else{
            throw new FFatalError("Unknown node parent.");
         }
      }else{
         throw new FFatalError("Unknown node type.");
      }
      //............................................................
      // 更新处理
      _sceneConsole.updateResource(logicContext, scene);
      return EResult.Success;
   }

   //============================================================
   // <T>修改数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult upate(IWebContext context,
                        ILogicContext logicContext,
                        FGcSessionInfo session,
                        IWebInput input,
                        IWebOutput output){
      // 获得参数
      FXmlNode xinput = input.config();
      String guid = xinput.nodeText("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Scene guid is empty.");
      }
      String code = xinput.nodeText("Code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Code is empty.");
      }
      String label = xinput.nodeText("Label");
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      // 查找数据
      FGcResSceneInfo sceneInfo = _sceneConsole.findByGuid(logicContext, guid);
      if(sceneInfo == null){
         throw new FFatalError("Scene is not exists. (guid={1})", guid);
      }
      // 检查用户有效
      if(sceneInfo.userId() != session.userId()){
         throw new FFatalError("Scene user is invalid. (scene_user_id={1}, session_user_id={2})", sceneInfo.userId(), session.userId());
      }
      // 更新数据
      if(code != null){
         sceneInfo.setCode(code);
      }
      if(label != null){
         sceneInfo.setLabel(label);
      }
      _sceneConsole.doUpdate(logicContext, sceneInfo);
      return EResult.Success;
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult updateContent(IWebContext context,
                                ILogicContext logicContext,
                                FGcSessionInfo session,
                                IWebInput input,
                                IWebOutput output){
      // 检查输入
      FXmlNode xscene = input.config();
      if(!xscene.isName("Scene")){
         throw new FFatalError("Invalid config code.");
      }
      // 获得场景
      String guid = xscene.get("guid");
      FResScene scene = _sceneConsole.makeScene(logicContext, guid);
      // 合并场景
      scene.mergeConfig(xscene);
      // 更新场景
      _sceneConsole.updateResource(logicContext, scene);
      return EResult.Success;
   }

   //============================================================
   // <T>删除数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult delete(IWebContext context,
                         ILogicContext logicContext,
                         FGcSessionInfo session,
                         IWebInput input,
                         IWebOutput output){
      // 获得参数
      FXmlNode xinput = input.config();
      String guid = xinput.nodeText("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Scene guid is empty.");
      }
      // 查找数据
      FGcResSceneInfo scene = _sceneConsole.findByGuid(logicContext, guid);
      if(scene == null){
         throw new FFatalError("Scene is not exists. (guid={1})", guid);
      }
      // 检查用户有效
      if(scene.userId() != session.userId()){
         throw new FFatalError("Scene user is invalid. (scene_user_id={1}, session_user_id={2})", scene.userId(), session.userId());
      }
      // 删除数据
      _sceneConsole.doDelete(logicContext, scene);
      return EResult.Success;
   }

   //============================================================
   // <T>删除场景节点处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult deleteNode(IWebContext context,
                             ILogicContext logicContext,
                             FGcSessionInfo session,
                             IWebInput input,
                             IWebOutput output){
      // 获得参数
      String spaceGuid = context.parameter("space_guid");
      if(RString.isEmpty(spaceGuid)){
         throw new FFatalError("Space guid is empty.");
      }
      String nodeGuid = context.parameter("node_guid");
      if(RString.isEmpty(nodeGuid)){
         throw new FFatalError("Node guid is empty.");
      }
      //............................................................
      // 查找项目
      FGcResSceneInfo sceneInfo = _sceneConsole.findByGuid(logicContext, spaceGuid);
      if(sceneInfo == null){
         throw new FFatalError("Scene is not exists. (guid={1})", spaceGuid);
      }
      FResScene scene = _sceneConsole.makeScene(logicContext, sceneInfo);
      // 查找模板
      FResObject findObject = scene.searchByGuid(nodeGuid);
      if(findObject == null){
         throw new FFatalError("Node guid is not found. (code={1})", nodeGuid);
      }
      if(findObject instanceof FResSceneDisplay){
         FResSceneDisplay display = (FResSceneDisplay)findObject;
         FResComponent parent = display.parent();
         if(parent instanceof FResDisplayContainer){
            FResDisplayContainer container = (FResDisplayContainer)parent;
            container.removeDisplay(display);
         }else{
            throw new FFatalError("Unknown node parent.");
         }
      }else{
         throw new FFatalError("Unknown node type.");
      }
      //............................................................
      // 更新处理
      _sceneConsole.updateResource(logicContext, scene);
      return EResult.Success;
   }
}
