package org.mo.eng.session;

import org.mo.core.monitor.common.FAbstractMonitor;

//============================================================
// <T>会话监视器。</T>
//============================================================
public class FSessionMonitor
      extends FAbstractMonitor
{
   // 会话控制台
   protected FSessionConsole _console;

   //============================================================
   // <T>构造会话监视器。</T>
   //============================================================
   public FSessionMonitor(){
   }

   //============================================================
   // <T>获得会话控制台。</T>
   //
   // @return 会话控制台
   //============================================================
   public FSessionConsole console(){
      return _console;
   }

   //============================================================
   // <T>设置会话控制台。</T>
   //
   // @param console 会话控制台
   //============================================================
   public void setConsole(FSessionConsole console){
      _console = console;
   }

   //============================================================
   // <T>执行逻辑处理。</T>
   //
   // @param console 会话控制台
   //============================================================
   @Override
   public void execute(){
      _console.refresh();
   }
}
