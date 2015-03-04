package org.mo.content.core.resource3d.model;

import org.mo.content.resource3d.model.FRs3Model;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台接口。</T>
//============================================================
public interface IC3dModelConsole
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   //============================================================
   FRs3Model makeModel(ILogicContext logicContext,
                       String guid);

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   //============================================================
   byte[] makeModelData(ILogicContext logicContext,
                        String guid);
}
