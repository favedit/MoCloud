package org.mo.eai.batch.history;

import org.mo.com.io.FLinesFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FStrings;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RString;
import org.mo.com.system.FThread;
import org.mo.eai.RResourceConfiguration;
import org.mo.eai.RResourceExportor;
import org.mo.eai.resource.history.FHistoryCityData;
import org.mo.eai.resource.history.FHistoryData;
import org.mo.eai.resource.history.FHistoryDateData;
import org.mo.eai.template.card.FCardTemplate;

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

   // 输入目录
   private String _dataPath;

   // 输出目录
   private String _outputFileName;

   //============================================================
   // <T>获得数据路径。</T>
   //
   // @return 数据路径
   //============================================================
   public String dataPath(){
      return _dataPath;
   }

   //============================================================
   // <T>设置数据路径。</T>
   //
   // @param dataPath 数据路径
   //============================================================
   public void setDataPath(String dataPath){
      _dataPath = dataPath;
   }

   //============================================================
   // <T>获得输出文件名称。</T>
   //
   // @return 输出文件名称
   //============================================================
   public String outputFileName(){
      return _outputFileName;
   }

   //============================================================
   // <T>设置输出文件名称。</T>
   //
   // @param outputFileName 输出文件名称
   //============================================================
   public void setOutputFileName(String outputFileName){
      _outputFileName = outputFileName;
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @return 处理结果
   //============================================================
   public void makeHistoryData(){
      FCardTemplate cardTemplate = RResourceExportor.cardTemplate();
      FHistoryData history = new FHistoryData();
      // 加载历史数据
      FStrings fileNames = RFile.listFiles(_dataPath);
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
               if(items.length != 4){
                  String lineValue = line.replace("  ", " ").trim();
                  items = RString.split(lineValue, ' ');
               }
               String dateValue = null;
               String card = null;
               float investmentDay = 0;
               float investmentTotal = 0;
               if(items.length == 4){
                  dateValue = items[0];
                  card = items[1];
                  investmentDay = RFloat.parse(items[2]);
                  investmentTotal = RFloat.parse(items[3]);
               }else{
                  // 检查非法行
                  System.out.println("Invalid line:" + fileName + " [" + line + "]");
                  continue;
               }
               // 创建数据项
               String cityCode = cardTemplate.findCityCode(card);
               FHistoryCityData city = history.findCity(dateValue, cityCode);
               if(city == null){
                  city = new FHistoryCityData();
                  city.setCode(cityCode);
                  history.push(dateValue, city);
               }
               city.addInvestmentDay(investmentDay);
               city.addInvestmentTotal(investmentTotal);
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
      history.serializeFile(_outputFileName);
   }

   //============================================================
   // <T>本地测试处理。</T>
   //
   // @param args 参数集合
   //============================================================
   public static void main(String[] args){
      FBatchHistoryProcess process = new FBatchHistoryProcess();
      process.setDataPath("D:/Temp/history");
      process.setOutputFileName(RResourceConfiguration.HomeResource + "/investment.dat");
      process.makeHistoryData();
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
