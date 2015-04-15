package org.mo.cloud.logic.resource.model.animation;

import com.cyou.gccloud.data.data.FDataResourceModelAnimationTrackLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>资源模型动画轨迹控制台。</T>
//============================================================
public class FGcResModelAnimationTrackConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelAnimationTrackLogic, FGcResModelAnimationTrackInfo>
      implements
         IGcResModelAnimationTrackConsole
{
   //============================================================
   // <T>构造资源模型动画轨迹控制台。</T>
   //============================================================
   public FGcResModelAnimationTrackConsole(){
      super(FDataResourceModelAnimationTrackLogic.class, FGcResModelAnimationTrackInfo.class);
   }
}
