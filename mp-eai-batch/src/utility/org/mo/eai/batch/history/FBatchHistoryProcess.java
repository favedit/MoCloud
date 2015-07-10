package org.mo.eai.batch.history;

import org.mo.com.io.FLinesFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FStrings;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.system.FThread;
import org.mo.eai.RResourceConfiguration;
import org.mo.eai.resource.history.FHistoryCityData;
import org.mo.eai.resource.history.FHistoryData;
import org.mo.eai.resource.history.FHistoryDateData;

//============================================================
// <T>历史数据打包处理。</T>
//
// @history 150710 MAOCY 创建
//============================================================
public class FBatchHistoryProcess
      extends FThread
{
   // 间隔(5分钟)
   protected int _interval = 1000 * 60 * 5;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @return 处理结果
   //============================================================
   public void makeHistoryData(){
      String path = "D:/Temp/history";
      FHistoryData history = new FHistoryData();
      // 加载历史数据
      FStrings fileNames = RFile.listFiles(path);
      fileNames.sort();
      for(String fileName : fileNames){
         // 检查文件
         if(!fileName.endsWith(".txt")){
            continue;
         }
         // 打开文件
         FLinesFile file = new FLinesFile(fileName);
         for(String line : file.lines()){
            if(!RString.isEmpty(line)){
               String[] items = RString.split(line, ' ');
               String dateValue = null;
               int card = 0;
               float investmentDay = 0;
               float investmentTotal = 0;
               if(items.length == 4){
                  dateValue = items[0];
                  card = RInteger.parse(items[1]);
                  investmentDay = RFloat.parse(items[2]);
                  investmentTotal = RFloat.parse(items[3]);
               }else{
                  // 检查非法行
                  System.out.println("Invalid line:" + fileName + " [" + line + "]");
                  continue;
               }
               // 创建数据项
               FHistoryCityData city = new FHistoryCityData();
               city.setCode(card);
               city.setInvestmentDay(investmentDay);
               city.setInvestmentTotal(investmentTotal);
               history.push(dateValue, city);
            }
         }
      }
      // 输出范围
      FHistoryDateData startDate = history.dates().value(0);
      FHistoryDateData endDate = history.dates().value(history.dates().count() - 1);
      System.out.println("Calculate range: " + startDate.code() + " - " + endDate.code());
      // 计算数据
      history.calculate();
      // 存储文件
      //history.serializeFile("D:/Temp/history/investment.dat");
      history.serializeFile(RResourceConfiguration.HomeResource + "/investment.dat");
   }

   public static void main(String[] args){
      new FBatchHistoryProcess().makeHistoryData();
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @return 处理结果
   //============================================================
   @Override
   public boolean execute(){
      while(!checkStop()){
         // 生成数据
         makeHistoryData();
         // 睡眠处理
         trySleep(_interval);
      }
      return true;
   }

}
