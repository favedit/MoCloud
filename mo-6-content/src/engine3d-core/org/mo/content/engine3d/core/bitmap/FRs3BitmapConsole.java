package org.mo.content.engine3d.core.bitmap;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapConsole;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlDocument;
import org.mo.content.resource3d.texture.FRs3Texture;
import org.mo.content.resource3d.texture.FRs3TextureBitmap;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.image.FImage;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3BitmapConsole
      extends FGcResBitmapConsole
      implements
         IRs3BitmapConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FRs3BitmapConsole.class);

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param bitmapInfo 位图信息
   // @param bitmap 位图
   // @return 处理结果
   //============================================================
   @Override
   public EResult updateResource(ILogicContext logicContext,
                                 FGcResBitmapInfo bitmapInfo,
                                 FImage bitmap){
      // 获得信息
      String guid = bitmapInfo.guid();
      // 设置数据
      bitmapInfo.setSizeWidth(bitmap.width());
      bitmapInfo.setSizeHeight(bitmap.height());
      doUpdate(logicContext, bitmapInfo);
      // 存储数据
      SGcStorage resource = new SGcStorage(EGcStorageCatalog.ResourceBitmap, guid);
      resource.setData(bitmap.toBytes("jpeg"));
      _storageConsole.store(resource);
      return EResult.Success;
   }

   //============================================================
   // <T>导入资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param path 路径
   // @return 处理结果
   //============================================================
   @Override
   public EResult importResource(ILogicContext logicContext,
                                 FGcSessionInfo session,
                                 String path){
      long userId = session.userId();
      path = RFile.format(path);
      //............................................................
      // 导入配置信息
      FRs3Texture texture = new FRs3Texture();
      String configFile = RFile.makeFilename(path, "config.xml");
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadFile(configFile);
      texture.importConfig(xdocument.root());
      String textureCode = texture.code();
      String textureLabel = texture.label();
      String textureKeywords = texture.keywords();
      //............................................................
      for(FRs3TextureBitmap bitmap : texture.bitmaps()){
         // 检查文件
         String bitmapCode = bitmap.code();
         String fileExtension = "jpg";
         String bitmapFile = RFile.makeFilename(path, bitmapCode + "." + fileExtension);
         if(!RFile.exists(bitmapFile)){
            throw new FFatalError("Bitmap file is not exists. (file_name={1})", bitmapFile);
         }
         String fullCode = textureCode + "|" + bitmapCode;
         // 新建位图
         FGcResBitmapInfo bitmapInfo = findByUserFullCode(logicContext, userId, fullCode);
         boolean exists = (bitmapInfo != null);
         if(!exists){
            bitmapInfo = doPrepare(logicContext);
            bitmapInfo.setUserId(userId);
            bitmapInfo.setProjectId(session.projectId());
            bitmapInfo.setFullCode(textureCode + "|" + bitmapCode);
         }
         bitmapInfo.setCode(bitmapCode);
         bitmapInfo.setLabel(textureLabel);
         bitmapInfo.setKeywords(textureKeywords);
         bitmapInfo.setFormatCode(fileExtension);
         if(exists){
            doUpdate(logicContext, bitmapInfo);
         }else{
            doInsert(logicContext, bitmapInfo);
         }
         // 上传位图数据
         FImage image = new FImage();
         try{
            image.loadFile(bitmapFile);
            this.updateResource(logicContext, bitmapInfo, image);
         }catch(Exception e){
            throw new FFatalError(e);
         }finally{
            try{
               image.close();
            }catch(Exception e){
               throw new FFatalError(e);
            }
         }
      }
      _logger.debug(this, "importResource", "Import bitmap success. (path={1})", path);
      return EResult.Success;
   }
}
