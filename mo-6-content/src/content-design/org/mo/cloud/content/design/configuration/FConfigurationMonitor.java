package org.mo.cloud.content.design.configuration;

import org.mo.core.monitor.common.FAbstractMonitor;

//============================================================
// <T>节点变化监视器基类。</T>
//============================================================
public class FConfigurationMonitor
      extends FAbstractMonitor
{
   // 配置节点
   private FConfigurationConsole _console;

   //============================================================
   // <T>构造节点变化监视器基类。</T>
   //============================================================
   public FConfigurationMonitor(){
      _interval = 1000 * 5;
   }

   //============================================================
   // <T>获得配置控制台。</T>
   //
   // @return 配置控制台
   //============================================================
   public FConfigurationConsole console(){
      return _console;
   }

   //============================================================
   // <T>设置配置控制台。</T>
   //
   // @param console 配置控制台
   //============================================================
   public void setConsole(FConfigurationConsole console){
      _console = console;
   }

   //============================================================
   // <T>执行监视器的逻辑。</T>
   //
   // @return 处理结果
   //============================================================
   @Override
   public boolean onExecute(){
      _console.check();
      return true;
   }
}
