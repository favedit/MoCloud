package org.mo.cloud.core.storage;

import java.io.File;
import org.mo.com.io.FFileInfo;
import org.mo.com.io.FFileInfos;
import org.mo.com.io.RDirectory;
import org.mo.com.io.RFile;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>存储控制台。</T>
//============================================================
public class FCloudStorageConsole
      implements
         ICloudStorageConsole
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
   // <T>生成目录名称。</T>
   //
   // @param type 类型
   // @param code 代码
   // @return 目录名称
   //============================================================
   public String makeStoreDirectory(String type,
                                    String code){
      return RFile.makeFilename(_storePath, type, code);
   }

   //============================================================
   // <T>生成文件名称。</T>
   //
   // @param type 类型
   // @param code 代码
   // @param name 名称
   // @return 文件名称
   //============================================================
   @Override
   public String makeStoreFileName(String type,
                                   String code,
                                   String name){
      return RFile.makeFilename(_storePath, type, code, name);
   }

   //============================================================
   // <T>生成存储文件。</T>
   //
   // @param type 类型
   // @param code 代码
   // @param name 名称
   // @return 文件
   //============================================================
   @Override
   public File createFile(String catalog,
                          String date,
                          String code,
                          String name){
      // 创建路径
      String pathName = RFile.makeFilename(_storePath, catalog, date, code);
      //String pathName = makeStoreDirectory(type, date, code);
      File path = new File(pathName);
      if(!path.isDirectory()){
         path.mkdirs();
      }
      // 创建文件
      String fileName = RFile.makeFilename(pathName, name);
      File file = new File(fileName);
      // 返回文件
      return file;
   }

   //============================================================
   // <T>删除存储文件。</T>
   //
   // @param type 类型
   // @param code 代码
   // @param name 名称
   // @return 处理结果
   //============================================================
   @Override
   public boolean deleteFile(String type,
                             String code,
                             String name){
      String fileName = makeStoreFileName(type, code, name);
      File file = new File(fileName);
      if(file.exists()){
         file.delete();
         return true;
      }
      return false;
   }

   //============================================================
   // <T>删除存储文件集合。</T>
   //
   // @param type 类型
   // @param code 代码
   // @param name 名称
   // @return 处理结果
   //============================================================
   @Override
   public boolean deleteFiles(String type,
                              String code,
                              String name){
      boolean result = false;
      String path = RFile.path(name);
      FFileInfos infos = RDirectory.listFiles(path);
      if(infos != null){
         for(FFileInfo info : infos){
            String fileName = info.fileName();
            if(fileName.startsWith(name)){
               File file = new File(fileName);
               if(file.exists()){
                  file.delete();
                  result = true;
               }
            }
         }
      }
      return result;
   }

   //============================================================
   // <T>删除存储目录。</T>
   //
   // @param type 类型
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public boolean deleteDirectory(String type,
                                  String code){
      String directoryName = makeStoreDirectory(type, code);
      File directory = new File(directoryName);
      if(directory.isDirectory()){
         directory.delete();
         return true;
      }
      return false;
   }
}
