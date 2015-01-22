package org.mo.com.lang.generic;

import org.mo.com.lang.FObject;
import org.mo.com.lang.RDump;

//============================================================
// <T>长整数代码集合。</T>
//============================================================
public abstract class MCodeLongSet<V>
      extends FObject
{
   // 扩展容量
   public static final int CAPACITY = 8;

   // 类对象
   protected Class<V> _class;

   // 总数
   protected int _count;

   // 哈希集合
   protected SCodeLongEntry[] _table;

   //============================================================
   // <T>构造长整数代码集合。</T>
   //
   // @param clazz 类对象
   //============================================================
   public MCodeLongSet(Class<V> clazz){
      _class = clazz;
   }

   //============================================================
   // <T>构造长整数代码集合。</T>
   //
   // @param clazz 类对象
   // @param capacity 容量
   //============================================================
   public MCodeLongSet(Class<V> clazz,
                       int capacity){
      _class = clazz;
      ensureSize(Math.max(capacity, CAPACITY));
   }

   //============================================================
   // <T>重新改变入口集合缓冲大小。</T>
   //============================================================
   protected void innerResize(){
      // 收集内存
      int index = 0;
      int length = _table.length;
      long size = length << 2;
      SCodeLongEntry[] memory = new SCodeLongEntry[(int)size];
      // 重置链表
      SCodeLongEntry entry = null;
      SCodeLongEntry next = null;
      for(int n = 0; n < length; n++){
         entry = _table[n];
         while(entry != null){
            index = (int)(entry.code % size);
            // 存储节点
            next = entry.next;
            entry.next = memory[index];
            memory[index] = entry;
            entry = next;
         }
         _table[n] = null;
      }
      // 保存内存
      _table = memory;
   }

   //============================================================
   // <T>确保集合有指定大小的容量。</T>
   //
   // @param size 总数
   //============================================================
   public void ensureSize(int size){
      int total = Math.max(size, CAPACITY);
      if(_table == null){
         // 创建缓冲
         _table = new SCodeLongEntry[total];
      }else if(total > _table.length){
         // 调整大小
         innerResize();
      }
   }

   //============================================================
   // <T>判断是否为空。</T>
   //
   // @return 是否为空
   //============================================================
   public boolean isEmpty(){
      return (_count == 0);
   }

   //============================================================
   // <T>获得总数。</T>
   //
   // @return 总数
   //============================================================
   public int count(){
      return _count;
   }

   //============================================================
   // <T>是否存在指定内容。</T>
   //
   // @param code 代码
   // @return 是否存在
   //============================================================
   public boolean contains(long code){
      if(_count > 0){
         long size = _table.length;
         int index = (int)(code % size);
         SCodeLongEntry entry = _table[index];
         while(entry != null){
            if(entry.code == code){
               return true;
            }
            entry = entry.next;
         }
      }
      return false;
   }

   //============================================================
   // <T>根据代码获得内容。</T>
   //
   // @param code 代码
   // @return 内容
   //============================================================
   @SuppressWarnings("unchecked")
   public V get(long code){
      if(_count > 0){
         long size = _table.length;
         int index = (int)(code % size);
         SCodeLongEntry entry = _table[index];
         while(entry != null){
            if(entry.code == code){
               return (V)entry.value;
            }
            entry = entry.next;
         }
      }
      return null;
   }

   //============================================================
   // <T>根据代码设置内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void set(long code,
                   V value){
      // 设置内容
      if(_table != null){
         long size = _table.length;
         int index = (int)(code % size);
         SCodeLongEntry entry = _table[index];
         while(entry != null){
            if(entry.code == code){
               entry.value = value;
               return;
            }
            entry = entry.next;
         }
      }
      // 调整大小
      ensureSize(_count);
      int index = (int)(code % _table.length);
      // 创建节点
      _count++;
      _table[index] = new SCodeLongEntry(_table[index], code, value);
   }

   //============================================================
   // <T>清除全部数据内容。</T>
   //============================================================
   public void clear(){
      if(_table != null){
         SCodeLongEntry entry = null;
         SCodeLongEntry next = null;
         int length = _table.length;
         for(int n = 0; n < length; n++){
            entry = _table[n];
            while(entry != null){
               next = entry.next;
               entry.clear();
               entry = next;
            }
            _table[n] = null;
         }
      }
      _count = 0;
      _table = null;
   }

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   @SuppressWarnings("unchecked")
   public TDumpInfo dump(TDumpInfo info){
      RDump.dump(info, this);
      info.append(" [ count=" + _count + " ]");
      if(_count > 0){
         info.append(" {\n");
         int length = _table.length;
         for(int n = 0; n < length; n++){
            SCodeLongEntry entry = _table[n];
            while(entry != null){
               V value = (V)entry.value;
               RDump.dump(info, Long.toString(entry.code), value);
               entry = entry.next;
            }
         }
         info.append("}");
      }
      return info;
   }
}
