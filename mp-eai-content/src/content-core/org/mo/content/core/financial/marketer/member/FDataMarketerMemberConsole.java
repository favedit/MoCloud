package org.mo.content.core.financial.marketer.member;

import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialMemberFeedback;
import com.cyou.gccloud.define.enums.financial.EGcFinancialMemberRelation;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融理财师成员控制台。</T>
//============================================================
public class FDataMarketerMemberConsole
      extends FAbstractLogicUnitConsole<FDataFinancialMarketerMemberLogic, FDataFinancialMarketerMemberUnit>
      implements
         IDataMarketerMemberConsole
{
   // 每页条数
   static final int _pageSize = 12;

   //成员信息控制器
   //   @ALink
   //   protected IDataMemberConsole _memberConsole;

   //============================================================
   // <T>构造控制台。</T>
   //============================================================
   public FDataMarketerMemberConsole(){
      super(FDataFinancialMarketerMemberLogic.class, FDataFinancialMarketerMemberUnit.class);
   }

   // ============================================================
   // <T>获取对象</T>
   //
   // @param logicContext 链接对象
   // @param  memberId 成员编号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialMarketerMemberUnit findByMemberId(ILogicContext logicContext,
                                                          long memberId){
      if(memberId == 0){
         throw new FFatalError("findByMemberId memberId is null");
      }
      FDataFinancialMarketerMemberLogic logic = logicContext.findLogic(FDataFinancialMarketerMemberLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialMarketerMemberLogic.MEMBER_ID + " = {member_id}");
      whereSql.bind("member_id", RString.parse(memberId));
      FLogicDataset<FDataFinancialMarketerMemberUnit> list = logic.fetch(whereSql);
      if(list == null){
         return null;
      }
      return list.first();
   }

   // ============================================================
   // <T>获取理财师已关注的客户</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialMarketerMemberInfo> selectFollowedByMarketerId(ILogicContext logicContext,
                                                                                     long marketerId,
                                                                                     int pageNum){
      if(marketerId == 0){
         throw new FFatalError("findByMarketerId marketerId is null");
      }
      if(0 > pageNum){
         pageNum = 0;
      }
      FDataFinancialMarketerMemberLogic logic = logicContext.findLogic(FDataFinancialMarketerMemberLogic.class);
      FDataFinancialMemberLogic memberLogic = logicContext.findLogic(FDataFinancialMemberLogic.class);
      FSql whereSql = new FSql();
      TDateTime nowDate = new TDateTime(RDateTime.currentDateTime());
      whereSql.append(FDataFinancialMarketerMemberLogic.MARKETER_ID + " = {marketer_id}");
      whereSql.bind("marketer_id", RString.parse(marketerId));
      whereSql.append(" AND " + FDataFinancialMarketerMemberLogic.RELATION_CD + " <> {relation_cd}");
      whereSql.bind("relation_cd", RString.parse(EGcFinancialMemberRelation.Unknown));
      FLogicDataset<FDataFinancialMarketerMemberInfo> list = logic.fetchClass(FDataFinancialMarketerMemberInfo.class, whereSql, _pageSize, pageNum);
      FLogicDataset<FDataFinancialMarketerMemberInfo> resultList = new FLogicDataset<>(FDataFinancialMarketerMemberInfo.class);
      for(FDataFinancialMarketerMemberInfo info : list){
         FDataFinancialMemberUnit member = memberLogic.find(info.memberId());
         if(member != null){
            info.setMemberLabel(member.label());
            info.setMemberPhone(member.phone());
            info.setMemberLastLoginDate(member.lastLoginDate());
            info.setMemberRecommendScore(member.recommendScore());
            info.setMemberGuid(member.guid());
         }
         int days = 0;
         if(!info.recommendEndDate().isEmpty()){
            days = info.recommendEndDate().sub(nowDate).days();
            info.setRemainingDays((days <= 0) ? 0 : days);
         }
         if(days > 0){
            resultList.push(info);
         }else{
            // 如果周期结束，以后将不在给此理财师推荐此成员
            if(info.feedbackCd() != EGcFinancialMemberFeedback.EndOfCycle){
               info.setRelationCd(EGcFinancialMemberRelation.Unknown);
               info.setFeedbackCd(EGcFinancialMemberFeedback.EndOfCycle);
               info.setFeedbackNote("the time is finish!");
               logic.doUpdate(info);
            }
         }
      }

      //      FSql where = null;
      //      if(list.count() > 0){
      //         long[] longArr = new long[list.count()];
      //         for(int i = 0; i < list.count(); i++){
      //            FDataFinancialMarketerMemberInfo unit = list.get(i);
      //            longArr[i] = unit.memberId();
      //         }
      //         String strArr = Arrays.toString(longArr).replace("[", "(").replace("]", ")");
      //         where = new FSql();
      //         where.append(FDataFinancialMemberLogic.OUID);
      //         where.append(" in ");
      //         where.append(strArr);
      //      }
      //      StringBuffer order = new StringBuffer();
      //      order.append(FDataFinancialMemberLogic.RECOMMEND_SCORE + " DESC,");
      //      order.append(FDataFinancialMemberLogic.LAST_LOGIN_DATE + " DESC");
      //      FDataFinancialMemberLogic memberLogic = logicContext.findLogic(FDataFinancialMemberLogic.class);
      //      FLogicDataset<FDataFinancialMemberUnit> dataMembers = memberLogic.fetch(where, order);
      //      FLogicDataset<FDataFinancialMarketerMemberInfo> dataMemberInfos = new FLogicDataset<FDataFinancialMarketerMemberInfo>(FDataFinancialMarketerMemberInfo.class);
      //      for(Iterator<FDataFinancialMemberUnit> iterator = dataMembers.iterator(); iterator.hasNext();){
      //         FDataFinancialMemberUnit dataMember = iterator.next();
      //         for(Iterator<FDataFinancialMarketerMemberInfo> iterator2 = list.iterator(); iterator2.hasNext();){
      //            FDataFinancialMarketerMemberInfo dataMemberInfo = iterator2.next();
      //            if(dataMember.ouid() == dataMemberInfo.memberId()){
      //               dataMemberInfo.setMemberLabel(dataMember.label());
      //               dataMemberInfo.setMemberPhone(dataMember.phone());
      //               dataMemberInfo.setMemberLastLoginDate(dataMember.lastLoginDate());
      //               dataMemberInfo.setMemberRecommendScore(dataMember.recommendScore());
      //               dataMemberInfo.setMemberGuid(dataMember.guid());
      //               int days = 0;
      //               if(!dataMemberInfo.recommendEndDate().isEmpty()){
      //                  int nowDay = nowDate.day();
      //                  dataMemberInfo.recommendEndDate().addDay(-nowDay);
      //                  days = dataMemberInfo.recommendEndDate().day();
      //                  //                  days = dataMemberInfo.recommendEndDate().day() - nowDate.day();
      //                  dataMemberInfo.setRemainingDays((days <= 0) ? 0 : days);
      //               }
      //
      //               if(days > 0){
      //                  dataMemberInfos.push(dataMemberInfo);
      //               }else{
      //                  // 如果周期结束，以后将不在给此理财师推荐此成员
      //                  if(dataMemberInfo.feedbackCd() != EGcFinancialMemberFeedback.EndOfCycle){
      //                     dataMemberInfo.setRelationCd(EGcFinancialMemberRelation.Unknown);
      //                     dataMemberInfo.setFeedbackCd(EGcFinancialMemberFeedback.EndOfCycle);
      //                     dataMemberInfo.setFeedbackNote("the time is finish!");
      //                     logic.doUpdate(dataMemberInfo);
      //                  }
      //               }
      //
      //            }
      //         }
      //      }
      return resultList;

   }

   // ============================================================
   // <T>获取总页数</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 理财师编号
   // @return 总页数
   // ============================================================
   @Override
   public int getPageCount(ILogicContext logicContext,
                           long marketerId){
      FDataFinancialMarketerMemberLogic logic = logicContext.findLogic(FDataFinancialMarketerMemberLogic.class);
      FSql sql = new FSql();
      sql.append("SELECT COUNT(ouid) FROM DT_FIN_MARKETER_MEMBER WHERE ");
      sql.append(FDataFinancialMarketerMemberLogic.MARKETER_ID + " = {marketer_id}");
      sql.bind("marketer_id", RString.parse(marketerId));
      sql.append(" AND " + FDataFinancialMarketerMemberLogic.RELATION_CD + " = {relation_cd}");
      sql.bind("relation_cd", RString.parse(EGcFinancialMemberRelation.Follow));
      ISqlConnection conn = logic.connection();
      int count = conn.executeInteger(sql);
      int pageTotal = count / _pageSize;
      if(count % _pageSize != 0){
         pageTotal += 1;
      }
      return pageTotal;
   }

   // ============================================================
   // <T>获取已关注的</T>
   //
   // @param logicContext 链接对象
   // @param  memberId 成员编号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialMarketerMemberUnit findFollowed(ILogicContext logicContext,
                                                        long memberId){
      if(memberId == 0){
         throw new FFatalError("findByMemberId memberId is null");
      }
      FDataFinancialMarketerMemberLogic logic = logicContext.findLogic(FDataFinancialMarketerMemberLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialMarketerMemberLogic.MEMBER_ID + " = {member_id}");
      whereSql.bind("member_id", RString.parse(memberId));
      whereSql.append(" AND " + FDataFinancialMarketerMemberLogic.RELATION_CD + " <> {relation_cd}");
      whereSql.bind("relation_cd", RString.parse(EGcFinancialMemberRelation.Follow));
      FLogicDataset<FDataFinancialMarketerMemberUnit> list = logic.fetch(whereSql);
      if(list == null){
         return null;
      }
      return list.first();
   }

   // ============================================================
   // <T>获取当前理财师是否关注过此成员</T>
   //
   // @param logicContext 链接对象
   // @return 总页数
   // ============================================================
   @Override
   public FDataFinancialMarketerMemberUnit findByMarketerAndMember(ILogicContext logicContext,
                                                                   long marketerId,
                                                                   long memberId){

      if(marketerId == 0 || memberId == 0){
         throw new FFatalError("FindByMarketerAndMember marketerId or memberId is null");
      }
      FDataFinancialMarketerMemberLogic logic = logicContext.findLogic(FDataFinancialMarketerMemberLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialMarketerMemberLogic.MARKETER_ID + " = {marketer_id}");
      whereSql.bind("marketer_id", RString.parse(marketerId));
      whereSql.append(" AND " + FDataFinancialMarketerMemberLogic.MEMBER_ID + " = {member_id}");
      whereSql.bind("member_id", RString.parse(memberId));
      FLogicDataset<FDataFinancialMarketerMemberUnit> list = logic.fetch(whereSql);
      if(list == null){
         return null;
      }
      return list.first();
   }

   // ============================================================
   // <T>获取当前理财师是否关注此成员</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @param  memberId   成员编号
   // @return 对象信息
   // ============================================================
   @Override
   public FDataFinancialMarketerMemberInfo findFollowedByMarketerAndMember(ILogicContext logicContext,
                                                                           long marketerId,
                                                                           long memberId){
      FDataFinancialMarketerMemberLogic logic = logicContext.findLogic(FDataFinancialMarketerMemberLogic.class);
      //      FDataFinancialMemberLogic memberLogic = logicContext.findLogic(FDataFinancialMemberLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialMarketerMemberLogic.MARKETER_ID + " = {marketer_id}");
      whereSql.bind("marketer_id", RString.parse(marketerId));
      whereSql.append(" AND " + FDataFinancialMarketerMemberLogic.MEMBER_ID + " = {member_id}");
      whereSql.bind("member_id", RString.parse(memberId));
      whereSql.append(" AND " + FDataFinancialMarketerMemberLogic.RELATION_CD + " = {relation_cd}");
      whereSql.bind("relation_cd", RString.parse(EGcFinancialMemberRelation.Follow));
      FLogicDataset<FDataFinancialMarketerMemberInfo> infoList = logic.fetchClass(FDataFinancialMarketerMemberInfo.class, whereSql, 0, 0);
      if(infoList.count() > 0){
         //         FDataFinancialMarketerMemberInfo info = infoList.first();
         //         //         FDataFinancialMemberUnit member = memberLogic.find(info.memberId());
         //         //         if(member != null){
         //         //            info.setMemberLabel(member.label());
         //         //            info.setMemberPhone(member.phone());
         //         //            info.setMemberLastLoginDate(member.lastLoginDate());
         //         //            info.setMemberRecommendScore(member.recommendScore());
         //         //            info.setMemberGuid(member.guid());
         //         //         }
         //         int days = 0;
         //         TDateTime nowDate = new TDateTime(RDateTime.currentDateTime());
         //         System.out.println(info.recommendBeginDate() + "-" + info.recommendEndDate() + "," + info.recommendEndDate().isEmpty() + "------------------------");
         //         if(!info.recommendEndDate().isEmpty()){
         //            days = info.recommendEndDate().day() - nowDate.day();
         //            info.setRemainingDays((days <= 0) ? 0 : days);
         //         }
         //         if(days == 0){
         //            throw new FFatalError("this member is Contact period has been exceeded.(days={1})", days);
         //         }
         return infoList.first();
      }
      return null;
   }
}
