package org.mo.cloud.core.storage;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.http.FHttpConnection;
import org.mo.com.net.http.RHttp;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>存储控制台。</T>
//============================================================
public class FGcStorageConsole
      implements
         IGcStorageConsole
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FGcStorageConsole.class);

   // 资源访问接口
   //private final static IResource _resource = RResource.find(FGcStorageConsole.class);

   // 使用标志
   @AProperty
   protected boolean _enable;

   // 上传地址
   @AProperty
   protected String _uploadUrl;

   // 访问地址
   @AProperty
   protected String _accessUrl;

   //   // 存储服务器
   //   @AProperty
   //   protected String _storageServer;
   //
   //   // 存储服务
   //   @AProperty
   //   protected String _storageService;
   //
   //   // 存储处理
   //   @AProperty
   //   protected String _storageServlet;
   //
   //   // 存储图片
   //   @AProperty
   //   protected String _storagePicture;
   //
   //   // 存储服务器
   //   @AProperty
   //   protected String _storageResource;
   //
   //   // 存储临时路径
   //   @AProperty
   //   protected String _storageTemp;
   //
   //   // 设置字典
   //   protected FDictionary<SGcStorageConfig> _configDictionary = new FDictionary<SGcStorageConfig>(SGcStorageConfig.class);
   //
   //   // 位图定义字典
   //   protected FDictionary<SGcStorageImages> _imagesDictionary = new FDictionary<SGcStorageImages>(SGcStorageImages.class);
   //
   //   // 绑定器
   //   @ALink
   //   protected IBindConsole _bindConsole;

   //   //============================================================
   //   // <T>获得服务器地址。</T>
   //   //
   //   // @return 服务器地址
   //   //============================================================
   //   @Override
   //   public String storageServer(){
   //      return _storageServer;
   //   }
   //
   //   //============================================================
   //   // <T>获得服务器资源地址。</T>
   //   //
   //   // @return 服务器资源地址
   //   //============================================================
   //   @Override
   //   public String storageResource(){
   //      return _storageResource;
   //   }
   //
   //   //============================================================
   //   // <T>获得存储临时路径。</T>
   //   //
   //   // @return 存储临时路径
   //   //============================================================
   //   @Override
   //   public String storageTemp(){
   //      return _storageTemp;
   //   }
   //
   //   //============================================================
   //   // <T>生成文本。</T>
   //   //
   //   // @param text 文本
   //   // @return 文本
   //   //============================================================
   //   @Override
   //   public String makeText(String text){
   //      if(RString.isEmpty(text)){
   //         return RString.EMPTY;
   //      }
   //      return RString.replace(text, _storageResource, RGcStorageUtility.StorageServer);
   //   }
   //
   //   //============================================================
   //   // <T>生成显示文本。</T>
   //   //
   //   // @param text 文本
   //   // @return 文本
   //   //============================================================
   //   @Override
   //   public String makeDisplay(String text){
   //      if(RString.isEmpty(text)){
   //         return RString.EMPTY;
   //      }
   //      return RString.replace(text, RGcStorageUtility.StorageServer, _storageResource);
   //   }
   //
   //   //============================================================
   //   // <T>生成网络地址。</T>
   //   //
   //   // @param uri 网络地址
   //   // @return 网络地址
   //   //============================================================
   //   @Override
   //   public String makeUrl(String uri){
   //      if(RString.isEmpty(uri)){
   //         return RString.EMPTY;
   //      }
   //      if(uri.contains("://")){
   //         return uri;
   //      }
   //      if(uri.contains(RGcStorageUtility.StorageServer)){
   //         return RString.replace(uri, RGcStorageUtility.StorageServer, _storageResource);
   //      }
   //      return _storageResource + uri;
   //   }
   //
   //   //============================================================
   //   // <T>生成图片网络图片地址。</T>
   //   //
   //   // @param deviceCd 设备类型
   //   // @param qualityCd 品质类型
   //   // @param displayCd 显示类型
   //   // @return 网络图片地址
   //   //============================================================
   //   @Override
   //   public String makePictureUrl(String typeName,
   //                                String subTypeName,
   //                                int displayCd,
   //                                String uri){
   //      //return makePictureUrl(typeName, subTypeName, EGcStorageDevice.Pc, EGcStorageQuality.All, displayCd, uri);
   //      return null;
   //   }
   //
   //   //============================================================
   //   // <T>生成图片网络图片地址。</T>
   //   //
   //   // @param deviceCd 设备类型
   //   // @param qualityCd 品质类型
   //   // @param deviceCd 设备类型
   //   // @param qualityCd 质量类型
   //   // @param displayCd 显示类型
   //   // @return 网络图片地址
   //   //============================================================
   //   @Override
   //   public String makePictureUrl(String typeName,
   //                                String subTypeName,
   //                                int deviceCd,
   //                                int qualityCd,
   //                                int displayCd,
   //                                String uri){
   //      // 检查参数
   //      if(RString.isEmpty(uri)){
   //         return EGcStorageResource.EmptyPicture;
   //      }
   //      // 生成地址
   //      if(uri.contains("://")){
   //         return uri;
   //      }
   //      // 获得会话信息
   //      FGcSessionInfo sessionInfo = _bindConsole.find(FGcSessionInfo.class);
   //      if(sessionInfo != null){
   //         deviceCd = sessionInfo.deviceCd();
   //         qualityCd = sessionInfo.qualityCd();
   //      }
   //      // 获得位图大小
   //      String code = typeName + "|" + subTypeName;
   //      SGcStorageImages images = _imagesDictionary.find(code);
   //      if(images != null){
   //         SGcStorageImage image = images.search(deviceCd, qualityCd, displayCd);
   //         if(image != null){
   //            String[] items = RString.splitLastTwo(uri, '.');
   //            if(items.length == 2){
   //               String url = _storageServer + "/ps/res" + items[0] + "_" + image.qualityCode() + "." + items[1];
   //               return url;
   //            }
   //         }
   //      }
   //      // 生成地址
   //      if(uri.contains(RGcStorageUtility.StorageServer)){
   //         return RString.replace(uri, RGcStorageUtility.StorageServer, _storageResource);
   //      }
   //      return _storageResource + uri;
   //   }
   //
   //   //============================================================
   //   // <T>生成类型网络相对地址。</T>
   //   //
   //   // @param type 网络地址
   //   // @param uri 网络地址
   //   // @return 网络地址
   //   //============================================================
   //   @Override
   //   public String makeTypeUri(String type,
   //                             String uri){
   //      return "/" + type + "/" + uri;
   //   }
   //
   //   //============================================================
   //   // <T>生成质量代码。</T>
   //   //
   //   // @param deviceCode 设备代码
   //   // @param width 文本
   //   // @param height 文本
   //   // @return 质量代码
   //   //============================================================
   //   @Override
   //   public String makeQualityCode(String deviceCode,
   //                                 int width,
   //                                 int height){
   //      // 获得品质代码
   //      String qualityCode = null;
   //      if("GcMobileIOS".equals(deviceCode)){
   //         qualityCode = "ios";
   //      }else if("GcMobileAndroid".equals(deviceCode)){
   //         qualityCode = "android";
   //      }else{
   //         qualityCode = "pc";
   //      }
   //      // 判断品质
   //      if(!"pc".equals(qualityCode)){
   //         if((width >= 1000) && (height >= 1800)){
   //            qualityCode += ".high";
   //         }else if((width >= 700) && (height >= 1000)){
   //            qualityCode += ".middle";
   //         }else{
   //            qualityCode += ".lower";
   //         }
   //      }
   //      return qualityCode;
   //   }
   //
   //   //============================================================
   //   // <T>注册一个存储设置。</T>
   //   //
   //   // @param config 存储设置
   //   //============================================================
   //   public void register(SGcStorageConfig config){
   //      String type = config.type();
   //      _configDictionary.set(type, config);
   //   }
   //
   //   //============================================================
   //   // <T>校验一个存储信息。</T>
   //   //
   //   // @param storage 存储信息
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public boolean check(SGcStorage storage){
   //      // 检查分类
   //      String catalog = storage.catalog();
   //      if(RString.isEmpty(catalog)){
   //         throw new FFatalError("Store catalog is empty.");
   //      }
   //      // 检查类型
   //      String type = storage.type();
   //      if(RString.isEmpty(type)){
   //         throw new FFatalError("Store type is empty.");
   //      }
   //      // 检查代码
   //      String code = storage.code();
   //      if(RString.isEmpty(code)){
   //         throw new FFatalError("Store code is empty.");
   //      }
   //      // 检查名称
   //      String name = storage.name();
   //      if(RString.isEmpty(name)){
   //         throw new FFatalError("Store name is empty.");
   //      }
   //      // 生成名称
   //      String extension = RFile.extension(name);
   //      String storeName = RUuid.makeUniqueId() + "_" + type;
   //      if(!RString.isEmpty(extension)){
   //         storeName += "." + extension;
   //      }
   //      // 获得位图设置
   //      String typeName = catalog + "|" + type;
   //      SGcStorageImages images = _imagesDictionary.find(typeName);
   //      if(images != null){
   //         storage.images().append(images);
   //      }
   //      //............................................................
   //      // 生成地址
   //      String urlFormat = "{1}?type={2}&code={3}&name={4}&orign={5}";
   //      String url = RString.format(urlFormat, _storageService, catalog, code, storeName, name);
   //      // 追加位图打包
   //      String imagePack = storage.images().pack();
   //      if(!RString.isEmpty(imagePack)){
   //         url += "&images=" + imagePack;
   //      }
   //      _logger.debug(this, "store", "Store url send. (url={1})", url);
   //      // 发送数据
   //      FXmlNode xresult = null;
   //      try(FXmlConnection connection = new FXmlConnection(url)){
   //         xresult = connection.process("check");
   //      }
   //      // 设置地址
   //      String resultCd = xresult.get("result_cd", "failure");
   //      if("success".equals(resultCd)){
   //         String uri = "/" + catalog + "/" + code + "/" + storeName;
   //         storage.setUri(uri);
   //         storage.setUrl(_storageResource + uri);
   //         return true;
   //      }
   //      return false;
   //   }

   //============================================================
   // <T>生成网络地址。</T>
   //
   // @param pack 打包字符串
   // @return 网络地址
   //============================================================
   @Override
   public String makeUrl(String pack){
      SGcStorage storage = new SGcStorage();
      storage.unpack(pack);
      return makeUrl(storage);
   }

   //============================================================
   // <T>生成网络地址。</T>
   //
   // @param storage 存储信息
   // @return 网络地址
   //============================================================
   @Override
   public String makeUrl(SGcStorage storage){
      String url = RHttp.makeUrl(_accessUrl, storage.catalog(), storage.date(), storage.code(), storage.name() + "." + storage.extension());
      return url;
   }

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   @Override
   public boolean store(SGcStorage storage){
      // 检查标志
      if(!_enable){
         _logger.debug(this, "store", "Store is not enable.");
         return true;
      }
      //............................................................
      // 检查分类
      String catalog = storage.catalog();
      if(RString.isEmpty(catalog)){
         throw new FFatalError("Store catalog is empty.");
      }
      //      // 检查类型
      //      String type = storage.type();
      //      if(RString.isEmpty(type)){
      //         throw new FFatalError("Store type is empty.");
      //      }
      // 检查日期
      String date = storage.date();
      if(RString.isEmpty(date)){
         throw new FFatalError("Store date is empty.");
      }
      // 检查代码
      String code = storage.code();
      if(RString.isEmpty(code)){
         throw new FFatalError("Store code is empty.");
      }
      // 检查名称
      String name = storage.name();
      if(RString.isEmpty(name)){
         throw new FFatalError("Store name is empty.");
      }
      // 检查扩展
      String extension = storage.extension();
      if(RString.isEmpty(extension)){
         throw new FFatalError("Store extension is empty.");
      }
      //      // 生成名称
      //      String extension = RFile.extension(name);
      //      String storeName = RUuid.makeUniqueId();
      //      if(!RString.isEmpty(extension)){
      //         storeName += "." + extension;
      //      }
      //      // 获得位图设置
      //      String typeName = catalog + "|" + type;
      //      SGcStorageImages images = _imagesDictionary.find(typeName);
      //      if(images != null){
      //         storage.images().append(images);
      //      }
      //............................................................
      // 检查数据
      byte[] data = storage.data();
      if(data == null){
         throw new FFatalError("Data is null.");
      }
      int size = data.length;
      if(size <= 0){
         throw new FFatalError("Data is empty.");
      }
      // 生成地址
      // String urlFormat = "{1}?catalog={2}&type={3}&code={4}&name={5}&size={6}";
      // String url = RString.format(urlFormat, _storageServlet, catalog, type, code, storeName, size);
      String urlFormat = "{1}?catalog={2}&date={3}&code={4}&name={5}&extension={6}&size={7}";
      String url = RString.format(urlFormat, _uploadUrl, catalog, date, code, name, extension, size);
      // 追加位图打包
      //            String imagePack = storage.images().pack();
      //            if(!RString.isEmpty(imagePack)){
      //               url += "&images=" + imagePack;
      //            }
      _logger.debug(this, "store", "Storage store send. (url={1})", url);
      // 发送数据
      try(FHttpConnection connection = new FHttpConnection(url)){
         connection.fetch(data);
      }
      _logger.debug(this, "store", "Storage store success. (url={1}, data_length={2})", url, size);
      // 设置地址
      //String uri = "/" + catalog + "/" + code + "/" + storeName;
      //storage.setUri(uri);
      //storage.setUrl(_storageResource + uri);
      //storage.setSourceLength(size);
      return true;
   }

   //   //============================================================
   //   // <T>保存一个存储信息。</T>
   //   //
   //   // @param storage 存储信息
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public boolean store(SGcStorage storage){
   //      // 检查标志
   //      if(!_enable){
   //         _logger.debug(this, "store", "Store is not enable.");
   //         return true;
   //      }
   //      //............................................................
   //      // 检查分类
   //      String catalog = storage.catalog();
   //      if(RString.isEmpty(catalog)){
   //         throw new FFatalError("Store catalog is empty.");
   //      }
   //      // 检查类型
   //      String type = storage.type();
   //      if(RString.isEmpty(type)){
   //         throw new FFatalError("Store type is empty.");
   //      }
   //      // 检查代码
   //      String code = storage.code();
   //      if(RString.isEmpty(code)){
   //         throw new FFatalError("Store code is empty.");
   //      }
   //      // 检查名称
   //      String name = storage.name();
   //      if(RString.isEmpty(name)){
   //         throw new FFatalError("Store name is empty.");
   //      }
   //      // 生成名称
   //      String extension = RFile.extension(name);
   //      String storeName = RUuid.makeUniqueId();
   //      if(!RString.isEmpty(extension)){
   //         storeName += "." + extension;
   //      }
   //      // 获得位图设置
   //      String typeName = catalog + "|" + type;
   //      SGcStorageImages images = _imagesDictionary.find(typeName);
   //      if(images != null){
   //         storage.images().append(images);
   //      }
   //      //............................................................
   //      // 检查数据
   //      String source = storage.source();
   //      try(FByteFile file = new FByteFile(source)){
   //         int size = file.length();
   //         if(size <= 0){
   //            _logger.warn(this, "storeType", "File size is invalid. (source={1})", source);
   //         }else{
   //            // 生成地址
   //            String urlFormat = "{1}?catalog={2}&type={3}&code={4}&name={5}&size={6}";
   //            String url = RString.format(urlFormat, _storageServlet, catalog, type, code, storeName, size);
   //            // 追加位图打包
   //            String imagePack = storage.images().pack();
   //            if(!RString.isEmpty(imagePack)){
   //               url += "&images=" + imagePack;
   //            }
   //            _logger.debug(this, "store", "Store url send. (url={1})", url);
   //            // 发送数据
   //            try(FHttpConnection connection = new FHttpConnection(url)){
   //               byte[] data = file.toArray();
   //               connection.fetch(data);
   //            }
   //            _logger.debug(this, "store", "Store url send finish. (url={1}, length={2})", url, file.length());
   //            // 设置地址
   //            String uri = "/" + catalog + "/" + code + "/" + storeName;
   //            storage.setUri(uri);
   //            storage.setUrl(_storageResource + uri);
   //            storage.setSourceLength(size);
   //            return true;
   //         }
   //      }catch(Exception e){
   //         _logger.error(this, "store", e);
   //      }
   //      return false;
   //   }

   //
   //   //============================================================
   //   // <T>删除一个存储信息。</T>
   //   //
   //   // @param storage 存储信息
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public boolean deleteFile(SGcStorage storage){
   //      // 检查分类
   //      String catalog = storage.catalog();
   //      if(RString.isEmpty(catalog)){
   //         throw new FFatalError("Store catalog is empty.");
   //      }
   //      // 检查类型
   //      String type = storage.type();
   //      if(RString.isEmpty(type)){
   //         throw new FFatalError("Store type is empty.");
   //      }
   //      // 检查代码
   //      String code = storage.code();
   //      if(RString.isEmpty(code)){
   //         throw new FFatalError("Store code is empty.");
   //      }
   //      // 检查名称
   //      String name = storage.name();
   //      if(RString.isEmpty(name)){
   //         throw new FFatalError("Store name is empty.");
   //      }
   //      // 生成地址
   //      String urlFormat = "{1}?catalog={2}&type={3}&code={4}&name={5}";
   //      String url = RString.format(urlFormat, _storageService, catalog, type, code, name);
   //      // 发送数据
   //      FXmlNode xresult = null;
   //      try(FXmlConnection connection = new FXmlConnection(url)){
   //         xresult = connection.process("deleteFiles");
   //      }
   //      // 设置地址
   //      String resultCd = xresult.get("result_cd", "failure");
   //      if("success".equals(resultCd)){
   //         return true;
   //      }
   //      return false;
   //   }
   //
   //   //============================================================
   //   // <T>删除一个存储目录。</T>
   //   //
   //   // @param storage 存储信息
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public boolean deleteDirectory(SGcStorage storage){
   //      // 检查分类
   //      String catalog = storage.catalog();
   //      if(RString.isEmpty(catalog)){
   //         throw new FFatalError("Store catalog is empty.");
   //      }
   //      // 检查类型
   //      String type = storage.type();
   //      if(RString.isEmpty(type)){
   //         throw new FFatalError("Store type is empty.");
   //      }
   //      // 检查代码
   //      String code = storage.code();
   //      if(RString.isEmpty(code)){
   //         throw new FFatalError("Store code is empty.");
   //      }
   //      // 生成地址
   //      String urlFormat = "{1}?catalog={2}&type={3}&code={4}";
   //      String url = RString.format(urlFormat, _storageService, catalog, type, code);
   //      // 发送数据
   //      FXmlNode xresult = null;
   //      try(FXmlConnection connection = new FXmlConnection(url)){
   //         xresult = connection.process("deleteDirectory");
   //      }
   //      // 设置地址
   //      String resultCd = xresult.get("result_cd", "failure");
   //      if("success".equals(resultCd)){
   //         return true;
   //      }
   //      return false;
   //   }

   //============================================================
   // <T>初始化内容。</T>
   //============================================================
   public void initialize(){
      //      FXmlNode xconfig = _resource.config();
      //      for(FXmlNode xnode : xconfig.nodes()){
      //         if(xnode.isName("ImageProcess")){
      //            String name = xnode.get("name");
      //            SGcStorageImages images = new SGcStorageImages();
      //            for(FXmlNode ximage : xnode.nodes()){
      //               SGcStorageImage image = new SGcStorageImage();
      //               image.loadConfig(ximage);
      //               images.push(image);
      //            }
      //            _imagesDictionary.set(name, images);
      //         }
      //      }
   }

   //============================================================
   // <T>获得运行信息。</T>
   //
   // @return 运行信息
   //============================================================
   //   public String dump(){
   //      FString dump = new FString();
   //      dump.appendLine("Count:" + _imagesDictionary.count());
   //      for(INamePair<SGcStorageImages> pair : _imagesDictionary){
   //         dump.appendLine("name=" + pair.name());
   //         dump.appendLine(pair.value().dump());
   //      }
   //      return dump.toString();
   //   }
}
