package org.mo.content.service.resource.model;

import org.mo.cloud.logic.data.resource.model.FGcResModelInfo;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource.model.ICntModelConsole;
import org.mo.content.resource.model.FResModel;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D网格服务。</T>
//============================================================
public class FModelService
      extends FObject
      implements
         IModelService
{
   // 项目控制台接口
   @ALink
   protected ICntModelConsole _modelConsole;

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FModelService(){
   }

   //============================================================
   // <T>获得模型列表。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult list(IWebContext context,
                       ILogicContext logicContext,
                       FGcSessionInfo session,
                       IWebInput input,
                       IWebOutput output){
      //      FXmlNode xoutput = output.config();
      //      // 获得模型信息
      //      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      //      FLogicDataset<FDataResource3dModelUnit> modelUnits = modelLogic.fetchAll();
      //      for(FDataResource3dModelUnit modelUnit : modelUnits){
      //         // 创建树节点
      //         FXmlNode xnode = xoutput.createNode("TreeNode");
      //         xnode.set("name", modelUnit.code());
      //         xnode.set("label", modelUnit.code());
      //         xnode.set("type", "Model");
      //      }
      return EResult.Success;
   }

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        ILogicContext logicContext,
                        FGcSessionInfo session,
                        IWebInput input,
                        IWebOutput output){
      //      String code = context.parameter("code");
      //      // 查找目录定义
      //      XTreeView xtree = _treeConsole.find(_storageName, code);
      //      if(xtree == null){
      //         return EResult.Failure;
      //      }
      //      // 转换数据
      //      FXmlNode xconfig = output.config().createNode();
      //      FPersistence persistence = _persistenceConsole.findPersistence(_storageName, "design.tree");
      //      FContentObject content = persistence.convertConfig(xtree);
      //      // 存储输出
      //      content.saveConfig(xconfig);
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
      //      // 获得参数
      //      FXmlNode xinput = input.config();
      //      String code = xinput.nodeText("Code");
      //      if(RString.isEmpty(code)){
      //         throw new FFatalError("Code is empty.");
      //      }
      //      String label = xinput.nodeText("Label");
      //      if(RString.isEmpty(label)){
      //         throw new FFatalError("Label is empty.");
      //      }
      //      // 查找数据
      //      FGcResModelInfo findMesh = _modelConsole.find .findByUserCode(logicContext, session.userId(), code);
      //      if(findMesh != null){
      //         throw new FFatalError("Resource3d mesh code is duplicate. (user_id={1}, code={2})", session.userId(), code);
      //      }
      //      // 新建处理
      //      FGcResModelInfo mesh = _modelConsole.doPrepare(logicContext);
      //      mesh.setUserId(session.userId());
      //      mesh.setCode(code);
      //      mesh.setLabel(label);
      //      _modelConsole.doInsert(logicContext, mesh);
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
      FGcResModelInfo mesh = _modelConsole.findByGuid(logicContext, guid);
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
      _modelConsole.doUpdate(logicContext, mesh);
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
      FXmlNode xmodel = input.config();
      if(!xmodel.isName("Model")){
         throw new FFatalError("Invalid config code.");
      }
      // 获得唯一编号
      String guid = xmodel.get("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Parameter guid is empty. (guid={1})", guid);
      }
      // 合并场景
      FGcResModelInfo modelInfo = _modelConsole.getByGuid(logicContext, guid);
      FResModel model = _modelConsole.makeModel(logicContext, modelInfo);
      model.mergeConfig(xmodel);
      // 更新场景
      _modelConsole.updateResource(logicContext, session, modelInfo, model);
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
         throw new FFatalError("Resource model guid is empty.");
      }
      // 查找数据
      FGcResModelInfo model = _modelConsole.findByGuid(logicContext, guid);
      if(model == null){
         throw new FFatalError("Resource model is not exists. (guid={1})", guid);
      }
      // 检查用户有效
      if(model.userId() != session.userId()){
         throw new FFatalError("Resource model user is invalid. (project_user_id={1}, session_user_id={2})", model.userId(), session.userId());
      }
      // 删除数据
      _modelConsole.doDelete(logicContext, model);
      return EResult.Success;
   }
}
