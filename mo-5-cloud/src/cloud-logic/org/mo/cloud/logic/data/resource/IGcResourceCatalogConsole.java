package org.mo.cloud.logic.data.resource;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源目录控制台接口。</T>
//============================================================
public interface IGcResourceCatalogConsole
      extends
         IAbstractLogicUnitConsole<FGcResourceCatalogInfo>
{
   //============================================================
   // <T>计算节点下所有子节点的总数。</T>
   //
   // @param logicContext 逻辑环境
   // @param nodeId 节点编号
   // @return 子节点总数
   //============================================================
   int calculateChildCount(ILogicContext logicContext,
                           long nodeId);
}
