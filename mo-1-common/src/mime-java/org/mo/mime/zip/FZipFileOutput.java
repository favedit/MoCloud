package org.mo.mime.zip;

import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>ZIP文件输出流。</T>
//============================================================
public class FZipFileOutput
      extends FZipOutput
{
   //============================================================
   // <T>构造ZIP文件输出流。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public FZipFileOutput(String fileName){
      try{
         FileOutputStream stream = new FileOutputStream(fileName);
         _output = new ZipOutputStream(stream);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }
}
