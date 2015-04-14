package org.mo.content.resource;

import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RResBitmapImport
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = "E:/Microbject/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-design/src/config/application-local.xml");

      String filePath = "E:/Microbject/MoScript/source/assets/texture/pvw.show.001.01";

      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         //         IRs3TextureConsole textureConsole = RAop.find(IRs3TextureConsole.class);
         //         textureConsole.importTexture(logicContext, filePath);
      }catch(Exception e){
         RLogger.find(RResBitmapImport.class).error(null, "main", e);
      }

      RAop.release();
   }
}
