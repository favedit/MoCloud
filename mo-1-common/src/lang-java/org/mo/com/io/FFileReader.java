package org.mo.com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;

//============================================================
// <T>文本文件读取器。</T>
//============================================================
public class FFileReader
      extends FObject
      implements
         AutoCloseable
{
   // 文件名称
   protected String _fileName;

   // 文本编码
   protected String _encoding = "UTF-8";

   // 输入流
   protected InputStream _inputStream;

   // 缓冲读取
   protected BufferedReader _reader;

   //============================================================
   // <T>构造文本文件读取器。</T>
   //============================================================
   public FFileReader(){
   }

   //============================================================
   // <T>构造文本文件读取器。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public FFileReader(String fileName){
      openFile(fileName);
   }

   //============================================================
   // <T>构造文本文件读取器。</T>
   //
   // @param fileName 文件名称
   // @param encoding 文本编码
   //============================================================
   public FFileReader(String fileName,
                      String encoding){
      openFile(fileName, encoding);
   }

   //============================================================
   // <T>获得文件名称。</T>
   //
   // @return 文件名称
   //============================================================
   public String fileName(){
      return _fileName;
   }

   //============================================================
   // <T>获得文本编码。</T>
   //
   // @return 文本编码
   //============================================================
   public String encoding(){
      return _encoding;
   }

   //============================================================
   // <T>打开文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void openFile(String fileName){
      openFile(fileName, _encoding);
   }

   //============================================================
   // <T>打开文件。</T>
   //
   // @param fileName 文件名称
   // @param encoding 文本编码
   //============================================================
   public void openFile(String fileName,
                        String encoding){
      // 检查文件有效性
      File file = new File(fileName);
      if(!file.exists()){
         throw new FFatalError("File is not exists. (file_name={1})", fileName);
      }
      if(!file.isFile()){
         throw new FFatalError("File is not file. (file_name={1})", fileName);
      }
      // 设置参数
      _fileName = fileName;
      _encoding = encoding;
      // 打开文件
      InputStreamReader reader = null;
      try{
         _inputStream = new FileInputStream(fileName);
         reader = new InputStreamReader(_inputStream, _encoding);
         _reader = new BufferedReader(reader);
      }catch(Exception exception){
         // 关闭缓冲流
         if(_reader != null){
            try{
               _reader.close();
            }catch(Exception e){
               throw new FFatalError(e, "openFile", "Close file reader failure. (fileName={1}, encoding={2})", fileName, encoding);
            }
         }
         // 关闭读取流
         if(reader != null){
            try{
               reader.close();
            }catch(Exception e){
               throw new FFatalError(e, "openFile", "Close file stream reader failure. (fileName={1}, encoding={2})", fileName, encoding);
            }
         }
         // 关闭输入流
         if(_inputStream != null){
            try{
               _inputStream.close();
            }catch(Exception e){
               throw new FFatalError(e, "openFile", "Close file input failure. (fileName={1}, encoding={2})", fileName, encoding);
            }
         }
         // 例外处理
         throw new FFatalError(exception, "openFile", "Open file failure. (fileName={1}, encoding={2})", fileName, encoding);
      }
   }

   //============================================================
   // <T>打开输入流。</T>
   //
   // @param inputStream 输入流
   //============================================================
   public void openStream(InputStream inputStream){
      openStream(inputStream, _encoding);
   }

   //============================================================
   // <T>打开输入流。</T>
   //
   // @param inputStream 输入流
   // @param encoding 文本编码
   //============================================================
   public void openStream(InputStream inputStream,
                          String encoding){
      InputStreamReader reader = null;
      try{
         _inputStream = inputStream;
         reader = new InputStreamReader(inputStream, encoding);
         _reader = new BufferedReader(reader);
      }catch(Exception exception){
         // 关闭缓冲流
         if(_reader != null){
            try{
               _reader.close();
            }catch(Exception e){
               throw new FFatalError(e, "openStream", "Close stream reader failure. (encoding={1})", encoding);
            }
         }
         // 关闭读取流
         if(reader != null){
            try{
               reader.close();
            }catch(Exception e){
               throw new FFatalError(e, "openStream", "Close stream stream reader failure. (encoding={1})", encoding);
            }
         }
         throw new FFatalError(exception, "openStream", "Open stream failure. (charset={1})", encoding);
      }
   }

   //============================================================
   // <T>读取一个字符。</T>
   //
   // @return 字符
   //============================================================
   public int read(){
      try{
         return _reader.read();
      }catch(Exception e){
         throw new FFatalError(e, "read", "Read failure.");
      }
   }

   //============================================================
   // <T>读取一行字符串。</T>
   //
   // @return 字符串
   //============================================================
   public String readLine(){
      try{
         return _reader.readLine();
      }catch(Exception e){
         throw new FFatalError(e, "readLine", "Read line failure.");
      }
   }

   //============================================================
   // <T>读取一行字符串。</T>
   //
   // @return 字符串
   //============================================================
   public FByteStream toByteStream(){
      FByteStream stream = new FByteStream();
      try{
         byte[] data = new byte[4096];
         while(true){
            int readed = _inputStream.read(data);
            if(readed > 0){
               stream.append(data, 0, readed);
            }else{
               break;
            }
         }
      }catch(Exception e){
         throw new FFatalError(e, "toStream", "Convert byte stream failure.");
      }
      return stream;
   }

   //============================================================
   // <T>关闭处理。</T>
   //============================================================
   @Override
   public void close(){
      if(_reader != null){
         try{
            _reader.close();
         }catch(Exception e){
            throw new FFatalError(e, "close", "Close file failure.");
         }
      }
   }
}
