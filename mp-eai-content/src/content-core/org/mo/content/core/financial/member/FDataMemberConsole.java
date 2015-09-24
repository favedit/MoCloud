package org.mo.content.core.financial.member;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialMemberRelation;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
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
   protected final int _RecommendDay = 3;

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
                                                         int pageNum){
      if(0 > pageNum){
         pageNum = 0;
      }
      TDateTime nowDate = new TDateTime(RDateTime.currentDateTime());
      FDataFinancialMemberLogic logic = logicContext.findLogic(FDataFinancialMemberLogic.class);

      FLogicDataset<FDataFinancialMemberInfo> List = logic.fetchClass(FDataFinancialMemberInfo.class, null, _pageSize, pageNum);
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
         //检查是否被关注
         FDataFinancialMarketerMemberUnit marketerMember = _marketerMemberConsole.findByMemberId(logicContext, unit.ouid());
         if(marketerMember == null){
            resultList.push(unit);
         }
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
                         String guid){
      try{
         TDateTime nowTime = new TDateTime(RDateTime.currentDateTime());
         FDataFinancialMemberLogic mLogic = logicContext.findLogic(FDataFinancialMemberLogic.class);
         // 获取成员
         FDataFinancialMemberUnit member = mLogic.findByGuid(guid);
         if(member == null){
            _logger.debug(this, "Follow", "Follow this member is null.(memberId={1})", guid);
            return EResult.Failure;
         }

         // 根成员检查理财师是否关注
         FDataFinancialMarketerMemberUnit mmUnit = _marketerMemberConsole.findByMemberId(logicContext, member.ouid());
         if(mmUnit != null){
            _logger.debug(this, "Follow", "Follow this member followd.(memberId={1})", member.ouid());
            return EResult.Failure;
         }
         // 关联理财师和用户的关系
         FDataFinancialMarketerMemberUnit MMNewUnit = new FDataFinancialMarketerMemberUnit();
         //      mmUnit.setMarketerId(value);
         MMNewUnit.setMemberId(member.ouid());
         MMNewUnit.setRelationCd(EGcFinancialMemberRelation.Follow);
         MMNewUnit.setRecommendBeginDate(nowTime);
         TDateTime afterTime = new TDateTime(nowTime);
         afterTime.addDay(_RecommendDay);
         MMNewUnit.setRecommendEndDate(afterTime);
         EResult result = _marketerMemberConsole.doInsert(logicContext, MMNewUnit);
         if(result.equals(EResult.Failure)){
            _logger.debug(this, "follow", "follow Failure.(memberId={1})", MMNewUnit.ouid());
            return EResult.Failure;
         }
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
      FLogicDataset<FDataFinancialMemberUnit> list = fetch(logicContext, null);
      int pageTotal = list.count() / _pageSize;
      if(list.count() % _pageSize != 0){
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
                                                  String guid){
      FDataFinancialMemberLogic logic = logicContext.findLogic(FDataFinancialMemberLogic.class);
      FDataFinancialMemberInfo member = logic.findByGuid(FDataFinancialMemberInfo.class, guid);
      TDateTime nowDate = new TDateTime(RDateTime.currentDateTime());
      if(!member.birthday().isEmpty()){
         member.setAge(nowDate.year() - member.birthday().year());
      }
      if(!member.recommendEndDate().isEmpty()){
         int days = member.recommendEndDate().day() - nowDate.day();

         member.setRemainingDays((days <= 0) ? 0 : days);
      }
      return member;
   }
}
