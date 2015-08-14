package org.mo.cloud.javascript;

import org.mo.com.io.FByteFile;
import org.mo.com.io.FByteStream;
import org.mo.com.io.FStringFile;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.mime.lzma.FLzmaFile;

//============================================================
// <T>游戏工具。</T>
//============================================================
public class RFileRenameUtil
{
   // 日志输出接口
   @SuppressWarnings("unused")
   private final static ILogger _logger = RLogger.find(RFileRenameUtil.class);

   //============================================================
   // <T>启动处理。</T>
   //============================================================
   @SuppressWarnings("resource")
   public static void main(String[] args){
      FByteStream stream = new FByteStream();
      FStringFile sourceFile = new FStringFile();
      sourceFile.loadFile("D:/Microbject/MoScript/source/ajs/me.js");
      String source = sourceFile.toString();
      int length = source.length();
      for(int i = 0; i < length; i++){
         char value = source.charAt(i);
         stream.writeUint16(value);
      }
      FLzmaFile file = new FLzmaFile();
      //file.append(stream.memory(), 0, stream.length());
      //      file.append((new FByteFile("D:/Microbject/MoScript/source/ajs/md5.js")).toArray());
      //      file.append((new FByteFile("D:/Microbject/MoScript/source/ajs/me.js")).toArray());
      //      file.append((new FByteFile("D:/Microbject/MoScript/source/ajs/eai.js")).toArray());
      //      file.saveLzmaFile("D:/Microbject/MoScript/source/ajs/me.jc");

      file.append((new FByteFile("D:/Microbject/MoScript/source/ajs/release/md5.js")).toArray());
      file.append((new FByteFile("D:/Microbject/MoScript/source/ajs/release/me.js")).toArray());
      file.append((new FByteFile("D:/Microbject/MoScript/source/ajs/release/eai.js")).toArray());
      file.saveLzmaFile("D:/Microbject/MoScript/source/ajs/release/me.jc");
   }
}
