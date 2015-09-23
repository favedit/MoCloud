package com.ahyc.eai.logger.core.system;

import org.mo.cloud.core.logger.FGcLoggerSystemLogger;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>系统日志接口。</T>
//============================================================
public interface ISystemLoggerConsole
{
   //============================================================
   // <T>发布日志。</T>
   //
   // @param logicContext 逻辑环境
   // @param logger 日志对象
   //============================================================
   void publish(ILogicContext logicContext,
                FGcLoggerSystemLogger logger);
}
