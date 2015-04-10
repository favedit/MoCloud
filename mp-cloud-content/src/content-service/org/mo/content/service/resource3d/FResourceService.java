package org.mo.content.service.resource3d;

import com.cyou.gccloud.define.enums.core.EGcResource;
import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.IGcResourceCatalogConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource3d.material.IC3dMaterialConsole;
import org.mo.content.core.resource3d.mesh.IC3dMeshConsole;
import org.mo.content.core.resource3d.model.IC3dModelConsole;
import org.mo.content.core.resource3d.resource.IC3dResourceConsole;
import org.mo.content.core.resource3d.scene.IC3dSceneConsole;
import org.mo.content.core.resource3d.template.IC3dTemplateConsole;
import org.mo.content.core.resource3d.texture.IC3dBitmapConsole;
import org.mo.content.core.resource3d.texture.IC3dTextureConsole;
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
   protected IC3dBitmapConsole _bitmapConsole;

   // 内容纹理控制台接口
   @ALink
   protected IC3dTextureConsole _textureConsole;

   // 内容材质控制台接口
   @ALink
   protected IC3dMaterialConsole _materialConsole;

   // 内容网格控制台接口
   @ALink
   protected IC3dMeshConsole _meshConsole;

   // 内容模型控制台接口
   @ALink
   protected IC3dModelConsole _modelConsole;

   // 内容模板控制台接口
   @ALink
   protected IC3dTemplateConsole _templateConsole;

   // 内容场景控制台接口
   @ALink
   protected IC3dSceneConsole _sceneConsole;

   // 资源目录控制台接口
   @ALink
   protected IGcResourceCatalogConsole _resourceCatalogConsole;

   // 资源控制台接口
   @ALink
   protected IC3dResourceConsole _resourceConsole;

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
      //String typeCd = context.parameter("type_cd");
      String serach = context.parameter("serach");
      String order = context.parameter("order");
      int pageSize = RInteger.toRange(context.parameterAsInteger("page_size", 20), 0, 200);
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
      String whereSql = "(USER_ID=" + session.userId() + ")";
      if(!RString.isEmpty(serach)){
         whereSql += " AND (LABEL LIKE '%" + serach + "%')";
      }
      //............................................................
      // 查询数据
      FLogicDataset<FGcResourceInfo> dataset = _resourceConsole.fetch(logicContext, whereSql, order, pageSize, page);
      //      FLogicDataset<FLogicUnit> dataset = null;
      //      switch(typeCd){
      //         case "picture":
      //            // 查找位图
      //            dataset = _bitmapConsole.list(logicContext, whereSql, order, pageSize, page);
      //            break;
      //         case "sound":
      //            // 查找声音
      //            break;
      //         case "video":
      //            // 查找视频
      //            break;
      //         case "texture":
      //            // 查找纹理
      //            //_textureConsole.fetch(logicContext, xoutput, whereSql, pageSize, page);
      //            break;
      //         case "material":
      //            // 查找材质
      //            //_materialConsole.fetch(logicContext, xoutput, whereSql, pageSize, page);
      //            break;
      //         case "mesh":
      //            // 查找网格
      //            dataset = _meshConsole.list(logicContext, whereSql, order, pageSize, page);
      //            break;
      //         case "model":
      //            // 查找网格
      //            //_modelConsole.fetch(logicContext, xoutput, whereSql, pageSize, page);
      //            break;
      //         case "template":
      //            // 查找模板
      //            //_templateConsole.fetch(logicContext, xoutput, whereSql, pageSize, page);
      //            break;
      //         case "scene":
      //            // 查找网格
      //            //_sceneConsole.fetch(logicContext, xoutput, whereSql, pageSize, page);
      //            break;
      //         default:
      //            throw new FFatalError("Unknown resource type. (type_cd={1})", typeCd);
      //      }
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
            xresource.set("code", resource.get("full_code"));
            xresource.set("label", resource.get("label"));
            xresource.set("update_date", resource.get("update_date"));
         }
      }
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
      long userId = session.userId();
      // 查询数据
      switch(typeCd){
         case "picture":
            // 查找位图
            //dataset = _bitmapConsole.list(logicContext, whereSql, order, pageSize, page);
            break;
         case "sound":
            // 查找声音
            break;
         case "video":
            // 查找视频
            break;
         case "texture":
            // 查找纹理
            //_textureConsole.fetch(logicContext, xoutput, whereSql, pageSize, page);
            break;
         case "material":
            // 查找材质
            //_materialConsole.fetch(logicContext, xoutput, whereSql, pageSize, page);
            break;
         case "mesh":
            // 删除网格
            _meshConsole.doDeleteByGuid(logicContext, userId, guid);
            break;
         case "model":
            // 查找网格
            //_modelConsole.fetch(logicContext, xoutput, whereSql, pageSize, page);
            break;
         case "template":
            // 查找模板
            //_templateConsole.fetch(logicContext, xoutput, whereSql, pageSize, page);
            break;
         case "scene":
            // 查找网格
            //_sceneConsole.fetch(logicContext, xoutput, whereSql, pageSize, page);
            break;
         default:
            throw new FFatalError("Unknown resource type. (type_cd={1})", typeCd);
      }
      return EResult.Success;
   }
}
