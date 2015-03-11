package org.mo.mime.lzma;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import lzma.streams.LzmaOutputStream;
import org.mo.com.io.FByteFile;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>LZMA文件。</T>
//============================================================
public class FLzmaFile
      extends FByteFile
{
   //============================================================
   // <T>构造LZMA文件。</T>
   //============================================================
   public FLzmaFile(){
   }

   //============================================================
   // <T>构造LZMA文件。</T>
   //
   // @param data 数据
   //============================================================
   public FLzmaFile(byte[] data){
      super(data);
   }

   //============================================================
   // <T>构造LZMA文件。</T>
   //
   // @param data 数据
   // @param offset 位置
   // @param length 长度
   //============================================================
   public FLzmaFile(byte[] data,
                    int offset,
                    int length){
      super(data, offset, length);
   }

   //============================================================
   // <T>构造LZMA文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public FLzmaFile(String fileName){
      super(fileName);
   }

   //============================================================
   // <T>构造LZMA文件。</T>
   //
   // @param fileName 文件名称
   // @param loaded 加载
   //============================================================
   public FLzmaFile(String fileName,
                    boolean loaded){
      super(fileName, loaded);
   }

   //============================================================
   // <T>加载LZMA文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void loadLzmaFile(String fileName){
      //      try{
      //         InputStream fileStream = new FileInputStream(fileName);
      //         LzmaInputStream lzmaStream = new LzmaInputStream(fileStream, new Decoder());
      //      }catch(Exception e){
      //         throw new FFatalError(e);
      //      }
   }

   //============================================================
   // <T>存储LZMA文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void saveLzmaFile(String fileName){
      try{
         FileOutputStream fileOutputStream = new FileOutputStream(fileName);
         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
         LzmaOutputStream lzmaOutputStream = new LzmaOutputStream.Builder(bufferedOutputStream).build();
         lzmaOutputStream.write(_memory, 0, _length);
         lzmaOutputStream.close();
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>存储LZMA数据。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public byte[] toLzmaArray(){
      try{
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
         LzmaOutputStream lzmaOutputStream = new LzmaOutputStream.Builder(bufferedOutputStream).build();
         lzmaOutputStream.write(_memory, 0, _length);
         lzmaOutputStream.close();
         return outputStream.toByteArray();
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }
}
