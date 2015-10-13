package org.mo.cloud.logic.data.system;

import com.cyou.gccloud.data.cache.FCacheSystemSessionLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.message.IGcMessageConsole;
import org.mo.com.data.FSql;
import org.mo.core.aop.face.ALink;
import org.mo.core.bind.IBindConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>用户控制台。</T>
//============================================================
public class FGcSessionConsole
      extends FAbstractLogicUnitConsole<FCacheSystemSessionLogic, FGcSessionInfo>
      implements
         IGcSessionConsole
{
   // 日志输出接口
   //private static ILogger _logger = RLogger.find(FGcSessionConsole.class);

   // 消息控制台
   @ALink
   protected IGcMessageConsole _logicMessageConsole;

   // 绑定控制台
   @ALink
   protected IBindConsole _bindConsole;

   //============================================================
   // <T>构造用户控制台。</T>
   //============================================================
   public FGcSessionConsole(){
      super(FCacheSystemSessionLogic.class, FGcSessionInfo.class);
   }

   //============================================================
   // <T>根据会话编号查找会话信息。</T>
   //
   // @param context 逻辑环境
   // @param sessionCode 会话代码
   // @return 会话信息
   //============================================================
   @Override
   public FGcSessionInfo findBySessionCode(ILogicContext context,
                                           String logicCode,
                                           String fromCode,
                                           String sessionCode){
      // 生成SQL文
      FSql whereSql = new FSql();
      whereSql.append("(" + FCacheSystemSessionLogic.LOGIC_CODE + "={logic_code})");
      whereSql.append(" AND (" + FCacheSystemSessionLogic.FROM_CODE + "={from_code})");
      whereSql.append(" AND (" + FCacheSystemSessionLogic.SESSION_CODE + "={session_code})");
      whereSql.bindString("logic_code", logicCode);
      whereSql.bindString("from_code", fromCode);
      whereSql.bindString("session_code", sessionCode);
      // 查询单元
      FCacheSystemSessionLogic logic = findLogic(context);
      FGcSessionInfo sessionInfo = logic.search(FGcSessionInfo.class, whereSql);
      return sessionInfo;
   }

   @Override
   public FGcSessionInfo findBySessionCode(ILogicContext context,
                                           String sessionCode){
      FSql whereSql = new FSql();
      whereSql.append(FCacheSystemSessionLogic.SESSION_CODE);
      whereSql.append("='");
      whereSql.append(sessionCode);
      whereSql.append("'");
      FCacheSystemSessionLogic logic = findLogic(context);
      FGcSessionInfo sessionInfo = logic.search(FGcSessionInfo.class, whereSql);
      return sessionInfo;
   }

   //============================================================
   // <T>根据用户编号查找会话集合。</T>
   //
   // @param context 逻辑环境
   // @param userId 用户编号
   // @return 会话集合
   //============================================================
   @Override
   public FLogicDataset<FGcSessionInfo> findByUserId(ILogicContext context,
                                                     long userId){
      String whereSql = "(" + FCacheSystemSessionLogic.USER_ID + "=" + userId + ") AND (" + FCacheSystemSessionLogic.OVLD + "=1)";
      FCacheSystemSessionLogic logic = findLogic(context);
      FLogicDataset<FGcSessionInfo> sessions = logic.fetchClass(FGcSessionInfo.class, whereSql);
      return sessions;
   }

   //   //============================================================
   //   // <T>打开一个会话。</T>
   //   //
   //   // @param context 逻辑环境
   //   // @param userId 用户编号
   //   // @param fromCd 来源类型
   //   // @return 会话信息
   //   //============================================================
   //   @Override
   //   public FGcSessionInfo open(ILogicContext context,
   //                              String sessionId){
   //      FCacheSystemSessionLogic logic = findLogic(context);
   //      // 新建记录
   //      FGcSessionInfo session = logic.findByGuid(FGcSessionInfo.class, sessionId);
   //      if(session == null){
   //         session = logic.doPrepare(FGcSessionInfo.class);
   //         session.setGuid(sessionId);
   //         try{
   //            logic.doInsert(session);
   //         }catch(Exception exception){
   //            session = logic.findByGuid(FGcSessionInfo.class, sessionId);
   //            if(session == null){
   //               throw exception;
   //            }
   //         }
   //      }else{
   //         logic.doUpdate(session);
   //      }
   //      _logger.debug(this, "open", "Open session. (guid={1})", session.guid());
   //      // 返回结果
   //      return session;
   //   }
   //
   //   //============================================================
   //   // <T>打开一个会话。</T>
   //   //
   //   // @param context 逻辑环境
   //   // @param userId 用户编号
   //   // @param fromCd 来源类型
   //   // @return 会话信息
   //   //============================================================
   //   @Override
   //   public FGcSessionInfo open(ILogicContext context,
   //                              long userId,
   //                              int fromCd){
   //      FCacheSystemSessionLogic logic = findLogic(context);
   //      // 新建记录
   //      FGcSessionInfo session = logic.doPrepare(FGcSessionInfo.class);
   //      session.setUserId(userId);
   //      session.setFromCd(fromCd);
   //      logic.doInsert(session);
   //      _logger.debug(this, "open", "Open session. (guid={1}, user_id={2}, from_cd={3})", session.guid(), userId, fromCd);
   //      // 绑定数据
   //      _bindConsole.bind(FGcSessionInfo.class, session);
   //      // 返回结果
   //      return session;
   //   }

   //   //============================================================
   //   // <T>验证一个会话是否有效。</T>
   //   //
   //   // @param messageContext 消息环境
   //   // @param context 逻辑环境
   //   // @param code 代码
   //   // @return 会话信息
   //   //============================================================
   //   @Override
   //   public FGcSessionInfo verify(IMessageContext messageContext,
   //                                ILogicContext context,
   //                                String code){
   //      // 检查参数
   //      if(RString.isEmpty(code)){
   //         _logicMessageConsole.throwError(messageContext, "E00103", code);
   //         return null;
   //      }
   //      // 新建记录
   //      String whereSql = "(" + FCacheSystemSessionLogic.GUID + "='" + code + "') AND (OVLD=1)";
   //      FCacheSystemSessionLogic sessionLogic = context.findLogic(FCacheSystemSessionLogic.class);
   //      FGcSessionInfo sessionInfo = sessionLogic.search(FGcSessionInfo.class, whereSql);
   //      // 检查会话信息
   //      if(sessionInfo == null){
   //         _logicMessageConsole.throwError(messageContext, "E00103", code);
   //      }else if(!sessionInfo.ovld()){
   //         _logicMessageConsole.throwError(messageContext, "E00104", code);
   //      }
   //      // 绑定数据
   //      _bindConsole.bind(FGcSessionInfo.class, sessionInfo);
   //      return sessionInfo;
   //   }
   //
   //   //============================================================
   //   // <T>验证一个会话是否有效。</T>
   //   //
   //   // @param messageContext 消息环境
   //   // @param context 逻辑环境
   //   // @param code 代码
   //   // @return 会话信息
   //   //============================================================
   //   @Override
   //   public FGcSessionInfo verifySession(IMessageContext messageContext,
   //                                       ILogicContext context,
   //                                       String code){
   //      // 检查参数
   //      if(RString.isEmpty(code)){
   //         _logicMessageConsole.throwError(messageContext, "E00103", code);
   //         return null;
   //      }
   //      // 新建记录
   //      String whereSql = "(" + FCacheSystemSessionLogic.GUID + "='" + code + "') AND (OVLD=1)";
   //      FCacheSystemSessionLogic sessionLogic = context.findLogic(FCacheSystemSessionLogic.class);
   //      FGcSessionInfo sessionInfo = sessionLogic.search(FGcSessionInfo.class, whereSql);
   //      // 检查会话信息
   //      if(sessionInfo == null){
   //         _logicMessageConsole.pushError(messageContext, "E00103", code);
   //      }else if(!sessionInfo.ovld()){
   //         _logicMessageConsole.pushError(messageContext, "E00104", code);
   //      }
   //      // 绑定数据
   //      _bindConsole.bind(FGcSessionInfo.class, sessionInfo);
   //      return sessionInfo;
   //   }
   //
   //   //============================================================
   //   // <T>验证一个会话是否登录。</T>
   //   //
   //   // @param messageContext 消息环境
   //   // @param context 逻辑环境
   //   // @param code 代码
   //   // @return 会话信息
   //   //============================================================
   //   @Override
   //   public FGcSessionInfo verifyLogin(IMessageContext messageContext,
   //                                     ILogicContext context,
   //                                     String code){
   //      // 检查参数
   //      if(RString.isEmpty(code)){
   //         _logicMessageConsole.throwError(messageContext, "E00103", code);
   //         return null;
   //      }
   //      // 新建记录
   //      String whereSql = "(" + FCacheSystemSessionLogic.GUID + "='" + code + "') AND (OVLD=1)";
   //      FCacheSystemSessionLogic sessionLogic = context.findLogic(FCacheSystemSessionLogic.class);
   //      FGcSessionInfo sessionInfo = sessionLogic.search(FGcSessionInfo.class, whereSql);
   //      // 检查会话信息
   //      if(sessionInfo == null){
   //         _logicMessageConsole.pushError(messageContext, "E00103", code);
   //      }else if(!sessionInfo.ovld()){
   //         _logicMessageConsole.pushError(messageContext, "E00104", code);
   //      }
   //      // 绑定数据
   //      _bindConsole.bind(FGcSessionInfo.class, sessionInfo);
   //      return sessionInfo;
   //   }

   //   //============================================================
   //   // <T>关闭指定代码的会话。</T>
   //   //
   //   // @param context 逻辑环境
   //   // @param guid 唯一编码
   //   //============================================================
   //   @Override
   //   public void close(ILogicContext context,
   //                     String guid){
   //      // 新建记录
   //      FCacheSystemSessionLogic logic = findLogic(context);
   //      FCacheSystemSessionUnit unit = logic.findByGuid(guid);
   //      if(unit != null){
   //         close(context, unit.userId());
   //         _logger.debug(this, "close", "Close session. (guid={1})", guid);
   //      }else{
   //         _logger.warn(this, "close", "Session is not exists. (guid={1})", guid);
   //      }
   //   }
   //
   //   //============================================================
   //   // <T>关闭指定用户的所有会话。</T>
   //   //
   //   // @param context 逻辑环境
   //   // @param userId 用户编号
   //   //============================================================
   //   @Override
   //   public void close(ILogicContext context,
   //                     long userId){
   //      // 查找当前用户会话
   //      String whereSql = FCacheSystemSessionLogic.USER_ID + "=" + userId;
   //      FCacheSystemSessionLogic logic = findLogic(context);
   //      FLogicDataset<FCacheSystemSessionUnit> sessions = logic.fetch(whereSql, 100, 0);
   //      // 删除当前用户所有会话
   //      if(sessions != null){
   //         for(FCacheSystemSessionUnit unit : sessions){
   //            logic.doDelete(unit);
   //         }
   //      }
   //   }
}
