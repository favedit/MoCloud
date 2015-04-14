package org.mo.content.engine3d.core.model;

import org.mo.cloud.logic.resource.model.FGcResModelMeshStreamInfo;
import org.mo.cloud.logic.resource.model.IGcResModelMeshStreamConsole;
import org.mo.content.resource3d.common.FRs3Stream;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型网格数据流控制台接口。</T>
//============================================================
public interface IRs3ModelMeshStreamConsole
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
   FRs3Stream makeStream(ILogicContext logicContext,
                         FGcResModelMeshStreamInfo streamInfo);

   //============================================================
   // <T>构建一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamId 数据流编号
   // @return 数据流
   //============================================================
   FRs3Stream makeStream(ILogicContext logicContext,
                         long streamId);

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamId 数据流编号
   // @param stream 数据流
   // @return 数据流信息
   //============================================================
   FGcResModelMeshStreamInfo updateResource(ILogicContext logicContext,
                                            long streamId,
                                            FRs3Stream stream);
}
