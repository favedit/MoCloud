package org.mo.content.engine3d.core.model.animation;

import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationInfo;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationTrackInfo;
import org.mo.cloud.logic.resource.model.animation.IGcResModelAnimationConsole;
import org.mo.content.resource3d.common.FRs3Animation;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源动画控制台接口。</T>
//============================================================
public interface IRs3ModelAnimationConsole
      extends
         IGcResModelAnimationConsole
{
   //============================================================
   // <T>新建一个跟踪。</T>
   //
   // @param logicContext 逻辑环境
   // @param track 跟踪
   // @return 跟踪单元
   //============================================================
   FGcResModelAnimationTrackInfo insertTrack(ILogicContext logicContext,
                                             FGcResModelAnimationInfo animationInfo,
                                             FRs3Track track);

   //============================================================
   // <T>构建一个跟踪。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackId 跟踪编号
   // @return 跟踪
   //============================================================
   FRs3Track makeTrack(ILogicContext logicContext,
                       long trackId);

   //============================================================
   // <T>构建蒙皮处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 蒙皮
   //============================================================
   FRs3Animation makeAnimation(ILogicContext logicContext,
                               long animationId);
}
