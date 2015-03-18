package org.mo.cloud.design.core.persistence;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.com.lang.EResult;

//============================================================
// <T>内容持久控制台。</T>
//============================================================
public interface IContentPersistenceConsole
{
   //============================================================
   // <T>查找持久对象。</T>
   //
   // @param storageName 存储名称
   // @param persistenceName 持久名称
   // @return 持久对象
   //============================================================
   FContentPersistence findPersistence(String storageName,
                                       String persistenceName);

   //============================================================
   // <T>根据节点名称获得内容节点。</T>
   //
   // @param nodeName 节点名称
   // @return 内容节点
   //============================================================
   FContentNode find(String name);

   //============================================================
   // <T>构建处理。</T>
   //
   // @param builder 构建器
   // @return 处理结果
   //============================================================
   EResult build(SContentPersistenceBuildArgs builder);
}
