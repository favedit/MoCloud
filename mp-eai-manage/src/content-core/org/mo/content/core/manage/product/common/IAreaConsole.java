package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>区域信息控制台接口</P>
//@interface IAreaConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public interface IAreaConsole
      extends
         IAbstractLogicUnitConsole<FDataCommonAreaUnit>
{
   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 每页显示的行数
   // @return 数据集合
   FLogicDataset<FDataAreaInfo> select(ILogicContext logicContext,
                                       FDataCommonAreaUnit unit,
                                       int pageNum,
                                       int pageSize);

   public FDataCommonAreaUnit findByLable(ILogicContext logicContext,
                                          String label);
}
