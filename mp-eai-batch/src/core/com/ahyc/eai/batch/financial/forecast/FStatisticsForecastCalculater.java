package com.ahyc.eai.batch.financial.forecast;

import com.ahyc.eai.batch.common.EDataConnection;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialForecastLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialForecastUnit;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObject;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>金融动态统计计算器。</T>
//============================================================
public class FStatisticsForecastCalculater
      extends FObject
{
   protected FDictionary<FRow> _history = new FDictionary<FRow>(FRow.class);

   // 日志输出接口
   private static IResource _resource = RResource.find(FStatisticsForecastCalculater.class);

   protected double _currentInvestment;

   protected double _currentInvestmentTotal;

   protected double _delayRate[] = {200, 180, 150, 130, 120, 110, 100, 90, 80, 60, 40, 20, 10, 5, 2, 1};

   protected double _delayNumber[];

   //============================================================
   // <T>构造金融动态统计计算器。</T>
   //============================================================
   public FStatisticsForecastCalculater(){
   }

   public void calculateDate(TDateTime currentDate){
      String date = currentDate.format("YYYYMMDD");
      FRow dateRow = _history.find(date);
      if(dateRow != null){
         _currentInvestment = dateRow.getDouble("investment");
         _currentInvestmentTotal = dateRow.getDouble("investment_total");
      }else{
         // 找到当前日期前一天
         TDateTime priorDate = new TDateTime(currentDate);
         priorDate.addDay(-1);
         FRow priorRow = _history.find(priorDate.format("YYYYMMDD"));
         double priorInvestment = priorRow.getDouble("investment");
         // 计算影响参数
         double investmentRate1 = 0;
         double investmentRate2 = 0;
         for(int n = 0; n < 16; n++){
            // 找到当前内容
            TDateTime findDate = new TDateTime(currentDate);
            findDate.addDay(-7 * (n + 1));
            FRow findRow1 = _history.find(findDate.format("YYYYMMDD"));
            double investment1 = findRow1.getDouble("investment");
            // 找到前一天
            findDate.addDay(-1);
            FRow findRow2 = _history.find(findDate.format("YYYYMMDD"));
            double investment2 = findRow2.getDouble("investment");
            if(investment2 == 0){
               continue;
            }
            // 找到前一周
            findDate = new TDateTime(currentDate);
            findDate.addDay(-7 * (n + 2));
            FRow findRow3 = _history.find(findDate.format("YYYYMMDD"));
            double investment3 = findRow3.getDouble("investment");
            if(investment3 == 0){
               continue;
            }
            // 计算前日变化比率
            double investmentDayRate = (investment1 / investment2) * _delayNumber[n];
            double investmentWeekRate = (investment1 / investment3) * _delayNumber[n];
            // 计算前周变化比率
            //investmentRate += investmentDayRate * 0.4 + investmentWeekRate * 0.6;
            investmentRate1 += investmentDayRate;
            investmentRate2 += investmentWeekRate;
         }
         System.out.println(investmentRate1 + " - " + investmentRate2);
         //double investmentRate = investmentRate1 * 0.5 + investmentRate2 * 0.5;
         double investmentRate = investmentRate1;
         _currentInvestment = priorInvestment * investmentRate;
         _currentInvestmentTotal += _currentInvestment;
         // 增加新行
         FRow row = new FRow();
         row.set("investment", _currentInvestment);
         row.set("investment_total", _currentInvestmentTotal);
         _history.set(date, row);
      }
   }

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   public void process(FLogicContext logicContext){
      ISqlConnection connection = logicContext.activeConnection(EDataConnection.STATISTICS);
      // 计算比率
      double totalRate = 0;
      for(double rate : _delayRate){
         totalRate += rate;
      }
      int rateCount = _delayRate.length;
      _delayNumber = new double[rateCount];
      for(int i = 0; i < rateCount; i++){
         _delayNumber[i] = _delayRate[i] / totalRate;
      }
      // 获得数据
      FSql sql = _resource.findString(FSql.class, "sql.forecast");
      FDataset dataset = connection.fetchDataset(sql);
      for(FRow row : dataset){
         String date = row.get("record_day");
         if(date.equals("20150817")){
            continue;
         }
         _history.set(date, row);
      }
      // 清空数据
      connection.executeSql("DELETE FROM ST_FIN_FORECAST");
      // 新建数据
      FStatisticsFinancialForecastLogic forecastLogic = logicContext.findLogic(FStatisticsFinancialForecastLogic.class);
      TDateTime currentDate = new TDateTime();
      currentDate.parse("20150101", "YYYYMMDD");
      for(int day = 0; day < 365; day++){
         calculateDate(currentDate);
         // 新建数据
         FStatisticsFinancialForecastUnit forecastUnit = forecastLogic.doPrepare();
         forecastUnit.actionDate().assign(currentDate);
         forecastUnit.setInvestment(_currentInvestment);
         forecastUnit.setInvestmentTotal(_currentInvestmentTotal);
         forecastLogic.doInsert(forecastUnit);
         // 增加1天
         currentDate.addDay(1);
      }
   }
}
