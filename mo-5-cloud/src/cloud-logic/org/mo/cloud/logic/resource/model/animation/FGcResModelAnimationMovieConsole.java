package org.mo.cloud.logic.resource.model.animation;

import com.cyou.gccloud.data.data.FDataResourceModelAnimationActionLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>资源模型动画动作控制台。</T>
//============================================================
public class FGcResModelAnimationMovieConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelAnimationActionLogic, FGcResModelAnimationActionInfo>
      implements
         IGcResModelAnimationMovieConsole
{
   //============================================================
   // <T>构造资源模型动画动作控制台。</T>
   //============================================================
   public FGcResModelAnimationMovieConsole(){
      super(FDataResourceModelAnimationActionLogic.class, FGcResModelAnimationActionInfo.class);
   }
}
