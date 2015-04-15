package org.mo.content.engine3d.core.model.animation;

import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationTrackInfo;
import org.mo.cloud.logic.resource.model.animation.IGcResModelAnimationTrackConsole;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源动画控制台接口。</T>
//============================================================
public interface IRs3ModelAnimationTrackConsole
      extends
         IGcResModelAnimationTrackConsole
{
   //============================================================
   // <T>更新一个跟踪数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackInfo 跟踪信息
   // @param track 跟踪
   // @return 跟踪单元
   //============================================================
   EResult updateResource(ILogicContext logicContext,
                          FGcResModelAnimationTrackInfo trackInfo,
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
}
