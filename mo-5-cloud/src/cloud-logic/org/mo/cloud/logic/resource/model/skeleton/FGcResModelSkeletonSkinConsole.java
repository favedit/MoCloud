package org.mo.cloud.logic.resource.model.skeleton;

import com.cyou.gccloud.data.data.FDataResourceModelSkeletonSkinLogic;
import com.cyou.gccloud.data.data.FDataResourceModelSkeletonSkinStreamLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼蒙皮控制台。</T>
//============================================================
public class FGcResModelSkeletonSkinConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelSkeletonSkinLogic, FGcResModelSkeletonSkinInfo>
      implements
         IGcResModelSkeletonSkinConsole
{
   // 资源模型骨骼蒙皮数据流管理器
   @ALink
   protected IGcResModelSkeletonSkinStreamConsole _dataModelSkeletonSkinStreamConsole;

   //============================================================
   // <T>构造资源模型骨骼蒙皮控制台。</T>
   //============================================================
   public FGcResModelSkeletonSkinConsole(){
      super(FDataResourceModelSkeletonSkinLogic.class, FGcResModelSkeletonSkinInfo.class);
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
                                    FGcResModelSkeletonSkinInfo skinInfo){
      long skinId = skinInfo.ouid();
      // 删除数据流集合
      String streamWhereSql = FDataResourceModelSkeletonSkinStreamLogic.SKIN_ID + "=" + skinId;
      FLogicDataset<FGcResModelSkeletonSkinStreamInfo> streamDataset = _dataModelSkeletonSkinStreamConsole.fetch(logicContext, streamWhereSql);
      if(streamDataset != null){
         for(FGcResModelSkeletonSkinStreamInfo streamInfo : streamDataset){
            _dataModelSkeletonSkinStreamConsole.doDelete(logicContext, streamInfo);
         }
      }
      // 返回结果
      return EResult.Success;
   }
}
