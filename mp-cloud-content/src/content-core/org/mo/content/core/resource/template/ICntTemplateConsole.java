package org.mo.content.core.resource.template;

import org.mo.com.lang.EResult;
import org.mo.content.engine.core.template.IResTemplateConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容场景模板接口。</T>
//============================================================
public interface ICntTemplateConsole
      extends
         IResTemplateConsole
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
