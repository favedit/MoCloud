package com.ahyc.eai.batch.common;

import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.type.TDateTime;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>统计计算器。</T>
//============================================================
public abstract class FStatisticsPeriodCalculater
      extends FStatisticsCalculater
{
   // 期间字段
   protected String _periodField;

   // 期间表
   protected String _periodTable;

   // 同步时间(1小时)
   protected long _intervalSpan = 1000 * 60 * 60 * 6;

   // 合计延迟(30秒)
   protected int _recordDelaySecond = -20;

   //============================================================
   // <T>阶段处理。</T>
   //============================================================
   public abstract void processPhase(FLogicContext logicContext,
                                     String beginDate,
                                     String endDate);

   //============================================================
   // <T>逻辑处理。</T>
   //============================================================
   @Override
   public void processLogic(FLogicContext logicContext){
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.STATISTICS);
      // 计算开始日期 
      TDateTime beginDate = _controllerUnit.linkDate();
      if(beginDate.isEmpty()){
         String dateSource = connection.executeScalar("SELECT DATE_FORMAT(MIN(" + _periodField + "),'%Y%m%d%H%i%s') AS ACTION_DATE FROM " + _periodTable);
         beginDate.parse(dateSource);
         beginDate.addSecond(_recordDelaySecond);
      }
      // 计算结束日期
      TDateTime endDate = beginDate.clone();
      endDate.add(_intervalSpan);
      String dateMaxSource = connection.executeScalar("SELECT DATE_FORMAT(MAX(" + _periodField + "),'%Y%m%d%H%i%s') AS `ACTION_DATE` FROM " + _periodTable);
      TDateTime endMaxDate = new TDateTime(dateMaxSource);
      if(endDate.get() > endMaxDate.get()){
         endDate.assign(endMaxDate);
         endDate.addSecond(_recordDelaySecond);
      }
      // 同步阶段内数据
      if(endDate.get() >= beginDate.get()){
         processPhase(logicContext, beginDate.format(), endDate.format());
         // 更新关联时间
         _controllerUnit.linkDate().assign(endDate);
      }
   }
}
