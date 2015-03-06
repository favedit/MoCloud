package org.mo.content.face.resource3d.texture;

import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapLogic;
import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapUnit;
import com.cyou.gccloud.data.data.FDataResource3dTextureLogic;
import com.cyou.gccloud.data.data.FDataResource3dTextureUnit;
import com.cyou.gccloud.data.data.FDataResourceBitmapImageUnit;
import javax.servlet.http.HttpServletResponse;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.core.resource3d.texture.IC3dBitmapConsole;
import org.mo.content.resource3d.texture.FRs3TextureBitmapPack;
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
   private static ILogger _logger = RLogger.find(FBitmapServlet.class);

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 纹理位图接口
   @ALink
   protected IC3dBitmapConsole _bitmapConsole;

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
      // 检查代码
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      if(RString.isEmpty(guid) || RString.isEmpty(code)){
         throw new FFatalError("Texture parameter is invalid. (guid={1}, code={2})", guid, code);
      }
      // 查找纹理
      FDataResource3dTextureLogic textureLogic = logicContext.findLogic(FDataResource3dTextureLogic.class);
      FDataResource3dTextureUnit textureUnit = textureLogic.findByGuid(guid);
      if(textureUnit == null){
         throw new FFatalError("Texture is not exists. (guid={1})", guid);
      }
      long textureId = textureUnit.ouid();
      byte[] data = null;
      String formatCode = null;
      if(code.contains("|")){
         String[] items = RString.split(code, '|');
         int count = items.length;
         Object[] itemDatas = new Object[items.length];
         for(int n = 0; n < count; n++){
            String item = items[n];
            if(!RString.isEmpty(item)){
               String whereSql = "(" + FDataResource3dTextureBitmapLogic.TEXTURE_ID + "=" + textureId + ") AND (" + FDataResource3dTextureBitmapLogic.CODE + "='" + item + "')";
               FDataResource3dTextureBitmapLogic textureBitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
               FDataResource3dTextureBitmapUnit textureBitmapUnit = textureBitmapLogic.search(whereSql);
               if(textureBitmapUnit == null){
                  throw new FFatalError("Texture bitmap is not exists. (code={1})", code);
               }
               FDataResourceBitmapImageUnit imageUnit = _bitmapConsole.findBitmapUnit(logicContext, textureBitmapUnit.bitmapId());
               formatCode = imageUnit.formatCode();
               SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, imageUnit.guid());
               itemDatas[n] = resource.data();
            }
         }
         try(FRs3TextureBitmapPack pack = new FRs3TextureBitmapPack()){
            if(count == 2){
               // Merge rgb + a
               pack.mergeRgba((byte[])itemDatas[0], (byte[])itemDatas[1]);
            }else if(count == 3){
               // Merge rgb + a
               pack.mergeRgba3((byte[])itemDatas[0], (byte[])itemDatas[1], (byte[])itemDatas[2]);
            }else{
               throw new FFatalError("Unserport mode");
            }
            data = pack.toArray();
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }else{
         String whereSql = "(" + FDataResource3dTextureBitmapLogic.TEXTURE_ID + "=" + textureId + ") AND (" + FDataResource3dTextureBitmapLogic.CODE + "='" + code + "')";
         FDataResource3dTextureBitmapLogic textureBitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
         FDataResource3dTextureBitmapUnit textureBitmapUnit = textureBitmapLogic.search(whereSql);
         if(textureBitmapUnit == null){
            throw new FFatalError("Texture bitmap is not exists. (code={1})", code);
         }
         FDataResourceBitmapImageUnit imageUnit = _bitmapConsole.findBitmapUnit(logicContext, textureBitmapUnit.bitmapId());
         formatCode = imageUnit.formatCode();
         SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, imageUnit.guid());
         data = resource.data();
      }
      // 获得数据
      //      String formatCode = imageUnit.formatCode();
      //      SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceBitmapImage, imageUnit.guid());
      //      byte[] data = resource.data();
      //      // 获得部分数据
      //      if(type != null){
      //         FImage image = new FImage(data);
      //         int x = 0;
      //         int y = 0;
      //         int height = image.height();
      //         switch(type){
      //            case "x1":
      //               x = 0;
      //               break;
      //            case "x2":
      //               x = height;
      //               break;
      //            case "y1":
      //               x = height * 2;
      //               break;
      //            case "y2":
      //               x = height * 3;
      //               break;
      //            case "z1":
      //               x = height * 4;
      //               break;
      //            case "z2":
      //               x = height * 5;
      //               break;
      //            default:
      //               throw new FFatalError("Unknown type. (type={1})", type);
      //         }
      //         synchronized(this){
      //            FImage dataImage = image.imageRectangle(x, y, height, height);
      //            data = dataImage.toBytes("jpg");
      //         }
      //      }
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
