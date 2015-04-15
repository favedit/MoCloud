package org.mo.cloud.logic.resource.model.skeleton;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼控制台接口。</T>
//============================================================
public interface IGcResModelSkeletonConsole
      extends
         IAbstractLogicUnitConsole<FGcResModelSkeletonInfo>
{
   //============================================================
   // <T>根据代码查找骨骼单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   FGcResModelSkeletonInfo findByCode(ILogicContext logicContext,
                                      String code);
}
