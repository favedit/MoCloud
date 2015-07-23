package org.mo.util.javascript;

import java.io.File;
import org.mo.com.io.FStringFile;
import org.mo.com.lang.FString;
import org.mo.com.logging.RLogger;

//============================================================
// <T>JavaScript路径合并。</T>
//============================================================
public class FJsPathMerger
{
   //============================================================
   // <T>启动处理。</T>
   //
   // @param params 参数集合
   //============================================================
   public static void main(String[] params){
      String path = null;
      String target = null;
      String modeCd = "debug";
      // 检查参数
      if(params.length == 3){
         path = params[0];
         target = params[1];
         modeCd = params[2];
      }else{
         System.out.println("Param count is invalid.");
         System.out.println("   1 - path");
         System.out.println("   2 - target");
         System.out.println("   3 - modeCd (debug/release)");
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
         // 存储文件
         FStringFile result = new FStringFile();
         result.append(sourceA);
         result.append(sourceS);
         result.append(sourceT);
         result.append(sourceF);
         result.append(sourceR);
         result.saveFile(target, RJsSourceUtil.CHARSET);
         System.out.println("Merge javascript path file. (file_name=" + target + ")");
      }catch(Throwable t){
         RLogger.find(FJsPathMerger.class).error(null, "main", t);
      }
   }
}
