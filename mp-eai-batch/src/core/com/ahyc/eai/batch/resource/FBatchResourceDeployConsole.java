package com.ahyc.eai.batch.resource;

import org.mo.core.aop.face.ALink;
import org.mo.core.monitor.IMonitorConsole;
import org.mo.eng.data.IDatabaseConsole;

public class FBatchResourceDeployConsole
      implements
         IBatchResourceDeployConsole
{

   @ALink
   private IDatabaseConsole _databaseConsole;

   @ALink
   private IMonitorConsole _monitorConsole;

   //private FDataDownloadMonitor _monitor;

   //注册资源现在monitor
   public void initialize(){
      //_monitor = new FDataDownloadMonitor();
      //_monitor.setDatabaseConsole(_databaseConsole);
      //_monitorConsole.register(_monitor);
   }
}
