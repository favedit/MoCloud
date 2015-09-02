package org.mo.cloud.javascript;

import org.mo.com.io.RFile;
import org.mo.com.lang.FStrings;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>游戏工具。</T>
//============================================================
public class RFileRenameUtil
{
   // 日志输出接口
   @SuppressWarnings("unused")
   private final static ILogger _logger = RLogger.find(RFileRenameUtil.class);

   protected static String findFile(FStrings fileNames,
                                    String code,
                                    String type){
      for(String fileName : fileNames){
         if(fileName.contains(code) && fileName.endsWith(type)){
            return fileName;
         }
      }
      return null;
   }

   //============================================================
   // <T>启动处理。</T>
   //============================================================
   public static void main(String[] args){
      String fileExt = ".mkv";
      String sourcePath = "Q:/[Temp]/尽管如此世界依然美丽 (2014-12.mkv-1920x1080-27.2G)";
      FStrings fileNames = RFile.listFiles(sourcePath);
      for(String fileName : fileNames){
         if(fileName.endsWith(fileExt)){
            //RFile.rename(fileName, RString.replace(fileName, ".MKV", ".mkv"));
            String code = RString.mid(RFile.name(fileName), "第", "話");
            //String code = RFile.name(fileName).substring(0, 2);
            if(RInteger.isInteger(code)){
               String name = RFile.name(fileName);
               String findFileName = findFile(fileNames, "[" + code + "]", "-tc.ass");
               if(!RString.isEmpty(findFileName)){
                  String findName = RFile.name(findFileName);
                  System.out.println(code + " - " + name + " : " + findName);
                  RFile.rename(sourcePath + "/" + findName, sourcePath + "/" + RString.replace(name, fileExt, ".tc.ass"));
               }
            }
         }
      }
   }
}
