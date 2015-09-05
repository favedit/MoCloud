package org.mo.cloud.logic.data.resource.material;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源材质位图信息控制台接口。</T>
//============================================================
public interface IGcResMaterialBitmapConsole
      extends
         IAbstractLogicUnitConsole<FGcResMaterialBitmapInfo>
{
   //============================================================
   // <T>根据材质和代码查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param materialId 材质编号
   // @param code 代码
   // @return 位图信息
   //============================================================
   FGcResMaterialBitmapInfo findByMaterialCode(ILogicContext logicContext,
                                               long materialId,
                                               String code);

   //============================================================
   // <T>根据材质编号查找位图信息集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param materialId 材质编号
   // @return 位图信息集合
   //============================================================
   FLogicDataset<FGcResMaterialBitmapInfo> fetchByMaterialId(ILogicContext logicContext,
                                                             long materialId);
}
