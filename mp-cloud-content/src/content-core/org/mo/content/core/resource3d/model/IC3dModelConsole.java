package org.mo.content.core.resource3d.model;

import org.mo.data.logic.ILogicContext;
import org.mo.engine3d.resource.model.FRs3Model;

//============================================================
// <T>模型控制台接口。</T>
//============================================================
public interface IC3dModelConsole
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param version 版本
   //============================================================
   FRs3Model makeModel(ILogicContext logicContext,
                       String code,
                       String version);
}
