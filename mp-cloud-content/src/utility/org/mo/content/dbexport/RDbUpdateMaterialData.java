package org.mo.content.dbexport;

import com.cyou.gccloud.data.data.FDataResourceMaterialLogic;
import com.cyou.gccloud.data.data.FDataResourceMaterialUnit;
import org.mo.cloud.logic.data.resource.FGcResourceInfo;
import org.mo.cloud.logic.data.resource.IGcResourceConsole;
import org.mo.com.logging.RLogger;
import org.mo.content.common.RRs3Configuration;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RDbUpdateMaterialData
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void importProcess() throws Exception{

      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      IGcResourceConsole resourceConsole = RAop.find(IGcResourceConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         FDataResourceMaterialLogic materialLogic = logicContext.findLogic(FDataResourceMaterialLogic.class);
         FLogicDataset<FDataResourceMaterialUnit> dataset = materialLogic.fetchAll();
         for(FDataResourceMaterialUnit materialUnit : dataset){
            FGcResourceInfo resourceInfo = resourceConsole.find(logicContext, materialUnit.resourceId());
            resourceInfo.setCode(materialUnit.code());
            resourceInfo.setLabel(materialUnit.label());
            resourceConsole.doUpdate(logicContext, resourceInfo);
         }
      }
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = RRs3Configuration.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-content/src/config/" + RRs3Configuration.Config);
      try{
         importProcess();
      }catch(Exception e){
         RLogger.find(RDbUpdateMaterialData.class).error(null, "main", e);
      }
      RAop.release();
   }
}
