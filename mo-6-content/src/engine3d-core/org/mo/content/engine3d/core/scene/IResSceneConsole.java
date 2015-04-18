package org.mo.content.engine3d.core.scene;

import org.mo.cloud.logic.resource.scene.FGcResSceneInfo;
import org.mo.cloud.logic.resource.scene.IGcResSceneConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源场景控制台接口。</T>
//============================================================
public interface IResSceneConsole
      extends
         IGcResSceneConsole
{
   //============================================================
   // <T>生成场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param sceneLogic 场景信息
   // @return 场景
   //============================================================
   FRs3Scene makeScene(ILogicContext logicContext,
                       FGcResSceneInfo sceneLogic);

   //============================================================
   // <T>生成场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编码
   // @return 场景
   //============================================================
   FRs3Scene makeScene(ILogicContext logicContext,
                       String guid);

   //============================================================
   // <T>生成场景数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编码
   // @return 场景数据
   //============================================================
   byte[] makeSceneData(ILogicContext logicContext,
                        String guid);

   //============================================================
   // <T>更新场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param scene 场景
   // @return 场景信息
   //============================================================
   FGcResSceneInfo updateResource(ILogicContext logicContext,
                                  FRs3Scene scene);

   //============================================================
   // <T>导入资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importResource(ILogicContext logicContext,
                          FGcSessionInfo session,
                          String fileName);
}
