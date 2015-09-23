package org.mo.cloud.common.datetime;

import org.mo.core.monitor.common.FAbstractMonitor;

//============================================================
// <T>时间监视器。</T>
//============================================================
public class FDataTimeMonitor
      extends FAbstractMonitor
{
   // 获得时间控制台
   protected FDateTimeConsole _console;

   //============================================================
   // <T>构造时间监视器。</T>
   //============================================================
   public FDataTimeMonitor(){
      _name = "datetime.monitorr";
      _interval = 300000;
   }

   //============================================================
   // <T>设置时间控制台。</T>
   //
   // @param console 控制台
   //============================================================
   public void setConsole(FDateTimeConsole console){
      _console = console;
   }

   //============================================================
   // <T>逻辑执行处理。</T>
   //
   // @return 逻辑处理
   //============================================================
   @Override
   public boolean onExecute(){
      return _console.refresh();
   }
}
