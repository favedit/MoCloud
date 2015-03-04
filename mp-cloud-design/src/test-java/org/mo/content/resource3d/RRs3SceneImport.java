package org.mo.content.resource3d;

import org.mo.com.lang.FStrings;
import org.mo.com.logging.RLogger;
import org.mo.content.common.RRs3Configuration;
import org.mo.content.engine3d.core.scene.IRs3SceneConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RRs3SceneImport
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void importProcess() throws Exception{
      // 设置数据
      FStrings filePaths = new FStrings();
      //      filePaths.push("pvw.show.item.001");
      //      filePaths.push("pvw.show.item.003");
      //      filePaths.push("pvw.show.item.004");
      //      filePaths.push("pvw.show.item.006");
      //      filePaths.push("pvw.show.item.007");
      //      filePaths.push("pvw.show.item.008");
      //      filePaths.push("pvw.show.item.009");
      //      filePaths.push("pvw.show.item.010");
      //      filePaths.push("pvw.show.item.011");
      //      filePaths.push("pvw.show.item.012");
      //      filePaths.push("pvw.show.skeleton.01");
      //      filePaths.push("pvw.show.skeleton.02");
      //      filePaths.push("pvw.show.skeleton.03");
      //      filePaths.push("pvw.show.skeleton.04");
      //filePaths.push("pvw.show.skeleton.05");
      //      filePaths.push("pvw.sc.car.01.001");
      //      filePaths.push("pvw.sc.car.01.002");
      //      filePaths.push("pvw.sc.car.01.003");
      //      filePaths.push("pvw.sc.house.01.scene");
      //      filePaths.push("lgt.item.01");
      //      filePaths.push("lgt.item.02");
      //      filePaths.push("lgt.item.03");
      //      filePaths.push("lgt.scene");
      //      filePaths.push("g3.chr.01");
      //      filePaths.push("g3.chr.02");
      //      filePaths.push("dev.water.001");
      //      filePaths.push("pvw.sc.science.item.001");
      //      filePaths.push("pvw.sc.science.item.002");
      //      filePaths.push("pvw.sc.science.item.003");
      //      filePaths.push("pvw.sc.courtyard.scene");
      filePaths.push("lbl.scene");
      // 导入处理
      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IRs3SceneConsole sceneConsole = RAop.find(IRs3SceneConsole.class);
         for(String fileName : filePaths){
            String path = RRs3Configuration.RootPath + "/MoScript/source/assets/scene/" + fileName + ".ser";
            sceneConsole.importScene(logicContext, path);
         }
      }
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = RRs3Configuration.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-design/src/config/" + RRs3Configuration.Config);
      try{
         importProcess();
      }catch(Exception e){
         RLogger.find(RRs3SceneImport.class).error(null, "main", e);
      }
      RAop.release();
   }
}
