package org.mo.content.service.solution;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource3d.material.IC3dMaterialConsole;
import org.mo.content.core.resource3d.mesh.IC3dMeshConsole;
import org.mo.content.core.resource3d.model.IC3dModelConsole;
import org.mo.content.core.resource3d.scene.IC3dSceneConsole;
import org.mo.content.core.resource3d.template.IC3dTemplateConsole;
import org.mo.content.core.resource3d.texture.IC3dBitmapConsole;
import org.mo.content.core.resource3d.texture.IC3dTextureConsole;
import org.mo.core.aop.face.ALink;
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
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult fetch(IWebContext context,
                        ILogicContext logicContext,
                        IWebInput input,
                        IWebOutput output){
      String typeCd = context.parameter("type_cd");
      String serach = context.parameter("serach");
      int pageSize = context.parameterAsInteger("page_size", 20);
      int page = context.parameterAsInteger("page", 0);
      // 设置输出节点
      FXmlNode xoutput = output.config().createNode("ItemCollection");
      xoutput.set("page_count", 0);
      xoutput.set("page_size", pageSize);
      xoutput.set("page", page);
      //............................................................
      // 查询数据
      switch(typeCd){
         case "picture":
            // 查找位图
            _bitmapConsole.fetch(logicContext, xoutput, serach, pageSize, page);
            break;
         case "sound":
            // 查找声音
            break;
         case "video":
            // 查找视频
            break;
         case "texture":
            // 查找纹理
            _textureConsole.fetch(logicContext, xoutput, serach, pageSize, page);
            break;
         case "material":
            // 查找材质
            _materialConsole.fetch(logicContext, xoutput, serach, pageSize, page);
            break;
         case "mesh":
            // 查找网格
            _meshConsole.fetch(logicContext, xoutput, serach, pageSize, page);
            break;
         case "model":
            // 查找网格
            _modelConsole.fetch(logicContext, xoutput, serach, pageSize, page);
            break;
         case "template":
            // 查找模板
            _templateConsole.fetch(logicContext, xoutput, serach, pageSize, page);
            break;
         case "scene":
            // 查找网格
            _sceneConsole.fetch(logicContext, xoutput, serach, pageSize, page);
            break;
         default:
            throw new FFatalError("Unknown resource type. (type_cd={1})", typeCd);
      }
      return EResult.Success;
   }
}
