package com.ahyc.eai.batch.session;

import com.cyou.gccloud.common.datetime.IDateTimeConsole;
import org.mo.com.console.FConsole;
import org.mo.com.lang.type.TTimeSpan;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.core.monitor.IMonitorConsole;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>系统会话控制台。</T>
//============================================================
public class FSessionConsole
      extends FConsole
      implements
         ISessionConsole
{

   @AProperty(name = "out_days")
   protected int _outDays;

   @AProperty(name = "interval")
   protected int _interval = 10;

   @AProperty(name = "count_in_tick")
   private int _countInTick = 50;

   @ALink
   private IDateTimeConsole _dateTimeConsole;

   @ALink
   private IDatabaseConsole _databaseConsole;

   @ALink
   private IMonitorConsole _monitorConsole;

   private FSessionMonitor _sessionMonitor;

   @Override
   public void initialize(){
      _sessionMonitor = new FSessionMonitor();
      TTimeSpan span = new TTimeSpan();
      span.addDays(_outDays);

      _sessionMonitor.setOutdate(span);
      _sessionMonitor.setInterval(_interval);
      _sessionMonitor.setCountInTick(_countInTick);

      _sessionMonitor.setDateTimeConsole(_dateTimeConsole);
      _sessionMonitor.setDataBaseConsole(_databaseConsole);

      _monitorConsole.register(_sessionMonitor);
   }

}
