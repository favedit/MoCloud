package org.mo.content.engine.core.model.animation;

import org.mo.cloud.logic.data.resource.model.skeleton.FGcResModelSkeletonInfo;

import org.mo.cloud.logic.data.resource.model.animation.FGcResModelAnimationConsole;
import org.mo.cloud.logic.data.resource.model.animation.FGcResModelAnimationInfo;
import org.mo.cloud.logic.data.resource.model.animation.FGcResModelAnimationTrackInfo;
import com.cyou.gccloud.data.data.FDataResourceModelAnimationTrackLogic;
import org.mo.content.engine.core.model.skeleton.IResModelSkeletonConsole;
import org.mo.content.resource.common.FResAnimation;
import org.mo.content.resource.common.FResTrack;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型动画控制台。</T>
//============================================================
public class FResModelAnimationConsole
      extends FGcResModelAnimationConsole
      implements
         IResModelAnimationConsole
{
   // 资源模型动画轨迹控制台
   @ALink
   protected IResModelSkeletonConsole _skeletonConsole;

   // 资源模型动画轨迹控制台
   @ALink
   protected IResModelAnimationTrackConsole _modelAnimationTrackConsole;

   //============================================================
   // <T>构建动画处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param animationInfo 动画信息
   // @return 动画
   //============================================================
   @Override
   public FResAnimation makeAnimation(ILogicContext logicContext,
                                      FGcResModelAnimationInfo animationInfo){
      long animationId = animationInfo.ouid();
      // 获得骨骼信息
      FResAnimation animation = new FResAnimation();
      animation.loadUnit(animationInfo);
      // 查找骨骼信息
      long skeletonId = animationInfo.skeletonId();
      if(skeletonId != 0){
         FGcResModelSkeletonInfo skeletonInfo = _skeletonConsole.find(logicContext, skeletonId);
         animation.setSkeletonGuid(skeletonInfo.guid());
      }
      // 获得跟踪集合
      String whereSql = FDataResourceModelAnimationTrackLogic.ANIMATION_ID + "=" + animationId;
      FLogicDataset<FGcResModelAnimationTrackInfo> trackInfos = _dataModelAnimationTrackConsole.fetch(logicContext, whereSql);
      if(!trackInfos.isEmpty()){
         for(FGcResModelAnimationTrackInfo trackInfo : trackInfos){
            FResTrack track = _modelAnimationTrackConsole.makeTrack(logicContext, trackInfo);
            animation.pushTrack(track);
         }
      }
      // 打包数据
      animation.pack();
      return animation;
   }

   //============================================================
   // <T>构建蒙皮处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 蒙皮
   //============================================================
   @Override
   public FResAnimation makeAnimation(ILogicContext logicContext,
                                      long animationId){
      FGcResModelAnimationInfo animationInfo = get(logicContext, animationId);
      return makeAnimation(logicContext, animationInfo);
   }
}
