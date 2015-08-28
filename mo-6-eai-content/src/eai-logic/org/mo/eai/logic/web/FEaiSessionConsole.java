package org.mo.eai.logic.web;

import org.mo.eai.logic.data.control.role.FDataControlModuleInfo;
import org.mo.eai.logic.data.control.role.FDataControlRoleInfo;
import org.mo.eai.logic.data.control.role.IDataControlRoleConsole;

import com.cyou.gccloud.define.enums.core.EGcControlRoleModuleValid;
import org.mo.cloud.core.web.FGcWebSessionConsole;
import org.mo.cloud.logic.person.FGcUserInfo;
import org.mo.cloud.logic.person.IGcUserConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FStrings;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
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

   // 用户控制台
   @ALink
   protected IGcUserConsole _userConsole;

   // 角色控制台
   @ALink
   protected IDataControlRoleConsole _roleConsole;

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
      try(FLogicContext logicContext = new FLogicContext(_databaseConsole)){
         // 获得用户信息
         long userId = session.userId();
         String userLabel = null;
         long roleId = 0;
         String roleCode = null;
         String roleModules = null;
         if(userId > 0){
            FGcUserInfo userInfo = _userConsole.find(logicContext, userId);
            roleId = userInfo.roleId();
            userLabel = userInfo.label();
            // 获得用户权限
            FStrings moduleCodes = new FStrings();
            if(roleId != 0){
               FDataControlRoleInfo roleInfo = _roleConsole.find(logicContext, roleId);
               if(roleInfo != null){
                  roleCode = roleInfo.code();
                  FLogicDataset<FDataControlModuleInfo> moduleDataset = _roleConsole.findRoleModules(logicContext, roleId);
                  if(moduleDataset != null){
                     for(FDataControlModuleInfo moduleInfo : moduleDataset){
                        if(moduleInfo.viewValidCd() == EGcControlRoleModuleValid.Valid){
                           String moduleCode = moduleInfo.code();
                           moduleCodes.push(moduleCode);
                        }
                     }
                  }
               }
            }
            roleModules = moduleCodes.join('|');
         }
         // 获得会话信息
         FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, _logicCode, "web", sessionCode);
         // 设置内容
         boolean exists = (sessionInfo != null);
         if(!exists){
            sessionInfo = _sessionConsole.doPrepare(logicContext);
         }
         sessionInfo.setFromCode("web");
         sessionInfo.setLogicCode(_logicCode);
         sessionInfo.setSessionCode(sessionCode);
         sessionInfo.setUserId(userId);
         sessionInfo.setUserLabel(userLabel);
         sessionInfo.setRoleId(roleId);
         sessionInfo.setRoleCode(roleCode);
         sessionInfo.setRoleModules(roleModules);
         if(!exists){
            _sessionConsole.doInsert(logicContext, sessionInfo);
         }else{
            _sessionConsole.doUpdate(logicContext, sessionInfo);
         }
         session.loadInfo(sessionInfo);
      }catch(Exception exception){
         throw new FFatalError(exception);
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
