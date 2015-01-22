package org.mo.web.core.servlet.common;

import org.mo.com.lang.FDictionary;

//============================================================
// <T>网页处理描述器。</T>
//============================================================
public class FServletDescriptor
{
   // 函数字典
   private FDictionary<FServletMethodDescriptor> _methods = new FDictionary<FServletMethodDescriptor>(FServletMethodDescriptor.class);

   //============================================================
   // <T>是否容纳指定名称的函数。</T>
   //
   // @param name 名称
   // @return 是否容纳
   //============================================================
   public boolean contains(String name){
      return _methods.contains(name);
   }

   //============================================================
   // <T>根据函数名称查找函数描述器。</T>
   //
   // @param method 名称
   // @return 函数描述器
   //============================================================
   public FServletMethodDescriptor find(String method){
      return _methods.get(method);
   }

   //============================================================
   // <T>根据函数名称查找函数描述器。</T>
   //
   // @param method 函数名称
   // @param descriptor 描述器
   //============================================================
   public void push(String method,
                    FServletMethodDescriptor descriptor){
      _methods.set(method, descriptor);
   }
}
