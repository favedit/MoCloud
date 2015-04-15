package org.mo.content.engine3d.core.model.animation;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationTrackConsole;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationTrackInfo;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3ModelAnimationTrackConsole
      extends FGcResModelAnimationTrackConsole
      implements
         IRs3ModelAnimationTrackConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>更新一个跟踪数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackInfo 跟踪信息
   // @param track 跟踪
   // @return 跟踪单元
   //============================================================
   @Override
   public EResult updateResource(ILogicContext logicContext,
                                 FGcResModelAnimationTrackInfo trackInfo,
                                 FRs3Track track){
      // 新建跟踪
      trackInfo.setFrameTick(track.frameTick());
      trackInfo.setFrameCount(track.frameCount());
      trackInfo.setFrameTotal(track.frameTick() * track.frameCount());
      doUpdate(logicContext, trackInfo);
      // 存储数据
      SGcStorage resource = new SGcStorage(EGcStorageCatalog.ResourceModelAnimationTrack, trackInfo.guid());
      resource.setData(track.toArray());
      _storageConsole.store(resource);
      // 返回结果
      return EResult.Success;
   }

   //============================================================
   // <T>构建一个跟踪。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackId 跟踪编号
   // @return 跟踪
   //============================================================
   @Override
   public FRs3Track makeTrack(ILogicContext logicContext,
                              long trackId){
      // 获得跟踪单元
      FGcResModelAnimationTrackInfo trackInfo = get(logicContext, trackId);
      // 设置属性
      FRs3Track track = new FRs3Track();
      track.loadUnit(trackInfo);
      // 读取数据
      SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceModelAnimationTrack, trackInfo.guid());
      track.setData(resource.data());
      return track;
   }
}
