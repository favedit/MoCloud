package org.mo.content.engine3d.core.model;

import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台接口。</T>
//============================================================
public interface IRs3ModelConsole
{
   //============================================================
   // <T>根据代码查找模型单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   FDataResource3dModelUnit findByCode(ILogicContext logicContext,
                                       String code);

   //============================================================
   // <T>根据代码查找模型网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 模型网格单元
   //============================================================
   FDataResource3dMeshUnit findMeshByCode(ILogicContext logicContext,
                                          long modelId,
                                          String code);

   //============================================================
   // <T>导入模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importModel(ILogicContext logicContext,
                       String fileName);

   //============================================================
   // <T>导入骨骼。</T>
   //
   // @param logicContext 逻辑环境
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importSkeleton(ILogicContext logicContext,
                          String fileName);

   //============================================================
   // <T>导入动画。</T>
   //
   // @param logicContext 逻辑环境
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importAnimation(ILogicContext logicContext,
                           String fileName);
}
