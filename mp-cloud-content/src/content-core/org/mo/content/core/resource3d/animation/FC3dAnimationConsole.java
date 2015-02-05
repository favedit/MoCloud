package org.mo.content.core.resource3d.animation;

import com.cyou.gccloud.data.data.FDataResource3dAnimationLogic;
import com.cyou.gccloud.data.data.FDataResource3dAnimationUnit;
import org.mo.content.engine3d.core.stream.IRs3StreamConsole;
import org.mo.content.resource3d.common.FRs3Animation;
import org.mo.core.aop.face.ALink;
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
      //      // 获得蒙皮集合
      //      FDataResource3dSkinLogic skinLogic = logicContext.findLogic(FDataResource3dSkinLogic.class);
      //      FLogicDataset<FDataResource3dSkinUnit> skinUnits = skinLogic.fetch(FDataResource3dSkinLogic.SKELETON_ID + "=" + skeletonUnit.ouid());
      //      for(FDataResource3dSkinUnit skinUnit : skinUnits){
      //         // 创建蒙皮
      //         FRs3SkeletonSkin skin = new FRs3SkeletonSkin();
      //         skin.loadUnit(skinUnit);
      //         // 获得蒙皮数据流集合
      //         FDataResource3dSkinStreamLogic skinStreamLogic = logicContext.findLogic(FDataResource3dSkinStreamLogic.class);
      //         FLogicDataset<FDataResource3dSkinStreamUnit> skinStreamUnits = skinStreamLogic.fetch(FDataResource3dSkinStreamLogic.SKIN_ID + "=" + skinUnit.ouid());
      //         for(FDataResource3dSkinStreamUnit skinStreamUnit : skinStreamUnits){
      //            // 构建数据流
      //            FRs3Stream stream = _streamConsole.makeStream(logicContext, skinStreamUnit.streamId());
      //            skin.pushStream(stream);
      //         }
      //      }
      return animation;
   }
}
