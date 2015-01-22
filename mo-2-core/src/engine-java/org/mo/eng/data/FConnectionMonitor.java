package org.mo.eng.data;

import org.mo.core.monitor.common.FAbstractMonitor;

//============================================================
// <T>数据库链接监视器。</T>
//
// @history 080101 MAOCY 创建
//============================================================
public class FConnectionMonitor
      extends FAbstractMonitor
{
   // 数据库链接控制台
   protected IConnectionConsole _console;

   //============================================================
   // <T>构造数据库链接监视器。</T>
   //
   // @param console 数据库链接控制台
   //============================================================
   public FConnectionMonitor(IConnectionConsole console){
      _valid = true;
      _console = console;
   }

   //============================================================
   // <T>执行监视器的逻辑。</T>
   //============================================================
   @Override
   public void execute(){
      _console.refresh();
   }
}
