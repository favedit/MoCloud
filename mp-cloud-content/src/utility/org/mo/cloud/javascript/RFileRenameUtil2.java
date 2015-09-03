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
public class RFileRenameUtil2
{
   // 日志输出接口
   @SuppressWarnings("unused")
   private final static ILogger _logger = RLogger.find(RFileRenameUtil2.class);

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
      String sourcePath = "E:/Download/Manhua/杀戮都市";
      //      for(String fullName : RFile.listFiles(sourcePath)){
      //         String fileName = RFile.name(fullName);
      //         if(fileName.startsWith("话-")){
      //            System.out.println(fileName);
      //            RFile.rename(fullName, sourcePath + "/章-" + fileName.substring(2));
      //         }
      //      }
      for(String fullName : RFile.listFiles(sourcePath)){
         String fileName = RFile.name(fullName);
         String code = RString.leftPad(RString.mid(fileName, "第", "卷"), 2, "0");
         if(RInteger.isInteger(code)){
            System.out.println(code + " - " + code + " : " + fileName);
            RFile.rename(fullName, sourcePath + "/卷-" + code);
         }
      }
      //      for(String fullName : RFile.listFiles(sourcePath)){
      //         String fileName = RFile.name(fullName);
      //         String code = RString.leftPad(RString.mid(fileName, "第", "话"), 3, "0");
      //         //String code = RString.leftPad(RString.right(fileName, "_CH"), 3, "0");
      //         if(RInteger.isInteger(code)){
      //            System.out.println(code + " - " + code + " : " + fileName);
      //            RFile.rename(fullName, sourcePath + "/章-" + code);
      //         }
      //      }
   }
}
