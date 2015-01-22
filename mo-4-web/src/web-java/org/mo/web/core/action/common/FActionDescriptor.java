package org.mo.web.core.action.common;

import java.lang.annotation.Annotation;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObject;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.core.face.AWebSession;

//============================================================
// <T>命令描述器。</T>
//============================================================
public class FActionDescriptor
      extends FObject
{
   // 类实例
   private Class<?> _clazz;

   // 会话的描述器
   protected AWebSession _sessionDescriptor;

   // 是否需要会话
   protected boolean _sessionRequire;

   // 登录的描述器
   protected AWebLogin _loginDescriptor;

   // 是否需要登录
   protected boolean _loginRequire;

   // 函数字典
   private FDictionary<FActionMethodDescriptor> _methods = new FDictionary<FActionMethodDescriptor>(FActionMethodDescriptor.class);

   //============================================================
   // <T>构造命令描述器。</T>
   //
   // @param clazz 类对象
   //============================================================
   public FActionDescriptor(Class<?> clazz){
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
   // <T>判断是否含有指定名称。</T>
   //
   // @param name 名称
   // @return 是否含有
   //============================================================
   public boolean contains(String name){
      return _methods.contains(name);
   }

   //============================================================
   // <T>根据函数名称查找函数描述器。</T>
   //
   // @param name 函数名称
   // @return 函数描述器
   //============================================================
   public FActionMethodDescriptor find(String name){
      return _methods.get(name);
   }

   //============================================================
   // <T>增加一个函数描述器。</T>
   //
   // @param methodName 函数名称
   // @param methodDescriptor 函数描述器
   //============================================================
   public void push(String methodName,
                    FActionMethodDescriptor methodDescriptor){
      methodDescriptor.setActionDescriptor(this);
      _methods.set(methodName, methodDescriptor);
   }
}
