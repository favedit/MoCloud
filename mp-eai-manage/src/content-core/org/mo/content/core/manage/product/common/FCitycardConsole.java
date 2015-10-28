package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaLogic;
import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import com.cyou.gccloud.data.data.FDataCommonCityCardLogic;
import com.cyou.gccloud.data.data.FDataCommonCityCardUnit;
import java.util.Iterator;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.ALink;
//============================================================
//<P>城市身份证关联控制台</P>
//@class FCitycardConsole
//@version 1.0.0
//============================================================
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>城市省份对照控制台</P>
//@class FCitycardConsole
//@version 1.0.0
//============================================================
public class FCitycardConsole
      extends FAbstractLogicUnitConsole<FDataCommonCityCardLogic, FDataCommonCityCardUnit>
      implements
         ICitycardConsole
{

   //城市控制台
   @ALink
   protected ICityConsole _cityConsole;

   //============================================================
   // <T>构造城市身份证关联控制台。</T>
   //============================================================
   public FCitycardConsole(){
      super(FDataCommonCityCardLogic.class, FDataCommonCityCardUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 每页显示的行数
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataCitycardInfo> select(ILogicContext logicContext,
                                                  FDataCommonCityCardUnit unit,
                                                  int pageNum,
                                                  int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.cardCode() + "")&&unit.cardCode()>0){
         whereSql.append(FDataCommonCityCardLogic.CARD_CODE);
         whereSql.append(" like ");
         whereSql.append(" '%{cardCode}%'");
         whereSql.bind("cardCode", RString.parse(unit.cardCode()));
      }
      FDataCommonCityCardLogic logic = logicContext.findLogic(FDataCommonCityCardLogic.class);
      FLogicDataset<FDataCitycardInfo> userInfoList = logic.fetchClass(FDataCitycardInfo.class, null, whereSql.toString(), null, pageSize, pageNum);
      for(Iterator<FDataCitycardInfo> iterator = userInfoList.iterator(); iterator.hasNext();){
         FDataCitycardInfo tempUnit = iterator.next();
         if(tempUnit.city()!=null&&!RString.isEmpty(tempUnit.city().label())){
            tempUnit.setCityLabel(tempUnit.city().label());
         }
      }
      return userInfoList;
   }

   // ============================================================
   // <T>根据身份证号和城市id，判断是否存在</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   @Override
   public boolean isExsitsByCardcodeandByCityId(ILogicContext logicContext,
                                                Long cityId,
                                                int cardCode){
      FSql whereSql = new FSql();
      if(cityId != null){
         whereSql.append(FDataCommonCityCardLogic.CITY_ID);
         whereSql.append(" = ");
         whereSql.append(" {cityId}");
         whereSql.bind("cityId", RString.parse(cityId));
      }

      if(cardCode != 0){
         if(cityId != null){
            whereSql.append(" AND ");
         }
         whereSql.append(FDataCommonCityCardLogic.CARD_CODE);
         whereSql.append(" = ");
         whereSql.append(" {cardCode}");
         whereSql.bind("cardCode", RString.parse(cardCode));
      }

      FDataCommonCityCardLogic logic = logicContext.findLogic(FDataCommonCityCardLogic.class);
      FLogicDataset<FDataCommonCityCardUnit> areaList = logic.fetch(whereSql.toString());
      if(areaList.count() > 0){
         return true;
      }
      return false;
   }

   // ============================================================
   // <T>根据身份证号和城市id，ouid判断是否存在</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   @Override
   public boolean isExsitsByCardcodeandByCityIdandOuid(ILogicContext logicContext,
                                                       Long cityId,
                                                       int cardCode,
                                                       Long ouid){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(cityId + "") && !RString.isEmpty(cardCode + "")){
         whereSql.append(FDataCommonCityCardLogic.CITY_ID);
         whereSql.append(" = ");
         whereSql.append(" {cityId}");
         whereSql.bind("cityId", RString.parse(cityId));
         whereSql.append(" and ");
         whereSql.append(FDataCommonCityCardLogic.CARD_CODE);
         whereSql.append(" = ");
         whereSql.append(" {cardCode}");
         whereSql.bind("cardCode", RString.parse(cardCode));
         FDataCommonCityCardLogic logic = logicContext.findLogic(FDataCommonCityCardLogic.class);
         FLogicDataset<FDataCommonCityCardUnit> areaList = logic.fetch(whereSql.toString());
         for(Iterator<FDataCommonCityCardUnit> it = areaList.iterator(); it.hasNext();){
            FDataCommonCityCardUnit unit = it.next();
            if(!RString.equals(ouid, unit.ouid())){
               return true;
            }
         }
      }
      return false;
   }

   // ============================================================
   // <T>根据标签获取对象列表</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataCommonAreaUnit> selectAll(ILogicContext logicContext,
                                                       Long countryId){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(countryId + "") && countryId > 0){
         whereSql.append(FDataCommonAreaLogic.COUNTRY_ID);
         whereSql.append(" = ");
         whereSql.append(" {countryId}");
         whereSql.bind("countryId", RString.parse(countryId));
         FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
         return logic.fetch(whereSql.toString());
      }
      FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
      return logic.fetchAll();
   }
}
