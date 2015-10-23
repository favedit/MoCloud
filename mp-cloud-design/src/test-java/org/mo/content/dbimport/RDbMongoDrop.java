package org.mo.content.dbimport;

import org.mo.cloud.core.storage.mongo.EGcStorageMongoCatalog;
import org.mo.cloud.core.storage.mongo.IGcStorageMongoConsole;

import org.mo.com.logging.RLogger;
import org.mo.content.common.RRs3Configuration;
import org.mo.core.aop.RAop;

public class RDbMongoDrop
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void process() throws Exception{
      // 导入处理
      IGcStorageMongoConsole console = RAop.find(IGcStorageMongoConsole.class);
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
      RAop.initialize(configPath + "/mp-cloud-design/src/config/" + RRs3Configuration.Config);
      try{
         process();
      }catch(Exception e){
         RLogger.find(RDbMongoDrop.class).error(null, "main", e);
      }
      RAop.release();
   }
}
