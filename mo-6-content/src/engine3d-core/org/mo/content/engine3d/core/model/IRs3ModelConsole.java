package org.mo.content.engine3d.core.model;

import org.mo.cloud.logic.resource.model.FGcResModelInfo;
import org.mo.cloud.logic.resource.model.IGcResModelConsole;
import org.mo.com.lang.EResult;
import org.mo.content.mime.obj.FObjFile;
import org.mo.content.mime.phy.FPlyFile;
import org.mo.content.resource3d.model.FRs3Model;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台接口。</T>
//============================================================
public interface IRs3ModelConsole
      extends
         IGcResModelConsole
{
   //   //============================================================
   //   // <T>根据代码查找模型单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 处理结果
   //   //============================================================
   //   FGcResModelInfo findByCode(ILogicContext logicContext,
   //                              String code);
   //
   //   //============================================================
   //   // <T>根据代码查找模型网格单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 模型网格单元
   //   //============================================================
   //   FGcResModelInfo findMeshByCode(ILogicContext logicContext,
   //                                  long modelId,
   //                                  String code);

   //
   //   //============================================================
   //   // <T>导入模型。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param fileName 文件名称
   //   // @return 处理结果
   //   //============================================================
   //   EResult importModel(ILogicContext logicContext,
   //                       String fileName);
   //
   //   //============================================================
   //   // <T>导入骨骼。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param fileName 文件名称
   //   // @return 处理结果
   //   //============================================================
   //   EResult importSkeleton(ILogicContext logicContext,
   //                          String fileName);
   //
   //   //============================================================
   //   // <T>导入动画。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param fileName 文件名称
   //   // @return 处理结果
   //   //============================================================
   //   EResult importAnimation(ILogicContext logicContext,
   //                           String fileName);

   //============================================================
   // <T>生成资源模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @return 资源模型
   //============================================================
   FRs3Model makeModel(ILogicContext logicContext,
                       FGcResModelInfo modelInfo);

   //============================================================
   // <T>生成资源模型数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 资源唯一编号
   // @return 资源模型数据
   //============================================================
   byte[] makeModelData(ILogicContext logicContext,
                        String guid);

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @param model 模型
   // @return 模型信息
   //============================================================
   EResult updateResource(ILogicContext logicContext,
                          FGcResModelInfo modelInfo,
                          FRs3Model model);

   //============================================================
   // <T>更新PLY资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   EResult updateResourcePly(ILogicContext logicContext,
                             FGcResModelInfo modelInfo,
                             FPlyFile file);

   //============================================================
   // <T>更新OBJ资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   EResult updateResourceObj(ILogicContext logicContext,
                             FGcResModelInfo modelInfo,
                             FObjFile file);
}
