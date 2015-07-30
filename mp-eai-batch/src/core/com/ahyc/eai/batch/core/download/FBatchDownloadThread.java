package com.ahyc.eai.batch.core.download;

import org.mo.com.system.FThread;

//============================================================
// <T>下载线程。</T>
//============================================================
public class FBatchDownloadThread
      extends FThread
{
   // 下载控制台
   protected IBatchDownloadConsole _console;

   // 休眠时间
   protected int _interval = 10000;

   //============================================================
   // <T>获得控制台。</T>
   //
   // @return 控制台
   //============================================================
   public IBatchDownloadConsole console(){
      return _console;
   }

   //============================================================
   // <T>设置控制台。</T>
   //
   // @param console 控制台
   //============================================================
   public void setConsole(IBatchDownloadConsole console){
      _console = console;
   }

   //============================================================
   // <T>获得间隔。</T>
   //
   // @return 间隔
   //============================================================
   public int interval(){
      return _interval;
   }

   //============================================================
   // <T>设置间隔。</T>
   //
   // @param interval 间隔
   //============================================================
   public void setInterval(int interval){
      _interval = interval;
   }

   //============================================================
   // <T>运行当前线程的事务。</T>
   //
   // @return TRUE：成功<br>FALSE：失败
   //============================================================
   @Override
   public boolean execute(){
      while(!checkStop()){
         _console.process();
         trySleep(_interval);
      }
      return false;
   }
}
