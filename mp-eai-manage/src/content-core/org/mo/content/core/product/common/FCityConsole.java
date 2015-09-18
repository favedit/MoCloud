package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonCityLogic;
import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
//============================================================
//<P>区域信息操作接口</P>
//
//@class FCityConsole
//@author Sunhr
//@Date 2015.09.13  
//@version 1.0.0
//============================================================
import org.mo.data.logic.ILogicContext;

public class FCityConsole
      extends FAbstractLogicUnitConsole<FDataCommonCityLogic, FDataCommonCityUnit>
      implements
         ICityConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FCityConsole(){
      super(FDataCommonCityLogic.class, FDataCommonCityUnit.class);
   }

   // ============================================================
   // <T>根据区号获取对象</T>
   //
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataCommonCityUnit findByCitycode(ILogicContext context,
                                             String code){
      FSql where = new FSql();
      if(code != null){
         where.append(FDataCommonCityLogic.CITY_CODE);
         where.append(" = '");
         where.append(code);
         where.append("'");
      }
      FDataCommonCityLogic logic = context.findLogic(FDataCommonCityLogic.class);
      FDataCommonCityUnit city = logic.search(where);
      return city;
   }

   @Override
   public FLogicDataset<FDataCityInfo> select(ILogicContext logicContext,
                                              FDataCommonCityUnit unit,
                                              int pageNum,
                                              int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql where = new FSql();
      if(!RString.isEmpty(unit.label())){
         where.append(FDataCommonCityLogic.LABEL);
         where.append(" LIKE '%");
         where.append(unit.label() + "%'");
      }
      String orderBy = String.format("%s %s", FDataCommonCityLogic.LABEL, "ASC");
      FDataCommonCityLogic logic = logicContext.findLogic(FDataCommonCityLogic.class);
      FLogicDataset<FDataCityInfo> userInfoList = logic.fetchClass(FDataCityInfo.class, null, where.toString(), null, pageSize, pageNum);
      return userInfoList;
   }
}
