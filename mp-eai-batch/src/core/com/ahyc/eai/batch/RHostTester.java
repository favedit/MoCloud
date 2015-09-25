package com.ahyc.eai.batch;

import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.RNet;

//============================================================
// <T>统计计算器。</T>
//============================================================
public class RHostTester
      extends FObject
{
   // 日志输出接口
   protected static ILogger _logger = RLogger.find(RHostTester.class);

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   public static void main(String[] args){
      // 打印参数
      try{
         String hostName = RNet.hostName();
         System.out.println("-- HostName [" + hostName + "]");
      }catch(Exception exception){
         _logger.error(null, "main", exception);

      }
   }
}
