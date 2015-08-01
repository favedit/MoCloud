package com.ahyc.eai.batch.financial;

import org.mo.com.lang.FObject;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>统计计算器。</T>
//============================================================
public class FStatisticsCalculater
      extends FObject
{
   // 处理总数
   protected long _processTotal;

   // 处理次数
   protected long _processCount;

   //============================================================
   // <T>获得处理总数。</T>
   //============================================================
   public long processTotal(){
      return _processTotal;
   }

   //============================================================
   // <T>获得处理次数。</T>
   //============================================================
   public long processCount(){
      return _processCount;
   }

   //============================================================
   // <T>开始处理。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void processBegin(FLogicContext logicContext){
      _processCount = 0;
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void processOnce(){
      _processTotal++;
      _processCount++;
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void processLogic(FLogicContext logicContext){
   }

   //============================================================
   // <T>结束处理。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void processEnd(FLogicContext logicContext){
   }

   //============================================================
   // <T>逻辑处理。</T>
   //============================================================
   public boolean process(FLogicContext logicContext){
      // 处理逻辑
      processBegin(logicContext);
      processLogic(logicContext);
      processEnd(logicContext);
      // 返回结果
      return (_processCount > 0);
   }
}
