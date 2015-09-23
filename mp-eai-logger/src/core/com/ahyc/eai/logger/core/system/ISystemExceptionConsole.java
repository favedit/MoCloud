package com.ahyc.eai.logger.core.system;

import org.mo.cloud.core.logger.FGcLoggerSystemException;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>系统例外接口。</T>
//============================================================
public interface ISystemExceptionConsole
{
   //============================================================
   // <T>发布日志。</T>
   //
   // @param logicContext 逻辑环境
   // @param logger 日志对象
   //============================================================
   void publish(ILogicContext logicContext,
                FGcLoggerSystemException logger);
}
