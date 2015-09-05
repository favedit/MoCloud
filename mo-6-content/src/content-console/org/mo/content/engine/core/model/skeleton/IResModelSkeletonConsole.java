package org.mo.content.engine.core.model.skeleton;

import org.mo.cloud.logic.data.resource.model.skeleton.FGcResModelSkeletonInfo;
import org.mo.cloud.logic.data.resource.model.skeleton.FGcResModelSkeletonSkinInfo;
import org.mo.cloud.logic.data.resource.model.skeleton.IGcResModelSkeletonConsole;

import org.mo.cloud.logic.data.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.content.resource.common.FResSkeleton;
import org.mo.content.resource.common.FResSkeletonSkin;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼控制台接口。</T>
//============================================================
public interface IResModelSkeletonConsole
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
                                          FResSkeletonSkin skin);

   //============================================================
   // <T>构建蒙皮处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 蒙皮
   //============================================================
   FResSkeleton makeSkeleton(ILogicContext logicContext,
                             long modelId,
                             long skeletonId);
}
