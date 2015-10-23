package org.mo.content.core.manage.product.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialProductLogic;
import com.cyou.gccloud.data.data.FDataFinancialProductUnit;
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
//<P>产品信息控制台</P>
//@class FProductConsole
//@author AnjoyTian
//@Date 2015.09.21 
//@version 1.0.0
//============================================================

public class FProductConsole
      extends FAbstractLogicUnitConsole<FDataFinancialProductLogic, FDataFinancialProductUnit>
      implements
         IProductConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造产品控制台。</T>
   //============================================================

   public FProductConsole(){
      super(FDataFinancialProductLogic.class, FDataFinancialProductUnit.class);
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
   public FLogicDataset<FDataFinancialProductUnit> select(ILogicContext logicContext,
                                                          FDataFinancialProductUnit unit,
                                                          int pageNum,
                                                          int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.name())){
         whereSql.append(FDataFinancialProductLogic.NAME + " LIKE '%{name}%'");
         whereSql.bind("name", RString.parse(unit.name()));
      }
      String orderBy = String.format("%s %s", FDataFinancialProductLogic.NAME, "ASC");
      FDataFinancialProductLogic logic = logicContext.findLogic(FDataFinancialProductLogic.class);
      FLogicDataset<FDataFinancialProductUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum);
      return moduleList;
   }

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialProductUnit findByCode(ILogicContext logicContext,
                                               String code){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(code)){
         whereSql.append(FDataFinancialProductLogic.NAME);
         whereSql.append("='");
         whereSql.append(code + "'");
      }
      FDataFinancialProductLogic logic = logicContext.findLogic(FDataFinancialProductLogic.class);
      FLogicDataset<FDataFinancialProductUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }
}
