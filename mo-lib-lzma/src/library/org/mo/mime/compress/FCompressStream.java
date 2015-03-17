package org.mo.mime.compress;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import lzma.streams.LzmaOutputStream;
import org.mo.com.io.FByteFile;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>压缩数据流。</T>
//============================================================
public class FCompressStream
      extends FByteFile
{
   //============================================================
   // <T>构造压缩数据流。</T>
   //============================================================
   public FCompressStream(){
   }

   //============================================================
   // <T>构造压缩数据流。</T>
   //
   // @param data 数据
   //============================================================
   public FCompressStream(byte[] data){
      super(data);
   }

   //============================================================
   // <T>构造压缩数据流。</T>
   //
   // @param data 数据
   // @param offset 位置
   // @param length 长度
   //============================================================
   public FCompressStream(byte[] data,
                          int offset,
                          int length){
      super(data, offset, length);
   }

   //============================================================
   // <T>存储DEFLATE数据。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public byte[] toDeflateArray(){
      try{
         byte[] output = null;
         Deflater compresser = new Deflater();
         compresser.reset();
         compresser.setInput(_memory, 0, _length);
         compresser.finish();
         ByteArrayOutputStream bos = new ByteArrayOutputStream(_length);
         try{
            byte[] buf = new byte[1024];
            while(!compresser.finished()){
               int i = compresser.deflate(buf);
               bos.write(buf, 0, i);
            }
            output = bos.toByteArray();
         }catch(Exception e){
            throw new FFatalError(e);
         }finally{
            try{
               bos.close();
            }catch(Exception e){
               throw new FFatalError(e);
            }
         }
         compresser.end();
         return output;
         //         ByteArrayOutputStream outputStream = new ByteArrayOutputStream(_length);
         //         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
         //         CompressorOutputStream compressorOutputStream = new CompressorStreamFactory().createCompressorOutputStream(CompressorStreamFactory.DEFLATE, bufferedOutputStream);
         //         compressorOutputStream.write(_memory, 0, _length);
         //         return outputStream.toByteArray();
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>存储DEFLATE数据。</T>
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

   //============================================================
   // <T>存储压缩数据。</T>
   //
   // @param modeCd 压缩模式
   //============================================================
   public byte[] toCompressArray(ECompressMode modeCd){
      if(modeCd == ECompressMode.Deflate){
         return toDeflateArray();
      }else if(modeCd == ECompressMode.Lzma){
         return toLzmaArray();
      }else{
         throw new FFatalError("Unknown mode.");
      }
   }
}
