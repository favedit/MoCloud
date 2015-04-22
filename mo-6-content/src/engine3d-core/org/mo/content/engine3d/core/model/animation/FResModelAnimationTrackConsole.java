package org.mo.content.engine3d.core.model.animation;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationTrackConsole;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationTrackInfo;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型动画轨迹控制台。</T>
//============================================================
public class FResModelAnimationTrackConsole
      extends FGcResModelAnimationTrackConsole
      implements
         IResModelAnimationTrackConsole
{
   //============================================================
   // <T>更新轨迹数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackInfo 轨迹信息
   // @param track 轨迹
   // @return 跟踪单元
   //============================================================
   @Override
   public EResult updateResource(ILogicContext logicContext,
                                 FGcResModelAnimationTrackInfo trackInfo,
                                 FRs3Track track){
      String guid = trackInfo.guid();
      // 新建跟踪
      trackInfo.setFrameTick(track.frameTick());
      trackInfo.setFrameCount(track.frameCount());
      trackInfo.setFrameTotal(track.frameTick() * track.frameCount());
      doUpdate(logicContext, trackInfo);
      // 存储数据
      SGcStorage resource = new SGcStorage(EGcStorageCatalog.ResourceModelAnimationTrack, guid);
      resource.setData(track.toArray());
      _storageConsole.store(resource);
      // 返回结果
      return EResult.Success;
   }

   //============================================================
   // <T>构建轨迹数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackInfo 轨迹信息
   // @return 轨迹
   //============================================================
   @Override
   public FRs3Track makeTrack(ILogicContext logicContext,
                              FGcResModelAnimationTrackInfo trackInfo){
      String guid = trackInfo.guid();
      // 设置属性
      FRs3Track track = new FRs3Track();
      track.loadUnit(trackInfo);
      // 读取数据
      SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceModelAnimationTrack, guid);
      track.setData(resource.data());
      return track;
   }

   //============================================================
   // <T>构建轨迹数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackId 轨迹编号
   // @return 轨迹
   //============================================================
   @Override
   public FRs3Track makeTrack(ILogicContext logicContext,
                              long trackId){
      FGcResModelAnimationTrackInfo trackInfo = get(logicContext, trackId);
      return makeTrack(logicContext, trackInfo);
   }
}