package org.mo.content.core.resource3d.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneThemeUnit;
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
   // <T>查找场景单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 场景唯一编码
   // @param code 场景代码
   // @return 场景单元
   //============================================================
   FDataResource3dSceneUnit findSceneUnit(ILogicContext logicContext,
                                          String guid,
                                          String code);

   //============================================================
   // <T>查找场景主题单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param sceneId 场景编码
   // @param themeCode 主题代码
   // @return 场景主题单元
   //============================================================
   FDataResource3dSceneThemeUnit findThemeUnit(ILogicContext logicContext,
                                               long sceneId,
                                               String themeCode);

   //============================================================
   // <T>生成场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编码
   // @return 场景
   //============================================================
   FRs3Scene makeTheme(ILogicContext logicContext,
                       String guid);

   //============================================================
   // <T>生成场景主题。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编码
   // @return 场景主题
   //============================================================
   byte[] makeThemeData(ILogicContext logicContext,
                        String guid);

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
