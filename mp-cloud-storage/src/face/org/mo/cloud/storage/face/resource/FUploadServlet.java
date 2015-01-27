package org.mo.cloud.storage.face.resource;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mo.cloud.storage.core.storage.IGcStorageConsole;
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
public class FUploadServlet
      extends FObject
      implements
         IUploadServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FUploadServlet.class);

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

   // 应用服务接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>逻辑处理。</T>
   // <P>catalog:分类</P>
   // <P>date:日期</P>
   // <P>code:代码</P>
   // <P>version:版本</P>
   // <P>type:类型，没有的话，存储为 bin</P>
   // <P>size:大小</P>
   // <P>存储位置：\{catalog}\{date:yyyymmdd}\{code}\{version}.{type}</P>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void process(IWebContext context,
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
      // 检查版本
      String version = context.parameter("version");
      if(RString.isEmpty(version)){
         throw new FFatalError("Upload version is empty.");
      }
      // 获得类型
      String type = RString.nvl(context.parameter("type"), "bin");
      //............................................................
      // 获得数据处理
      String sizeValue = context.parameter("size");
      int size = RInteger.parse(sizeValue);
      if((size <= 0) || (size > RInteger.SIZE_64M)){
         throw new FFatalError("Invalid size. (size={1})", size);
      }
      // 写入文件
      String storageName = _storageConsole.makeStorageName(catalog, date, code, version, type);
      _logger.debug(this, "process", "Upload data. (catalog={1}, date={2}, code={3}, version={4}, type={5}, size={6})", catalog, date, code, version, type, size);
      try(FileOutputStream file = new FileOutputStream(storageName)){
         try(DataOutputStream output = new DataOutputStream(file)){
            // 写入文件
            byte buffer[] = new byte[BufferLength];
            // 接收数据
            InputStream inputStream = request.inputStream();
            int remain = size;
            while(remain > 0){
               int readed = inputStream.read(buffer, 0, BufferLength);
               if(readed > 0){
                  output.write(buffer, 0, readed);
               }
               remain -= readed;
               if((readed == 0) || (remain <= 0)){
                  break;
               }
            }
         }
         //         // 写入文件
         //         byte buffer[] = new byte[BufferLength];
         //         FileChannel channel = file.getChannel();
         //         MappedByteBuffer mapping = channel.map(FileChannel.MapMode.READ_WRITE, 0, size);
         //         // 接收数据
         //         InputStream inputStream = request.inputStream();
         //         int remain = size;
         //         while(remain > 0){
         //            int readed = inputStream.read(buffer, 0, BufferLength);
         //            if(readed > 0){
         //               mapping.put(buffer, 0, readed);
         //            }
         //            remain -= readed;
         //            if((readed == 0) || (remain <= 0)){
         //               break;
         //            }
         //         }
         //         channel.close();
         _logger.debug(this, "process", "Upload data success. (size={1}, file={2})", size, storageName);
      }catch(IOException e){
         _logger.error(this, "process", e);
         throw new FFatalError(e);
      }
   }
}
