package org.mo.content.service.resource;

import com.cyou.gccloud.data.data.FDataResourceResourceLogic;
import com.cyou.gccloud.define.enums.core.EGcResource;
import com.cyou.gccloud.define.enums.core.EGcResourceShare;
import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.IGcResourceCatalogConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FString;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource.ICntResourceConsole;
import org.mo.content.core.resource.bitmap.ICntBitmapConsole;
import org.mo.content.core.resource.material.ICntMaterialConsole;
import org.mo.content.core.resource.mesh.ICntMeshConsole;
import org.mo.content.core.resource.model.ICntModelConsole;
import org.mo.content.core.resource.scene.ICntSceneConsole;
import org.mo.content.core.resource.template.ICntTemplateConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D服务。</T>
//============================================================
public class FResourceService
      extends FObject
      implements
         IResourceService
{
   // 内容图片控制台接口
   @ALink
   protected ICntBitmapConsole _bitmapConsole;

   // 内容材质控制台接口
   @ALink
   protected ICntMaterialConsole _materialConsole;

   // 内容网格控制台接口
   @ALink
   protected ICntMeshConsole _meshConsole;

   // 内容模型控制台接口
   @ALink
   protected ICntModelConsole _modelConsole;

   // 内容模板控制台接口
   @ALink
   protected ICntTemplateConsole _templateConsole;

   // 内容场景控制台接口
   @ALink
   protected ICntSceneConsole _sceneConsole;

   // 资源目录控制台接口
   @ALink
   protected IGcResourceCatalogConsole _resourceCatalogConsole;

   // 资源控制台接口
   @ALink
   protected ICntResourceConsole _resourceConsole;

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FResourceService(){
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
      String typeCd = context.parameter("type_cd");
      String serach = context.parameter("serach");
      String order = context.parameter("order");
      int pageSize = RInteger.toRange(context.parameterAsInteger("page_size", 40), 0, 100);
      int page = context.parameterAsInteger("page", 0);
      // 设置输出节点
      FXmlNode xresources = output.config().createNode("ResourceCollection");
      xresources.set("total", 0);
      xresources.set("count", 0);
      xresources.set("page_count", 0);
      xresources.set("page_size", pageSize);
      xresources.set("page", page);
      //............................................................
      // 生成查询脚本
      FString whereSql = new FString();
      whereSql.append("(USER_ID=" + session.userId() + ")");
      if(!RString.isEmpty(serach)){
         whereSql.append(" AND (LABEL LIKE '%" + serach + "%')");
      }
      if(!RString.isEmpty(typeCd)){
         if(!typeCd.contains("All")){
            String[] types = RString.split(typeCd, '|');
            whereSql.append(" AND (RESOURCE_CD IN (");
            int count = types.length;
            for(int n = 0; n < count; n++){
               String type = types[n];
               int typeCode = EGcResource.parse(type);
               if(n > 0){
                  whereSql.append(",");
               }
               whereSql.append(typeCode);
            }
            whereSql.append("))");
         }
      }
      //............................................................
      // 查询数据
      FLogicDataset<FGcResourceInfo> dataset = _resourceConsole.fetch(logicContext, whereSql.toString(), order, pageSize, page);
      //............................................................
      // 生成输出内容
      if(dataset != null){
         xresources.set("total", dataset.total());
         xresources.set("count", dataset.count());
         xresources.set("page_size", dataset.pageSize());
         xresources.set("page_count", dataset.pageCount());
         xresources.set("page", dataset.page());
         for(FGcResourceInfo resource : dataset){
            FXmlNode xresource = xresources.createNode("Resource");
            xresource.set("guid", resource.get("guid"));
            xresource.set("type_cd", EGcResource.format(resource.resourceCd()));
            xresource.set("share_cd", EGcResourceShare.format(resource.shareCd()));
            xresource.set("code", resource.get("code"));
            xresource.set("label", resource.get("label"));
            xresource.set("update_date", resource.get("update_date"));
         }
      }
      return EResult.Success;
   }

   //============================================================
   // <T>获取共享数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult listShare(IWebContext context,
                            ILogicContext logicContext,
                            FGcSessionInfo session,
                            IWebInput input,
                            IWebOutput output){
      // 检查参数
      String typeCd = context.parameter("type_cd");
      String serach = context.parameter("serach");
      String order = context.parameter("order");
      int pageSize = RInteger.toRange(context.parameterAsInteger("page_size", 40), 0, 100);
      int page = context.parameterAsInteger("page", 0);
      // 设置输出节点
      FXmlNode xresources = output.config().createNode("ResourceCollection");
      xresources.set("total", 0);
      xresources.set("count", 0);
      xresources.set("page_count", 0);
      xresources.set("page_size", pageSize);
      xresources.set("page", page);
      //............................................................
      // 生成查询脚本
      FString whereSql = new FString();
      whereSql.append(FDataResourceResourceLogic.SHARE_CD + "=" + EGcResourceShare.Public);
      if(!RString.isEmpty(serach)){
         whereSql.append(" AND (" + FDataResourceResourceLogic.LABEL + " LIKE '%" + serach + "%')");
      }
      if(!RString.isEmpty(typeCd)){
         if(!typeCd.contains("All")){
            String[] types = RString.split(typeCd, '|');
            whereSql.append(" AND (RESOURCE_CD IN (");
            int count = types.length;
            for(int n = 0; n < count; n++){
               String type = types[n];
               int typeCode = EGcResource.parse(type);
               if(n > 0){
                  whereSql.append(",");
               }
               whereSql.append(typeCode);
            }
            whereSql.append("))");
         }
      }
      //............................................................
      // 查询数据
      FLogicDataset<FGcResourceInfo> dataset = _resourceConsole.fetch(logicContext, whereSql.toString(), order, pageSize, page);
      //............................................................
      // 生成输出内容
      if(dataset != null){
         xresources.set("total", dataset.total());
         xresources.set("count", dataset.count());
         xresources.set("page_size", dataset.pageSize());
         xresources.set("page_count", dataset.pageCount());
         xresources.set("page", dataset.page());
         for(FGcResourceInfo resource : dataset){
            FXmlNode xresource = xresources.createNode("Resource");
            xresource.set("guid", resource.get("guid"));
            xresource.set("type_cd", EGcResource.format(resource.resourceCd()));
            xresource.set("share_cd", EGcResourceShare.format(resource.shareCd()));
            xresource.set("code", resource.get("code"));
            xresource.set("label", resource.get("label"));
            xresource.set("update_date", resource.get("update_date"));
         }
      }
      return EResult.Success;
   }

   //============================================================
   // <T>分享数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult share(IWebContext context,
                        ILogicContext logicContext,
                        FGcSessionInfo session,
                        IWebInput input,
                        IWebOutput output){
      // 检查参数
      String guid = context.parameter("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Resource guid is empty.");
      }
      String shareCode = context.parameter("share_cd");
      if(RString.isEmpty(shareCode)){
         throw new FFatalError("Resource share type is empty.");
      }
      int shareCd = EGcResourceShare.parse(shareCode);
      //............................................................
      // 获得会话信息
      long userId = session.userId();
      //............................................................
      // 查找资源
      FGcResourceInfo resourceInfo = _resourceConsole.getByGuid(logicContext, guid);
      if(resourceInfo.userId() != userId){
         throw new FFatalError("Session user is not resource user.");
      }
      if(resourceInfo.shareCd() != shareCd){
         resourceInfo.setShareCd(shareCd);
         _resourceConsole.doUpdate(logicContext, resourceInfo);
      }
      // 返回结果
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
      // 检查参数
      String typeCd = context.parameter("type_cd");
      if(RString.isEmpty(typeCd)){
         throw new FFatalError("Resource type is empty.");
      }
      String guid = context.parameter("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Resource guid is empty.");
      }
      //............................................................
      // 查找资源
      FGcResourceInfo resource = _resourceConsole.getByGuid(logicContext, guid);
      long resourceId = resource.ouid();
      //............................................................
      long userId = session.userId();
      // 查询数据
      switch(typeCd){
         case EGcResource.BitmapString:
            // 删除位图
            _bitmapConsole.doDeleteByResourceId(logicContext, userId, resourceId);
            break;
         case "sound":
            // 查找声音
            break;
         case "video":
            // 查找视频
            break;
         case EGcResource.MaterialString:
            // 查找材质
            _materialConsole.doDeleteByResourceId(logicContext, userId, resourceId);
            break;
         case EGcResource.MeshString:
            // 删除网格
            _meshConsole.doDeleteByResourceId(logicContext, userId, resourceId);
            break;
         case EGcResource.ModelString:
            // 删除模型
            _modelConsole.doDeleteByResourceId(logicContext, userId, resourceId);
            break;
         case EGcResource.TemplateString:
            // 查找模板
            _templateConsole.doDeleteByResourceId(logicContext, userId, resourceId);
            break;
         case EGcResource.SceneString:
            // 查找网格
            _sceneConsole.doDeleteByResourceId(logicContext, userId, resourceId);
            break;
         default:
            throw new FFatalError("Unknown resource type. (type_cd={1})", typeCd);
      }
      return EResult.Success;
   }
}
