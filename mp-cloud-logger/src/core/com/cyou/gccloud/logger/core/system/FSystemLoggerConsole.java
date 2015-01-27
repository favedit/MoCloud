package com.cyou.gccloud.logger.core.system;

import org.mo.com.console.FConsole;

//============================================================
// <T>资源应用控制台。</T>
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
   //   @Override
   //   public void publish(ILogicContext logicContext,
   //                       FGcLoggerSystemLogger logger){
   //      FLoggerSystemLoggerLogic logic = logicContext.findLogic(FLoggerSystemLoggerLogic.class);
   //      // 设置内容
   //      FLoggerSystemLoggerUnit unit = logic.doPrepare();
   //      unit.setRecordDate(new TDateTime(logger.dateTime()));
   //      unit.setServerCode(logger.serverCode());
   //      unit.setUserId(logger.userId());
   //      unit.setLevelCd(logger.levelCd());
   //      unit.setCode(logger.code());
   //      unit.setDescription(logger.description());
   //      // 新建记录
   //      logic.doInsert(unit);
   //   }
}
