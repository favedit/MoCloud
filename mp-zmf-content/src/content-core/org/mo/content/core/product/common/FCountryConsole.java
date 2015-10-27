package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonCountryLogic;
import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
//============================================================
//<P>国家信息操作接口</P>
//
//@class FCountryConsole
//@author Sunhr
//@Date 2015.09.13  
//@version 1.0.0
//============================================================
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>国家信息控制台</P>
//@class FCountryConsole
//@author AnjoyTian
//@Date 2015.09.21 
//@version 1.0.0
//============================================================

public class FCountryConsole
      extends FAbstractLogicUnitConsole<FDataCommonCountryLogic, FDataCommonCountryUnit>
      implements
         ICountryConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造国家控制台。</T>
   //============================================================
   public FCountryConsole(){
      super(FDataCommonCountryLogic.class, FDataCommonCountryUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @param pageSize 页面显示的行数
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataCommonCountryUnit> select(ILogicContext logicContext,
                                                       FDataCommonCountryUnit unit,
                                                       int pageNum,
                                                       int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.name())){
         whereSql.append(FDataCommonCountryLogic.NAME);
         whereSql.append(" LIKE '%");
         whereSql.append(unit.name() + "%'");
      }
      String orderBy = String.format("%s %s", FDataCommonCountryLogic.OUID, "ASC");
      FDataCommonCountryLogic logic = logicContext.findLogic(FDataCommonCountryLogic.class);
      FLogicDataset<FDataCommonCountryUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum);
      return moduleList;
   }

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataCommonCountryUnit findByCode(ILogicContext logicContext,
                                            String code){
      StringBuffer whereSql = new StringBuffer();
      if(!RString.isEmpty(code)){
         whereSql.append(FDataCommonCountryLogic.CODE).append("='").append(code + "'");
      }
      FDataCommonCountryLogic logic = logicContext.findLogic(FDataCommonCountryLogic.class);
      FLogicDataset<FDataCommonCountryUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }

}
