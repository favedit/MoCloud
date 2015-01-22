package org.mo.com.collections;

import org.mo.com.lang.generic.MCodeLongSet;

//============================================================
// <T>长整数代码集合。</T>
//============================================================
public class FCodeLongSet<V>
      extends MCodeLongSet<V>
{
   //============================================================
   // <T>构造长整数代码集合。</T>
   //
   // @param clazz 类对象
   //============================================================
   public FCodeLongSet(Class<V> clazz){
      super(clazz);
   }

   //============================================================
   // <T>构造长整数代码集合。</T>
   //
   // @param clazz 类对象
   // @param capacity 容量
   //============================================================
   public FCodeLongSet(Class<V> clazz,
                       int capacity){
      super(clazz, capacity);
   }
}
