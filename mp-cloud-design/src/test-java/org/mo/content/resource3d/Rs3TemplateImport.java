package org.mo.content.resource3d;

import org.mo.com.logging.RLogger;
import org.mo.content.engine3d.core.template.IRs3TemplateConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class Rs3TemplateImport
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = "E:/Microbject/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-design/src/config/application-local.xml");

      String fileName = "E:/Microbject/MoScript/source/assets/template/pvw.show.item.001.xml";

      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IRs3TemplateConsole templateConsole = RAop.find(IRs3TemplateConsole.class);
         templateConsole.importTemplate(logicContext, fileName);
         //FRs3Template template = templateConsole.findTemplate(logicContext, "DDD55D1AF1BA4626875D21F16296D8AB");
         //System.out.println(template);
      }catch(Exception e){
         RLogger.find(Rs3TemplateImport.class).error(null, "main", e);
      }

      RAop.release();
   }
}
