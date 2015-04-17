package org.mo.content.engine3d.core.model.animation;

import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationTrackInfo;
import org.mo.cloud.logic.resource.model.animation.IGcResModelAnimationTrackConsole;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型动画轨迹控制台接口。</T>
//============================================================
public interface IRs3ModelAnimationTrackConsole
      extends
         IGcResModelAnimationTrackConsole
{
   //============================================================
   // <T>更新轨迹数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackInfo 轨迹信息
   // @param track 轨迹
   // @return 跟踪单元
   //============================================================
   EResult updateResource(ILogicContext logicContext,
                          FGcResModelAnimationTrackInfo trackInfo,
                          FRs3Track track);

   //============================================================
   // <T>构建轨迹数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackInfo 轨迹信息
   // @return 轨迹
   //============================================================
   FRs3Track makeTrack(ILogicContext logicContext,
                       FGcResModelAnimationTrackInfo trackInfo);

   //============================================================
   // <T>构建轨迹数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackId 轨迹编号
   // @return 轨迹
   //============================================================
   FRs3Track makeTrack(ILogicContext logicContext,
                       long trackId);
}