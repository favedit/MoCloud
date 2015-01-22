package org.mo.core.aop.dispatcher;

import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>调用分析器。</T>
//============================================================
public class FAopInvokeAnalyzer
      extends FObject
{
   // 调用次数
   private long _count;

   // 总共间隔
   private long _spanTotal;

   // 最短间隔
   private long _spanMin;

   // 最长间隔
   private long _spanMax;

   //============================================================
   // <T>构造调用分析器。</T>
   //============================================================
   public FAopInvokeAnalyzer(){
      _spanMin = Long.MAX_VALUE;
   }

   //============================================================
   // <T>获得次数。</T>
   //
   // @return 次数
   //============================================================
   public long count(){
      return _count;
   }

   //============================================================
   // <T>获得总共间隔。</T>
   //
   // @return 总共间隔
   //============================================================
   public long spanTotal(){
      return _spanTotal;
   }

   //============================================================
   // <T>获得最小间隔。</T>
   //
   // @return 最小间隔
   //============================================================
   public long spanMin(){
      return _spanMin;
   }

   //============================================================
   // <T>获得最大间隔。</T>
   //
   // @return 最大间隔
   //============================================================
   public long spanMax(){
      return _spanMax;
   }

   //============================================================
   // <T>获得平均间隔。</T>
   //
   // @return 平均间隔
   //============================================================
   public long spanAvg(){
      long result = 0;
      if(_count > 0){
         result = _spanTotal / _count;
      }
      return result;
   }

   //============================================================
   // <T>调用监视处理。</T>
   //
   // @param span 间隔
   //============================================================
   public void invokeMonitor(long span){
      _count++;
      _spanTotal += span;
      if(span < _spanMin){
         _spanMin = span;
      }
      if(span > _spanMax){
         _spanMax = span;
      }
   }

   //============================================================
   // <T>存储配置信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("count", _count);
      xconfig.set("total", _spanTotal);
      xconfig.set("min", _spanMin);
      xconfig.set("max", _spanMax);
      xconfig.set("avg", spanAvg());
   }
}
