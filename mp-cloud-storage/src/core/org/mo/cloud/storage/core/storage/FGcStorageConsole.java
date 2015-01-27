package org.mo.cloud.storage.core.storage;

import org.mo.com.io.RFile;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>存储控制台。</T>
//============================================================
public class FGcStorageConsole
      implements
         IGcStorageConsole
{
   // 存储路径
   @AProperty
   protected String _storePath;

   //============================================================
   // <T>生成文件名称。</T>
   //
   // @param name 名称
   // @return 文件名称
   //============================================================
   @Override
   public String makeFileName(String name){
      return RFile.makeFilename(_storePath, name);
   }

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
   @Override
   public String makeStorageName(String catalog,
                                 String date,
                                 String code,
                                 String version,
                                 String type){
      String fileName = catalog + "/" + date + "/" + code + "/" + version + "." + type;
      String fullName = makeFileName(fileName);
      RFile.makeFileDirectory(fullName);
      return fullName;
   }
}
