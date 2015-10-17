package org.mo.content.core.manage.product.examine.business.truetime;

import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>实时数据控制台接口</P>
//@class ITruetimeConsole
//@version 1.0.0
//============================================================
public interface ITruetimeConsole 
      extends 
         IAbstractLogicUnitConsole<FDataLogicTruetimeUnit> 
{

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param sqlContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataTruetimeInfo> select(ILogicContext logicContext, 
                                           FDataLogicTruetimeUnit unit, 
                                           int pageNum, 
                                           int pageSize);
}
