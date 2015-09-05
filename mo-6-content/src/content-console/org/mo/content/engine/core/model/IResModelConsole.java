package org.mo.content.engine.core.model;

import org.mo.cloud.logic.data.system.FGcSessionInfo;

import org.mo.cloud.logic.data.resource.model.FGcResModelInfo;
import org.mo.cloud.logic.data.resource.model.IGcResModelConsole;
import org.mo.com.lang.EResult;
import org.mo.content.mime.obj.FObjFile;
import org.mo.content.mime.phy.FPlyFile;
import org.mo.content.mime.stl.FStlFile;
import org.mo.content.resource.model.FResModel;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台接口。</T>
//============================================================
public interface IResModelConsole
      extends
         IGcResModelConsole
{
   //============================================================
   // <T>生成资源模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @return 资源模型
   //============================================================
   FResModel makeModel(ILogicContext logicContext,
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
   // <T>新建模型信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param model 模型数据
   // @return 模型信息
   //============================================================
   FGcResModelInfo insertResource(ILogicContext logicContext,
                                  FGcSessionInfo session,
                                  FResModel model);

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param model 模型
   // @return 模型信息
   //============================================================
   EResult updateResource(ILogicContext logicContext,
                          FGcSessionInfo session,
                          FGcResModelInfo modelInfo,
                          FResModel model);

   //============================================================
   // <T>更新PLY资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   EResult updateResourcePly(ILogicContext logicContext,
                             FGcSessionInfo session,
                             FGcResModelInfo modelInfo,
                             FPlyFile file);

   //============================================================
   // <T>更新OBJ资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   EResult updateResourceObj(ILogicContext logicContext,
                             FGcSessionInfo session,
                             FGcResModelInfo modelInfo,
                             FObjFile file);

   //============================================================
   // <T>更新STL资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   EResult updateResourceStl(ILogicContext logicContext,
                             FGcSessionInfo session,
                             FGcResModelInfo modelInfo,
                             FStlFile file);

   //============================================================
   // <T>导入模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importModel(ILogicContext logicContext,
                       FGcSessionInfo session,
                       String fileName);

   //============================================================
   // <T>导入骨骼。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importSkeleton(ILogicContext logicContext,
                          FGcSessionInfo session,
                          String fileName);

   //============================================================
   // <T>导入动画。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importAnimation(ILogicContext logicContext,
                           FGcSessionInfo session,
                           String fileName);
}
