package com.ahyc.eai.batch.data.financial.trend;

import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ELoggerLevel;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>投资趋势计算器。</T>
//============================================================
public class RTrendCalculator
{
   // 日志输出接口
   protected static ILogger _logger = RLogger.find(RTrendCalculator.class);

   //============================================================
   // <T>投资趋势处理。</T>
   //============================================================
   public static void main(String args[]){
      _logger.debug(null, "main", "-- Trend calculater start.");
      args = new String[]{"work"};
      // 打印参数
      int count = args.length;
      for(int i = 0; i < count; i++){
         System.out.println(" [" + i + "] " + args[i]);
      }
      // 检查参数
      if(args.length != 1){
         throw new FFatalError("Argements count failure");
      }
      String modeCd = RString.trim(args[0]);
      if(!modeCd.equals("work") && !modeCd.equals("test") && !modeCd.equals("online")){
         throw new FFatalError("Mode type failure.");
      }
      // 加载配置
      FAttributes attributes = RAop.configConsole().defineCollection().attributes();
      attributes.set("application", "D:/Microbject/MoCloud");
      RAop.initialize("D:/Microbject/MoCloud/mp-eai-batch/src/config//application-work.xml");
      // 设置日志
      RLogger.setFlags(ELoggerLevel.NO_DEBUG.value());
      // 逻辑处理
      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      // 计算数据
      try(FLogicContext logicContext = new FLogicContext(databaseConsole)){
         FTrendCalculator calculator = new FTrendCalculator();
         calculator.process(logicContext);
      }catch(Exception exception){
         _logger.error(null, "main", exception);
      }
      // 结束处理
      RAop.release();
      _logger.debug(null, "main", "-- Trend calculater stop.");
   }
}
