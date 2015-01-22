package org.mo.core.aop.dispatcher;

import java.lang.reflect.Method;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObject;
import org.mo.com.lang.INamePair;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>类调用分析器。</T>
//============================================================
public class FAopClassAnalyzer
      extends FObject
{
   // 处理器集合
   protected FDictionary<FAopInvokeAnalyzer> _invokeAnalyzers = new FDictionary<FAopInvokeAnalyzer>(FAopInvokeAnalyzer.class);

   //============================================================
   // <T>构造类调用分析器。</T>
   //============================================================
   public FAopClassAnalyzer(){
   }

   //============================================================
   // <T>获得调用分析器字典。</T>
   //
   // @return 调用分析器字典
   //============================================================
   public FDictionary<FAopInvokeAnalyzer> invokeAnalyzers(){
      return _invokeAnalyzers;
   }

   //============================================================
   // <T>调用监视处理。</T>
   //
   // @param method 函数
   // @param span 间隔
   //============================================================
   public void invokeMonitor(Method method,
                             long span){
      String methodName = method.getName();
      // 获得调用分析器
      FAopInvokeAnalyzer invokeAnalyzer = _invokeAnalyzers.get(methodName, null);
      if(invokeAnalyzer == null){
         invokeAnalyzer = new FAopInvokeAnalyzer();
         _invokeAnalyzers.set(methodName, invokeAnalyzer);
      }
      // 调用处理
      invokeAnalyzer.invokeMonitor(span);
   }

   //============================================================
   // <T>存储配置信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      for(INamePair<FAopInvokeAnalyzer> pair : _invokeAnalyzers){
         String methodName = pair.name();
         FAopInvokeAnalyzer invokeAnalyzer = pair.value();
         // 创建节点
         FXmlNode xmethod = xconfig.createNode("Method");
         xmethod.set("name", methodName);
         // 存储信息
         invokeAnalyzer.saveConfig(xmethod);
      }
   }
}
