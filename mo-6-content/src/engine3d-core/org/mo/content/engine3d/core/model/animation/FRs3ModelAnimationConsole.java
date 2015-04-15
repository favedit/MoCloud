package org.mo.content.engine3d.core.model.animation;

import com.cyou.gccloud.data.data.FDataResourceModelAnimationTrackLogic;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationConsole;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationInfo;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationTrackInfo;
import org.mo.cloud.logic.resource.model.animation.IGcResModelAnimationTrackConsole;
import org.mo.content.resource3d.common.FRs3Animation;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3ModelAnimationConsole
      extends FGcResModelAnimationConsole
      implements
         IRs3ModelAnimationConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 存储控制台
   @ALink
   protected IGcResModelAnimationTrackConsole _trackConsole;

   //============================================================
   // <T>新建一个跟踪。</T>
   //
   // @param logicContext 逻辑环境
   // @param track 跟踪
   // @return 跟踪单元
   //============================================================
   @Override
   public FGcResModelAnimationTrackInfo insertTrack(ILogicContext logicContext,
                                                    FGcResModelAnimationInfo animationInfo,
                                                    FRs3Track track){
      // 新建跟踪
      FGcResModelAnimationTrackInfo trackInfo = _trackConsole.doPrepare(logicContext);
      trackInfo.setUserId(animationInfo.userId());
      trackInfo.setProjectId(animationInfo.projectId());
      trackInfo.setModelId(animationInfo.modelId());
      trackInfo.setAnimationId(animationInfo.ouid());
      trackInfo.setFrameTick(track.frameTick());
      trackInfo.setFrameCount(track.frameCount());
      trackInfo.setFrameTotal(track.frameTick() * track.frameCount());
      _trackConsole.doInsert(logicContext, trackInfo);
      // 存储数据
      SGcStorage resource = new SGcStorage(EGcStorageCatalog.ResourceModelAnimationTrack, trackInfo.guid());
      resource.setData(track.toArray());
      _storageConsole.store(resource);
      // 返回跟踪单元
      return trackInfo;
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
      FGcResModelAnimationTrackInfo trackInfo = _trackConsole.get(logicContext, trackId);
      // 设置属性
      FRs3Track track = new FRs3Track();
      track.loadUnit(trackInfo);
      // 读取数据
      SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceModelAnimationTrack, trackInfo.guid());
      track.setData(resource.data());
      return track;
   }

   //============================================================
   // <T>构建蒙皮处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 蒙皮
   //============================================================
   @Override
   public FRs3Animation makeAnimation(ILogicContext logicContext,
                                      long animationId){
      FRs3Animation animation = new FRs3Animation();
      // 获得骨骼信息
      FGcResModelAnimationInfo animationInfo = find(logicContext, animationId);
      if(animationInfo == null){
         return null;
      }
      animation.loadUnit(animationInfo);
      // 获得跟踪集合
      FLogicDataset<FGcResModelAnimationTrackInfo> trackInfos = _trackConsole.fetch(logicContext, FDataResourceModelAnimationTrackLogic.ANIMATION_ID + "=" + animationId);
      if(!trackInfos.isEmpty()){
         for(FGcResModelAnimationTrackInfo trackInfo : trackInfos){
            FRs3Track track = makeTrack(logicContext, trackInfo.ouid());
            animation.pushTrack(track);
         }
      }
      return animation;
   }
}
