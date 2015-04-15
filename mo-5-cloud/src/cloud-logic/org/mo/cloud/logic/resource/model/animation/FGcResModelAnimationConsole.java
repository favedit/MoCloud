package org.mo.cloud.logic.resource.model.animation;

import com.cyou.gccloud.data.data.FDataResourceModelAnimationActionLogic;
import com.cyou.gccloud.data.data.FDataResourceModelAnimationLogic;
import com.cyou.gccloud.data.data.FDataResourceModelAnimationTrackLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型动画控制台。</T>
//============================================================
public class FGcResModelAnimationConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelAnimationLogic, FGcResModelAnimationInfo>
      implements
         IGcResModelAnimationConsole
{
   // 资源模型动画轨迹管理器
   @ALink
   protected IGcResModelAnimationTrackConsole _modelAnimationTrackConsole;

   // 资源模型动画动作管理器
   @ALink
   protected IGcResModelAnimationMovieConsole _modelAnimationMovieConsole;

   //============================================================
   // <T>构造资源模型动画控制台。</T>
   //============================================================
   public FGcResModelAnimationConsole(){
      super(FDataResourceModelAnimationLogic.class, FGcResModelAnimationInfo.class);
   }

   //============================================================
   // <T>删除记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   protected EResult onDeleteBefore(ILogicContext logicContext,
                                    FGcResModelAnimationInfo animation){
      long animationId = animation.ouid();
      // 删除轨迹集合
      String trackWhereSql = FDataResourceModelAnimationTrackLogic.ANIMATION_ID + "=" + animationId;
      FLogicDataset<FGcResModelAnimationTrackInfo> trackDataset = _modelAnimationTrackConsole.fetch(logicContext, trackWhereSql);
      if(trackDataset != null){
         for(FGcResModelAnimationTrackInfo track : trackDataset){
            _modelAnimationTrackConsole.doDelete(logicContext, track);
         }
      }
      // 删除动作集合
      String actionWhereSql = FDataResourceModelAnimationActionLogic.ANIMATION_ID + "=" + animationId;
      FLogicDataset<FGcResModelAnimationActionInfo> actionDataset = _modelAnimationMovieConsole.fetch(logicContext, actionWhereSql);
      if(actionDataset != null){
         for(FGcResModelAnimationActionInfo action : actionDataset){
            _modelAnimationMovieConsole.doDelete(logicContext, action);
         }
      }
      // 返回结果
      return EResult.Success;
   }
}
