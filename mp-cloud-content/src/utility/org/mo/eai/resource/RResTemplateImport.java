package org.mo.eai.resource;

import org.mo.content.engine.core.template.IResTemplateConsole;

import java.io.File;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.io.RFile;
import org.mo.com.lang.FStrings;
import org.mo.com.logging.RLogger;
import org.mo.content.common.RRs3Configuration;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RResTemplateImport
{
   //============================================================
   // <T>导入处理。</T>
   //============================================================
   public static void importProcess() throws Exception{
      String path = RRs3Configuration.RootPath + "/MoResource/Export/template/";
      // 设置数据
      FStrings filePaths = new FStrings();
      for(String fileName : RFile.listFiles(path)){
         String name = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
         if(name.endsWith(".xml")){
            name = name.substring(0, name.length() - 4);
            filePaths.push(name);
         }
      }
      // 创建会话
      FGcSessionInfo session = RRs3Configuration.makeSession();
      // 导入处理
      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IResTemplateConsole templateConsole = RAop.find(IResTemplateConsole.class);
         for(String fileName : filePaths){
            templateConsole.importResource(logicContext, session, path + fileName + ".xml");
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
         RLogger.find(RResTemplateImport.class).error(null, "main", e);
      }
      RAop.release();
   }
}
