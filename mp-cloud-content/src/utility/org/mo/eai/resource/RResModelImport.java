package org.mo.eai.resource;

import java.io.File;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.io.RFile;
import org.mo.com.lang.FStrings;
import org.mo.com.logging.RLogger;
import org.mo.content.common.RRs3Configuration;
import org.mo.content.engine.core.model.IResModelConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RResModelImport
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void importProcess() throws Exception{
      String path = "D:/Microbject/MoExport/model/";
      // 设置数据
      FStrings filePaths = new FStrings();
      for(String fileName : RFile.listFiles(path)){
         String name = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
         if(name.endsWith(".msh")){
            name = name.substring(0, name.length() - 4);
            filePaths.push(name);
         }
      }
      // 创建会话
      FGcSessionInfo session = RRs3Configuration.makeSession();
      // 导入处理
      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IResModelConsole modelConsole = RAop.find(IResModelConsole.class);
         for(String fileName : filePaths){
            String fullName = path + fileName;
            modelConsole.importModel(logicContext, session, fullName + ".msh");
            if(RFile.exists(fullName + ".skt")){
               modelConsole.importSkeleton(logicContext, session, fullName + ".skt");
            }
            if(RFile.exists(fullName + ".anm")){
               modelConsole.importAnimation(logicContext, session, fullName + ".anm");
            }
         }
      }
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = RRs3Configuration.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-content/src/config/" + RRs3Configuration.Config);
      try{
         importProcess();
      }catch(Exception e){
         RLogger.find(RResModelImport.class).error(null, "main", e);
      }
      RAop.release();
   }
}
