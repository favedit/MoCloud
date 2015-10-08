package org.mo.content.core.manage.product.common.configration;

import com.cyou.gccloud.data.data.FDataCommonConfigurationUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>配置信息操作接口</P>
//
//@class IConfigrationConsole
//@author Sunhr
//@Date 2015.09.09  
//@version 1.0.0
//============================================================

public interface IConfigrationConsole
      extends
         IAbstractLogicUnitConsole<FDataCommonConfigurationUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataCommonConfigurationUnit> select(ILogicContext logicContext,
                                                      FDataCommonConfigurationUnit unit,
                                                      int pageNum,
                                                      int pageSize);

   FDataCommonConfigurationUnit findByCode(ILogicContext logicContext,
                                           String code);
}
