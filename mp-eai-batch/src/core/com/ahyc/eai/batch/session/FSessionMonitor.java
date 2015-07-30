package com.ahyc.eai.batch.session;

import com.cyou.gccloud.common.datetime.IDateTimeConsole;
import com.cyou.gccloud.data.cache.FCacheSystemSessionLogic;
import com.cyou.gccloud.data.cache.FCacheSystemSessionUnit;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.lang.type.TTimeSpan;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.eng.data.IDatabaseConsole;

public class FSessionMonitor
      extends FAbstractMonitor
{
   public FSessionMonitor(){
      _name = "session.monitor";
      _valid = true;
      _interval = _minInterval;
   }

   private IDateTimeConsole _dateTimeConsole;

   private IDatabaseConsole _databaseConsole;

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FSessionMonitor.class);

   private TTimeSpan _outTime = new TTimeSpan(7 * 24 * 60 * 60 * 1000);

   private int _countInTick = 50;

   private int _minInterval = 10;

   private int _maxInterval = 60 * 1000;

   public void setDateTimeConsole(IDateTimeConsole console){
      _dateTimeConsole = console;
   }

   public void setDataBaseConsole(IDatabaseConsole console){
      _databaseConsole = console;
   }

   public void setOutdate(TTimeSpan span){
      _outTime = span;
   }

   public void setCountInTick(int count){
      _countInTick = count;
   }

   public void setTickIntervial(int time){
      _minInterval = time;
      _interval = time;
      if(_minInterval * 10 > _maxInterval){
         _maxInterval = _minInterval * 10;
      }
   }

   @Override
   public void initialize(){

      super.initialize();
   }

   @Override
   public boolean onExecute(){
      work();
      return true;
   }

   private void work(){

      try(FLogicContext logicContext = new FLogicContext(_databaseConsole)){
         FCacheSystemSessionLogic logic = logicContext.findLogic(FCacheSystemSessionLogic.class);
         proccess(logic);
      }catch(Exception e){
         _logger.error(this, "process", e);
         _interval = _maxInterval;
      }finally{

      }
   }

   // 修正tick时间
   private void feedbackInterval(int count){

      //如果是满负荷运行，不断缩小tick间隔
      if(count >= _countInTick){

         _interval -= (_interval / 2);
         if(_interval < _minInterval){
            _interval = _minInterval;
         }

      }else if(0 == count){

         _interval = _maxInterval;

      }else if(count < (_countInTick / 2)){ //如果始终低水平运行，就延长间隔

         _interval += (_interval / 2);
         if(_interval > _maxInterval){
            _interval = _maxInterval;
         }
      }
   }

   private void proccess(FCacheSystemSessionLogic logic){

      TDateTime outDate = _dateTimeConsole.getCurrentTime();

      outDate.sub(_outTime);

      String whereSql = String.format("(UPDATE_DATE < %s)", outDate);

      FLogicDataset<FCacheSystemSessionUnit> units = logic.fetch(null, whereSql, null, _countInTick, 0);

      if(null != units){
         feedbackInterval(units.count());
         for(FCacheSystemSessionUnit unit : units){
            logic.doDelete(unit);
         }
      }
   }

}
