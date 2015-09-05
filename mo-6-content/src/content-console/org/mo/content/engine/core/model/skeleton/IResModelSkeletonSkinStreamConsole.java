package org.mo.content.engine.core.model.skeleton;

import org.mo.cloud.logic.data.resource.model.skeleton.FGcResModelSkeletonSkinStreamInfo;
import org.mo.cloud.logic.data.resource.model.skeleton.IGcResModelSkeletonSkinStreamConsole;

import org.mo.content.resource.common.FResStream;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼蒙皮数据流控制台接口。</T>
//============================================================
public interface IResModelSkeletonSkinStreamConsole
      extends
         IGcResModelSkeletonSkinStreamConsole
{
   //============================================================
   // <T>构建一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamInfo 数据流信息
   // @return 数据流
   //============================================================
   FResStream makeStream(ILogicContext logicContext,
                         FGcResModelSkeletonSkinStreamInfo streamInfo);

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
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamInfo 数据流信息
   // @param stream 数据流
   // @return 数据流信息
   //============================================================
   FGcResModelSkeletonSkinStreamInfo updateResource(ILogicContext logicContext,
                                                    FGcResModelSkeletonSkinStreamInfo streamInfo,
                                                    FResStream stream);
}
