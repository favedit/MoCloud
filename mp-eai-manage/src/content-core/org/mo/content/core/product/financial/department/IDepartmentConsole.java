package org.mo.content.core.product.financial.department;

import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>部门信息控制台接口</P>
//@interface IDepartmentConsole
//@author AnjoyTian
//@Date 2015.09.21  
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

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataFinancialDepartmentUnit findByCode(ILogicContext logicContext,
                                           String code);
}
