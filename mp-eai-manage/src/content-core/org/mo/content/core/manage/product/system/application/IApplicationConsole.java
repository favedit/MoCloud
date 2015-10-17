package org.mo.content.core.manage.product.system.application;

import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>应用控制台接口</P>
//@interface IApplicationConsole
//@version 1.0.0
//============================================================
public interface IApplicationConsole
      extends
         IAbstractLogicUnitConsole<FDataSystemApplicationUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataSystemApplicationUnit> select(ILogicContext logicContext,
                                                           FDataSystemApplicationUnit unit,
                                                           int pageNum,
                                                           int pageSize);

   // ============================================================
   // <T>根据标签获取对象</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   FDataSystemApplicationUnit findByLable(ILogicContext logicContext,
                                                 String label);

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param logicContext 链接对象
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataSystemApplicationUnit> selectAll(ILogicContext logicContext);
}
