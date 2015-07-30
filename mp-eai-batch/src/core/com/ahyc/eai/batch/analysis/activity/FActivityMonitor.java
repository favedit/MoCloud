package com.ahyc.eai.batch.analysis.activity;

import org.mo.com.data.FSqlProcedure;
import org.mo.com.data.ISqlConnection;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.eng.data.IDatabaseConsole;

public class FActivityMonitor
      extends FAbstractMonitor
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FActivityMonitor.class);

   private IDatabaseConsole _databaseConsole;

   private int _defaultInterval = 1000 * 60 * 60;

   private FSqlProcedure _countProc = new FSqlProcedure("AccountActivityJoinSubmitCount");

   private FSqlProcedure _totalProc = new FSqlProcedure("AccountActivityJoinSubmitTotal");

   public FActivityMonitor(IDatabaseConsole databaseConsole){
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
