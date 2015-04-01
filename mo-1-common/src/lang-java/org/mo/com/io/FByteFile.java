package org.mo.com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>字节流文件。</T>
//============================================================
public class FByteFile
      extends FByteStream
      implements
         AutoCloseable
{
   // 文件名称
   protected String _fileName;

   //============================================================
   // <T>构造字节流文件。</T>
   //============================================================
   public FByteFile(){
   }

   //============================================================
   // <T>构造字节流文件。</T>
   //
   // @param capacity 容量
   //============================================================
   public FByteFile(int capacity){
      super(capacity);
   }

   //============================================================
   // <T>构造字节流文件。</T>
   //
   // @param data 数据
   //============================================================
   public FByteFile(byte[] data){
      _length = data.length;
      _memory = data;
   }

   //============================================================
   // <T>构造字节流文件。</T>
   //
   // @param data 数据
   // @param offset 位置
   // @param length 长度
   //============================================================
   public FByteFile(byte[] data,
                    int offset,
                    int length){
      _length = length;
      _memory = new byte[length];
      System.arraycopy(data, offset, _memory, 0, length);
   }

   //============================================================
   // <T>构造字节流文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public FByteFile(String fileName){
      loadFile(fileName);
   }

   //============================================================
   // <T>构造字节流文件。</T>
   //
   // @param fileName 文件名称
   // @param loaded 加载
   //============================================================
   public FByteFile(String fileName,
                    boolean loaded){
      if(loaded){
         loadFile(fileName);
      }else{
         _fileName = fileName;
      }
   }

   //============================================================
   // <T>读取一个文件，以字节返回这个文件的全部内容。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void loadFile(String fileName){
      // 检查文件合法
      File file = new File(fileName);
      if(!file.exists()){
         throw new FFatalError("File is not exists. (file_name={1})", fileName);
      }
      if(!file.isFile()){
         throw new FFatalError("File is invalid. (file_name={1})", fileName);
      }
      _fileName = fileName;
      // 清空内容
      clear();
      // 加载内容
      BufferedInputStream inputStream = null;
      try{
         int length = (int)file.length();
         if(length > 0){
            forceSize(length);
            // 读取文件
            inputStream = new BufferedInputStream(new FileInputStream(file));
            inputStream.read(_memory, 0, length);
            _length = length;
         }
      }catch(Exception e){
         throw new FFatalError(e, "Load file failure. (file_name={1})", fileName);
      }finally{
         if(null != inputStream){
            try{
               inputStream.close();
            }catch(Exception e){
               throw new FFatalError(e, "Close file failure. (file_name={1})", fileName);
            }
         }
      }
   }

   //============================================================
   // <T>将指定内容存储到一个指定的文件中。</T>
   // <P>如果指定文件的目录不存在，则自动创建目录。</P>
   //
   // @param fileName 文件名称
   //============================================================
   public void saveToFile(String fileName){
      // 建立目录
      fileName = RFile.formatFileName(fileName);
      int find = fileName.lastIndexOf(File.separator);
      if(-1 != find){
         String path = fileName.substring(0, find);
         File directory = new File(path);
         if(!directory.isDirectory()){
            directory.mkdirs();
         }
      }
      // 存储文件
      BufferedOutputStream outputStream = null;
      try{
         File file = new File(fileName);
         outputStream = new BufferedOutputStream(new FileOutputStream(file));
         if(_memory != null){
            outputStream.write(_memory, 0, _length);
         }
      }catch(Exception e){
         throw new FFatalError(e, "Save file failure. (file_name={1})", fileName);
      }finally{
         if(outputStream != null){
            try{
               outputStream.close();
            }catch(Exception e){
               throw new FFatalError(e, "Close file failure. (file_name={0})", fileName);
            }
         }
      }
   }

   //============================================================
   // <T>存储文件内容。</T>
   //============================================================
   public void store(){
      saveToFile(_fileName);
   }

   //============================================================
   // <T>关闭处理。</T>
   //============================================================
   @Override
   public void close(){
      _memory = null;
      _length = 0;
   }
}
