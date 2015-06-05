package org.mo.content.engine.core.model;

import org.mo.cloud.logic.resource.model.FGcResModelInfo;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshStreamInfo;
import org.mo.cloud.logic.resource.model.mesh.IGcResModelMeshStreamConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.content.resource.common.FResStream;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型网格数据流控制台接口。</T>
//============================================================
public interface IResModelMeshStreamConsole
      extends
         IGcResModelMeshStreamConsole
{
   //============================================================
   // <T>构建一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamInfo 数据流信息
   // @return 数据流
   //============================================================
   FResStream makeStream(ILogicContext logicContext,
                         FGcResModelMeshStreamInfo streamInfo);

   //============================================================
   // <T>构建一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamId 数据流编号
   // @return 数据流
   //============================================================
   FResStream makeStream(ILogicContext logicContext,
                         long streamId);

   //============================================================
   // <T>新建资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param meshInfo 网格信息
   // @param stream 数据流
   // @return 数据流信息
   //============================================================
   FGcResModelMeshStreamInfo insertResource(ILogicContext logicContext,
                                            FGcSessionInfo session,
                                            FGcResModelInfo modelInfo,
                                            FGcResModelMeshInfo meshInfo,
                                            FResStream stream);

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param meshInfo 网格信息
   // @param streamInfo 数据流信息
   // @param stream 数据流
   // @return 数据流信息
   //============================================================
   FGcResModelMeshStreamInfo updateResource(ILogicContext logicContext,
                                            FGcSessionInfo session,
                                            FGcResModelInfo modelInfo,
                                            FGcResModelMeshInfo meshInfo,
                                            FGcResModelMeshStreamInfo streamInfo,
                                            FResStream stream);

   //============================================================
   // <T>导入资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param meshInfo 网格信息
   // @param stream 数据流
   // @return 数据流信息
   //============================================================
   FGcResModelMeshStreamInfo importResource(ILogicContext logicContext,
                                            FGcSessionInfo session,
                                            FGcResModelInfo modelInfo,
                                            FGcResModelMeshInfo meshInfo,
                                            FResStream stream);
}
