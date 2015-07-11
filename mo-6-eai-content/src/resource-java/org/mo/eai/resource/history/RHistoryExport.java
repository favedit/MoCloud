package org.mo.eai.resource.history;

import org.mo.com.io.FLinesFile;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.eai.RResourceConfiguration;

public class RHistoryExport
{
   public static void main(String[] args){
      // 加载历史数据
      FHistoryData history = new FHistoryData();
      FLinesFile file = new FLinesFile();
      file.loadFile(RResourceConfiguration.HomeData + "/history/investment.txt");
      for(String line : file.lines()){
         if(!RString.isEmpty(line)){
            String[] items = RString.split(line, ' ');
            if(items.length != 4){
               throw new FFatalError("Invalid count.");
            }
            String dateValue = RString.removeChar(items[0], '-');
            FHistoryCityData city = new FHistoryCityData();
            city.setCode(RInteger.parse(items[1]));
            city.setInvestmentDay(RFloat.parse(items[2]));
            city.setInvestmentTotal(RFloat.parse(items[3]));
            history.push(dateValue, city);
            // System.out.println(items[0]);
         }
      }
      FHistoryDateData startDate = history.dates().value(0);
      FHistoryDateData endDate = history.dates().value(history.dates().count() - 1);
      System.out.println(startDate.code() + " - " + endDate.code());
      // 计算数据
      history.calculate();
      // 存储文件
      history.serializeFile(RResourceConfiguration.HomeResource + "/investment.dat");
   }
}
