package org.mo.cloud.logic.resource.mesh;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格数据流控制台接口。</T>
//============================================================
public interface IGcResMeshStreamConsole
      extends
         IAbstractLogicUnitConsole<FGcResMeshStreamInfo>
{
   //============================================================
   // <T>根据网格编号和代码查找数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param meshId 网格编号
   // @param code 代码
   // @return 网格数据流
   //============================================================
   FGcResMeshStreamInfo findByCode(ILogicContext logicContext,
                                   long meshId,
                                   String code);

   //============================================================
   // <T>根据网格编号查找所有网格数据流集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param meshId 网格编号
   // @return 网格数据流集合
   //============================================================
   FLogicDataset<FGcResMeshStreamInfo> fetchByMeshId(ILogicContext logicContext,
                                                     long meshId);
}
