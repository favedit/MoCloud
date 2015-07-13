package org.mo.util.javascript;

import java.io.File;
import org.mo.com.io.FLinesFile;
import org.mo.com.io.FStringFile;
import org.mo.com.lang.FString;
import org.mo.com.lang.RString;
import org.mo.com.logging.RLogger;

//============================================================
// <T>JavaScript路径合并。</T>
//============================================================
public class FJsPathMerger
{
   // 字符编码
   private static String CHARSET = "UTF-8";

   //============================================================
   // <T>格式化文件。</T>
   //
   // @param source 来源
   // @param commont 环境 debug | release
   // @param file 文件
   //============================================================
   public static void formatFile(FString source,
                                 String comment,
                                 File file){
      FLinesFile fileLines = new FLinesFile(file, CHARSET);
      int count = fileLines.count();
      for(int n = 0; n < count; n++){
         String line = fileLines.line(n);
         if(!RString.isBlank(line)){
            line = RString.trimRight(line);
            line = RString.removeChars(line, '\r');
            if(comment.equals("debug")){
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
               //............................................................
               // 追加去除debug的代码
               if(trim.startsWith("MO.Assert.debug")){
                  // 删除debug模式
                  continue;
               }else if(trim.startsWith("MO.Assert.debugBegin")){
                  // 删除块代码
                  for(n++; n < count; n++){
                     line = fileLines.line(n);
                     if(line.trim().endsWith("MO.Assert.debugEnd")){
                        break;
                     }
                  }
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
   public static void main(String[] params){
      String path = null;
      String target = null;
      String comment = "debug";
      // 检查参数
      if(params.length == 3){
         path = params[0];
         target = params[1];
         comment = params[2];
      }else{
         System.out.println("Param count is invalid.");
         System.out.println("   1 - path");
         System.out.println("   2 - target");
         System.out.println("   3 - comment (debug/release)");
         return;
      }
      try{
         // 链接目录下内容
         FString sourceS = new FString();
         FString sourceT = new FString();
         FString sourceF = new FString();
         FString sourceR = new FString();
         FString sourceA = new FString();
         for(File file : new File(path).listFiles()){
            if(file.isFile()){
               String fileName = file.getName();
               if(fileName.startsWith("S")){
                  formatFile(sourceS, comment, file);
               }else if(fileName.startsWith("T")){
                  formatFile(sourceT, comment, file);
               }else if(fileName.startsWith("F")){
                  formatFile(sourceF, comment, file);
               }else if(fileName.startsWith("R")){
                  formatFile(sourceR, comment, file);
               }else{
                  formatFile(sourceA, comment, file);
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
         result.saveFile(target, CHARSET);
         System.out.println("Merge javascript path file. (file_name=" + target + ")");
      }catch(Throwable t){
         RLogger.find(FJsPathMerger.class).error(null, "main", t);
      }
   }
}
