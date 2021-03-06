package org.mo.com.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>字段对象工具类。</T>
//============================================================
public class FField
{
   // 字段对象
   protected Field _field;

   // 描述对象集合
   protected FAnnotation[] _annotations;

   // 类对象
   protected FClass<?> _type;

   //============================================================
   // <T>构造字段对象工具类。</T>
   //
   // @param field 字段对象
   //============================================================
   public FField(Field field){
      _field = field;
   }

   //============================================================
   // <T>获得本地对象。</T>
   //
   // @return 本地对象
   //============================================================
   public Field nativeObject(){
      return _field;
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _field.getName();
   }

   //============================================================
   // <T>判断是否为静态。</T>
   //
   // @return 是否为静态
   //============================================================
   public boolean isStatic(){
      int modifiers = _field.getModifiers();
      return (modifiers & Modifier.STATIC) == Modifier.STATIC;
   }

   //============================================================
   // <T>获得描述集合。</T>
   //
   // @return 描述集合
   //============================================================
   public FAnnotation[] annotations(){
      if(null == _annotations){
         try{
            Annotation[] annotations = _field.getAnnotations();
            int count = annotations.length;
            _annotations = new FAnnotation[count];
            for(int n = 0; n < count; n++){
               _annotations[n] = new FAnnotation(annotations[n]);
            }
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }
      return _annotations;
   }

   //============================================================
   // <T>获得类对象。</T>
   //
   // @return 类对象
   //============================================================
   public FClass<?> type(){
      if(null == _type){
         _type = RClass.find(_field.getType());
      }
      return _type;
   }

   //============================================================
   // <T>是否存在指定类对象的描述定义。</T>
   //
   // @param clazz 类对象
   // @return 是否存在
   //============================================================
   public boolean hasAnnotation(Class<?> clazz){
      for(FAnnotation annotation : annotations()){
         if(annotation.isClass(clazz)){
            return true;
         }
      }
      return false;
   }

   //============================================================
   // <T>查找指定类对象的描述定义。</T>
   //
   // @param clazz 类对象
   // @return 描述定义
   //============================================================
   public FAnnotation findAnnotation(Class<?> clazz){
      for(FAnnotation annotation : annotations()){
         if(annotation.isClass(clazz)){
            return annotation;
         }
      }
      return null;
   }

   //============================================================
   // <T>查找指定类对象的描述定义。</T>
   //
   // @param clazz 类对象
   // @return 描述定义
   //============================================================
   public <C extends Annotation> C getAnnotation(Class<C> clazz){
      return _field.getAnnotation(clazz);
   }

   //============================================================
   // <T>设置是否可以访问。</T>
   //
   // @param accessible 是否可以访问
   //============================================================
   public void setAccessible(boolean accessible){
      _field.setAccessible(accessible);
   }

   //============================================================
   // <T>获得实例内容。</T>
   //
   // @param instance 实例
   // @return 内容
   //============================================================
   public Object get(Object instance){
      try{
         return _field.get(instance);
      }catch(Exception e){
         throw new FFatalError(e, "Get value failure. (instance={1}, name={2})", instance, _field.getName());
      }
   }

   //============================================================
   // <T>设置实例内容。</T>
   //
   // @param instance 实例
   // @param value 内容
   //============================================================
   public void set(Object instance,
                   Object value){
      try{
         _field.set(instance, value);
      }catch(Exception e){
         throw new FFatalError(e, "Set value failure. (instance={1}, value={2})", instance, value);
      }
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return _field.getName();
   }
}
