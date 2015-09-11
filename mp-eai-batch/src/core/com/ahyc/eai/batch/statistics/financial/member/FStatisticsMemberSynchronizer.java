package com.ahyc.eai.batch.statistics.financial.member;

import com.ahyc.eai.batch.common.FStatisticsCalculater;
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
      extends FStatisticsCalculater
{
   // 同步总数
   protected long _intervalCount = 10000;

   // 用户控制台接口
   protected IStatisticsMemberConsole _memberConsole;

   //============================================================
   // <T>构造金融用户同步器。</T>
   //============================================================
   public FStatisticsMemberSynchronizer(){
      _memberConsole = RAop.find(IStatisticsMemberConsole.class);
   }

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
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

   //============================================================
   // <T>逻辑处理。</T>
   //============================================================
   @Override
   public void processLogic(FLogicContext logicContext){
      _memberConsole.clear();
      ISqlConnection sourceConnection = logicContext.activeConnection("ezubao");
      ISqlConnection targetConnection = logicContext.activeConnection("statistics");
      // 获得最大编号
      long sourceMaxId = sourceConnection.executeLong("SELECT MAX(id) FROM lzh_members");
      long targetMaxId = targetConnection.executeLong("SELECT MAX(LINK_ID) FROM ST_FIN_MEMBER");
      if(targetMaxId == 0){
         targetMaxId = sourceConnection.executeLong("SELECT MIN(id) FROM lzh_members");
         if(targetMaxId > 0){
            targetMaxId--;
         }
      }
      // 每次同步数量
      long beginId = targetMaxId;
      long endId = targetMaxId + _intervalCount;
      if(endId > sourceMaxId){
         endId = sourceMaxId;
      }
      // 同步阶段内数据
      if(endId > beginId){
         processPhase(logicContext, beginId, endId);
      }
   }
}
