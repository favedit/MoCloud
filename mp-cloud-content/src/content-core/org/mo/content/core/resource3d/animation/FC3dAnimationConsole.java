package org.mo.content.core.resource3d.animation;

import com.cyou.gccloud.data.data.FDataResource3dAnimationLogic;
import com.cyou.gccloud.data.data.FDataResource3dAnimationTrackLogic;
import com.cyou.gccloud.data.data.FDataResource3dAnimationTrackUnit;
import com.cyou.gccloud.data.data.FDataResource3dAnimationUnit;
import org.mo.com.lang.FObjects;
import org.mo.content.engine3d.core.animation.IRs3AnimationConsole;
import org.mo.content.engine3d.core.stream.IRs3StreamConsole;
import org.mo.content.resource3d.common.FRs3Animation;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FC3dAnimationConsole
      implements
         IC3dAnimationConsole
{
   // 存储管理接口
   @ALink
   protected IRs3StreamConsole _streamConsole;

   // 动画管理接口
   @ALink
   protected IRs3AnimationConsole _animationConsole;

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
      FDataResource3dAnimationLogic animationLogic = logicContext.findLogic(FDataResource3dAnimationLogic.class);
      FDataResource3dAnimationUnit animationUnit = animationLogic.find(animationId);
      if(animationUnit == null){
         return null;
      }
      animation.loadUnit(animationUnit);
      // 获得跟踪集合
      FDataResource3dAnimationTrackLogic animationTrackLogic = logicContext.findLogic(FDataResource3dAnimationTrackLogic.class);
      FLogicDataset<FDataResource3dAnimationTrackUnit> animationTrackUnits = animationTrackLogic.fetch(FDataResource3dAnimationTrackLogic.ANIMATION_ID + "=" + animationId);
      if(!animationTrackUnits.isEmpty()){
         FObjects<FRs3Track> tracks = animation.tracks();
         for(FDataResource3dAnimationTrackUnit animationTrackUnit : animationTrackUnits){
            FRs3Track track = _animationConsole.makeTrack(logicContext, animationTrackUnit.trackId());
            tracks.push(track);
         }
      }
      return animation;
   }
}
