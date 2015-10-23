package org.mo.content.face.resource.material;

import org.mo.cloud.core.storage.mongo.IGcStorageMongoConsole;

import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.resource.material.FGcResMaterialBitmapInfo;
import org.mo.cloud.logic.data.resource.material.FGcResMaterialInfo;
import org.mo.cloud.logic.data.resource.bitmap.FGcResBitmapInfo;
import javax.servlet.http.HttpServletResponse;
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
import org.mo.content.core.resource.material.ICntMaterialConsole;
import org.mo.content.engine.core.material.IResMaterialBitmapConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.image.FImage;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>材质数据处理。</T>
//============================================================
public class FMaterialServlet
      extends FObject
      implements
         IMaterialServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMaterialServlet.class);

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 存储管理接口
   @ALink
   protected IGcStorageMongoConsole _storageConsole;

   // 资源位图控制台
   @ALink
   protected ICntBitmapConsole _bitmapConsole;

   // 资源材质接口
   @ALink
   protected ICntMaterialConsole _materialConsole;

   // 资源材质纹理控制台
   @ALink
   protected IResMaterialBitmapConsole _materialBitmapConsole;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param request 页面请求
   // @param response 页面应答
   //============================================================
   @Override
   public void process(IWebContext context,
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response){
      // 检查代码
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      if(RString.isEmpty(guid) || RString.isEmpty(code)){
         throw new FFatalError("Material parameter is invalid. (guid={1}, code={2})", guid, code);
      }
      // 查找纹理
      FGcResMaterialInfo materialInfo = _materialConsole.findByGuid(logicContext, guid);
      if(materialInfo == null){
         throw new FFatalError("Material is not exists. (guid={1})", guid);
      }
      String formatCode = "jpg";
      byte[] data = _materialConsole.makeBitmapData(logicContext, guid, code);
      if("environment".equals(code)){
         int index = context.parameterAsInteger("index", 0);
         try(FImage image = new FImage(data)){
            int height = image.height();
            try(FImage faceImage = image.imageRectangle(height * index, 0, height, height)){
               data = faceImage.toBytes("jpg");
            }
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }else{
         if(code.contains("_")){
            String[] items = RString.split(code, '_');
            if(items.length == 2){
               formatCode = "png";
            }
         }
      }
      int dataLength = data.length;
      if(dataLength == 0){
         throw new FFatalError("Make bitmap data failure.");
      }
      // 发送数据
      _logger.debug(this, "process", "Send data. (length={1})", dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      switch(formatCode){
         case "jpg":
            response.setContentType(EMime.Jpg.mime());
            break;
         case "png":
            response.setContentType(EMime.Png.mime());
            break;
         default:
            response.setContentType(EMime.Bin.mime());
      }
      response.setContentLength(dataLength);
      response.write(data, 0, dataLength);
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param request 页面请求
   // @param response 页面应答
   //============================================================
   @Override
   public void query(IWebContext context,
                     ILogicContext logicContext,
                     FGcSessionInfo session,
                     IWebServletRequest request,
                     IWebServletResponse response){
      // 检查代码
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      if(RString.isEmpty(guid) || RString.isEmpty(code)){
         throw new FFatalError("Material parameter is invalid. (guid={1}, code={2})", guid, code);
      }
      // 查找纹理
      FGcResMaterialInfo materialInfo = _materialConsole.findByGuid(logicContext, guid);
      if(materialInfo == null){
         throw new FFatalError("Material is not exists. (guid={1})", guid);
      }
      String formatCode = "jpg";
      byte[] data = _materialConsole.makeBitmapData(logicContext, guid, code);
      if("environment".equals(code)){
         int index = context.parameterAsInteger("index", 0);
         try(FImage image = new FImage(data)){
            int height = image.height();
            try(FImage faceImage = image.imageRectangle(height * index, 0, height, height)){
               data = faceImage.toBytes("jpg");
            }
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }else{
         if(code.contains("_")){
            String[] items = RString.split(code, '_');
            if(items.length == 2){
               formatCode = "png";
            }
         }
      }
      int dataLength = data.length;
      if(dataLength == 0){
         throw new FFatalError("Make bitmap data failure.");
      }
      // 发送数据
      _logger.debug(this, "process", "Send data. (length={1})", dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      switch(formatCode){
         case "jpg":
            response.setContentType(EMime.Jpg.mime());
            break;
         case "png":
            response.setContentType(EMime.Png.mime());
            break;
         default:
            response.setContentType(EMime.Bin.mime());
      }
      response.setContentLength(dataLength);
      response.write(data, 0, dataLength);
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param request 页面请求
   // @param response 页面应答
   //============================================================
   @Override
   public void data(IWebContext context,
                    ILogicContext logicContext,
                    FGcSessionInfo session,
                    IWebServletRequest request,
                    IWebServletResponse response){
      // 检查代码
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      if(RString.isEmpty(guid) && RString.isEmpty(code)){
         throw new FFatalError("Material parameter is invalid. (guid={1}, code={2})", guid, code);
      }
      // 查找材质
      FGcResMaterialInfo materialInfo = _materialConsole.findByGuid(logicContext, guid);
      if(materialInfo == null){
         throw new FFatalError("Material is not exists. (guid={1})", guid);
      }
      // 获得数据
      byte[] data = _materialConsole.makeResourceData(logicContext, guid);
      int dataLength = data.length;
      // 发送数据
      _logger.debug(this, "process", "Send data. (length={1})", dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      response.setContentType(EMime.Bin.mime());
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
      //String nodeGuid = context.parameter("node_guid");
      String materialGuid = context.parameter("material_guid");
      if(RString.isEmpty(materialGuid)){
         throw new FFatalError("Material guid is empty.");
      }
      String code = context.parameter("code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Bitmap code is empty.");
      }
      String label = context.parameter("label");
      if(RString.isEmpty(label)){
         throw new FFatalError("Bitmap label is empty.");
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
      // 获得会话信息
      long userId = session.userId();
      long projectId = session.projectId();
      // 获得节点编号
      FGcResMaterialInfo materialInfo = _materialConsole.getByGuid(logicContext, materialGuid);
      long materialId = materialInfo.ouid();
      //long catalogId = 0;
      //if(!RString.isEmpty(nodeGuid)){
      //   FGcResourceCatalogInfo catalog = _catalogConsole.findByGuid(logicContext, nodeGuid);
      //   if(catalog == null){
      //      throw new FFatalError("Catalog is not exists.");
      //   }
      //   catalogId = catalog.ouid();
      //}
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
         //bitmap.setCatalogId(catalogId);
         bitmap.setCode(code);
         bitmap.setLabel(label);
         bitmap.setFormatCode("jpg");
         _bitmapConsole.doInsert(logicContext, bitmap);
         long bitmapId = bitmap.ouid();
         // 上传图像数据
         _bitmapConsole.updateData(logicContext, bitmap, file);
         // 关联材质
         FGcResMaterialBitmapInfo materialBitmapInfo = _materialBitmapConsole.doPrepare(logicContext);
         materialBitmapInfo.setUserId(userId);
         materialBitmapInfo.setMaterialId(materialId);
         materialBitmapInfo.setBitmapId(bitmapId);
         materialBitmapInfo.setFullCode(code);
         materialBitmapInfo.setCode(code);
         _materialBitmapConsole.doInsert(logicContext, materialBitmapInfo);
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
   // <T>替换数据处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param session 会话
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void replaceData(IWebContext context,
                           ILogicContext logicContext,
                           FGcSessionInfo session,
                           IWebServletRequest request,
                           IWebServletResponse response){
      // 检查参数
      String materialGuid = context.parameter("material_guid");
      if(RString.isEmpty(materialGuid)){
         throw new FFatalError("Material guid is empty.");
      }
      String materialBitmapGuid = context.parameter("link_guid");
      if(RString.isEmpty(materialBitmapGuid)){
         throw new FFatalError("Material bitmap guid is empty.");
      }
      String bitmapGuid = context.parameter("bitmap_guid");
      if(RString.isEmpty(bitmapGuid)){
         throw new FFatalError("Bitmap guid is empty.");
      }
      String code = context.parameter("code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Bitmap code is empty.");
      }
      String label = context.parameter("label");
      if(RString.isEmpty(label)){
         throw new FFatalError("Bitmap label is empty.");
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
      // 获得节点编号
      FGcResBitmapInfo bitmapInfo = _bitmapConsole.getByGuid(logicContext, bitmapGuid);
      FGcResMaterialBitmapInfo materialBitmapInfo = _materialBitmapConsole.getByGuid(logicContext, materialBitmapGuid);
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
         // 设置位图信息
         bitmapInfo.setCode(code);
         bitmapInfo.setLabel(label);
         bitmapInfo.setSize(0, 0);
         _bitmapConsole.updateData(logicContext, bitmapInfo, file);
         // 设置关联信息
         materialBitmapInfo.setCode(code);
         _materialBitmapConsole.doUpdate(logicContext, materialBitmapInfo);
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
