package org.mo.cloud.core.storage;

import java.io.File;

//============================================================
// <T>存储控制台接口。</T>
//============================================================
public interface ICloudStorageConsole
{
   //============================================================
   // <T>生成文件名称。</T>
   //
   // @param name 名称
   // @return 文件名称
   //============================================================
   String makeFileName(String name);

   //============================================================
   // <T>生成文件名称。</T>
   //
   // @param type 类型
   // @param code 代码
   // @param name 名称
   // @return 文件名称
   //============================================================
   String makeStoreFileName(String type,
                            String code,
                            String name);

   //============================================================
   // <T>生成存储文件。</T>
   //
   // @param type 类型
   // @param code 代码
   // @param name 名称
   // @return 文件
   //============================================================
   File createFile(String type,
                   String date,
                   String code,
                   String name);

   //============================================================
   // <T>删除存储文件。</T>
   //
   // @param type 类型
   // @param code 代码
   // @param name 名称
   // @return 处理结果
   //============================================================
   boolean deleteFile(String type,
                      String code,
                      String name);

   //============================================================
   // <T>删除存储文件集合。</T>
   //
   // @param type 类型
   // @param code 代码
   // @param name 名称
   // @return 处理结果
   //============================================================
   boolean deleteFiles(String type,
                       String code,
                       String name);

   //============================================================
   // <T>删除存储目录。</T>
   //
   // @param type 类型
   // @param code 代码
   // @return 处理结果
   //============================================================
   boolean deleteDirectory(String type,
                           String code);
}
