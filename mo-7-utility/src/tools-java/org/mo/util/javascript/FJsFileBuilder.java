package org.mo.util.javascript;

import java.io.File;
import org.mo.com.io.FStringFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FString;
import org.mo.com.lang.FStrings;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;

//============================================================
//<T>JavaScript文件合并。</T>
//============================================================
public class FJsFileBuilder
{
   private static ILogger _logger = RLogger.find(FJsFileBuilder.class);

   //============================================================
   // <T>启动处理。</T>
   //
   // @param params 参数集合
   //============================================================
   public static void mergePath(String sourcePath,
                                String targetFile,
                                String modeCd){
      try{
         // 链接目录下内容
         FString sourceS = new FString();
         FString sourceT = new FString();
         FString sourceF = new FString();
         FString sourceR = new FString();
         FString sourceA = new FString();
         File path = new File(sourcePath);
         if(path.isDirectory()){
            for(File file : new File(sourcePath).listFiles()){
               if(file.isFile()){
                  String fileName = file.getName();
                  if(fileName.startsWith("S")){
                     RJsSourceUtil.formatFile(sourceS, modeCd, file);
                  }else if(fileName.startsWith("T")){
                     RJsSourceUtil.formatFile(sourceT, modeCd, file);
                  }else if(fileName.startsWith("F")){
                     RJsSourceUtil.formatFile(sourceF, modeCd, file);
                  }else if(fileName.startsWith("R")){
                     RJsSourceUtil.formatFile(sourceR, modeCd, file);
                  }else{
                     RJsSourceUtil.formatFile(sourceA, modeCd, file);
                  }
               }
            }
         }
         // 存储文件
         FStringFile result = new FStringFile();
         result.append(sourceA);
         result.append(sourceS);
         result.append(sourceT);
         result.append(sourceF);
         result.append(sourceR);
         // 存储文件
         result.saveFile(targetFile, RJsSourceUtil.CHARSET);
         System.out.println("Merge javascript path file. (file_name=" + targetFile + ")");
      }catch(Throwable t){
         _logger.error(null, "mergePath", t);
      }
   }

   //============================================================
   // <T>启动处理。</T>
   //
   // @param params 参数集合
   //============================================================
   public static void mergeFiles(FStrings sourceFiles,
                                 String targetFile){
      try{
         FStringFile file = new FStringFile(targetFile, RJsSourceUtil.CHARSET, false);
         for(String sourceFile : sourceFiles){
            FStringFile item = new FStringFile(sourceFile, RJsSourceUtil.CHARSET);
            file.append(item);
         }
         file.store(RJsSourceUtil.CHARSET);
         System.out.println("Merge javascript files. (file_name=" + targetFile + ")");
      }catch(Exception e){
         _logger.error(null, "main", e);
      }
   }

   //============================================================
   // <T>启动处理。</T>
   //
   // @param params 参数集合
   //============================================================
   public static void main(String[] params){
      try{
         // 检查路径
         String path = params[0];
         String modeCd = params[1];
         if(!RFile.isDirectory(path)){
            System.out.println("Unknown directory. (parameter=" + path + ")");
            return;
         }
         // 文件处理
         String configName = path + "/mojs.xml";
         FXmlDocument xdoc = new FXmlDocument(configName);
         FXmlNode xconfig = xdoc.root();
         // 处理所有路径合并
         if(xconfig.hasNode()){
            FXmlNode xmergers = xconfig.findNode("PathMergerCollection");
            for(FXmlNode xmerger : xmergers){
               if(xmerger.isName("PathMerger")){
                  String sourcePath = RFile.makeFilename(path, xmerger.get("source"));
                  String targetFile = RFile.makeFilename(path, xmerger.get("target"));
                  mergePath(sourcePath, targetFile, modeCd);
               }
            }
         }
         // 处理所有文件合并
         if(xconfig.hasNode()){
            FXmlNode xmergers = xconfig.findNode("FileMergerCollection");
            for(FXmlNode xmerger : xmergers){
               if(xmerger.isName("FileMerger")){
                  String targetFile = RFile.makeFilename(path, xmerger.get("target"));
                  FStrings sourceFiles = new FStrings();
                  for(FXmlNode xfile : xmerger){
                     if(xfile.isName("File")){
                        String sourceFile = RFile.makeFilename(path, xfile.get("source"));
                        sourceFiles.push(sourceFile);
                     }
                  }
                  mergeFiles(sourceFiles, targetFile);
               }
            }
         }
      }catch(Exception e){
         RLogger.find(FJsFileBuilder.class).error(null, "main", e);
      }
   }
}
