package org.mo.content.engine3d.core.model;

import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.model.mesh.IGcResModelMeshConsole;

import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型网格控制台接口。</T>
//============================================================
public interface IRs3ModelMeshConsole
      extends
         IGcResModelMeshConsole
{
   //   //============================================================
   //   // <T>根据代码查找网格单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 网格单元
   //   //============================================================
   //   FDataResource3dMeshUnit findByGuid(ILogicContext logicContext,
   //                                      String guid);
   //
   //   //============================================================
   //   // <T>根据代码查找网格单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 网格单元
   //   //============================================================
   //   FDataResource3dMeshUnit findByCode(ILogicContext logicContext,
   //                                      String code);
   //
   //   //============================================================
   //   // <T>更新网格。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param mesh 网格
   //   // @return 网格单元
   //   //============================================================
   //   FDataResource3dMeshUnit updateMesh(ILogicContext logicContext,
   //                                      FRs3Mesh mesh);
   //
   //   //============================================================
   //   // <T>生成资源网格。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 资源网格
   //   //============================================================
   //   FRs3Mesh makeMesh(ILogicContext logicContext,
   //                     String guid);
   //
   //   //============================================================
   //   // <T>生成资源网格数据。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 资源网格数据
   //   //============================================================
   //   byte[] makeMeshData(ILogicContext logicContext,
   //                       String guid);
   //

   //
   //   //============================================================
   //   // <T>新建网格。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param mesh 网格
   //   // @return 网格单元
   //   //============================================================
   //   FDataResource3dMeshUnit insert(ILogicContext logicContext,
   //                                  FRs3ModelMesh mesh);
   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param meshInfo 网格信息
   // @param mesh 网格数据
   // @return 网格信息
   //============================================================
   FGcResModelMeshInfo updateResource(ILogicContext logicContext,
                                      FGcResModelMeshInfo meshInfo,
                                      FRs3ModelMesh mesh);
}
