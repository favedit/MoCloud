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
   FLogicDataset<FDataSigningInfo> select(ILogicContext logicContext, FDataSigningInfo unit, int pageNum, int pageSize);

   // ============================================================
   // <T>依据条件获得分页数据列表</T>
   // @param sqlContext 链接对象
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataSigningInfo> selectByDate(ILogicContext logicContext, String beginDateStr, String endDateStr, int pageNum, int pageSize);
}
