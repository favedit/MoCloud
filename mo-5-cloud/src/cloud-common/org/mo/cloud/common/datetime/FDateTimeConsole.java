package org.mo.cloud.common.datetime;

import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.core.monitor.IMonitorConsole;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>时间控制台。</T>
//============================================================
public class FDateTimeConsole
      implements
         IDateTimeConsole
{
   // 代码修正
   public static final String CURRENT_DATE_SQL = "SELECT CURRENT_TIMESTAMP";

   // 是否允许
   @AProperty
   protected boolean _enable = true;

   // 监视器
   protected FDataTimeMonitor _monitor;

   // 监视器控制台
   @ALink
   protected IMonitorConsole _monitorConsole;

   // 数据库控制台
   @ALink
   protected IDatabaseConsole _databaseConsole;

   // 时刻差
   protected volatile long _tickDifference;

   // 时刻
   protected TDateTime _tickDateTime = new TDateTime();

   //============================================================
   // <T>获得当前时间。</T>
   //
   // @return 时间
   //============================================================
   @Override
   public TDateTime currentDateTime(){
      TDateTime currentTime = RDateTime.currentDateTime();
      currentTime.add(_tickDifference);
      return currentTime;
   }

   //============================================================
   // <T>获得当前时刻。</T>
   //
   // @return 时刻
   //============================================================
   @Override
   public long currentTick(){
      TDateTime current = currentDateTime();
      return current.get();
   }

   //============================================================
   // <T>刷新数据处理。</T>
   //============================================================
   public boolean refresh(){
      if(_enable){
         ISqlConnection connection = null;
         try{
            connection = _databaseConsole.alloc();
            // 获得时间
            FRow row = connection.find(CURRENT_DATE_SQL);
            if(!row.isEmpty()){
               String datetime = row.value(0);
               _tickDateTime.parse(datetime);
            }
            // 计算时差
            TDateTime currentTime = RDateTime.currentDateTime();
            _tickDifference = _tickDateTime.get() - currentTime.get();
         }catch(Exception exception){
            return false;
         }finally{
            if(connection != null){
               _databaseConsole.free(connection);
            }
         }
      }
      return true;
   }

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
      // 启动监视器
      _monitor = new FDataTimeMonitor();
      _monitor.setConsole(this);
      _monitorConsole.start(_monitor);
   }
}
