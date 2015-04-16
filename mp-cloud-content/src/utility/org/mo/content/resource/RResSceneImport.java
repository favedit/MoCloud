package org.mo.content.resource;


public class RResSceneImport
{
   //   //============================================================
   //   // <T>导入处理。</T>
   //   //============================================================
   //   public static void importProcess() throws Exception{
   //      String path = RRs3Configuration.RootPath + "/MoScript/source/assets/scene/";
   //      // 设置数据
   //      FStrings filePaths = new FStrings();
   //      for(String fileName : RFile.listFiles(path)){
   //         String name = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
   //         filePaths.push(name);
   //      }
   //      //filePaths.push("pvw.show.item.001");
   //      // 导入处理
   //      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
   //      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
   //         IRs3SceneConsole sceneConsole = RAop.find(IRs3SceneConsole.class);
   //         for(String fileName : filePaths){
   //            sceneConsole.importScene(logicContext, RFile.format(path + fileName));
   //         }
   //      }
   //   }
   //
   //   //============================================================
   //   // <T>主函数。</T>
   //   //============================================================
   //   public static void main(String[] args) throws Exception{
   //      String configPath = RRs3Configuration.RootPath + "/MoCloud";
   //      RAop.configConsole().defineCollection().attributes().set("application", configPath);
   //      RAop.initialize(configPath + "/mp-cloud-design/src/config/" + RRs3Configuration.Config);
   //      try{
   //         importProcess();
   //      }catch(Exception e){
   //         RLogger.find(RRs3SceneImport.class).error(null, "main", e);
   //      }
   //      RAop.release();
   //   }
}
