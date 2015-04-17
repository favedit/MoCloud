package org.mo.content.service.resource.scene;

import com.cyou.gccloud.data.data.FDataResourceSceneLogic;
import org.mo.cloud.logic.resource.scene.FGcResSceneInfo;
import org.mo.cloud.logic.solution.FGcProjectInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource.scene.ICntSceneConsole;
import org.mo.content.core.solution.project.ICntProjectConsole;
import org.mo.content.resource3d.scene.FRs3Scene;
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
   // 项目控制台接口
   @ALink
   protected ICntProjectConsole _projectConsole;

   // 场景控制台接口
   @ALink
   protected ICntSceneConsole _sceneConsole;

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
   // <T>新建数据处理。</T>
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
      String projectGuid = xscene.get("project_guid", null);
      if(RString.isEmpty(projectGuid)){
         throw new FFatalError("Project guid is empty.");
      }
      String code = xscene.get("code", null);
      if(RString.isEmpty(code)){
         throw new FFatalError("Code is empty.");
      }
      String label = xscene.get("label", null);
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      // 查找项目
      FGcProjectInfo findProject = _projectConsole.findByGuid(logicContext, projectGuid);
      if(findProject == null){
         throw new FFatalError("Project is not exists. (guid={1})", projectGuid);
      }
      long projectId = findProject.ouid();
      // 查找场景
      long userId = session.userId();
      FGcResSceneInfo findScene = _sceneConsole.findByCode(logicContext, userId, projectId, code);
      if(findScene != null){
         throw new FFatalError("Scene code is duplicate. (user_id={1}, project_id={2}, code={3})", userId, projectId, code);
      }
      // 新建处理
      FGcResSceneInfo scene = _sceneConsole.doPrepare(logicContext);
      scene.setUserId(session.userId());
      scene.setProjectId(projectId);
      scene.setCode(code);
      scene.setLabel(label);
      _sceneConsole.doInsert(logicContext, scene);
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
      FGcResSceneInfo scene = _sceneConsole.findByGuid(logicContext, guid);
      if(scene == null){
         throw new FFatalError("Scene is not exists. (guid={1})", guid);
      }
      // 检查用户有效
      if(scene.userId() != session.userId()){
         throw new FFatalError("Scene user is invalid. (scene_user_id={1}, session_user_id={2})", scene.userId(), session.userId());
      }
      // 更新数据
      if(code != null){
         scene.setCode(code);
      }
      if(label != null){
         scene.setLabel(label);
      }
      _sceneConsole.doUpdate(logicContext, scene);
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
      FRs3Scene scene = _sceneConsole.makeScene(logicContext, guid);
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
}
