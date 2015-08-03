package com.ahyc.eai.batch.financial;

import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.core.monitor.IMonitorConsole;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>统计计算器。</T>
//============================================================
public class RStatisticsCalculater
      extends FObject
{
   // 日志输出接口
   protected static ILogger _logger = RLogger.find(RStatisticsCalculater.class);

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   public static void main(String[] args){
      // 打印参数
      System.out.println("-- Statistics calculater start");
      int count = args.length;
      for(int i = 0; i < count; i++){
         System.out.println(" [" + i + "] " + args[i]);
      }
      // 检查参数
      if(args.length != 1){
         throw new FFatalError("Argements count failure");
      }
      String modeCd = RString.trim(args[0]);
      if(!modeCd.equals("test") && !modeCd.equals("online")){
         throw new FFatalError("Mode type failure.");
      }
      // 设置属性
      FAttributes attributes = RAop.configConsole().defineCollection().attributes();
      attributes.set("application", "/data/eai/eai.batch");
      // 加载配置
      RAop.initialize("/data/eai/eai.batch/webroot/WEB-INF/classes/application-" + modeCd + ".xml");
      // 逻辑处理
      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      // 启动监视器
      FStatisticsMonitor monitor = new FStatisticsMonitor(databaseConsole);
      IMonitorConsole monitorConsole = RAop.find(IMonitorConsole.class);
      monitorConsole.start(monitor);
      monitorConsole.waitStop();
      // 结束处理
      RAop.release();
   }
}
