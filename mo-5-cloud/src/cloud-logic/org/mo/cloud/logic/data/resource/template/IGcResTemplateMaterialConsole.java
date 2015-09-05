package org.mo.cloud.logic.data.resource.template;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模板材质控制台接口。</T>
//============================================================
public interface IGcResTemplateMaterialConsole
      extends
         IAbstractLogicUnitConsole<FGcResTemplateMaterialInfo>
{
   //============================================================
   // <T>根据用户编号和模板编号和代码查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param templateId 模板编号
   // @param code 代码
   // @return 模板信息
   //============================================================
   FGcResTemplateMaterialInfo findByCode(ILogicContext logicContext,
                                         long userId,
                                         long templateId,
                                         String code);
}
