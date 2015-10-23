package org.mo.content.resource;

import org.mo.cloud.core.storage.mongo.EGcStorageMongoCatalog;
import org.mo.cloud.core.storage.mongo.IGcStorageMongoConsole;

import org.mo.com.logging.RLogger;
import org.mo.content.common.RRs3Configuration;
import org.mo.core.aop.RAop;

public class RMongoDropCache
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void process() throws Exception{
      IGcStorageMongoConsole console = RAop.find(IGcStorageMongoConsole.class);
      // 删除缓冲
      console.drop(EGcStorageMongoCatalog.CacheBitmapPreview);
      console.drop(EGcStorageMongoCatalog.CacheMaterialPreview);
      console.drop(EGcStorageMongoCatalog.CacheResourceMaterialBitmapPack);
      console.drop(EGcStorageMongoCatalog.CacheResourceMesh);
      console.drop(EGcStorageMongoCatalog.CacheResourceModel);
      console.drop(EGcStorageMongoCatalog.CacheResourceTemplate);
      console.drop(EGcStorageMongoCatalog.CacheResourceScene);
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = RRs3Configuration.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-content/src/config/" + RRs3Configuration.Config);
      try{
         process();
      }catch(Exception e){
         RLogger.find(RMongoDropCache.class).error(null, "main", e);
      }
      RAop.release();
   }
}
