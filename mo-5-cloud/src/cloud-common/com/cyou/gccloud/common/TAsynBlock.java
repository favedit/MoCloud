package com.cyou.gccloud.common;

import java.util.LinkedList;
import java.util.Queue;

public class TAsynBlock<T>
{
   private Queue<T> _listReceive;

   private Queue<T> _listSend;

   public TAsynBlock(){
      _listReceive = newQueue();
      _listSend = newQueue();
   }

   public void offer(T value){
      synchronized(this){
         _listReceive.offer(value);
      }
   }

   public void addAll(Queue<T> queue){
      synchronized(this){
         _listReceive.addAll(queue);
      }
   }

   public T poll(){
      return _listSend.poll();
   }

   public Queue<T> pollAll(){
      if(_listSend.isEmpty()){
         return null;
      }else{
         Queue<T> tmp = _listSend;
         _listSend = newQueue();
         return tmp;
      }
   }

   public void swap(){
      synchronized(this){
         Queue<T> tmp = _listReceive;
         _listReceive = _listSend;
         _listSend = tmp;
      }
   }

   private Queue<T> newQueue(){
      return new LinkedList<T>();
   }
}
