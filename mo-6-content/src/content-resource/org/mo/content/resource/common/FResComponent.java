package org.mo.content.resource.common;

import org.mo.com.lang.FObjects;

//============================================================
// <T>资源组件。</T>
//============================================================
public class FResComponent
      extends FResObject
{
   // 父对象
   protected FResComponent _parent;

   // 组件集合
   protected FObjects<FResComponent> _components;

   //============================================================
   // <T>构造资源组件。</T>
   //============================================================
   public FResComponent(){
   }

   //============================================================
   // <T>获得父组件。</T>
   //
   // @return 父组件
   //============================================================
   public FResComponent parent(){
      return _parent;
   }

   //============================================================
   // <T>设置父组件。</T>
   //
   // @param parent 父组件
   //============================================================
   public void setParent(FResComponent parent){
      _parent = parent;
   }

   //============================================================
   // <T>判断是否含有组件。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasComponent(){
      return (_components != null) ? _components.isEmpty() : false;
   }

   //============================================================
   // <T>获得组件集合。</T>
   //
   // @return 组件集合
   //============================================================
   public FObjects<FResComponent> components(){
      return _components;
   }

   //============================================================
   // <T>增加一个组件。</T>
   //
   // @param component 组件
   //============================================================
   public void push(FResComponent component){
      if(_components == null){
         _components = new FObjects<FResComponent>(FResComponent.class);
      }
      component.setParent(this);
      _components.push(component);
   }

   //============================================================
   // <T>释放处理。</T>
   //============================================================
   public void dispose(){
      _parent = null;
      if(_components != null){
         _components.clear();
         _components = null;
      }
   }
}
