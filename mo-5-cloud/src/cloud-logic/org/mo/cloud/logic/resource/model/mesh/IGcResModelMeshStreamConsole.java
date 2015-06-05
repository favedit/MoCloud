package org.mo.cloud.logic.resource.model.mesh;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格数据流控制台接口。</T>
//============================================================
public interface IGcResModelMeshStreamConsole
      extends
         IAbstractLogicUnitConsole<FGcResModelMeshStreamInfo>
{
   //============================================================
   // <T>根据网格编号和代码查找数据流信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param meshId 网格编号
   // @param code 代码
   // @return 数据流信息
   //============================================================
   FGcResModelMeshStreamInfo findByCode(ILogicContext logicContext,
                                        long meshId,
                                        String code);

   //============================================================
   // <T>根据用户编号和模型编号和网格编号和代码查找数据流信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param modelId 模型编号
   // @param meshId 网格编号
   // @param code 代码
   // @return 数据流信息
   //============================================================
   FGcResModelMeshStreamInfo findByCode(ILogicContext logicContext,
                                        long userId,
                                        long modelId,
                                        long meshId,
                                        String code);

   //============================================================
   // <T>根据网格编号查找所有网格数据流集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param meshId 网格编号
   // @return 网格数据流集合
   //============================================================
   FLogicDataset<FGcResModelMeshStreamInfo> fetchByMeshId(ILogicContext logicContext,
                                                          long meshId);

   //============================================================
   // <T>根据网格编号删除所有网格数据流集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelMeshId 模型网格编号
   // @return 处理结果
   //============================================================
   EResult doDeleteByMeshId(ILogicContext logicContext,
                            long modelMeshId);
}
