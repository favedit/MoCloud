package org.mo.content.engine3d.core.model;

import com.cyou.gccloud.data.data.FDataResource3dModelMeshUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台接口。</T>
//============================================================
public interface IRs3ModelMeshConsole
{
   //============================================================
   // <T>根据代码查找模型网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 模型网格单元
   //============================================================
   FDataResource3dModelMeshUnit findByCode(ILogicContext logicContext,
                                           long modelId,
                                           String code);
}
