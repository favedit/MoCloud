package org.mo.content.engine3d.core.skeleton;

import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinUnit;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonUnit;
import org.mo.content.resource3d.common.FRs3Skeleton;
import org.mo.content.resource3d.common.FRs3SkeletonSkin;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源3D蒙皮控制台接口。</T>
//============================================================
public interface IRs3SkeletonConsole
{
   //============================================================
   // <T>根据代码查找骨骼单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   FDataResource3dSkeletonUnit findByCode(ILogicContext logicContext,
                                          String code);

   //============================================================
   // <T>新建一个蒙皮。</T>
   //
   // @param logicContext 逻辑环境
   // @param skeletonId 骨骼编号
   // @param skin 蒙皮
   // @return 蒙皮单元
   //============================================================
   FDataResource3dSkeletonSkinUnit insertSkin(ILogicContext logicContext,
                                              long meshId,
                                              long skeletonId,
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
