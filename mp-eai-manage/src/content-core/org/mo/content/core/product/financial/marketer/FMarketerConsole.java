package org.mo.content.core.product.financial.marketer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
//============================================================
//<P>部门信息操作接口</P>
//
//@class FDepartmentConsole
//@author Sunhr
//@Date 2015.09.11
//@version 1.0.0
//============================================================
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>理财师信息控制台</P>
//@class FMarketerConsole
//@author AnjoyTian
//@Date 2015.09.21 
//@version 1.0.0
//============================================================

public class FMarketerConsole
      extends FAbstractLogicUnitConsole<FDataFinancialMarketerLogic, FDataFinancialMarketerUnit>
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
}
