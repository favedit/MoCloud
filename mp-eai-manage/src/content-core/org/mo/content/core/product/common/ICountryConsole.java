package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>国家信息操作接口</P>
//
//@class ICountryConsole
//@author Sunhr
//@Date 2015.09.13
//@version 1.0.0
//============================================================

public interface ICountryConsole
      extends
         IAbstractLogicUnitConsole<FDataCommonCountryUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataCommonCountryUnit> select(ILogicContext logicContext,
                                                FDataCommonCountryUnit unit,
                                                int pageNum,
                                                int pageSize);

   FDataCommonCountryUnit findByCode(ILogicContext logicContext,
                                     String code);
}
