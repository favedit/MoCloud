package org.mo.content.core.resource3d.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>场景控制台接口。</T>
//============================================================
public interface IC3dSceneConsole
      extends
         IAbstractLogicUnitConsole<FDataResource3dSceneUnit>
{

   //============================================================
   // <T>更新场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param scene 场景
   //============================================================
   EResult updateScene(ILogicContext logicContext,
                       FRs3Scene scene);

   //============================================================
   // <T>更新场景主题。</T>
   //
   // @param logicContext 逻辑环境
   // @param scene 场景
   //============================================================
   EResult updateSceneTheme(ILogicContext logicContext,
                            FRs3Scene scene);
}
