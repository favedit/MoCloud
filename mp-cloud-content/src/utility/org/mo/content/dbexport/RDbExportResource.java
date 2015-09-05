package org.mo.content.dbexport;

public class RDbExportResource
{
   //   //============================================================
   //   // <T>导出模型处理。</T>
   //   //============================================================
   //   public static void exportTexture(ILogicContext logicContext,
   //                                    String resourcePath) throws Exception{
   //      // 设置数据
   //      String path = resourcePath + "/texture";
   //      // 导出模板
   //      IRs3TextureConsole console = RAop.find(IRs3TextureConsole.class);
   //      FDataResource3dTextureLogic logic = logicContext.findLogic(FDataResource3dTextureLogic.class);
   //      FLogicDataset<FDataResource3dTextureUnit> units = logic.fetchAll();
   //      for(FDataResource3dTextureUnit unit : units){
   //         String textureGuid = unit.guid();
   //         // 存储纹理
   //         byte[] data = console.makeTextureData(logicContext, textureGuid);
   //         try(FByteFile file = new FByteFile(data)){
   //            file.saveToFile(path + "/" + unit.guid() + ".bin");
   //         }
   //         // 存储位图
   //         FRs3Texture texture = console.makeTexture(logicContext, textureGuid);
   //         for(FRs3TextureBitmapPack pack : texture.bitmapPacks()){
   //            String packCode = pack.code();
   //            packCode = RString.replace(packCode, '|', '-');
   //            byte[] bitmapData = console.makeBitmapData(logicContext, textureGuid, pack.code());
   //            try(FByteFile file = new FByteFile(bitmapData)){
   //               file.saveToFile(path + "/" + textureGuid + "/" + packCode + "." + pack.formatCode());
   //            }
   //         }
   //      }
   //   }
   //
   //   //============================================================
   //   // <T>导出模型处理。</T>
   //   //============================================================
   //   public static void exportModel(ILogicContext logicContext,
   //                                  String resourcePath) throws Exception{
   //      // 设置数据
   //      String path = resourcePath + "/model";
   //      // 导出模板
   //      IRs3ModelConsole console = RAop.find(IRs3ModelConsole.class);
   //      FDataResource3dModelLogic logic = logicContext.findLogic(FDataResource3dModelLogic.class);
   //      FLogicDataset<FDataResource3dModelUnit> units = logic.fetchAll();
   //      for(FDataResource3dModelUnit unit : units){
   //         byte[] data = console.makeModelData(logicContext, unit.guid());
   //         try(FByteFile file = new FByteFile(data)){
   //            file.saveToFile(path + "/" + unit.guid() + ".bin");
   //         }
   //      }
   //   }
   //
   //   //============================================================
   //   // <T>导出模板处理。</T>
   //   //============================================================
   //   public static void exportTemplate(ILogicContext logicContext,
   //                                     String resourcePath) throws Exception{
   //      // 设置数据
   //      String path = resourcePath + "/template";
   //      // 导出模板
   //      IRs3TemplateConsole templateConsole = RAop.find(IRs3TemplateConsole.class);
   //      FDataResource3dTemplateLogic templateLogic = logicContext.findLogic(FDataResource3dTemplateLogic.class);
   //      FLogicDataset<FDataResource3dTemplateUnit> units = templateLogic.fetchAll();
   //      for(FDataResource3dTemplateUnit unit : units){
   //         byte[] data = templateConsole.makeTemplateData(logicContext, unit.guid());
   //         try(FByteFile file = new FByteFile(data)){
   //            file.saveToFile(path + "/" + unit.guid() + ".bin");
   //         }
   //      }
   //   }
   //
   //   //============================================================
   //   // <T>导出场景处理。</T>
   //   //============================================================
   //   public static void exportScene(ILogicContext logicContext,
   //                                  String resourcePath) throws Exception{
   //      // 设置数据
   //      String path = resourcePath + "/scene";
   //      // 导出模板
   //      IRs3SceneConsole console = RAop.find(IRs3SceneConsole.class);
   //      FDataResource3dSceneLogic sceneLogic = logicContext.findLogic(FDataResource3dSceneLogic.class);
   //      FLogicDataset<FDataResource3dSceneUnit> sceneUnits = sceneLogic.fetchAll();
   //      for(FDataResource3dSceneUnit sceneUnit : sceneUnits){
   //         FDataResource3dSceneThemeLogic scenethemeLogic = logicContext.findLogic(FDataResource3dSceneThemeLogic.class);
   //         FLogicDataset<FDataResource3dSceneThemeUnit> scenethemeUnits = scenethemeLogic.fetch(FDataResource3dSceneThemeLogic.SCENE_ID + "=" + sceneUnit.ouid(), "CODE");
   //         for(FDataResource3dSceneThemeUnit scenethemeUnit : scenethemeUnits){
   //            byte[] data = console.makeThemeData(logicContext, scenethemeUnit.guid());
   //            try(FByteFile file = new FByteFile(data)){
   //               file.saveToFile(path + "/" + sceneUnit.code() + ".bin");
   //            }
   //            break;
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
   //      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
   //      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
   //         String resourcePath = RRs3Configuration.RootPath + "/MoScript/source/ar3";
   //         exportTexture(logicContext, resourcePath);
   //         //exportModel(logicContext, resourcePath);
   //         //exportTemplate(logicContext, resourcePath);
   //         //exportScene(logicContext, resourcePath);
   //      }catch(Exception e){
   //         RLogger.find(RRs3TextureImport.class).error(null, "main", e);
   //      }
   //      RAop.release();
   //   }
}
