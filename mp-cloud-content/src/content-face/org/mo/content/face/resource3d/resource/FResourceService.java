package org.mo.content.face.resource3d.resource;

import com.cyou.gccloud.data.data.FDataResource3dMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dSceneThemeUnit;
import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource3d.scene.IC3dSceneConsole;
import org.mo.content.engine3d.core.scene.IRs3SceneConsole;
import org.mo.content.resource3d.scene.FRs3Scene;
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
   @ALink
   protected IRs3SceneConsole _sceneConsole;

   @ALink
   protected IC3dSceneConsole _contentSceneConsole;

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
      //............................................................
      // 查找网格
      if(typeCd.equals("mesh")){
         String whereSql = null;
         if(!RString.isEmpty(serach)){
            whereSql = FDataResource3dMeshLogic.FULL_CODE + " LIKE '%" + serach + "%'";
         }
         FDataResource3dMeshLogic meshLogic = logicContext.findLogic(FDataResource3dMeshLogic.class);
         FLogicDataset<FDataResource3dMeshUnit> meshUnits = meshLogic.fetch(whereSql, pageSize, page);
         FXmlNode xitems = output.config().createNode("ItemCollection");
         xitems.set("total", meshUnits.total());
         xitems.set("count", meshUnits.count());
         xitems.set("page_size", meshUnits.pageSize());
         xitems.set("page_count", meshUnits.pageCount());
         xitems.set("page", meshUnits.page());
         for(FDataResource3dMeshUnit meshUnit : meshUnits){
            FXmlNode xitem = xitems.createNode("Item");
            xitem.set("guid", meshUnit.guid());
            xitem.set("type", "mesh");
            xitem.set("code", meshUnit.fullCode());
            xitem.set("label", meshUnit.label());
         }
      }else{
         throw new FFatalError("Unknown resource type. (type_cd={1})", typeCd);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        ILogicContext logicContext,
                        IWebInput input,
                        IWebOutput output){
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      String themeCode = context.parameter("theme");
      //............................................................
      // 查找场景
      FDataResource3dSceneUnit sceneUnit = _sceneConsole.findSceneUnit(logicContext, guid, code);
      if(sceneUnit != null){
         // 查找主题
         FDataResource3dSceneThemeUnit themeUnit = _sceneConsole.findThemeUnit(logicContext, sceneUnit.ouid(), themeCode);
         if(themeUnit != null){
            // 生成数据
            FRs3Scene scene = _sceneConsole.makeTheme(logicContext, themeUnit.guid());
            if(scene != null){
               FXmlNode xconfig = output.config().createNode("Scene");
               scene.saveConfig(xconfig);
            }
         }
      }
      return EResult.Success;
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult update(IWebContext context,
                         ILogicContext logicContext,
                         IWebInput input,
                         IWebOutput output){
      //      // 检查输入
      //      FXmlNode xscene = input.config();
      //      if(!xscene.isName("Scene")){
      //         throw new FFatalError("Invalid config code.");
      //      }
      //      // 获得场景
      //      String sceneGuid = xscene.get("guid");
      //      String sceneCode = xscene.get("code");
      //      String theme = context.parameter("theme");
      //      FRs3Scene scene = _sceneConsole.makeScene(logicContext, sceneGuid, sceneCode, theme);
      //      // 合并场景
      //      scene.mergeConfig(xscene);
      //      // 更新场景
      //      _sceneConsole.updateScene(logicContext, scene);
      return EResult.Success;
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult updateTheme(IWebContext context,
                              ILogicContext logicContext,
                              IWebInput input,
                              IWebOutput output){
      // 检查输入
      FXmlNode xscene = input.config();
      if(!xscene.isName("Scene")){
         throw new FFatalError("Invalid config code.");
      }
      // 获得场景
      String themeGuid = xscene.get("theme_guid");
      FRs3Scene scene = _sceneConsole.makeTheme(logicContext, themeGuid);
      // 合并场景
      scene.mergeConfig(xscene);
      // 更新场景
      _contentSceneConsole.updateSceneTheme(logicContext, scene);
      return EResult.Success;
   }
}
