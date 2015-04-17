package org.mo.content.face.resource.texture;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.lang.FObject;
import org.mo.content.engine3d.core.texture.IRs3TextureConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FBitmapServlet
      extends FObject
      implements
         IBitmapServlet
{
   // 日志输出接口
   //private static ILogger _logger = RLogger.find(FBitmapServlet.class);

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 纹理位图接口
   @ALink
   protected IRs3TextureConsole _textureConsole;

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
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response){
      //      // 检查代码
      //      String guid = context.parameter("guid");
      //      String code = context.parameter("code");
      //      if(RString.isEmpty(guid) || RString.isEmpty(code)){
      //         throw new FFatalError("Texture parameter is invalid. (guid={1}, code={2})", guid, code);
      //      }
      //      // 查找纹理
      //      FDataResource3dTextureLogic textureLogic = logicContext.findLogic(FDataResource3dTextureLogic.class);
      //      FDataResource3dTextureUnit textureUnit = textureLogic.findByGuid(guid);
      //      if(textureUnit == null){
      //         throw new FFatalError("Texture is not exists. (guid={1})", guid);
      //      }
      //      String formatCode = "jpg";
      //      byte[] data = _textureConsole.makeBitmapData(logicContext, guid, code);
      //      if("environment".equals(code)){
      //         int index = context.parameterAsInteger("index", 0);
      //         try(FImage image = new FImage(data)){
      //            int height = image.height();
      //            try(FImage faceImage = image.imageRectangle(height * index, 0, height, height)){
      //               data = faceImage.toBytes("jpg");
      //            }
      //         }catch(Exception e){
      //            throw new FFatalError(e);
      //         }
      //      }else{
      //         if(code.contains("_")){
      //            String[] items = RString.split(code, '_');
      //            if(items.length == 2){
      //               formatCode = "png";
      //            }
      //         }
      //      }
      //      int dataLength = data.length;
      //      // 发送数据
      //      _logger.debug(this, "process", "Send data. (length={1})", dataLength);
      //      response.setCharacterEncoding("utf-8");
      //      response.setStatus(HttpServletResponse.SC_OK);
      //      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      //      response.addHeader("Last-Modified", System.currentTimeMillis());
      //      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      //      switch(formatCode){
      //         case "jpg":
      //            response.setContentType(EMime.Jpg.mime());
      //            break;
      //         case "png":
      //            response.setContentType(EMime.Png.mime());
      //            break;
      //         default:
      //            response.setContentType(EMime.Bin.mime());
      //      }
      //      response.setContentLength(dataLength);
      //      response.write(data, 0, dataLength);
   }
}
