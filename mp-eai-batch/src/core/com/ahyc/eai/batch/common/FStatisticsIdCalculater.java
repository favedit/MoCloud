package com.ahyc.eai.batch.common;

import org.mo.com.data.ISqlConnection;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>统计计算器。</T>
//============================================================
public abstract class FStatisticsIdCalculater
      extends FStatisticsCalculater
{
   // 期间链接
   protected String _periodConnection;

   // 期间表
   protected String _periodTable;

   // 期间字段
   protected String _periodField;

   // 同步数量
   protected long _intervalId = 10000;

   //============================================================
   // <T>阶段处理。</T>
   //============================================================
   public abstract void processPhase(FLogicContext logicContext,
                                     long beginId,
                                     long endId);

   //============================================================
   // <T>逻辑处理。</T>
   //============================================================
   @Override
   public void processLogic(FLogicContext logicContext){
      ISqlConnection connection = logicContext.activeConnection(_periodConnection);
      // 计算开始编号 
      long beginId = _controllerUnit.linkId();
      if(beginId == 0){
         beginId = connection.executeLong("SELECT MIN(" + _periodField + ") FROM " + _periodTable);
         beginId--;
      }
      // 计算结束编号
      long endId = beginId + _intervalId;
      long maxId = connection.executeLong("SELECT MAX(" + _periodField + ") FROM " + _periodTable);
      if(endId > maxId){
         endId = maxId;
      }
      // 同步阶段内数据
      if(endId > beginId){
         processPhase(logicContext, beginId, endId);
         // 更新关联时间
         _controllerUnit.setLinkId(endId);
      }
   }
}
