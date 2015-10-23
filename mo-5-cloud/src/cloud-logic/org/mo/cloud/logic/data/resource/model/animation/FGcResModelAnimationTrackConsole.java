package org.mo.cloud.logic.data.resource.model.animation;

import org.mo.cloud.core.storage.mongo.EGcStorageMongoCatalog;
import org.mo.cloud.core.storage.mongo.IGcStorageMongoConsole;

import com.cyou.gccloud.data.data.FDataResourceModelAnimationTrackLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型动画轨迹控制台。</T>
//============================================================
public class FGcResModelAnimationTrackConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelAnimationTrackLogic, FGcResModelAnimationTrackInfo>
      implements
         IGcResModelAnimationTrackConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageMongoConsole _storageConsole;

   //============================================================
   // <T>构造资源模型动画轨迹控制台。</T>
   //============================================================
   public FGcResModelAnimationTrackConsole(){
      super(FDataResourceModelAnimationTrackLogic.class, FGcResModelAnimationTrackInfo.class);
   }

   //============================================================
   // <T>删除记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult onDeleteBefore(ILogicContext logicContext,
                                 FGcResModelAnimationTrackInfo trackInfo){
      // 删除关联数据
      String guid = trackInfo.guid();
      _storageConsole.delete(EGcStorageMongoCatalog.ResourceModelAnimationTrack, guid);
      // 返回结果
      return EResult.Success;
   }
}
