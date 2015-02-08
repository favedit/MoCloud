package org.mo.content.core.resource3d.scene;

import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>场景控制台接口。</T>
//============================================================
public interface IC3dSceneConsole
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param version 版本
   //============================================================
   FRs3Scene makeScene(ILogicContext logicContext,
                       String guid,
                       String code);
}
