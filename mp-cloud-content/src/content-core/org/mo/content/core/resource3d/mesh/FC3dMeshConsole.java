package org.mo.content.core.resource3d.mesh;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.content.core.resource3d.animation.IC3dAnimationConsole;
import org.mo.content.core.resource3d.skeleton.IC3dSkeletonConsole;
import org.mo.content.engine3d.core.stream.IRs3StreamConsole;
import org.mo.core.aop.face.ALink;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FC3dMeshConsole
      implements
         IC3dMeshConsole
{
   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 数据流管理接口
   @ALink
   protected IRs3StreamConsole _streamConsole;

   // 骨骼管理接口
   @ALink
   protected IC3dSkeletonConsole _skeletonConsole;

   // 动画管理接口
   @ALink
   protected IC3dAnimationConsole _animationConsole;
}
