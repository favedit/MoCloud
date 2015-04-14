package org.mo.content.resource3d;


public class RRs3TextureImport
{
   //   //============================================================
   //   // <T>导入处理。</T>
   //   //============================================================
   //   public static void importProcess() throws Exception{
   //      String path = RRs3Configuration.RootPath + "/MoScript/source/assets/texture/";
   //      // 设置数据
   //      FStrings filePaths = new FStrings();
   //      for(String fileName : RFile.listFiles(path)){
   //         String name = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
   //         filePaths.push(name);
   //      }
   //      // 导入处理
   //      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
   //      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
   //         IRs3TextureConsole textureConsole = RAop.find(IRs3TextureConsole.class);
   //         for(String fileName : filePaths){
   //            textureConsole.importTexture(logicContext, path + fileName);
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
   //         RLogger.find(RRs3TextureImport.class).error(null, "main", e);
   //      }
   //      RAop.release();
   //   }
}
