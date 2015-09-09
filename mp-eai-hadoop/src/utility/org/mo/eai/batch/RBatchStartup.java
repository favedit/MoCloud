package org.mo.eai.batch;

import org.mo.eai.RResourceConfiguration;
import org.mo.eai.batch.history.FBatchHistoryProcess;

public class RBatchStartup
{
   public static void main(String[] args){
      // 设置变量
      RResourceConfiguration.HomeData = "/data/eai/template";
      RResourceConfiguration.HomeResource = "/data/eai/script/ars/eai";
      // 运行线程
      FBatchHistoryProcess process = new FBatchHistoryProcess();
      process.setDataPath("/data/eai/history");
      process.setOutputFileName("/data/eai/script/ars/eai/investment.dat");
      process.start();
   }
}
