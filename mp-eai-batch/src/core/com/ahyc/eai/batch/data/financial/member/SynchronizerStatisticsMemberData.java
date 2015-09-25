package com.ahyc.eai.batch.data.financial.member;

import com.cyou.gccloud.data.data.FDataFinancialCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import com.cyou.gccloud.data.data.FDataFinancialMarketerLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import org.mo.com.data.FSql;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
//============================================================
//<P>同步分析ST库表里面的数据到DT库下对应的表里面</P>
//@class SynchronizerStatisticsMemberData
//@author AnjoyTian
//@Date 2015.09.24  
//@version 1.0.0
//============================================================
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
      FStatisticsFinancialMarketerLogic statisticsMarketerLogic = logicContext.findLogic(FStatisticsFinancialMarketerLogic.class);
      FStatisticsFinancialCustomerLogic statisticsCustomerLogic = logicContext.findLogic(FStatisticsFinancialCustomerLogic.class);
      FStatisticsFinancialMemberLogic statisticsMemberLogic = logicContext.findLogic(FStatisticsFinancialMemberLogic.class);
      FDataFinancialMemberLogic dataMemberLogic = logicContext.findLogic(FDataFinancialMemberLogic.class);
      FDataFinancialCustomerLogic dataCustomerLogic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FDataFinancialMarketerLogic dataMarketerLogic = logicContext.findLogic(FDataFinancialMarketerLogic.class);
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
            loadDTMemberData(dataMember, statisticsMember);
            dataMemberLogic.doUpdate(dataMember);
            //同步更新与之关联的customer和marketer
            long linkId = dataMember.linkId();
            FSql wheresqlCustomer = new FSql();
            wheresqlCustomer.append(FDataFinancialCustomerLogic.LINK_ID);
            wheresqlCustomer.append(" = ");
            wheresqlCustomer.append(linkId);
            FLogicDataset<FDataFinancialCustomerUnit> FDataFinancialCustomerUnits = dataCustomerLogic.fetch(wheresqlCustomer);
            if(FDataFinancialCustomerUnits != null && FDataFinancialCustomerUnits.count() > 0){
               FDataFinancialCustomerUnit dataCustomerUnit = FDataFinancialCustomerUnits.first();
               FSql wheresql = new FSql();
               wheresql.append(FStatisticsFinancialCustomerLogic.LINK_ID);
               wheresql.append(" = ");
               wheresql.append(linkId);
               FLogicDataset<FStatisticsFinancialCustomerUnit> fetchByLink_ID = statisticsCustomerLogic.fetch(wheresql);
               loadDTCustomerData(linkId, dataMember.ouid(), statisticsCustomerLogic, dataCustomerLogic, dataCustomerUnit, fetchByLink_ID.first());
               dataCustomerLogic.doUpdate(dataCustomerUnit);
            }

            FSql wheresqlMarketer = new FSql();
            wheresqlMarketer.append(FDataFinancialMarketerLogic.LINK_ID);
            wheresqlMarketer.append(" = ");
            wheresqlMarketer.append(linkId);
            FLogicDataset<FDataFinancialMarketerUnit> FDataFinancialMarketerUnits = dataMarketerLogic.fetch(wheresqlMarketer);
            if(FDataFinancialMarketerUnits != null && FDataFinancialMarketerUnits.count() > 0){
               FDataFinancialMarketerUnit dataMarketerUnit = FDataFinancialMarketerUnits.first();
               FSql wheresql2 = new FSql();
               wheresql2.append(FStatisticsFinancialMarketerLogic.LINK_ID);
               wheresql2.append(" = ");
               wheresql2.append(linkId);
               FLogicDataset<FStatisticsFinancialMarketerUnit> fetchByLink_ID2 = statisticsMarketerLogic.fetch(wheresql2);
               loadDTMarketerData(linkId, dataMember.ouid(), statisticsMarketerLogic, dataMarketerLogic, dataMarketerUnit, fetchByLink_ID2.first());
               dataMarketerLogic.doUpdate(dataMarketerUnit);
            }
            //更新完毕member
         }else{

            //如果member不存在,插入数据,同步数据的俩张表guid设置为一样,ouid也设置一样  (如果member不存在,意味着与之关联的customer和marketer也要新添加
            FDataFinancialMemberUnit dataMember = new FDataFinancialMemberUnit();
            FDataFinancialCustomerUnit dataCustomerUnit = new FDataFinancialCustomerUnit();
            FDataFinancialMarketerUnit dataMarketerUnit = new FDataFinancialMarketerUnit();
            loadDTMemberData(dataMember, statisticsMember);
            dataMemberLogic.doInsert(dataMember);
            //当同步添加了一个member后,要保证与member关联的customer和marketer的ouid要一致.拿member的link_id去ST关联customer和marketer的LINK_ID
            long linkId = dataMember.linkId();
            long ouid = dataMember.ouid();
            //首先去ST库下找有没有相应link_id的customer
            FSql wheresql = new FSql();
            wheresql.append(FStatisticsFinancialCustomerLogic.LINK_ID);
            wheresql.append(" = ");
            wheresql.append(linkId);
            FLogicDataset<FStatisticsFinancialCustomerUnit> fetchByLink_ID = statisticsCustomerLogic.fetch(wheresql);
            if(fetchByLink_ID != null && fetchByLink_ID.count() > 0){
               FStatisticsFinancialCustomerUnit firstStatisticsFinancialCustomerUnit = fetchByLink_ID.first();
               loadDTCustomerData(linkId, ouid, statisticsCustomerLogic, dataCustomerLogic, dataCustomerUnit, firstStatisticsFinancialCustomerUnit);
               dataCustomerLogic.doInsert(dataCustomerUnit);
            }

            //首先去ST库下找有没有相应link_id的marketer
            FSql wheresql2 = new FSql();
            wheresql2.append(FStatisticsFinancialMarketerLogic.LINK_ID);
            wheresql2.append(" = ");
            wheresql2.append(linkId);
            FLogicDataset<FStatisticsFinancialMarketerUnit> fetchByLink_ID2 = statisticsMarketerLogic.fetch(wheresql2);
            if(fetchByLink_ID2 != null && fetchByLink_ID2.count() > 0){
               FStatisticsFinancialMarketerUnit firstStatisticsFinancialMarketerUnit = fetchByLink_ID2.first();
               loadDTMarketerData(linkId, ouid, statisticsMarketerLogic, dataMarketerLogic, dataMarketerUnit, firstStatisticsFinancialMarketerUnit);
               dataMarketerLogic.doInsert(dataMarketerUnit);
            }
         }
         /*System.out.println("年龄:" + getAgeByCard(idCard) + "  收入:" + statisticsMember.incomeCode() + "  dataMemberpassport:" + dataMember.passport() + "  dataMemberlinkId:" + dataMember.linkId() + "  dataMemberrecommendScore:"
               + dataMember.recommendScore());*/

      }
   }

   //同步删除数据
   public static void synchronizedDeleteMember(FLogicContext logicContext){
      FStatisticsFinancialMarketerLogic statisticsMarketerLogic = logicContext.findLogic(FStatisticsFinancialMarketerLogic.class);
   }

   //把ST的marketer同步到DT的marketer
   public static void loadDTMarketerData(long linkId,
                                         long ouid,
                                         FStatisticsFinancialMarketerLogic statisticsMarketerLogic,
                                         FDataFinancialMarketerLogic dataMarketerLogic,
                                         FDataFinancialMarketerUnit dataMarketerUnit,
                                         FStatisticsFinancialMarketerUnit firstStatisticsFinancialMarketerUnit){
      dataMarketerUnit.setOuid(ouid);
      dataMarketerUnit.setGuid(firstStatisticsFinancialMarketerUnit.guid());
      dataMarketerUnit.setLinkId(linkId);
      dataMarketerUnit.setStatisticsId(firstStatisticsFinancialMarketerUnit.ouid());
      dataMarketerUnit.setLabel(firstStatisticsFinancialMarketerUnit.label());
      dataMarketerUnit.setStatusCd(firstStatisticsFinancialMarketerUnit.statusCd());
      dataMarketerUnit.setPhone(firstStatisticsFinancialMarketerUnit.phone());
      dataMarketerUnit.setCard(firstStatisticsFinancialMarketerUnit.card());
      dataMarketerUnit.setRankLabel(firstStatisticsFinancialMarketerUnit.rankLabel());
      dataMarketerUnit.setDepartmentId(firstStatisticsFinancialMarketerUnit.departmentLinkId());
      dataMarketerUnit.setDepartmentLabel(firstStatisticsFinancialMarketerUnit.departmentLabel());
      dataMarketerUnit.setCustomerInvestmentTotal(firstStatisticsFinancialMarketerUnit.investmentTotal());
      dataMarketerUnit.setCustomerRedemptionTotal(firstStatisticsFinancialMarketerUnit.redemptionTotal());
      dataMarketerUnit.setCustomerNetinvestmentTotal(firstStatisticsFinancialMarketerUnit.netinvestmentTotal());
      dataMarketerUnit.setCustomerInterestTotal(firstStatisticsFinancialMarketerUnit.interestTotal());
      dataMarketerUnit.setCustomerPerformanceTotal(firstStatisticsFinancialMarketerUnit.performanceTotal());

   }

   //把ST的customer同步到DT的customer
   public static void loadDTCustomerData(long linkId,
                                         long ouid,
                                         FStatisticsFinancialCustomerLogic statisticsCustomerLogic,
                                         FDataFinancialCustomerLogic dataCustomerLogic,
                                         FDataFinancialCustomerUnit dataCustomerUnit,
                                         FStatisticsFinancialCustomerUnit firstStatisticsFinancialCustomerUnit){

      dataCustomerUnit.setOuid(ouid);
      dataCustomerUnit.setGuid(firstStatisticsFinancialCustomerUnit.guid());
      //      System.out.println("firstStatisticsFinancialCustomerUnit.guid()-->" + firstStatisticsFinancialCustomerUnit.guid());
      dataCustomerUnit.setLinkId(linkId);
      dataCustomerUnit.setStatisticsId((int)firstStatisticsFinancialCustomerUnit.ouid());
      dataCustomerUnit.setInvestmentTotal(firstStatisticsFinancialCustomerUnit.investmentTotal());
      dataCustomerUnit.setRedemptionTotal((float)firstStatisticsFinancialCustomerUnit.redemptionTotal());
      dataCustomerUnit.setNetinvestment((float)firstStatisticsFinancialCustomerUnit.netinvestmentTotal());
      dataCustomerUnit.setInterestTotal((float)firstStatisticsFinancialCustomerUnit.interestTotal());

   }

   //计算分数  通过年龄和收入去计算
   public static int getScore(int age,
                              String incomeCode){
      double w = 0.0;//权重 总分数=ageScore*w+incomeScore*w
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

   //按最近登录时间计算分数
   public static int getScoreByLastLoginDate(TDateTime lastLoginDate){
      int lastLoginDateLastLoginDateScore = -1;
      //距今天0天 2015 09 25 00:00:00--2015 09 25 10:02:18 代码编辑于2015 09 25 10:02:18
      if(lastLoginDate.isBetween(getNDayAgo(0), new TDateTime(new Date()))){
         lastLoginDateLastLoginDateScore = 100;
      }else if(lastLoginDate.isBetween(getNDayAgo(-1), getNDayAgo(0))){
         //距今天1天 (2015 09 24 00:00:00---2015 09 25 00:00:00   代码编辑于2015 09 25 10:02:18
         lastLoginDateLastLoginDateScore = 90;
      }else if(lastLoginDate.isBetween(getNDayAgo(-2), getNDayAgo(-1))){
         //距今天2天
         lastLoginDateLastLoginDateScore = 80;

      }else if(lastLoginDate.isBetween(getNDayAgo(-3), getNDayAgo(-2))){
         //距今天3天
         lastLoginDateLastLoginDateScore = 70;
      }else if(lastLoginDate.isBetween(getNDayAgo(-4), getNDayAgo(-3))){
         //距今天4天
         lastLoginDateLastLoginDateScore = 60;
      }else if(lastLoginDate.isBetween(getNDayAgo(-5), getNDayAgo(-4))){
         //距今天5天
         lastLoginDateLastLoginDateScore = 50;
      }else if(lastLoginDate.isBefore(getNDayAgo(-5))){
         //距今天>=6天
         lastLoginDateLastLoginDateScore = 40;
      }
      return lastLoginDateLastLoginDateScore;
   }

   //返回距今几天的方法,以00:00:00为判断点
   public static TDateTime getNDayAgo(int dayNumber){
      Date date = new Date();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      calendar.add(Calendar.DAY_OF_MONTH, dayNumber);//当前日期+dayNumber
      calendar.set(Calendar.HOUR, 0);
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      date = calendar.getTime();
      TDateTime DateTime = new TDateTime(date);
      return DateTime;
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
   public static void loadDTMemberData(FDataFinancialMemberUnit dataMember,
                                       FStatisticsFinancialMemberUnit statisticsMember){
      dataMember.setOuid(statisticsMember.ouid());
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
