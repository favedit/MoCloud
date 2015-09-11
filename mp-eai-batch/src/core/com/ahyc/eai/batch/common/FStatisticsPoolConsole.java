package com.ahyc.eai.batch.common;

import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>统计缓冲控制台。</T>
//============================================================
public class FStatisticsPoolConsole<T extends FLogicUnit>
      extends FConsole
      implements
         IStatisticsPoolConsole
{
   // 缓冲字典
   protected FDictionary<T> _pool;

   //============================================================
   // <T>构造统计缓冲控制台。</T>
   //============================================================
   public FStatisticsPoolConsole(Class<T> clazz){
      _pool = new FDictionary<T>(clazz);
   }

   //============================================================
   // <T>清空处理。</T>
   //============================================================
   @Override
   public void clear(){
      _pool.clear();
   }
}
