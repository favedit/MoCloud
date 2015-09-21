package com.ahyc.eai.batch.data.financial.member;

import com.ahyc.eai.batch.common.FStatisticsIdCalculater;
import org.mo.com.data.FSqlProcedure;
import org.mo.com.data.ISqlConnection;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>用户同步器。</T>
//============================================================
public class FDataMemberSynchronizer
      extends FStatisticsIdCalculater
{
   //============================================================
   // <T>构造用户同步器。</T>
   //============================================================
   public FDataMemberSynchronizer(){
   }

   //============================================================
   // <T>同步处理。</T>
   //============================================================
   @Override
   public void processPhase(FLogicContext logicContext,
                            long beginId,
                            long endId){
      ISqlConnection sourceConnection = logicContext.activeConnection(EEaiDataConnection.DATA);
      FSqlProcedure procedure = new FSqlProcedure();
      procedure.setName("");
      sourceConnection.execute(procedure);

   }
}
