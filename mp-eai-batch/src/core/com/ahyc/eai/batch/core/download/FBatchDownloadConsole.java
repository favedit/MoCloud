package com.ahyc.eai.batch.core.download;

import org.mo.com.console.FConsole;
import org.mo.com.io.RFile;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.eng.data.common.ISqlContext;

//============================================================
// <T>资源应用控制台。</T>
//============================================================
public class FBatchDownloadConsole
      extends FConsole
      implements
         IBatchDownloadConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FBatchDownloadConsole.class);

   // 存储服务
   @AProperty
   protected String _storageServer;

   // 存储路径
   @AProperty
   protected String _storagePath;

   // 现在线程
   protected FBatchDownloadThread _thread;

   // 数据控制台
   @ALink
   protected IDatabaseConsole _databaseConsole;

   //============================================================
   // <T>初始化处理。</T>
   //
   // @param applicationCode 应用代码
   // @param created 是否创建目录
   // @return 存储路径
   //============================================================
   public void initializeThread(){
      _thread = new FBatchDownloadThread();
      _thread.setConsole(this);
      _thread.start();
   }

   //============================================================
   // <T>生成存储文件名称。</T>
   //
   // @param name 名称
   // @return 存储文件名称
   //============================================================
   public String makeStorageFileName(String name){
      return RFile.makeFilename(_storagePath, name);
   }

   //============================================================
   // <T>处理下载。</T>
   //
   // @param connection 链接
   // @param unit 数据单元
   //============================================================
   //   public void processDownload(FLogicContext logicContext,
   //                               FDataBatchDownloadUnit unit){
   //      FDataBatchDownloadLogic downloadLogic = logicContext.findLogic(FDataBatchDownloadLogic.class);
   //
   //      if(unit.statusCd() == EGcBatchDownloadStatus.Prepare){
   //         // 更改设置
   //         String downloadUrl = unit.downloadUrl();
   //         String storageFile = unit.storageFile();
   //         String storageFileName = makeStorageFileName(storageFile);
   //         RFile.makeFileDirectory(storageFileName);
   //         unit.setStatusCd(EGcBatchDownloadStatus.Downloading);
   //         downloadLogic.doUpdate(unit, unit.ouid());
   //         // 下载处理
   //         try(FHttpConnection http = new FHttpConnection(downloadUrl)){
   //            http.fetch();
   //            http.response().saveFile(storageFileName);
   //            unit.setStatusCd(EGcBatchDownloadStatus.Finish);
   //         }catch(Exception e){
   //            unit.setStatusCd(EGcBatchDownloadStatus.Failure);
   //            _logger.error(this, "processDownload", e);
   //         }
   //         // 下载完成
   //         downloadLogic.doUpdate(unit, unit.ouid());
   //         //............................................................
   //         // 命令处理
   //         int storageActionCd = unit.storageActionCd();
   //         if(storageActionCd == EGcBatchStorageAction.ZipDecompress){
   //            boolean unzipResult = false;
   //            try{
   //               String decompressPath = RFile.makeDirectoryName(storageFileName);
   //               int count = RZip.decompress(storageFileName, decompressPath);
   //               unzipResult = count > 0;
   //               _logger.debug(this, "processDownload", "Unzip file success.(count={1}, file={2}, path={3})", count, storageFileName, decompressPath);
   //            }catch(Exception e){
   //               _logger.error(this, "processDownload", e);
   //            }
   //            unit.setStorageStatusCd(unzipResult ? EGcBatchStorageStatus.Success : EGcBatchStorageStatus.Failure);
   //            downloadLogic.doUpdate(unit, unit.ouid());
   //         }
   //      }
   //      _logger.debug(this, "processDownload", "Download url. (url={1})", unit.downloadUrl());
   //   }

   //============================================================
   // <T>后台处理。</T>
   //============================================================
   @Override
   public void process(){
      try(FLogicContext logicContext = new FLogicContext(_databaseConsole)){
         //         FDataBatchDownloadLogic downloadLogic = logicContext.findLogic(FDataBatchDownloadLogic.class);
         //         FLogicDataset<FDataBatchDownloadUnit> downloadUnits = downloadLogic.fetch(FDataBatchDownloadLogic.STATUS_CD + "=" + EGcBatchDownloadStatus.Prepare, 0, 0);
         //         for(FDataBatchDownloadUnit unit : downloadUnits){
         //            processDownload(logicContext, unit);
         //         }
      }catch(Exception e){
         _logger.error(this, "process", e);
      }finally{
      }
   }

   //============================================================
   // <T>下载处理。</T>
   //
   // @param sqlContext 数据环境
   // @param info 应用信息
   //============================================================
   @Override
   public void push(ISqlContext sqlContext,
                    long uid,
                    long lid,
                    String url){
   }
}
