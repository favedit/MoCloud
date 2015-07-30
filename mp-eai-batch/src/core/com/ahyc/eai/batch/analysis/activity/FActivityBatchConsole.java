package com.ahyc.eai.batch.analysis.activity;

import org.mo.com.console.FConsole;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.core.monitor.IMonitorConsole;
import org.mo.eng.data.IDatabaseConsole;

public class FActivityBatchConsole
      extends FConsole
      implements
         IActivityBatchConsole
{
   // 数据控制台
   @ALink
   protected IDatabaseConsole _databaseConsole;

   @AProperty(name = "interval")
   protected int _interval = 1000 * 60 * 60;

   private FActivityMonitor _activityMonitor;

   @ALink
   private IMonitorConsole _monitorConsole;

   @Override
   public void initialize(){
      _activityMonitor = new FActivityMonitor(_databaseConsole);
      _activityMonitor.setInterval(_interval);
      _monitorConsole.register(_activityMonitor);
      System.out.println("==========================================FActivityBatchConsole.initialize");
   }
}
