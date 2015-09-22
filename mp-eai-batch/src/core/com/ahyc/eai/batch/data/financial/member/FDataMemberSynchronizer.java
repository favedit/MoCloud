package com.ahyc.eai.batch.data.financial.member;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import org.mo.com.data.FSql;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>用户同步器。</T>
//============================================================
public class FDataMemberSynchronizer
{
   //============================================================
   // <T>构造用户同步器。</T>
   //============================================================
   public FDataMemberSynchronizer(){
   }

   //============================================================
   // <T>同步处理。</T>
   //============================================================
   public void processPhase(){
      FAttributes attributes = RAop.configConsole().defineCollection().attributes();
      attributes.set("application", "D:/Microbject/MoCloud/");
      RAop.initialize("D:/Microbject/MoCloud/mp-eai-manage/src/config/application-work.xml");

      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      FLogicContext logicContext = new FLogicContext(databaseConsole);

      FStatisticsFinancialMemberLogic memberLogic = logicContext.findLogic(FStatisticsFinancialMemberLogic.class);
      TDateTime nowTime = new TDateTime(RDateTime.currentDateTime());
      TDateTime beforeOneDay = nowTime;
      beforeOneDay.addDay(-1);
      beforeOneDay.format("YYYYMMDDHH240000");

      FSql whereSql = new FSql();
      whereSql.append("");
      FLogicDataset<FStatisticsFinancialMemberUnit> memberList = memberLogic.fetch(whereSql);
      for(FStatisticsFinancialMemberUnit member : memberList){

      }
   }
}
