package org.mo.cloud.logic.resource.model.skeleton;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼蒙皮数据流控制台接口。</T>
//============================================================
public interface IGcResModelSkeletonSkinStreamConsole
      extends
         IAbstractLogicUnitConsole<FGcResModelSkeletonSkinStreamInfo>
{
   //============================================================
   // <T>根据蒙皮编号查找数据流集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param skinId 蒙皮编号
   // @return 数据流集合
   //============================================================
   FLogicDataset<FGcResModelSkeletonSkinStreamInfo> fetchStreams(ILogicContext logicContext,
                                                                 long skinId);
}
