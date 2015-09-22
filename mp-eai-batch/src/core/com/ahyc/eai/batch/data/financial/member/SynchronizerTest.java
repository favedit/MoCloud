package com.ahyc.eai.batch.data.financial.member;

import com.cyou.gccloud.data.data.FDataFinancialMemberLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import org.mo.com.data.FSql;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.eng.data.IDatabaseConsole;

public class SynchronizerTest
{
   public static void main(String[] args){
      FAttributes attributes = RAop.configConsole().defineCollection().attributes();
      attributes.set("application", "D:/Microbject/MoCloud/");
      RAop.initialize("D:/Microbject/MoCloud/mp-eai-batch/src/config/application-work.xml");
      int score = 0;

      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      FLogicContext logicContext = new FLogicContext(databaseConsole);

      FStatisticsFinancialMemberLogic memberLogic = logicContext.findLogic(FStatisticsFinancialMemberLogic.class);
      FDataFinancialMemberLogic dataMemberLogic = logicContext.findLogic(FDataFinancialMemberLogic.class);

      TDateTime nowTime = new TDateTime(RDateTime.currentDateTime());
      //一天前的日期
      TDateTime beforeOneDay = nowTime;
      beforeOneDay.addDay(-1);
      String date = beforeOneDay.format("YYYYMMDD");
      FSql whereSql = new FSql();
      whereSql.append(FStatisticsFinancialMemberLogic.LAST_LOGIN_DATE + " = STR_TO_DATE('{lastLoginDate}','%Y%m%d')");
      whereSql.bind("lastLoginDate", date);
      //获取最新数据
      FDictionary<FStatisticsFinancialMemberUnit> members = new FDictionary<FStatisticsFinancialMemberUnit>(FStatisticsFinancialMemberUnit.class);
      FLogicDataset<FStatisticsFinancialMemberUnit> memberList = memberLogic.fetch(whereSql);
      for(FStatisticsFinancialMemberUnit unit : memberList){
         members.set(RString.parse(unit.linkId()), unit);
      }

      //二天前
      TDateTime beforeTwoDay = nowTime;
      beforeTwoDay.addDay(-2);
      date = beforeTwoDay.format("YYYYMMDD");
      whereSql.append(FStatisticsFinancialMemberLogic.LAST_LOGIN_DATE + " = STR_TO_DATE('{lastLoginDate}','%Y%m%d')");
      whereSql.bind("lastLoginDate", date);
      //      FDictionary<FStatisticsFinancialMemberUnit> membersTow = new FDictionary<FStatisticsFinancialMemberUnit>(FStatisticsFinancialMemberUnit.class);
      FLogicDataset<FStatisticsFinancialMemberUnit> memberTowList = memberLogic.fetch(whereSql);
      for(FStatisticsFinancialMemberUnit unit : memberTowList){
         String linkId = RString.parse(unit.linkId());
         FStatisticsFinancialMemberUnit member = members.find(linkId);
         if(member != null){
            score = 98;
            //            FDataFinancialMemberUnit memberUnit = dataMemberLogic
            //            memberUnit.setLinkId(unit.linkId());
            //            memberUnit.setStatisticsId(unit.ouid());
            //            memberUnit.setPassport(unit.passport());
            //            memberUnit.setLabel(unit.label());
            //            dataMemberLogic.doInsert(memberUnit);
         }
         //         members.set(RString.parse(unit.linkId()), unit);
      }

   }
}
