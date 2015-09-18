package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
//============================================================
//<P>省份信息操作接口</P>
//
//@class IProvinceConsole
//@author Sunhr
//@Date 2015.09.13
//@version 1.0.0
//============================================================
import org.mo.data.logic.ILogicContext;

public interface IProvinceConsole
      extends
         IAbstractLogicUnitConsole<FDataCommonProvinceUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataProvinceInfo> select(ILogicContext logicContext,
                                           FDataCommonProvinceUnit unit,
                                           int pageNum,
                                           int pageSize);

   FDataCommonProvinceUnit findByCode(ILogicContext logicContext,
                                      String code);

   FDataCommonProvinceUnit findByLabel(FLogicContext logicContext,
                                       String provinceLabel);
}
