package com.ahyc.eai.batch.statistics.financial.marketer;

import com.ahyc.eai.batch.common.FStatisticsCalculater;
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
      extends FStatisticsCalculater
{
   // 同步总数
   protected long _intervalCount = 10000;

   // 理财师控制台接口
   protected IStatisticsMarketerConsole _marketerConsole;

   //============================================================
   // <T>构造金融用户同步器。</T>
   //============================================================
   public FStatisticsMarketerSynchronizer(){
      _marketerConsole = RAop.find(IStatisticsMarketerConsole.class);
   }

   //============================================================
   // <T>投资阶段处理。</T>
   //============================================================
   public void processPhase(FLogicContext logicContext,
                            long beginId,
                            long endId){
      ISqlConnection sourceConnection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      // 获得数据集合：编号/投资会员编号/投资金额/投资时间
      String selectSql = RString.format("SELECT uid FROM lzh_fmanager WHERE uid>{1} AND uid<={2}", beginId, endId);
      try(ISqlDatasetReader reader = sourceConnection.fetchReader(selectSql)){
         for(FRow row : reader){
            long uid = row.getLong("uid");
            _marketerConsole.syncByLinkId(logicContext, uid);
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
      ISqlConnection sourceConnection = logicContext.activeConnection("ezubao");
      ISqlConnection targetConnection = logicContext.activeConnection("statistics");
      // 获得最大编号
      long sourceMaxId = sourceConnection.executeLong("SELECT MAX(uid) FROM lzh_fmanager");
      long targetMaxId = targetConnection.executeLong("SELECT MAX(LINK_ID) FROM ST_FIN_MARKETER");
      if(targetMaxId == 0){
         targetMaxId = sourceConnection.executeLong("SELECT MIN(uid) FROM lzh_fmanager");
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
