package com.cyou.gccloud.logic.system;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.message.IMessageContext;
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
   // <T>根据代码查找会话。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 会话集合
   //============================================================
   FGcSessionInfo findByCode(ILogicContext logicContext,
                             String code);

   //============================================================
   // <T>查找所有会话。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @return 会话集合
   //============================================================
   FLogicDataset<FGcSessionInfo> findByUserId(ILogicContext logicContext,
                                              long userId);

   //============================================================
   // <T>打开一个会话。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param sysAppCode 系统应用编号
   // @param deviceWidth 设备宽度
   // @param deviceHeight 设备高度
   // @return 会话信息
   //============================================================
   FGcSessionInfo open(ILogicContext logicContext,
                       long userId,
                       int sessionFrom,
                       String applicationCode,
                       int deviceWidth,
                       int deviceHeight);

   //============================================================
   // <T>验证一个会话是否有效。</T>
   //
   // @param messageContext 消息环境
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 会话信息
   //============================================================
   FGcSessionInfo verify(IMessageContext messageContext,
                         ILogicContext logicContext,
                         String code);

   //============================================================
   // <T>验证一个会话是否有效。</T>
   //
   // @param messageContext 消息环境
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 会话信息
   //============================================================
   FGcSessionInfo verifySession(IMessageContext messageContext,
                                ILogicContext logicContext,
                                String code);

   //============================================================
   // <T>验证一个会话是否登录。</T>
   //
   // @param messageContext 消息环境
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 会话信息
   //============================================================
   FGcSessionInfo verifyLogin(IMessageContext messageContext,
                              ILogicContext logicContext,
                              String code);

   //============================================================
   // <T>关闭指定代码的会话。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   //============================================================
   void close(ILogicContext logicContext,
              String code);

   //============================================================
   // <T>关闭指定用户的所有会话。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   //============================================================
   void close(ILogicContext logicContext,
              long userId);
}
