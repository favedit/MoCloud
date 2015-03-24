package org.mo.cloud.core.storage;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import org.mo.com.console.FConsole;
import org.mo.com.io.FByteFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>存储控制台。</T>
//============================================================
public class FGcStorageConsole
      extends FConsole
      implements
         IGcStorageConsole
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FGcStorageConsole.class);

   // 允许标志
   @AProperty
   protected boolean _enable;

   // 存储主机
   @AProperty
   protected String _storageHost;

   // 存储端口
   @AProperty
   protected int _storagePort;

   // 存储名称
   @AProperty
   protected String _storageName;

   // 存储名称
   @AProperty
   protected String _storagePath = "E:/Microbject/storage";

   // 数据库链接
   protected Mongo _connection;

   // 数据库
   protected DB _database;

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param catalog 集合分类
   // @param guid 唯一编号
   // @return 查找结果
   //============================================================
   @Override
   public SGcStorage find(String catalog,
                          String guid){
      // 获得集合
      DBCollection collection = _database.getCollection(catalog);
      // 查找内容
      DBObject search = new BasicDBObject("guid", guid);
      // 更新处理
      DBObject item = collection.findOne(search);
      if(item == null){
         return null;
      }
      byte[] data = (byte[])item.get("data");
      if(data == null){
         String fileName = _storagePath + "/" + catalog + "/" + guid + ".bin";
         if(RFile.exists(fileName)){
            FByteFile storgeFile = new FByteFile(fileName);
            storgeFile.loadFile(fileName);
            data = storgeFile.toArray();
            storgeFile.close();
         }
      }
      // 返回内容
      SGcStorage resource = new SGcStorage();
      resource.setData(data);
      return resource;
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
      // 检查唯一编号
      String guid = storage.guid();
      if(RString.isEmpty(guid)){
         throw new FFatalError("Store code is empty.");
      }
      // 检查类型
      String type = RString.nvl(storage.type(), "bin");
      //............................................................
      // 获得数据
      byte[] data = null;
      String dataSource = storage.dataSource();
      if(!RString.isEmpty(dataSource)){
         try(FByteFile file = new FByteFile(dataSource)){
            int size = file.length();
            if(size <= 0){
               _logger.warn(this, "store", "File size is invalid. (source={1})", dataSource);
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
      if(data == null){
         throw new FFatalError("Resource data is empty.");
      }
      //............................................................
      // 压缩数据
      //FLzmaFile file = new FLzmaFile(data);
      //byte[] lzmaData = file.toLzmaArray();
      //............................................................
      // 获得集合
      DBCollection collection = _database.getCollection(catalog);
      // 新建数据
      DBObject item = new BasicDBObject();
      item.put("guid", guid);
      item.put("code", storage.code());
      item.put("type", type);
      //item.put("compress", "lzma");
      item.put("data_length", data.length);
      //item.put("compress_length", lzmaData.length);
      // 检查数据限制
      if(data.length > RInteger.SIZE_4M){
         _logger.error(this, "store", "Storage document is too large. (size={1}, limit={2})", data.length, RInteger.SIZE_16M);
         FByteFile storgeFile = new FByteFile(data);
         storgeFile.saveToFile(_storagePath + "/" + catalog + "/" + guid + ".bin");
         storgeFile.close();
         item.put("data", null);
      }else{
         item.put("data", data);
      }
      // 查找内容
      DBObject search = new BasicDBObject("guid", guid);
      // 更新处理
      collection.update(search, item, true, false);
      //file.close();
      return true;
   }

   //============================================================
   // <T>删除一个存储信息。</T>
   //
   // @param catalog 集合分类
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   @Override
   public boolean delete(String catalog,
                         String guid){
      // 检查参数
      if(RString.isEmpty(catalog)){
         throw new FFatalError("Parameter catalog is empty.");
      }
      if(RString.isEmpty(guid)){
         throw new FFatalError("Parameter guid is empty.");
      }
      //............................................................
      // 获得集合
      DBCollection collection = _database.getCollection(catalog);
      // 查找内容
      DBObject search = new BasicDBObject("guid", guid);
      // 更新处理
      DBObject find = collection.findOne(search);
      if(find != null){
         collection.remove(find);
         return true;
      }
      return false;
   }

   //============================================================
   // <T>删除一个存储集合。</T>
   //
   // @param catalog 集合分类
   // @return 处理结果
   //============================================================
   @Override
   public boolean drop(String catalog){
      // 检查参数
      if(RString.isEmpty(catalog)){
         throw new FFatalError("Parameter catalog is empty.");
      }
      //............................................................
      // 删除集合
      if(_database.collectionExists(catalog)){
         DBCollection collection = _database.getCollection(catalog);
         collection.drop();
         _logger.debug(this, "drop", "Drop data collection. (name={1})", catalog);
         return true;
      }else{
         _logger.debug(this, "drop", "Data collection is not exists. (name={1})", catalog);
         return false;
      }
   }

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult exportFile(String catalog,
                             String guid,
                             String path){
      // 获得集合
      DBCollection collection = _database.getCollection(catalog);
      // 查找内容
      DBObject search = new BasicDBObject("guid", guid);
      // 获得数据
      DBObject item = collection.findOne(search);
      String type = (String)item.get("type");
      byte[] data = (byte[])item.get("data");
      // 存储内容
      String fileName = path + "/" + guid + "." + type;
      try(FByteFile file = new FByteFile()){
         file.assign(data, 0, data.length);
         file.saveToFile(fileName);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult importFile(String catalog,
                             String guid,
                             String type,
                             String fileName){
      // 获得集合
      DBCollection collection = _database.getCollection(catalog);
      // 查找内容
      DBObject search = new BasicDBObject("guid", guid);
      // 存储内容
      try(FByteFile file = new FByteFile(fileName)){
         // 新建数据
         DBObject item = new BasicDBObject();
         item.put("guid", guid);
         item.put("type", type);
         item.put("data", file.toArray());
         // 更新处理
         collection.update(search, item, true, false);
      }
      return EResult.Success;
   }

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
   public void initialize(){
      try{
         _connection = new Mongo(_storageHost, _storagePort);
         _database = _connection.getDB(_storageName);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }
}
