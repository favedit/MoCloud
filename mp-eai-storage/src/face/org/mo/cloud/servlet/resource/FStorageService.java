package org.mo.cloud.servlet.resource;

import org.mo.cloud.core.storage.ICloudStorageConsole;

import org.mo.cloud.core.storage.SGcStorageImages;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源存储服务接口。</T>
//============================================================
public class FStorageService
      extends FObject
      implements
         IStorageService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStorageService.class);

   // 存储后缀
   public static String StoreFix = ".store";

   // 会话控制台
   //   @ALink
   //   protected IGcSessionConsole _sessionConsole;

   // 应用控制台
   //   @ALink
   //   protected IApplicationConsole _applicationConsole;

   // 应用服务接口
   @ALink
   protected ICloudStorageConsole _storageConsole;

   // 图片服务接口
   //   @ALink
   //   protected IGcPictureConsole _pictureConsole;

   //============================================================
   // <T>资源应用查询处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        ISqlContext sqlContext,
                        IWebInput input,
                        IWebOutput output){
      // 获得参数
      //      FXmlNode xinput = input.config();
      //      String sessionCode = xinput.nodeText("SessionCode");
      //      int resourceCd = xinput.nodeTextAsInt("ResourceCd");
      //      //String resourceCdName = EGcResource.format(resourceCd);
      //      String resourceCode = xinput.nodeText("ResourceCode");
      //      String resourceName = xinput.nodeText("ResourceName");
      //      //String resourceVersion = xinput.nodeText("ResourceVersion");
      //      // 打开会话
      //      FGcSessionInfo sessionInfo = _sessionConsole.findByCode(sqlContext, sessionCode);
      //      if(sessionInfo == null){
      //         context.messages().push(new FErrorMessage("Session is not exists. (session_code={1})", sessionCode));
      //         return EResult.Failure;
      //      }
      //      // 查找应用
      //      if(resourceCd == EGcResource.Application){
      //         FApplicationInfo applicationInfo = _applicationConsole.findByCode(sqlContext, resourceCode);
      //         if(applicationInfo == null){
      //            context.messages().push(new FErrorMessage("Application is not exists. (code={1})", resourceCode));
      //            return EResult.Failure;
      //         }
      //      }
      //      // 获得文件大小
      //      String storePath = _applicationConsole.makeStorePath(resourceCode, false);
      //      String fileName = storePath + "/" + resourceName;
      //      String fileStoreName = storePath + "/" + resourceName + StoreFix;
      //      long fileSize = 0;
      //      String statusCd = "Success";
      //      if(RFile.exists(fileStoreName)){
      //         FStringFile file = new FStringFile(fileStoreName);
      //         String fileLength = file.toString();
      //         fileSize = RLong.parse(fileLength);
      //         statusCd = "Continue";
      //      }else if(RFile.exists(fileName)){
      //         fileSize = new File(fileName).length();
      //      }else{
      //         statusCd = "None";
      //      }
      //      _logger.debug(this, "query", "Query file info. (length={1})", fileSize);
      //      // 设置返回内容
      //      FXmlNode applicationNode = output.config().createNode("Application");
      //      applicationNode.set("status_cd", statusCd);
      //      applicationNode.set("position", fileSize);
      return EResult.Success;
   }

   //============================================================
   // <T>资源应用检查处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult check(IWebContext context,
                        ISqlContext sqlContext,
                        IWebInput input,
                        IWebOutput output){
      // 获得参数
      FXmlNode xinput = input.config();
      String catalog = xinput.nodeText("catalog");
      if(RString.isEmpty(catalog)){
         throw new FFatalError("Check catalog is empty.", catalog);
      }
      String type = xinput.nodeText("type");
      if(RString.isEmpty(type)){
         throw new FFatalError("Check type is empty.", catalog);
      }
      String code = xinput.nodeText("code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Check code is empty.", catalog);
      }
      String name = xinput.nodeText("name");
      if(RString.isEmpty(name)){
         throw new FFatalError("Check name is empty.", catalog);
      }
      String orign = xinput.nodeText("orign");
      if(RString.isEmpty(orign)){
         throw new FFatalError("Check orign is empty.", catalog);
      }
      // 获得位图集合
      SGcStorageImages images = new SGcStorageImages();
      String imagesPack = xinput.nodeText("images");
      if(!RString.isEmpty(imagesPack)){
         images.unpack(imagesPack);
      }
      //............................................................
      // 建立图片集合
      String storageFileName = _storageConsole.makeStoreFileName(type, code, name);
      String orignFileName = _storageConsole.makeFileName(orign);
      _logger.debug(this, "check", "Check storage file. (storage={1}, orign={2}, images={3})", storageFileName, orignFileName, images.count());
      // 检查原始文件
      if(RFile.exists(orignFileName)){
         // 复制文件数据
         RFile.copyFile(orignFileName, storageFileName);
      }
      // 建立位图
      if(!images.isEmpty()){
         String fileName = null;
         if(RFile.exists(orignFileName)){
            fileName = orignFileName;
         }
         if(RFile.exists(storageFileName)){
            fileName = storageFileName;
         }
         if(fileName != null){
            //            _pictureConsole.buildImages(type, fileName, images);
            //            return EResult.Success;
         }
      }
      return EResult.Failure;
   }

   //============================================================
   // <T>删除文件处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult deleteFile(IWebContext context,
                             ISqlContext sqlContext,
                             IWebInput input,
                             IWebOutput output){
      // 检查分类
      String catalog = context.parameter("catalog");
      if(RString.isEmpty(catalog)){
         throw new FFatalError("Store catalog is empty.");
      }
      // 检查类型
      String type = context.parameter("type");
      if(RString.isEmpty(type)){
         throw new FFatalError("Store type is empty.");
      }
      // 检查代码
      String code = context.parameter("code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Store code is empty.");
      }
      // 检查名称
      String name = context.parameter("name");
      if(RString.isEmpty(name)){
         throw new FFatalError("Store name is empty.");
      }
      //............................................................
      // 删除命令
      String itemCode = RFile.shortName(name);
      String fullPath = _storageConsole.makeStoreFileName(catalog, code, itemCode);
      if(_storageConsole.deleteFile(type, code, fullPath)){
         return EResult.Success;
      }
      return EResult.Failure;
   }

   //============================================================
   // <T>删除文件集合。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult deleteFiles(IWebContext context,
                              ISqlContext sqlContext,
                              IWebInput input,
                              IWebOutput output){
      // 检查分类
      String catalog = context.parameter("catalog");
      if(RString.isEmpty(catalog)){
         throw new FFatalError("Store catalog is empty.");
      }
      // 检查类型
      String type = context.parameter("type");
      if(RString.isEmpty(type)){
         throw new FFatalError("Store type is empty.");
      }
      // 检查代码
      String code = context.parameter("code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Store code is empty.");
      }
      // 检查名称
      String name = context.parameter("name");
      if(RString.isEmpty(name)){
         throw new FFatalError("Store name is empty.");
      }
      //............................................................
      // 删除命令
      String itemCode = RFile.shortName(name);
      String fullPath = _storageConsole.makeStoreFileName(catalog, code, itemCode);
      if(_storageConsole.deleteFiles(type, code, fullPath)){
         return EResult.Success;
      }
      return EResult.Failure;
   }

   //============================================================
   // <T>删除目录处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult deleteDirectory(IWebContext context,
                                  ISqlContext sqlContext,
                                  IWebInput input,
                                  IWebOutput output){
      // 检查分类
      String catalog = context.parameter("catalog");
      if(RString.isEmpty(catalog)){
         throw new FFatalError("Store catalog is empty.");
      }
      // 检查代码
      String code = context.parameter("code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Store code is empty.");
      }
      //............................................................
      // 删除命令
      if(_storageConsole.deleteDirectory(catalog, code)){
         return EResult.Success;
      }
      return EResult.Failure;
   }
}
