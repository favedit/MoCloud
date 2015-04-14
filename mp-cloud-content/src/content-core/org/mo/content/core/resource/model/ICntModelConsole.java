package org.mo.content.core.resource.model;

import org.mo.com.lang.EResult;
import org.mo.content.engine3d.core.model.IRs3ModelConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容模型控制台接口。</T>
//============================================================
public interface ICntModelConsole
      extends
         IRs3ModelConsole
{
   //============================================================
   // <T>根据资源编号删除模型信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param resourceId 资源编号
   // @return 处理结果
   //============================================================
   EResult doDeleteByResourceId(ILogicContext logicContext,
                                long userId,
                                long resourceId);
}
