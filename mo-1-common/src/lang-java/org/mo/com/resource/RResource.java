package org.mo.com.resource;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.reflect.RClass;

//============================================================
// <T>资源管理器。</T>
//============================================================
public class RResource
{
   // 资源字典
   private static FResourceDictionary _resources = new FResourceDictionary();

   //============================================================
   // <T>获得类关联的资源对象。</T>
   //
   // @param clazz 类对象
   // @return 资源对象
   //============================================================
   private static IResource innerBuild(Class<?> clazz){
      FResource resource = new FResource();
      String name = clazz.getName();
      try{
         resource.construct(clazz);
      }catch(Exception exception){
         throw new FFatalError(exception, "Find resource for class failure. (class={1})", name);
      }
      _resources.set(name, resource);
      return resource;
   }

   //============================================================
   // <T>获得指定名称的资源对象。</T>
   //
   // @param name 名称
   // @return 资源对象
   //============================================================
   public static synchronized IResource find(String name){
      IResource resource = _resources.find(name);
      if(resource == null){
         // 获得类对象
         Class<?> clazz = RClass.findClass(name);
         if(clazz == null){
            throw new FFatalError("No found resource class. (class={1})", name);
         }
         // 建立资源对象
         resource = innerBuild(clazz);
      }
      return resource;
   }

   //============================================================
   // <T>获得类关联的资源对象。</T>
   //
   // @param clazz 类对象
   // @return 资源对象
   //============================================================
   public static synchronized IResource find(Class<?> clazz){
      String name = clazz.getName();
      IResource resource = _resources.find(name);
      if(resource == null){
         // 建立资源对象
         resource = innerBuild(clazz);
      }
      return resource;
   }
}
