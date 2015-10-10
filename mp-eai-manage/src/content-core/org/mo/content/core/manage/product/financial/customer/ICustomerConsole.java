package org.mo.content.core.manage.product.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>客户信息控制台接口</P>
//@interface ICustomerConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public interface ICustomerConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialCustomerUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataFinancialCustomerUnit> select(ILogicContext logicContext,
                                                    FDataFinancialCustomerUnit unit,
                                                    int pageNum,
                                                    int pageSize);

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataFinancialCustomerUnit findByCode(ILogicContext logicContext,
                                         String code);
}