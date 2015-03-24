package org.mo.content.resource3d;

import java.io.File;
import org.mo.com.io.RFile;
import org.mo.com.lang.FStrings;
import org.mo.com.logging.RLogger;
import org.mo.content.common.RRs3Configuration;
import org.mo.content.engine3d.core.mesh.IRs3MeshConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RRs3MeshImport
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void importProcess() throws Exception{
      String path = RRs3Configuration.RootPath + "/MoScript/Temp/";
      // 设置数据
      FStrings filePaths = new FStrings();
      for(String fileName : RFile.listFiles(path)){
         String name = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
         if(name.endsWith(".ply")){
            name = name.substring(0, name.length() - 4);
            if(name.equals("person-02")){
               filePaths.push(name);
            }
         }
      }
      // 导入处理
      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IRs3MeshConsole meshConsole = RAop.find(IRs3MeshConsole.class);
         for(String fileName : filePaths){
            String fullName = path + fileName;
            meshConsole.importMeshPly(logicContext, fileName, fullName + ".ply");
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
         RLogger.find(RRs3MeshImport.class).error(null, "main", e);
      }
      RAop.release();
   }
}
