package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>城市信息操作接口</P>
//
//@class ICityConsole
//@author Sunhr
//@Date 2015.09.13
//@version 1.0.0
//============================================================

public interface ICityConsole
      extends
         IAbstractLogicUnitConsole<FDataCommonCityUnit>
{
   // ============================================================
   // <T>根据区号获取对象</T>
   //
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataCommonCityUnit findByCitycode(ILogicContext context,
                                      String code);
}
