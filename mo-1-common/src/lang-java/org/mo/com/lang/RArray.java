package org.mo.com.lang;

import java.lang.reflect.Array;

//============================================================
// <T>数组工具类。</T>
//============================================================
public class RArray
{
   //============================================================
   // <T>创建指定长度的新数组。</T>
   //
   // @param clazz 类对象
   // @param capacity 新数组容量
   // @return 新数组
   //============================================================
   @SuppressWarnings("unchecked")
   public static <V> V[] newInstance(Class<V> clazz,
                                     int capacity){
      return (V[])Array.newInstance(clazz, capacity);
   }

   //============================================================
   // <T>创建指定长度的新数组。</T>
   //
   // @param clazz 类对象
   // @param memory 内存
   // @param offset 位置
   // @param length 长度
   // @return 新数组
   //============================================================
   @SuppressWarnings("unchecked")
   public static <V> V[] sub(Class<V> clazz,
                             V[] memory,
                             int offset,
                             int length){
      V[] alloc = (V[])Array.newInstance(clazz, length);
      if(memory != null){
         System.arraycopy(memory, offset, alloc, 0, length);
      }
      return alloc;
   }

   //============================================================
   // <T>复制数组中的一部分成为新的数组。</T>
   //
   // @param memory 数组
   // @param offset 数组位置
   // @param length 数组长度
   //============================================================
   public static <V> V[] copy(V[] memory,
                              int offset,
                              int length){
      return copy(memory, offset, length, null, -1);
   }

   //============================================================
   // <T>复制数组中的一部分成为新的数组。</T>
   //
   // @param memory 数组
   // @param offset 数组位置
   // @param length 数组长度
   // @param capacity 新数组容量
   //============================================================
   public static <V> V[] copy(V[] memory,
                              int offset,
                              int length,
                              int capacity){
      return copy(memory, offset, length, null, capacity);
   }

   //============================================================
   // <T>复制数组中的一部分成为新的数组。</T>
   //
   // @param memory 数组
   // @param offset 数组位置
   // @param length 数组长度
   // @param clazz 类对象
   //============================================================
   public static <V> V[] copy(V[] memory,
                              int offset,
                              int length,
                              Class<?> clazz){
      return copy(memory, offset, length, clazz, -1);
   }

   //============================================================
   // <T>复制数组中的一部分成为新的数组。</T>
   //
   // @param memory 数组
   // @param offset 数组位置
   // @param length 数组长度
   // @param clazz 类对象
   // @param capacity 新数组容量
   //============================================================
   @SuppressWarnings("unchecked")
   public static <V> V[] copy(V[] memory,
                              int offset,
                              int length,
                              Class<?> clazz,
                              int capacity){
      // 检查参数
      if(null == memory){
         throw new NullPointerException("memory");
      }
      // 设置类对象
      if(null == clazz){
         clazz = memory.getClass().getComponentType();
      }
      // 设置容量
      if(capacity < 0){
         capacity = length;
      }
      // 创建数组
      V[] alloc = (V[])Array.newInstance(clazz, capacity);
      // 如果存在数据，则复制数据
      if(null != memory){
         System.arraycopy(memory, offset, alloc, 0, length);
      }
      return alloc;
   }

   //============================================================
   // <T>压缩数组中空内容，生成一个新数据组。</T>
   //
   // @param clazz 类对象
   // @param memory 数组
   // @param offset 数组位置
   // @param length 数组长度
   //============================================================
   @SuppressWarnings("unchecked")
   public static <V> V[] compress(Class<V> clazz,
                                  V[] memory,
                                  int offset,
                                  int length){
      V[] alloc = (V[])Array.newInstance(clazz, length);
      int index = 0;
      int total = offset + length;
      for(int n = offset; n < total; n++){
         if(memory[n] != null){
            alloc[index] = memory[n];
         }
      }
      V[] result = (V[])Array.newInstance(clazz, index);
      System.arraycopy(alloc, 0, result, 0, index);
      return result;
   }

   //==========================================================
   // <T>对值对快速排序。</T>
   //
   // @method
   // @param names:Array 名称数组
   // @param values:Array 内容数组
   // @param begin:Integer 开始位置
   // @param end:Integer 结束位置
   // @param comparer:Function 比较器
   // @param parameters:Object 参数
   //==========================================================
   public static <N, V> int pairSortMid(N[] names,
                                        V[] values,
                                        int begin,
                                        int end,
                                        IObjectComparable<N> comparer,
                                        Object parameters){
      N name = names[begin];
      V value = null;
      if(values != null){
         value = values[begin];
      }
      while(begin < end){
         while((begin < end) && comparer.compare(names[end], name, parameters) >= 0){
            end--;
         }
         names[begin] = names[end];
         if(values != null){
            values[begin] = values[end];
         }
         while((begin < end) && comparer.compare(names[begin], name, parameters) <= 0){
            begin++;
         }
         names[end] = names[begin];
         if(values != null){
            values[end] = values[begin];
         }
      }
      names[begin] = name;
      if(values != null){
         values[begin] = value;
      }
      return begin;
   }

   //==========================================================
   // <T>对值对快速排序。</T>
   //
   // @method
   // @param names:Array 名称数组
   // @param values:Array 内容数组
   // @param begin:Integer 开始位置
   // @param end:Integer 结束位置
   // @param comparer:Function 比较器
   // @param parameters:Object 参数
   //==========================================================
   public static <N, V> void pairSortSub(N[] names,
                                         V[] values,
                                         int begin,
                                         int end,
                                         IObjectComparable<N> comparer,
                                         Object parameters){
      if(begin < end){
         int mid = pairSortMid(names, values, begin, end, comparer, parameters);
         pairSortSub(names, values, begin, mid - 1, comparer, parameters);
         pairSortSub(names, values, mid + 1, end, comparer, parameters);
      }
   }

   //==========================================================
   // <T>对值对快速排序。</T>
   //
   // @method
   // @param names:Array 名称数组
   // @param values:Array 内容数组
   // @param offset:Integer 位置
   // @param count:Integer 总数
   // @param comparer:Function 比较器
   // @param parameters:Object 参数
   //==========================================================
   public static <N, V> void pairSort(N[] names,
                                      V[] values,
                                      int offset,
                                      int count,
                                      IObjectComparable<N> comparer,
                                      Object parameters){
      int begin = offset;
      int end = offset + count - 1;
      pairSortSub(names, values, begin, end, comparer, parameters);
   }
}
