package com.cyou.gccloud.logger.core.system;

import org.mo.com.console.FConsole;

//============================================================
// <T>资源应用控制台。</T>
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
   //   @Override
   //   public void publish(ILogicContext logicContext,
   //                       FGcLoggerSystemException logger){
   //      FLoggerSystemExceptionLogic logic = logicContext.findLogic(FLoggerSystemExceptionLogic.class);
   //      // 设置内容
   //      FLoggerSystemExceptionUnit unit = logic.doPrepare();
   //      unit.setRecordDate(new TDateTime(logger.dateTime()));
   //      unit.setServerCode(logger.serverCode());
   //      unit.setUserId(logger.userId());
   //      unit.setCode(logger.code());
   //      unit.setDescription(logger.description());
   //      // 新建记录
   //      logic.doInsert(unit);
   //   }
}
