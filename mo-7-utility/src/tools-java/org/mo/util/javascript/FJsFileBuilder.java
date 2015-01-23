package org.mo.util.javascript;

import java.io.File;
import org.mo.com.io.FLinesFile;
import org.mo.com.io.FStringFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FString;
import org.mo.com.lang.FStrings;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;

//============================================================
//<T>JavaScript文件合并。</T>
//============================================================
public class FJsFileBuilder
{
   // 字符编码
   private static String CHARSET = "UTF-8";

   private static ILogger _logger = RLogger.find(FJsFileBuilder.class);

   //============================================================
   // <T>格式化文件。</T>
   //
   // @param source 来源
   // @param commont 注释
   // @param file 文件
   //============================================================
   public static void formatFile(FString source,
                                 boolean comment,
                                 File file){
      FLinesFile fileLines = new FLinesFile(file, CHARSET);
      int count = fileLines.count();
      for(int n = 0; n < count; n++){
         String line = fileLines.line(n);
         if(!RString.isBlank(line)){
            line = RString.trimRight(line);
            line = RString.removeChars(line, '\r');
            if(comment){
               //............................................................
               // 追加含有注释的代码内容
               source.appendLine(line);
            }else{
               //............................................................
               // 追加去除注释的代码内容
               String trim = line.trim();
               if(trim.startsWith("/*")){
                  // 删除块注释
                  for(n++; n < count; n++){
                     line = fileLines.line(n);
                     if(line.trim().endsWith("*/")){
                        break;
                     }
                  }
                  continue;
               }else if(trim.startsWith("//")){
                  // 删除行注释
                  continue;
               }
               source.appendLine(line);
            }
         }
      }
   }

   //============================================================
   // <T>启动处理。</T>
   //
   // @param params 参数集合
   //============================================================
   public static void mergePath(String sourcePath,
                                String targetFile){
      boolean comment = false;
      try{
         FStringFile result = new FStringFile();
         File path = new File(sourcePath);
         if(path.isDirectory()){
            for(File file : path.listFiles()){
               if(file.isFile()){
                  formatFile(result, comment, file);
               }
            }
         }
         // 存储文件
         result.saveFile(targetFile, CHARSET);
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
         FStringFile file = new FStringFile(targetFile, CHARSET, false);
         for(String sourceFile : sourceFiles){
            FStringFile item = new FStringFile(sourceFile, CHARSET);
            file.append(item);
         }
         file.store(CHARSET);
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
                  mergePath(sourcePath, targetFile);
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
