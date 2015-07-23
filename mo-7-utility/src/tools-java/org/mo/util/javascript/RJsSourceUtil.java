/*
 * @(#)FHtmlUtil.java
 *
 * Copyright 2005 microbject, All Rights Reserved.
 *
 */
package org.mo.util.javascript;

import java.io.File;
import org.mo.com.io.FLinesFile;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FString;
import org.mo.com.lang.RString;

public class RJsSourceUtil
{
   // 字符编码
   public static String CHARSET = "UTF-8";

   public static String makeLabel(String type,
                                  String label,
                                  String desc){
      if(RString.equalsIgnoreCase(label, desc)){
         return label;
      }
      if(RString.isEmpty(desc)){
         return label;
      }
      if(type.equalsIgnoreCase("user")){
         return desc;
      }
      return label + " <FONT color='green'>[ " + desc + " ]</FONT>";
   }

   public static String nodeLabel(String name,
                                  String label){
      if(name != null && label != null && label.length() > 0 && !name.equals(label)){
         return name + " <FONT color='green'>[ " + label + " ]</FONT>";
      }
      return name;
   }

   //============================================================
   // <T>格式化文件。</T>
   //
   // @param source 来源
   // @param commont 环境 debug | release
   // @param file 文件
   //============================================================
   public static void formatFile(FString source,
                                 String modeCd,
                                 File file){
      FLinesFile fileLines = new FLinesFile(file, CHARSET);
      int count = fileLines.count();
      for(int n = 0; n < count; n++){
         String line = fileLines.line(n);
         if(!RString.isBlank(line)){
            line = RString.trimRight(line);
            line = RString.removeChars(line, '\r');
            //............................................................
            // 去除注释的代码内容
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
            if(modeCd.equals("debug")){
               source.appendLine(line);
            }else if(modeCd.equals("release")){
               // 去除日志信息
               if(trim.startsWith("MO.Logger.debug")){
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
            }else{
               throw new FFatalError("Invalid mode.");
            }
         }
      }
   }
}
