package org.mo.content.engine.core.material;

import org.mo.cloud.logic.data.resource.material.FGcResMaterialInfo;
import org.mo.cloud.logic.data.resource.material.IGcResMaterialConsole;

import org.mo.com.lang.EResult;
import org.mo.content.resource.common.FResMaterial;
import org.mo.content.resource.material.FResMaterialResource;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台接口。</T>
//============================================================
public interface IResMaterialConsole
      extends
         IGcResMaterialConsole
{
   //============================================================
   // <T>生成材质。</T>
   //
   // @param logicContext 逻辑环境
   // @param templateInfo 模板信息
   // @return 材质
   //============================================================
   FResMaterial makeMaterial(ILogicContext logicContext,
                             FGcResMaterialInfo materialInfo);

   //============================================================
   // <T>生成材质。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 材质
   //============================================================
   FResMaterial makeMaterial(ILogicContext logicContext,
                             String guid);

   //============================================================
   // <T>生成资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param templateInfo 模板信息
   // @return 资源模板
   //============================================================
   FResMaterialResource makeResource(ILogicContext logicContext,
                                     FGcResMaterialInfo materialInfo);

   //============================================================
   // <T>生成资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 资源模板
   //============================================================
   FResMaterialResource makeResource(ILogicContext logicContext,
                                     String guid);

   //============================================================
   // <T>查找资源数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   byte[] makeResourceData(ILogicContext logicContext,
                           String guid);

   //============================================================
   // <T>导入纹理。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   EResult importTexture(ILogicContext logicContext,
                         String path);
}
