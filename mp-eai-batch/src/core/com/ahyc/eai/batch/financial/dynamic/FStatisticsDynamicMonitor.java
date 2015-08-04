package com.ahyc.eai.batch.financial.dynamic;

import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>统计监视器。</T>
//============================================================
public class FStatisticsDynamicMonitor
      extends FAbstractMonitor
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsDynamicMonitor.class);

   // 默认间隔
   protected long _defaultInterval = 1000 * 10;

   // 数据库控制台
   protected IDatabaseConsole _databaseConsole;

   //============================================================
   // <T>统计监视器。</T>
   //============================================================
   public FStatisticsDynamicMonitor(IDatabaseConsole databaseConsole){
      _name = "analysis.activity";
      _valid = true;
      //_interval = _defaultInterval;
      _interval = 10;
      _databaseConsole = databaseConsole;
   }

   //============================================================
   // <T>执行处理。</T>
   //============================================================
   @Override
   public boolean onExecute(){
      long processCount = 0;
      // 逻辑处理
      try(FLogicContext logicContext = new FLogicContext(_databaseConsole)){
         // 计算动态数据
         FStatisticsDynamicCalculater dynamicCalculater = new FStatisticsDynamicCalculater();
         dynamicCalculater.process(logicContext);
         processCount += dynamicCalculater.processCount();
      }catch(Exception exception){
         _logger.error(null, "main", exception);
      }
      _logger.debug(this, "onExecute", "Process statistics. (count={1})", processCount);
      //      if(processCount > 0){
      //         _interval = 10;
      //      }else{
      //         _interval = _defaultInterval;
      //      }
      return true;
   }
}
