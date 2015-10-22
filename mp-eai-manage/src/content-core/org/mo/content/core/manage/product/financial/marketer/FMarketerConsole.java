package org.mo.content.core.manage.product.financial.marketer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>理财师信息控制台</P>
//@class FMarketerConsole
//@version 1.0.0
//============================================================
public class FMarketerConsole
      extends 
         FAbstractLogicUnitConsole<FDataFinancialMarketerLogic, FDataFinancialMarketerUnit>
      implements
         IMarketerConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造理财师控制台。</T>
   //============================================================

   public FMarketerConsole(){
      super(FDataFinancialMarketerLogic.class, FDataFinancialMarketerUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialMarketerUnit> select(ILogicContext logicContext,
                                                           FDataFinancialMarketerUnit unit,
                                                           int pageNum,
                                                           int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.name())){
         whereSql.append(FDataFinancialMarketerLogic.NAME);
         whereSql.append(" LIKE '%");
         whereSql.append(unit.name() + "%'");
      }
      String orderBy = String.format("%s %s", FDataFinancialMarketerLogic.NAME, "ASC");
      FDataFinancialMarketerLogic logic = logicContext.findLogic(FDataFinancialMarketerLogic.class);
      FLogicDataset<FDataFinancialMarketerUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum);
      return moduleList;
   }

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialMarketerUnit findByCode(ILogicContext logicContext,
                                                String code){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(code)){
         whereSql.append(FDataFinancialMarketerLogic.NAME);
         whereSql.append("='");
         whereSql.append(code + "'");
      }
      FDataFinancialMarketerLogic logic = logicContext.findLogic(FDataFinancialMarketerLogic.class);
      FLogicDataset<FDataFinancialMarketerUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }
   
   // ============================================================
   // <T>根据搜索条件时间段查询分页数据</T>
   // @param logicContext 链接对象
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialMarketerUnit> selectByMessage(ILogicContext logicContext, 
                                                                    String beginDateStr, 
                                                                    String endDateStr,
                                                                    String name,
                                                                    int pageNum, 
                                                                    int pageSize) {
      if (0 > pageNum) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(" 1=1 ");
      if (!RString.isEmpty(beginDateStr)) {
         whereSql.append(" and ");
         whereSql.append(FDataFinancialMarketerLogic.CREATE_DATE + " >= '{beginDateStr}'");
         whereSql.bind("beginDateStr", RString.parse(beginDateStr));
      }
      if (!RString.isEmpty(endDateStr)) {
         whereSql.append(" and ");
         whereSql.append(FDataFinancialMarketerLogic.CREATE_DATE + " <= '{endDateStr}'");
         whereSql.bind("endDateStr", RString.parse(endDateStr));
      }
      if (!RString.isEmpty(name)) {
         whereSql.append(" and ");
         whereSql.append(FDataFinancialMarketerLogic.NAME + " LIKE '%{name}%'");
         whereSql.bind("name", RString.parse(name));
      }
      String orderBy = String.format("%s %s", FDataFinancialMarketerLogic.CREATE_DATE, "DESC");
      FDataFinancialMarketerLogic logic = new FDataFinancialMarketerLogic(logicContext);
      FLogicDataset<FDataFinancialMarketerUnit> unitlist = logic.fetchClass(FDataFinancialMarketerUnit.class, whereSql.toString(), orderBy, pageSize, pageNum);
      return unitlist;
   }
}
