package org.mo.cloud.logic.data.resource.material;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源材质信息控制台接口。</T>
//============================================================
public interface IGcResMaterialConsole
      extends
         IAbstractLogicUnitConsole<FGcResMaterialInfo>
{
   //============================================================
   // <T>根据资源编号查找材质信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceId 资源编号
   // @return 材质信息
   //============================================================
   FGcResMaterialInfo findByResourceId(ILogicContext logicContext,
                                       long resourceId);

   //============================================================
   // <T>根据资源唯一编号查找材质信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceGuid 资源唯一编号
   // @return 材质信息
   //============================================================
   FGcResMaterialInfo findByResourceGuid(ILogicContext logicContext,
                                         String resourceGuid);

   //============================================================
   // <T>根据用户编号和代码查找材质信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param code 代码
   // @return 材质信息
   //============================================================
   FGcResMaterialInfo findByUserCode(ILogicContext logicContext,
                                     long userId,
                                     String code);
}
