package org.mo.cloud.core.storage;

//============================================================
// <T>存储控制台接口。</T>
//============================================================
public interface IGcStorageConsole
{
   //============================================================
   // <T>生成存储文件名称。</T>
   //
   // @param catalog 目录
   // @param date 日期
   // @param code 代码
   // @param version 版本
   // @param type 类型
   // @return 文件名称
   //============================================================
   String makeFileName(String catalog,
                       String date,
                       String code,
                       String version,
                       String type);

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   boolean store(SGcStorage storage);
}
