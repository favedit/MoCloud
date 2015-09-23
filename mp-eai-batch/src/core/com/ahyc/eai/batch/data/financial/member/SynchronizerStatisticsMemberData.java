package com.ahyc.eai.batch.data.financial.member;

import com.cyou.gccloud.data.data.FDataFinancialMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import java.util.Calendar;
import java.util.Iterator;
import org.mo.com.data.FSql;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.eng.data.IDatabaseConsole;

public class SynchronizerStatisticsMemberData
{
   public static void main(String[] args){
      FAttributes attributes = RAop.configConsole().defineCollection().attributes();
      attributes.set("application", "D:/Microbject/MoCloud/");
      RAop.initialize("D:/Microbject/MoCloud/mp-eai-batch/src/config/application-work.xml");
      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      FLogicContext logicContext = new FLogicContext(databaseConsole);
      //同步数据
      SynchronizerStatisticsMemberData.synchronizedMember(logicContext);
   }

   //同步ST_FIN_MEMBER表数据到DT_FIN_MEMBER表
   public static void synchronizedMember(FLogicContext logicContext){
      FStatisticsFinancialMemberLogic statisticsMemberLogic = logicContext.findLogic(FStatisticsFinancialMemberLogic.class);
      FDataFinancialMemberLogic dataMemberLogic = logicContext.findLogic(FDataFinancialMemberLogic.class);
      //获取最近一礼拜统计成员表的数据,将其同步到存储表,,score字段计算获得
      FLogicDataset<FStatisticsFinancialMemberUnit> statisticsMemberLatestWeek = getLatestWeek(statisticsMemberLogic);
      for(Iterator<FStatisticsFinancialMemberUnit> iterator = statisticsMemberLatestWeek.iterator(); iterator.hasNext();){
         FStatisticsFinancialMemberUnit statisticsMember = iterator.next();
         FSql whereSqlGuid = new FSql();
         whereSqlGuid.append(FDataFinancialMemberLogic.GUID);
         whereSqlGuid.append("=\"");
         whereSqlGuid.append(statisticsMember.guid() + "\"");
         FLogicDataset<FDataFinancialMemberUnit> dataMembers = dataMemberLogic.fetch(whereSqlGuid);

         //如果存在,则更新数据
         if(dataMembers != null && dataMembers.count() > 0){
            FDataFinancialMemberUnit dataMember = dataMembers.first();
            loadData(dataMember, statisticsMember);
            dataMemberLogic.doUpdate(dataMember);
         }else{

            //如果不存在,插入数据,同步数据的俩张表guid设置为一样
            FDataFinancialMemberUnit dataMember = new FDataFinancialMemberUnit();
            loadData(dataMember, statisticsMember);
            dataMemberLogic.doInsert(dataMember);
         }
         /*System.out.println("年龄:" + getAgeByCard(idCard) + "  收入:" + statisticsMember.incomeCode() + "  dataMemberpassport:" + dataMember.passport() + "  dataMemberlinkId:" + dataMember.linkId() + "  dataMemberrecommendScore:"
               + dataMember.recommendScore());*/

      }
   }

   //计算分数  通过年龄和收入去计算
   private static int getScore(int age,
                               String incomeCode){
      int ageScore = 0;
      int incomeScore = 0;
      if(age == -1 || age <= 20){
         ageScore = 50;
      }else if(age > 20 && age <= 30){
         ageScore = 60;
      }else if(age > 30 && age <= 40){
         ageScore = 70;
      }else if(age > 40 && age <= 50){
         ageScore = 80;
      }else if(age > 50 && age <= 60){
         ageScore = 90;
      }else{
         ageScore = 100;
      }
      if(incomeCode != null && (!"".equals(incomeCode))){
         if(incomeCode.equals("50000以上")){
            incomeScore = 100;
         }else if(incomeCode.equals("10000-50000")){
            incomeScore = 80;
         }else if(incomeCode.equals("5000-10000")){
            incomeScore = 60;
         }else{
            incomeScore = 40;
         }
      }else{
         return ageScore;
      }

      return (int)(ageScore * 0.5 + incomeScore * 0.5);
   }

   //根据身份证计算年龄
   public static int getAgeByCard(String idCard){
      if(idCard == null || "".equals(idCard)){
         return -1;
      }
      int iAge = -1;
      String year = idCard.substring(6, 10);
      Calendar cal = Calendar.getInstance();
      int iCurrYear = cal.get(Calendar.YEAR);
      iAge = iCurrYear - Integer.valueOf(year);
      return iAge;
   }

   //根据身份证获得生日字符串
   public static TDateTime getBirthdayByIdCard(String idCard){
      String birthdayString = "";
      TDateTime birthdayDateTime = null;
      if(idCard != null && idCard.length() > 0){
         birthdayString = idCard.substring(6, 14);//生日字符串19900326
         birthdayDateTime = new TDateTime(birthdayString);
      }

      return birthdayDateTime;
   }

   //装载数据
   public static void loadData(FDataFinancialMemberUnit dataMember,
                               FStatisticsFinancialMemberUnit statisticsMember){
      dataMember.setGuid(statisticsMember.guid());
      dataMember.setLinkId(statisticsMember.linkId());//******
      dataMember.setStatisticsId(statisticsMember.ouid());
      dataMember.setPassport(statisticsMember.passport());
      dataMember.setLabel(statisticsMember.label());
      dataMember.setCard(statisticsMember.card());
      dataMember.setPhone(statisticsMember.phone());
      dataMember.setEmail(statisticsMember.email());
      String idCard = statisticsMember.card();//身份证
      //         System.out.println("****************-------------->生日" + getBirthdayByIdCard(idCard));
      //         System.out.println("****************----年龄---------->" + getAgeByCard(idCard));
      //         System.out.println("****************-------------->" + birthdayStringDateTime);
      dataMember.setBirthday(getBirthdayByIdCard(idCard));//从身份证截取生日
      dataMember.setGenderCd(statisticsMember.genderCd());
      dataMember.setMarryCd(statisticsMember.marryCd());
      dataMember.setEducationCd(statisticsMember.educationCd());
      dataMember.setBusinessCd(statisticsMember.businessCd());
      dataMember.setIncomeCd(statisticsMember.incomeCd());
      dataMember.setRecommendScore(getScore(getAgeByCard(idCard), statisticsMember.incomeCode()));//------计算分数  通过年龄和收入去计算
      dataMember.setProvinceAreaId(statisticsMember.provinceAreaId());
      dataMember.setProvinceId(statisticsMember.provinceId());
      dataMember.setCityId(statisticsMember.cityId());
      dataMember.setAreaId(statisticsMember.areaId());
      dataMember.setAddress(statisticsMember.address());
      dataMember.setRegisterDate(statisticsMember.registerDate());
      dataMember.setLastLoginDate(statisticsMember.lastLoginDate());
      //         dataMember.setRecommendBeginDate(value);
      //         dataMember.setRecommendEndDate(value);
      //         dataMember.setRecommendMarketerId(value);
      //         dataMember.setRecommendMarketerUserId(value);
      dataMember.setNote(statisticsMember.info());
   }

   //获取统计member表最近一个礼拜登录的数据
   public static FLogicDataset<FStatisticsFinancialMemberUnit> getLatestWeek(FStatisticsFinancialMemberLogic statisticsMemberLogic){
      FSql whereSqlLatestWeek = new FSql();
      whereSqlLatestWeek.append(FStatisticsFinancialMemberLogic.LAST_LOGIN_DATE);
      whereSqlLatestWeek.append(" BETWEEN DATE_SUB(NOW(),INTERVAL 1 WEEK)  AND NOW()");
      return statisticsMemberLogic.fetch(whereSqlLatestWeek);
   }
}
