package org.mo.content.core.resource3d.skeleton;

import org.mo.content.resource3d.common.FRs3Skeleton;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台接口。</T>
//============================================================
public interface IC3dSkeletonConsole
{
   //============================================================
   // <T>构建蒙皮处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 蒙皮
   //============================================================
   FRs3Skeleton makeSkeleton(ILogicContext logicContext,
                             long modelId,
                             long skeletonId);
}
