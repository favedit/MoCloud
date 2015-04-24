package org.mo.content.face.resource.bitmap;

import javax.servlet.http.HttpServletResponse;
import org.mo.cloud.logic.resource.FGcResourceCatalogInfo;
import org.mo.cloud.logic.resource.IGcResourceCatalogConsole;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.io.FByteFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.core.resource.bitmap.ICntBitmapConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>纹理数据。</T>
//============================================================
public class FBitmapServlet
      extends FObject
      implements
         IBitmapServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FBitmapServlet.class);

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 资源目录控制台
   @ALink
   protected IGcResourceCatalogConsole _catalogConsole;

   // 资源位图控制台
   @ALink
   protected ICntBitmapConsole _bitmapConsole;

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
   //   public void process(IWebContext context,
   //                       ILogicContext logicContext,
   //                       IWebServletRequest request,
   //                       IWebServletResponse response){
   //               // 检查代码
   //               String guid = context.parameter("guid");
   //               String code = context.parameter("code");
   //               if(RString.isEmpty(guid) || RString.isEmpty(code)){
   //                  throw new FFatalError("Texture parameter is invalid. (guid={1}, code={2})", guid, code);
   //               }
   //               // 查找纹理
   //               FDataResource3dTextureLogic textureLogic = logicContext.findLogic(FDataResource3dTextureLogic.class);
   //               FDataResource3dTextureUnit textureUnit = textureLogic.findByGuid(guid);
   //               if(textureUnit == null){
   //                  throw new FFatalError("Texture is not exists. (guid={1})", guid);
   //               }
   //               String formatCode = "jpg";
   //               byte[] data = _textureConsole.makeBitmapData(logicContext, guid, code);
   //               if("environment".equals(code)){
   //                  int index = context.parameterAsInteger("index", 0);
   //                  try(FImage image = new FImage(data)){
   //                     int height = image.height();
   //                     try(FImage faceImage = image.imageRectangle(height * index, 0, height, height)){
   //                        data = faceImage.toBytes("jpg");
   //                     }
   //                  }catch(Exception e){
   //                     throw new FFatalError(e);
   //                  }
   //               }else{
   //                  if(code.contains("_")){
   //                     String[] items = RString.split(code, '_');
   //                     if(items.length == 2){
   //                        formatCode = "png";
   //                     }
   //                  }
   //               }
   //               int dataLength = data.length;
   //               // 发送数据
   //               _logger.debug(this, "process", "Send data. (length={1})", dataLength);
   //               response.setCharacterEncoding("utf-8");
   //               response.setStatus(HttpServletResponse.SC_OK);
   //               response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
   //               response.addHeader("Last-Modified", System.currentTimeMillis());
   //               response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
   //               switch(formatCode){
   //                  case "jpg":
   //                     response.setContentType(EMime.Jpg.mime());
   //                     break;
   //                  case "png":
   //                     response.setContentType(EMime.Png.mime());
   //                     break;
   //                  default:
   //                     response.setContentType(EMime.Bin.mime());
   //               }
   //               response.setContentLength(dataLength);
   //               response.write(data, 0, dataLength);
   //   }

   //============================================================
   // <T>获得预览数据处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param session 会话
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void view(IWebContext context,
                    ILogicContext logicContext,
                    FGcSessionInfo session,
                    IWebServletRequest request,
                    IWebServletResponse response){
      // 检查参数
      String guid = context.parameter("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Parameter is invalid.");
      }
      //............................................................
      // 生成预览
      byte[] data = _bitmapConsole.makeViewData(logicContext, guid);
      if(data == null){
         throw new FFatalError("Bitmap is not exists. (guid={1})", guid);
      }
      int dataLength = data.length;
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send bitmap image view data. (guid={1}, length={2})", guid, dataLength);
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
   // <T>获得预览数据处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param session 会话
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void preview(IWebContext context,
                       ILogicContext logicContext,
                       FGcSessionInfo session,
                       IWebServletRequest request,
                       IWebServletResponse response){
      // 检查参数
      String guid = context.parameter("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Parameter is invalid.");
      }
      //............................................................
      // 生成预览
      byte[] data = _bitmapConsole.makePreviewData(logicContext, guid);
      int dataLength = 0;
      if(data != null){
         dataLength = data.length;
      }
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send bitmap image preview data. (guid={1}, length={2})", guid, dataLength);
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
   // <T>导入数据处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param session 会话
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void importData(IWebContext context,
                          ILogicContext logicContext,
                          FGcSessionInfo session,
                          IWebServletRequest request,
                          IWebServletResponse response){
      // 检查参数
      String nodeGuid = context.parameter("node_guid");
      String code = context.parameter("code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Picture code is empty.");
      }
      String label = context.parameter("label");
      if(RString.isEmpty(label)){
         throw new FFatalError("Picture label is empty.");
      }
      int dataLength = context.parameterAsInteger("data_length");
      if((dataLength <= 0) || (dataLength > RInteger.SIZE_64M)){
         throw new FFatalError("Picture data length is invalid.");
      }
      String fileName = context.parameter("file_name");
      if(RString.isEmpty(fileName)){
         throw new FFatalError("Picture file name is empty.");
      }
      String extension = RFile.extension(fileName);
      long userId = session.userId();
      long projectId = session.projectId();
      // 获得节点编号
      long catalogId = 0;
      if(!RString.isEmpty(nodeGuid)){
         FGcResourceCatalogInfo catalog = _catalogConsole.findByGuid(logicContext, nodeGuid);
         if(catalog == null){
            throw new FFatalError("Catalog is not exists.");
         }
         catalogId = catalog.ouid();
      }
      // 导入数据
      if("jpg".equals(extension)){
      }else if("png".equals(extension)){
      }else{
         throw new FFatalError("Unknown file format.");
      }
      // 读取数据
      FByteFile file = new FByteFile(dataLength);
      file.loadStream(request.inputStream());
      // 导入数据
      try{
         // 创建图片
         FGcResBitmapInfo bitmap = _bitmapConsole.doPrepare(logicContext);
         bitmap.setUserId(userId);
         bitmap.setProjectId(projectId);
         bitmap.setCatalogId(catalogId);
         bitmap.setCode(code);
         bitmap.setLabel(label);
         _bitmapConsole.doInsert(logicContext, bitmap);
         // 上传图像数据
         _bitmapConsole.updateData(logicContext, bitmap, file);
      }catch(Exception e){
         throw new FFatalError(e);
      }finally{
         file.close();
      }
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send model data. (length={1})", dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      response.setContentType(EMime.Bin.mime());
      response.setContentLength(0);
   }

   //============================================================
   // <T>更新数据处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param session 会话
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void updateData(IWebContext context,
                          ILogicContext logicContext,
                          FGcSessionInfo session,
                          IWebServletRequest request,
                          IWebServletResponse response){
      // 检查参数
      String guid = context.parameter("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Bitmap guid is empty.");
      }
      int dataLength = context.parameterAsInteger("data_length");
      if((dataLength <= 0) || (dataLength > RInteger.SIZE_64M)){
         throw new FFatalError("Bitmap data length is invalid.");
      }
      String fileName = context.parameter("file_name");
      if(RString.isEmpty(fileName)){
         throw new FFatalError("Bitmap file name is empty.");
      }
      String extension = RFile.extension(fileName);
      if("jpg".equals(extension)){
      }else if("png".equals(extension)){
      }else{
         throw new FFatalError("Unknown file format.");
      }
      // 获得位图信息
      FGcResBitmapInfo bitmapInfo = _bitmapConsole.getByGuid(logicContext, guid);
      if(bitmapInfo == null){
         throw new FFatalError("Bitmap is notformat.");
      }
      // 检查用户有效
      long userId = session.userId();
      if(bitmapInfo.userId() != userId){
         throw new FFatalError("Resource bitmap user is invalid. (project_user_id={1}, session_user_id={2})", bitmapInfo.userId(), userId);
      }
      // 上传图像数据
      FByteFile file = new FByteFile(dataLength);
      file.loadStream(request.inputStream());
      try{
         _bitmapConsole.updateData(logicContext, bitmapInfo, file);
      }catch(Exception e){
         throw new FFatalError(e);
      }finally{
         file.close();
      }
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send model data. (length={1})", dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      response.setContentType(EMime.Bin.mime());
      response.setContentLength(0);
   }
}
