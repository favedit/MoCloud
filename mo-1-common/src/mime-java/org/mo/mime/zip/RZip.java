package org.mo.mime.zip;

//============================================================
// <T>ZIP压缩文件工具类。</T>
//============================================================
public class RZip
{
   // 后缀
   public static String EXTENSION = "zip";

   //============================================================
   // <T>打开一个压缩文件，返回读取用的流对象。</T>
   //
   // @param fileName 文件路径
   // @return 读取流对象
   //============================================================
   public static FZipInput openFile(String fileName){
      return new FZipFileInput(fileName);
   }

   //============================================================
   // <T>保存一个压缩文件，返回输出用的流对象。</T>
   //
   // @param fileName 文件路径
   // @return 输出流对象
   //============================================================
   public static FZipOutput writeFile(String fileName){
      return new FZipFileOutput(fileName);
   }

   //============================================================
   // <T>压缩目录到一个文件。</T>
   //
   // @param fileName 文件
   // @param directory 目录
   // @return 压缩文件个数
   //============================================================
   public static int compress(String fileName,
                              String directory){
      int count = 0;
      try(FZipOutput output = new FZipFileOutput(fileName)){
         count = output.compress(directory);
      }
      return count;
   }

   //============================================================
   // <T>解压缩一个压缩文件到目录。</T>
   //
   // @param fileName 文件
   // @param directory 目录
   // @return 解压文件个数
   //============================================================
   public static int decompress(String fileName,
                                String directory){
      int count = 0;
      try(FZipInput input = new FZipFileInput(fileName)){
         count = input.decompress(directory);
      }
      return count;
   }
}
