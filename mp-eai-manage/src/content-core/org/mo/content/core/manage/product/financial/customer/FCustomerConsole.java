package org.mo.content.core.manage.product.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
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
//<P>客户信息控制台</P>
//@class FCustomerConsole
//@author AnjoyTian
//@Date 2015.09.21 
//@version 1.0.0
//============================================================

public class FCustomerConsole
      extends FAbstractLogicUnitConsole<FDataFinancialCustomerLogic, FDataFinancialCustomerUnit>
      implements
         ICustomerConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造客户控制台。</T>
   //============================================================

   public FCustomerConsole(){
      super(FDataFinancialCustomerLogic.class, FDataFinancialCustomerUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialCustomerUnit> select(ILogicContext logicContext,
                                                           FDataFinancialCustomerUnit unit,
                                                           int pageNum,
                                                           int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      /*if(unit.incomeCd() != 0){
         whereSql.append(FDataFinancialCustomerLogic.INCOME_CD);
         whereSql.append(" LIKE '%");
         whereSql.append(unit.incomeCd() + "%'");
      }*/
      String orderBy = String.format("%s %s", FDataFinancialCustomerLogic.INCOME_CD.toString(), "ASC");
      FDataFinancialCustomerLogic logic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FLogicDataset<FDataFinancialCustomerUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum);
      return moduleList;
   }

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialCustomerUnit findByCode(ILogicContext logicContext,
                                                String code){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(code)){
         whereSql.append(FDataFinancialCustomerLogic.INCOME_CD);
         whereSql.append("='");
         whereSql.append(code + "'");
      }
      FDataFinancialCustomerLogic logic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FLogicDataset<FDataFinancialCustomerUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }
}
