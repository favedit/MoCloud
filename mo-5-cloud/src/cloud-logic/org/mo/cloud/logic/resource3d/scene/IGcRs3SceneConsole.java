package org.mo.cloud.logic.resource3d.scene;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源场景控制台接口。</T>
//============================================================
public interface IGcRs3SceneConsole
      extends
         IAbstractLogicUnitConsole<FGcRs3SceneInfo>
{
   //============================================================
   // <T>根据用户编号和项目编号和代码查找场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param projectId 项目编号
   // @param code 场景代码
   // @return 场景信息
   //============================================================
   FGcRs3SceneInfo findByCode(ILogicContext logicContext,
                              long userId,
                              long projectId,
                              String code);
}
