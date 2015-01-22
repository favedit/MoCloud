package org.mo.com.system;

import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>线程工具类。</T>
//============================================================
public class RThread
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(RThread.class);

   // 线程运行状态
   private static int _status = 0;

   // 默认线程事务间隔
   public static long DEFAULT_INTERVAL = 5000;

   // 默认线程优先级
   public static int DEFAULT_PRIORITY = 4;

   // 线程运行状态：运行中
   public static int STATUS_RUN = 1;

   // 线程运行状态：停止
   public static int STATUS_STOP = 2;

   //============================================================
   // <T>检查当前线程是否已经要求结束。</T>
   //
   // @return TRUE：是<br>FALSE：否
   //============================================================
   public static boolean checkStop(){
      return (_status == STATUS_STOP);
   }

   //============================================================
   // <T>获得线程运行状态。</T>
   //
   // @return 线程运行状态
   //============================================================
   public static int status(){
      return _status;
   }

   //============================================================
   // <T>线程休眠。</T>
   //
   // @param tick 时长
   //============================================================
   @SuppressWarnings("static-access")
   public static void sleep(int tick){
      try{
         Thread.currentThread().sleep(tick);
      }catch(Exception e){
         _logger.error(null, "sleep", e);
      }
   }

   //============================================================
   // <T>线程休眠。</T>
   //
   // @param tick 时长
   //============================================================
   @SuppressWarnings("static-access")
   public static void sleep(long tick){
      try{
         Thread.currentThread().sleep(tick);
      }catch(Exception e){
         _logger.error(null, "sleep", e);
      }
   }

   //============================================================
   // <T>通知所有线程结束。</T>
   //============================================================
   public static void stopAll(){
      _status = STATUS_STOP;
      _logger.info(null, "stopAll", "Stop all thread");
   }

   //============================================================
   // <T>生成线程代码。</T>
   //
   // @return 线程代码
   //============================================================
   public static String makeThreadCode(){
      String name = Thread.currentThread().getName();
      if(name.equalsIgnoreCase("main")){
         return "<MA>";
      }else if(name.startsWith("Thread-")){
         return "T" + RString.leftPad(name.substring(7), 3, "0");
      }else if(name.startsWith("localhost-startStop-")){
         return "L" + RString.leftPad(name.substring(20), 3, "0");
      }else if(name.startsWith("http-nio-") && name.contains("-exec-")){
         return "N" + RString.leftPad(name.substring(name.indexOf("-exec-") + 6), 3, "0");
      }else if(name.startsWith("http-bio-") && name.contains("-exec-")){
         return "B" + RString.leftPad(name.substring(name.indexOf("-exec-") + 6), 3, "0");
      }else if(name.startsWith("http-") && name.contains("Processor")){
         return "H" + RString.leftPad(name.substring(name.indexOf("Processor") + 9), 3, "0");
      }else if(name.startsWith("TP-Processor")){
         return "P" + RString.leftPad(name.substring(12), 3, "0");
      }else if(name.equals("JavaFX Application Thread")){
         return "<JF>";
      }else if(name.equals("ContainerBackgroundProcessor[StandardEngine[Catalina]]")){
         return "<CL>";
      }else{
         return name;
      }
   }
}
