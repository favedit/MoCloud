package org.mo.web.core.servlet.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.mo.com.lang.FFatalError;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.face.AWebAuthority;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.core.face.AWebRole;
import org.mo.web.core.face.AWebSession;

//============================================================
// <T>网页处理函数描述器。</T>
//============================================================
public class FServletMethodDescriptor
{
   // 服务描述器
   protected FServletDescriptor _servletDescriptor;

   // 函数
   protected Method _method;

   // 会话的描述器
   protected AWebSession _sessionDescriptor;

   // 是否需要会话
   protected boolean _sessionRequire;

   // 登录的描述器
   protected AWebLogin _loginDescriptor;

   // 是否需要登录
   protected boolean _loginRequire;

   // 角色描述器
   protected AWebRole _role;

   // 权限描述器
   protected AWebAuthority _authority;

   // 表单信息集合
   protected AContainer[] _forms;

   // 类型集合
   protected Class<?>[] _types;

   //============================================================
   // <T>构造网页处理函数描述器。</T>
   //
   // @param method 函数
   //============================================================
   public FServletMethodDescriptor(){
   }

   //============================================================
   // <T>建立内部信息。</T>
   //
   // @param method 函数
   //============================================================
   public void build(Method method){
      _method = method;
      _sessionRequire = _servletDescriptor.sessionRequire();
      _loginRequire = _servletDescriptor.loginRequire();
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
      _forms = new AContainer[_types.length];
      // 获得函数的参数描述器
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
   // <T>获得处理描述器。</T>
   //
   // @return 处理描述器
   //============================================================
   public FServletDescriptor servletDescriptor(){
      return _servletDescriptor;
   }

   //============================================================
   // <T>设置处理描述器。</T>
   //
   // @param servletDescriptor 处理描述器
   //============================================================
   public void setServletDescriptor(FServletDescriptor servletDescriptor){
      _servletDescriptor = servletDescriptor;
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
