package org.mo.cloud.test;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RUuid;
import org.mo.core.aop.RAop;

//============================================================
// <T>存储工具类。</T>
//============================================================
public class RGcStorageUtility
{
   // 服务器定义
   public final static String StorageServer = "${storage.server}";

   public static void main(String[] args){
      // 设置属性
      FAttributes attributes = RAop.configConsole().defineCollection().attributes();
      attributes.set("application", "D:/Microbject/MoCloud");
      RAop.initialize("D:/Microbject/MoCloud/mp-eai-manage/webroot/WEB-INF/classes/application-work.xml");
      IGcStorageConsole storageConsole = RAop.find(IGcStorageConsole.class);
      SGcStorage storage = new SGcStorage();
      storage.setCatalog("eai.images");
      storage.setDate(RDateTime.format("YYMMDD"));
      storage.setCode(RUuid.makeUniqueIdLower());
      storage.setName(RUuid.makeUniqueIdLower());
      storage.loadFile("D:/picture-03.jpg");
      storageConsole.store(storage);
      System.out.println(storageConsole.makeUrl(storage));
      //System.out.println(storage.pack());
      RAop.release();
   }
}