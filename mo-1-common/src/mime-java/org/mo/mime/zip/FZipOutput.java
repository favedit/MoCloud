package org.mo.mime.zip;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.mo.com.io.FByteFile;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RByte;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>ZIP输出流。</T>
//============================================================
public abstract class FZipOutput
      extends FZipStream
      implements
         AutoCloseable
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FZipOutput.class);

   // 输出流
   protected ZipOutputStream _output;

   //============================================================
   // <T>打开处理。</T>
   //
   // @param name 名称
   //============================================================
   public FZipEntry open(String name){
      try{
         _entry = new FZipEntry(name);
         _output.putNextEntry(_entry._entry);
         return _entry;
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>设置函数。</T>
   //
   // @param method 函数
   //============================================================
   public void setMethod(int method){
      _output.setMethod(method);
   }

   //============================================================
   // <T>设置备注。</T>
   //
   // @param data 数据
   //============================================================
   public void setComment(String comment){
      _output.setComment(comment);
   }

   //============================================================
   // <T>写入数据。</T>
   //
   // @param data 数据
   //============================================================
   public void write(byte[] data){
      try{
         _output.write(data);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>写入数据。</T>
   //
   // @param data 数据
   // @param offset 位置
   // @param length 长度
   //============================================================
   public void write(byte[] data,
                     int offset,
                     int length){
      try{
         _output.write(data, offset, length);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>完成处理。</T>
   //============================================================
   public void finish(){
      try{
         _output.finish();
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>刷新处理。</T>
   //============================================================
   public void flush(){
      try{
         _output.flush();
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>解压到一个目录。</T>
   //
   // @param directory 目录
   // @return 解压文件个数
   //============================================================
   protected int compress(String directory,
                          String path) throws IOException{
      int count = 0;
      File sourceDirectory = new File(path);
      for(File file : sourceDirectory.listFiles()){
         if(file.isFile()){
            String name = file.getAbsolutePath().substring(directory.length());
            int length = (int)file.length();
            ZipEntry entry = new ZipEntry(name);
            entry.setTime(file.lastModified());
            entry.setSize(length);
            _output.putNextEntry(entry);
            if(length > 0){
               try(FByteFile data = new FByteFile(file.getAbsolutePath())){
                  _output.write(data.memory(), 0, data.length());
               }
            }else{
               _output.write(RByte.EMPTY_COLLECTION, 0, 0);
            }
            count++;
         }
         if(file.isDirectory()){
            count += compress(directory, file.getAbsolutePath());
         }
      }
      return count;
   }

   //============================================================
   // <T>解压到一个目录。</T>
   //
   // @param directory 目录
   // @return 解压文件个数
   //============================================================
   public int compress(String directory){
      int count = 0;
      try{
         File sourceDirectory = new File(directory);
         if(sourceDirectory.isDirectory()){
            String path = sourceDirectory.getAbsolutePath();
            compress(path, path);
         }
         _output.flush();
         _output.finish();
         _logger.debug(this, "compress", "Compress directory. (directory={1}, count={2})", directory, count);
      }catch(IOException e){
         _logger.error(this, "compress", e, "Compress directory failure. (directory={1}, count={2})", directory, count);
      }
      return count;
   }

   //============================================================
   // <T>关闭处理。</T>
   //============================================================
   @Override
   public void close(){
      if(_output != null){
         try{
            _output.close();
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }
      _output = null;
   }
}
