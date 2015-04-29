package org.mo.cloud.logic.resource.template;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模板控制台接口。</T>
//============================================================
public interface IGcResTemplateConsole
      extends
         IAbstractLogicUnitConsole<FGcResTemplateInfo>
{
   //============================================================
   // <T>根据资源编号查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceId 资源编号
   // @return 模板信息
   //============================================================
   FGcResTemplateInfo findByResourceId(ILogicContext logicContext,
                                       long resourceId);

   //============================================================
   // <T>根据资源唯一编号查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceGuid 资源唯一编号
   // @return 模板信息
   //============================================================
   FGcResTemplateInfo findByResourceGuid(ILogicContext logicContext,
                                         String resourceGuid);

   //============================================================
   // <T>根据用户编号和项目编号和代码查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param code 代码
   // @return 模板信息
   //============================================================
   FGcResTemplateInfo findByUserCode(ILogicContext logicContext,
                                     long userId,
                                     String code);

   //============================================================
   // <T>根据用户编号和项目编号和代码查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param projectId 项目编号
   // @param code 代码
   // @return 模板信息
   //============================================================
   FGcResTemplateInfo findByUserCode(ILogicContext logicContext,
                                     long userId,
                                     long projectId,
                                     String code);
}
