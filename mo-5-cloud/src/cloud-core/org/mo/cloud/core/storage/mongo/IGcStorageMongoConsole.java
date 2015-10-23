package org.mo.cloud.core.storage.mongo;

import org.mo.com.lang.EResult;

//============================================================
// <T>存储控制台接口。</T>
//============================================================
public interface IGcStorageMongoConsole
{
   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param catalog 集合分类
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   SGcMongoStorage find(String catalog,
                   String guid);

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   boolean store(SGcMongoStorage storage);

   //============================================================
   // <T>删除一个存储信息。</T>
   //
   // @param catalog 集合分类
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   boolean delete(String catalog,
                  String guid);

   //============================================================
   // <T>删除一个存储集合。</T>
   //
   // @param catalog 集合分类
   // @return 处理结果
   //============================================================
   boolean drop(String catalog);

   //============================================================
   // <T>导出一个存储内容为文件。</T>
   //
   // @param catalog 分类名称
   // @param guid 唯一编号
   // @param formatName 格式名称
   // @param path 存储路径
   // @return 处理结果
   //============================================================
   EResult exportFile(String catalog,
                      String guid,
                      String formatName,
                      String path);

   //============================================================
   // <T>导入一个文件为存储内容。</T>
   //
   // @param catalog 分类名称
   // @param guid 唯一编号
   // @param formatName 格式名称
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importFile(String catalog,
                      String guid,
                      String formatName,
                      String fileName);
}
