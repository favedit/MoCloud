package org.mo.web.core.common;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.face.AWebAuthority;
import org.mo.web.core.face.AWebRole;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>网站权限访问规则。</T>
//============================================================
public class FWebAccessRule
      extends FObject
      implements
         IWebAccessRule
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
   @Override
   public EResult checkSession(IWebContext context,
                               ILogicContext logicContext){
      return EResult.Success;
   }

   //============================================================
   // <T>检查会话是否登录。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param input 输入信息
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult checkLogin(IWebContext context,
                             ILogicContext logicContext){
      IWebSession session = context.session();
      if(!session.user().isLogin()){
         return EResult.Failure;
      }
      return EResult.Success;
   }

   //============================================================
   // <T>检查角色是否有权限。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param authority 权限
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult checkAuthority(IWebContext context,
                                 ILogicContext logicContext,
                                 AWebRole role,
                                 AWebAuthority authority){
      return EResult.Success;
   }
}
