package org.mo.content.face.resource3d.resource;

import com.cyou.gccloud.define.enums.core.EGcResource;
import java.awt.image.BufferedImage;
import javax.servlet.http.HttpServletResponse;
import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.resource3d.mesh.FGcRs3MeshInfo;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.core.resource.bitmap.IC2dBitmapConsole;
import org.mo.content.core.resource3d.mesh.IC3dMeshConsole;
import org.mo.content.core.resource3d.resource.IC3dResourceConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.image.FImage;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FPreviewServlet
      extends FObject
      implements
         IPreviewServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FPreviewServlet.class);

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

   // 位图模型接口
   @ALink
   protected IC2dBitmapConsole _bitmapConsole;

   // 资源模型接口
   @ALink
   protected IC3dResourceConsole _resourceConsole;

   // 网格模型接口
   @ALink
   protected IC3dMeshConsole _meshConsole;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void process(IWebContext context,
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response){
      // 检查参数
      String typeCd = context.parameter("type_cd");
      String guid = context.parameter("guid");
      if(RString.isEmpty(typeCd) || RString.isEmpty(guid)){
         throw new FFatalError("Parameter is invalid.");
      }
      //............................................................
      byte[] data = _resourceConsole.findPreviewData(logicContext, guid);
      // 生成预览
      if(data == null){
         // 获得资源
         FGcResourceInfo resource = _resourceConsole.findByGuid(logicContext, guid);
         if(resource == null){
            throw new FFatalError("Resource is not exists. (guid={1})", guid);
         }
         long resourceId = resource.ouid();
         // 生成数据
         switch(typeCd){
            case EGcResource.BitmapString:
               FGcResBitmapInfo bitmap = _bitmapConsole.findByResourceId(logicContext, resourceId);
               String bitmapGuid = bitmap.guid();
               data = _bitmapConsole.makePreviewData(logicContext, bitmapGuid);
               _resourceConsole.uploadPreviewData(logicContext, bitmapGuid, data);
               break;
            case EGcResource.Mesh3dString:
               //data = _resourceConsole.findPreviewData(logicContext, typeCd, guid);
               break;
         }
      }
      int dataLength = 0;
      if(data != null){
         dataLength = data.length;
      }
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send resource preview data. (type_cd={1}, guid={2}, length={3})", typeCd, guid, dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      response.setContentType(EMime.Jpg.mime());
      response.setContentLength(dataLength);
      response.write(data, 0, dataLength);
   }

   //============================================================
   // <T>上传处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void upload(IWebContext context,
                      ILogicContext logicContext,
                      IWebServletRequest request,
                      IWebServletResponse response){
      // 检查参数
      String typeCd = context.parameter("type_cd");
      String guid = context.parameter("guid");
      if(RString.isEmpty(typeCd) || RString.isEmpty(guid)){
         throw new FFatalError("Parameter is invalid.");
      }
      int width = context.parameterAsInteger("width");
      int height = context.parameterAsInteger("height");
      if((width <= 0) || (height <= 0)){
         throw new FFatalError("Parameter size is invalid. (width={1}, height={2})", width, height);
      }
      //............................................................
      // 读取数据（数据需要上下颠倒）
      FByteStream stream = new FByteStream(Integer.BYTES * width * height);
      stream.loadStream(request.inputStream());
      byte[] uploadData = stream.memory();
      int[] pixelData = new int[width * height];
      int position = 0;
      for(int y = 0; y < height; y++){
         int index = 4 * width * (height - y - 1);
         for(int x = 0; x < width; x++){
            int r = (uploadData[index++] & 0xFF);
            int g = (uploadData[index++] & 0xFF);
            int b = (uploadData[index++] & 0xFF);
            index++;
            pixelData[position++] = 0xFF000000 | (r << 16) | (g << 8) | b;
         }
      }
      // 生成图像
      BufferedImage bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      bufferImage.setRGB(0, 0, width, height, pixelData, 0, width);
      // 获得数据
      byte[] data = null;
      try(FImage image = new FImage(bufferImage)){
         //image.resize(200, 150, false);
         data = image.toBytes("jpg");
      }catch(Exception e){
         throw new FFatalError(e);
      }
      //............................................................
      // 上传预览数据
      switch(typeCd){
         case "mesh":
            // 获得网格信息
            FGcRs3MeshInfo mesh = _meshConsole.findByGuid(logicContext, guid);
            if(mesh == null){
               throw new FFatalError("Mesh is empty. (guid={1})", guid);
            }
            // 修改更新时间，预览图才能重新显示
            FGcResourceInfo resource = _resourceConsole.find(logicContext, mesh.resourceId());
            _resourceConsole.doUpdate(logicContext, resource);
            // 上传数据
            _resourceConsole.uploadPreviewData(logicContext, resource.guid(), data);
            break;
         default:
            throw new FFatalError("Upload preview type failure. (type_cd={1})", typeCd);
      }
      int dataLength = data.length;
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send resource preview data. (type_cd={1}, guid={2}, length={3})", typeCd, guid, dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      response.setContentType(EMime.Jpg.mime());
      response.setContentLength(dataLength);
      response.write(data, 0, dataLength);
   }
}
