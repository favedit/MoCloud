package com.ahyc.eai.logger.core.system;

import com.cyou.gccloud.data.logger.FLoggerSystemExceptionLogic;
import com.cyou.gccloud.data.logger.FLoggerSystemExceptionUnit;
import org.mo.cloud.core.logger.FGcLoggerSystemException;
import org.mo.com.console.FConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>系统例外控制台。</T>
//============================================================
public class FSystemExceptionConsole
      extends FConsole
      implements
         ISystemExceptionConsole
{
   //============================================================
   // <T>发布日志。</T>
   //
   // @param logicContext 逻辑环境
   // @param logger 日志对象
   //============================================================
   @Override
   public void publish(ILogicContext logicContext,
                       FGcLoggerSystemException logger){
      FLoggerSystemExceptionLogic logic = logicContext.findLogic(FLoggerSystemExceptionLogic.class);
      // 设置内容
      FLoggerSystemExceptionUnit unit = logic.doPrepare();
      unit.recordDate().set(logger.dateTime());
      unit.setServerCode(logger.serverCode());
      unit.setServerHost(logger.serverHost());
      unit.setUserId(logger.userId());
      unit.setCode(logger.code());
      unit.setDescription(logger.description());
      // 新建记录
      logic.doInsert(unit);
   }
}
