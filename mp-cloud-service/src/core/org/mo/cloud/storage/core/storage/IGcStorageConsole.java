package org.mo.cloud.storage.core.storage;

//============================================================
// <T>存储控制台接口。</T>
//============================================================
public interface IGcStorageConsole
{
   //============================================================
   // <T>生成文件名称。</T>
   //
   // @param name 名称
   // @return 文件名称
   //============================================================
   String makeFileName(String name);

   //============================================================
   // <T>生成存储文件名称。</T>
   //
   // @param catalog 分类
   // @param date 日期
   // @param code 代码
   // @param version 版本
   // @param type 类型
   // @return 文件名称
   //============================================================
   String makeStorageName(String catalog,
                          String date,
                          String code,
                          String version,
                          String type);
}
