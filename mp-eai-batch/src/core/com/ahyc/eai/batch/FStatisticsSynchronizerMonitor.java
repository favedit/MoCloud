package com.ahyc.eai.batch;

import com.ahyc.eai.batch.statistics.financial.customer.IStatisticsCustomerConsole;
import com.ahyc.eai.batch.statistics.financial.department.IStatisticsDepartmentConsole;
import com.ahyc.eai.batch.statistics.financial.marketer.FStatisticsMarketerSynchronizer;
import com.ahyc.eai.batch.statistics.financial.marketer.IStatisticsMarketerConsole;
import com.ahyc.eai.batch.statistics.financial.member.FStatisticsMemberSynchronizer;
import com.ahyc.eai.batch.statistics.financial.member.IStatisticsMemberConsole;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>统计监视器。</T>
//============================================================
public class FStatisticsSynchronizerMonitor
      extends FAbstractMonitor
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsSynchronizerMonitor.class);

   // 默认间隔
   protected long _defaultInterval = 1000 * 10;

   // 数据库控制台
   protected IDatabaseConsole _databaseConsole;

   //============================================================
   // <T>统计监视器。</T>
   //============================================================
   public FStatisticsSynchronizerMonitor(IDatabaseConsole databaseConsole){
      _groupName = "statistics.synchronizer";
      _name = "analysis.synchronizer";
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
         // 清空部门控制台
         IStatisticsMemberConsole memberConsole = RAop.find(IStatisticsMemberConsole.class);
         memberConsole.clear();
         IStatisticsCustomerConsole customerConsole = RAop.find(IStatisticsCustomerConsole.class);
         customerConsole.clear();
         IStatisticsMarketerConsole marketerConsole = RAop.find(IStatisticsMarketerConsole.class);
         marketerConsole.clear();
         IStatisticsDepartmentConsole departmentConsole = RAop.find(IStatisticsDepartmentConsole.class);
         departmentConsole.clear();
         //............................................................
         // 同步用户
         FStatisticsMemberSynchronizer memberSynchronizer = new FStatisticsMemberSynchronizer();
         memberSynchronizer.process(logicContext);
         processCount += memberSynchronizer.processCount();
         // 同步理财师
         FStatisticsMarketerSynchronizer marketerSynchronizer = new FStatisticsMarketerSynchronizer();
         marketerSynchronizer.process(logicContext);
         processCount += marketerSynchronizer.processCount();
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
