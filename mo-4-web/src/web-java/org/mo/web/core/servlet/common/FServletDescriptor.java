package org.mo.web.core.servlet.common;

import java.lang.annotation.Annotation;
import org.mo.com.lang.FDictionary;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.core.face.AWebSession;

//============================================================
// <T>网络处理描述器。</T>
//============================================================
public class FServletDescriptor
{
   // 类实例
   protected Class<?> _clazz;

   // 会话的描述器
   protected AWebSession _sessionDescriptor;

   // 是否需要会话
   protected boolean _sessionRequire;

   // 登录的描述器
   protected AWebLogin _loginDescriptor;

   // 是否需要登录
   protected boolean _loginRequire;

   // 函数字典
   private FDictionary<FServletMethodDescriptor> _methods = new FDictionary<FServletMethodDescriptor>(FServletMethodDescriptor.class);

   //============================================================
   // <T>构造服务描述器。</T>
   //
   // @param clazz 类对象
   //============================================================
   public FServletDescriptor(Class<?> clazz){
      _clazz = clazz;
      build();
   }

   //============================================================
   // <T>建立内部信息。</T>
   //============================================================
   protected void build(){
      // 获得函数的描述器
      Annotation[] methodAnnotations = _clazz.getAnnotations();
      if(methodAnnotations != null){
         for(Annotation annotation : methodAnnotations){
            if(annotation instanceof AWebSession){
               _sessionDescriptor = (AWebSession)annotation;
               _sessionRequire = _sessionDescriptor.require();

            }else if(annotation instanceof AWebLogin){
               _loginDescriptor = (AWebLogin)annotation;
               _loginRequire = _loginDescriptor.require();
            }
         }
      }
   }

   //============================================================
   // <T>获得会话描述器。</T>
   //
   // @return 会话描述器
   //============================================================
   public AWebSession sessionDescriptor(){
      return _sessionDescriptor;
   }

   //============================================================
   // <T>获得是否需要会话。</T>
   //
   // @return 是否需要
   //============================================================
   public boolean sessionRequire(){
      return _sessionRequire;
   }

   //============================================================
   // <T>获得登录描述器。</T>
   //
   // @return 登录描述器
   //============================================================
   public AWebLogin loginDescriptor(){
      return _loginDescriptor;
   }

   //============================================================
   // <T>获得是否需要登录。</T>
   //
   // @return 是否需要
   //============================================================
   public boolean loginRequire(){
      return _loginRequire;
   }

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
   // @param methodDescriptor 描述器
   //============================================================
   public void push(String method,
                    FServletMethodDescriptor methodDescriptor){
      methodDescriptor.setServletDescriptor(this);
      _methods.set(method, methodDescriptor);
   }
}
