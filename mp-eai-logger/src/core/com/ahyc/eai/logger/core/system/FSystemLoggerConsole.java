package com.ahyc.eai.logger.core.system;

import com.cyou.gccloud.data.logger.FLoggerSystemLoggerLogic;
import com.cyou.gccloud.data.logger.FLoggerSystemLoggerUnit;
import org.mo.cloud.core.logger.FGcLoggerSystemLogger;
import org.mo.com.console.FConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>系统日志控制台。</T>
//============================================================
public class FSystemLoggerConsole
      extends FConsole
      implements
         ISystemLoggerConsole
{
   //============================================================
   // <T>发布日志。</T>
   //
   // @param logicContext 逻辑环境
   // @param logger 日志对象
   //============================================================
   @Override
   public void publish(ILogicContext logicContext,
                       FGcLoggerSystemLogger logger){
      FLoggerSystemLoggerLogic logic = logicContext.findLogic(FLoggerSystemLoggerLogic.class);
      // 设置内容
      FLoggerSystemLoggerUnit unit = logic.doPrepare();
      unit.recordDate().set(logger.dateTime());
      unit.setServerCode(logger.serverCode());
      unit.setServerHost(logger.serverHost());
      unit.setUserId(logger.userId());
      unit.setLevelCd(logger.levelCd().value());
      unit.setCode(logger.code());
      unit.setDescription(logger.description());
      // 新建记录
      logic.doInsert(unit);
   }
}
