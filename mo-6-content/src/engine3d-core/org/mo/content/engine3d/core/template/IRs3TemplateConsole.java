package org.mo.content.engine3d.core.template;

import com.cyou.gccloud.data.data.FDataResourceTemplateUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;

//============================================================
// <T>资源模板控制台接口。</T>
//============================================================
public interface IRs3TemplateConsole
      extends
         IAbstractLogicUnitConsole<FDataResourceTemplateUnit>
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
   //
   //   //============================================================
   //   // <T>查找资源模板。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 处理结果
   //   //============================================================
   //   FRs3Template makeTemplate(ILogicContext logicContext,
   //                             String guid);
   //
   //   //============================================================
   //   // <T>查找资源模板。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 处理结果
   //   //============================================================
   //   byte[] makeTemplateData(ILogicContext logicContext,
   //                           String guid);
   //
   //   //============================================================
   //   // <T>导入模板。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param fileName 文件名称
   //   // @return 处理结果
   //   //============================================================
   //   EResult importTemplate(ILogicContext logicContext,
   //                          String fileName);
}
