package org.mo.cloud.servlet.picture;

import org.mo.cloud.core.storage.ICloudStorageConsole;

import javax.servlet.http.HttpServletResponse;
import org.mo.cloud.core.storage.SGcStorageImageStyle;
import org.mo.com.io.FByteFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.core.aop.face.ALink;
import org.mo.eng.memorycache.FMemoryChannel;
import org.mo.eng.memorycache.IMemoryCacheConsole;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>图片服务。</T>
//============================================================
public class FPictureServlet
      extends FObject
      implements
         IPictureServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FPictureServlet.class);

   // 缓冲时间
   protected long _cacheTimeout = 3600 * 24 * 7 * 4;

   // 内存缓冲控制台
   @ALink
   protected IMemoryCacheConsole _memoryCacheConsole;

   // 数据存储控制台
   @ALink
   protected ICloudStorageConsole _storageConsole;

   //============================================================
   // <T>生成图片。</T>
   //
   // @param fileName 文件名称
   // @param style 样式
   // @return 处理结果
   //============================================================
   //   public String makePicture(String resourceName,
   //                             String fileName,
   //                             SGcStorageImageStyle style){
   //      // 读取图片
   //      FImage image = new FImage(resourceName);
   //      // 变换大小
   //      int width = style.width();
   //      int height = style.height();
   //      if((width > 0) && (height > 0)){
   //         boolean alpha = style.supportAlpha();
   //         image.resizeScale(width, height, alpha);
   //      }
   //      // 变换圆角
   //      int radius = style.round();
   //      if(radius > 0){
   //         image.round(radius);
   //      }
   //      // 存储文件
   //      image.saveFile(fileName);
   //      _logger.debug(this, "makePicture", "Make picture to file. (file_name={1}, style={2})", fileName, style.pack());
   //      return fileName;
   //   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public void sendData(IWebServletResponse response,
                        EMime mimeCd,
                        byte[] data){
      try{
         response.setCharacterEncoding("utf-8");
         response.setStatus(HttpServletResponse.SC_OK);
         response.setHeader("Cache-Control", "max-age=" + _cacheTimeout);
         response.addHeader("Last-Modified", System.currentTimeMillis());
         response.addHeader("Expires", System.currentTimeMillis() + _cacheTimeout * 1000);
         if(data != null){
            response.setContentType(mimeCd.mime());
            response.setContentLength(data.length);
            response.write(data);
         }else{
            response.setContentLength(0);
         }
      }catch(Exception e){
         _logger.error(this, "process", e);
      }
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public void processNoStyle(IWebContext context,
                              IWebServletRequest request,
                              IWebServletResponse response,
                              String resource){
      // 获取数据
      byte[] data = null;
      try(FMemoryChannel channel = _memoryCacheConsole.alloc()){
         // 从缓冲中获得
         String code = "mo-cache|resource|" + resource + "|" + RDateTime.format("yyyymmdd");
         if(channel != null){
            data = (byte[])channel.get(code);
         }
         // 从文件中获得
         if(data == null){
            String fileName = _storageConsole.makeFileName(resource);
            if(RFile.exists(fileName)){
               try(FByteFile file = new FByteFile(fileName)){
                  data = file.toArray();
                  _logger.debug(this, "processNoStyle", "Read resource from file. (file_name={1})", fileName);
               }
            }
            // 存储到缓冲
            if((data != null) && (channel != null)){
               channel.set(code, data);
            }
         }
         //............................................................
         // 发送数据
         String extension = RFile.extension(resource);
         EMime mimeCd = EMime.parseExtension(extension);
         sendData(response, mimeCd, data);
      }catch(Exception e){
         _logger.error(this, "process", e);
      }
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public void processStyle(IWebContext context,
                            IWebServletRequest request,
                            IWebServletResponse response,
                            String resource,
                            SGcStorageImageStyle style){
      // 计算名称
      String stylePack = style.pack();
      EMime mimeCd = style.mimeCd();
      String extension = mimeCd.type();
      String path = RFile.extensionPath(resource);
      String name = path + "_" + stylePack + "." + extension;
      // 获取数据
      byte[] data = null;
      try(FMemoryChannel channel = _memoryCacheConsole.alloc()){
         // 从缓冲中获得
         String code = "mo-cache|resource|" + name + "|" + RDateTime.format("yyyymmdd");
         if(channel != null){
            data = (byte[])channel.get(code);
         }
         // 从文件中获得
         if(data == null){
            String fileName = _storageConsole.makeFileName(name);
            if(RFile.exists(fileName)){
               try(FByteFile file = new FByteFile(fileName)){
                  data = file.toArray();
                  _logger.debug(this, "processStyle", "Read resource from file. (file_name={1})", fileName);
               }
            }else{
               // 生成文件
               String resourceName = _storageConsole.makeFileName(resource);
               if(RFile.exists(resourceName)){
                  //makePicture(resourceName, fileName, style);
                  if(RFile.exists(fileName)){
                     try(FByteFile file = new FByteFile(fileName)){
                        data = file.toArray();
                     }
                  }
               }
            }
            // 存储到缓冲
            if((data != null) && (channel != null)){
               channel.set(code, data);
            }
         }
         //............................................................
         // 发送数据
         sendData(response, mimeCd, data);
      }catch(Exception e){
         _logger.error(this, "process", e);
      }
   }

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
      // 检查参数
      String resource = context.parameter("r");
      if(RString.isEmpty(resource)){
         sendData(response, null, null);
         return;
      }
      // 解析样式
      String stylePack = RString.nvl(context.parameter("s"));
      SGcStorageImageStyle style = null;
      if(!RString.isEmpty(stylePack)){
         style = new SGcStorageImageStyle();
         style.unpack(stylePack);
      }
      // 根据样式处理
      if(style == null){
         processNoStyle(context, request, response, resource);
      }else{
         processStyle(context, request, response, resource, style);
      }
   }
}
