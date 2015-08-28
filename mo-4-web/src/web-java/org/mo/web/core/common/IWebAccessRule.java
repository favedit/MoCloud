package org.mo.web.core.common;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.face.AWebAuthority;
import org.mo.web.core.face.AWebRole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>网站权限访问规则接口。</T>
//============================================================
public interface IWebAccessRule
{
   //============================================================
   // <T>检查会话是否有效。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param input 输入信息
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   EResult checkSession(IWebContext context,
                        ILogicContext logicContext);

   //============================================================
   // <T>检查会话是否登录。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param input 输入信息
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   EResult checkLogin(IWebContext context,
                      ILogicContext logicContext);

   //============================================================
   // <T>检查角色是否有权限。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param authority 权限
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   EResult checkAuthority(IWebContext context,
                          ILogicContext logicContext,
                          AWebRole role,
                          AWebAuthority authority);
}
