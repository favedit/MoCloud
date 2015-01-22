package org.mo.content.core.configuration;

import org.mo.com.lang.FDictionary;

//============================================================
// <T>内容配置控制台接口。</T>
//============================================================
public interface IContentConfigurationConsole
{
   //============================================================
   // <T>获得内容存储字典。</T>
   //
   // @return 内容存储字典
   //============================================================
   FDictionary<FContentStorage> storages();

   //============================================================
   // <T>根据存储名称查找内容存储。</T>
   //
   // @param storageName 存储名称
   // @return 内容存储
   //============================================================
   FContentStorage findStorage(String storageName);

   //============================================================
   // <T>根据存储名称获得内容存储。</T>
   //
   // @param storageName 存储名称
   // @return 内容存储
   //============================================================
   FContentStorage getStorage(String storageName);

   //============================================================
   // <T>根据空间名称查找内容空间。</T>
   //
   // @param storageName 存储名称
   // @param spaceName 空间名称
   // @return 内容空间
   //============================================================
   FContentSpace findSpace(String storageName,
                           String spaceName);

   //============================================================
   // <T>根据空间名称获得内容空间。</T>
   //
   // @param storageName 存储名称
   // @param spaceName 空间名称
   // @return 内容空间
   //============================================================
   FContentSpace getSpace(String storageName,
                          String spaceName);

   //============================================================
   // <T>根据空间名称和节点名称查找内容节点。</T>
   //
   // @param storageName 存储名称
   // @param spaceName 空间名称
   // @param nodeName 节点名称
   // @return 内容节点
   //============================================================
   FContentNode findNode(String storageName,
                         String spaceName,
                         String nodeName);

   //============================================================
   // <T>根据空间名称和节点名称获得内容节点。</T>
   //
   // @param storageName 存储名称
   // @param spaceName 空间名称
   // @param nodeName 节点名称
   // @return 内容节点
   //============================================================
   FContentNode getNode(String storageName,
                        String spaceName,
                        String nodeName);

   //============================================================
   // <T>根据空间名称和节点名称获得内容类对象。</T>
   //
   // @param storageName 存储名称
   // @param spaceName 空间名称
   // @param nodeName 节点名称
   // @param typeName 类型名称
   // @return 内容节点
   //============================================================
   FContentClass getContentClass(String storageName,
                                 String spaceName,
                                 String nodeName,
                                 String typeName);
}
