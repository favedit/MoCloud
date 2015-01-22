package com.cyou.gccloud.core.download;

import com.cyou.gccloud.core.storage.EGcStorageCatalog;
import com.cyou.gccloud.data.data.FDataBatchDownloadLogic;
import com.cyou.gccloud.data.data.FDataBatchDownloadUnit;
import com.cyou.gccloud.define.enums.core.EGcBatchDownloadStatus;
import com.cyou.gccloud.define.enums.core.EGcBatchDownloadType;
import com.cyou.gccloud.define.enums.core.EGcBatchStorageAction;
import com.cyou.gccloud.define.enums.core.EGcBatchStorageStatus;
import org.mo.com.io.RFile;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>存储控制台。</T>
//============================================================
public class FDownloadConsole
      implements
         IDownloadConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FDownloadConsole.class);

   // 存储服务器
   @AProperty
   protected String _storageServer;

   // 存储服务器
   @AProperty
   protected String _storagePath;

   //============================================================
   // <T>获得服务器地址。</T>
   //
   // @return 服务器地址
   //============================================================
   public String storageServer(){
      return _storageServer;
   }

   //============================================================
   // <T>获得服务器地址。</T>
   //
   // @return 服务器地址
   //============================================================
   public String storagePath(){
      return _storagePath;
   }

   //============================================================
   // <T>生成存储文件名称。</T>
   //
   // @param name 名称
   // @return 存储文件名称
   //============================================================
   @Override
   public String makeTypeName(int typeCd){
      switch(typeCd){
         case EGcBatchDownloadType.Game:
            return EGcStorageCatalog.ExternalGamemeiGame;
         default:
            throw new FFatalError("Unknown type. (type_cd={1})", typeCd);
      }
   }

   //============================================================
   // <T>下载一个ZIP文件。</T>
   //
   // @param logicContext 逻辑环境
   // @param typeCd 类型
   // @param userId 用户编号
   // @param linkId 关联编号
   // @param downloadUrl 下载地址
   // @param storageFile 存储文件
   //============================================================
   @Override
   public void downloadZip(ILogicContext logicContext,
                           int typeCd,
                           long userId,
                           long linkId,
                           String downloadUrl,
                           String storageFile){
      String storageFileName = RFile.makeFilename(_storagePath, storageFile);
      String typeName = makeTypeName(typeCd);
      // 新建记录
      FDataBatchDownloadLogic logic = logicContext.findLogic(FDataBatchDownloadLogic.class);
      FDataBatchDownloadUnit unit = logic.doPrepare();
      unit.setTypeCd(typeCd);
      unit.setUserId(userId);
      unit.setLinkId(linkId);
      unit.setStatusCd(EGcBatchDownloadStatus.Prepare);
      unit.setDownloadUrl(downloadUrl);
      unit.setStorageUri("/" + typeName + "/" + storageFile);
      unit.setStorageFile("/" + typeName + "/" + storageFileName);
      unit.setStorageActionCd(EGcBatchStorageAction.ZipDecompress);
      unit.setStorageStatusCd(EGcBatchStorageStatus.Unknown);
      logic.doInsert(unit);
      _logger.debug(this, "downloadZip", "Download url. (url={1})", downloadUrl);
   }
}
