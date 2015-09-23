package org.mo.cloud.core.logger;

import org.mo.core.monitor.common.FAbstractMonitor;

//============================================================
// <T>日志监视器。</T>
//============================================================
public class FGcLoggerMonitor
      extends FAbstractMonitor
{
   // 控制台
   protected FGcLoggerConsole _console;

   // 日志集合
   protected FGcLoggers _loggers = new FGcLoggers();

   //============================================================
   // <T>构造日志监视器。</T>
   //============================================================
   public FGcLoggerMonitor(){
      _interval = 10000;
   }

   //============================================================
   // <T>构造日志监视器。</T>
   //
   // @param console 控制台
   //============================================================
   public FGcLoggerMonitor(FGcLoggerConsole console){
      _valid = true;
      _interval = 1000;
      _console = console;
   }

   //============================================================
   // <T>获得控制台。</T>
   //
   // @return 控制台
   //============================================================
   public FGcLoggerConsole console(){
      return _console;
   }

   //============================================================
   // <T>设置控制台。</T>
   //
   // @param console 控制台
   //============================================================
   public void setConsole(FGcLoggerConsole console){
      _console = console;
   }

   //============================================================
   // <T>执行监视器的逻辑。</T>
   //
   // @return 处理结果
   //============================================================
   @Override
   public boolean onExecute(){
      // 获取日志
      _console.fetch(_loggers);
      // 发送日志
      try{
         _console.send(_loggers);
      }finally{
         _loggers.clear();
      }
      return true;
   }
}
