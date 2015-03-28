package org.mo.content.face.solution;

import org.mo.content.core.person.IAccountConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>人员账号逻辑。</T>
//
// @author sunhr
// @version 150328
//============================================================
public class FResourceAction
      implements
         IResourceAction
{
   //用户控制台
   @ALink
   protected IAccountConsole _accountConsole;

   //============================================================
   // <T>列表页面</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FProjectPage page){
      return "resource/List";
   }

   //============================================================
   // <T>详细页面</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String detail(IWebContext context,
                        ILogicContext logicContext,
                        @AContainer(name = "page") FProjectPage page){
      return "resource/Detail";
   }
}
