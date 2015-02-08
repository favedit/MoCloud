package org.mo.content.resource3d;

import org.mo.com.lang.FStrings;
import org.mo.com.logging.RLogger;
import org.mo.content.engine3d.core.template.IRs3TemplateConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class Rs3TemplateImport
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void importProcess() throws Exception{
      // 设置数据
      FStrings filePaths = new FStrings();
      filePaths.push("pvw.show.item.001");
      filePaths.push("pvw.show.item.009");
      filePaths.push("pvw.sc.car.01.001");
      filePaths.push("pvw.show.skeleton.001");
      // 导入处理
      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IRs3TemplateConsole templateConsole = RAop.find(IRs3TemplateConsole.class);
         for(String fileName : filePaths){
            String path = RRs3Utility.RootPath + "/MoScript/source/assets/template/" + fileName + ".xml";
            templateConsole.importTemplate(logicContext, path);
         }
      }
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = RRs3Utility.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-design/src/config/" + RRs3Utility.Config);
      try{
         importProcess();
      }catch(Exception e){
         RLogger.find(Rs3TemplateImport.class).error(null, "main", e);
      }
      RAop.release();
   }
}
