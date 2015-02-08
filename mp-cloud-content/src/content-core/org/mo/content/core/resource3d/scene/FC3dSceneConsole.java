package org.mo.content.core.resource3d.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneLogic;
import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FC3dSceneConsole
      implements
         IC3dSceneConsole
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param version 版本
   //============================================================
   @Override
   public FRs3Scene makeScene(ILogicContext logicContext,
                              String guid,
                              String code){
      // 获得模型信息
      FDataResource3dSceneLogic sceneLogic = logicContext.findLogic(FDataResource3dSceneLogic.class);
      FDataResource3dSceneUnit sceneUnit = sceneLogic.findByGuid(guid);
      if(sceneUnit == null){
         return null;
      }
      // 创建场景
      FRs3Scene scene = new FRs3Scene();
      scene.loadUnit(sceneUnit);
      return scene;
   }
}
