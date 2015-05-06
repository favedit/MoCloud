package org.mo.mime.compress;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import lzma.streams.LzmaOutputStream;
import org.mo.com.io.FByteFile;
import org.mo.com.io.FByteStream;
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
   // <T>存储DEFLATE数据。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public byte[] toLzmaArray(int blockSize){
      // 计算分块数量
      int blockCount = _length / blockSize;
      if(_length % blockSize != 0){
         blockCount++;
      }
      // 分块压缩
      FByteStream stream = new FByteStream();
      try{
         stream.writeString("lzma");
         stream.writeInt32(_length);
         stream.writeInt32(blockSize);
         stream.writeInt32(blockCount);
         for(int block = 0; block < blockCount; block++){
            // 计算位置
            int position = blockSize * block;
            int remain = _length - position;
            int size = Math.min(remain, blockSize);
            // 压缩数据
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            LzmaOutputStream lzmaOutputStream = new LzmaOutputStream.Builder(bufferedOutputStream).build();
            lzmaOutputStream.write(_memory, position, size);
            lzmaOutputStream.close();
            byte[] data = outputStream.toByteArray();
            // 输出数据
            stream.writeUint32(data.length);
            stream.write(data);
         }
         return stream.toArray();
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

   //============================================================
   // <T>存储压缩数据。</T>
   //
   // @param modeCd 压缩模式
   // @param blockSize 分块大小
   //============================================================
   public byte[] toCompressArray(ECompressMode modeCd,
                                 int blockSize){
      if(modeCd == ECompressMode.Deflate){
         return toDeflateArray();
      }else if(modeCd == ECompressMode.Lzma){
         return toLzmaArray(blockSize);
      }else{
         throw new FFatalError("Unknown mode.");
      }
   }
}
