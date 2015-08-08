package org.mo.content.service.resource;

import com.cyou.gccloud.data.data.FDataResourceCatalogLogic;
import org.mo.cloud.logic.resource.FGcResourceCatalogInfo;
import org.mo.cloud.logic.resource.IGcResourceCatalogConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D服务。</T>
//============================================================
public class FCatalogService
      extends FObject
      implements
         ICatalogService
{
   // 资源目录控制台接口
   @ALink
   protected IGcResourceCatalogConsole _resourceCatalogConsole;

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FCatalogService(){
   }

   //============================================================
   // <T>创建资源文件夹。</T>
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
      // 获得参数
      String parentGuid = null;
      FXmlNode xparent = input.config().findNode("TreeNode");
      if(xparent != null){
         parentGuid = xparent.get("guid");
      }
      // 获得用户
      long userId = session.userId();
      // 查找父节点
      long parentId = 0;
      if(!RString.isEmpty(parentGuid)){
         FGcResourceCatalogInfo parentCatalog = _resourceCatalogConsole.findByGuid(logicContext, parentGuid);
         if(parentCatalog == null){
            throw new FFatalError("Parent catalog is not exists. (guid={1})", parentGuid);
         }
         parentId = parentCatalog.ouid();
      }
      // 创建目录
      String whereSql = "(" + FDataResourceCatalogLogic.USER_ID + "=" + userId + ")";
      if(parentId > 0){
         whereSql += " AND (" + FDataResourceCatalogLogic.PARENT_ID + "=" + parentId + ")";
      }else{
         whereSql += " AND (PARENT_ID IS NULL)";
      }
      String orderSql = FDataResourceCatalogLogic.LABEL + " ASC";
      FLogicDataset<FGcResourceCatalogInfo> dataset = _resourceCatalogConsole.fetch(logicContext, whereSql, orderSql);
      // 生成目录
      FXmlNode xoutput = output.config();
      for(FGcResourceCatalogInfo catalog : dataset){
         // 获得子节点个数
         long nodeId = catalog.ouid();
         int childCount = _resourceCatalogConsole.calculateChildCount(logicContext, nodeId);
         // 创建目录节点
         FXmlNode xnode = xoutput.createNode("TreeNode");
         xnode.set("guid", catalog.guid());
         xnode.set("has_child", RBoolean.toString(childCount > 0));
         xnode.set("code", catalog.code());
         xnode.set("type_code", "Folder");
         xnode.set("label", catalog.label());
      }
      return EResult.Success;
   }

   //============================================================
   // <T>创建资源文件夹。</T>
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
      FXmlNode xfolder = input.config().findNode("Folder");
      String parentGuid = xfolder.get("parent_guid", null);
      String code = xfolder.get("code", null);
      String label = xfolder.get("label", null);
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      // 获得用户
      long userId = session.userId();
      // 查找父节点
      long parentId = 0;
      if(!RString.isEmpty(parentGuid)){
         FGcResourceCatalogInfo parentCatalog = _resourceCatalogConsole.findByGuid(logicContext, parentGuid);
         if(parentCatalog == null){
            throw new FFatalError("Parent catalog is not exists. (guid={1})", parentGuid);
         }
         parentId = parentCatalog.ouid();
      }
      // 创建目录
      FGcResourceCatalogInfo catalog = _resourceCatalogConsole.doPrepare(logicContext);
      catalog.setUserId(userId);
      catalog.setParentId(parentId);
      catalog.setCode(code);
      catalog.setLabel(label);
      _resourceCatalogConsole.doInsert(logicContext, catalog);
      return EResult.Success;
   }

   //============================================================
   // <T>修改资源文件夹。</T>
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
      FXmlNode xfolder = input.config().findNode("Folder");
      String guid = xfolder.get("guid", null);
      String code = xfolder.get("code", null);
      String label = xfolder.get("label", null);
      if(RString.isEmpty(label)){
         throw new FFatalError("Label is empty.");
      }
      // 获得用户
      long userId = session.userId();
      // 查找节点
      FGcResourceCatalogInfo catalog = _resourceCatalogConsole.findByGuid(logicContext, guid);
      if(catalog == null){
         throw new FFatalError("Catalog is not exists. (guid={1})", guid);
      }
      if(catalog.userId() != userId){
         throw new FFatalError("Catalog user is not equals. (user_id={1}, session_user_id={2})", catalog.userId(), userId);
      }
      // 更新数据
      catalog.setCode(code);
      catalog.setLabel(label);
      _resourceCatalogConsole.doUpdate(logicContext, catalog);
      return EResult.Success;
   }

   //============================================================
   // <T>删除资源文件夹。</T>
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
      // 检查参数
      String guid = context.parameter("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Catalog guid is empty.");
      }
      // 获得用户
      long userId = session.userId();
      //............................................................
      // 查找节点
      FGcResourceCatalogInfo catalog = _resourceCatalogConsole.findByGuid(logicContext, guid);
      if(catalog == null){
         throw new FFatalError("Catalog is not exists. (guid={1})", guid);
      }
      if(catalog.userId() != userId){
         throw new FFatalError("Catalog user is not equals. (user_id={1}, session_user_id={2})", catalog.userId(), userId);
      }
      // 删除节点
      _resourceCatalogConsole.doDelete(logicContext, catalog);
      return EResult.Success;
   }
}
