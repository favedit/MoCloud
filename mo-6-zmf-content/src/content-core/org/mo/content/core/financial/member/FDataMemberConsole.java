package org.mo.content.core.financial.member;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import com.cyou.gccloud.define.enums.core.EGcPersonBusiness;
import com.cyou.gccloud.define.enums.core.EGcPersonEducation;
import com.cyou.gccloud.define.enums.core.EGcPersonGender;
import com.cyou.gccloud.define.enums.core.EGcPersonIncome;
import com.cyou.gccloud.define.enums.financial.EGcFinancialMemberRelation;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.financial.marketer.member.IDataMarketerMemberConsole;
import org.mo.content.core.product.common.ICityConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融成员控制台。</T>
//============================================================
public class FDataMemberConsole
      extends FAbstractLogicUnitConsole<FDataFinancialMemberLogic, FDataFinancialMemberUnit>
      implements
         IDataMemberConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FDataMemberConsole.class);

   // 每页条数
   static final int _pageSize = 12;

   //推荐天数
   protected final int _RecommendDay = 4;

   @ALink
   protected ICityConsole _cityConsole;

   @ALink
   protected IDataMarketerMemberConsole _marketerMemberConsole;

   //============================================================
   // <T>构造控制台。</T>
   //============================================================
   public FDataMemberConsole(){
      super(FDataFinancialMemberLogic.class, FDataFinancialMemberUnit.class);
   }

   // ============================================================
   // <T>获得分页数据</T>
   //
   // @param logicContext 链接对象
   // @page  pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialMemberInfo> select(ILogicContext logicContext,
                                                         long marketerId,
                                                         int pageNum){
      if(0 > pageNum){
         pageNum = 0;
      }
      TDateTime nowDate = new TDateTime(RDateTime.currentDateTime());
      FDataFinancialMemberLogic logic = logicContext.findLogic(FDataFinancialMemberLogic.class);
      StringBuffer order = new StringBuffer();
      order.append(FDataFinancialMemberLogic.RECOMMEND_SCORE + " DESC,");
      order.append(FDataFinancialMemberLogic.LAST_LOGIN_DATE + " DESC");

      FLogicDataset<FDataFinancialMemberInfo> List = logic.fetchClass(FDataFinancialMemberInfo.class, null, order, _pageSize, pageNum);
      FLogicDataset<FDataFinancialMemberInfo> resultList = new FLogicDataset<>(FDataFinancialMemberInfo.class);
      for(FDataFinancialMemberInfo unit : List){
         //获取年龄
         if(!unit.birthday().isEmpty()){
            unit.setAge(nowDate.year() - unit.birthday().year());
         }
         //获取城市
         FDataCommonCityUnit city = _cityConsole.find(logicContext, unit.cityId());
         if(city != null){
            unit.setCityLabel(city.label());
         }
         // 检查此成员是否被其它人关注 加字段
         FDataFinancialMarketerMemberUnit marketerMember = _marketerMemberConsole.findFollowed(logicContext, unit.ouid());
         if(marketerMember != null){
            continue;
         }
         // 检查此理财师是否关注过此成员 字典
         marketerMember = _marketerMemberConsole.findByMarketerAndMember(logicContext, marketerId, unit.ouid());
         if(marketerMember != null){
            continue;
         }
         resultList.push(unit);
      }
      return resultList;
   }

   // ============================================================
   // <T>用户关注</T>
   //
   // @param logicContext 链接对象
   // @param  guid 用户唯一码
   // @return 数据集合
   // ============================================================
   @Override
   public EResult follow(ILogicContext logicContext,
                         long marketerId,
                         String guid){
      try{
         if(marketerId == 0 || guid.isEmpty()){
            throw new FFatalError("follow,marketerId and guid can not be null");
         }
         TDateTime nowTime = new TDateTime(RDateTime.currentDateTime());
         FDataFinancialMemberLogic mLogic = logicContext.findLogic(FDataFinancialMemberLogic.class);
         // 获取成员
         FDataFinancialMemberUnit member = mLogic.findByGuid(guid);
         if(member == null){
            _logger.debug(this, "Follow", "Follow this member is null.(memberId={1})", guid);
            return EResult.Failure;
         }
         // 检查此成员是否被其它理财师关注过
         FDataFinancialMarketerMemberUnit followed = _marketerMemberConsole.findFollowed(logicContext, member.ouid());
         if(followed != null){
            _logger.debug(this, "Follow", "Follow this member is followed by other Marketer.(memberId={1})", member.ouid());
            return EResult.Failure;
         }

         // 检查此理财师是否关注过此成员
         FDataFinancialMarketerMemberUnit mmUnit = _marketerMemberConsole.findByMarketerAndMember(logicContext, marketerId, member.ouid());
         if(mmUnit == null){//没有关注过此成员
            // 关联理财师和用户的关系
            FDataFinancialMarketerMemberUnit MMNewUnit = new FDataFinancialMarketerMemberUnit();
            MMNewUnit.setMarketerId(marketerId);
            MMNewUnit.setMemberId(member.ouid());
            MMNewUnit.setRelationCd(EGcFinancialMemberRelation.Follow);
            MMNewUnit.setRecommendBeginDate(nowTime);
            TDateTime afterTime = new TDateTime(nowTime);
            afterTime.addDay(_RecommendDay);
            MMNewUnit.setRecommendEndDate(afterTime);
            EResult result = _marketerMemberConsole.doInsert(logicContext, MMNewUnit);
            if(result.equals(EResult.Failure)){
               _logger.debug(this, "follow", "follow insert Failure.(memberId={1})", MMNewUnit.ouid());
               return EResult.Failure;
            }
         }else{
            mmUnit.setRelationCd(EGcFinancialMemberRelation.Follow);
            EResult result = _marketerMemberConsole.doUpdate(logicContext, mmUnit);
            if(result.equals(EResult.Failure)){
               _logger.debug(this, "follow", "follow update Failure.(memberId={1})", mmUnit.ouid());
               return EResult.Failure;
            }
         }
         //修改成员中被推荐的时间
         return EResult.Success;
      }catch(Exception e){
         e.printStackTrace();
         return EResult.Failure;
      }
   }

   // ============================================================
   // <T>获取总页数</T>
   //
   // @param logicContext 链接对象
   // @return 总页数
   // ============================================================
   @Override
   public int getPageCount(ILogicContext logicContext){
      _logger.debug(this, "GetPageCount", "GetPageCount begin.");
      FDataFinancialMemberLogic logic = logicContext.findLogic(FDataFinancialMemberLogic.class);
      FSql sql = new FSql();
      sql.append("SELECT COUNT(ouid) FROM DT_FIN_MEMBER");
      ISqlConnection conn = logic.connection();
      int count = conn.executeInteger(sql);
      _logger.debug(this, "GetPageCount", "GetPageCount result.(count={1})", count);
      int pageTotal = count / _pageSize;
      if(count % _pageSize != 0){
         pageTotal += 1;
      }
      return pageTotal;
   }

   // ============================================================
   // <T>获取对象</T>
   //
   // @param logicContext 链接对象
   // @param  guid 用户唯一码
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialMemberInfo findInfoByGuid(ILogicContext logicContext,
                                                  long marketerId,
                                                  String guid){
      FDataFinancialMemberLogic logic = logicContext.findLogic(FDataFinancialMemberLogic.class);
      FDataFinancialMemberInfo member = logic.findByGuid(FDataFinancialMemberInfo.class, guid);
      TDateTime nowDate = new TDateTime(RDateTime.currentDateTime());
      member.setGenderLabel(EGcPersonGender.formatLabel(member.genderCd()));
      member.setEducationLabel(EGcPersonEducation.formatLabel(member.educationCd()));
      member.setIncomeLabel(EGcPersonIncome.formatLabel(member.incomeCd()));
      member.setBusinessLabel(EGcPersonBusiness.formatLabel(member.businessCd()));
      //年龄
      if(!member.birthday().isEmpty()){
         member.setAge(nowDate.year() - member.birthday().year());
      }
      //获取城市
      FDataCommonCityUnit city = _cityConsole.find(logicContext, member.cityId());
      if(city != null){
         member.setCityLabel(city.label());
      }
      //联络周期
      FDataFinancialMarketerMemberUnit marketer = _marketerMemberConsole.findFollowedByMarketerAndMember(logicContext, marketerId, member.ouid());
      if(marketer != null && !marketer.recommendEndDate().isEmpty()){
         int days = marketer.recommendEndDate().sub(nowDate).days();
         member.setRemainingDays((days <= 0) ? 0 : days);
      }
      return member;
   }
}
