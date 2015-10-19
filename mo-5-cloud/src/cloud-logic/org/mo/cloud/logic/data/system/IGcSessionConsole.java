package org.mo.cloud.logic.data.system;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>系统会话控制台接口。</T>
//============================================================
public interface IGcSessionConsole extends
        IAbstractLogicUnitConsole<FGcSessionInfo> {
    // ============================================================
    // <T>根据会话编号查找会话信息。</T>
    //
    // @param context 逻辑环境
    // @param sessionCode 会话代码
    // @return 会话信息
    // ============================================================
    FGcSessionInfo findBySessionCode(ILogicContext context, String logicCode,
            String fromCode, String sessionCode);

    // ============================================================
    // <T>查找所有会话。</T>
    //
    // @param context 逻辑环境
    // @param userId 用户编号
    // @return 会话集合
    // ============================================================
    FLogicDataset<FGcSessionInfo> findByUserId(ILogicContext context,
            long userId);

    // //============================================================
    // // <T>打开一个会话。</T>
    // //
    // // @param context 逻辑环境
    // // @param sessionId 会话编号
    // // @return 会话信息
    // //============================================================
    // FGcSessionInfo open(ILogicContext context,
    // String sessionId);
    //
    // //============================================================
    // // <T>打开一个会话。</T>
    // //
    // // @param context 逻辑环境
    // // @param userId 用户编号
    // // @param fromCd 来源类型
    // // @return 会话信息
    // //============================================================
    // FGcSessionInfo open(ILogicContext context,
    // long userId,
    // int fromCd);

    // //============================================================
    // // <T>验证一个会话是否有效。</T>
    // //
    // // @param messageContext 消息环境
    // // @param context 逻辑环境
    // // @param code 代码
    // // @return 会话信息
    // //============================================================
    // FGcSessionInfo verify(IMessageContext messageContext,
    // ILogicContext context,
    // String code);
    //
    // //============================================================
    // // <T>验证一个会话是否有效。</T>
    // //
    // // @param messageContext 消息环境
    // // @param context 逻辑环境
    // // @param code 代码
    // // @return 会话信息
    // //============================================================
    // FGcSessionInfo verifySession(IMessageContext messageContext,
    // ILogicContext context,
    // String code);
    //
    // //============================================================
    // // <T>验证一个会话是否登录。</T>
    // //
    // // @param messageContext 消息环境
    // // @param context 逻辑环境
    // // @param code 代码
    // // @return 会话信息
    // //============================================================
    // FGcSessionInfo verifyLogin(IMessageContext messageContext,
    // ILogicContext context,
    // String code);

    // //============================================================
    // // <T>关闭指定代码的会话。</T>
    // //
    // // @param context 逻辑环境
    // // @param guid 唯一代码
    // //============================================================
    // void close(ILogicContext context,
    // String guid);
    //
    // //============================================================
    // // <T>关闭指定用户的所有会话。</T>
    // //
    // // @param context 逻辑环境
    // // @param userId 用户编号
    // //============================================================
    // void close(ILogicContext context,
    // long userId);
    public FGcSessionInfo findBySessionCode(ILogicContext context,
            String sessionCode);

    // ============================================================
    // <T>根据用户编号和应用id查找会话集合。</T>
    // @param context 逻辑环境
    // @param userId 用户编号
    // @return 会话集合
    // ============================================================

    public FLogicDataset<FGcSessionInfo> findByUserAndAppId(
            ILogicContext context, long userId, long applicationId);
}
