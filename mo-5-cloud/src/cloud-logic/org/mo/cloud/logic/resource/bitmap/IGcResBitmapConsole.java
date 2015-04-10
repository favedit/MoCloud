package org.mo.cloud.logic.resource.bitmap;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源位图信息控制台接口。</T>
//============================================================
public interface IGcResBitmapConsole
      extends
         IAbstractLogicUnitConsole<FGcResBitmapInfo>
{
   //============================================================
   // <T>根据资源编号查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceId 资源编号
   // @return 位图信息
   //============================================================
   FGcResBitmapInfo findByResourceId(ILogicContext logicContext,
                                     long resourceId);

   //============================================================
   // <T>根据资源唯一编号查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceGuid 资源唯一编号
   // @return 位图信息
   //============================================================
   FGcResBitmapInfo findByResourceGuid(ILogicContext logicContext,
                                       String resourceGuid);
}
