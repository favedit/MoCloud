package com.ahyc.eai.batch;

import com.ahyc.eai.batch.data.financial.member.FSynchronizeStatisticsMemberData;

import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>统计监视器。</T>
//============================================================
public class FSynchronizeMonitor
      extends FAbstractMonitor
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FSynchronizeMonitor.class);

   // 默认间隔
   protected long _defaultInterval = 1000 * 10;

   // 数据库控制台
   protected IDatabaseConsole _databaseConsole;

   //============================================================
   // <T>统计监视器。</T>
   //============================================================
   public FSynchronizeMonitor(IDatabaseConsole databaseConsole){
      _valid = true;
      _interval = _defaultInterval;
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
         //数据同步
         FSynchronizeStatisticsMemberData.synchronizedMember(logicContext);
      }catch(Exception exception){
         _logger.error(null, "main", exception);
      }
      _logger.debug(this, "onExecute", "Process statistics. (count={1})", processCount);
      if(processCount == 0){
         _interval = 10;
      }else{
         _interval = _defaultInterval;
      }
      return true;
   }
}
