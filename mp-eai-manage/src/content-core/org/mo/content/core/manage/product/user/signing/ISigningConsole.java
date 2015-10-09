package org.mo.content.core.manage.product.user.signing;

import com.cyou.gccloud.data.data.FDataPersonUserSigningUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

public interface ISigningConsole extends IAbstractLogicUnitConsole<FDataPersonUserSigningUnit> {

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataPersonUserSigningUnit> select(ILogicContext logicContext, FDataPersonUserSigningUnit unit, int pageNum, int pageSize);
}
