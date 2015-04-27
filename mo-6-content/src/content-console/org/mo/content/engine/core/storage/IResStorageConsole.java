package org.mo.content.engine.core.storage;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源存储控制台接口。</T>
//============================================================
public interface IResStorageConsole
{
   //============================================================
   // <T>清空数据。</T>
   //
   // @param logicContext 逻辑环境
   // @return 处理结果
   //============================================================
   EResult clearData(ILogicContext logicContext);

   //============================================================
   // <T>导出数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   EResult exportData(ILogicContext logicContext,
                      String path);

   //============================================================
   // <T>导出存储。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   EResult exportStorage(ILogicContext logicContext,
                         String path);

   //============================================================
   // <T>导入数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   EResult importData(ILogicContext logicContext,
                      String path);

   //============================================================
   // <T>导入存储。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   EResult importStorage(ILogicContext logicContext,
                         String path);
}
