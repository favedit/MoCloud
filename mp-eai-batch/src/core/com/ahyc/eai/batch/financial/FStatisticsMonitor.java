package com.ahyc.eai.batch.financial;

import org.mo.com.data.FSqlProcedure;
import org.mo.com.data.ISqlConnection;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>统计监视器。</T>
//============================================================
public class FStatisticsMonitor
      extends FAbstractMonitor
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsMonitor.class);

   protected IDatabaseConsole _databaseConsole;

   protected int _defaultInterval = 1000 * 60 * 60;

   protected FSqlProcedure _countProc = new FSqlProcedure("AccountActivityJoinSubmitCount");

   protected FSqlProcedure _totalProc = new FSqlProcedure("AccountActivityJoinSubmitTotal");

   public FStatisticsMonitor(IDatabaseConsole databaseConsole){
      _name = "analysis.activity";
      _valid = true;
      _interval = _defaultInterval;
      _databaseConsole = databaseConsole;
   }

   @Override
   public boolean onExecute(){
      ISqlConnection connection = null;
      try{
         connection = _databaseConsole.alloc("CD_STATISTICS");
         connection.execute(_countProc);
         connection.execute(_totalProc);
      }catch(Exception e){
         _logger.error(this, "process", e);
         return false;
      }finally{
         _databaseConsole.free(connection);
      }
      System.out.println("==========================================FActivityMonitor.onExecute");
      return true;
   }
}
