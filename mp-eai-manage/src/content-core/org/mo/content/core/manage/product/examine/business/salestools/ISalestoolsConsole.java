package org.mo.content.core.manage.product.examine.business.salestools;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>销售工具控制台接口</P>
//@class INewsConsole
//@version 1.0.0
//============================================================
public interface ISalestoolsConsole 
      extends 
         IAbstractLogicUnitConsole<FDataLogicSalestoolsUnit> 
{

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataSalestoolsInfo> select(ILogicContext logicContext, 
                                             FDataLogicSalestoolsUnit unit, 
                                             int pageNum, 
                                             int pageSize);

}
