package org.mo.content.service.info.logic.login;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>登录信息管理接口。</T>
//============================================================
public interface ILoginService
{
   //============================================================
   // <T>默认逻辑。</T>
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult process(IWebContext context,
                   IWebInput input,
                   IWebOutput output);

   //============================================================
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   EResult login(IWebContext context,
                 IWebInput input,
                 IWebOutput output,
                 ILogicContext logicContext,
                 IWebSession sessionContext);

   EResult logout(IWebContext context,
                  IWebInput input,
                  IWebOutput output,
                  ILogicContext logicContext,
                  IWebSession sessionContext);

   EResult query(IWebContext context,
                 IWebInput input,
                 IWebOutput output,
                 ILogicContext logicContext,
                 IWebSession sessionContext);

   public EResult update(IWebContext context,
                         IWebInput input,
                         IWebOutput output,
                         ILogicContext logicContext,
                         IWebSession sessionContext);

   public EResult feedback(IWebContext context,
                           IWebInput input,
                           IWebOutput output,
                           ILogicContext logicContext,
                           IWebSession sessionContext);
}
