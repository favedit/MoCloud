package org.mo.util.javascript;

import org.mo.com.io.FByteFile;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.mime.lzma.FLzmaFile;

//============================================================
// <T>游戏工具。</T>
//============================================================
public class RJsCompress
{
   // 日志输出接口
   @SuppressWarnings("unused")
   private final static ILogger _logger = RLogger.find(RJsCompress.class);

   //============================================================
   // <T>启动处理。</T>
   //============================================================
   @SuppressWarnings("resource")
   public static void main(String[] args){
      //      String targetFileName = null;
      //      // 打印参数
      //      int count = args.length;
      //      for(int n = 0; n < count; n++){
      //         String parameter = args[n];
      //         if(n == 0){
      //            targetFileName = parameter;
      //         }
      //         System.out.println("Parameter " + n + ": " + parameter);
      //      }
      //      // 检查参数
      //      if(RString.isEmpty(targetFileName)){
      //         throw new FFatalError("Target file is empty.");
      //      }
      //      // 压缩文件
      FLzmaFile file = new FLzmaFile();
      //      for(int n = 1; n < count; n++){
      //         String parameter = args[n];
      //         file.append((new FByteFile(parameter)).toArray());
      //      }
      //      file.saveLzmaFile(targetFileName);
      file.append((new FByteFile("D:/Microbject/MoScript/source/ajs/me.js")).toArray());
      file.append((new FByteFile("D:/Microbject/MoScript/source/ajs/eai.js")).toArray());
      file.saveLzmaFile("D:/Microbject/MoScript/source/ajs/release/eai.jc");
      System.out.println("Success");
   }
}
