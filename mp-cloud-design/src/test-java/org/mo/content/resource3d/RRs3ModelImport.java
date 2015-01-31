package org.mo.content.resource3d;

import org.mo.com.io.FByteFile;
import org.mo.com.logging.RLogger;
import org.mo.content.engine3d.core.model.IRs3ModelConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RRs3ModelImport
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = RRs3Utility.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-design/src/config/application-local.xml");

      FByteFile file = new FByteFile();
      //file.loadFile("E:/Microbject/XiaoLongNv.mesh");
      file.loadFile(RRs3Utility.RootPath + "/MoScript/source/assets/model/pvw.show.item.001.msd");
      //file.loadFile("E:/Microbject/MoScript/source/assets/model/pvw.show.item.008.msd");
      //file.loadFile("E:/Microbject/MoScript/source/assets/model/pvw.show.item.009.msd");

      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IRs3ModelConsole modelConsole = RAop.find(IRs3ModelConsole.class);
         modelConsole.importModel(logicContext, file);
      }catch(Exception e){
         RLogger.find(RRs3ModelImport.class).error(null, "main", e);
      }

      RAop.release();
   }
}
