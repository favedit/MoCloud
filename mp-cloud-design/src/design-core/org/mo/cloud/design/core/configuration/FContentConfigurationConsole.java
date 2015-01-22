package org.mo.cloud.design.core.configuration;

import org.mo.com.console.FConsole;
import org.mo.com.io.RDirectory;
import org.mo.com.io.RFile;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内容配置控制台。</T>
//============================================================
public class FContentConfigurationConsole
      extends FConsole
      implements
         IContentConfigurationConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FContentConfigurationConsole.class);

   // 配置路径
   @AProperty
   protected String _configPath;

   // 内容存储字典
   protected FDictionary<FContentStorage> _storages = new FDictionary<FContentStorage>(FContentStorage.class);

   //============================================================
   // <T>获得内容存储字典。</T>
   //
   // @return 内容存储字典
   //============================================================
   @Override
   public FDictionary<FContentStorage> storages(){
      return _storages;
   }

   //============================================================
   // <T>根据存储名称查找内容存储。</T>
   //
   // @param storageName 存储名称
   // @return 内容存储
   //============================================================
   @Override
   public FContentStorage findStorage(String storageName){
      FContentStorage storage = _storages.find(storageName);
      if(storage != null){
         storage.open();
      }
      return storage;
   }

   //============================================================
   // <T>根据存储名称获得内容存储。</T>
   //
   // @param storageName 存储名称
   // @return 内容存储
   //============================================================
   @Override
   public FContentStorage getStorage(String storageName){
      FContentStorage storage = findStorage(storageName);
      if(storage == null){
         throw new FFatalError("Can't find content space. (storage={1})", storageName);
      }
      return storage;
   }

   //============================================================
   // <T>根据空间名称查找内容空间。</T>
   //
   // @param storageName 存储名称
   // @param spaceName 空间名称
   // @return 内容空间
   //============================================================
   @Override
   public FContentSpace findSpace(String storageName,
                                  String spaceName){
      FContentStorage storage = findStorage(storageName);
      if(storage == null){
         return null;
      }
      FContentSpace space = storage.find(spaceName);
      if(space != null){
         //_persistenceConsole.find(nodeName)
         space.open();
      }
      return space;
   }

   //============================================================
   // <T>根据空间名称获得内容空间。</T>
   //
   // @param storageName 存储名称
   // @param spaceName 空间名称
   // @return 内容空间
   //============================================================
   @Override
   public FContentSpace getSpace(String storageName,
                                 String spaceName){
      FContentSpace space = findSpace(storageName, spaceName);
      if(space == null){
         throw new FFatalError("Can't find content space. (storage={1}, space={2})", storageName, spaceName);
      }
      return space;
   }

   //============================================================
   // <T>根据空间名称和节点名称查找内容节点。</T>
   //
   // @param storageName 存储名称
   // @param spaceName 空间名称
   // @param nodeName 节点名称
   // @return 内容节点
   //============================================================
   @Override
   public FContentNode findNode(String storageName,
                                String spaceName,
                                String nodeName){
      FContentSpace space = findSpace(storageName, spaceName);
      if(space == null){
         return null;
      }
      return space.find(nodeName);
   }

   //============================================================
   // <T>根据空间名称和节点名称查找内容节点。</T>
   //
   // @param storageName 存储名称
   // @param spaceName 空间名称
   // @param nodeName 节点名称
   // @return 内容节点
   //============================================================
   @Override
   public FContentNode getNode(String storageName,
                               String spaceName,
                               String nodeName){
      FContentNode node = findNode(storageName, spaceName, nodeName);
      if(node == null){
         throw new FFatalError("Can't find content node. (storage={1}, space={2}, node={3})", storageName, spaceName, nodeName);
      }
      return node;
   }

   //============================================================
   // <T>初始化配置。</T>
   //============================================================
   public void initializeConfig(){
      String configPath = RFile.format(_configPath);
      for(String name : RDirectory.listDirectory(configPath)){
         FContentStorage storage = new FContentStorage();
         storage.setName(name);
         storage.setFilePath(RFile.makePathname(configPath, name));
         _storages.set(name, storage);
         _logger.debug(this, "initializeConfig", "Create content storage. (name={1})", name);
      }
   }

   //============================================================
   // <T>初始化监视器。</T>
   //============================================================
   public void initializeMonitor(){
   }

   //============================================================
   // <T>根据空间名称和节点名称获得内容类对象。</T>
   //
   // @param storageName 存储名称
   // @param spaceName 空间名称
   // @param nodeName 节点名称
   // @param typeName 类型名称
   // @return 内容节点
   //============================================================
   @Override
   public FContentClass getContentClass(String storageName,
                                        String spaceName,
                                        String nodeName,
                                        String typeName){
      return new FContentClass();
   }
}
