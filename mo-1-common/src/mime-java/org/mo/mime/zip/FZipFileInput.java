package org.mo.mime.zip;

import java.io.FileInputStream;
import java.util.zip.ZipInputStream;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>ZIP文件输入流。</T>
//============================================================
public class FZipFileInput
      extends FZipInput
{
   //============================================================
   // <T>构造ZIP文件输入流。</T>
   //============================================================
   public FZipFileInput(String fileName){
      try{
         FileInputStream stream = new FileInputStream(fileName);
         _input = new ZipInputStream(stream);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }
}
