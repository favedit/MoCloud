package com.cyou.gccloud.logger.face.logger;

import com.cyou.gccloud.logger.core.system.ISystemExceptionConsole;
import com.cyou.gccloud.logger.core.system.ISystemLoggerConsole;
import org.mo.cloud.core.logger.FGcLogger;
import org.mo.cloud.core.logger.FGcLoggers;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>日志处理控制台。</T>
//============================================================
public class FPublishService
      implements
         IPublishService
{
   // 系统日志控制台
   @ALink
   protected ISystemLoggerConsole _systemLoggerConsole;

   // 系统例外控制台
   @ALink
   protected ISystemExceptionConsole _systemExceptionConsole;

   //============================================================
   // <T>日志处理接口。</T>
   //
   // @param context 网页环境
   // @param logicContext 逻辑环境
   // @param input 网页输入
   // @param output 网页输出
   //============================================================
   @Override
   public EResult process(IWebContext context,
                          ILogicContext logicContext,
                          IWebInput input,
                          IWebOutput output){
      FXmlNode xconfig = input.config();
      // 加载日志
      FGcLoggers loggers = new FGcLoggers();
      loggers.loadConfig(xconfig);
      // 处理日志
      if(!loggers.isEmpty()){
         for(FGcLogger logger : loggers){
            int typeCd = logger.typeCd();
            switch(typeCd){
            //               case EGcLogger.SystemLogger:
            //                  _systemLoggerConsole.publish(logicContext, (FGcLoggerSystemLogger)logger);
            //                  break;
            //               case EGcLogger.SystemException:
            //                  _systemExceptionConsole.publish(logicContext, (FGcLoggerSystemException)logger);
            //                  break;
               default:
                  throw new FFatalError("Unknown logger type. (type_cd={1})", typeCd);
            }
         }
      }
      return EResult.Success;
   }
}
