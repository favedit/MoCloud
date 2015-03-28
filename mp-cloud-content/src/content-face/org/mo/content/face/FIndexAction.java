package org.mo.content.face;

import org.mo.content.core.person.IAccountConsole;
import org.mo.core.aop.face.ALink;
import org.mo.eng.data.common.ISqlContext;

//============================================================
//<P>用户逻辑实现类</P>
//
//@class FPersonAction
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public class FIndexAction
      implements
         IIndexAction
{
   //用户控制台
   @ALink
   protected IAccountConsole _personConsole;

   @Override
   public String construct(ISqlContext context,
                           FIndexPage areaPage){
      return "/index";
   }
}
