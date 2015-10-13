package org.mo.content.service.mobile.account;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.face.AWebSession;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>登录service接口。</T>
//============================================================
public interface ILoginService
{
   //============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult process(IWebContext context,
                   IWebInput input,
                   IWebOutput output);

   //============================================================
   // @登录
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

   //============================================================
   // @注销
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   EResult logout(IWebContext context,
                  IWebInput input,
                  IWebOutput output,
                  ILogicContext logicContext,
                  IWebSession sessionContext);

   //============================================================
   // @根据guid查询用户
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   EResult query(IWebContext context,
                 IWebInput input,
                 IWebOutput output,
                 ILogicContext logicContext,
                 IWebSession sessionContext);

   //============================================================
   // @更新用户
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   public EResult update(IWebContext context,
                         IWebInput input,
                         IWebOutput output,
                         ILogicContext logicContext,
                         IWebSession sessionContext);

   //============================================================
   // @用户反馈
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   public EResult feedback(IWebContext context,
                           IWebInput input,
                           IWebOutput output,
                           ILogicContext logicContext,
                           IWebSession sessionContext);

   //============================================================
   // @如果已经登录的用户直接自动登录
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @AWebSession
   public EResult autoLogin(IWebContext context,
                            IWebInput input,
                            IWebOutput output,
                            ILogicContext logicContext,
                            IWebSession sessionContext);
}
