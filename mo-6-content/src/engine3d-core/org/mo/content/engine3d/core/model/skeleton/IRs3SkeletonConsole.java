package org.mo.content.engine3d.core.model.skeleton;

import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.model.skeleton.FGcResModelSkeletonInfo;
import org.mo.cloud.logic.resource.model.skeleton.FGcResModelSkeletonSkinInfo;
import org.mo.cloud.logic.resource.model.skeleton.IGcResModelSkeletonConsole;
import org.mo.content.resource3d.common.FRs3Skeleton;
import org.mo.content.resource3d.common.FRs3SkeletonSkin;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼控制台接口。</T>
//============================================================
public interface IRs3SkeletonConsole
      extends
         IGcResModelSkeletonConsole
{
   //============================================================
   // <T>新建一个蒙皮。</T>
   //
   // @param logicContext 逻辑环境
   // @param skeletonId 骨骼编号
   // @param skin 蒙皮
   // @return 蒙皮单元
   //============================================================
   FGcResModelSkeletonSkinInfo insertSkin(ILogicContext logicContext,
                                          FGcResModelMeshInfo meshInfo,
                                          FGcResModelSkeletonInfo skeletonInfo,
                                          FRs3SkeletonSkin skin);

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
