package org.mo.cloud.core.storage;

import org.mo.com.io.FByteFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.http.FHttpConnection;
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

   // 存储路径
   @AProperty
   protected String _storagePath;

   // 存储服务器
   @AProperty
   protected String _storageServer;

   // 存储处理
   @AProperty
   protected String _storageServlet;

   // 存储服务器
   @AProperty
   protected String _storageResource;

   //============================================================
   // <T>生成存储文件名称。</T>
   //
   // @param catalog 目录
   // @param date 日期
   // @param code 代码
   // @param version 版本
   // @param type 类型
   // @return 文件名称
   //============================================================
   @Override
   public String makeFileName(String catalog,
                              String date,
                              String code,
                              String version,
                              String type){
      String typeName = RString.nvl(type, "bin");
      String storeName = "/" + catalog + "/" + date + "/" + code + "/" + version + "." + typeName;
      return RFile.makeFilename(_storagePath, storeName);
   }

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   @Override
   public boolean store(SGcStorage storage){
      // 检查分类
      String catalog = storage.catalog();
      if(RString.isEmpty(catalog)){
         throw new FFatalError("Store catalog is empty.");
      }
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
      // 检查版本
      String version = storage.version();
      if(RString.isEmpty(version)){
         throw new FFatalError("Store version is empty.");
      }
      // 检查类型
      String type = RString.nvl(storage.type(), "bin");
      // 生成名称
      String storeName = "/" + catalog + "/" + date + "/" + code + "/" + version + "." + type;
      //............................................................
      // 获得数据
      byte[] data = null;
      String source = storage.source();
      if(!RString.isEmpty(source)){
         try(FByteFile file = new FByteFile(source)){
            int size = file.length();
            if(size <= 0){
               _logger.warn(this, "store", "File size is invalid. (source={1})", source);
               return false;
            }else{
               data = file.toArray();
            }
         }catch(Exception e){
            _logger.error(this, "store", e);
         }
      }
      if(data == null){
         data = storage.data();
      }
      //............................................................
      // 上传数据
      if(data != null){
         try{
            int size = data.length;
            if(size <= 0){
               _logger.warn(this, "store", "Data size is invalid. (size={1})", size);
            }else{
               // 生成地址
               String urlFormat = "{1}?catalog={2}&date={3}&code={4}&version={5}&type={6}&size={7}";
               String url = RString.format(urlFormat, _storageServlet, catalog, date, code, version, type, size);
               _logger.debug(this, "store", "Store url send. (url={1})", url);
               // 发送数据
               try(FHttpConnection connection = new FHttpConnection(url)){
                  connection.fetch(data);
               }
               _logger.debug(this, "store", "Store url send finish. (url={1})", url);
               // 设置地址
               storage.setUri(storeName);
               storage.setUrl(_storageResource + storeName);
               return true;
            }
         }catch(Exception e){
            _logger.error(this, "store", e);
         }
      }else{
         throw new FFatalError("Data is null.");
      }
      return false;
   }
}
