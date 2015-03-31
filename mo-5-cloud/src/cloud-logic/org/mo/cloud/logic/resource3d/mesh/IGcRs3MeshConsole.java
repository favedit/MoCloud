package org.mo.cloud.logic.resource3d.mesh;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格控制台接口。</T>
//============================================================
public interface IGcRs3MeshConsole
      extends
         IAbstractLogicUnitConsole<FGcRs3MeshInfo>
{
   //============================================================
   // <T>根据代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 网格信息
   //============================================================
   FGcRs3MeshInfo findByCode(ILogicContext logicContext,
                             String code);

   //============================================================
   // <T>根据全代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param fullCode 全代码
   // @return 网格信息
   //============================================================
   FGcRs3MeshInfo findByFullCode(ILogicContext logicContext,
                                 String fullCode);

   //============================================================
   // <T>根据用户编号和代码查找网格信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param code 项目代码
   // @return 网格信息
   //============================================================
   FGcRs3MeshInfo findByUserCode(ILogicContext logicContext,
                                 long userId,
                                 String code);
}
