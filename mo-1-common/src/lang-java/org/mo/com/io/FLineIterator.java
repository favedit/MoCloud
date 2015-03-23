package org.mo.com.io;

import java.util.Iterator;
import org.mo.com.lang.FUnsupportMethodError;

//============================================================
// <T>字符串行读取迭代器。</T>
//
// @type T 对象类型
//============================================================
public class FLineIterator
      implements
         Iterator<String>
{
   // 读取器
   protected ILineReader _reader;

   //============================================================
   // <T>字符串行读取迭代器。</T>
   //
   // @param reader 读取器
   //============================================================
   public FLineIterator(ILineReader reader){
      _reader = reader;
   }

   //============================================================
   // <T>判断是否有下一个对象。</T>
   //
   // @return 是否有
   //============================================================
   @Override
   public boolean hasNext(){
      return _reader.hasNext();
   }

   //============================================================
   // <T>>获得下一个对象。</T>
   //
   // @return 下一个对象
   //============================================================
   @Override
   public String next(){
      return _reader.readLine();
   }

   //============================================================
   // <T>移除当前对象。</T>
   //============================================================
   @Override
   public void remove(){
      throw new FUnsupportMethodError();
   }
}
