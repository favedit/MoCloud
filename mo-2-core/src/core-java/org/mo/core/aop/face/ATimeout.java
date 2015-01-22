package org.mo.core.aop.face;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.mo.core.aop.config.EComponentScope;

//============================================================
// <T>超时描述器。</T>
//============================================================
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ATimeout{
   //============================================================
   // <T>范围类型。</T>
   //============================================================
   EComponentScope scopeCd() default EComponentScope.Session;

   //============================================================
   // <T>时长描述。</T>
   //============================================================
   int interval() default 0;
}
