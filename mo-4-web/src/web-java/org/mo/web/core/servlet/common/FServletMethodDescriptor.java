package org.mo.web.core.servlet.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.mo.com.lang.FFatalError;
import org.mo.web.core.container.AContainer;

//============================================================
// <T>网页处理函数描述器。</T>
//============================================================
public class FServletMethodDescriptor
{
   // 函数
   protected Method _method;

   // 表单信息集合
   protected AContainer[] _forms;

   // 类型集合
   protected Class<?>[] _types;

   //============================================================
   // <T>构造网页处理函数描述器。</T>
   //
   // @param method 函数
   //============================================================
   public FServletMethodDescriptor(Method method){
      _method = method;
      build();
   }

   //============================================================
   // <T>建立处理。</T>
   //============================================================
   protected void build(){
      _types = _method.getParameterTypes();
      _forms = new AContainer[_types.length];
      Annotation[][] annos = _method.getParameterAnnotations();
      for(int n = 0; n < _types.length; n++){
         for(Annotation anno : annos[n]){
            if(anno instanceof AContainer){
               _forms[n] = (AContainer)anno;
               break;
            }
         }
      }
   }

   //============================================================
   // <T>获得表单信息集合。</T>
   //
   // @return 表单信息集合
   //============================================================
   public AContainer[] forms(){
      return _forms;
   }

   //============================================================
   // <T>获得类型信息集合。</T>
   //
   // @return 类型信息集合
   //============================================================
   public Class<?>[] types(){
      return _types;
   }

   //============================================================
   // <T>调用函数处理。</T>
   //
   // @param action 命令对象
   // @param params 参数集合
   // @return 处理结果
   //============================================================
   public String invoke(Object action,
                        Object[] params){
      try{
         return (String)_method.invoke(action, params);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }
}
