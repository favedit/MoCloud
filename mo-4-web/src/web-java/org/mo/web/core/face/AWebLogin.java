package org.mo.web.core.face;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//============================================================
// <T>描述指定类或函数是否需要用户登录验证的描述器。</T>
//============================================================
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AWebLogin{
   //============================================================
   // <T>是否需要用户登录校验。</T>
   //============================================================
   boolean require() default true;
}
