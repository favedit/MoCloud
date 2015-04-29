package org.mo.content.service.resource.template;

import com.cyou.gccloud.data.data.FDataSolutionProjectLogic;
import org.mo.cloud.logic.resource.material.FGcResMaterialInfo;
import org.mo.cloud.logic.resource.model.FGcResModelInfo;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.template.FGcResTemplateInfo;
import org.mo.cloud.logic.resource.template.FGcResTemplateMaterialInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource.material.ICntMaterialConsole;
import org.mo.content.core.resource.model.ICntModelConsole;
import org.mo.content.core.resource.model.ICntModelMeshConsole;
import org.mo.content.core.resource.template.ICntTemplateConsole;
import org.mo.content.engine.core.template.IResTemplateMaterialConsole;
import org.mo.content.resource.common.FResMaterial;
import org.mo.content.resource.common.FResShape;
import org.mo.content.resource.common.FResSprite;
import org.mo.content.resource.template.FResTemplate;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源模板服务。</T>
//============================================================
public class FTemplateService
      extends FObject
      implements
         ITemplateService
{
   // 内容材质控制台接口
   @ALink
   protected ICntMaterialConsole _materialConsole;

   // 内容模型控制台接口
   @ALink
   protected ICntModelConsole _modelConsole;

   // 内容模型网格控制台接口
   @ALink
   protected ICntModelMeshConsole _modelMeshConsole;

   // 内容模板控制台接口
   @ALink
   protected ICntTemplateConsole _templateConsole;

   // 内容模板材质控制台接口
   @ALink
   protected IResTemplateMaterialConsole _templateMaterialConsole;

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
      FLogicDataset<FGcResModelMeshInfo> dataset = _modelMeshConsole.fetch(logicContext, whereSql, order, pageSize, page);
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
      FGcResModelMeshInfo mesh = _modelMeshConsole.findByGuid(logicContext, guid);
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
      FXmlNode xtemplate = input.config().findNode("Template");
      if(xtemplate == null){
         throw new FFatalError("Template config is not exists.");
      }
      String code = xtemplate.get("code", null);
      if(RString.isEmpty(code)){
         throw new FFatalError("Code is empty.");
      }
      String label = xtemplate.get("label", null);
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      // 获得会话信息
      long userId = session.userId();
      // 查找数据
      FGcResTemplateInfo findTemplateInfo = _templateConsole.findByUserCode(logicContext, userId, code);
      if(findTemplateInfo != null){
         throw new FFatalError("Resource template code is duplicate. (user_id={1}, code={2})", userId, code);
      }
      // 新建材质
      FResTemplate template = new FResTemplate();
      template.setCode(code);
      template.setLabel(label);
      // 新建数据
      FGcResTemplateInfo templateInfo = _templateConsole.doPrepare(logicContext);
      templateInfo.setUserId(userId);
      template.setGuid(templateInfo.guid());
      template.saveUnit(templateInfo);
      _templateConsole.doInsert(logicContext, templateInfo);
      return EResult.Success;
   }

   //============================================================
   // <T>创建材质处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult createMaterial(IWebContext context,
                                 ILogicContext logicContext,
                                 FGcSessionInfo session,
                                 IWebInput input,
                                 IWebOutput output){
      long userId = session.userId();
      // 获得参数
      FXmlNode xmaterial = input.config().findNode("Material");
      if(xmaterial == null){
         throw new FFatalError("Material is empty.");
      }
      String spaceGuid = xmaterial.get("space_guid", null);
      if(RString.isEmpty(spaceGuid)){
         throw new FFatalError("Space guid is empty.");
      }
      String code = xmaterial.get("code", null);
      String label = xmaterial.get("label", null);
      String materialGuid = xmaterial.get("material_guid", null);
      String materialCode = xmaterial.get("material_code", null);
      if(RString.isEmpty(materialGuid) && RString.isEmpty(materialCode)){
         throw new FFatalError("Material guid and code is empty.");
      }
      //............................................................
      // 查找项目
      FGcResTemplateInfo templateInfo = _templateConsole.findByGuid(logicContext, spaceGuid);
      if(templateInfo == null){
         throw new FFatalError("Template is not exists. (guid={1})", spaceGuid);
      }
      long templateId = templateInfo.ouid();
      FResTemplate template = _templateConsole.makeTemplate(logicContext, templateInfo);
      // 查找模板
      FGcResMaterialInfo materialInfo = null;
      if(!RString.isEmpty(materialGuid)){
         materialInfo = _materialConsole.findByGuid(logicContext, materialGuid);
      }else{
         materialInfo = _materialConsole.findByUserCode(logicContext, userId, materialCode);
      }
      if(materialInfo == null){
         throw new FFatalError("Material is not exists. (guid={1}, code={2})", materialGuid, materialCode);
      }
      if(RString.isEmpty(code)){
         code = materialInfo.code();
      }
      if(RString.isEmpty(label)){
         label = materialInfo.label();
      }
      long materialId = materialInfo.ouid();
      // 创建显示对象
      FResMaterial material = _materialConsole.makeMaterial(logicContext, materialInfo);
      material.setCode(code);
      material.setLabel(label);
      template.pushMaterial(material);
      // 创建材质关联
      FGcResTemplateMaterialInfo templateMaterialInfo = _templateMaterialConsole.doPrepare(logicContext);
      templateMaterialInfo.setTemplateId(templateId);
      templateMaterialInfo.setMaterialId(materialId);
      templateMaterialInfo.setCode(code);
      _templateMaterialConsole.doInsert(logicContext, templateMaterialInfo);
      //............................................................
      // 更新处理
      _templateConsole.updateResource(logicContext, template);
      return EResult.Success;
   }

   //============================================================
   // <T>创建显示对象处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult createDisplay(IWebContext context,
                                ILogicContext logicContext,
                                FGcSessionInfo session,
                                IWebInput input,
                                IWebOutput output){
      long userId = session.userId();
      // 获得参数
      FXmlNode xdisplay = input.config().findNode("Display");
      if(xdisplay == null){
         throw new FFatalError("Sprite is empty.");
      }
      String spaceGuid = xdisplay.get("space_guid", null);
      if(RString.isEmpty(spaceGuid)){
         throw new FFatalError("Space guid is empty.");
      }
      String code = xdisplay.get("code", null);
      String label = xdisplay.get("label", null);
      String modelGuid = xdisplay.get("model_guid", null);
      String modelCode = xdisplay.get("model_code", null);
      if(RString.isEmpty(modelGuid) && RString.isEmpty(modelCode)){
         throw new FFatalError("Model guid and code is empty.");
      }
      //............................................................
      // 查找项目
      FGcResTemplateInfo templateInfo = _templateConsole.findByGuid(logicContext, spaceGuid);
      if(templateInfo == null){
         throw new FFatalError("Template is not exists. (guid={1})", spaceGuid);
      }
      FResTemplate template = _templateConsole.makeTemplate(logicContext, templateInfo);
      // 查找模板
      FGcResModelInfo modelInfo = null;
      if(!RString.isEmpty(modelGuid)){
         modelInfo = _modelConsole.findByGuid(logicContext, modelGuid);
      }else{
         modelInfo = _modelConsole.findByUserCode(logicContext, userId, modelCode);
      }
      if(modelInfo == null){
         throw new FFatalError("Model is not exists. (guid={1}, code={2})", modelGuid, modelCode);
      }
      if(RString.isEmpty(code)){
         code = modelInfo.code();
      }
      if(RString.isEmpty(label)){
         label = modelInfo.label();
      }
      long modelId = modelInfo.ouid();
      // 创建显示对象
      FResSprite sprite = new FResSprite();
      sprite.setCode(code);
      sprite.setLabel(label);
      FLogicDataset<FGcResModelMeshInfo> meshDataset = _modelMeshConsole.fetchByModelId(logicContext, modelId);
      for(FGcResModelMeshInfo meshInfo : meshDataset){
         // 增加渲染对象
         FResShape shape = new FResShape();
         shape.setCode(meshInfo.code());
         shape.setLabel(meshInfo.label());
         shape.setModelGuid(modelInfo.guid());
         shape.setMeshGuid(meshInfo.guid());
         sprite.pushRenderable(shape);
      }
      template.pushDisplay(sprite);
      //............................................................
      // 更新处理
      _templateConsole.updateResource(logicContext, template);
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
      FGcResModelMeshInfo mesh = _modelMeshConsole.findByGuid(logicContext, guid);
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
      _modelMeshConsole.doUpdate(logicContext, mesh);
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
      FXmlNode xtemplate = input.config();
      if(!xtemplate.isName("Template")){
         throw new FFatalError("Invalid config code.");
      }
      // 获得唯一编号
      String guid = xtemplate.get("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Parameter guid is empty. (guid={1})", guid);
      }
      // 合并场景
      FGcResTemplateInfo templateInfo = _templateConsole.getByGuid(logicContext, guid);
      FResTemplate template = _templateConsole.makeTemplate(logicContext, templateInfo);
      template.mergeConfig(xtemplate);
      template.saveUnit(templateInfo);
      _templateConsole.updateResource(logicContext, template);
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
      FGcResModelMeshInfo mesh = _modelMeshConsole.findByGuid(logicContext, guid);
      if(mesh == null){
         throw new FFatalError("Resource3d mesh is not exists. (guid={1})", guid);
      }
      // 检查用户有效
      if(mesh.userId() != session.userId()){
         throw new FFatalError("Resource3d mesh user is invalid. (project_user_id={1}, session_user_id={2})", mesh.userId(), session.userId());
      }
      // 删除数据
      _modelMeshConsole.doDelete(logicContext, mesh);
      return EResult.Success;
   }
}
