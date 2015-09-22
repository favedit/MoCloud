package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P城市信息控制台接口</P>
//@interface ICityConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public interface ICityConsole
      extends
         IAbstractLogicUnitConsole<FDataCommonCityUnit>
{
   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataCommonCityUnit findByCitycode(ILogicContext context,
                                      String code);

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 每页显示的行数
   // @return 数据集合
   FLogicDataset<FDataCityInfo> select(ILogicContext logicContext,
                                       FDataCommonCityUnit unit,
                                       int pageNum,
                                       int pageSize);
}
