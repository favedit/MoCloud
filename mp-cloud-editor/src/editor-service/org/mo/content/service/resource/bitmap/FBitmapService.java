package org.mo.content.service.resource.bitmap;

import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource.bitmap.ICntBitmapConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D网格服务。</T>
//============================================================
public class FBitmapService
      extends FObject
      implements
         IBitmapService
{
   // 项目控制台接口
   @ALink
   protected ICntBitmapConsole _bitmapConsole;

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FBitmapService(){
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
   public EResult imageList(IWebContext context,
                            ILogicContext logicContext,
                            FGcSessionInfo session,
                            IWebInput input,
                            IWebOutput output){
      //      FXmlNode xinput = input.config();
      //      String search = xinput.nodeText("Search");
      //      String order = xinput.nodeText("Order");
      //      int pageSize = RInteger.toRange(xinput.nodeTextAsInt("PageSize", 20), 0, 200);
      //      int page = xinput.nodeTextAsInt("Page", 0);
      //      // 设置输出节点
      //      FXmlNode xoutput = output.config().createNode("MeshCollection");
      //      xoutput.set("page_count", 0);
      //      xoutput.set("page_size", pageSize);
      //      xoutput.set("page", page);
      //      //............................................................
      //      // 生成查询脚本
      //      String whereSql = "(" + FDataSolutionProjectLogic.USER_ID + "=" + session.userId() + ")";
      //      if(!RString.isEmpty(search)){
      //         whereSql += " AND (" + FDataSolutionProjectLogic.CODE + " LIKE '%" + RSql.formatValue(search) + "%')";
      //      }
      //      // 查询数据
      //      FLogicDataset<FGcResModelMeshInfo> dataset = _bitmapConsole.fetch(logicContext, whereSql, order, pageSize, page);
      //      xoutput.set("total", dataset.total());
      //      xoutput.set("count", dataset.count());
      //      xoutput.set("page_size", dataset.pageSize());
      //      xoutput.set("page_count", dataset.pageCount());
      //      xoutput.set("page", dataset.page());
      //      for(FGcResModelMeshInfo mesh : dataset){
      //         FXmlNode xitem = xoutput.createNode("Project");
      //         xitem.set("guid", mesh.guid());
      //         xitem.set("code", mesh.code());
      //         xitem.set("label", mesh.label());
      //      }
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
      FGcResBitmapInfo bitmap = _bitmapConsole.findByGuid(logicContext, guid);
      if(bitmap == null){
         throw new FFatalError("Resource bitmap is not exists. (guid={1})", guid);
      }
      // 检查用户
      if(bitmap.userId() != session.userId()){
         throw new FFatalError("Resource bitmap user is invalid. (project_user_id={1}, session_user_id={2})", bitmap.userId(), session.userId());
      }
      // 设置输出
      FXmlNode xbitmap = output.config().createNode("Bitmap");
      xbitmap.set("guid", bitmap.guid());
      xbitmap.set("code", bitmap.code());
      xbitmap.set("label", bitmap.label());
      xbitmap.set("size_width", bitmap.sizeWidth());
      xbitmap.set("size_height", bitmap.sizeHeight());
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
      //      FGcResModelMeshInfo findMesh = _bitmapConsole.findByUserCode(logicContext, session.userId(), code);
      //      if(findMesh != null){
      //         throw new FFatalError("Resource3d mesh code is duplicate. (user_id={1}, code={2})", session.userId(), code);
      //      }
      //      // 新建处理
      //      FGcResModelMeshInfo mesh = _bitmapConsole.doPrepare(logicContext);
      //      mesh.setUserId(session.userId());
      //      mesh.setCode(code);
      //      mesh.setLabel(label);
      //      _bitmapConsole.doInsert(logicContext, mesh);
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
   public EResult update(IWebContext context,
                         ILogicContext logicContext,
                         FGcSessionInfo session,
                         IWebInput input,
                         IWebOutput output){
      // 获得参数
      FXmlNode xbitmap = input.config().findNode("Bitmap");
      if(xbitmap == null){
         throw new FFatalError("Bitmap config is empty.");
      }
      String guid = xbitmap.get("guid", null);
      if(RString.isEmpty(guid)){
         throw new FFatalError("Guid is empty.");
      }
      String code = xbitmap.get("code", null);
      if(RString.isEmpty(code)){
         throw new FFatalError("Code is empty.");
      }
      String label = xbitmap.get("label", null);
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      // 查找数据
      FGcResBitmapInfo bitmapInfo = _bitmapConsole.findByGuid(logicContext, guid);
      if(bitmapInfo == null){
         throw new FFatalError("Resource bitmap is not exists. (guid={1})", guid);
      }
      // 检查用户有效
      if(bitmapInfo.userId() != session.userId()){
         throw new FFatalError("Resource bitmap user is invalid. (project_user_id={1}, session_user_id={2})", bitmapInfo.userId(), session.userId());
      }
      // 更新数据
      if(code != null){
         bitmapInfo.setCode(code);
      }
      if(label != null){
         bitmapInfo.setLabel(label);
      }
      _bitmapConsole.doUpdate(logicContext, bitmapInfo);
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
      //      FGcResModelMeshInfo mesh = _bitmapConsole.findByGuid(logicContext, guid);
      //      if(mesh == null){
      //         throw new FFatalError("Resource3d mesh is not exists. (guid={1})", guid);
      //      }
      //      // 检查用户有效
      //      if(mesh.userId() != session.userId()){
      //         throw new FFatalError("Resource3d mesh user is invalid. (project_user_id={1}, session_user_id={2})", mesh.userId(), session.userId());
      //      }
      //      // 删除数据
      //      _bitmapConsole.doDelete(logicContext, mesh);
      return EResult.Success;
   }
}
