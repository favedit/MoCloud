package com.ahyc.eai.batch.statistics.financial.member;

import com.ahyc.eai.batch.common.FStatisticsIdCalculater;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.data.ISqlDatasetReader;
import org.mo.com.lang.RString;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>金融用户同步器。</T>
//============================================================
public class FStatisticsMemberSynchronizer
      extends FStatisticsIdCalculater
{
   // 用户控制台接口
   protected IStatisticsMemberConsole _memberConsole;

   //============================================================
   // <T>构造金融用户同步器。</T>
   //============================================================
   public FStatisticsMemberSynchronizer(){
      _processCode = "financial.member.synchronizer";
      _periodConnection = EEaiDataConnection.EZUBAO;
      _periodTable = "lzh_members";
      _periodField = "id";
      _memberConsole = RAop.find(IStatisticsMemberConsole.class);
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
      String selectSql = RString.format("SELECT id FROM lzh_members WHERE id>{1} AND id<={2}", beginId, endId);
      try(ISqlDatasetReader reader = sourceConnection.fetchReader(selectSql)){
         for(FRow row : reader){
            long id = row.getLong("id");
            _memberConsole.syncByLinkId(logicContext, id);
            // 统计处理
            processOnce();
         }
      }
   }
}
