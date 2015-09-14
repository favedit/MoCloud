package org.mo.content.core.product.financial.marketer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
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

public interface IMarketerConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialMarketerUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataFinancialMarketerUnit> select(ILogicContext logicContext,
                                                    FDataFinancialMarketerUnit unit,
                                                    int pageNum,
                                                    int pageSize);

   FDataFinancialMarketerUnit findByCode(ILogicContext logicContext,
                                         String code);
}
