package org.mo.content.core.product.financial.department;

import com.cyou.gccloud.data.data.FDataFinancialDepartmentLogic;
import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
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

public class FDepartmentConsole
      extends FAbstractLogicUnitConsole<FDataFinancialDepartmentLogic, FDataFinancialDepartmentUnit>
      implements
         IDepartmentConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FDepartmentConsole(){
      super(FDataFinancialDepartmentLogic.class, FDataFinancialDepartmentUnit.class);
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
   public FLogicDataset<FDataFinancialDepartmentUnit> select(ILogicContext logicContext,
                                                             FDataFinancialDepartmentUnit unit,
                                                             int pageNum,
                                                             int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.code())){
         whereSql.append(FDataFinancialDepartmentLogic.CODE);
         whereSql.append(" LIKE '%");
         whereSql.append(unit.code() + "%'");
      }
      String orderBy = String.format("%s %s %s %s", FDataFinancialDepartmentLogic.DEPARTMENT_LABEL + ",", FDataFinancialDepartmentLogic.REGION_LABEL + ",", FDataFinancialDepartmentLogic.LABEL, "ASC");
      FDataFinancialDepartmentLogic logic = logicContext.findLogic(FDataFinancialDepartmentLogic.class);
      FLogicDataset<FDataFinancialDepartmentUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum);
      return moduleList;
   }

   @Override
   public FDataFinancialDepartmentUnit findByCode(ILogicContext logicContext,
                                                  String code){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(code)){
         whereSql.append(FDataFinancialDepartmentLogic.CODE);
         whereSql.append("='");
         whereSql.append(code + "'");
      }
      FDataFinancialDepartmentLogic logic = logicContext.findLogic(FDataFinancialDepartmentLogic.class);
      FLogicDataset<FDataFinancialDepartmentUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }
}
