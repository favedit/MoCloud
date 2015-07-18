package org.mo.content.face.mobile;

import org.mo.content.core.person.IAccountConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>接口。</P>
//
// @author sunhr
// @version 150718
//============================================================
public class FIndexAction
      implements
         IIndexAction
{
   //用户控制台
   @ALink
   protected IAccountConsole _personConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FIndexPage areaPage){
      String test = context.parameter("a");
      System.out.println("-----------------------------------------------" + test);
      return "/Index";
   }

   @Override
   public String putMobileInfo(IWebContext context,
                               ILogicContext logicContext,
                               FIndexPage page){
      // TODO Auto-generated method stub
      return null;
   }

}
