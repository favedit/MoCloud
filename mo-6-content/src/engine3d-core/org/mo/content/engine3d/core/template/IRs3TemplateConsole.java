package org.mo.content.engine3d.core.template;

import com.cyou.gccloud.data.data.FDataResource3dTemplateUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.template.FRs3Template;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模板控制台接口。</T>
//============================================================
public interface IRs3TemplateConsole
      extends
         IAbstractLogicUnitConsole<FDataResource3dTemplateUnit>
{
   //============================================================
   // <T>查找资源模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @param code 代码
   // @param version 版本
   // @return 处理结果
   //============================================================
   FRs3Template findTemplate(ILogicContext logicContext,
                             String guid,
                             String code,
                             String version);

   //============================================================
   // <T>导入模板。</T>
   //
   // @param logicContext 逻辑环境
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importTemplate(ILogicContext logicContext,
                          String fileName);
}
