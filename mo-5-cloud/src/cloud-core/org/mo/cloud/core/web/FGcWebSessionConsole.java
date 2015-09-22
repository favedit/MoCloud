package org.mo.cloud.core.web;

import org.mo.cloud.logic.data.person.FGcUserInfo;
import org.mo.cloud.logic.data.person.IGcUserConsole;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
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

   // 用户管理器接口
   @ALink
   protected IGcUserConsole _userConsole;

   //============================================================
   // <T>建立线程对象。</T>
   //
   // @param sessionCode 会话代码
   // @return 线程对象
   //============================================================
   @Override
   public IWebSession build(String sessionCode){
      FGcWebSession session = (FGcWebSession)createSession(sessionCode);
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
      FGcWebSession session = (FGcWebSession)webSession;
      // 获得编号
      String fromCode = session.fromCode();
      String sessionCode = session.id();
      // 打开会话
      try(FLogicContext logicContext = new FLogicContext(_databaseConsole)){
         // 查找信息
         FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, _logicCode, fromCode, sessionCode);
         // 查找对象
         long userId = session.userId();
         String userLabel = null;
         FGcUserInfo userInfo = null;
         if(userId > 0){
            userInfo = _userConsole.find(logicContext, userId);
            if(userInfo != null){
               userLabel = userInfo.label();
            }
         }
         // 设置内容
         boolean exists = (sessionInfo != null);
         if(!exists){
            sessionInfo = _sessionConsole.doPrepare(logicContext);
         }
         sessionInfo.setLogicCode(_logicCode);
         sessionInfo.setFromCode(fromCode);
         sessionInfo.setSessionCode(sessionCode);
         sessionInfo.setUserId(session.userId());
         sessionInfo.setUserLabel(userLabel);
         if(!exists){
            _sessionConsole.doInsert(logicContext, sessionInfo);
         }else{
            _sessionConsole.doUpdate(logicContext, sessionInfo);
         }
         session.loadInfo(sessionInfo);
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
      try(FLogicContext logicContext = new FLogicContext(_databaseConsole)){
         // 新建会话
         FGcSessionInfo info = _sessionConsole.find(logicContext, recordId);
         if(info == null){
            _logger.warn(this, "update", "Update session is not exists. (record_id={1}, session_code={2})", recordId, sessionCode);
         }else if(!sessionCode.equals(info.sessionCode())){
            _logger.error(this, "update", "Update session is invalid. (record_id={1}, session_code={2}, record_code={3})", recordId, sessionCode, info.sessionCode());
         }else{
            session.saveInfo(info);
            _sessionConsole.doUpdate(logicContext, info);
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
      try(FLogicContext logicContext = new FLogicContext(_databaseConsole)){
         // 新建会话
         FGcSessionInfo info = _sessionConsole.find(logicContext, recordId);
         if(info == null){
            _logger.warn(this, "close", "Close session is not exists. (session_id={1})", sessionCode);
         }else if(!sessionCode.equals(info.sessionCode())){
            _logger.error(this, "close", "Update session is invalid. (record_id={1}, session_code={2}, record_code={3})", recordId, sessionCode, info.sessionCode());
         }else{
            _sessionConsole.doDelete(logicContext, info);
         }
      }catch(Exception e){
         throw new FFatalError(e);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>刷新线程信息,释放掉超时的线程对象。</T>
   //============================================================
   @Override
   public void refresh(){
      // 获得时间
      TDateTime current = RDateTime.currentDateTime();
      current.add(-_timeout);
      // 删除超时会话
      try(FLogicContext logicContext = new FLogicContext(_databaseConsole)){
         // 查询所有超时的会话
         FSql whereSql = new FSql("UPDATE_DATE < STR_TO_DATE({current_date}, '%Y%m%d%H%i%s')");
         whereSql.bindString("current_date", current.format());
         FLogicDataset<FGcSessionInfo> dataset = _sessionConsole.fetch(logicContext, whereSql);
         if(!dataset.isEmpty()){
            int count = dataset.count();
            _logger.info(this, "refresh", "Release timeout session. (count={1})", count);
            // 删除处理
            for(FGcSessionInfo sessionInfo : dataset){
               _sessionConsole.doDelete(logicContext, sessionInfo);
            }
         }
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }
}
