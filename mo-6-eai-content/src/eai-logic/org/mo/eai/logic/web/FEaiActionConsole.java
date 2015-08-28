package org.mo.eai.logic.web;

import org.mo.cloud.core.message.IGcMessageConsole;
import org.mo.cloud.logic.system.IGcSessionConsole;
import org.mo.core.aop.face.ALink;
import org.mo.web.core.action.FActionConsole;

//============================================================
// <T>服务命令处理控制台。</T>
// <P>根据访问的地址，对页面服务执行分发处理。</P>
//============================================================
public class FEaiActionConsole
      extends FActionConsole
{
   // 头标志
   public final static String HeadSession = "session_guid";

   // 消息控制台
   @ALink
   protected IGcMessageConsole _gcMessageConsole;

   // 会话控制台
   @ALink
   protected IGcSessionConsole _gcSessionConsole;

   //============================================================
   // <T>构造服务命令处理控制台。</T>
   //============================================================
   public FEaiActionConsole(){
   }

   //   //============================================================
   //   // <T>检查会话是否有效。</T>
   //   //
   //   // @param context 页面环境
   //   // @param logicContext 逻辑环境
   //   // @param input 输入信息
   //   // @param output 输出信息
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public EResult checkSession(IWebContext context,
   //                               ILogicContext logicContext){
   //      FEaiSession session = (FEaiSession)context.session();
   //      if(session == null){
   //         return EResult.Failure;
   //      }
   //      // 绑定数据
   //      _bindConsole.bind(FEaiSession.class, session);
   //      return EResult.Success;
   //   }
   //
   //   //============================================================
   //   // <T>检查会话是否登录。</T>
   //   //
   //   // @param context 页面环境
   //   // @param logicContext 逻辑环境
   //   // @param input 输入信息
   //   // @param output 输出信息
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public EResult checkLogin(IWebContext context,
   //                             ILogicContext logicContext){
   //      FEaiSession session = (FEaiSession)context.session();
   //      // 会话不存在
   //      if(session == null){
   //         return EResult.Failure;
   //      }
   //      // 会话用户未登录
   //      long userId = session.userId();
   //      if(userId == 0){
   //         return EResult.Failure;
   //      }
   //      // 绑定会话数据
   //      _bindConsole.bind(FEaiSession.class, session);
   //      return EResult.Success;
   //   }
   //
   //   //============================================================
   //   // <T>检查角色是否有权限。</T>
   //   //
   //   // @param context 页面环境
   //   // @param logicContext 逻辑环境
   //   // @param authority 权限
   //   // @param output 输出信息
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public EResult checkAuthority(IWebContext context,
   //                                 ILogicContext logicContext,
   //                                 AWebRole role,
   //                                 AWebAuthority authority){
   //      return EResult.Success;
   //   }
}
