package org.mo.com.lang.generic;

//============================================================
// <T>长整数代码入口。</T>
//============================================================
public class SCodeLongEntry
{
   // 下个入口
   public SCodeLongEntry next;

   // 代码
   public long code;

   // 内容
   public Object value;

   //============================================================
   // <T>长整数代码入口。</T>
   //
   // @param hash 哈希值
   // @param index 索引
   // @param next 下个入口
   //============================================================
   public SCodeLongEntry(SCodeLongEntry next,
                         long code,
                         Object value){
      this.next = next;
      this.code = code;
      this.value = value;
   }

   //============================================================
   // <T>清空处理。</T>
   //============================================================
   public void clear(){
      next = null;
      value = null;
   }
}
