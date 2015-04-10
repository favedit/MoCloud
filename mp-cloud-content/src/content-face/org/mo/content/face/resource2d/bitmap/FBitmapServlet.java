package org.mo.content.face.resource2d.bitmap;

import javax.servlet.http.HttpServletResponse;
import org.mo.cloud.logic.resource.FGcResourceCatalogInfo;
import org.mo.cloud.logic.resource.IGcResourceCatalogConsole;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapImageInfo;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.resource3d.mesh.IGcRs3MeshConsole;
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
import org.mo.content.core.resource.bitmap.IC2dBitmapConsole;
import org.mo.content.core.resource.bitmap.IC2dBitmapImageConsole;
import org.mo.content.core.resource3d.mesh.IC3dMeshConsole;
import org.mo.content.engine3d.core.texture.IRs3TextureConsole;
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

   // 纹理位图接口
   @ALink
   protected IRs3TextureConsole _textureConsole;

   // 数据网格控制台
   @ALink
   protected IGcResourceCatalogConsole _dataCatalogConsole;

   // 数据网格控制台
   @ALink
   protected IGcRs3MeshConsole _dataMeshConsole;

   // 资源位图接口
   @ALink
   protected IC2dBitmapConsole _bitmapConsole;

   // 资源位图图像接口
   @ALink
   protected IC2dBitmapImageConsole _bitmapImageConsole;

   // 资源网格接口
   @ALink
   protected IC3dMeshConsole _c3MeshConsole;

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
         FGcResourceCatalogInfo catalog = _dataCatalogConsole.findByGuid(logicContext, nodeGuid);
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
         _bitmapConsole.createBitmap(logicContext, bitmap);
         // 新建图像
         FGcResBitmapImageInfo bitmapImage = _bitmapImageConsole.doPrepare(logicContext);
         bitmapImage.setUserId(userId);
         bitmapImage.setProjectId(projectId);
         bitmapImage.setBitmapId(bitmap.ouid());
         bitmapImage.setCode("default");
         bitmapImage.setLabel("默认");
         _bitmapImageConsole.doInsert(logicContext, bitmapImage);
         // 上传图像数据
         _bitmapConsole.importBitmap(logicContext, bitmapImage, file);
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
