package org.mo.cloud.core.web;

import com.cyou.gccloud.data.cache.FCacheSystemSessionLogic;
import com.cyou.gccloud.data.cache.FCacheSystemSessionUnit;
import org.mo.com.data.FSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.web.core.session.FWebSessionConsole;
import org.mo.web.core.session.IWebSession;

//============================================================
// <T>服务命令处理控制台。</T>
// <P>根据访问的地址，对页面服务执行分发处理。</P>
//============================================================
public class FGcWebSessionConsole
      extends FWebSessionConsole
{
   // 日志输出接口
   protected static ILogger _logger = RLogger.find(FGcWebSessionConsole.class);

   // 服务代码
   @AProperty
   protected String _serverCode;

   // 逻辑代码
   @AProperty
   protected String _logicCode;

   // 数据库管理器接口
   @ALink
   protected IDatabaseConsole _databaseConsole;

   //============================================================
   // <T>建立线程对象。</T>
   //
   // @param sessionId 线程标识
   // @return 线程对象
   //============================================================
   @Override
   public IWebSession build(String sessionId){
      FGcWebSession session = new FGcWebSession();
      try(FLogicContext context = new FLogicContext(_databaseConsole)){
         // 根据唯一编号查找
         FCacheSystemSessionLogic logic = context.findLogic(FCacheSystemSessionLogic.class);
         FCacheSystemSessionUnit unit = logic.findByGuid(sessionId);
         // 创建会话
         if(unit != null){
            session.loadUnit(unit);
         }else{
            session.setId(sessionId);
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
      FGcWebSession session = (FGcWebSession)webSession;
      // 获得编号
      String sessionCode = session.id();
      // 打开会话
      try(FLogicContext context = new FLogicContext(_databaseConsole)){
         // 查找对象
         FSql whereSql = new FSql(FCacheSystemSessionLogic.SERVER_CODE + "={session_code}");
         whereSql.bindString("session_code", sessionCode);
         FCacheSystemSessionLogic logic = context.findLogic(FCacheSystemSessionLogic.class);
         FCacheSystemSessionUnit unit = logic.search(whereSql);
         // 设置内容
         boolean exists = (unit != null);
         if(!exists){
            unit = logic.doPrepare();
         }
         unit.setServerCode(_serverCode);
         unit.setLogicCode(_logicCode);
         unit.setSessionCode(sessionCode);
         unit.setUserId(session.userId());
         if(!exists){
            logic.doInsert(unit);
         }else{
            logic.doUpdate(unit);
         }
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
      FGcWebSession session = (FGcWebSession)webSession;
      long recordId = session.recordId();
      String sessionCode = session.id();
      // 打开会话
      try(FLogicContext context = new FLogicContext(_databaseConsole)){
         // 新建会话
         FCacheSystemSessionLogic logic = context.findLogic(FCacheSystemSessionLogic.class);
         FCacheSystemSessionUnit unit = logic.find(recordId);
         if(unit == null){
            _logger.warn(this, "update", "Update session is not exists. (record_id={1}, session_code={2})", recordId, sessionCode);
         }else if(!sessionCode.equals(unit.sessionCode())){
            _logger.error(this, "update", "Update session is invalid. (record_id={1}, session_code={2}, record_code={3})", recordId, sessionCode, unit.sessionCode());
         }else{
            unit.setUserId(session.userId());
            logic.doUpdate(unit);
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
      FGcWebSession session = (FGcWebSession)webSession;
      long recordId = session.recordId();
      String sessionCode = session.id();
      // 打开会话
      try(FLogicContext context = new FLogicContext(_databaseConsole)){
         // 新建会话
         FCacheSystemSessionLogic logic = context.findLogic(FCacheSystemSessionLogic.class);
         FCacheSystemSessionUnit unit = logic.find(recordId);
         if(unit == null){
            _logger.warn(this, "close", "Close session is not exists. (session_id={1})", sessionCode);
         }else if(!sessionCode.equals(unit.sessionCode())){
            _logger.error(this, "close", "Update session is invalid. (record_id={1}, session_code={2}, record_code={3})", recordId, sessionCode, unit.sessionCode());
         }else{
            logic.doDelete(unit);
         }
      }catch(Exception e){
         throw new FFatalError(e);
      }
      return EResult.Success;
   }
}
