package org.mo.content.engine.core.template;

import org.mo.cloud.logic.data.system.FGcSessionInfo;

import org.mo.cloud.logic.data.resource.template.FGcResTemplateInfo;
import org.mo.cloud.logic.data.resource.template.IGcResTemplateConsole;
import org.mo.com.lang.EResult;
import org.mo.content.resource.template.FResTemplate;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模板控制台接口。</T>
//============================================================
public interface IResTemplateConsole
      extends
         IGcResTemplateConsole
{
   //============================================================
   // <T>生成资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param templateInfo 模板信息
   // @return 资源模板
   //============================================================
   FResTemplate makeTemplate(ILogicContext logicContext,
                             FGcResTemplateInfo templateInfo);

   //============================================================
   // <T>生成资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 资源模板
   //============================================================
   FResTemplate makeTemplate(ILogicContext logicContext,
                             String guid);

   //============================================================
   // <T>查找资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   byte[] makeTemplateData(ILogicContext logicContext,
                           String guid);

   //============================================================
   // <T>更新模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param template 模板
   // @return 模板信息
   //============================================================
   FGcResTemplateInfo updateResource(ILogicContext logicContext,
                                     FResTemplate template);

   //============================================================
   // <T>导入模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importResource(ILogicContext logicContext,
                          FGcSessionInfo session,
                          String fileName);
}
