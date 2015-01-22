package org.mo.mime.zip;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.mo.com.io.FByteFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RInteger;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>ZIP输入流。</T>
//============================================================
public abstract class FZipInput
      extends FZipStream
      implements
         AutoCloseable
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FZipInput.class);

   // 输入流
   protected ZipInputStream _input;

   // 下一个节点
   protected FZipEntry _nextEntry;

   //============================================================
   // <T>打开处理。</T>
   //============================================================
   public void open(){
      try{
         ZipEntry entry = _input.getNextEntry();
         if(null != entry){
            _entry = new FZipEntry(entry);
         }
         _nextEntry = null;
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>判断是否有下一个。</T>
   //
   // @return 是否有下一个
   //============================================================
   public boolean hasNext(){
      return (null != _nextEntry);
   }

   //============================================================
   // <T>获得下一个节点。</T>
   //
   // @return 下一个节点
   //============================================================
   public FZipEntry nextEntry(){
      try{
         ZipEntry entry = _input.getNextEntry();
         if(entry != null){
            _entry = new FZipEntry(entry);
            return _entry;
         }
         return null;
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>读取数据。</T>
   //
   // @return 数据
   //============================================================
   public int read(){
      try{
         return _input.read();
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>读取数据。</T>
   //
   // @param data 数据
   // @return 读取长度
   //============================================================
   public int read(byte[] data){
      try{
         return _input.read(data);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>读取数据。</T>
   //
   // @param data 数据
   // @param offset 位置
   // @param length 长度
   // @return 读取长度
   //============================================================
   public int read(byte[] data,
                   int offset,
                   int length){
      try{
         return _input.read(data, offset, length);
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
   public int decompress(String directory){
      byte[] buffer = new byte[RInteger.SIZE_16K];
      // 读取ZIP文件
      int count = 0;
      FZipEntry entry = null;
      while(null != (entry = nextEntry())){
         // 不处理目录
         if(entry.isDirectory()){
            continue;
         }
         // 生成读取文件
         String outputFile = RFile.makeFilename(directory, entry.name());
         // 保存文件
         try(FByteFile file = new FByteFile(outputFile, false)){
            while(true){
               int read = read(buffer);
               if(-1 == read){
                  break;
               }
               file.append(buffer, 0, read);
            }
            // 存储文件
            file.store();
            count++;
         }
      }
      _logger.debug(null, "decompress", "Decompress directory. (directory={1}, count={2})", directory, count);
      return count;
   }

   //============================================================
   // <T>关闭处理。</T>
   //============================================================
   @Override
   public void close(){
      try{
         _input.close();
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }
}
