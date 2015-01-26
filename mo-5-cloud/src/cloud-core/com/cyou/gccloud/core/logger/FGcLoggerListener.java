package com.cyou.gccloud.core.logger;

import org.mo.com.lang.FString;
import org.mo.com.lang.FThrowables;
import org.mo.com.lang.RString;
import org.mo.com.lang.RThrowable;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.logging.MLoggerListener;
import org.mo.com.logging.SLoggerInfo;
import org.mo.com.system.RThread;

//============================================================
// <T>日志控制台输出监听器。</T>
//============================================================
public class FGcLoggerListener
      extends MLoggerListener
{
   // 控制台
   protected IGcLoggerConsole _console;

   //============================================================
   // <T>构造日志控制台输出监听器。</T>
   //============================================================
   public FGcLoggerListener(IGcLoggerConsole console){
      super(console);
      _console = console;
   }

   //============================================================
   // <T>输出日志处理。</T>
   //
   // @param sender 发出者
   // @param level 级别
   // @param message 日志信息
   //============================================================
   @Override
   protected void output(Object sender,
                         int command,
                         FString message){
   }

   //============================================================
   // <T>建立消息信息字符串。</T>
   //
   // @param result 结果
   // @param info 信息
   //============================================================
   @Override
   protected void buildMessage(FString result,
                               SLoggerInfo info){
      // 建立线程信息
      String threadName = RThread.makeThreadCode();
      // 获得引用对象信息
      String refer = null;
      Object reference = info.reference;
      if(reference instanceof String){
         refer = "(" + (String)reference + ")";
      }else{
         refer = RClass.shortName(reference);
         if(reference != null){
            refer += "@" + Integer.toHexString(reference.hashCode()).toUpperCase();
         }
      }
      if(info.method != null){
         refer += "." + info.method;
      }
      // 建立引用信息
      if(info.timeSpan > 0){
         info.referInfo = threadName + " - " + refer + " (" + info.timeSpan + "ms)";
      }else{
         info.referInfo = threadName + " - " + refer;
      }
      // 建立信息
      String message = info.message;
      if(message != null){
         Object[] params = info.parameters;
         if(params != null){
            message = RString.format(message, params);
         }
         result.append(message);
      }
      if(info.throwable != null){
         // 建立例外堆栈
         FThrowables stack = RThrowable.buildStack(info.throwable);
         // 建立例外消息
         RThrowable.buildMessage(result, stack);
      }
   }

   //============================================================
   // <T>日志处理。</T>
   //
   // @param sender 发出者
   // @param level 级别
   // @param info 信息
   //============================================================
   @Override
   public boolean processLogger(Object sender,
                                int level,
                                SLoggerInfo info){
      //      ELoggerLevel levelCd = info.levelCd;
      //      // 建立信息
      //      if(ELoggerLevel.isOutputAble(levelCd)){
      //         // 获得信息
      //         FString message = new FString();
      //         buildMessage(message, info);
      //         String referInfo = info.referInfo;
      //         String messageInfo = message.toString();
      //         // 发布信息
      //         switch(levelCd){
      //            case INFO:
      //               _console.push(new FGcLoggerSystemLogger(0, EGcSystemLogger.Info, referInfo, messageInfo));
      //               break;
      //            case WARN:
      //               _console.push(new FGcLoggerSystemLogger(0, EGcSystemLogger.Warn, referInfo, messageInfo));
      //               break;
      //            case ERROR:
      //               _console.push(new FGcLoggerSystemLogger(0, EGcSystemLogger.Error, referInfo, messageInfo));
      //               break;
      //            case FATAL:
      //               _console.push(new FGcLoggerSystemException(0, referInfo, message.toString()));
      //               break;
      //            default:
      //               break;
      //
      //         }
      //      }
      return true;
   }
}
