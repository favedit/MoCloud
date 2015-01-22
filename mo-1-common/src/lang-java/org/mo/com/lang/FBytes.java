package org.mo.com.lang;

import org.mo.com.lang.generic.MBytes;

//============================================================
// <T>字节类型集合。</T>
//============================================================
public class FBytes
      extends MBytes
{
   //============================================================
   // <T>构造字节类型集合。</T>
   //============================================================
   public FBytes(){
   }

   //============================================================
   // <T>构造字节类型集合。</T>
   //
   // @param capacity 容量
   //============================================================
   public FBytes(int capacity){
      super(capacity);
   }

   //============================================================
   // <T>构造字节类型集合。</T>
   //
   // @param data 数据集合
   //============================================================
   public FBytes(byte[] data){
      append(data);
   }

   //============================================================
   // <T>追加一个短整数。</T>
   //
   // @param value 短整数
   //============================================================
   public FBytes appendShort(short value){
      ensureSize(_length + 2);
      _memory[_length++] = (byte)value;
      _memory[_length++] = (byte)(value >>> 8);
      return this;
   }

   //============================================================
   // <T>追加一个短整数。</T>
   //
   // @param value 短整数
   //============================================================
   public FBytes appendShort(int value){
      ensureSize(_length + 2);
      _memory[_length++] = (byte)value;
      _memory[_length++] = (byte)(value >>> 8);
      return this;
   }

   //============================================================
   // <T>追加一个整数。</T>
   //
   // @param value 整数
   //============================================================
   public FBytes appendInteger(int value){
      ensureSize(_length + 4);
      _memory[_length++] = (byte)value;
      _memory[_length++] = (byte)(value >>> 8);
      _memory[_length++] = (byte)(value >>> 16);
      _memory[_length++] = (byte)(value >>> 24);
      return this;
   }

   //============================================================
   // <T>移除指定索引位置的定长数据。</T>
   //
   // @param index 索引位置 
   // @param length 长度
   //============================================================
   public void remove(int index,
                      int length){
      if(null != _memory){
         if(length <= 0){
            throw new FFatalError("Length is out range.");
         }
         if(index + length > _length){
            throw new FFatalError("Length is out range.");
         }
         int moved = _length - index - length;
         System.arraycopy(_memory, index + length, _memory, index, moved);
         _length -= length;
      }
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return new String(_memory, 0, _length);
   }
}
