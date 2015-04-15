package org.mo.cloud.logic.resource.model.skeleton;

import com.cyou.gccloud.data.data.FDataResourceModelSkeletonLogic;
import com.cyou.gccloud.data.data.FDataResourceModelSkeletonSkinLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼控制台。</T>
//============================================================
public class FGcResModelSkeletonConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelSkeletonLogic, FGcResModelSkeletonInfo>
      implements
         IGcResModelSkeletonConsole
{
   // 资源模型骨骼蒙皮管理器
   @ALink
   protected IGcResModelSkeletonSkinConsole _dataModelAnimationTrackConsole;

   //============================================================
   // <T>构造资源模型骨骼控制台。</T>
   //============================================================
   public FGcResModelSkeletonConsole(){
      super(FDataResourceModelSkeletonLogic.class, FGcResModelSkeletonInfo.class);
   }

   //============================================================
   // <T>根据代码查找骨骼单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FGcResModelSkeletonInfo findByCode(ILogicContext logicContext,
                                             String code){
      String searchSql = FDataResourceModelSkeletonLogic.CODE + "='" + code + "'";
      FGcResModelSkeletonInfo skeletonInfo = search(logicContext, searchSql);
      return skeletonInfo;
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
                                    FGcResModelSkeletonInfo skeletonInfo){
      long skeletonId = skeletonInfo.ouid();
      // 删除蒙皮集合
      String skinWhereSql = FDataResourceModelSkeletonSkinLogic.SKELETON_ID + "=" + skeletonId;
      FLogicDataset<FGcResModelSkeletonSkinInfo> skinDataset = _dataModelAnimationTrackConsole.fetch(logicContext, skinWhereSql);
      if(skinDataset != null){
         for(FGcResModelSkeletonSkinInfo skinInfo : skinDataset){
            _dataModelAnimationTrackConsole.doDelete(logicContext, skinInfo);
         }
      }
      // 返回结果
      return EResult.Success;
   }
}
