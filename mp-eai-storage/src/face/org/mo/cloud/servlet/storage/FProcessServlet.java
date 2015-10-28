package org.mo.cloud.servlet.storage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import org.mo.cloud.core.storage.ICloudStorageConsole;
import org.mo.com.lang.FBytes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FProcessServlet
      extends FObject
      implements
         IProcessServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FProcessServlet.class);

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

   // 数据块最小尺寸
   protected static int BlockMinSize = 1024 * 16;

   // 数据块最大尺寸
   protected static int BlockMaxSize = 1024 * 256;

   // 应用服务接口
   @ALink
   protected ICloudStorageConsole _storageConsole;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void upload(IWebContext context,
                      IWebServletRequest request,
                      IWebServletResponse response){
      // 检查分类
      String catalog = context.parameter("catalog");
      if(RString.isEmpty(catalog)){
         throw new FFatalError("Upload catalog is empty.");
      }
      // 检查日期
      String date = context.parameter("date");
      if(RString.isEmpty(date)){
         throw new FFatalError("Upload date is empty.");
      }
      // 检查代码
      String code = context.parameter("code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Upload code is empty.");
      }
      // 检查名称
      String name = context.parameter("name");
      if(RString.isEmpty(name)){
         throw new FFatalError("Upload name is empty.");
      }
      //............................................................
      // 上传处理
      String sizeValue = context.parameter("size");
      int size = RInteger.parse(sizeValue);
      if((size <= 0) || (size > RInteger.SIZE_64M)){
         throw new FFatalError("Unknown size. (size={1})", size);
      }
      // 计算分块大小
      int blockSize = size;
      if(blockSize < BlockMinSize){
         blockSize = BlockMinSize;
      }
      if(blockSize > BlockMaxSize){
         blockSize = BlockMaxSize;
      }
      // 写入文件
      File storageFile = _storageConsole.createFile(catalog, date, code, name);
      _logger.debug(this, "process", "Upload data. (catalog={1}, date={2}, code={3}, size={4}, block_size={5}, file_name={6})", catalog, date, code, size, blockSize, storageFile.getAbsolutePath());
      try(RandomAccessFile file = new RandomAccessFile(storageFile, "rw")){
         // 设置文件大小
         if(file.length() != size){
            file.setLength(size);
         }
         // 设置开始位置
         file.seek(0);
         // 创建数据缓冲
         FBytes stream = new FBytes(size);
         // 接收数据
         byte buffer[] = new byte[BufferLength];
         InputStream inputStream = request.inputStream();
         long remain = size;
         while(remain > 0){
            int readed = inputStream.read(buffer, 0, BufferLength);
            if(readed > 0){
               stream.append(buffer, 0, readed);
               // 写入分块数据
               int streamLength = stream.length();
               if(streamLength > blockSize){
                  file.write(stream.memory(), 0, streamLength);
                  stream.remove(0, streamLength);
               }
            }
            remain -= readed;
            // 写入剩余数据
            if((readed == 0) || (remain <= 0)){
               int streamLength = stream.length();
               if(streamLength > 0){
                  file.write(stream.memory(), 0, streamLength);
               }
               break;
            }
         }
         _logger.debug(this, "process", "Upload data success. (size={1})", size);
      }catch(IOException exception){
         _logger.error(this, "process", exception);
         throw new FFatalError(exception);
      }
   }

   //============================================================
   // <T>删除文件处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void delete(IWebContext context,
                      IWebServletRequest request,
                      IWebServletResponse response){
   }

   //============================================================
   // <T>删除目录处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void drop(IWebContext context,
                    IWebServletRequest request,
                    IWebServletResponse response){
   }
}
