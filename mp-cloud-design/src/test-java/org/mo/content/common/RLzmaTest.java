package org.mo.content.common;

import org.mo.mime.lzma.FLzmaFile;

public class RLzmaTest
{

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      FLzmaFile file = new FLzmaFile();
      file.loadFile("E:\\Genesis3D-功能模块地图.png");
      //byte[] data = file.toLzmaArray();
      byte[] data = file.toLzmaArray();
      //file.saveLzmaFile("E:\\Genesis3D-功能模块地图.lzma");
      float rate = (float)data.length / (float)file.length();
      System.out.println("Compress data. " + file.length() + " -> " + data.length + " rate=" + rate);
      file.close();
   }
}
