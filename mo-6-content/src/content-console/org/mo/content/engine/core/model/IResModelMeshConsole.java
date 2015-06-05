package org.mo.content.engine.core.model;

import org.mo.cloud.logic.resource.model.FGcResModelInfo;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.model.mesh.IGcResModelMeshConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.content.resource.model.FResModelMesh;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型网格控制台接口。</T>
//============================================================
public interface IResModelMeshConsole
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
   // <T>新建资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param mesh 网格数据
   // @return 网格信息
   //============================================================
   FGcResModelMeshInfo insertResource(ILogicContext logicContext,
                                      FGcSessionInfo session,
                                      FGcResModelInfo modelInfo,
                                      FResModelMesh mesh);

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param meshInfo 网格信息
   // @param mesh 网格数据
   // @return 网格信息
   //============================================================
   FGcResModelMeshInfo updateResource(ILogicContext logicContext,
                                      FGcSessionInfo session,
                                      FGcResModelInfo modelInfo,
                                      FGcResModelMeshInfo meshInfo,
                                      FResModelMesh mesh);

   //============================================================
   // <T>导入资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param mesh 网格数据
   // @return 网格信息
   //============================================================
   FGcResModelMeshInfo importResource(ILogicContext logicContext,
                                      FGcSessionInfo session,
                                      FGcResModelInfo modelInfo,
                                      FResModelMesh mesh);
}
