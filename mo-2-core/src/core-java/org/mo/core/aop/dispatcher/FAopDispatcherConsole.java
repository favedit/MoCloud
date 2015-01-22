package org.mo.core.aop.dispatcher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.FString;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.RString;
import org.mo.com.lang.reflect.FClass;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>AOP处理器控制台。</T>
//============================================================
public class FAopDispatcherConsole
      extends FConsole
{
   // 日志输出接口
   protected static ILogger _logger = RLogger.find(FAopDispatcherConsole.class);

   // 监视调用
   @AProperty
   protected boolean _monitorInvoke;

   // 处理器集合
   protected FObjects<IAopDispatcher> _dispatchers = new FObjects<IAopDispatcher>(IAopDispatcher.class);

   // 类调用分析器字典
   protected FDictionary<FAopClassAnalyzer> _classAnalyzers = new FDictionary<FAopClassAnalyzer>(FAopClassAnalyzer.class);

   //============================================================
   // <T>构造AOP处理器控制台。</T>
   //============================================================
   public FAopDispatcherConsole(){
   }

   //============================================================
   // <T>获得监视调用。</T>
   //
   // @return 监视调用
   //============================================================
   public boolean monitorInvoke(){
      return _monitorInvoke;
   }

   //============================================================
   // <T>获得处理器集合。</T>
   //
   // @return 处理器集合
   //============================================================
   public FObjects<IAopDispatcher> dispatchers(){
      return _dispatchers;
   }

   //============================================================
   // <T>获得类调用分析器字典。</T>
   //
   // @return 类调用分析器字典
   //============================================================
   public FDictionary<FAopClassAnalyzer> classAnalyzers(){
      return _classAnalyzers;
   }

   //============================================================
   // <T>创建处理对象。</T>
   //============================================================
   @SuppressWarnings("unchecked")
   public <V> V createDispatchObject(Object component,
                                     FClass<?> face){
      InvocationHandler handler = new FAopDispatcher(this, component);
      ClassLoader loader = component.getClass().getClassLoader();
      Class<?>[] faceClasses = new Class<?>[]{face.nativeObject()};
      return (V)Proxy.newProxyInstance(loader, faceClasses, handler);
   }

   //============================================================
   // <T>调用开始处理。</T>
   //
   // @param instance 实例
   // @param proxy 代理
   // @param method 函数
   // @param args 参数集合
   //============================================================
   public synchronized void invokeBefore(Object instance,
                                         Object proxy,
                                         Method method,
                                         Object[] args){
      if(_logger.debugAble()){
         FString message = new FString();
         //message.append(proxy.getClass().getName());
         //message.append(".");
         //message.append(method.getName());
         if(args != null){
            int count = args.length;
            message.append("(");
            for(int n = 0; n < count; n++){
               if(n > 0){
                  message.append(", ");
               }
               message.append(args[n]);
            }
            message.append(") ");
         }
         _logger.debug(instance, method.getName() + " >", message.toString());
      }
   }

   //============================================================
   // <T>调用结束处理。</T>
   //
   // @param instance 实例
   // @param proxy 代理
   // @param method 函数
   // @param result 结果
   // @param args 参数集合
   //============================================================
   public synchronized void invokeAfter(Object instance,
                                        Object proxy,
                                        Method method,
                                        Object result,
                                        Object[] args){
      if(_logger.debugAble()){
         FString message = new FString();
         if(result instanceof String){
            result = RString.singleLine((String)result);
         }
         message.append(result);
         _logger.debug(instance, method.getName() + " <", message.toString());
      }
   }

   //============================================================
   // <T>调用监视处理。</T>
   //
   // @param instance 实例
   // @param method 函数
   // @param span 间隔
   //============================================================
   public synchronized void invokeMonitor(Object instance,
                                          Method method,
                                          long span){
      String className = instance.getClass().getName();
      // 获得类分析器
      FAopClassAnalyzer classAnalyzer = _classAnalyzers.get(className, null);
      if(classAnalyzer == null){
         classAnalyzer = new FAopClassAnalyzer();
         _classAnalyzers.set(className, classAnalyzer);
      }
      // 调用监视处理
      classAnalyzer.invokeMonitor(method, span);
   }

   //============================================================
   // <T>调用例外处理。</T>
   //
   // @param instance 实例
   // @param proxy 代理
   // @param method 函数
   // @param args 参数集合
   // @param throwable 抛出对象
   //============================================================
   public synchronized boolean invokeException(Object instance,
                                               Object proxy,
                                               Method method,
                                               Object[] args,
                                               Throwable throwable){
      int count = _dispatchers.count();
      for(int n = 0; n < count; n++){
         IAopDispatcher dispatcher = _dispatchers.get(n);
         if(dispatcher.process(throwable)){
            return true;
         }
      }
      FString message = new FString("exception......");
      if(args != null){
         count = args.length;
         message.append("(");
         for(int n = 0; n < count; n++){
            if(n > 0){
               message.append(", ");
            }
            message.append(args[n]);
         }
         message.append(") ");
      }
      _logger.error(this, "invokeException", throwable, message.toString());
      return false;
   }

   //============================================================
   // <T>存储配置信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveInvokeConfig(FXmlNode xconfig){
      for(INamePair<FAopClassAnalyzer> pair : _classAnalyzers){
         String className = pair.name();
         FAopClassAnalyzer classAnalyzer = pair.value();
         // 创建节点
         FXmlNode xclass = xconfig.createNode("Class");
         xclass.set("name", className);
         // 存储信息
         classAnalyzer.saveConfig(xclass);
      }
   }
}
