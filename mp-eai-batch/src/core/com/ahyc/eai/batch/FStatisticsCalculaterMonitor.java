package com.ahyc.eai.batch;

import com.ahyc.eai.batch.statistics.financial.customer.FStatisticsCustomerCalculater;
import com.ahyc.eai.batch.statistics.financial.customer.IStatisticsCustomerConsole;
import com.ahyc.eai.batch.statistics.financial.department.FStatisticsDepartmentCalculater;
import com.ahyc.eai.batch.statistics.financial.department.IStatisticsDepartmentConsole;
import com.ahyc.eai.batch.statistics.financial.marketer.FStatisticsMarketerCalculater;
import com.ahyc.eai.batch.statistics.financial.marketer.IStatisticsMarketerConsole;
import com.ahyc.eai.batch.statistics.financial.member.IStatisticsMemberConsole;
import com.ahyc.eai.batch.statistics.financial.tender.FStatisticsTenderCalculater;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>统计监视器。</T>
//============================================================
public class FStatisticsCalculaterMonitor
      extends FAbstractMonitor
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsCalculaterMonitor.class);

   // 默认间隔
   protected long _defaultInterval = 1000 * 10;

   // 数据库控制台
   protected IDatabaseConsole _databaseConsole;

   //============================================================
   // <T>统计监视器。</T>
   //============================================================
   public FStatisticsCalculaterMonitor(IDatabaseConsole databaseConsole){
      _groupName = "statistics.calculater";
      _name = "analysis.calculater";
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
         // 统计投标信息
         FStatisticsTenderCalculater tenderCalculater = new FStatisticsTenderCalculater();
         tenderCalculater.process(logicContext);
         processCount += tenderCalculater.processCount();
         // 统计客户信息
         FStatisticsCustomerCalculater customerCalculater = new FStatisticsCustomerCalculater();
         customerCalculater.process(logicContext);
         processCount += customerCalculater.processCount();
         // 统计理财师信息
         FStatisticsMarketerCalculater marketerCalculater = new FStatisticsMarketerCalculater();
         marketerCalculater.process(logicContext);
         processCount += marketerCalculater.processCount();
         // 统计部门信息
         FStatisticsDepartmentCalculater departmentCalculater = new FStatisticsDepartmentCalculater();
         departmentCalculater.process(logicContext);
         processCount += departmentCalculater.processCount();
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
