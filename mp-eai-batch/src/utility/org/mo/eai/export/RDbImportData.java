package org.mo.eai.export;

import org.mo.com.logging.RLogger;
import org.mo.content.engine.core.storage.IResStorageConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RDbImportData
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = "D:/Microbject/MoCloud";
      String path = "D:/Microbject/transfer";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-eai-batch/src/config/application-work.xml");
      try{
         // 导入处理
         IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
         try(ILogicContext logicContext = new FLogicContext(dbConsole)){
            IResStorageConsole storageConsole = RAop.find(IResStorageConsole.class);
            storageConsole.importDataset(logicContext, "develop.data", "DT_COM_COUNTRY", path);
            storageConsole.importDataset(logicContext, "develop.data", "DT_COM_AREA", path);
            storageConsole.importDataset(logicContext, "develop.data", "DT_COM_PROVINCE", path);
            storageConsole.importDataset(logicContext, "develop.data", "DT_COM_CITY", path);
            storageConsole.importDataset(logicContext, "develop.data", "DT_COM_CITY_CARD", path);
         }
      }catch(Exception e){
         RLogger.find(RDbImportData.class).error(null, "main", e);
      }
      RAop.release();
   }
}
