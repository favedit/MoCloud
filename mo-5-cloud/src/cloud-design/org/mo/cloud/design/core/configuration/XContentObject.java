package org.mo.cloud.design.core.configuration;

import org.mo.com.lang.FObject;

//============================================================
// <T>内容对象。</T>
//
// @return 节点名称
//============================================================
public class XContentObject
      extends FObject
{
   // 类对象
   protected FContentClass _contentClass;

   // 子节点集合
   protected XContentObjects _children;

   //============================================================
   // <T>判断是否指定名称。</T>
   //
   // @return 名称
   //============================================================
   public boolean isName(String name){
      return name.equals(_contentClass.name());
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _contentClass.name();
   }

   //============================================================
   // <T>获得内容类对象。</T>
   //
   // @return 内容类对象
   //============================================================
   public FContentClass contentClass(){
      return _contentClass;
   }

   //============================================================
   // <T>设置内容类对象。</T>
   //
   // @param clazz 内容类对象
   //============================================================
   public void linkContentClass(FContentClass clazz){
      _contentClass = clazz;
   }

   //============================================================
   // <T>根据名称获得内容。</T>
   //
   // @param name 名称
   // @return 内容
   //============================================================
   public Object get(String name){
      FContentField field = _contentClass.findField(name);
      if(field != null){
         return field.get(this);
      }
      return null;
   }

   //============================================================
   // <T>根据名称设置内容。</T>
   //
   // @param name 名称
   // @param value 内容 
   //============================================================
   public void set(String name,
                   Object value){
      FContentField field = _contentClass.findField(name);
      if(field != null){
         field.set(this, value);
      }
   }

   //============================================================
   // <T>判断是否含有子节点。</T>
   //
   // @return 是否含有子节点
   //============================================================
   public boolean hasChild(){
      return (_children != null) ? !_children.isEmpty() : false;
   }

   //============================================================
   // <T>获得子节点集合。</T>
   //
   // @return 子节点集合
   //============================================================
   public XContentObjects children(){
      if(_children == null){
         _children = new XContentObjects();
      }
      return _children;
   }
}
