package org.mo.cloud.core.web;

import com.cyou.gccloud.data.cache.FCacheSystemSessionLogic;
import com.cyou.gccloud.data.cache.FCacheSystemSessionUnit;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.eng.session.common.ISession;
import org.mo.web.core.session.FWebSessionConsole;
import org.mo.web.core.session.IWebSession;

//============================================================
// <T>服务命令处理控制台。</T>
// <P>根据访问的地址，对页面服务执行分发处理。</P>
//============================================================
public class FGcWebSessionConsole
      extends FWebSessionConsole
{
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
   // <T>根据代码查找会话对象。</T>
   //
   // @param code 代码
   // @return 会话对象
   //============================================================
   @Override
   @SuppressWarnings("unchecked")
   public <V extends ISession> V find(String sessionCode){
      FGcWebSession session = new FGcWebSession();
      try(FLogicContext context = new FLogicContext(_databaseConsole)){
         // 根据唯一编号查找
         FCacheSystemSessionLogic logic = context.findLogic(FCacheSystemSessionLogic.class);
         FCacheSystemSessionUnit unit = logic.findByGuid(sessionCode);
         // 创建会话
         if(unit != null){
            session.loadUnit(unit);
         }else{
            session.setId(sessionCode);
         }
      }catch(Exception e){
         throw new FFatalError(e);
      }
      return (V)session;
   }

   //============================================================
   // <T>建立线程对象。</T>
   //
   // @param sessionId 线程标识
   // @return 线程对象
   //============================================================
   @Override
   public IWebSession build(String sessionId){
      FGcWebSession session = null;
      try(FLogicContext context = new FLogicContext(_databaseConsole)){
         // 新建会话
         FCacheSystemSessionLogic logic = context.findLogic(FCacheSystemSessionLogic.class);
         FCacheSystemSessionUnit unit = logic.doPrepare();
         unit.setServerCode(_serverCode);
         unit.setLogicCode(_logicCode);
         unit.setSessionCode(sessionId);
         logic.doInsert(unit);
         // 加载会话
         session = new FGcWebSession();
         session.loadUnit(unit);
      }catch(Exception e){
         throw new FFatalError(e);
      }
      return session;
   }
}
