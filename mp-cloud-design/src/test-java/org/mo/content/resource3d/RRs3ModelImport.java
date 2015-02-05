package org.mo.content.resource3d;

import org.mo.com.io.RFile;
import org.mo.com.lang.FStrings;
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
      RAop.initialize(configPath + "/mp-cloud-design/src/config/" + RRs3Utility.Config);

      FStrings filePaths = new FStrings();
      filePaths.push("pvw.show.item.001");
      filePaths.push("pvw.show.item.009");
      filePaths.push("pvw.sc.car.01.001");
      filePaths.push("pvw.show.skeleton.001");

      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IRs3ModelConsole modelConsole = RAop.find(IRs3ModelConsole.class);
         for(String fileName : filePaths){
            String fullName = RRs3Utility.RootPath + "/MoScript/source/assets/model/" + fileName;
            modelConsole.importModel(logicContext, fullName + ".msh");
            if(RFile.exists(fullName + ".skt")){
               modelConsole.importSkeleton(logicContext, fullName + ".skt");
            }
            if(RFile.exists(fullName + ".anm")){
               modelConsole.importAnimation(logicContext, fullName + ".anm");
            }
         }
      }catch(Exception e){
         RLogger.find(RRs3ModelImport.class).error(null, "main", e);
      }

      RAop.release();
   }
}
