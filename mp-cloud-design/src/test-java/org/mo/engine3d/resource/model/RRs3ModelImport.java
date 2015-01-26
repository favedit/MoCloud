package org.mo.engine3d.resource.model;

import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
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
      String configPath = "D:/Microbject/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.configConsole().loadFile(configPath + "/mp-cloud-design/src/config/application-local.xml");

      FRs3Model model = new FRs3Model();
      model.loadFile("D:/Microbject/MoScript/source/assets/model/pvw.show.item.001.msd");

      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
         FDataResource3dModelUnit modelUnit = modelLogic.doPrepare();
         modelLogic.doInsert(modelUnit);
      }

      RAop.release();
   }
}
