package org.mo.com.lang.type;

//============================================================
// <T>64位整数数据。</T>
//
// @history 130220 创建
//============================================================
public class TInt64
      extends MType
{
   // 存储内容
   protected int _value;

   //============================================================
   // <T>构造64位整数数据。</T>
   //============================================================
   public TInt64(){
   }

   //============================================================
   // <T>构造64位整数数据。</T>
   //
   // @param value 整数数据内容
   //============================================================
   public TInt64(int value){
      _value = value;
   }

   //============================================================
   // <T>获得整数数据内容。</T>
   //
   // @return 整数数据内容
   //============================================================
   public int get(){
      return _value;
   }

   //============================================================
   // <T>设置整数数据内容。</T>
   //
   // @param value 整数数据内容
   //============================================================
   public void set(int value){
      _value = value;
   }

   //============================================================
   // <T>以字符串方式，获得数据内容。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return Integer.toString(_value);
   }
}
