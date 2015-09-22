package org.mo.cloud.common.datetime;

import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ALink;
import org.mo.core.monitor.IMonitorConsole;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>时间控制台。</T>
//============================================================
public class FDateTimeConsole
      implements
         IDateTimeConsole
{
   // 监视器
   protected FDataTimeMonitor _monitor;

   // 监视器控制台
   @ALink
   protected IMonitorConsole _monitorConsole;

   // 数据库控制台
   @ALink
   protected IDatabaseConsole _databaseConsole;

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
      _monitor = new FDataTimeMonitor();
      _monitor.setDatabaseConsole(_databaseConsole);
      _monitorConsole.register(_monitor);
   }

   //============================================================
   // <T>获得当前时间。</T>
   //
   // @return 时间
   //============================================================
   @Override
   public TDateTime currentDateTime(){
      return _monitor.getCurrentTime();
   }

   //============================================================
   // <T>获得当前时刻。</T>
   //
   // @return 时刻
   //============================================================
   @Override
   public long currentTick(){
      return _monitor.getCurrentTime().get();
   }
}
