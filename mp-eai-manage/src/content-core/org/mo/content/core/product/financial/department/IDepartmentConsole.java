package org.mo.content.core.product.financial.department;

import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>部门信息操作接口</P>
//
//@class IDepartmentConsole
//@author Sunhr
//@Date 2015.09.11 
//@version 1.0.0
//============================================================

public interface IDepartmentConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialDepartmentUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataFinancialDepartmentUnit> select(ILogicContext logicContext,
                                                      FDataFinancialDepartmentUnit unit,
                                                      int pageNum,
                                                      int pageSize);

   FDataFinancialDepartmentUnit findByCode(ILogicContext logicContext,
                                           String code);
}
