package com.ahyc.eai.batch.financial;

import com.ahyc.eai.batch.financial.customer.FStatisticsCustomerCalculater;
import com.ahyc.eai.batch.financial.department.FStatisticsDepartmentCalculater;
import com.ahyc.eai.batch.financial.department.IStatisticsDepartmentInfoConsole;
import com.ahyc.eai.batch.financial.dynamic.FStatisticsDynamicCalculater;
import com.ahyc.eai.batch.financial.dynamic.FStatisticsInvestmentCalculater;
import com.ahyc.eai.batch.financial.dynamic.FStatisticsRedemptionCalculater;
import com.ahyc.eai.batch.financial.marketer.FStatisticsMarketerCalculater;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>统计监视器。</T>
//============================================================
public class FStatisticsMonitor
      extends FAbstractMonitor
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsMonitor.class);

   // 默认间隔
   protected long _defaultInterval = 1000 * 10;

   // 数据库控制台
   protected IDatabaseConsole _databaseConsole;

   //============================================================
   // <T>统计监视器。</T>
   //============================================================
   public FStatisticsMonitor(IDatabaseConsole databaseConsole){
      _name = "analysis.activity";
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
         IStatisticsDepartmentInfoConsole departmentInfoConsole = RAop.find(IStatisticsDepartmentInfoConsole.class);
         departmentInfoConsole.clear();
         //............................................................
         // 计算投资
         FStatisticsInvestmentCalculater investmentCalculater = new FStatisticsInvestmentCalculater();
         investmentCalculater.process(logicContext);
         processCount += investmentCalculater.processCount();
         // 计算赎回
         FStatisticsRedemptionCalculater redemptionCalculater = new FStatisticsRedemptionCalculater();
         redemptionCalculater.process(logicContext);
         processCount += redemptionCalculater.processCount();
         // 计算动态数据
         FStatisticsDynamicCalculater dynamicCalculater = new FStatisticsDynamicCalculater();
         dynamicCalculater.process(logicContext);
         processCount += dynamicCalculater.processCount();
         //............................................................
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
      if(processCount > 0){
         _interval = 10;
      }else{
         _interval = _defaultInterval;
      }
      return true;
   }
}
