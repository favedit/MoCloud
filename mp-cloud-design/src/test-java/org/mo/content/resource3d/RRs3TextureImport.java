package org.mo.content.resource3d;

import java.io.File;
import org.mo.com.io.RFile;
import org.mo.com.lang.FStrings;
import org.mo.com.logging.RLogger;
import org.mo.content.common.RRs3Configuration;
import org.mo.content.engine3d.core.texture.IRs3TextureConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RRs3TextureImport
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void importProcess() throws Exception{
      String path = RRs3Configuration.RootPath + "/MoScript/source/assets/texture/";
      // 设置数据
      FStrings filePaths = new FStrings();
      for(String fileName : RFile.listFiles(path)){
         String name = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
         if(name.startsWith("lbl.")){
            filePaths.push(name);
         }
      }
      //      filePaths.push("pvw.show.001.01");
      //filePaths.push("pvw.show.003.01");
      //      filePaths.push("pvw.show.004.01");
      //      filePaths.push("pvw.show.004.02");
      //      filePaths.push("pvw.show.004.03");
      //      filePaths.push("pvw.show.005.01");
      //      filePaths.push("pvw.show.006.01");
      //      filePaths.push("pvw.show.006.02");
      //      filePaths.push("pvw.show.007.01");
      //      filePaths.push("pvw.show.008.01");
      //      filePaths.push("pvw.show.008.02");
      //      filePaths.push("pvw.show.009.01");
      //      filePaths.push("pvw.show.010.01");
      //      filePaths.push("pvw.show.011.01");
      //      filePaths.push("pvw.show.012.01");
      //      filePaths.push("pvw.show.012.02");
      //      filePaths.push("pvw.show.012.03");
      //      filePaths.push("pvw.show.012.04");
      //      filePaths.push("pvw.show.012.05");
      //      filePaths.push("pvw.show.012.06");
      //      filePaths.push("pvw.show.012.07");
      //      filePaths.push("pvw.show.012.08");
      //      filePaths.push("pvw.show.012.09");
      //      filePaths.push("pvw.show.012.10");
      //      filePaths.push("pvw.show.013.01");
      //      filePaths.push("pvw.show.013.02");
      //      filePaths.push("pvw.show.013.03");
      //      filePaths.push("pvw.show.014.01");
      //      filePaths.push("pvw.show.014.02");
      //      filePaths.push("pvw.show.014.03");
      //      filePaths.push("pvw.show.015.01");
      //      filePaths.push("pvw.show.016.01");
      //      filePaths.push("pvw.show.016.02");
      //      filePaths.push("pvw.show.016.03");
      //      filePaths.push("pvw.show.017.01");
      //      filePaths.push("pvw.show.017.02");
      //      filePaths.push("pvw.show.017.03");
      //      filePaths.push("pvw.show.018.01");
      //      filePaths.push("pvw.show.018.02");
      //      filePaths.push("pvw.show.018.03");
      //      filePaths.push("pvw.show.018.04");
      //      filePaths.push("pvw.show.018.05");
      //      filePaths.push("pvw.show.018.06");
      //      filePaths.push("pvw.show.018.07");
      //      filePaths.push("pvw.show.018.08");
      //      filePaths.push("pvw.show.018.09");
      //      filePaths.push("pvw.show.018.10");
      //      filePaths.push("pvw.show.019.01");
      //      filePaths.push("pvw.show.019.02");
      //      filePaths.push("pvw.sc.car.01.001.01");
      //      filePaths.push("pvw.sc.car.01.001.02");
      //      filePaths.push("pvw.sc.car.01.001.03");
      //      filePaths.push("pvw.sc.car.01.003.02");
      //      filePaths.push("pvw.showcase.001.01");
      //      filePaths.push("pvw.showcase.001.02");
      //      filePaths.push("pvw.showcase.001.03");
      //      filePaths.push("pvw.showcase.003.02");
      //      filePaths.push("pvw.sc.house.01.001");
      //      filePaths.push("pvw.sc.house.01.002");
      //      filePaths.push("pvw.sc.house.01.003");
      //      filePaths.push("pvw.sc.house.01.004");
      //      filePaths.push("pvw.sc.house.01.007");
      //      filePaths.push("pvw.sc.house.01.008");
      //      filePaths.push("pvw.sc.house.01.009");
      //      filePaths.push("pvw.sc.house.01.010");
      //      filePaths.push("pvw.sc.house.01.011");
      //      filePaths.push("pvw.sc.house.01.012");
      //      filePaths.push("pvw.sc.house.01.013");
      //      filePaths.push("pvw.sc.house.01.015");
      //      filePaths.push("pvw.sc.house.01.016");
      //      filePaths.push("pvw.sc.house.01.017");
      //      filePaths.push("pvw.sc.house.01.018");
      //      filePaths.push("pvw.sc.house.01.020");
      //      filePaths.push("pvw.sc.house.01.022");
      //      filePaths.push("pvw.sc.house.01.023");
      //      filePaths.push("pvw.sc.house.01.024");
      // 导入处理
      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IRs3TextureConsole textureConsole = RAop.find(IRs3TextureConsole.class);
         for(String fileName : filePaths){
            textureConsole.importTexture(logicContext, path + fileName);
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
         RLogger.find(RRs3TextureImport.class).error(null, "main", e);
      }
      RAop.release();
   }
}
