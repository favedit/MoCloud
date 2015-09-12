package com.ahyc.eai.batch.statistics.financial.marketer;

import com.ahyc.eai.batch.common.FStatisticsIdCalculater;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.data.ISqlDatasetReader;
import org.mo.com.lang.RString;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>金融理财师同步器。</T>
//============================================================
public class FStatisticsMarketerSynchronizer
      extends FStatisticsIdCalculater
{
   // 理财师控制台接口
   protected IStatisticsMarketerConsole _marketerConsole;

   //============================================================
   // <T>构造金融用户同步器。</T>
   //============================================================
   public FStatisticsMarketerSynchronizer(){
      _processCode = "financial.marketer.synchronizer";
      _periodConnection = EEaiDataConnection.EZUBAO;
      _periodTable = "lzh_fmanager";
      _periodField = "uid";
      _marketerConsole = RAop.find(IStatisticsMarketerConsole.class);
   }

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   @Override
   public void processPhase(FLogicContext logicContext,
                            long beginId,
                            long endId){
      ISqlConnection sourceConnection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      // 获得编号集合
      String selectSql = RString.format("SELECT uid FROM lzh_fmanager WHERE uid>{1} AND uid<={2}", beginId, endId);
      try(ISqlDatasetReader reader = sourceConnection.fetchReader(selectSql)){
         for(FRow row : reader){
            // 代码修正
            long uid = row.getLong("uid");
            _marketerConsole.syncByLinkId(logicContext, uid);
            // 统计处理
            processOnce();
         }
      }
   }
}
