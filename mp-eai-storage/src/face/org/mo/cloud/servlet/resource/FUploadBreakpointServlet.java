package org.mo.cloud.servlet.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import org.mo.com.io.FStringFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FBytes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FUploadBreakpointServlet
      extends FObject
      implements
         IUploadDirectServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FUploadBreakpointServlet.class);

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

   // 数据块最小尺寸
   protected static int BlockMinSize = 1024 * 16;

   // 数据块最大尺寸
   protected static int BlockMaxSize = 1024 * 256;

   // 应用服务接口
   //   @ALink
   //   protected IApplicationConsole _applicationConsole;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void process(IWebContext context,
                       IWebServletRequest request,
                       IWebServletResponse response){
      // 获取传入内容
      //int typeCd = RInteger.parse(context.parameter("type_cd"));
      String code = context.parameter("code");
      String name = context.parameter("name");
      String sizeValue = context.parameter("size");
      int size = RInteger.parse(sizeValue);
      String lengthValue = context.parameter("length");
      int length = RInteger.parse(lengthValue);
      String positionValue = context.parameter("position");
      int position = RInteger.parse(positionValue);
      // 计算分块大小
      int blockSize = length / 16;
      if(blockSize < BlockMinSize){
         blockSize = BlockMinSize;
      }
      if(blockSize > BlockMaxSize){
         blockSize = BlockMaxSize;
      }
      _logger.debug(this, "process", "Upload data. (code={1}, length={2}, position={3}, block_size={4})", code, length, position, blockSize);
      // 写入文件
      String resourceCode = null;
      //      if(typeCd == EGcResource.Application){
      //         resourceCode = _applicationConsole.makeStorePath(code, true);
      //      }else{
      //         throw new FFatalError("Unknown type code. (type_cd={1})", typeCd);
      //      }
      String fileName = resourceCode + "/" + name;
      String fileStoreName = fileName + ".store";
      try(RandomAccessFile file = new RandomAccessFile(fileName, "rw")){
         // 设置文件大小
         if(file.length() != size){
            file.setLength(size);
         }
         // 设置写入位置
         file.seek(position);
         // 创建数据缓冲
         FBytes stream = new FBytes();
         // 接收数据
         byte buffer[] = new byte[BufferLength];
         InputStream inputStream = request.inputStream();
         long dataRemain = length;
         long readTotal = 0;
         long positionTotal = position;
         while(true){
            int readed = inputStream.read(buffer, 0, BufferLength);
            readTotal += readed;
            positionTotal += readed;
            if(readed > 0){
               stream.append(buffer, 0, readed);
               // 写入分块数据
               int streamLength = stream.length();
               if(streamLength > blockSize){
                  int blockCount = streamLength / blockSize;
                  int blockTotal = blockSize * blockCount;
                  file.write(stream.memory(), 0, blockTotal);
                  stream.remove(0, blockTotal);
                  // 写入数据位置
                  FStringFile storeFile = new FStringFile();
                  storeFile.append(positionTotal);
                  storeFile.saveFile(fileStoreName);
               }
            }
            dataRemain -= readed;
            // 写入剩余数据
            if((readed == 0) || (dataRemain <= 0)){
               int streamLength = stream.length();
               if(streamLength > 0){
                  file.write(stream.memory(), 0, streamLength);
               }
               // 删除位置文件
               RFile.delete(fileStoreName);
               break;
            }
         }
         _logger.debug(this, "process", "Upload data success. (length={1}, read_total={2})", length, readTotal);
      }catch(IOException e){
         throw new FFatalError(e);
      }
   }
}
