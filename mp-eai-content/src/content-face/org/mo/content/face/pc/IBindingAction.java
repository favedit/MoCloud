package org.mo.content.face.pc;

import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.face.AWebRole;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>账号绑定接口。</P>
//
// @author sunhr
// @version 150724
//============================================================
public interface IBindingAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @AWebRole("eai.oa")
   String construct(IWebContext context,
                    IWebSession sessionContext,
                    ILogicContext logicContext,
                    @AContainer(name = "page") FIndexPage page);

   //============================================================
   // <T>发送验证码。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @AWebRole("eai.oa")
   String sendValidate(IWebContext context,
                       IWebSession sessionContext,
                       ILogicContext logicContext,
                       @AContainer(name = "page", fill = true) FIndexPage page);

   //============================================================
   // <T>账号绑定。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   //   @AWebRole("eai.oa")
   String bindOnAccount(IWebContext context,
                        IWebSession sessionContext,
                        ILogicContext logicContext,
                        @AContainer(name = "page", fill = true) FIndexPage page);

}
