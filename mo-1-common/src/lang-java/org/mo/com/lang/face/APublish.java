package org.mo.com.lang.face;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//============================================================
// <T>可发布描述。</T>
//============================================================
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD})
public @interface APublish{
   //============================================================
   // <T>发布版本。</T>
   //============================================================
   String version() default "";
}
