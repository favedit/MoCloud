package com.cyou.gccloud.logic.resource3d.mesh;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格控制台接口。</T>
//============================================================
public interface IGcRs3MeshConsole
      extends
         IAbstractLogicUnitConsole<FGcRs3MeshUnit>
{
   //============================================================
   // <T>根据代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 网格单元
   //============================================================
   FGcRs3MeshUnit findByCode(ILogicContext logicContext,
                             String code);

   //============================================================
   // <T>根据全代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param fullCode 全代码
   // @return 网格单元
   //============================================================
   FGcRs3MeshUnit findByFullCode(ILogicContext logicContext,
                                 String fullCode);
}
