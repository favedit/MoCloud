package org.mo.content.service.resource.template;

import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;

import org.mo.content.core.resource.mesh.ICntMeshConsole;
import com.cyou.gccloud.data.data.FDataSolutionProjectLogic;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D网格服务。</T>
//============================================================
public class FTemplateService
      extends FObject
      implements
         ITemplateService
{
   // 项目控制台接口
   @ALink
   protected ICntMeshConsole _meshConsole;

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FTemplateService(){
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
      FXmlNode xoutput = output.config().createNode("MeshCollection");
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
      FLogicDataset<FGcResModelMeshInfo> dataset = _meshConsole.fetch(logicContext, whereSql, order, pageSize, page);
      xoutput.set("total", dataset.total());
      xoutput.set("count", dataset.count());
      xoutput.set("page_size", dataset.pageSize());
      xoutput.set("page_count", dataset.pageCount());
      xoutput.set("page", dataset.page());
      for(FGcResModelMeshInfo mesh : dataset){
         FXmlNode xitem = xoutput.createNode("Project");
         xitem.set("guid", mesh.guid());
         xitem.set("code", mesh.code());
         xitem.set("label", mesh.label());
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
      FGcResModelMeshInfo mesh = _meshConsole.findByGuid(logicContext, guid);
      if(mesh == null){
         return EResult.Failure;
      }
      // 检查用户
      if(mesh.userId() != session.userId()){
         throw new FFatalError("Resource3d mesh user is invalid. (project_user_id={1}, session_user_id={2})", mesh.userId(), session.userId());
      }
      // 设置输出
      FXmlNode xproject = output.config().createNode("Project");
      xproject.set("guid", mesh.guid());
      xproject.set("code", mesh.code());
      xproject.set("label", mesh.label());
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
      FXmlNode xinput = input.config();
      String code = xinput.nodeText("Code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Code is empty.");
      }
      String label = xinput.nodeText("Label");
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      // 查找数据
      FGcResModelMeshInfo findMesh = _meshConsole.findByUserCode(logicContext, session.userId(), code);
      if(findMesh != null){
         throw new FFatalError("Resource3d mesh code is duplicate. (user_id={1}, code={2})", session.userId(), code);
      }
      // 新建处理
      FGcResModelMeshInfo mesh = _meshConsole.doPrepare(logicContext);
      mesh.setUserId(session.userId());
      mesh.setCode(code);
      mesh.setLabel(label);
      _meshConsole.doInsert(logicContext, mesh);
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
         throw new FFatalError("Guid is empty.");
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
      FGcResModelMeshInfo mesh = _meshConsole.findByGuid(logicContext, guid);
      if(mesh == null){
         throw new FFatalError("Resource3d mesh is not exists. (guid={1})", guid);
      }
      // 检查用户有效
      if(mesh.userId() != session.userId()){
         throw new FFatalError("Resource3d mesh user is invalid. (project_user_id={1}, session_user_id={2})", mesh.userId(), session.userId());
      }
      // 更新数据
      if(code != null){
         mesh.setCode(code);
      }
      if(label != null){
         mesh.setLabel(label);
      }
      _meshConsole.doUpdate(logicContext, mesh);
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
         throw new FFatalError("Resource3d mesh guid is empty.");
      }
      // 查找数据
      FGcResModelMeshInfo mesh = _meshConsole.findByGuid(logicContext, guid);
      if(mesh == null){
         throw new FFatalError("Resource3d mesh is not exists. (guid={1})", guid);
      }
      // 检查用户有效
      if(mesh.userId() != session.userId()){
         throw new FFatalError("Resource3d mesh user is invalid. (project_user_id={1}, session_user_id={2})", mesh.userId(), session.userId());
      }
      // 删除数据
      _meshConsole.doDelete(logicContext, mesh);
      return EResult.Success;
   }
}
