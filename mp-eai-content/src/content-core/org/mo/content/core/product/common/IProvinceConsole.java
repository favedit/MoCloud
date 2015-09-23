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
//============================================================
//<P省会信息控制台接口</P>
//@interface IProvinceConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

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

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataCommonProvinceUnit findByCode(ILogicContext logicContext,
                                      String code);

   FDataCommonProvinceUnit findByLabel(FLogicContext logicContext,
                                       String provinceLabel);

}
