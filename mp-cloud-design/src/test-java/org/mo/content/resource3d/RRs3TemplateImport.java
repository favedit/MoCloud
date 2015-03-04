package org.mo.content.resource3d;

import org.mo.com.lang.FStrings;
import org.mo.com.logging.RLogger;
import org.mo.content.common.RRs3Configuration;
import org.mo.content.engine3d.core.template.IRs3TemplateConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RRs3TemplateImport
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void importProcess() throws Exception{
      String path = RRs3Configuration.RootPath + "/MoScript/source/assets/template/";
      // 设置数据
      FStrings filePaths = new FStrings();
      //      for(String fileName : RFile.listFiles(path)){
      //         String name = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
      //         if(name.endsWith(".xml")){
      //            name = name.substring(0, name.length() - 4);
      //            if(name.startsWith("pvw.sc.courtyard")){
      //               filePaths.push(name);
      //            }
      //         }
      //      }
      //      filePaths.push("com.design.translation");
      //      filePaths.push("com.design.rotation");
      //      filePaths.push("com.design.scale");
      //      filePaths.push("com.light.point");
      //      filePaths.push("com.light.spot");
      //      filePaths.push("pvw.show.item.001");
      // filePaths.push("pvw.show.item.003");
      //      filePaths.push("pvw.show.item.004");
      //      filePaths.push("pvw.show.item.005");
      //      filePaths.push("pvw.show.item.006");
      //      filePaths.push("pvw.show.item.007");
      //      filePaths.push("pvw.show.item.008");
      //      filePaths.push("pvw.show.item.009");
      //filePaths.push("pvw.show.item.010");
      //filePaths.push("pvw.show.item.011");
      //      filePaths.push("pvw.show.item.012");
      //      filePaths.push("pvw.show.skeleton.001");
      //      filePaths.push("pvw.show.skeleton.002");
      //      filePaths.push("pvw.show.skeleton.003");
      //      filePaths.push("pvw.show.skeleton.004");
      //      filePaths.push("pvw.show.skeleton.005");
      //      filePaths.push("pvw.sc.car.01.001");
      //      filePaths.push("pvw.sc.car.01.002");
      //      filePaths.push("pvw.sc.car.01.003");
      //      filePaths.push("pvw.showcase.001");
      //      filePaths.push("pvw.showcase.002");
      //      filePaths.push("pvw.showcase.003");
      //      filePaths.push("pvw.showcase.004");
      //      filePaths.push("pvw.showcase.005");
      //      filePaths.push("pvw.showcase.007");
      //      filePaths.push("pvw.sc.house.01.scene");
      //      filePaths.push("lgt.item.001");
      //      filePaths.push("lgt.item.002");
      //      filePaths.push("lgt.item.003");
      //filePaths.push("lgt.scene");
      //      filePaths.push("g3.chr.npc.race.001.001");
      //      filePaths.push("g3.chr.ply.race.001.001");
      //      filePaths.push("sky.001");
      //      filePaths.push("sky.002");
      //      filePaths.push("sky.003");
      //filePaths.push("dev.water.001");
      //      filePaths.push("pvw.sc.science.item.001");
      //      filePaths.push("pvw.sc.science.item.002");
      //      filePaths.push("pvw.sc.science.item.003");
      filePaths.push("lbl.scene");
      // 导入处理
      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IRs3TemplateConsole templateConsole = RAop.find(IRs3TemplateConsole.class);
         for(String fileName : filePaths){
            System.out.println("-- " + fileName);
            templateConsole.importTemplate(logicContext, path + fileName + ".xml");
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
         RLogger.find(RRs3TemplateImport.class).error(null, "main", e);
      }
      RAop.release();
   }
}
