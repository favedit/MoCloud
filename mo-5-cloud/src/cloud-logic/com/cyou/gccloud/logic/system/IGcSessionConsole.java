package com.cyou.gccloud.logic.system;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>系统会话控制台接口。</T>
//============================================================
public interface IGcSessionConsole
      extends
         IAbstractLogicUnitConsole<FGcSessionInfo>
{
   //============================================================
   // <T>查找所有会话。</T>
   //
   // @param context 逻辑环境
   // @param userId 用户编号
   // @return 会话集合
   //============================================================
   FLogicDataset<FGcSessionInfo> findByUserId(ILogicContext context,
                                              long userId);

   //============================================================
   // <T>打开一个会话。</T>
   //
   // @param context 逻辑环境
   // @param userId 用户编号
   // @param fromCd 来源类型
   // @return 会话信息
   //============================================================
   FGcSessionInfo open(ILogicContext context,
                       long userId,
                       int fromCd);

   //   //============================================================
   //   // <T>验证一个会话是否有效。</T>
   //   //
   //   // @param messageContext 消息环境
   //   // @param context 逻辑环境
   //   // @param code 代码
   //   // @return 会话信息
   //   //============================================================
   //   FGcSessionInfo verify(IMessageContext messageContext,
   //                         ILogicContext context,
   //                         String code);
   //
   //   //============================================================
   //   // <T>验证一个会话是否有效。</T>
   //   //
   //   // @param messageContext 消息环境
   //   // @param context 逻辑环境
   //   // @param code 代码
   //   // @return 会话信息
   //   //============================================================
   //   FGcSessionInfo verifySession(IMessageContext messageContext,
   //                                ILogicContext context,
   //                                String code);
   //
   //   //============================================================
   //   // <T>验证一个会话是否登录。</T>
   //   //
   //   // @param messageContext 消息环境
   //   // @param context 逻辑环境
   //   // @param code 代码
   //   // @return 会话信息
   //   //============================================================
   //   FGcSessionInfo verifyLogin(IMessageContext messageContext,
   //                              ILogicContext context,
   //                              String code);

   //============================================================
   // <T>关闭指定代码的会话。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一代码
   //============================================================
   void close(ILogicContext context,
              String guid);

   //============================================================
   // <T>关闭指定用户的所有会话。</T>
   //
   // @param context 逻辑环境
   // @param userId 用户编号
   //============================================================
   void close(ILogicContext context,
              long userId);
}
