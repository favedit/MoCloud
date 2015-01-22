package org.mo.com.lang.generic;

import java.util.Iterator;

//============================================================
// <T>对象链表迭代器。</T>
//
// @type T 对象类型
//============================================================
public class FListIterator<T>
      implements
         Iterator<T>
{
   // 对象集合
   protected MList<T> _objects;

   // 开始节点
   protected SListEntry<T> _first;

   // 结束节点
   protected SListEntry<T> _last;

   // 当前节点
   protected SListEntry<T> _current;

   //============================================================
   // <T>构造对象链表迭代器。</T>
   //
   // @param objects 对象集合
   // @param offset 对象位置
   // @param count 对象总数
   //============================================================
   public FListIterator(MList<T> list,
                        SListEntry<T> first,
                        SListEntry<T> last){
      _objects = list;
      _first = first;
      _last = last;
   }

   //============================================================
   // <T>判断是否有下一个对象。</T>
   //
   // @return 是否有
   //============================================================
   @Override
   public boolean hasNext(){
      if(_current == null){
         return (_first != null);
      }
      return (_current != _last);
   }

   //============================================================
   // <T>>获得下一个对象。</T>
   //
   // @return 下一个对象
   //============================================================
   @Override
   public T next(){
      // 获得下一个内容
      if(_current == null){
         _current = _first;
      }else{
         _current = _current.next;
      }
      // 返回内容
      if(_current != null){
         return _current.value;
      }
      return null;
   }

   //============================================================
   // <T>移除当前对象。</T>
   //============================================================
   @Override
   public void remove(){
      //_objects.removeFirst();;
   }
}
