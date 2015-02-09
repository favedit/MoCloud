package org.mo.content.engine3d.core.scene;

import com.cyou.gccloud.data.data.FDataResource3dMaterialGroupUnit;
import com.cyou.gccloud.data.data.FDataResource3dSceneLogic;
import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import com.cyou.gccloud.data.data.FDataResource3dTemplateUnit;
import org.mo.com.console.FConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.content.engine3d.core.template.IRs3TemplateConsole;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.content.resource3d.scene.FRs3SceneDisplay;
import org.mo.content.resource3d.scene.FRs3SceneMaterial;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源场景控制台。</T>
//============================================================
public class FRs3SceneConsole
      extends FConsole
      implements
         IRs3SceneConsole
{
   // 资源模板控制台
   @ALink
   protected IRs3TemplateConsole _templateConsole;

   //============================================================
   // <T>根据代码查找场景单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FDataResource3dSceneUnit findByCode(ILogicContext logicContext,
                                              String code){
      String searchSql = FDataResource3dSceneLogic.CODE + "='" + code + "'";
      FDataResource3dSceneLogic logic = logicContext.findLogic(FDataResource3dSceneLogic.class);
      FDataResource3dSceneUnit unit = logic.search(searchSql);
      return unit;
   }

   //============================================================
   // <T>导入场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param input 输入流
   // @return 处理结果
   //============================================================
   @Override
   public EResult importScene(ILogicContext logicContext,
                              String fileName){
      // 加载模型资源
      FRs3Scene scene = new FRs3Scene();
      scene.loadFile(fileName);
      //............................................................
      // 关联显示集合
      FObjects<FRs3SceneDisplay> displays = scene.filterDisplays();
      for(FRs3SceneDisplay display : displays){
         String displayCode = display.code();
         FDataResource3dTemplateUnit templateUnit = _templateConsole.findByCode(logicContext, displayCode);
         if(templateUnit == null){
            throw new FFatalError("Template unit is not exists. (code={1})", displayCode);
         }
         display.setTemplateGuid(templateUnit.guid());
         // 关联材质集合
         if(display.hasMaterial()){
            for(FRs3SceneMaterial material : display.materials()){
               FDataResource3dMaterialGroupUnit materialGroupUnit = _templateConsole.findMaterialGroupByCode(logicContext, templateUnit.ouid(), material.code());
               if(materialGroupUnit == null){
                  throw new FFatalError("Material group is not exists. (code={1})", material.code());
               }
               material.setGroupGuid(materialGroupUnit.guid());
            }
         }
      }
      //............................................................
      // 新建场景
      FDataResource3dSceneLogic sceneLogic = logicContext.findLogic(FDataResource3dSceneLogic.class);
      FDataResource3dSceneUnit sceneUnit = sceneLogic.doPrepare();
      scene.setGuid(sceneUnit.guid());
      scene.saveUnit(sceneUnit);
      sceneLogic.doInsert(sceneUnit);
      return EResult.Success;
   }
}
