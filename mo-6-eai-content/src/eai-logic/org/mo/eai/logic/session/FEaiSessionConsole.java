package org.mo.eai.logic.session;

import org.mo.cloud.core.web.FGcWebSessionConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.cloud.logic.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.web.core.session.IWebSession;

//============================================================
// <T>服务命令处理控制台。</T>
// <P>根据访问的地址，对页面服务执行分发处理。</P>
//============================================================
public class FEaiSessionConsole
      extends FGcWebSessionConsole
{
   // 日志输出接口
   protected static ILogger _logger = RLogger.find(FEaiSessionConsole.class);

   // 逻辑代码
   @AProperty
   protected String _logicCode;

   // 服务代码
   @AProperty
   protected String _serverCode;

   // 数据库管理器接口
   @ALink
   protected IDatabaseConsole _databaseConsole;

   // 数据库管理器接口
   @ALink
   protected IGcSessionConsole _sessionConsole;

   //============================================================
   // <T>建立线程对象。</T>
   //
   // @param sessionCode 会话代码
   // @return 线程对象
   //============================================================
   @Override
   public IWebSession build(String sessionCode){
      FEaiSession session = new FEaiSession();
      try(FLogicContext context = new FLogicContext(_databaseConsole)){
         // 查找信息
         FGcSessionInfo info = _sessionConsole.findBySessionCode(context, _logicCode, "web", sessionCode);
         // 创建会话
         if(info != null){
            session.loadInfo(info);
         }else{
            session.setId(sessionCode);
         }
      }catch(Exception e){
         throw new FFatalError(e);
      }
      return session;
   }

   //============================================================
   // <T>打开会话对象。</T>
   //
   // @param session 会话对象
   // @return 处理结果
   //============================================================
   @Override
   public EResult open(IWebSession webSession){
      FEaiSession session = (FEaiSession)webSession;
      // 获得编号
      String sessionCode = session.id();
      // 打开会话
      try(FLogicContext context = new FLogicContext(_databaseConsole)){
         // 查找对象
         // 查找信息
         FGcSessionInfo info = _sessionConsole.findBySessionCode(context, _logicCode, "web", sessionCode);
         // 设置内容
         boolean exists = (info != null);
         if(!exists){
            info = _sessionConsole.doPrepare(context);
         }
         info.setFromCode("web");
         info.setLogicCode(_logicCode);
         info.setSessionCode(sessionCode);
         info.setUserId(session.userId());
         if(!exists){
            _sessionConsole.doInsert(context, info);
         }else{
            _sessionConsole.doUpdate(context, info);
         }
         session.loadInfo(info);
      }catch(Exception e){
         throw new FFatalError(e);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>更新会话对象。</T>
   //
   // @param session 会话对象
   // @return 处理结果
   //============================================================
   @Override
   public EResult update(IWebSession webSession){
      // 获得编号
      FEaiSession session = (FEaiSession)webSession;
      long recordId = session.recordId();
      String sessionCode = session.id();
      // 打开会话
      try(FLogicContext context = new FLogicContext(_databaseConsole)){
         // 新建会话
         FGcSessionInfo info = _sessionConsole.find(context, recordId);
         if(info == null){
            _logger.warn(this, "update", "Update session is not exists. (record_id={1}, session_code={2})", recordId, sessionCode);
         }else if(!sessionCode.equals(info.sessionCode())){
            _logger.error(this, "update", "Update session is invalid. (record_id={1}, session_code={2}, record_code={3})", recordId, sessionCode, info.sessionCode());
         }else{
            info.setUserId(session.userId());
            _sessionConsole.doUpdate(context, info);
         }
      }catch(Exception e){
         throw new FFatalError(e);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>关闭会话对象。</T>
   //
   // @param session 会话对象
   // @return 处理结果
   //============================================================
   @Override
   public EResult close(IWebSession webSession){
      // 获得编号
      FEaiSession session = (FEaiSession)webSession;
      long recordId = session.recordId();
      String sessionCode = session.id();
      // 打开会话
      try(FLogicContext context = new FLogicContext(_databaseConsole)){
         // 新建会话
         FGcSessionInfo info = _sessionConsole.find(context, recordId);
         if(info == null){
            _logger.warn(this, "close", "Close session is not exists. (session_id={1})", sessionCode);
         }else if(!sessionCode.equals(info.sessionCode())){
            _logger.error(this, "close", "Update session is invalid. (record_id={1}, session_code={2}, record_code={3})", recordId, sessionCode, info.sessionCode());
         }else{
            _sessionConsole.doDelete(context, info);
         }
      }catch(Exception e){
         throw new FFatalError(e);
      }
      return EResult.Success;
   }
}
