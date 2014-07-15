package org.mo.com.message;

import org.mo.com.lang.FObjects;
import org.mo.com.lang.FValidError;

//============================================================
// <T>消息集合。</T>
//============================================================
public class FMessages
      extends FObjects<IMessage>
{
   //============================================================
   // <T>构造消息集合。</T>
   //============================================================
   public FMessages(){
      super(IMessage.class);
   }

   //============================================================
   // <T>检查处理。</T>
   //============================================================
   public void check(){
      if(!isEmpty()){
         throw new FValidError();
      }
   }

   //============================================================
   // <T>判断是否含指定类型的消息。</T>
   //
   // @param clazz 类型
   // @return 是否含有
   //============================================================
   public boolean hasMessage(Class<?> clazz){
      int n = -1;
      while(++n < _count){
         if(_items[n].getClass().isAssignableFrom(clazz)){
            return true;
         }
      }
      return false;
   }

   //============================================================
   // <T>判断是否含有错误。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasError(){
      return hasMessage(FFatalMessage.class) || hasMessage(FErrorMessage.class);
   }

   //============================================================
   // <T>获得指定类型的消息个数。</T>
   //
   // @param clazz 类型
   // @return 个数
   //============================================================
   public int count(Class<?> clazz){
      int n = -1;
      int count = 0;
      while(++n < _count){
         if(_items[n].getClass().isAssignableFrom(clazz)){
            count++;
         }
      }
      return count;
   }

   //============================================================
   // <T>获得最大级别。</T>
   //
   // @return 最大级别
   //============================================================
   public EMessageLevel calculateMaxLevel(){
      if(hasMessage(FFatalMessage.class)){
         return EMessageLevel.Fatal;
      }
      if(hasMessage(FErrorMessage.class)){
         return EMessageLevel.Error;
      }
      if(hasMessage(FWarnMessage.class)){
         return EMessageLevel.Warn;
      }
      if(hasMessage(FInfoMessage.class)){
         return EMessageLevel.Info;
      }
      if(hasMessage(FDebugMessage.class)){
         return EMessageLevel.Debug;
      }
      return EMessageLevel.Success;
   }

   //============================================================
   // <T>获得指定类型的一个消息。</T>
   //
   // @param clazz 类型
   // @return 一个消息
   //============================================================
   @SuppressWarnings("unchecked")
   public <V extends IMessage> V message(Class<V> clazz){
      int n = -1;
      while(++n < _count){
         if(_items[n].getClass().isAssignableFrom(clazz)){
            return (V)_items[n];
         }
      }
      return null;
   }

   //============================================================
   // <T>获得指定类型的一个消息集合。</T>
   //
   // @param clazz 类型
   // @return 消息集合
   //============================================================
   public FMessages messages(Class<?> clazz){
      int n = -1;
      FMessages messages = new FMessages();
      while(++n < _count){
         if(_items[n].getClass().isAssignableFrom(clazz)){
            messages.push(_items[n]);
         }
      }
      return messages;
   }
}
