package org.mo.content.service.solution;

import com.cyou.gccloud.data.data.FDataResourceSceneLogic;
import com.cyou.gccloud.data.data.FDataSolutionProjectLogic;
import com.cyou.gccloud.data.data.FDataSolutionProjectUnit;
import org.mo.cloud.logic.data.resource.scene.FGcResSceneInfo;
import org.mo.cloud.logic.data.solution.FGcProjectInfo;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource.scene.ICntSceneConsole;
import org.mo.content.core.solution.project.ICntProjectConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D服务。</T>
//============================================================
public class FProjectService
      extends FObject
      implements
         IProjectService
{
   // 项目控制台接口
   @ALink
   protected ICntProjectConsole _projectConsole;

   // 场景控制台接口
   @ALink
   protected ICntSceneConsole _sceneConsole;

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FProjectService(){
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
      FXmlNode xinput = input.config();
      String search = xinput.nodeText("Search");
      String order = xinput.nodeText("Order");
      int pageSize = RInteger.toRange(xinput.nodeTextAsInt("PageSize", 20), 0, 200);
      int page = xinput.nodeTextAsInt("Page", 0);
      // 设置输出节点
      FXmlNode xoutput = output.config().createNode("ProjectCollection");
      xoutput.set("page_count", 0);
      xoutput.set("page_size", pageSize);
      xoutput.set("page", page);
      //............................................................
      // 生成查询脚本
      String whereSql = "(" + FDataSolutionProjectLogic.USER_ID + "=" + session.userId() + ")";
      if(!RString.isEmpty(search)){
         whereSql += " AND (" + FDataSolutionProjectLogic.CODE + " LIKE '%" + RSql.formatValue(search) + "%')";
      }
      // 查询数据
      FLogicDataset<FGcProjectInfo> dataset = _projectConsole.fetch(logicContext, whereSql, order, pageSize, page);
      xoutput.set("total", dataset.total());
      xoutput.set("count", dataset.count());
      xoutput.set("page_size", dataset.pageSize());
      xoutput.set("page_count", dataset.pageCount());
      xoutput.set("page", dataset.page());
      for(FGcProjectInfo unit : dataset){
         FXmlNode xitem = xoutput.createNode("Project");
         xitem.set("guid", unit.guid());
         xitem.set("code", unit.code());
         xitem.set("label", unit.label());
      }
      return EResult.Success;
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
   public EResult listProject(IWebContext context,
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
      // 检查参数
      FXmlNode xinput = input.config();
      String guid = xinput.nodeText("Guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Guid is empty.");
      }
      // 获得数据
      FDataSolutionProjectUnit project = _projectConsole.findByGuid(logicContext, guid);
      if(project == null){
         return EResult.Failure;
      }
      // 检查用户
      if(project.userId() != session.userId()){
         throw new FFatalError("Project user is invalid. (project_user_id={1}, session_user_id={2})", project.userId(), session.userId());
      }
      // 设置输出
      FXmlNode xproject = output.config().createNode("Project");
      xproject.set("guid", project.guid());
      xproject.set("code", project.code());
      xproject.set("label", project.label());
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
      FXmlNode xproject = input.config().findNode("Project");
      String code = xproject.get("code", null);
      if(RString.isEmpty(code)){
         throw new FFatalError("Code is empty.");
      }
      String label = xproject.get("label", null);
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      // 查找数据
      FGcProjectInfo findProject = _projectConsole.findByUserCode(logicContext, session.userId(), code);
      if(findProject != null){
         throw new FFatalError("Project code is duplicate. (user_id={1}, code={2})", session.userId(), code);
      }
      // 新建处理
      FGcProjectInfo project = _projectConsole.doPrepare(logicContext);
      project.setUserId(session.userId());
      project.setCode(code);
      project.setLabel(label);
      _projectConsole.doInsert(logicContext, project);
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
         throw new FFatalError("Project guid is empty.");
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
      FGcProjectInfo project = _projectConsole.findByGuid(logicContext, guid);
      if(project == null){
         throw new FFatalError("Project is not exists. (guid={1})", guid);
      }
      // 检查用户有效
      if(project.userId() != session.userId()){
         throw new FFatalError("Project user is invalid. (project_user_id={1}, session_user_id={2})", project.userId(), session.userId());
      }
      // 更新数据
      if(code != null){
         project.setCode(code);
      }
      if(label != null){
         project.setLabel(label);
      }
      _projectConsole.doUpdate(logicContext, project);
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
         throw new FFatalError("Project guid is empty.");
      }
      // 查找数据
      FGcProjectInfo project = _projectConsole.findByGuid(logicContext, guid);
      if(project == null){
         throw new FFatalError("Project is not exists. (guid={1})", guid);
      }
      // 检查用户有效
      if(project.userId() != session.userId()){
         throw new FFatalError("Project user is invalid. (project_user_id={1}, session_user_id={2})", project.userId(), session.userId());
      }
      // 删除数据
      _projectConsole.doDelete(logicContext, project);
      return EResult.Success;
   }
}
