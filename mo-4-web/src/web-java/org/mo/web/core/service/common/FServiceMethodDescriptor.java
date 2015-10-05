package org.mo.web.core.service.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.mo.com.data.ASqlConnect;
import org.mo.com.lang.FError;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.face.AWebAuthority;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.core.face.AWebRole;
import org.mo.web.core.face.AWebSession;

//============================================================
// <T>服务函数描述器。</T>
//============================================================
public class FServiceMethodDescriptor
      extends FObject
{
   // 服务描述器
   protected FServiceDescriptor _serviceDescriptor;

   // 调用函数对象
   protected Method _method;

   // 会话的描述器
   protected AWebSession _sessionDescriptor;

   // 是否需要会话
   protected boolean _sessionRequire;

   // 登录的描述器
   protected AWebLogin _loginDescriptor;

   // 角色描述器
   protected AWebRole _role;

   // 权限描述器
   protected AWebAuthority _authority;

   // 是否需要登录
   protected boolean _loginRequire;

   // 表单描述器数组
   protected AContainer[] _forms;

   // 类描述对象
   protected Class<?>[] _types;

   // 数据链接数组
   protected ASqlConnect[] _sqlConnects;

   //============================================================
   // <T>构造服务函数描述器。</T>
   //============================================================
   public FServiceMethodDescriptor(){
   }

   //============================================================
   // <T>建立内部信息。</T>
   //
   // @param method 函数
   //============================================================
   public void build(Method method){
      _method = method;
      _sessionRequire = _serviceDescriptor.sessionRequire();
      _loginRequire = _serviceDescriptor.loginRequire();
      // 获得函数的描述器
      Annotation[] methodAnnotations = _method.getAnnotations();
      if(methodAnnotations != null){
         for(Annotation annotation : methodAnnotations){
            if(annotation instanceof AWebSession){
               _sessionDescriptor = (AWebSession)annotation;
               _sessionRequire = _sessionDescriptor.require();
            }else if(annotation instanceof AWebLogin){
               _loginDescriptor = (AWebLogin)annotation;
               _loginRequire = _loginDescriptor.require();
            }else if(annotation instanceof AWebRole){
               _role = (AWebRole)annotation;
            }else if(annotation instanceof AWebAuthority){
               _authority = (AWebAuthority)annotation;
            }
         }
      }
      // 获得函数的参数信息
      _types = _method.getParameterTypes();
      int typeCount = _types.length;
      _forms = new AContainer[typeCount];
      _sqlConnects = new ASqlConnect[typeCount];
      // 获得函数的参数描述器
      Annotation[][] annos = _method.getParameterAnnotations();
      for(int n = 0; n < typeCount; n++){
         for(Annotation anno : annos[n]){
            if(anno instanceof AContainer){
               _forms[n] = (AContainer)anno;
               break;
            }
            if(anno instanceof ASqlConnect){
               _sqlConnects[n] = (ASqlConnect)anno;
               break;
            }
         }
      }
   }

   //============================================================
   // <T>获得服务描述器。</T>
   //
   // @return 服务描述器
   //============================================================
   public FServiceDescriptor serviceDescriptor(){
      return _serviceDescriptor;
   }

   //============================================================
   // <T>设置服务描述器。</T>
   //
   // @param serviceDescriptor 服务描述器
   //============================================================
   public void setServiceDescriptor(FServiceDescriptor serviceDescriptor){
      _serviceDescriptor = serviceDescriptor;
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
   // <T>获得角色描述器。</T>
   //
   // @return 角色描述器
   //============================================================
   public AWebRole role(){
      return _role;
   }

   //============================================================
   // <T>获得权限描述器。</T>
   //
   // @return 权限描述器
   //============================================================
   public AWebAuthority authority(){
      return _authority;
   }

   //============================================================
   // <T>获得类型描述器集合。</T>
   //
   // @return 类型描述器集合
   //============================================================
   public Class<?>[] types(){
      return _types;
   }

   //============================================================
   // <T>获得表单描述器集合。</T>
   //
   // @return 表单描述器集合
   //============================================================
   public AContainer[] forms(){
      return _forms;
   }

   //============================================================
   // <T>获得数据链接描述器集合。</T>
   //
   // @return 链接描述器集合
   //============================================================
   public ASqlConnect[] sqlConnects(){
      return _sqlConnects;
   }

   //============================================================
   // <T>函数调用处理。</T>
   //
   // @param instance 实例
   // @param params 参数集合
   // @return 处理结果
   //============================================================
   public Object invoke(Object instance,
                        Object[] params){
      try{
         return _method.invoke(instance, params);
      }catch(Exception exception){
         // 获得原始例外
         Throwable throwable = null;
         if(exception instanceof InvocationTargetException){
            throwable = ((InvocationTargetException)exception).getTargetException();
         }else{
            throwable = exception;
         }
         // 产生新例外
         FError error = null;
         if(throwable instanceof FError){
            error = (FError)throwable;
         }else{
            error = new FFatalError(exception);
         }
         throw error;
      }
   }
}
