package org.mo.content.engine3d.core.template;

import org.mo.cloud.logic.resource.template.FGcResTemplateInfo;
import org.mo.cloud.logic.resource.template.IGcResTemplateConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.template.FRs3Template;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模板控制台接口。</T>
//============================================================
public interface IResTemplateConsole
      extends
         IGcResTemplateConsole
{
   //   //============================================================
   //   // <T>根据代码查找资源模板单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 资源模板单元
   //   //============================================================
   //   FDataResource3dTemplateUnit findByCode(ILogicContext logicContext,
   //                                          String code);
   //
   //   //============================================================
   //   // <T>根据编号和代码查找材质组单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param templateId 模板编号
   //   // @param code 代码
   //   // @return 材质组单元
   //   //============================================================
   //   FDataResource3dMaterialGroupUnit findMaterialGroupByCode(ILogicContext logicContext,
   //                                                            long templateId,
   //                                                            String code);
   //
   //   //============================================================
   //   // <T>查找资源模板。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @param code 代码
   //   // @param version 版本
   //   // @return 处理结果
   //   //============================================================
   //   FRs3Template findTemplate(ILogicContext logicContext,
   //                             String guid,
   //                             String code,
   //                             String version);

   //============================================================
   // <T>生成资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param templateInfo 模板信息
   // @return 资源模板
   //============================================================
   FRs3Template makeTemplate(ILogicContext logicContext,
                             FGcResTemplateInfo templateInfo);

   //============================================================
   // <T>生成资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 资源模板
   //============================================================
   FRs3Template makeTemplate(ILogicContext logicContext,
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
                                     FRs3Template template);

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