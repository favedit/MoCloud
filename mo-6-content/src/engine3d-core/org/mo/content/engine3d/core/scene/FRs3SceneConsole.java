package org.mo.content.engine3d.core.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneLogic;
import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.console.FConsole;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.scene.FRs3Scene;
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
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

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
      // 新建场景
      FDataResource3dSceneLogic sceneLogic = logicContext.findLogic(FDataResource3dSceneLogic.class);
      FDataResource3dSceneUnit sceneUnit = sceneLogic.doPrepare();
      scene.setGuid(sceneUnit.guid());
      scene.saveUnit(sceneUnit);
      sceneLogic.doInsert(sceneUnit);
      return EResult.Success;
   }
}
