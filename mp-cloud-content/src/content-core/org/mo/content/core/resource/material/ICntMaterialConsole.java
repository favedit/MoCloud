package org.mo.content.core.resource.material;

import org.mo.com.lang.EResult;
import org.mo.content.engine.core.material.IResMaterialConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容材质控制台接口。</T>
//============================================================
public interface ICntMaterialConsole
      extends
         IResMaterialConsole
{
   //============================================================
   // <T>生成位图预览数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   byte[] makePreviewData(ILogicContext logicContext,
                          String guid);

   //============================================================
   // <T>生成纹理位图。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @param code 代码
   // @return 处理结果
   //============================================================
   byte[] makeBitmap(ILogicContext logicContext,
                     String guid,
                     String code);

   //============================================================
   // <T>生成纹理位图。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @param code 代码
   // @return 处理结果
   //============================================================
   byte[] makeBitmapData(ILogicContext logicContext,
                         String guid,
                         String code);

   //============================================================
   // <T>根据资源编号删除材质信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param resourceId 资源编号
   // @return 处理结果
   //============================================================
   EResult doDeleteByResourceId(ILogicContext logicContext,
                                long userId,
                                long resourceId);
}
