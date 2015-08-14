package org.mo.cloud.content.design.persistence;

import org.mo.cloud.content.design.common.IContentConsole;
import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.persistence.common.XPersistence;
import org.mo.com.lang.EResult;

//============================================================
// <T>内容持久控制台。</T>
//============================================================
public interface IPersistenceConsole
      extends
         IContentConsole
{
   //============================================================
   // <T>获得列表集合。</T>
   //
   // @param storgeName 存储名称
   // @return 列表集合
   //============================================================
   XPersistence[] list(String storgeName);

   //============================================================
   // <T>根据名称获得列表。</T>
   //
   // @param storgeName 存储名称
   // @param listName 列表名称
   // @param modeCd 模式类型
   // @return 列表
   //============================================================
   XPersistence find(String storgeName,
                     String listName,
                     EPersistenceMode modeCd);

   //============================================================
   // <T>查找持久对象。</T>
   //
   // @param storageName 存储名称
   // @param persistenceName 持久名称
   // @return 持久对象
   //============================================================
   FPersistence findPersistence(String storageName,
                                String persistenceName);

   //============================================================
   // <T>根据名称获得持久化定义。</T>
   //
   // @param storgeName 存储名称
   // @param persistenceName 表单名称
   // @param modeCd 模式类型
   // @return 持久化定义
   //============================================================
   @Override
   FContentObject findDefine(String storgeName,
                             String persistenceName,
                             EPersistenceMode modeCd);

   //============================================================
   // <T>根据节点名称获得内容节点。</T>
   //
   // @param nodeName 节点名称
   // @return 内容节点
   //============================================================
   FContentNode findNode(String name);

   //============================================================
   // <T>构建处理。</T>
   //
   // @param builder 构建器
   // @return 处理结果
   //============================================================
   EResult build(SPersistenceBuildArgs builder);
}
