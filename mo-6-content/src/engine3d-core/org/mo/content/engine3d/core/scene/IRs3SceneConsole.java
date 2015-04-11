package org.mo.content.engine3d.core.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneThemeUnit;
import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import org.mo.cloud.logic.resource3d.scene.IGcRs3SceneConsole;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源场景控制台接口。</T>
//============================================================
public interface IRs3SceneConsole
      extends
         IGcRs3SceneConsole
{
   //============================================================
   // <T>根据代码查找资源场景单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   FDataResource3dSceneUnit findByCode(ILogicContext logicContext,
                                       String code);

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
   // <T>导入场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importScene(ILogicContext logicContext,
                       String fileName);
}
