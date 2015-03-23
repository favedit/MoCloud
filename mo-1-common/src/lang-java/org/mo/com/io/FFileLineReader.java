package org.mo.com.io;

import java.io.InputStream;
import java.util.Iterator;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>文本行读取器。</T>
//============================================================
public class FFileLineReader
      extends FFileReader
      implements
         ILineReader,
         Iterable<String>
{
   // 行字符串
   protected String _line;

   //============================================================
   // <T>构造文本行读取器。</T>
   //============================================================
   public FFileLineReader(){
   }

   //============================================================
   // <T>构造文本行读取器。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public FFileLineReader(String fileName){
      super(fileName);
   }

   //============================================================
   // <T>构造文本行读取器。</T>
   //
   // @param fileName 文件名称
   // @param encoding 文本编码
   //============================================================
   public FFileLineReader(String fileName,
                          String encoding){
      super(fileName, encoding);
   }

   //============================================================
   // <T>打开文件。</T>
   //
   // @param fileName 文件名称
   // @param encoding 文本编码
   //============================================================
   @Override
   public void openFile(String fileName,
                        String encoding){
      super.openFile(fileName, encoding);
      try{
         _line = _reader.readLine();
      }catch(Exception e){
         throw new FFatalError(e, "openFile", "Read file first line failure.");
      }
   }

   //============================================================
   // <T>打开输入流。</T>
   //
   // @param inputStream 输入流
   // @param encoding 文本编码
   //============================================================
   @Override
   public void openStream(InputStream inputStream,
                          String encoding){
      super.openStream(inputStream, encoding);
      try{
         _line = _reader.readLine();
      }catch(Exception e){
         throw new FFatalError(e, "openStream", "Read file first line failure.");
      }
   }

   //============================================================
   // <T>判断是否有下一行字符串。</T>
   //
   // @return 是否有
   //============================================================
   @Override
   public boolean hasNext(){
      return (_line != null);
   }

   //============================================================
   // <T>>获得下一行字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String readLine(){
      try{
         String line = _line;
         _line = _reader.readLine();
         return line;
      }catch(Exception e){
         throw new FFatalError(e, "readLine", "Read file line failure.");
      }
   }

   //============================================================
   // <T>获得迭代器。</T>
   //
   // @return 迭代器
   //============================================================
   @Override
   public Iterator<String> iterator(){
      return new FLineIterator(this);
   }
}
