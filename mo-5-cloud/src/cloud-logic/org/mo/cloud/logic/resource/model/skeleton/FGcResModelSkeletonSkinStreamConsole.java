package org.mo.cloud.logic.resource.model.skeleton;

import com.cyou.gccloud.data.data.FDataResourceModelSkeletonSkinStreamLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼蒙皮数据流控制台。</T>
//============================================================
public class FGcResModelSkeletonSkinStreamConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelSkeletonSkinStreamLogic, FGcResModelSkeletonSkinStreamInfo>
      implements
         IGcResModelSkeletonSkinStreamConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>构造资源模型骨骼蒙皮数据流控制台。</T>
   //============================================================
   public FGcResModelSkeletonSkinStreamConsole(){
      super(FDataResourceModelSkeletonSkinStreamLogic.class, FGcResModelSkeletonSkinStreamInfo.class);
   }

   //============================================================
   // <T>根据蒙皮编号查找数据流集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param skinId 蒙皮编号
   // @return 数据流集合
   //============================================================
   @Override
   public FLogicDataset<FGcResModelSkeletonSkinStreamInfo> fetchStreams(ILogicContext logicContext,
                                                                        long skinId){
      String serachSql = FDataResourceModelSkeletonSkinStreamLogic.SKIN_ID + "=" + skinId;
      String orderSql = FDataResourceModelSkeletonSkinStreamLogic.SORT_INDEX + " ASC";
      FLogicDataset<FGcResModelSkeletonSkinStreamInfo> dataset = fetch(logicContext, serachSql, orderSql);
      return dataset;
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
                                 FGcResModelSkeletonSkinStreamInfo streamInfo){
      // 删除关联数据
      String guid = streamInfo.guid();
      _storageConsole.delete(EGcStorageCatalog.ResourceModelSkeletonSkinStream, guid);
      // 返回结果
      return EResult.Success;
   }
}
