package org.mo.core.aop.face;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//============================================================
// <T>代码描述器。</T>
//============================================================
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ASource{
}
