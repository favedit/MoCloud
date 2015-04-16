package org.mo.content.face.resource.material;

import javax.servlet.http.HttpServletResponse;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.resource.material.FGcResMaterialInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.core.resource.material.ICntMaterialConsole;
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
   protected IGcStorageConsole _storageConsole;

   // 资源模型接口
   @ALink
   protected ICntMaterialConsole _materialConsole;

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
   public void process(IWebContext context,
                       ILogicContext logicContext,
                       FGcSessionInfo session,
                       IWebServletRequest request,
                       IWebServletResponse response){
      // 检查代码
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      if(RString.isEmpty(guid) || RString.isEmpty(code)){
         throw new FFatalError("Texture parameter is invalid. (guid={1}, code={2})", guid, code);
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
}
