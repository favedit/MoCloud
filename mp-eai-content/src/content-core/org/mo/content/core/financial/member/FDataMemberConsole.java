package org.mo.content.core.financial.member;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
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
   // 每页条数
   static final int _pageSize = 12;

   @ALink
   protected ICityConsole _cityConsole;

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
      for(FDataFinancialMemberInfo unit : List){
         if(!unit.birthday().isEmpty()){
            unit.setAge(nowDate.year() - unit.birthday().year());
         }
         FDataCommonCityUnit city = _cityConsole.find(logicContext, unit.cityId());
         if(city != null){
            unit.setCityLabel(city.label());
         }
      }
      return List;
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
      FDataFinancialMarketerMemberLogic MMLogic = logicContext.findLogic(FDataFinancialMarketerMemberLogic.class);
      FDataFinancialMemberUnit member = findByGuid(logicContext, guid);
      FDataFinancialMarketerMemberUnit mmUnit = new FDataFinancialMarketerMemberUnit();
      //      mmUnit.set
      //      MMLogic.doInsert(logicUnit)

      return null;
   }
}
