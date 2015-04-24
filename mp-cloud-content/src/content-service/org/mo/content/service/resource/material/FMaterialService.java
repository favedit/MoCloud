package org.mo.content.service.resource.material;

import com.cyou.gccloud.data.data.FDataResourceMaterialBitmapLogic;
import org.mo.cloud.logic.resource.IGcResourceConsole;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.resource.bitmap.IGcResBitmapConsole;
import org.mo.cloud.logic.resource.material.FGcResMaterialBitmapInfo;
import org.mo.cloud.logic.resource.material.FGcResMaterialInfo;
import org.mo.cloud.logic.resource.material.IGcResMaterialBitmapConsole;
import org.mo.cloud.logic.resource.material.IGcResMaterialConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
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
public class FMaterialService
      extends FObject
      implements
         IMaterialService
{
   // 位图控制台接口
   @ALink
   protected IGcResourceConsole _resourceConsole;

   // 位图控制台接口
   @ALink
   protected IGcResBitmapConsole _bitmapConsole;

   // 材质控制台接口
   @ALink
   protected IGcResMaterialConsole _materialConsole;

   // 材质位图控制台接口
   @ALink
   protected IGcResMaterialBitmapConsole _materialBitmapConsole;

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FMaterialService(){
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
      //      // 获得参数
      //      String resourceGuid = context.parameter("guid");
      //      if(RString.isEmpty(resourceGuid)){
      //         throw new FFatalError("Resource guid is empty.");
      //      }
      //      long userId = session.userId();
      //      //............................................................
      //      // 获得位图
      //      FGcResBitmapInfo bitmap = _bitmapConsole.findByResourceGuid(logicContext, resourceGuid);
      //      long bitmapId = bitmap.ouid();
      //      //............................................................
      //      // 生成查询脚本
      //      String whereSql = "(" + FDataResourceBitmapImageLogic.USER_ID + "=" + userId + ")";
      //      whereSql += " AND (" + FDataResourceBitmapImageLogic.BITMAP_ID + "=" + bitmapId + ")";
      //      // 查询数据
      //      FLogicDataset<FGcResBitmapImageInfo> dataset = _bitmapImageConsole.fetch(logicContext, whereSql);
      //      // 设置输出节点
      //      FXmlNode xdataset = output.config().createNode("ImageCollection");
      //      for(FGcResBitmapImageInfo image : dataset){
      //         FXmlNode ximage = xdataset.createNode("Image");
      //         ximage.set("guid", image.guid());
      //         ximage.set("code", image.code());
      //         ximage.set("label", image.label());
      //      }
      return EResult.Success;
   }

   //============================================================
   // <T>获取材质位图列表。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult listBitmap(IWebContext context,
                             ILogicContext logicContext,
                             FGcSessionInfo session,
                             IWebInput input,
                             IWebOutput output){
      // 检查参数
      String guid = context.parameter("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Material guid is empty. (guid={1})", guid);
      }
      //............................................................
      // 获得材质信息
      FGcResMaterialInfo materialInfo = _materialConsole.getByGuid(logicContext, guid);
      long materialId = materialInfo.ouid();
      //............................................................
      // 生成查询脚本
      String whereSql = "(" + FDataResourceMaterialBitmapLogic.USER_ID + "=" + session.userId() + ")";
      whereSql += " AND (" + FDataResourceMaterialBitmapLogic.MATERIAL_ID + "=" + materialId + ")";
      String orderSql = FDataResourceMaterialBitmapLogic.CODE + " ASC";
      // 查询数据
      FLogicDataset<FGcResMaterialBitmapInfo> dataset = _materialBitmapConsole.fetch(logicContext, whereSql, orderSql);
      // 设置输出节点
      FXmlNode xoutput = output.config().createNode("BitmapCollection");
      xoutput.set("total", dataset.total());
      xoutput.set("count", dataset.count());
      xoutput.set("page_size", dataset.pageSize());
      xoutput.set("page_count", dataset.pageCount());
      xoutput.set("page", dataset.page());
      for(FGcResMaterialBitmapInfo materialBitmapInfo : dataset){
         // 查找位图信息
         long bitmapId = materialBitmapInfo.bitmapId();
         FGcResBitmapInfo bitmapInfo = _bitmapConsole.find(logicContext, bitmapId);
         // 创建位图节点
         FXmlNode xitem = xoutput.createNode("Bitmap");
         xitem.set("guid", bitmapInfo.guid());
         xitem.set("code", bitmapInfo.code());
         xitem.set("label", bitmapInfo.label());
         xitem.set("update_date", bitmapInfo.updateDate());
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
      FGcResMaterialInfo materialInfo = _materialConsole.findByGuid(logicContext, guid);
      if(materialInfo == null){
         throw new FFatalError("Resource material is not exists. (guid={1})", guid);
      }
      // 检查用户
      if(materialInfo.userId() != session.userId()){
         throw new FFatalError("Resource material user is invalid. (project_user_id={1}, session_user_id={2})", materialInfo.userId(), session.userId());
      }
      // 设置输出
      FXmlNode xbitmap = output.config().createNode("Material");
      xbitmap.set("guid", materialInfo.guid());
      xbitmap.set("code", materialInfo.code());
      xbitmap.set("label", materialInfo.label());
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
      //      FGcRs3MeshInfo findMesh = _meshConsole.findByUserCode(logicContext, session.userId(), code);
      //      if(findMesh != null){
      //         throw new FFatalError("Resource3d mesh code is duplicate. (user_id={1}, code={2})", session.userId(), code);
      //      }
      //      // 新建处理
      //      FGcRs3MeshInfo mesh = _meshConsole.doPrepare(logicContext);
      //      mesh.setUserId(session.userId());
      //      mesh.setCode(code);
      //      mesh.setLabel(label);
      //      _meshConsole.doInsert(logicContext, mesh);
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
      //      // 获得参数
      //      FXmlNode xinput = input.config();
      //      String guid = xinput.nodeText("guid");
      //      if(RString.isEmpty(guid)){
      //         throw new FFatalError("Guid is empty.");
      //      }
      //      String code = xinput.nodeText("Code");
      //      if(RString.isEmpty(code)){
      //         throw new FFatalError("Code is empty.");
      //      }
      //      String label = xinput.nodeText("Label");
      //      if(RString.isEmpty(label)){
      //         throw new FFatalError("Label is empty.");
      //      }
      //      // 查找数据
      //      FGcRs3MeshInfo mesh = _meshConsole.findByGuid(logicContext, guid);
      //      if(mesh == null){
      //         throw new FFatalError("Resource3d mesh is not exists. (guid={1})", guid);
      //      }
      //      // 检查用户有效
      //      if(mesh.userId() != session.userId()){
      //         throw new FFatalError("Resource3d mesh user is invalid. (project_user_id={1}, session_user_id={2})", mesh.userId(), session.userId());
      //      }
      //      // 更新数据
      //      if(code != null){
      //         mesh.setCode(code);
      //      }
      //      if(label != null){
      //         mesh.setLabel(label);
      //      }
      //      _meshConsole.doUpdate(logicContext, mesh);
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
      //      // 获得参数
      //      FXmlNode xinput = input.config();
      //      String guid = xinput.nodeText("guid");
      //      if(RString.isEmpty(guid)){
      //         throw new FFatalError("Resource3d mesh guid is empty.");
      //      }
      //      // 查找数据
      //      FGcRs3MeshInfo mesh = _meshConsole.findByGuid(logicContext, guid);
      //      if(mesh == null){
      //         throw new FFatalError("Resource3d mesh is not exists. (guid={1})", guid);
      //      }
      //      // 检查用户有效
      //      if(mesh.userId() != session.userId()){
      //         throw new FFatalError("Resource3d mesh user is invalid. (project_user_id={1}, session_user_id={2})", mesh.userId(), session.userId());
      //      }
      //      // 删除数据
      //      _meshConsole.doDelete(logicContext, mesh);
      return EResult.Success;
   }
}
