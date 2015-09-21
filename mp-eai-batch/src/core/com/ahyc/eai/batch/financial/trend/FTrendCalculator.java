package com.ahyc.eai.batch.financial.trend;

import com.ahyc.eai.batch.statistics.financial.customer.IStatisticsCustomerConsole;
import org.mo.com.lang.FDoubles;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.RAop;
import org.mo.data.logic.ILogicContext;

public class FTrendCalculator
{
   public double nextValue(FDoubles values){
      FTrendARIMA arima = new FTrendARIMA(values.toArray());
      int[] model = arima.getARIMAmodel();
      double value = arima.aftDeal(arima.predictValue(model[0], model[1]));
      return value;
   }

   public void process(ILogicContext logicContext){
      TDateTime currentDate = RDateTime.currentDateTime();
      currentDate.truncateDay();
      TDateTime beginDate = new TDateTime(currentDate.year() + "0101");
      TDateTime endDate = new TDateTime(currentDate.year() + "1231");
      IStatisticsCustomerConsole customerConsole = RAop.find(IStatisticsCustomerConsole.class);
      // 获得投资总计
      double investmentTotal = customerConsole.fetchInvestment(logicContext, beginDate);
      // 获得投资信息
      FDoubles investments = customerConsole.fetchDayInvestments(logicContext, beginDate, currentDate);
      TDateTime loopDate = beginDate.clone();
      int index = 0;
      while(true){
         String date = loopDate.format("YYYYMMDD");
         double value = 0;
         double total = 0;
         if(loopDate.get() < currentDate.get()){
            value = investments.get(index);
            total = investmentTotal + investments.calculateSum(index);
         }else{
            value = nextValue(investments);
            investments.append(value);
            total = investmentTotal + investments.calculateSum();
         }
         System.out.println(date + "\t" + value + "\t" + total);
         loopDate.addDay(1);
         index++;
         if(loopDate.get() > endDate.get()){
            break;
         }
      }
   }
}
