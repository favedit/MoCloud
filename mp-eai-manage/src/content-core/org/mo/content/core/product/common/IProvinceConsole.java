package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
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
   // <T>根据名称获取对象</T>
   //
   // @param logicContext 链接对象
   // @param label 名称
   // @return 数据对象
   // ============================================================
   FDataCommonProvinceUnit findByLabel(ILogicContext context,
                                       String label);
}
